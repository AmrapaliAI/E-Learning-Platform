<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Courses</title>

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap" rel="stylesheet">

<style>
* { box-sizing: border-box; }

body {
    font-family: 'Poppins', sans-serif;
    background: linear-gradient(rgba(0,0,0,0.55), rgba(0,0,0,0.75)),
                url('data-sciences.jpg') no-repeat center center fixed;
    background-size: cover;
    margin: 0;
    color: #fff;
    text-align: center;
}

#header {
    padding: 25px;
    background: linear-gradient(135deg, #ff9800, #ff5722);
    border-radius: 0 0 30px 30px;
    box-shadow: 0 10px 30px rgba(0,0,0,0.6);
}

.start-button-main {
    margin-bottom: 30px;
    background: linear-gradient(135deg, #2196f3, #00c6ff);
    padding: 14px 34px;
    border: none;
    border-radius: 30px;
    color: #fff;
    font-size: 18px;
    cursor: pointer;
    font-weight: 600;
    transition: 0.3s;
}

.start-button-main:hover {
    transform: scale(1.05);
    box-shadow: 0 10px 30px rgba(0,198,255,0.6);
}

.courses-container {
    position: relative;
    max-width: 1100px;
    margin: 40px auto;
}

.courses-wrapper {
    display: flex;
    gap: 25px;
    overflow-x: auto;
    scroll-behavior: smooth;
    padding: 25px 10px;
}

.courses-wrapper::-webkit-scrollbar { display: none; }

.course-card {
    min-width: 280px;
    background: rgba(255,255,255,0.12);
    backdrop-filter: blur(12px);
    border-radius: 20px;
    padding: 18px;
    box-shadow: 0 15px 35px rgba(0,0,0,0.6);
    transition: all 0.4s ease;
}

.course-card:hover {
    transform: translateY(-12px) scale(1.06);
    box-shadow: 0 25px 50px rgba(255,165,0,0.6);
}

.card-image img {
    width: 100%;
    height: 160px;
    border-radius: 15px;
    object-fit: cover;
}

.course-card p {
    margin: 15px 0;
    font-size: 18px;
    font-weight: 600;
}

.start-button {
    background: linear-gradient(135deg, #4caf50, #2e7d32);
    border: none;
    padding: 10px 26px;
    border-radius: 25px;
    color: #fff;
    font-weight: bold;
    cursor: pointer;
    transition: 0.3s ease;
}

.start-button:hover {
    background: linear-gradient(135deg, #66bb6a, #43a047);
    box-shadow: 0 10px 25px rgba(76,175,80,0.6);
}
</style>
</head>

<body>

<div id="header">
    <jsp:include page="Header.html" />
</div>

<a href="Frame.jsp">
    <button class="start-button-main">Go to Learning Dashboard</button>
</a>

<!-- PREMIUM COURSE: ARTIFICIAL INTELLIGENCE -->
<div class="courses-container">
    <div class="courses-wrapper">
        <div class="course-card">
            <div class="card-image"><img src="AI.jpg" alt="Artificial Intelligence"></div>
            <p>Artificial Intelligence</p>
            <a href="list7.html"><button class="start-button">Start</button></a>
        </div>
    </div>
</div>

</body>
</html>
