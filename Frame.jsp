<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="Conec.Serv" %>
<%@page import="java.util.*"%>




<%
    // 🔐 Session validation
    String user = (String) session.getAttribute("User");


    String userName = "";
    int totalCompletedCourses = 0;
    int totalCertificates = 0;

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        conn = Serv.get();

        /* ===== Fetch User Name ===== */
        pstmt = conn.prepareStatement(
            "SELECT name, filepath FROM UserData WHERE email = ?");
        pstmt.setString(1, user);
        rs = pstmt.executeQuery();

        if (rs.next()) {
            userName = rs.getString("name");
            session.setAttribute("filepath", rs.getString("filepath"));
        }
        session.setAttribute("userName", userName);

        rs.close();
        pstmt.close();

        /* ===== Fetch Completed Courses ===== */
        Set<Integer> completedCourses = new HashSet<>();

        pstmt = conn.prepareStatement(
            "SELECT course_id FROM coursecheck WHERE email = ? AND Mark>=30");
        pstmt.setString(1, user);
        rs = pstmt.executeQuery();

        while (rs.next()) {
            completedCourses.add(rs.getInt("course_id"));
        }

        totalCompletedCourses = completedCourses.size();
        session.setAttribute("TotalCompletedCourses", totalCompletedCourses);

        rs.close();
        pstmt.close();

        /* ===== Fetch Certificates ===== */
        Set<Integer> certificates = new HashSet<>();

        pstmt = conn.prepareStatement(
            "SELECT course_id FROM coursecheck WHERE email = ? AND dateuser IS NOT NULL");

        pstmt.setString(1, user);
        rs = pstmt.executeQuery();

        while (rs.next()) {
            certificates.add(rs.getInt("course_id"));
        }

        totalCertificates = certificates.size();
        session.setAttribute("TotalCertificates", totalCertificates);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try { if (rs != null) rs.close(); } catch (Exception e) {}
        try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
        try { if (conn != null) conn.close(); } catch (Exception e) {}
    }
%>

