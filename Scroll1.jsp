<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Courses - Learning Platform</title>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap" rel="stylesheet">
<Style>
/* --- Global Styles --- */
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: 'Poppins', sans-serif;
    background: linear-gradient(rgba(0,0,0,0.65), rgba(0,0,0,0.80)),
                url("data-sciences.jpg") no-repeat center center fixed;
    background-size: cover;
    color: #fff;
}

/* --- Header Enhancement --- */
#header {
    background: linear-gradient(135deg, #FF6B35, #FF8C42, #FFA500);
    padding: 20px;
    box-shadow: 0 10px 40px rgba(255, 107, 53, 0.5);
    border-radius: 0 0 30px 30px;
    animation: slideDown 0.6s ease;
}

@keyframes slideDown {
    from { transform: translateY(-100%); opacity: 0; }
    to { transform: translateY(0); opacity: 1; }
}

/* --- Navigation Bar Enhancement --- */
.nav-bar {
    background: linear-gradient(135deg, #FF8C00, #FFA500, #FFB84D);
    padding: 15px;
    margin: 30px auto;
    max-width: 800px;
    border-radius: 50px;
    box-shadow: 0 10px 40px rgba(255, 140, 0, 0.6);
    display: flex;
    justify-content: center;
    gap: 20px;
    animation: fadeInUp 0.8s ease 0.2s both;
}

@keyframes fadeInUp {
    from { transform: translateY(50px); opacity: 0; }
    to { transform: translateY(0); opacity: 1; }
}

.nav-bar a {
    background: rgba(255, 255, 255, 0.2);
    backdrop-filter: blur(10px);
    padding: 12px 30px;
    border-radius: 30px;
    text-decoration: none;
    color: white;
    font-weight: 600;
    font-size: 17px;
    transition: all 0.3s ease;
    border: 2px solid transparent;
}

.nav-bar a:hover {
    background: rgba(255, 255, 255, 0.95);
    color: #FF6B35;
    transform: translateY(-3px);
    border-color: white;
    box-shadow: 0 10px 30px rgba(255, 255, 255, 0.4);
}

/* --- SUPER ATTRACTIVE SEARCH BAR --- */
.search-container {
    max-width: 700px;
    margin: 40px auto 30px;
    padding: 0 20px;
    text-align: center;
    animation: fadeInUp 0.8s ease 0.4s both;
}

.search-wrapper {
    position: relative;
    display: inline-block;
    width: 100%;
}

.search-input {
    width: 100%;
    padding: 20px 60px 20px 60px;
    font-size: 17px;
    border: 3px solid transparent;
    border-radius: 60px;
    background: linear-gradient(135deg, rgba(255, 255, 255, 0.95), rgba(255, 255, 255, 1));
    box-shadow: 0 15px 50px rgba(255, 140, 0, 0.5),
                inset 0 2px 10px rgba(255, 140, 0, 0.1);
    outline: none;
    transition: all 0.4s ease;
    font-family: 'Poppins', sans-serif;
    font-weight: 500;
}

.search-input:focus {
    transform: translateY(-5px) scale(1.02);
    box-shadow: 0 20px 60px rgba(255, 140, 0, 0.7),
                0 0 0 5px rgba(255, 140, 0, 0.2),
                inset 0 2px 10px rgba(255, 140, 0, 0.2);
    border-color: #FF8C00;
}

.search-input::placeholder {
    color: #888;
    font-weight: 400;
}

.search-icon {
    position: absolute;
    left: 25px;
    top: 50%;
    transform: translateY(-50%);
    font-size: 24px;
    color: #FF8C00;
    pointer-events: none;
    transition: all 0.3s ease;
}

.search-input:focus + .search-icon {
    color: #FF6B35;
    transform: translateY(-50%) scale(1.2);
}

.clear-search {
    position: absolute;
    right: 25px;
    top: 50%;
    transform: translateY(-50%);
    background: linear-gradient(135deg, #FF6B35, #FF8C42);
    color: white;
    border: none;
    width: 32px;
    height: 32px;
    border-radius: 50%;
    font-size: 18px;
    cursor: pointer;
    opacity: 0;
    transition: all 0.3s ease;
    display: flex;
    align-items: center;
    justify-content: center;
}

.clear-search.visible {
    opacity: 1;
}

.clear-search:hover {
    transform: translateY(-50%) scale(1.15) rotate(90deg);
    box-shadow: 0 5px 15px rgba(255, 107, 53, 0.5);
}

/* --- Course Container --- */
.courses-container {
    position: relative;
    max-width: 1100px;
    margin: 50px auto;
    animation: fadeInUp 0.8s ease 0.6s both;
}

.courses-wrapper,
.courses-wrapper1 {
    display: flex;
    white-space: nowrap; 
    overflow-x: scroll;
    -ms-overflow-style: none;
    scrollbar-width: none;
    padding: 25px 10px;
    scroll-behavior: smooth;
    gap: 25px;
}

.courses-wrapper::-webkit-scrollbar,
.courses-wrapper1::-webkit-scrollbar {
    display: none;
}

/* --- ENHANCED COURSE CARD --- */
.course-card {
    flex-shrink: 0; 
    width: 320px; 
    border-radius: 25px;
    padding: 20px;
    text-align: center;
    background: linear-gradient(135deg, rgba(255, 255, 255, 0.15), rgba(255, 255, 255, 0.08));
    backdrop-filter: blur(15px);
    border: 2px solid rgba(255, 255, 255, 0.2);
    box-shadow: 0 15px 45px rgba(0, 0, 0, 0.5);
    cursor: pointer;
    transition: all 0.5s cubic-bezier(0.34, 1.56, 0.64, 1);
    position: relative;
    overflow: hidden;
}

.course-card::before {
    content: '';
    position: absolute;
    top: -50%;
    left: -50%;
    width: 200%;
    height: 200%;
    background: linear-gradient(45deg, transparent, rgba(255, 255, 255, 0.1), transparent);
    transform: rotate(45deg);
    transition: all 0.5s ease;
}

.course-card:hover::before {
    left: 100%;
}

.course-card:hover {
    transform: translateY(-15px) scale(1.05);
    box-shadow: 0 25px 60px rgba(255, 140, 0, 0.6),
                0 0 30px rgba(255, 140, 0, 0.3);
    border-color: rgba(255, 200, 100, 0.5);
}

.card-image {
    height: 180px;
    margin-bottom: 15px;
    border-radius: 20px;
    overflow: hidden;
    box-shadow: 0 10px 30px rgba(0, 0, 0, 0.4);
    position: relative;
}

.card-image img {
    width: 100%;
    height: 100%;
    object-fit: cover;
    transition: transform 0.5s ease;
}

.course-card:hover .card-image img {
    transform: scale(1.15) rotate(2deg);
}

.course-card p {
    margin: 20px 0;
    font-size: 19px;
    font-weight: 600;
    color: #fff;
    text-shadow: 0 2px 10px rgba(0, 0, 0, 0.5);
    min-height: 50px;
    display: flex;
    align-items: center;
    justify-content: center;
}

.start-button {
    background: linear-gradient(135deg, #4CAF50, #45a049, #66BB6A);
    color: white;
    padding: 14px 35px;
    border: none;
    border-radius: 30px;
    cursor: pointer;
    font-weight: 700;
    font-size: 16px;
    transition: all 0.4s ease;
    box-shadow: 0 8px 25px rgba(76, 175, 80, 0.4);
    text-transform: uppercase;
    letter-spacing: 1px;
}

.start-button:hover {
    background: linear-gradient(135deg, #66BB6A, #4CAF50);
    transform: translateY(-3px);
    box-shadow: 0 12px 35px rgba(76, 175, 80, 0.6);
}

.start-button:active {
    transform: translateY(-1px);
}

/* --- ENHANCED NAVIGATION ARROWS --- */
.nav-arrow {
    position: absolute;
    top: 50%;
    transform: translateY(-50%);
    background: linear-gradient(135deg, rgba(255, 107, 53, 0.9), rgba(255, 140, 0, 0.9));
    backdrop-filter: blur(10px);
    color: white;
    border: 2px solid rgba(255, 255, 255, 0.3);
    padding: 18px 14px;
    cursor: pointer;
    z-index: 10;
    font-size: 22px;
    line-height: 1;
    border-radius: 50%;
    box-shadow: 0 10px 30px rgba(255, 107, 53, 0.5);
    transition: all 0.4s ease;
}

.nav-arrow:hover {
    background: linear-gradient(135deg, rgba(255, 140, 0, 1), rgba(255, 165, 0, 1));
    transform: translateY(-50%) scale(1.25);
    box-shadow: 0 15px 40px rgba(255, 140, 0, 0.7);
}

.nav-arrow:active {
    transform: translateY(-50%) scale(1.15);
}

.left-arrow { left: -25px; }
.right-arrow { right: -25px; }

/* --- Animation Keyframes --- */
@keyframes fadeIn {
    from { 
        opacity: 0; 
        transform: scale(0.8) translateY(20px); 
    }
    to { 
        opacity: 1; 
        transform: scale(1) translateY(0); 
    }
}

@keyframes pulse {
    0%, 100% { transform: scale(1); }
    50% { transform: scale(1.05); }
}

/* --- No Results Message --- */
.no-results {
    text-align: center;
    padding: 60px 20px;
    color: #fff;
    font-size: 24px;
    font-weight: 600;
    text-shadow: 0 2px 10px rgba(0, 0, 0, 0.5);
    display: none;
    animation: fadeInUp 0.5s ease;
}

/* --- Responsive Design --- */
@media(max-width: 768px) {
    .nav-bar {
        flex-direction: column;
        gap: 10px;
        padding: 15px 20px;
    }
    
    .course-card {
        width: 280px;
    }
    
    .search-input {
        padding: 18px 50px;
        font-size: 15px;
    }
    
    .nav-arrow {
        padding: 15px 12px;
        font-size: 18px;
    }
}

@media(max-width: 480px) {
    .course-card {
        width: 250px;
    }
}
</Style>
</head>
<body>

<div id="header">
    <jsp:include page="Header.html" />
</div>

<!-- ENHANCED NAVIGATION BAR -->
<div class="nav-bar">
    <a href="Program.html">&#128218; Programming Courses</a>
    <a href="General.html"> &#127757; General Knowledge</a>
</div>

<!-- SUPER ATTRACTIVE SEARCH BAR -->
<div class="search-container">
    <div class="search-wrapper">
        <input type="text" id="courseSearch" class="search-input" placeholder="Search for courses... (Java, Python, AI, Database)" onkeyup="filterCourses()" oninput="toggleClearButton()">
        <span class="search-icon">&#128269;</span>
        <button class="clear-search" id="clearBtn" onclick="clearSearch()">&#10005;</button>
    </div>
</div>

<!-- No Results Message -->
<div class="no-results" id="noResults">
  &#128269; No courses found. Try searching for Java, Python, HTML, AI, or Database.
</div>

<!-- CAROUSEL 1 -->
<div class="courses-container">
    <button class="nav-arrow left-arrow" onclick="scrollCourses(-350)">&#9664;</button>
    <div class="courses-wrapper">
        <div class="course-card">
            <div class="card-image">
                <img src="JSP.jpg" alt="JSP Course">
            </div>
            <p>JSP Fundamental</p>
            <a href="inde.jsp" style="text-decoration:none;">
                <button class="start-button">Start Course</button>
            </a>
        </div>
        
        <div class="course-card">
            <div class="card-image">
                <img src="Dot.jpg" alt="Dot Net Course">
            </div>
            <p>Dot Net Core</p>
            <a href="inde.jsp" style="text-decoration:none;">
                <button class="start-button">Start Course</button>
            </a>
        </div>
        
        <div class="course-card">
            <div class="card-image">
                <img src="Python.jpg" alt="Python Course">
            </div>
            <p>Python</p>
            <a href="inde.jsp" style="text-decoration:none;">
                <button class="start-button">Start Course</button>
            </a>
        </div>

        <div class="course-card">
            <div class="card-image">
                <img src="Copilot_20251122_174444.png" alt="Database Course">
            </div>
            <p>Database Management System</p>
            <a href="inde.jsp" style="text-decoration:none;">
                <button class="start-button">Start Course</button>
            </a>
        </div>
        
        <div class="course-card">
            <div class="card-image">
                <img src="Const.jpg" alt="Constitution Course">
            </div>
            <p>Indian Constitution</p>
            <a href="inde.jsp" style="text-decoration:none;">
                <button class="start-button">Start Course</button>
            </a>
        </div>
    </div>
    <button class="nav-arrow right-arrow" onclick="scrollCourses(350)">&#9654;</button>
</div>

<!-- CAROUSEL 2 -->
<div class="courses-container">
    <button class="nav-arrow left-arrow" onclick="scrollCourses1(-350)">&#9664;</button>
    <div class="courses-wrapper1">
        <div class="course-card">
            <div class="card-image">
                <img src="java.jpg" alt="Java Course">
            </div>
            <p>Introduction to Java</p>
            <a href="inde.jsp" style="text-decoration:none;">
                <button class="start-button">Start Course</button>
            </a>
        </div>
        
        <div class="course-card">
            <div class="card-image">
                <img src="html.jpg" alt="Web Development Course">
            </div>
            <p>Introduction to HTML, CSS, JavaScript</p>
            <a href="inde.jsp" style="text-decoration:none;">
                <button class="start-button">Start Course</button>
            </a>
        </div>
        
        <div class="course-card">
            <div class="card-image">
                <img src="AI.jpg" alt="AI Course">
            </div>
            <p>Introduction to Artificial Intelligence And Its Core Techniques</p>
            <a href="inde.jsp" style="text-decoration:none;">
                <button class="start-button">Start Course</button>
            </a>
        </div>
    </div>
    <button class="nav-arrow right-arrow" onclick="scrollCourses1(350)">&#9654;</button>
</div>

<script>
    function scrollCourses(amount) {
        const wrapper = document.querySelector('.courses-wrapper');
        wrapper.scrollLeft += amount;
    }
    
    function scrollCourses1(amount) {
        const wrapper = document.querySelector('.courses-wrapper1');
        wrapper.scrollLeft += amount;
    }
    
    function filterCourses() {
        const searchInput = document.getElementById('courseSearch').value.toLowerCase();
        const allCourses = document.querySelectorAll('.course-card');
        let visibleCount = 0;
        
        allCourses.forEach(card => {
            const courseTitle = card.querySelector('p').textContent.toLowerCase();
            if (courseTitle.includes(searchInput)) {
                card.style.display = 'block';
                card.style.animation = 'fadeIn 0.6s ease';
                visibleCount++;
            } else {
                card.style.display = 'none';
            }
        });
        
        // Show/hide no results message
        const noResults = document.getElementById('noResults');
        if (visibleCount === 0 && searchInput !== '') {
            noResults.style.display = 'block';
        } else {
            noResults.style.display = 'none';
        }
    }
    
    function toggleClearButton() {
        const searchInput = document.getElementById('courseSearch');
        const clearBtn = document.getElementById('clearBtn');
        
        if (searchInput.value.length > 0) {
            clearBtn.classList.add('visible');
        } else {
            clearBtn.classList.remove('visible');
        }
    }
    
    function clearSearch() {
        const searchInput = document.getElementById('courseSearch');
        searchInput.value = '';
        toggleClearButton();
        filterCourses();
        searchInput.focus();
    }
</script>

</body>
</html>