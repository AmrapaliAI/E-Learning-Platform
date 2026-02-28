<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Courses</title>

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap" rel="stylesheet">

<style>
/* ===================== */
/* GLOBAL STYLES */
/* ===================== */
* {
    box-sizing: border-box;
}

body {
    font-family: 'Poppins', sans-serif;
    background: linear-gradient(rgba(0,0,0,0.55), rgba(0,0,0,0.75)),
                url('data-sciences.jpg') no-repeat center center fixed;
    background-size: cover;
    margin: 0;
    color: #fff;
    text-align: center;
}

/* ===================== */
/* HEADER */
/* ===================== */
#header {
    padding: 25px;
    background: linear-gradient(135deg, #ff9800, #ff5722);
    border-radius: 0 0 30px 30px;
    box-shadow: 0 10px 30px rgba(0,0,0,0.6);
}

/* ===================== */
/* SEARCH BAR */
/* ===================== */
.search-container {
    margin: 30px auto;
    max-width: 600px;
    padding: 0 20px;
}

.search-input {
    width: 100%;
    padding: 16px 24px;
    font-size: 16px;
    border: none;
    border-radius: 50px;
    background: rgba(255,255,255,0.95);
    backdrop-filter: blur(10px);
    box-shadow: 0 8px 32px rgba(255,165,0,0.3);
    outline: none;
    transition: all 0.3s ease;
    font-family: 'Poppins', sans-serif;
}

.search-input:focus {
    transform: translateY(-2px);
    box-shadow: 0 12px 40px rgba(255,165,0,0.5);
    background: rgba(255,255,255,1);
}

.search-input::placeholder {
    color: #666;
}

/* ===================== */
/* CATEGORY LINKS */
/* ===================== */
.course-category-links {
    display: flex;
    justify-content: center;
    gap: 25px;
    margin: 35px 0;
}

.course-category-links a {
    padding: 12px 28px;
    border-radius: 30px;
    background: linear-gradient(135deg, #ffb347, #ffcc33);
    color: #000;
    text-decoration: none;
    font-weight: 600;
    transition: 0.3s ease;
}

.course-category-links a:hover {
    transform: translateY(-3px);
    box-shadow: 0 10px 25px rgba(255,165,0,0.6);
}

/* ===================== */
/* DASHBOARD BUTTON */
/* ===================== */
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

/* ===================== */
/* COURSE SECTION */
/* ===================== */
.courses-container {
    position: relative;
    max-width: 1100px;
    margin: 40px auto;
}

.courses-wrapper,
.courses-wrapper1 {
    display: flex;
    gap: 25px;
    overflow-x: auto;
    scroll-behavior: smooth;
    padding: 25px 10px;
}

.courses-wrapper::-webkit-scrollbar,
.courses-wrapper1::-webkit-scrollbar {
    display: none;
}

/* ===================== */
/* COURSE CARD */
/* ===================== */
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

/* IMAGE */
.card-image img {
    width: 100%;
    height: 160px;
    border-radius: 15px;
    object-fit: cover;
}

/* TITLE */
.course-card p {
    margin: 15px 0;
    font-size: 18px;
    font-weight: 600;
}

/* START BUTTON */
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

/* ===================== */
/* ARROWS */
/* ===================== */
.nav-arrow {
    position: absolute;
    top: 50%;
    transform: translateY(-50%);
    background: rgba(0,0,0,0.7);
    border: none;
    color: white;
    padding: 15px 18px;
    border-radius: 50%;
    font-size: 22px;
    cursor: pointer;
    transition: 0.3s ease;
    z-index: 5;
}

.nav-arrow:hover {
    background: orange;
    transform: translateY(-50%) scale(1.2);
}

.left-arrow { left: -20px; }
.right-arrow { right: -20px; }

/* ===================== */
/* ANIMATIONS */
/* ===================== */
@keyframes fadeIn {
    from { opacity: 0; transform: scale(0.9); }
    to { opacity: 1; transform: scale(1); }
}

/* ===================== */
/* RESPONSIVE */
/* ===================== */
@media(max-width: 768px) {
    .course-category-links {
        flex-direction: column;
    }
    .course-card {
        min-width: 230px;
    }
}
</style>
</head>

<body>

<div id="header">
    <jsp:include page="Header.html" />
</div>

<!-- SEARCH BAR -->
<div class="search-container">
    <input type="text" id="courseSearch" class="search-input" placeholder="&#128269; Search courses... (e.g., Java, Python, JSP)" onkeyup="filterCourses()">
</div>

<div class="course-category-links">
    <a href="Program.html">Programming Courses</a>
    <a href="list4.html">General Knowledge Courses</a>
</div>

<a href="Frame.jsp">
    <button class="start-button-main">Go to Learning Dashboard</button>
</a>

<!-- CAROUSEL 1 -->
<div class="courses-container">
    <button class="nav-arrow left-arrow" onclick="scrollCourses(-350)">&#10094;</button>
    <div class="courses-wrapper">
        <div class="course-card">
            <div class="card-image"><img src="JSP.jpg"></div>
            <p>JSP Fundamental</p>
            <a href="list.html"><button class="start-button">Start</button></a>
        </div>
        <div class="course-card">
            <div class="card-image"><img src="Dot.jpg"></div>
            <p>Dot Net Core</p>
            <a href="list1.html"><button class="start-button">Start</button></a>
        </div>
        <div class="course-card">
            <div class="card-image"><img src="Python.jpg"></div>
            <p>Python</p>
            <a href="list2.html"><button class="start-button">Start</button></a>
        </div><div class="course-card">
            <div class="card-image"><img src="Const.jpg"></div>
            <p>Indian Constitution</p>
            <a href="list4.html"><button class="start-button">Start</button></a>
        </div>
    </div>
    <button class="nav-arrow right-arrow" onclick="scrollCourses(350)">&#10095;</button>
</div>

<!-- CAROUSEL 2 -->
<div class="courses-container">
    <button class="nav-arrow left-arrow" onclick="scrollCourses1(-350)">&#10094;</button>
    <div class="courses-wrapper1">
        <div class="course-card">
            <div class="card-image"><img src="java.jpg"></div>
            <p>Introduction to Java</p>
            <a href="list5.html"><button class="start-button">Start</button></a>
        </div>
        <div class="course-card">
            <div class="card-image"><img src="html.jpg"></div>
            <p>HTML, CSS, JavaScript</p>
            <a href="list6.html"><button class="start-button">Start</button></a>
        </div>
        
        <div class="course-card">
            <div class="card-image"><img src="Dot.jpg"></div>
            <p>Database Management</p>
            <a href="list3.html"><button class="start-button">Start</button></a>
        </div>
    </div>
    <button class="nav-arrow right-arrow" onclick="scrollCourses1(350)">&#10095;</button>
</div>

<script>
function scrollCourses(amount) {
    document.querySelector('.courses-wrapper').scrollLeft += amount;
}
function scrollCourses1(amount) {
    document.querySelector('.courses-wrapper1').scrollLeft += amount;
}

function filterCourses() {
    const searchInput = document.getElementById('courseSearch').value.toLowerCase();
    const allCourses = document.querySelectorAll('.course-card');
    
    allCourses.forEach(card => {
        const courseTitle = card.querySelector('p').textContent.toLowerCase();
        if (courseTitle.includes(searchInput)) {
            card.style.display = 'block';
            card.style.animation = 'fadeIn 0.5s ease';
        } else {
            card.style.display = 'none';
        }
    });
}
</script>

</body>
</html>