<!DOCTYPE html>
<html lang="en">
<head><link rel="stylesheet" type="text/css" href="Chat.css"><link rel="stylesheet" href="U.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile & Courses</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #1e3c72 0%, #2a5298 50%, #7e22ce 100%);
            min-height: 100vh;
        }

        /* Header */
        .header {
            background: linear-gradient(135deg, #667eea, #764ba2);
            padding: 0;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.4);
            position: sticky;
            top: 0;
            z-index: 1000;
        }

        .header-top {
            padding: 25px 50px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            border-bottom: 2px solid rgba(255, 255, 255, 0.2);
        }

        .header-logo {
            display: flex;
            align-items: center;
            gap: 15px;
        }

        .header-logo h1 {
            font-size: 32px;
            font-weight: 700;
            color: white;
            text-shadow: 2px 2px 8px rgba(0, 0, 0, 0.3);
        }

        .header-buttons {
            display: flex;
            gap: 15px;
        }

        .header-btn {
            padding: 12px 28px;
            background: rgba(255, 255, 255, 0.2);
            border: 2px solid white;
            border-radius: 50px;
            color: white;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s ease;
            backdrop-filter: blur(10px);
            display: flex;
            align-items: center;
            gap: 10px;
            font-size: 14px;
        }

        .header-btn:hover {
            background: white;
            color: #764ba2;
            transform: translateY(-2px);
            box-shadow: 0 6px 20px rgba(255, 255, 255, 0.3);
        }

        .header-btn.active {
            background: white;
            color: #764ba2;
        }

        .header-btn i {
            font-size: 16px;
        }

        /* Header Navigation */
        .header-nav {
            display: flex;
            justify-content: center;
            gap: 0;
            background: rgba(255, 255, 255, 0.1);
        }

        .nav-item {
            flex: 1;
            text-align: center;
            padding: 20px 30px;
            text-decoration: none;
            color: white;
            font-size: 16px;
            font-weight: 600;
            transition: all 0.3s ease;
            border-right: 1px solid rgba(255, 255, 255, 0.2);
            position: relative;
            overflow: hidden;
        }

        .nav-item:last-child {
            border-right: none;
        }

        .nav-item:before {
            content: '';
            position: absolute;
            bottom: 0;
            left: 0;
            width: 100%;
            height: 4px;
            background: linear-gradient(90deg, #ffd700, #ff6b6b);
            transform: translateX(-100%);
            transition: transform 0.3s ease;
        }

        .nav-item:hover {
            background: rgba(255, 255, 255, 0.2);
        }

        .nav-item:hover:before {
            transform: translateX(0);
        }

        .nav-item i {
            margin-right: 8px;
            font-size: 18px;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 40px 20px;
        }

        /* Profile Section */
        .profile-section {
            background: rgba(255, 255, 255, 0.98);
            border-radius: 30px;
            padding: 50px;
            margin-bottom: 50px;
            box-shadow: 0 25px 70px rgba(0, 0, 0, 0.4);
            transition: all 0.5s ease;
            max-height: 2000px;
            overflow: hidden;
            opacity: 1;
        }

        .profile-section.hidden {
            max-height: 0;
            padding: 0;
            margin-bottom: 0;
            opacity: 0;
        }

        .profile-header {
            text-align: center;
            margin-bottom: 40px;
        }

        .profile-title {
            font-size: 38px;
            font-weight: 700;
            background: linear-gradient(135deg, #667eea, #764ba2);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            background-clip: text;
            margin-bottom: 10px;
        }

        .profile-subtitle {
            font-size: 16px;
            color: #718096;
        }

        .profile-content {
            display: grid;
            grid-template-columns: 300px 1fr;
            gap: 50px;
            align-items: start;
        }

        /* Photo Section */
        .photo-section {
            text-align: center;
        }

        .photo-wrapper {
            position: relative;
            width: 200px;
            height: 200px;
            margin: 0 auto 25px;
        }

        .photo-container {
            width: 100%;
            height: 100%;
            border-radius: 50%;
            border: 6px solid #667eea;
            overflow: hidden;
            box-shadow: 0 15px 40px rgba(102, 126, 234, 0.4);
            background: white;
            transition: transform 0.3s ease;
        }

        .photo-container:hover {
            transform: scale(1.08);
        }

        .profile-photo {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }

        .camera-btn {
            position: absolute;
            bottom: 10px;
            right: 10px;
            width: 50px;
            height: 50px;
            background: linear-gradient(135deg, #667eea, #764ba2);
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            cursor: pointer;
            box-shadow: 0 6px 20px rgba(0, 0, 0, 0.3);
            transition: all 0.3s ease;
            border: 4px solid white;
        }

        .camera-btn:hover {
            transform: scale(1.15) rotate(15deg);
        }

        .camera-btn i {
            color: white;
            font-size: 20px;
        }

        #fileInput {
            display: none;
        }

        .user-name {
            font-size: 28px;
            font-weight: 700;
            color: #2d3748;
            margin-bottom: 8px;
        }

        .user-role {
            color: #718096;
            font-size: 15px;
            font-weight: 500;
        }

        /* Info Grid */
        .info-grid {
            display: grid;
            gap: 25px;
        }

        .info-card {
            background: linear-gradient(135deg, #f7fafc, #edf2f7);
            padding: 25px;
            border-radius: 20px;
            border: 2px solid #e2e8f0;
            transition: all 0.3s ease;
        }

        .info-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 12px 30px rgba(102, 126, 234, 0.2);
            border-color: #667eea;
        }

        .info-card-header {
            display: flex;
            align-items: center;
            gap: 15px;
            margin-bottom: 15px;
        }

        .info-icon {
            width: 50px;
            height: 50px;
            background: linear-gradient(135deg, #667eea, #764ba2);
            border-radius: 14px;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .info-icon i {
            color: white;
            font-size: 22px;
        }

        .info-label {
            font-size: 13px;
            color: #718096;
            font-weight: 600;
            text-transform: uppercase;
            letter-spacing: 0.5px;
        }

        .info-value {
            font-size: 22px;
            font-weight: 700;
            color: #2d3748;
            padding-left: 65px;
        }

        /* Stats Bar */
        .stats-bar {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 20px;
            margin-top: 30px;
            padding-top: 30px;
            border-top: 3px solid #e2e8f0;
        }

        .stat-box {
            text-align: center;
            padding: 20px;
            background: linear-gradient(135deg, #667eea, #764ba2);
            border-radius: 16px;
            box-shadow: 0 8px 20px rgba(102, 126, 234, 0.3);
        }

        .stat-number {
            font-size: 36px;
            font-weight: 700;
            color: white;
            display: block;
            margin-bottom: 8px;
        }

        .stat-label {
            font-size: 14px;
            color: rgba(255, 255, 255, 0.95);
            font-weight: 600;
        }

        /* Courses Section */
        .courses-section {
            animation: fadeInUp 1s ease;
        }

        .section-header {
            text-align: center;
            margin-bottom: 50px;
        }

        .section-title {
            font-size: 42px;
            font-weight: 700;
            color: white;
            margin-bottom: 15px;
            text-shadow: 3px 3px 10px rgba(0, 0, 0, 0.3);
        }

        .section-subtitle {
            font-size: 18px;
            color: rgba(255, 255, 255, 0.9);
        }

        /* Filter Buttons */
        .filter-section {
            display: flex;
            justify-content: center;
            gap: 20px;
            margin-bottom: 50px;
            flex-wrap: wrap;
        }

        .filter-btn {
            padding: 15px 35px;
            background: rgba(255, 255, 255, 0.15);
            backdrop-filter: blur(10px);
            border: 2px solid rgba(255, 255, 255, 0.3);
            border-radius: 50px;
            color: white;
            font-size: 16px;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s ease;
            display: flex;
            align-items: center;
            gap: 10px;
        }

        .filter-btn:hover {
            background: white;
            color: #667eea;
            transform: translateY(-3px);
            box-shadow: 0 10px 30px rgba(255, 255, 255, 0.3);
        }

        .filter-btn.active {
            background: linear-gradient(135deg, #667eea, #764ba2);
            border-color: white;
            box-shadow: 0 8px 25px rgba(102, 126, 234, 0.5);
        }

        /* Category Section */
        .category-wrapper {
            margin-bottom: 50px;
            transition: all 0.5s ease;
        }

        .category-wrapper.hidden {
            display: none;
        }

        .category-header {
            display: flex;
            align-items: center;
            gap: 20px;
            margin-bottom: 30px;
            padding: 25px 35px;
            background: rgba(255, 255, 255, 0.15);
            backdrop-filter: blur(10px);
            border-radius: 20px;
            border: 2px solid rgba(255, 255, 255, 0.3);
        }

        .category-icon {
            width: 70px;
            height: 70px;
            background: linear-gradient(135deg, #10b981, #059669);
            border-radius: 18px;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 32px;
            color: white;
            box-shadow: 0 10px 25px rgba(16, 185, 129, 0.5);
        }
/* Notification Button */
.notification-btn {
    position: relative;
}

/* Badge */
.notif-badge {
    position: absolute;
    top: -6px;
    right: -8px;
    background: red;
    color: white;
    font-size: 12px;
    padding: 3px 7px;
    border-radius: 50%;
    font-weight: bold;
}

/* Dropdown */
.notification-dropdown {
    position: absolute;
    top: 60px;
    right: 20px;
    width: 320px;
    background: white;
    border-radius: 12px;
    box-shadow: 0 15px 35px rgba(0,0,0,0.3);
    display: none;
    z-index: 2000;
    padding: 15px;
}

.notification-dropdown h4 {
    margin: 0 0 10px;
    color: #333;
    text-align: center;
}

/* Items */
.notif-item {
    background: #f5f5f5;
    padding: 12px;
    border-radius: 10px;
    margin-bottom: 10px;
    font-size: 14px;
}

.notif-item.success {
    background: #e8f5e9;
    border-left: 4px solid #4CAF50;
}

.notif-item.certificate {
    background: #fff3e0;
    border-left: 4px solid orange;
}

.logout-btn {
    background: linear-gradient(135deg, #dc2626, #b91c1c);
    border: 2px solid rgba(255, 255, 255, 0.3);
}

.logout-btn:hover {
    background: linear-gradient(135deg, #b91c1c, #991b1b);
    box-shadow: 0 0 20px rgba(220, 38, 38, 0.5);
}
.notif-item a {
    color: #ff9800;
    text-decoration: none;
    font-weight: bold;
}

        .category-icon.premium {
            background: linear-gradient(135deg, #f59e0b, #d97706);
            box-shadow: 0 10px 25px rgba(245, 158, 11, 0.5);
        }

        .category-info h3 {
            font-size: 32px;
            font-weight: 700;
            color: white;
            margin-bottom: 5px;
        }

        .category-info p {
            font-size: 15px;
            color: rgba(255, 255, 255, 0.85);
        }

        /* Course Grid */
        .course-grid {
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            gap: 35px;
        }

        .course-card {
            background: rgba(255, 255, 255, 0.98);
            border-radius: 24px;
            overflow: hidden;
            box-shadow: 0 20px 50px rgba(0, 0, 0, 0.4);
            transition: all 0.4s cubic-bezier(0.175, 0.885, 0.32, 1.275);
            text-decoration: none;
            color: #2d3748;
            border: 3px solid transparent;
            position: relative;
        }

        .course-card:hover {
            transform: translateY(-15px) scale(1.02);
            box-shadow: 0 35px 80px rgba(0, 0, 0, 0.6);
            border-color: #667eea;
        }

        .course-ribbon {
            position: absolute;
            top: 20px;
            right: -35px;
            background: linear-gradient(135deg, #10b981, #059669);
            color: white;
            padding: 8px 40px;
            font-weight: 700;
            font-size: 12px;
            transform: rotate(45deg);
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.3);
            z-index: 10;
            letter-spacing: 1px;
        }

        .course-ribbon.premium {
            background: linear-gradient(135deg, #f59e0b, #d97706);
        }

        .course-image-wrapper {
            position: relative;
            overflow: hidden;
            height: 240px;
        }

        .course-image {
            width: 100%;
            height: 100%;
            object-fit: cover;
            transition: transform 0.5s ease;
        }

        .course-card:hover .course-image {
            transform: scale(1.15);
        }

        .course-overlay {
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background: linear-gradient(to bottom, transparent 0%, rgba(0,0,0,0.85) 100%);
            opacity: 0;
            transition: opacity 0.4s ease;
            display: flex;
            align-items: flex-end;
            justify-content: center;
            padding: 30px;
        }

        .course-card:hover .course-overlay {
            opacity: 1;
        }

        .enroll-btn {
            background: linear-gradient(135deg, #667eea, #764ba2);
            color: white;
            padding: 14px 35px;
            border-radius: 50px;
            font-weight: 700;
            font-size: 15px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.3);
            transform: translateY(20px);
            transition: all 0.3s ease;
            border: 2px solid white;
        }

        .course-card:hover .enroll-btn {
            transform: translateY(0);
        }

        .course-content {
            padding: 30px;
        }
/* Badge */
.notif-badge {
    position: absolute;
    top: -6px;
    right: -8px;
    background: red;
    color: white;
    font-size: 12px;
    padding: 3px 7px;
    border-radius: 50%;
    font-weight: bold;
    transition: 0.3s;
}

/* Unread notification highlight */
.notif-item.unread {
    font-weight: bold;
    background: #fff9c4; /* light yellow for unread */
}

/* When read */
.notif-item.read {
    font-weight: normal;
    background: #f5f5f5;
}
        #chatToggleBtn {
            position: fixed;
            bottom: 20px;
            left: 20px;
            width: 65px;
            height: 65px;
            font-size: 30px;
            border-radius: 50%;
            background: linear-gradient(135deg, #ff7e5f, #feb47b);
            color: white;
            border: none;
            cursor: pointer;
            z-index: 9999;
            box-shadow: 0 10px 30px rgba(255, 126, 95, 0.4);
            display: flex;
            align-items: center;
            justify-content: center;
            transition: all 0.3s ease;
            animation: pulse 2s infinite;
        }

        #chatToggleBtn:hover {
            transform: scale(1.1);
            box-shadow: 0 15px 40px rgba(255, 126, 95, 0.6);
        }

        @keyframes pulse {
            0%, 100% { transform: scale(1); }
            50% { transform: scale(1.05); }
        }

        /* Chat Container */
        #chatContainer {
            position: fixed;
            bottom: 100px;
            left: 20px;
            width: 480px;
            height: 650px;
            background: white;
            border-radius: 24px;
            box-shadow: 0 25px 60px rgba(0, 0, 0, 0.3);
            display: none;
            flex-direction: column;
            overflow: hidden;
            z-index: 9998;
            animation: slideUp 0.4s ease-out;
        }

        @keyframes slideUp {
            from {
                opacity: 0;
                transform: translateY(30px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        /* Chat Header */
        .quiz-chat-header {
            background: linear-gradient(135deg, #ff7e5f, #feb47b);
            color: white;
            padding: 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }

        .quiz-chat-header h3 {
            margin: 0;
            font-size: 1.3rem;
            font-weight: 700;
            display: flex;
            align-items: center;
            gap: 10px;
        }

        #chatCloseBtn {
            cursor: pointer;
            border: none;
            background: rgba(255, 255, 255, 0.2);
            color: white;
            font-size: 24px;
            width: 36px;
            height: 36px;
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            transition: all 0.3s ease;
        }

        #chatCloseBtn:hover {
            background: rgba(255, 255, 255, 0.3);
            transform: rotate(90deg);
        }

        /* Chat Box */
        #chatBox {
            flex: 1;
            padding: 20px;
            background: linear-gradient(to bottom, #f8fafc, #f1f5f9);
            overflow-y: auto;
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        #chatBox::-webkit-scrollbar {
            width: 8px;
        }

        #chatBox::-webkit-scrollbar-thumb {
            background: linear-gradient(135deg, #ff7e5f, #feb47b);
            border-radius: 10px;
        }

        #chatBox::-webkit-scrollbar-track {
            background: #f1f5f9;
        }

        /* Messages */
        .quiz-message {
            max-width: 85%;
            padding: 14px 18px;
            border-radius: 18px;
            font-size: 0.95rem;
            line-height: 1.6;
            animation: messageSlideIn 0.3s ease-out;
            word-wrap: break-word;
        }

        @keyframes messageSlideIn {
            from {
                opacity: 0;
                transform: translateY(15px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        .quiz-message.user {
            background: linear-gradient(135deg, #ff7e5f, #feb47b);
            color: white;
            margin-left: auto;
            border-bottom-right-radius: 4px;
            box-shadow: 0 4px 12px rgba(255, 126, 95, 0.3);
        }

        .quiz-message.bot {
            background: white;
            border: 2px solid #e2e8f0;
            color: #2d3748;
            border-bottom-left-radius: 4px;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
        }

        /* MCQ Options Container */
        .mcq-options {
            display: flex;
            flex-direction: column;
            gap: 12px;
            margin-top: 15px;
            width: 100%;
        }

        /* Individual MCQ Option */
        .mcq-option {
            background: white;
            border: 2px solid #e2e8f0;
            border-radius: 14px;
            padding: 16px 20px;
            cursor: pointer;
            transition: all 0.3s ease;
            display: flex;
            align-items: center;
            gap: 15px;
            font-size: 0.95rem;
            color: #2d3748;
            font-weight: 500;
            position: relative;
            overflow: hidden;
        }

        .mcq-option:before {
            content: '';
            position: absolute;
            left: 0;
            top: 0;
            height: 100%;
            width: 4px;
            background: linear-gradient(135deg, #ff7e5f, #feb47b);
            transform: scaleY(0);
            transition: transform 0.3s ease;
        }

        .mcq-option:hover {
            border-color: #ff7e5f;
            background: linear-gradient(to right, #fff5f0, white);
            transform: translateX(5px);
            box-shadow: 0 6px 18px rgba(255, 126, 95, 0.15);
        }

        .mcq-option:hover:before {
            transform: scaleY(1);
        }

        /* Option Label (A, B, C, D) */
        .option-label {
            width: 36px;
            height: 36px;
            background: linear-gradient(135deg, #ff7e5f, #feb47b);
            color: white;
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            font-weight: 700;
            font-size: 1rem;
            flex-shrink: 0;
            box-shadow: 0 4px 10px rgba(255, 126, 95, 0.3);
        }

        .mcq-option:hover .option-label {
            transform: scale(1.1);
        }

        /* Option Text */
        .option-text {
            flex: 1;
            line-height: 1.5;
        }

        /* Selected Option State */
        .mcq-option.selected {
            background: linear-gradient(135deg, #ff7e5f, #feb47b);
            border-color: #ff7e5f;
            color: white;
            box-shadow: 0 8px 24px rgba(255, 126, 95, 0.4);
        }

        .mcq-option.selected .option-label {
            background: white;
            color: #ff7e5f;
        }

        /* Correct Answer State */
        .mcq-option.correct {
            background: linear-gradient(135deg, #10b981, #059669);
            border-color: #10b981;
            color: white;
            animation: correctPulse 0.5s ease;
        }

        .mcq-option.correct .option-label {
            background: white;
            color: #10b981;
        }

        @keyframes correctPulse {
            0%, 100% { transform: scale(1); }
            50% { transform: scale(1.03); }
        }

        /* Wrong Answer State */
        .mcq-option.wrong {
            background: linear-gradient(135deg, #ef4444, #dc2626);
            border-color: #ef4444;
            color: white;
            animation: shake 0.5s ease;
        }

        .mcq-option.wrong .option-label {
            background: white;
            color: #ef4444;
        }

        @keyframes shake {
            0%, 100% { transform: translateX(0); }
            25% { transform: translateX(-10px); }
            75% { transform: translateX(10px); }
        }

        /* Disabled Options (after answer) */
        .mcq-option.disabled {
            cursor: not-allowed;
            opacity: 0.6;
        }

        /* Question Container */
        .question-container {
            background: white;
            border: 2px solid #e2e8f0;
            border-radius: 18px;
            padding: 20px;
            margin-bottom: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
        }

        .question-text {
            font-size: 1.05rem;
            font-weight: 600;
            color: #2d3748;
            margin-bottom: 15px;
            line-height: 1.6;
        }

        .question-meta {
            display: flex;
            gap: 15px;
            font-size: 0.85rem;
            color: #718096;
            margin-top: 12px;
            padding-top: 12px;
            border-top: 1px solid #e2e8f0;
        }

        .question-meta span {
            display: flex;
            align-items: center;
            gap: 5px;
        }

        /* Typing Indicator */
        .typing-indicator {
            display: flex;
            gap: 6px;
            padding: 14px 18px;
            background: white;
            border-radius: 18px;
            width: fit-content;
            border: 2px solid #e2e8f0;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
        }

        .typing-dot {
            width: 10px;
            height: 10px;
            background: linear-gradient(135deg, #ff7e5f, #feb47b);
            border-radius: 50%;
            animation: typing 1.4s infinite;
        }

        .typing-dot:nth-child(2) {
            animation-delay: 0.2s;
        }

        .typing-dot:nth-child(3) {
            animation-delay: 0.4s;
        }

        @keyframes typing {
            0%, 60%, 100% {
                transform: translateY(0);
                opacity: 0.5;
            }
            30% {
                transform: translateY(-12px);
                opacity: 1;
            }
        }

        /* Input Area */
        .chat-input-area {
            display: flex;
            padding: 18px;
            border-top: 2px solid #e2e8f0;
            background: white;
            gap: 12px;
        }

        #userInput {
            flex: 1;
            padding: 14px 18px;
            border-radius: 14px;
            border: 2px solid #e2e8f0;
            font-size: 0.95rem;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            transition: all 0.3s ease;
        }

        #userInput:focus {
            outline: none;
            border-color: #ff7e5f;
            box-shadow: 0 0 12px rgba(255, 126, 95, 0.2);
        }

        #sendBtn {
            padding: 14px 24px;
            border-radius: 14px;
            border: none;
            background: linear-gradient(135deg, #ff7e5f, #feb47b);
            color: white;
            cursor: pointer;
            font-weight: 600;
            font-size: 0.95rem;
            box-shadow: 0 4px 12px rgba(255, 126, 95, 0.3);
            transition: all 0.3s ease;
        }

        #sendBtn:hover {
            box-shadow: 0 6px 18px rgba(255, 126, 95, 0.5);
            transform: translateY(-2px);
        }

        #sendBtn:active {
            transform: translateY(0);
        }

        #sendBtn:disabled {
            opacity: 0.6;
            cursor: not-allowed;
        }

        /* Score Display */
        .score-display {
            background: linear-gradient(135deg, #667eea, #764ba2);
            color: white;
            padding: 16px 20px;
            border-radius: 14px;
            text-align: center;
            font-weight: 700;
            font-size: 1.1rem;
            box-shadow: 0 6px 18px rgba(102, 126, 234, 0.3);
            margin: 10px 0;
        }

        /* Feedback Messages */
        .feedback-message {
            padding: 12px 16px;
            border-radius: 12px;
            margin-top: 10px;
            font-weight: 600;
            font-size: 0.9rem;
            text-align: center;
        }

        .feedback-message.correct {
            background: #d1fae5;
            color: #065f46;
            border-left: 4px solid #10b981;
        }

        .feedback-message.wrong {
            background: #fee2e2;
            color: #991b1b;
            border-left: 4px solid #ef4444;
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            #chatContainer {
                width: calc(100vw - 40px);
                left: 20px;
                bottom: 100px;
                height: 70vh;
            }

            #chatToggleBtn {
                left: 20px;
                bottom: 20px;
            }

            .mcq-option {
                padding: 14px 16px;
            }

            .option-label {
                width: 32px;
                height: 32px;
                font-size: 0.9rem;
            }
        }

        .course-category {
            display: inline-block;
            background: linear-gradient(135deg, #e0e7ff, #f3e8ff);
            color: #667eea;
            padding: 8px 16px;
            border-radius: 20px;
            font-size: 12px;
            font-weight: 600;
            margin-bottom: 15px;
        }

        .course-title {
            font-size: 24px;
            font-weight: 700;
            margin-bottom: 15px;
            color: #2d3748;
            line-height: 1.4;
        }

        .course-description {
            font-size: 15px;
            color: #718096;
            line-height: 1.7;
            margin-bottom: 20px;
        }

        .course-features {
            display: flex;
            flex-wrap: wrap;
            gap: 15px;
            margin-bottom: 20px;
            padding-bottom: 20px;
            border-bottom: 3px solid #e2e8f0;
        }

        .feature-item {
            display: flex;
            align-items: center;
            gap: 8px;
            font-size: 13px;
            color: #4a5568;
            font-weight: 600;
        }

        .feature-item i {
            color: #667eea;
            font-size: 15px;
        }

        .course-footer {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .course-price {
            font-size: 32px;
            font-weight: 700;
            color: #10b981;
        }

        .course-price.premium-price {
            color: #f59e0b;
        }

        .course-rating {
            display: flex;
            align-items: center;
            gap: 8px;
            font-size: 14px;
            color: #718096;
        }

        .stars {
            color: #fbbf24;
            font-size: 16px;
        }

        /* Animations */
        @keyframes fadeInDown {
            from {
                opacity: 0;
                transform: translateY(-30px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        @keyframes fadeInUp {
            from {
                opacity: 0;
                transform: translateY(30px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        /* Responsive */
        @media (max-width: 1024px) {
            .profile-content {
                grid-template-columns: 1fr;
                gap: 40px;
            }

            .photo-section {
                display: flex;
                flex-direction: column;
                align-items: center;
            }

            .course-grid {
                grid-template-columns: 1fr;
            }
        }

        @media (max-width: 768px) {
            .header-top {
                flex-direction: column;
                gap: 20px;
                padding: 20px;
            }

            .header-nav {
                flex-direction: column;
            }

            .nav-item {
                border-right: none;
                border-bottom: 1px solid rgba(255, 255, 255, 0.2);
            }

            .profile-section {
                padding: 30px 25px;
            }

            .profile-title {
                font-size: 28px;
            }

            .stats-bar {
                grid-template-columns: 1fr;
                gap: 15px;
            }

            .section-title {
                font-size: 32px;
            }

            .category-header {
                flex-direction: column;
                text-align: center;
                padding: 20px;
            }
        }
      #chat-btn {
    position: fixed;
    bottom: 20px;
    right: 20px;
    width: 65px;
    height: 65px;
    font-size: 30px;
    border-radius: 50%;
    background: linear-gradient(135deg, #667eea, #764ba2);
    color: white;
    border: none;
    cursor: pointer;
    z-index: 9999;
    box-shadow: 0 10px 30px rgba(102, 126, 234, 0.4);
    display: flex;
    align-items: center;
    justify-content: center;
    transition: all 0.3s ease;
    animation: bounce 2s infinite;
}

#chat-btn:hover {
    transform: scale(1.15);
    box-shadow: 0 15px 40px rgba(102, 126, 234, 0.6);
    animation: none;
}

#chat-btn:active {
    transform: scale(1.05);
}

/* Bounce Animation for Button */
@keyframes bounce {
    0%, 100% { 
        transform: translateY(0); 
    }
    50% { 
        transform: translateY(-10px); 
    }
}

/* Chatbox Container with Slide-Up Animation */
#chatbox {
    position: fixed;
    bottom: 100px;
    right: 20px;
    width: 450px;
    height: 65vh;
    background: white;
    border-radius: 20px;
    box-shadow: 0 20px 50px rgba(0, 0, 0, 0.3);
    display: none;
    flex-direction: column;
    overflow: hidden;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    z-index: 9998;
    animation: slideUp 0.4s ease-out;
}

@keyframes slideUp {
    from {
        opacity: 0;
        transform: translateY(30px) scale(0.95);
    }
    to {
        opacity: 1;
        transform: translateY(0) scale(1);
    }
}

/* Chat Header with Gradient */
#chat-header {
    background: linear-gradient(135deg, #667eea, #764ba2);
    color: white;
    padding: 18px 20px;
    font-weight: bold;
    display: flex;
    justify-content: space-between;
    align-items: center;
    font-size: 1.2rem;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}

/* Close Button with Rotate Animation */
#close-btn {
    cursor: pointer;
    font-size: 24px;
    width: 32px;
    height: 32px;
    display: flex;
    align-items: center;
    justify-content: center;
    border-radius: 50%;
    background: rgba(255, 255, 255, 0.2);
    transition: all 0.3s ease;
}

#close-btn:hover {
    background: rgba(255, 255, 255, 0.3);
    transform: rotate(90deg);
}

#close-btn:active {
    transform: rotate(90deg) scale(0.9);
}

/* Chat Messages Area */
#chat {
    flex: 1;
    padding: 20px;
    background: linear-gradient(to bottom, #f8fafc, #f1f5f9);
    overflow-y: auto;
    display: flex;
    flex-direction: column;
    gap: 12px;
}

/* Custom Scrollbar */
#chat::-webkit-scrollbar {
    width: 6px;
}

#chat::-webkit-scrollbar-thumb {
    background: linear-gradient(135deg, #667eea, #764ba2);
    border-radius: 10px;
}

#chat::-webkit-scrollbar-track {
    background: #f1f5f9;
}

/* Message Bubbles with Slide-In Animation */
.message {
    max-width: 80%;
    padding: 12px 16px;
    border-radius: 16px;
    font-size: 0.95rem;
    line-height: 1.5;
    animation: messageSlide 0.3s ease-out;
    word-wrap: break-word;
    white-space: pre-wrap;
}

@keyframes messageSlide {
    from {
        opacity: 0;
        transform: translateY(15px);
    }
    to {
        opacity: 1;
        transform: translateY(0);
    }
}

/* User Messages */
.message.user {
    background: linear-gradient(135deg, #667eea, #764ba2);
    color: white;
    margin-left: auto;
    border-bottom-right-radius: 4px;
    box-shadow: 0 4px 12px rgba(102, 126, 234, 0.3);
}

/* Bot Messages */
.message.bot {
    background: white;
    border: 2px solid #e2e8f0;
    color: #2d3748;
    border-bottom-left-radius: 4px;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
}

/* Typing Indicator Animation */
.typing-indicator {
    display: flex;
    gap: 6px;
    padding: 14px 18px;
    background: white;
    border-radius: 18px;
    width: fit-content;
    border: 2px solid #e2e8f0;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
}

.typing-dot {
    width: 10px;
    height: 10px;
    background: linear-gradient(135deg, #667eea, #764ba2);
    border-radius: 50%;
    animation: typing 1.4s infinite;
}

.typing-dot:nth-child(2) {
    animation-delay: 0.2s;
}

.typing-dot:nth-child(3) {
    animation-delay: 0.4s;
}

@keyframes typing {
    0%, 60%, 100% {
        transform: translateY(0);
        opacity: 0.5;
    }
    30% {
        transform: translateY(-12px);
        opacity: 1;
    }
}

/* Input Area */
#chat-input {
    display: flex;
    padding: 18px;
    border-top: 2px solid #e2e8f0;
    background: white;
    gap: 12px;
}

/* Input Field with Focus Animation */
#q {
    flex: 1;
    padding: 12px 16px;
    border-radius: 25px;
    border: 2px solid #e2e8f0;
    outline: none;
    font-size: 0.95rem;
    transition: all 0.3s ease;
}

#q:focus {
    border-color: #667eea;
    box-shadow: 0 0 10px rgba(102, 126, 234, 0.2);
    transform: scale(1.02);
}

/* Send Button with Hover Effects */
#send-btn {
    padding: 12px 20px;
    border-radius: 25px;
    border: none;
    background: linear-gradient(135deg, #667eea, #764ba2);
    color: white;
    cursor: pointer;
    font-weight: 600;
    transition: all 0.3s ease;
    box-shadow: 0 4px 12px rgba(102, 126, 234, 0.3);
}

#send-btn:hover {
    box-shadow: 0 6px 18px rgba(102, 126, 234, 0.5);
    transform: translateY(-2px);
}

#send-btn:active {
    transform: translateY(0);
}

#send-btn:disabled {
    opacity: 0.6;
    cursor: not-allowed;
}

/* Pulse Effect for New Messages */
@keyframes pulse {
    0% {
        box-shadow: 0 0 0 0 rgba(102, 126, 234, 0.7);
    }
    70% {
        box-shadow: 0 0 0 10px rgba(102, 126, 234, 0);
    }
    100% {
        box-shadow: 0 0 0 0 rgba(102, 126, 234, 0);
    }
}

/* Add pulse class to button when new message */
#chat-btn.new-message {
    animation: pulse 1.5s infinite;
}

/* Fade-in animation for chatbox opening */
@keyframes fadeIn {
    from {
        opacity: 0;
    }
    to {
        opacity: 1;
    }
}

/* Code blocks in messages */
.message code {
    background: rgba(0, 0, 0, 0.05);
    padding: 2px 6px;
    border-radius: 4px;
    font-family: 'Courier New', monospace;
    font-size: 0.9em;
}

.message.bot code {
    background: #f1f5f9;
}

.message.user code {
    background: rgba(255, 255, 255, 0.2);
}

/* Links in messages */
.message a {
    color: inherit;
    text-decoration: underline;
    opacity: 0.9;
}

.message a:hover {
    opacity: 1;
}

/* Responsive Design */
@media (max-width: 768px) {
    #chatbox {
        width: calc(100vw - 40px);
        right: 20px;
        bottom: 100px;
        height: 70vh;
    }

    #chat-btn {
        right: 20px;
        bottom: 20px;
    }
}

/* Shake animation for errors */
@keyframes shake {
    0%, 100% { transform: translateX(0); }
    25% { transform: translateX(-10px); }
    75% { transform: translateX(10px); }
}

.shake {
    animation: shake 0.5s ease;
}

/* Success message highlight */
.message.success {
    background: linear-gradient(135deg, #10b981, #059669);
    color: white;
}

/* Error message highlight */
.message.error {
    background: linear-gradient(135deg, #ef4444, #dc2626);
    color: white;
}

/* Glow effect for active chat */
#chatbox.active {
    box-shadow: 0 20px 50px rgba(102, 126, 234, 0.4);
}  
    </style>
</head>
<body>
    <!-- Header -->
    <div class="header">
        <div class="header-top">
            <div class="header-logo">
                <h1><i class="fas fa-graduation-cap"></i> Learning Dashboard</h1>
            </div>
            <div class="header-buttons">
                <button class="header-btn" id="profileToggleBtn">
                    <i class="fas fa-user-circle"></i> Profile
                </button>
               <button class="header-btn notification-btn" id="notificationBtn">
    <i class="fas fa-bell"></i>
    <span class="notif-badge" id="notifBadge">
        <%= totalCompletedCourses + totalCertificates %>
    </span>
</button>
<button class="header-btn logout-btn" id="logoutBtn">
    <i class="fas fa-sign-out-alt"></i> Logout
</button>
<div class="notification-dropdown" id="notificationDropdown">
    <h4>Notifications</h4>

    <% if (totalCompletedCourses > 0) { %>
        <div class="notif-item success unread">
              &#x1F389; <b>Well done <%= userName %>!</b><br>
            You completed <%= totalCompletedCourses %> course(s).
        </div>
    <% } %>

    <% if (totalCertificates > 0) { %>
        <div class="notif-item certificate unread">
              &#x1F3C6; <b>Certificate Unlocked!</b><br>
            You earned <%= totalCertificates %> certificate(s).
            <br>
            <a href="Certificate.jsp">View Certificate</a>
        </div>
    <% } %>

    <% if (totalCompletedCourses == 0 && totalCertificates == 0) { %>
        <div class="notif-item">
             &#x1F4DA;Start a course to earn achievements!
        </div>
    <% } %>
</div>
               

<!-- NOTIFICATION DROPDOWN -->


            </div>
        </div>
        
        <!-- Header Navigation -->
        <div class="header-nav">
      
           <a href="javascript:void(0)" onclick="openPanel('about')" class="nav-item">
                <i class="fas fa-chalkboard-teacher"></i> About Us
            </a>
            <a href="javascript:void(0)" onclick="openPanel('services')" class="nav-item">
                <i class="fas fa-book-open"></i> Services
            </a>
            <a href="javascript:void(0)" onclick="openPanel('contact')"  class="nav-item">
                <i class="fas fa-life-ring"></i> Support
            </a>
        </div>
    </div>

    <div class="container">
        <!-- Profile Section -->
        <div class="profile-section" id="profileSection">
            <div class="profile-header">
                <h1 class="profile-title">Knowledge Check & Demonstration of Projects</h1>
                <p class="profile-subtitle">Track your progress and explore amazing courses</p>
            </div>

            <div class="profile-content">
                <!-- Photo Section -->
                <div class="photo-section">
                    <div class="photo-wrapper">
                        <div class="photo-container">
<img id="profilePhoto" src="<%= session.getAttribute("photo") != null ? session.getAttribute("photo") : "Ashoka.jpg" %>" alt="Profile Photo" class="profile-photo">
                        </div>
                        <label for="fileInput" class="camera-btn">
                            <i class="fas fa-camera"></i>
                        </label>
                        <input type="file" id="fileInput" accept="image/*">
                    </div>
                    <h2 class="user-name"><%= userName %></h2>
                    <p class="user-role">Data Science Student</p>
                </div>

                <!-- Info Grid -->
                <div class="info-grid">
                    <div class="info-card">
                        <div class="info-card-header">
                            <div class="info-icon">
                                <i class="fas fa-user-circle"></i>
                            </div>
                            <span class="info-label">Account Name</span>
                        </div>
                        <div class="info-value"><%= userName %></div>
                    </div>

                    <div class="info-card">
                        <div class="info-card-header">
                            <div class="info-icon">
                                <i class="fas fa-envelope"></i>
                            </div>
                            <span class="info-label"><a href='UserProfile.jsp' Style='text-decoration: NoNe;'>Account</a></span>
                        </div>
                        <div class="info-value"></div>
                    </div>

                    <div class="info-card">
                        <div class="info-card-header">
                            <div class="info-icon">
                                <i class="fas fa-graduation-cap"></i>
                            </div>
                            <span class="info-label"><a href="Completed.jsp" Style="text-Decoration:NoNe;">Courses Completed</a></span>
                        </div>
                        <div class="info-value">Click to View Completed Courses</div>
                    </div>

                    <!-- Stats Bar -->
                    <!-- Stats Bar -->



<div class="stats-bar">
    <div class="stat-box">
        <span class="stat-number">8</span>
        <span class="stat-label">Total Courses</span>
    </div>
    <div class="stat-box">
        <span class="stat-number">
            <%
            Integer completedCount = (Integer) session.getAttribute("TotalCompletedCourses");
            out.print(completedCount != null ? completedCount : 0);
            %>
        </span>
        <span class="stat-label">Completed</span>
    </div>
   <div class="stat-box">
    <span class="stat-number">
        <%
        Integer certsCount = (Integer) session.getAttribute("TotalCertificates");
        out.print(certsCount != null ? certsCount : 0);
        %>
    </span>
    <span class="stat-label">Certificates</span>
</div>
</div>
                </div>
            </div>
        </div>

        <!-- Courses Section -->
        <div class="courses-section">
            <div class="section-header">
                <h2 class="section-title">Available Courses</h2>
                <p class="section-subtitle">Choose the perfect course to advance your skills</p>
            </div>

            <!-- Filter Buttons -->
            <div class="filter-section">
                <button class="filter-btn active" data-filter="all">
                    <i class="fas fa-th"></i> All Courses
                </button>
                <button class="filter-btn" data-filter="free">
                    <i class="fas fa-gift"></i><a href="Scroll.jsp" Style='text-decoration:NoNe;'> Free Courses</a>
                </button>
                <button class="filter-btn" data-filter="premium">
                    <i class="fas fa-crown"></i> Premium Courses
                </button>
            </div>

            <!-- Free Courses -->
            <div class="category-wrapper free-category">
                <div class="category-header">
                    <div class="category-icon">
                        <i class="fas fa-gift"></i>
                    </div>
                    <div class="category-info">
                        <h3>Free Courses</h3>
                        <p>Start learning without any cost</p>
                    </div>
                </div>

                <div class="course-grid">
                    <!-- Free Course 1 -->
                    <a href="Scroll.jsp" class="course-card">
                        <span class="course-ribbon">FREE</span>
                        <div class="course-image-wrapper">
                            <img src="Free.jpg" alt="Python Basics" class="course-image">
                            <div class="course-overlay">
                                <span class="enroll-btn">Start Learning →</span>
                            </div>
                        </div>
                        <div class="course-content">
                             <div class="course-features">
                                <div class="feature-item">
                                    <i class="fas fa-video"></i>
                                </div>
                                <div class="feature-item">
                                    <i class="fas fa-clock"></i>
                                    <span>6 Hours</span>
                                </div>
                                <div class="feature-item">
                                    <i class="fas fa-users"></i>
                                    <span>15K Students</span>
                                </div>
                            </div>
                            <div class="course-footer">
                                <span class="course-price">FREE</span>
                                <div class="course-rating">
                                    <span class="stars">>&#x2605;&#x2605;&#x2605;&#x2605;&#x2605;</span>
                                    <span>4.8 (2.5K)</span>
                                </div>
                            </div>
                        </div>
                    </a>

                    <!-- Free Course 2 -->
                   </div></div>
<button id="chat-btn" style="position: fixed; bottom: 20px; right: 20px; width: 60px; height: 60px; font-size:28px; border-radius:50%; background: linear-gradient(135deg,#667eea,#764ba2); color:white; border:none; cursor:pointer; z-index:9999;">
    &#x1F916;
</button>

<div id="chatbox" style="position: fixed; bottom: 90px; right: 20px; width: 400px; height: 60vh; background:white; border-radius:15px; box-shadow:0 10px 30px rgba(0,0,0,0.2); display:none; flex-direction:column; overflow:hidden; font-family:Arial, sans-serif; z-index:9998;">
    <div id="chat-header" style="background: linear-gradient(135deg,#667eea,#764ba2); color:white; padding:12px; font-weight:bold; display:flex; justify-content:space-between; align-items:center;">
        AI JavaBot
        <span id="close-btn" style="cursor:pointer;">&#10005;</span>
    </div>
    <div id="chat" style="flex:1; padding:10px; background:#f1f3f6; overflow-y:auto; display:flex; flex-direction:column;"></div>
    <div id="chat-input" style="display:flex; padding:10px; border-top:1px solid #ccc; background:#f9f9f9;">
        <input id="q" placeholder="Type your message..." autocomplete="off" style="flex:1; padding:8px 12px; border-radius:25px; border:1px solid #ccc; outline:none;" />
        <button id="send-btn" style="margin-left:8px; padding:0 15px; border-radius:25px; border:none; background:linear-gradient(135deg,#667eea,#764ba2); color:white; cursor:pointer;">Send</button>
    </div>
</div>

<!-- Second Chat: CertiQuiz Bot -->
<button id="chatToggleBtn" title="Open Quiz Chat" style="position: fixed; bottom: 20px; left: 20px; width: 60px; height: 60px; font-size:28px; border-radius:50%; background: linear-gradient(135deg,#ff7e5f,#feb47b); color:white; border:none; cursor:pointer; z-index:9999;">
   &#128221;
</button>

<div id="chatContainer" style="position: fixed; bottom: 90px; left: 20px; width: 450px; height: 65vh; background:white; border-radius:15px; box-shadow:0 10px 30px rgba(0,0,0,0.2); display:none; flex-direction:column; overflow:hidden; font-family:Arial, sans-serif; z-index:9998;">
    <div class="chat-header" style="background: linear-gradient(135deg,#ff7e5f,#feb47b); color:white; padding:12px; display:flex; justify-content:space-between; align-items:center;">
        <h3 style="margin:0;">&#x1F3AF; CertiQuiz Bot</h3>
        <button id="chatCloseBtn" style="cursor:pointer; border:none; background:none; color:white; font-size:18px;">&#x00D7;</button>
    </div>
    <div id="chatBox" style="flex:1; padding:10px; background:#f1f3f6; overflow-y:auto; display:flex; flex-direction:column;"></div>
    <div class="chat-input-area" style="display:flex; padding:10px; border-top:1px solid #ccc; background:#f9f9f9;">
        <input id="userInput" type="text" placeholder="Type 'java question' or 'help'..." autocomplete="off" style="flex:1; padding:8px 12px; border-radius:25px; border:1px solid #ccc; outline:none;">
        <button id="sendBtn" style="margin-left:8px; padding:0 15px; border-radius:25px; border:none; background:linear-gradient(135deg,#ff7e5f,#feb47b); color:white; cursor:pointer;">Send</button>
    </div>
</div>

            <!-- Premium Courses -->
            <div class="category-wrapper premium-category">
                <div class="category-header">
                    <div class="category-icon premium">
                        <i class="fas fa-crown"></i>
                    </div>
                    <div class="category-info">
                        <h3>Premium Courses</h3>
                        <p>Unlock advanced skills with premium content</p>
                    </div>
                </div>

                <div class="course-grid">
                    <!-- Premium Course 1 -->
                    <a href="PremiumAccess?course=AIML" class="course-card">
                        <span class="course-ribbon premium">PREMIUM</span>
                        <div class="course-image-wrapper">
                            <img src="AI.jpg" alt="Machine Learning" class="course-image">
                            <div class="course-overlay">
                                <span class="enroll-btn">Start Learning →</span>
                            </div>
                        </div>
                        <div class="course-content">
                            <span class="course-category">Data Science</span>
                            <h3 class="course-title">Machine Learning & AI</h3>
                            <p class="course-description">Master supervised and unsupervised learning, neural networks, and AI applications with real-world projects.</p>
                            <div class="course-features">
                                <div class="feature-item">
                                    <i class="fas fa-video"></i>
                                    
                                </div>
                                <div class="feature-item">
                                    <i class="fas fa-clock"></i>
                                    <span>12 Hours</span>
                                </div>
                                <div class="feature-item">
                                    <i class="fas fa-users"></i>
                                    <span>10K Students</span>
                                </div>
                            </div>
                            <div class="course-footer">
                                <span class="course-price premium-price">₹4999</span>
                                <div class="course-rating">
                                    <span class="stars">&#x2605;&#x2605;&#x2605;&#x2605;&#x2605;</span>
                                    <span>4.9 (1.8K)</span>
                                </div>
                            </div>
                        </div>
                    </a>

                    <!-- Premium Course 2 -->
                    <a href="PremiumAccess?course=AWS/Azure Cloud" class="course-card">
                        <span class="course-ribbon premium">PREMIUM</span>
                        <div class="course-image-wrapper">
                            <img src="AWZC.png" alt="Cloud Computing" class="course-image">
                            <div class="course-overlay">
                                <span class="enroll-btn">Start Learning →</span>
                            </div>
                        </div>
                        <div class="course-content">
                            <span class="course-category">Cloud Computing</span>
                            <h3 class="course-title">AWS & Azure Fundamentals</h3>
                            <p class="course-description">Learn cloud architecture, deployment, and scaling with AWS and Azure. Includes hands-on labs and certification prep.</p>
                            <div class="course-features">
                                <div class="feature-item">
                                    <i class="fas fa-video"></i>
                                   
                                </div>
                                <div class="feature-item">
                                    <i class="fas fa-clock"></i>
                                    <span>10 Hours</span>
                                </div>
                                <div class="feature-item">
                                    <i class="fas fa-users"></i>
                                    <span>8K Students</span>
                                </div>
                            </div>
                            <div class="course-footer">
                                <span class="course-price premium-price">₹3999</span>
                                <div class="course-rating">
                                    <span class="stars">>&#x2605;&#x2605;&#x2605;&#x2605;&#x2605;</span>
                                    <span>4.6 (1.2K)</span>
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </div>

    <!-- Scripts -->
    <script>
        // Toggle profile section
        const profileToggleBtn = document.getElementById('profileToggleBtn');
        const profileSection = document.getElementById('profileSection');

        profileToggleBtn.addEventListener('click', () => {
            profileSection.classList.toggle('hidden');
            profileToggleBtn.classList.toggle('active');
        });

        // Filter courses
        const filterBtns = document.querySelectorAll('.filter-btn');
        const freeCategory = document.querySelector('.free-category');
        const premiumCategory = document.querySelector('.premium-category');

        filterBtns.forEach(btn => {
            btn.addEventListener('click', () => {
                filterBtns.forEach(b => b.classList.remove('active'));
                btn.classList.add('active');

                const filter = btn.getAttribute('data-filter');
                if (filter === 'all') {
                    freeCategory.classList.remove('hidden');
                    premiumCategory.classList.remove('hidden');
                } else if (filter === 'free') {
                    freeCategory.classList.remove('hidden');
                    premiumCategory.classList.add('hidden');
                } else if (filter === 'premium') {
                    premiumCategory.classList.remove('hidden');
                    freeCategory.classList.add('hidden');
                }
            });
        });

        // Profile photo upload
        const fileInput = document.getElementById('fileInput');
        const profilePhoto = document.getElementById('profilePhoto');

        fileInput.addEventListener('change', (event) => {
            const file = event.target.files[0];
            if (file) {
                const reader = new FileReader();
                reader.onload = e => {
                    profilePhoto.src = e.target.result;
                };
                reader.readAsDataURL(file);
            }
        });
    </script>
    <script>
const notifBtn = document.getElementById("notificationBtn");
const dropdown = document.getElementById("notificationDropdown");
const notifBadge = document.getElementById("notifBadge");

// Function to update badge count based on unread notifications
function updateBadge() {
    const unreadItems = document.querySelectorAll(".notif-item.unread");
    if (unreadItems.length > 0) {
        notifBadge.textContent = unreadItems.length;
        notifBadge.style.display = "inline-block";
    } else {
        // Smoothly hide badge
        notifBadge.style.transition = "0.4s";
        notifBadge.style.transform = "scale(0)";
        setTimeout(() => {
            notifBadge.style.display = "none";
            notifBadge.style.transform = "scale(1)";
        }, 400);
    }
}

// Toggle dropdown on bell click
notifBtn.addEventListener("click", (e) => {
    e.stopPropagation(); // prevent immediate closing
    dropdown.style.display =
        dropdown.style.display === "block" ? "none" : "block";

    // Mark visible notifications as read
    const unreadItems = document.querySelectorAll(".notif-item.unread");
    unreadItems.forEach(item => {
        item.classList.remove("unread");
        item.classList.add("read");
    });

    // Update badge count after marking as read
    updateBadge();
});

// Close dropdown when clicking outside
document.addEventListener("click", (e) => {
    if (!notifBtn.contains(e.target) && !dropdown.contains(e.target)) {
        dropdown.style.display = "none";
    }
});

// Optional: Hover effect to show tooltip for unread notifications
const allNotifItems = document.querySelectorAll(".notif-item");
allNotifItems.forEach(item => {
    item.addEventListener("mouseenter", () => {
        if (item.classList.contains("unread")) {
            item.style.background = "#fff9c4"; // highlight unread on hover
        }
    });
    item.addEventListener("mouseleave", () => {
        if (item.classList.contains("read")) {
            item.style.background = "#f5f5f5"; // reset read background
        }
    });
});
</script>

<script>
 PreparedStatement pstmt = conn.prepareStatement("SELECT filepath FROM UserData WHERE email = ?");
pstmt.setString(1, user);
ResultSet rs = pstmt.executeQuery();
if(rs.next()) {
    session.setAttribute("photo", rs.getString("photo"));
}</script><script>

const logoutBtn = document.getElementById('logoutBtn');

logoutBtn.addEventListener('click', () => {
    if (confirm('Are you sure you want to logout?')) {
        window.location.href = 'LogoutServlet';
    }
});
</script>
 
  
 <script>
// Open / Close chat
const chatBtn = document.getElementById("chat-btn");
const chatBox = document.getElementById("chatbox");
const closeBtn = document.getElementById("close-btn");
chatBtn.onclick = () => chatBox.style.display = "flex";
closeBtn.onclick = () => chatBox.style.display = "none";

// Send message function
function send() {
    let question = document.getElementById("q").value.trim();
    if (!question) return;

    const chat = document.getElementById("chat");

    // Add user message
    const userMsg = document.createElement("div");
    userMsg.className = "message user";
    userMsg.innerText = question;
    chat.appendChild(userMsg);

    document.getElementById("q").value = "";
    chat.scrollTop = chat.scrollHeight;

    // Add bot typing placeholder
    const botMsg = document.createElement("div");
    botMsg.className = "message bot";
    botMsg.innerText = "Bot is thinking...";
    chat.appendChild(botMsg);
    chat.scrollTop = chat.scrollHeight;

    // Fetch response from your servlet
    fetch("ChattahC", {
        method: "POST",
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
        body: "question=" + encodeURIComponent(question)
    })
    .then(res => res.json())
    .then(data => {
        botMsg.innerText = data.answer;
        chat.scrollTop = chat.scrollHeight;
    })
    .catch(err => {
        botMsg.innerText = `Error: ${err.message}`;
        chat.scrollTop = chat.scrollHeight;
    });
}

// Send on Enter key
document.getElementById("q").addEventListener("keypress", function(e){
    if(e.key === "Enter") send();
});
document.getElementById("send-btn").addEventListener("click", send);
chatBtn.onclick = () => {
    chatBox.style.display = "flex";
    chatBox.style.width = "500px";
    chatBox.style.height = "70vh";
};

closeBtn.onclick = () => {
    chatBox.style.display = "none";
};

</script>
 <div id="sidePanel" style="
  position: fixed; top: 0; right: -100%; width: 100%; max-width: 750px;
  height: 100vh; background: #fff; z-index: 9999;
  box-shadow: -10px 0 50px rgba(0,0,0,0.25);
  transition: right 0.45s cubic-bezier(0.4,0,0.2,1);
  display: flex; flex-direction: column; overflow: hidden;
">
  <div id="panelHeader" style="
    background: linear-gradient(135deg, #1e3a8a, #0f172a);
    color: white; padding: 24px 30px;
    display: flex; justify-content: space-between; align-items: center;
    flex-shrink: 0;
  ">
    <h2 id="panelTitle" style="margin:0; font-size:1.6rem; font-weight:800; font-family:'Plus Jakarta Sans',sans-serif;"></h2>
    <button onclick="closePanel()" style="
      background: rgba(255,255,255,0.15); border: none; color: white;
      width: 42px; height: 42px; border-radius: 50%; font-size: 1.4rem;
      cursor: pointer; display: flex; align-items: center; justify-content: center;
    " onmouseover="this.style.background='rgba(255,46,151,0.6)'"
       onmouseout="this.style.background='rgba(255,255,255,0.15)'">&times;</button>
  </div>
  <div id="panelBody" style="flex:1; overflow-y:auto; padding: 40px 35px; font-family:'Plus Jakarta Sans',sans-serif;"></div>
</div>

<div id="panelBackdrop" onclick="closePanel()" style="
  position: fixed; inset: 0; background: rgba(15,23,42,0.6);
  backdrop-filter: blur(4px); z-index: 9998;
  display: none; opacity: 0; transition: opacity 0.35s;
"></div>

<script>
// ============================================================
// JSP-SAFE VERSION: uses string concatenation NOT backticks
// ============================================================

function makeCard(icon, title, desc, tag) {
  return '<div style="background:linear-gradient(135deg,#f8fafc,#eef2ff);border:1.5px solid #e2e8f0;border-radius:18px;padding:28px 24px;transition:all 0.3s;" onmouseover="this.style.transform=\'translateY(-5px)\';this.style.boxShadow=\'0 12px 30px rgba(37,99,235,0.15)\';this.style.borderColor=\'#2563eb\'" onmouseout="this.style.transform=\'\';this.style.boxShadow=\'\';this.style.borderColor=\'#e2e8f0\'">'
    + '<div style="font-size:2.2rem;margin-bottom:12px;">' + icon + '</div>'
    + '<h3 style="margin:0 0 10px;font-size:1.15rem;color:#1e293b;">' + title + '</h3>'
    + '<p style="margin:0 0 14px;color:#64748b;font-size:0.9rem;line-height:1.6;">' + desc + '</p>'
    + '<span style="background:linear-gradient(135deg,#dbeafe,#e0e7ff);color:#2563eb;font-size:0.75rem;font-weight:700;padding:5px 13px;border-radius:20px;text-transform:uppercase;letter-spacing:0.5px;">' + tag + '</span>'
    + '</div>';
}

function makeStatBox(num, label) {
  return '<div style="background:linear-gradient(135deg,#eef2ff,#e0e7ff);border-radius:16px;padding:22px;text-align:center;border:1.5px solid #c7d2fe;">'
    + '<span style="font-size:2rem;font-weight:800;color:#2563eb;display:block;">' + num + '</span>'
    + '<span style="font-size:0.85rem;color:#64748b;font-weight:600;">' + label + '</span>'
    + '</div>';
}

function makeValueCard(icon, title, desc) {
  return '<div style="display:flex;gap:12px;padding:16px;background:#f8fafc;border-radius:14px;border:1px solid #e2e8f0;">'
    + '<span style="font-size:1.3rem;flex-shrink:0;">' + icon + '</span>'
    + '<div><h4 style="margin:0 0 4px;font-size:0.93rem;color:#1e293b;">' + title + '</h4>'
    + '<p style="margin:0;font-size:0.82rem;color:#64748b;line-height:1.5;">' + desc + '</p></div>'
    + '</div>';
}

function makeTeamCard(icon, name, role, bio, bg) {
  return '<div style="background:' + bg + ';color:white;border-radius:18px;padding:24px;display:flex;gap:18px;align-items:center;margin-bottom:14px;">'
    + '<div style="width:60px;height:60px;border-radius:50%;background:linear-gradient(135deg,#667eea,#764ba2);display:flex;align-items:center;justify-content:center;font-size:1.8rem;flex-shrink:0;">' + icon + '</div>'
    + '<div><h4 style="margin:0 0 3px;font-size:1.05rem;">' + name + ' \u2014 ' + role + '</h4>'
    + '<p style="margin:0;font-size:0.85rem;color:rgba(255,255,255,0.75);line-height:1.5;">' + bio + '</p></div>'
    + '</div>';
}

function makeContactRow(icon, label, val) {
  return '<div style="display:flex;align-items:center;gap:15px;padding:16px 20px;background:#f8fafc;border-radius:14px;border:1.5px solid #e2e8f0;transition:all 0.25s;" onmouseover="this.style.borderColor=\'#2563eb\';this.style.background=\'#eef2ff\'" onmouseout="this.style.borderColor=\'#e2e8f0\';this.style.background=\'#f8fafc\'">'
    + '<span style="font-size:1.4rem;width:30px;text-align:center;">' + icon + '</span>'
    + '<div><p style="margin:0;font-size:0.78rem;color:#94a3b8;font-weight:700;text-transform:uppercase;letter-spacing:0.4px;">' + label + '</p>'
    + '<p style="margin:0;font-size:0.97rem;color:#1e293b;font-weight:600;">' + val + '</p></div>'
    + '</div>';
}

var panelData = {

  services: {
    title: 'Our Services',
    html: function() {
      var cards = [
        makeCard('\uD83D\uDCBB', 'Online Courses', 'Self-paced expert-designed courses in Python, Java, JavaScript \u2014 built for real skill development.', '10+ Courses'),
        makeCard('\uD83D\uDCCB', 'Knowledge Assessments', 'Scenario-based challenges that prove you can apply what you\'ve learned, not just memorize it.', 'Skill Verified'),
        makeCard('\uD83C\uDFC6', 'Digital Certificates', 'Shareable, verifiable certificates recognised by employers \u2014 perfect for LinkedIn or your portfolio.', 'Industry Recognised'),
        makeCard('\uD83D\uDDFA\uFE0F', 'Learning Paths', 'Curated multi-course journeys: Full Stack, Data Science, Cloud Engineering \u2014 from basics to job-ready.', 'Goal Oriented'),
        makeCard('\uD83D\uDC65', 'Live Mentorship', '1-on-1 sessions with working engineers for code reviews, career guidance, and practice.', '1-on-1 Sessions'),
        makeCard('\uD83D\uDCBC', 'Career Support', 'Resume reviews, mock interviews, and job placement support to land your first tech role.', 'Placement Help')
      ].join('');
      return '<p style="color:#64748b;font-size:1.05rem;margin-bottom:32px;">Everything you need to go from beginner to job-ready developer.</p>'
           + '<div style="display:grid;grid-template-columns:repeat(auto-fit,minmax(260px,1fr));gap:20px;">' + cards + '</div>';
    }
  },

  about: {
    title: 'About Us',
    html: function() {
      var stats = [makeStatBox('2021','Founded'), makeStatBox('50K+','Learners'), makeStatBox('10+','Courses'), makeStatBox('94%','Success Rate')].join('');
      var values = [
        makeValueCard('\uD83C\uDFAF','Practical First','Every lesson connects to a real-world use case.'),
        makeValueCard('\u2764\uFE0F','Student-Centric','Designed around how people actually learn.'),
        makeValueCard('\uD83C\uDF0D','Accessible','Affordable pricing for everyone, everywhere.'),
        makeValueCard('\uD83D\uDEE1\uFE0F','Trusted Credentials','Certificates verified by hiring companies.')
      ].join('');
      var team = [
        makeTeamCard('\uD83D\uDC68\u200D\uD83D\uDCBB','Arjun Mehta','Founder & CEO','Ex-Google engineer, 12 years in EdTech. Passionate about democratising technical education.','linear-gradient(135deg,#1e3a8a,#0f172a)'),
        makeTeamCard('\uD83D\uDC69\u200D\uD83D\uDCBB','Nisha Rao','Head of Curriculum','Former Microsoft engineer & educator. Bridges the gap between theory and industry practice.','linear-gradient(135deg,#4f46e5,#7c3aed)')
      ].join('');
      return '<div style="display:grid;grid-template-columns:1fr 1fr;gap:16px;margin-bottom:32px;">' + stats + '</div>'
           + '<h3 style="color:#1e293b;font-size:1.4rem;margin-bottom:12px;">Built for Learners, By Developers.</h3>'
           + '<p style="color:#64748b;line-height:1.8;margin-bottom:16px;">Knowledge Check was founded with one belief: anyone, anywhere can learn to code \u2014 and prove it. We\'re not just a course platform; we\'re a complete skill validation ecosystem.</p>'
           + '<p style="color:#64748b;line-height:1.8;margin-bottom:28px;">Our curriculum is built by engineers from top tech companies. Assessments mirror real-world challenges you\'ll face on the job \u2014 not memorization tests.</p>'
           + '<h3 style="color:#1e293b;font-size:1.2rem;margin-bottom:16px;">Our Values</h3>'
           + '<div style="display:grid;grid-template-columns:1fr 1fr;gap:14px;margin-bottom:32px;">' + values + '</div>'
           + '<h3 style="color:#1e293b;font-size:1.2rem;margin-bottom:16px;">Meet the Team</h3>' + team;
    }
  },

  contact: {
    title: 'Contact Us',
    html: function() {
      var rows = [
        makeContactRow('\uD83D\uDCCD','Address','Solapur, Maharashtra, India \u2014 413001'),
        makeContactRow('\u2709\uFE0F','Email','support@knowledgecheck.in'),
        makeContactRow('\uD83D\uDCDE','Phone','+91 98765 43210'),
        makeContactRow('\uD83D\uDD50','Support Hours','Mon \u2013 Sat, 9:00 AM \u2013 6:00 PM IST')
      ].join('');
      return '<p style="color:#64748b;font-size:1.05rem;margin-bottom:28px;">Have a question or feedback? We\'d love to hear from you.</p>'
           + '<div style="display:flex;flex-direction:column;gap:14px;margin-bottom:36px;">' + rows + '</div>'
           + '<h3 style="color:#1e293b;font-size:1.2rem;margin-bottom:18px;">Send Us a Message</h3>'
           + '<form action="User_Contact" method="POST" style="display:flex;flex-direction:column;gap:14px;">'
           + '<div style="display:grid;grid-template-columns:1fr 1fr;gap:12px;">'
           + '<div><label style="font-size:0.8rem;font-weight:700;color:#64748b;text-transform:uppercase;letter-spacing:0.4px;display:block;margin-bottom:6px;">Name</label>'
           + '<input type="text" name="name"required placeholder="Your name" style="width:100%;padding:12px 14px;border:2px solid #e2e8f0;border-radius:10px;font-family:\'Plus Jakarta Sans\',sans-serif;font-size:0.92rem;background:#f8fafc;box-sizing:border-box;" onfocus="this.style.borderColor=\'#2563eb\'" onblur="this.style.borderColor=\'#e2e8f0\'"></div>'
           + '<div><label style="font-size:0.8rem;font-weight:700;color:#64748b;text-transform:uppercase;letter-spacing:0.4px;display:block;margin-bottom:6px;">Email</label>'
           + '<input type="email" name="email"required placeholder="you@example.com" style="width:100%;padding:12px 14px;border:2px solid #e2e8f0;border-radius:10px;font-family:\'Plus Jakarta Sans\',sans-serif;font-size:0.92rem;background:#f8fafc;box-sizing:border-box;" onfocus="this.style.borderColor=\'#2563eb\'" onblur="this.style.borderColor=\'#e2e8f0\'"></div>'
           + '</div>'
           + '<div><label style="font-size:0.8rem;font-weight:700;color:#64748b;text-transform:uppercase;letter-spacing:0.4px;display:block;margin-bottom:6px;">Subject</label>'
           + '<input type="text" name="subject" required placeholder="What\'s this about?" style="width:100%;padding:12px 14px;border:2px solid #e2e8f0;border-radius:10px;font-family:\'Plus Jakarta Sans\',sans-serif;font-size:0.92rem;background:#f8fafc;box-sizing:border-box;" onfocus="this.style.borderColor=\'#2563eb\'" onblur="this.style.borderColor=\'#e2e8f0\'"></div>'
           + '<div><label style="font-size:0.8rem;font-weight:700;color:#64748b;text-transform:uppercase;letter-spacing:0.4px;display:block;margin-bottom:6px;">Message</label>'
           + '<textarea name="message"required placeholder="Write your message here..." rows="4" style="width:100%;padding:12px 14px;border:2px solid #e2e8f0;border-radius:10px;font-family:\'Plus Jakarta Sans\',sans-serif;font-size:0.92rem;background:#f8fafc;resize:vertical;box-sizing:border-box;" onfocus="this.style.borderColor=\'#2563eb\'" onblur="this.style.borderColor=\'#e2e8f0\'"></textarea></div>'
           + '<button type="submit" id="panelSendBtn" style="padding:14px;background:linear-gradient(135deg,#2563eb,#4f46e5);color:white;border:none;border-radius:12px;font-size:1rem;font-weight:700;cursor:pointer;font-family:\'Plus Jakarta Sans\',sans-serif;box-shadow:0 8px 20px rgba(37,99,235,0.35);">'
           + '\u2708\uFE0F Send Message</button>'
           + '<div id="panelContactSuccess" style="display:none;padding:16px;background:linear-gradient(135deg,#d1fae5,#a7f3d0);border-radius:12px;color:#065f46;font-weight:700;text-align:center;">'
           + '\u2705 Message sent! We\'ll get back to you within 24 hours.</div>'
           + '</form>';
    }
  }
};

function openPanel(type) {
  var data = panelData[type];
  if (!data) return;
  document.getElementById('panelTitle').textContent = data.title;
  document.getElementById('panelBody').innerHTML = data.html();

  var panel    = document.getElementById('sidePanel');
  var backdrop = document.getElementById('panelBackdrop');

  backdrop.style.display = 'block';
  backdrop.style.opacity = '0';
  setTimeout(function() { backdrop.style.opacity = '1'; }, 10);
  panel.style.right = '0px';
  document.body.style.overflow = 'hidden';
}

function closePanel() {
  var panel    = document.getElementById('sidePanel');
  var backdrop = document.getElementById('panelBackdrop');
  panel.style.right = '-100%';
  backdrop.style.opacity = '0';
  setTimeout(function() { backdrop.style.display = 'none'; }, 400);
  document.body.style.overflow = '';
}

document.addEventListener('keydown', function(e) {
  if (e.key === 'Escape') closePanel();
});

function handlePanelContact(e) {
  e.preventDefault();
  var btn     = document.getElementById('panelSendBtn');
  var success = document.getElementById('panelContactSuccess');
  if (btn)     { btn.textContent = '\u2713 Sent!'; btn.style.background = 'linear-gradient(135deg,#059669,#047857)'; }
  if (success) { success.style.display = 'block'; }
}
</script>
 <script src='script.js'></script>   
</body>
</html>
                            