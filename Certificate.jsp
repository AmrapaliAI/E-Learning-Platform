<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Certificate of Achievement</title>
<link href="https://fonts.googleapis.com/css2?family=Great+Vibes&family=Playfair+Display:wght@400;700;900&family=Montserrat:wght@300;400;600;700&display=swap" rel="stylesheet">
<style>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: 'Montserrat', sans-serif;
    background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
    min-height: 100vh;
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 40px 20px;
    position: relative;
    overflow-x: hidden;
}

/* Animated Background Particles */
body::before {
    content: '';
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-image: 
        radial-gradient(circle at 20% 50%, rgba(255, 255, 255, 0.1) 1px, transparent 1px),
        radial-gradient(circle at 80% 80%, rgba(255, 255, 255, 0.1) 1px, transparent 1px);
    background-size: 50px 50px;
    animation: float 20s linear infinite;
    z-index: 0;
}

@keyframes float {
    from { background-position: 0 0; }
    to { background-position: 50px 50px; }
}

/* Top Navigation Bar */
.top-nav {
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    background: rgba(15, 23, 42, 0.95);
    backdrop-filter: blur(20px);
    padding: 20px 40px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    z-index: 1000;
    box-shadow: 0 4px 20px rgba(0, 0, 0, 0.3);
    animation: slideDown 0.6s ease-out;
}

@keyframes slideDown {
    from { transform: translateY(-100px); opacity: 0; }
    to { transform: translateY(0); opacity: 1; }
}

