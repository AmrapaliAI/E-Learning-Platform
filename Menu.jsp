<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="Conec.Serv" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            padding: 40px 20px;
        }

        .container {
            max-width: 1400px;
            margin: 0 auto;
        }

        .profile-grid {
            display: grid;
            grid-template-columns: 350px 1fr;
            gap: 30px;
            margin-bottom: 30px;
        }

        .profile-card {
            background: rgba(255, 255, 255, 0.98);
            backdrop-filter: blur(10px);
            border-radius: 24px;
            padding: 40px;
            box-shadow: 0 20px 60px rgba(0, 0, 0, 0.3);
            text-align: center;
            transition: transform 0.3s ease;
        }

        .profile-card:hover {
            transform: translateY(-5px);
        }

        .profile-pic-wrapper {
            position: relative;
            width: 200px;
            height: 200px;
            margin: 0 auto 25px;
        }

        .profile-pic {
            width: 100%;
            height: 100%;
            border-radius: 50%;
            border: 6px solid #667eea;
            overflow: hidden;
            box-shadow: 0 15px 40px rgba(102, 126, 234, 0.4);
            transition: all 0.3s ease;
            background: white;
        }

        .profile-pic:hover {
            transform: scale(1.05);
            box-shadow: 0 20px 50px rgba(102, 126, 234, 0.6);
        }

        .profile-pic img {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }

        .camera-btn {
            position: absolute;
            bottom: 15px;
            right: 15px;
            background: linear-gradient(135deg, #667eea, #764ba2);
            width: 50px;
            height: 50px;
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            cursor: pointer;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.3);
            transition: all 0.3s ease;
            border: 3px solid white;
        }

        .camera-btn:hover {
            transform: scale(1.15) rotate(15deg);
            background: linear-gradient(135deg, #764ba2, #667eea);
        }

        .camera-btn i {
            color: white;
            font-size: 20px;
        }

        #fileInput {
            display: none;
        }

        .user-name {
            font-size: 32px;
            font-weight: 700;
            color: #2d3748;
            margin-bottom: 8px;
            background: linear-gradient(135deg, #667eea, #764ba2);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            background-clip: text;
        }

        .user-role {
            color: #718096;
            font-size: 16px;
            font-weight: 500;
            margin-bottom: 25px;
        }

        .profile-stats {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 20px;
            margin-top: 30px;
            padding-top: 30px;
            border-top: 2px solid #e2e8f0;
        }

        .stat-item {
            text-align: center;
        }

        .stat-number {
            font-size: 28px;
            font-weight: 700;
            color: #667eea;
            display: block;
        }

        .stat-label {
            font-size: 13px;
            color: #718096;
            margin-top: 5px;
        }

        .welcome-card {
            background: rgba(255, 255, 255, 0.98);
            backdrop-filter: blur(10px);
            border-radius: 24px;
            padding: 40px;
            box-shadow: 0 20px 60px rgba(0, 0, 0, 0.3);
        }

        .welcome-header {
            font-size: 36px;
            font-weight: 700;
            color: #2d3748;
            margin-bottom: 10px;
        }

        .welcome-text {
            color: #718096;
            font-size: 18px;
            margin-bottom: 30px;
        }

        .quick-actions {
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            gap: 20px;
        }

        .action-card {
            background: linear-gradient(135deg, #f7fafc, #edf2f7);
            padding: 25px;
            border-radius: 16px;
            text-decoration: none;
            color: #2d3748;
            transition: all 0.3s ease;
            border: 2px solid transparent;
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        .action-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 15px 40px rgba(102, 126, 234, 0.3);
            border-color: #667eea;
            background: white;
        }

        .action-icon {
            width: 60px;
            height: 60px;
            background: linear-gradient(135deg, #667eea, #764ba2);
            border-radius: 16px;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 28px;
            color: white;
            transition: all 0.3s ease;
        }

        .action-card:hover .action-icon {
            transform: scale(1.1) rotate(5deg);
        }

        .action-title {
            font-size: 20px;
            font-weight: 700;
            color: #2d3748;
        }

        .action-desc {
            font-size: 14px;
            color: #718096;
            line-height: 1.6;
        }

        .menu-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
            gap: 20px;
            margin-top: 30px;
        }

        .menu-card {
            background: rgba(255, 255, 255, 0.98);
            backdrop-filter: blur(10px);
            border-radius: 20px;
            padding: 30px;
            text-decoration: none;
            color: #2d3748;
            transition: all 0.3s ease;
            display: flex;
            align-items: center;
            gap: 20px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.2);
            border: 2px solid transparent;
        }

        .menu-card:hover {
            transform: translateY(-8px);
            box-shadow: 0 20px 50px rgba(102, 126, 234, 0.4);
            border-color: #667eea;
        }

        .menu-icon {
            width: 70px;
            height: 70px;
            background: linear-gradient(135deg, #667eea, #764ba2);
            border-radius: 18px;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 32px;
            color: white;
            flex-shrink: 0;
            transition: all 0.3s ease;
        }

        .menu-card:hover .menu-icon {
            transform: scale(1.15) rotate(10deg);
        }

        .menu-content h3 {
            font-size: 20px;
            font-weight: 700;
            margin-bottom: 8px;
            color: #2d3748;
        }

        .menu-content p {
            font-size: 14px;
            color: #718096;
        }

        .logout-card {
            background: linear-gradient(135deg, #f56565, #e53e3e);
            color: white;
        }

        .logout-card .menu-icon {
            background: rgba(255, 255, 255, 0.2);
        }

        .logout-card h3,
        .logout-card p {
            color: white;
        }

        .logout-card:hover {
            background: linear-gradient(135deg, #e53e3e, #c53030);
            border-color: white;
        }

        @media (max-width: 1024px) {
            .profile-grid {
                grid-template-columns: 1fr;
            }

            .quick-actions {
                grid-template-columns: 1fr;
            }
        }

        @media (max-width: 768px) {
            .menu-grid {
                grid-template-columns: 1fr;
            }

            .profile-stats {
                grid-template-columns: 1fr;
                gap: 15px;
            }
        }
    </style>
</head>
<body>
    <%
    String user = (String)session.getAttribute("User");
    String userName = "";
    
    try {
        Connection conn = Serv.get();
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM UserData");
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()) {
            if(rs.getString(3).equals(user)) {
                userName = rs.getString(1);
                break;
            }
        }
        
        rs.close();
        pstmt.close();
    } catch(Exception e) {
        out.println("Error: " + e.getMessage());
    }
    %>

    <div class="container">
        <div class="profile-grid">
            <!-- Profile Card -->
            <div class="profile-card">
                <div class="profile-pic-wrapper">
                    <div class="profile-pic">
                        <img id="profileImage" src="Ashoka.jpg" alt="Profile Picture">
                    </div>
                    <label for="fileInput" class="camera-btn">
                        <i class="fas fa-camera"></i>
                    </label>
                    <input type="file" id="fileInput" accept="image/*">
                </div>
                
                <h2 class="user-name"><%= userName %></h2>
                <p class="user-role">Data Science Student</p>
                
                <div class="profile-stats">
                    <div class="stat-item">
                        <span class="stat-number">12</span>
                        <span class="stat-label">Courses</span>
                    </div>
                    <div class="stat-item">
                        <span class="stat-number">8</span>
                        <span class="stat-label">Completed</span>
                    </div>
                    <div class="stat-item">
                        <span class="stat-number">5</span>
                        <span class="stat-label">Certificates</span>
                    </div>
                </div>
            </div>

            <!-- Welcome Card -->
            <div class="welcome-card">
                <h1 class="welcome-header">Welcome Back, <%= userName %>!</h1>
                <p class="welcome-text">Continue your learning journey and achieve your goals</p>
                
                <div class="quick-actions">
                    <a href="UserProfile.jsp" class="action-card">
                        <div class="action-icon">
                            <i class="fas fa-user-circle"></i>
                        </div>
                        <div>
                            <div class="action-title">My Profile</div>
                            <p class="action-desc">View and edit your personal information and preferences</p>
                        </div>
                    </a>
                    
                    <a href="Completed.jsp" class="action-card">
                        <div class="action-icon">
                            <i class="fas fa-graduation-cap"></i>
                        </div>
                        <div>
                            <div class="action-title">Completed Courses</div>
                            <p class="action-desc">Review your completed courses and achievements</p>
                        </div>
                    </a>
                    
                    <a href="#" class="action-card">
                        <div class="action-icon">
                            <i class="fas fa-book-reader"></i>
                        </div>
                        <div>
                            <div class="action-title">Continue Learning</div>
                            <p class="action-desc">Pick up where you left off in your current courses</p>
                        </div>
                    </a>
                    
                    <a href="#" class="action-card">
                        <div class="action-icon">
                            <i class="fas fa-certificate"></i>
                        </div>
                        <div>
                            <div class="action-title">Certificates</div>
                            <p class="action-desc">Download and share your earned certificates</p>
                        </div>
                    </a>
                </div>
            </div>
        </div>
        
        

        <!-- Menu Cards -->
        <div class="menu-grid">
            <a href="UserProfile.jsp" class="menu-card">
                <div class="menu-icon">
                    <i class="fas fa-user"></i>
                </div>
                <div class="menu-content">
                    <h3>Account Settings</h3>
                    <p>Manage your account details and preferences</p>
                </div>
            </a>

            <a href="Completed.jsp" class="menu-card">
                <div class="menu-icon">
                    <i class="fas fa-check-circle"></i>
                </div>
                <div class="menu-content">
                    <h3>Completed Courses</h3>
                    <p>View all your completed courses and progress</p>
                </div>
            </a>

            <a href="#" class="menu-card">
                <div class="menu-icon">
                    <i class="fas fa-book"></i>
                </div>
                <div class="menu-content">
                    <h3>My Courses</h3>
                    <p>Access your enrolled and ongoing courses</p>
                </div>
            </a>

            <a href="#" class="menu-card">
                <div class="menu-icon">
                    <i class="fas fa-trophy"></i>
                </div>
                <div class="menu-content">
                    <h3>Achievements</h3>
                    <p>View your badges and certifications</p>
                </div>
            </a>

            <a href="#" class="menu-card">
                <div class="menu-icon">
                    <i class="fas fa-calendar-alt"></i>
                </div>
                <div class="menu-content">
                    <h3>Schedule</h3>
                    <p>Manage your learning schedule and deadlines</p>
                </div>
            </a>

            <a href="#" class="menu-card">
                <div class="menu-icon">
                    <i class="fas fa-cog"></i>
                </div>
                <div class="menu-content">
                    <h3>Settings</h3>
                    <p>Customize your learning experience</p>
                </div>
            </a>

            <a href="index1.jsp" class="menu-card logout-card">
                <div class="menu-icon">
                    <i class="fas fa-sign-out-alt"></i>
                </div>
                <div class="menu-content">
                    <h3>Log Out</h3>
                    <p>Sign out from your account securely</p>
                </div>
            </a>
        </div>
    </div>

    <script>
        const fileInput = document.getElementById('fileInput');
        const profileImage = document.getElementById('profileImage');

        fileInput.addEventListener('change', function(e) {
            if(this.files && this.files[0]) {
                const reader = new FileReader();
                
                reader.onload = function(e) {
                    profileImage.src = e.target.result;
                };
                
                reader.readAsDataURL(this.files[0]);
            }
        });
    </script>
</body>
</html>