.nav-btn {
    padding: 12px 30px;
    background: linear-gradient(135deg, #667eea, #764ba2);
    color: white;
    text-decoration: none;
    border-radius: 50px;
    font-weight: 600;
    font-size: 16px;
    transition: all 0.3s ease;
    box-shadow: 0 4px 15px rgba(102, 126, 234, 0.4);
    display: inline-flex;
    align-items: center;
    gap: 10px;
}

.nav-btn:hover {
    transform: translateY(-3px);
    box-shadow: 0 8px 25px rgba(102, 126, 234, 0.6);
}

.nav-btn.download {
    background: linear-gradient(135deg, #f59e0b, #d97706);
    box-shadow: 0 4px 15px rgba(245, 158, 11, 0.4);
}

.nav-btn.download:hover {
    box-shadow: 0 8px 25px rgba(245, 158, 11, 0.6);
}

/* Certificate Container */
.certificate-wrapper {
    margin-top: 120px;
    perspective: 1500px;
    z-index: 1;
    animation: fadeInScale 1s ease-out;
}

@keyframes fadeInScale {
    from {
        opacity: 0;
        transform: scale(0.8) translateY(50px);
    }
    to {
        opacity: 1;
        transform: scale(1) translateY(0);
    }
}

.certificate-container {
    width: 900px;
    background: white;
    padding: 60px;
    border-radius: 30px;
    box-shadow: 
        0 50px 100px rgba(0, 0, 0, 0.4),
        0 0 0 15px rgba(255, 255, 255, 0.1),
        0 0 0 30px rgba(255, 255, 255, 0.05);
    position: relative;
    overflow: hidden;
    transition: transform 0.3s ease;
}

.certificate-container:hover {
    transform: translateY(-10px);
}

/* Decorative Border */
.certificate-border {
    position: absolute;
    top: 30px;
    left: 30px;
    right: 30px;
    bottom: 30px;
    border: 4px solid transparent;
    border-image: linear-gradient(135deg, #f59e0b, #667eea, #10b981, #f59e0b) 1;
    border-radius: 20px;
    pointer-events: none;
}

/* Corner Decorations */
.corner-decoration {
    position: absolute;
    width: 120px;
    height: 120px;
    background: linear-gradient(135deg, #f59e0b, #d97706);
    opacity: 0.15;
}

.corner-decoration.top-left {
    top: 0;
    left: 0;
    border-radius: 0 0 100% 0;
}

.corner-decoration.top-right {
    top: 0;
    right: 0;
    border-radius: 0 0 0 100%;
}

.corner-decoration.bottom-left {
    bottom: 0;
    left: 0;
    border-radius: 0 100% 0 0;
}

.corner-decoration.bottom-right {
    bottom: 0;
    right: 0;
    border-radius: 100% 0 0 0;
}

/* Logo Section */
.logo-section {
    text-align: center;
    margin-bottom: 20px;
    animation: fadeIn 1s ease-out 0.3s backwards;
}

.logo {
    width: 120px;
    height: 120px;
    object-fit: contain;
    border-radius: 20px;
    box-shadow: 0 10px 30px rgba(0, 0, 0, 0.2);
    margin-bottom: 15px;
    transition: transform 0.3s ease;
}

.logo:hover {
    transform: rotate(5deg) scale(1.1);
}

.org-name {
    font-size: 24px;
    font-weight: 700;
    background: linear-gradient(135deg, #667eea, #764ba2);
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
    background-clip: text;
    letter-spacing: 2px;
    margin-bottom: 30px;
}

/* Certificate Title */
.certificate-title {
    text-align: center;
    margin-bottom: 40px;
    animation: fadeIn 1s ease-out 0.5s backwards;
}

.title-main {
    font-family: 'Playfair Display', serif;
    font-size: 48px;
    font-weight: 900;
    background: linear-gradient(135deg, #2563eb, #7c3aed);
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
    background-clip: text;
    letter-spacing: 3px;
    margin-bottom: 10px;
    text-transform: uppercase;
}

.title-subtitle {
    font-size: 18px;
    color: #64748b;
    font-weight: 300;
    letter-spacing: 4px;
    text-transform: uppercase;
}

/* Award Section */
.award-section {
    text-align: center;
    margin-bottom: 40px;
    animation: fadeIn 1s ease-out 0.7s backwards;
}

.award-text {
    font-size: 20px;
    color: #475569;
    margin-bottom: 25px;
    font-weight: 300;
    letter-spacing: 1px;
}

.student-name {
    font-family: 'Great Vibes', cursive;
    font-size: 72px;
    background: linear-gradient(135deg, #ec4899, #f59e0b);
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
    background-clip: text;
    margin: 30px 0;
    line-height: 1.2;
    animation: glow 2s ease-in-out infinite alternate;
}

@keyframes glow {
    from {
        filter: drop-shadow(0 0 5px rgba(236, 72, 153, 0.3));
    }
    to {
        filter: drop-shadow(0 0 20px rgba(236, 72, 153, 0.6));
    }
}

/* Achievement Details */
.achievement-details {
    text-align: center;
    margin: 40px 0;
    padding: 30px;
    background: linear-gradient(135deg, #f0f9ff, #fef3c7);
    border-radius: 20px;
    border: 3px solid #e0e7ff;
    animation: fadeIn 1s ease-out 0.9s backwards;
}

.achievement-text {
    font-size: 18px;
    color: #1e293b;
    line-height: 1.8;
    font-weight: 500;
}

.course-name {
    font-weight: 700;
    font-size: 24px;
    background: linear-gradient(135deg, #667eea, #764ba2);
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
    background-clip: text;
    margin: 15px 0;
    display: block;
}

/* Success Badge */
.success-badge {
    display: inline-block;
    background: linear-gradient(135deg, #10b981, #059669);
    color: white;
    padding: 12px 30px;
    border-radius: 50px;
    font-weight: 700;
    font-size: 16px;
    margin-top: 20px;
    box-shadow: 0 8px 20px rgba(16, 185, 129, 0.4);
    animation: bounce 2s ease-in-out infinite;
}

@keyframes bounce {
    0%, 100% { transform: translateY(0); }
    50% { transform: translateY(-10px); }
}

/* Footer Section */
.certificate-footer {
    display: flex;
    justify-content: space-between;
    align-items: flex-end;
    margin-top: 60px;
    padding-top: 40px;
    border-top: 3px solid #e2e8f0;
    animation: fadeIn 1s ease-out 1.1s backwards;
}

.footer-item {
    text-align: center;
    flex: 1;
}

.footer-label {
    font-size: 14px;
    color: #64748b;
    font-weight: 600;
    text-transform: uppercase;
    letter-spacing: 1px;
    margin-bottom: 10px;
}

.footer-value {
    font-size: 18px;
    color: #0f172a;
    font-weight: 700;
}

.signature-line {
    width: 200px;
    height: 2px;
    background: linear-gradient(90deg, transparent, #667eea, transparent);
    margin: 15px auto 10px;
}

/* Seal/Stamp */
.certificate-seal {
    position: absolute;
    bottom: 80px;
    right: 80px;
    width: 120px;
    height: 120px;
    background: linear-gradient(135deg, #f59e0b, #d97706);
    border-radius: 50%;
    display: flex;
    align-items: center;
    justify-content: center;
    color: white;
    font-weight: 800;
    font-size: 16px;
    text-align: center;
    line-height: 1.3;
    box-shadow: 0 10px 30px rgba(245, 158, 11, 0.4);
    border: 5px solid white;
    transform: rotate(-15deg);
    animation: sealPop 1s ease-out 1.3s backwards;
}

@keyframes sealPop {
    0% {
        transform: rotate(-15deg) scale(0);
        opacity: 0;
    }
    50% {
        transform: rotate(-15deg) scale(1.2);
    }
    100% {
        transform: rotate(-15deg) scale(1);
        opacity: 1;
    }
}

@keyframes fadeIn {
    from { opacity: 0; transform: translateY(20px); }
    to { opacity: 1; transform: translateY(0); }
}

/* Responsive Design */
@media (max-width: 1024px) {
    .certificate-container {
        width: 95%;
        padding: 40px 30px;
    }
    
    .title-main {
        font-size: 36px;
    }
    
    .student-name {
        font-size: 56px;
    }
    
    .certificate-seal {
        width: 100px;
        height: 100px;
        font-size: 14px;
        bottom: 60px;
        right: 60px;
    }
}

@media (max-width: 768px) {
    .top-nav {
        flex-direction: column;
        gap: 15px;
        padding: 20px;
    }
    
    .certificate-wrapper {
        margin-top: 180px;
    }
    
    .certificate-footer {
        flex-direction: column;
        gap: 30px;
    }
}
</style>
</head>
<body>

<%@page import="java.sql.*"%>
<%@page import="Conec.Serv" %>
<%
String user = (String)session.getAttribute("User");
String u = "";
Connection C = Serv.get();
PreparedStatement P = C.prepareStatement("SELECT * FROM UserData WHERE email = ?");
P.setString(1, user);
ResultSet R = P.executeQuery();

if(R.next()) {
    u = R.getString(1);
}
application.setAttribute("Name", u);

CallableStatement I = C.prepareCall("{call Data(?,?)}");
I.setString(1, u);
I.setString(2, user);

R.close();
P.close();
C.close();

String courseName = (String) application.getAttribute("A");
ServletContext U = request.getServletContext();
String completionDate = (String) U.getAttribute("time");
%>

<!-- Top Navigation -->
<div class="top-nav">
    <a href="Frame.jsp" class="nav-btn">
        <svg width="20" height="20" fill="currentColor" viewBox="0 0 20 20">
            <path d="M10.707 2.293a1 1 0 00-1.414 0l-7 7a1 1 0 001.414 1.414L4 10.414V17a1 1 0 001 1h2a1 1 0 001-1v-2a1 1 0 011-1h2a1 1 0 011 1v2a1 1 0 001 1h2a1 1 0 001-1v-6.586l.293.293a1 1 0 001.414-1.414l-7-7z"/>
        </svg>
        Go to Main Page
    </a>
    
    <a href="Down" class="nav-btn download">
        <svg width="20" height="20" fill="currentColor" viewBox="0 0 20 20">
            <path fill-rule="evenodd" d="M3 17a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zm3.293-7.707a1 1 0 011.414 0L9 10.586V3a1 1 0 112 0v7.586l1.293-1.293a1 1 0 111.414 1.414l-3 3a1 1 0 01-1.414 0l-3-3a1 1 0 010-1.414z" clip-rule="evenodd"/>
        </svg>
        Download Certificate
    </a>
</div>

<!-- Certificate -->
<div class="certificate-wrapper">
    <div class="certificate-container">
        <!-- Decorative Border -->
        <div class="certificate-border"></div>
        
        <!-- Corner Decorations -->
        <div class="corner-decoration top-left"></div>
        <div class="corner-decoration top-right"></div>
        <div class="corner-decoration bottom-left"></div>
        <div class="corner-decoration bottom-right"></div>
        
        <!-- Logo Section -->
        <div class="logo-section">
            <img src="logoCheck.jpg" alt="Logo" class="logo">
            <div class="org-name">KNOWLEDGE CHECK DEMONSTRATION</div>
        </div>
        
        <!-- Certificate Title -->
        <div class="certificate-title">
            <h1 class="title-main">Certificate of Achievement</h1>
            <p class="title-subtitle">Excellence in Learning</p>
        </div>
        
        <!-- Award Section -->
        <div class="award-section">
            <p class="award-text">This certificate is proudly presented to</p>
            <h2 class="student-name"><%= u %></h2>
        </div>
        
        <!-- Achievement Details -->
        <div class="achievement-details">
            <p class="achievement-text">
                For successfully completing the comprehensive assessment in
                <span class="course-name"><%= courseName %></span>
                with an outstanding score, demonstrating exceptional knowledge and dedication to learning.
            </p>
            <div class="success-badge">
               OUTSTANDING ACHIEVEMENT ⭐
            </div>
        </div>
        
        <!-- Footer -->
        <div class="certificate-footer">
            <div class="footer-item">
                <div class="footer-label">Date of Completion</div>
                <div class="signature-line"></div>
                <div class="footer-value"><%= completionDate %></div>
            </div>
            
            <div class="footer-item">
                <div class="footer-label">Authorized Signature</div>
                <div class="signature-line"></div>
                <div class="footer-value">Program Director</div>
            </div>
        </div>
        
        <!-- Certificate Seal -->
        <div class="certificate-seal">
            VERIFIED<br>AUTHENTIC
        </div>
    </div>
</div>

</body>
</html>