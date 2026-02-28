<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Master Programming | Knowledge Check</title>
<link rel="stylesheet" type="text/css" href="Chat.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link href="https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@300;400;600;800&display=swap" rel="stylesheet">
<link rel="stylesheet" href="U.css">
<style>



:root {
    --primary: #2563eb;
    --primary-glow: rgba(37, 99, 235, 0.4);
    --dark-bg: #0f172a;
    --text-main: #1e293b;
    --text-muted: #64748b;
    --hot-pink: #ff2e97;
    --gradient-1: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
    --gradient-2: linear-gradient(45deg, #f59e0b, #d97706);
}

* { 
    box-sizing: border-box; 
    transition: all 0.3s cubic-bezier(0.4, 0, 0.2, 1); 
}

body {
    font-family: 'Plus Jakarta Sans', sans-serif;
    line-height: 1.6;
    color: var(--text-main);
    margin: 0;
    background: linear-gradient(to bottom, #f8fafc 0%, #e0e7ff 100%);
    scroll-behavior: smooth;
}

/* Header Styles */
header {
    background: rgba(15, 23, 42, 0.98);
    backdrop-filter: blur(20px);
    padding: 12px 0;
    position: sticky;
    top: 0;
    z-index: 1000;
    border-bottom: 1px solid rgba(255,255,255,0.08);
    box-shadow: 0 4px 20px rgba(0,0,0,0.15);
}

nav { 
    display: flex; 
    justify-content: space-between; 
    align-items: center; 
    max-width: 1250px; 
    margin: 0 auto; 
    padding: 0 30px; 
}

.logo { 
    height: 60px; 
    width: auto; 
    border-radius: 10px; 
    filter: drop-shadow(0 0 8px rgba(255,255,255,0.3)); 
    animation: float 3s ease-in-out infinite;
}

@keyframes float {
    0%, 100% { transform: translateY(0px); }
    50% { transform: translateY(-5px); }
}

.brand-title { 
    color: var(--hot-pink) !important; 
    font-size: 22px; 
    font-weight: 800; 
    text-shadow: 0 0 15px rgba(255, 46, 151, 0.5); 
    margin-left: 15px; 
    letter-spacing: -0.5px; 
}

nav ul { 
    display: flex; 
    list-style: none; 
    gap: 15px; 
    align-items: center; 
}

nav ul li a, .nav-button-js { 
    color: #f1f5f9; 
    text-decoration: none; 
    font-weight: 600; 
    font-size: 0.9rem; 
    padding: 8px 16px; 
    border-radius: 8px; 
    cursor: pointer; 
}

nav ul li a:hover { 
    color: var(--hot-pink); 
    background: rgba(255,255,255,0.05); 
    transform: translateY(-2px);
}

#openLoginBtn, #openRegisterBtn { 
    background: rgba(255,255,255,0.1); 
    border: 1px solid rgba(255,255,255,0.1); 
}

#openLoginBtn:hover { 
    background: var(--primary); 
    border-color: var(--primary); 
}

#openRegisterBtn { 
    background: var(--primary); 
    color: white; 
}

#openRegisterBtn:hover { 
    background: #1d4ed8; 
    box-shadow: 0 0 15px var(--primary-glow); 
    transform: translateY(-2px);
}

.btn-news { 
    display: inline-block; 
    background: var(--gradient-2); 
    color: white; 
    padding: 12px 30px; 
    border-radius: 50px; 
    text-decoration: none; 
    font-weight: 700; 
    font-size: 0.9rem; 
    margin: 25px auto; 
    box-shadow: 0 8px 20px rgba(217, 119, 6, 0.4); 
    animation: pulse 2s infinite;
}

@keyframes pulse {
    0%, 100% { transform: scale(1); }
    50% { transform: scale(1.05); }
}

.btn-news:hover {
    box-shadow: 0 12px 30px rgba(217, 119, 6, 0.6);
    transform: translateY(-3px) scale(1.05);
}

/* Hero Section */
.hero { 
    background: radial-gradient(circle at 20% 20%, #1e3a8a 0%, #0f172a 100%);
    color: white; 
    padding: 160px 20px; 
    text-align: center; 
    position: relative;
    overflow: hidden;
}

.hero::before {
    content: '';
    position: absolute;
    width: 500px;
    height: 500px;
    background: radial-gradient(circle, var(--primary) 0%, transparent 70%);
    opacity: 0.15;
    top: -250px;
    right: -250px;
    animation: rotate 20s linear infinite;
}

@keyframes rotate {
    from { transform: rotate(0deg); }
    to { transform: rotate(360deg); }
}

.hero h1 { 
    font-size: 4.5rem; 
    font-weight: 800; 
    max-width: 900px; 
    margin: 0 auto 25px; 
    line-height: 1.1; 
    background: linear-gradient(to bottom, #ffffff, #a5b4fc); 
    -webkit-background-clip: text; 
    -webkit-text-fill-color: transparent;
    animation: slideDown 1s ease-out;
}

@keyframes slideDown {
    from { opacity: 0; transform: translateY(-30px); }
    to { opacity: 1; transform: translateY(0); }
}

.hero p { 
    font-size: 1.4rem; 
    color: #c7d2fe; 
    max-width: 750px; 
    margin: 0 auto 45px;
    animation: slideUp 1s ease-out 0.3s backwards;
}

@keyframes slideUp {
    from { opacity: 0; transform: translateY(30px); }
    to { opacity: 1; transform: translateY(0); }
}

.btn { 
    background: var(--primary); 
    color: white; 
    padding: 18px 40px; 
    border-radius: 12px; 
    font-weight: 700; 
    text-decoration: none; 
    display: inline-block; 
    box-shadow: 0 10px 25px var(--primary-glow); 
    animation: slideUp 1s ease-out 0.6s backwards;
}

.btn:hover { 
    transform: translateY(-3px); 
    box-shadow: 0 15px 35px var(--primary-glow); 
}

/* Features Section */
.features { 
    padding: 120px 20px; 
    max-width: 1200px; 
    margin: 0 auto; 
}

.feature-grid { 
    display: grid; 
    grid-template-columns: repeat(auto-fit, minmax(320px, 1fr)); 
    gap: 35px; 
    margin-top: 60px; 
}

.feature-item { 
    background: white; 
    padding: 50px 40px; 
    border-radius: 24px; 
    border: 1px solid #e2e8f0; 
    box-shadow: 0 10px 30px rgba(0,0,0,0.05); 
    text-align: center;
    position: relative;
    overflow: hidden;
}

.feature-item::before {
    content: '';
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 4px;
    background: var(--gradient-1);
    transform: scaleX(0);
    transition: transform 0.4s;
}

.feature-item:hover::before {
    transform: scaleX(1);
}

.feature-item:hover { 
    transform: translateY(-15px); 
    box-shadow: 0 25px 50px rgba(0, 0, 0, 0.12); 
    border-color: var(--primary); 
}

.feature-item i { 
    font-size: 3rem; 
    color: var(--primary); 
    background: linear-gradient(135deg, #dbeafe, #e0e7ff); 
    width: 100px; 
    height: 100px; 
    line-height: 100px; 
    border-radius: 50%; 
    margin: 0 auto 25px; 
    display: block;
}

.feature-item h3 {
    font-size: 1.5rem;
    margin-bottom: 15px;
    color: var(--text-main);
}

.feature-item p {
    color: var(--text-muted);
    line-height: 1.7;
}

/* Modal Styles */
.modal { 
    display: none; 
    position: fixed; 
    inset: 0; 
    background: rgba(15, 23, 42, 0.95); 
    backdrop-filter: blur(10px); 
    z-index: 2000; 
    align-items: center;
    justify-content: center;
}

.modal-content { 
    background: white; 
    padding: 50px; 
    border-radius: 30px; 
    max-width: 450px; 
    text-align: center; 
    box-shadow: 0 30px 60px rgba(0,0,0,0.4); 
    position: relative;
    animation: modalSlide 0.4s ease-out;
}

@keyframes modalSlide {
    from { opacity: 0; transform: scale(0.9) translateY(-20px); }
    to { opacity: 1; transform: scale(1) translateY(0); }
}

.close { 
    position: absolute; 
    top: 25px; 
    right: 25px; 
    font-size: 2rem; 
    cursor: pointer; 
    color: #94a3b8; 
}

.close:hover {
    color: var(--hot-pink);
    transform: rotate(90deg);
}

/* Chat Toggle Button */
.chat-toggle-btn {
  position: fixed;
  bottom: 40px;
  right: 40px;
  width: 65px;
  height: 65px;
  background: linear-gradient(135deg, #2563eb, #4f46e5);
  color: white;
  border: none;
  border-radius: 50%;
  font-size: 28px;
  cursor: pointer;
  box-shadow: 0 10px 30px rgba(37, 99, 235, 0.4);
  z-index: 999;
  display: flex;
  align-items: center;
  justify-content: center;
  animation: bounce 2s infinite;
}

@keyframes bounce {
  0%, 100% { transform: translateY(0); }
  50% { transform: translateY(-10px); }
}

.chat-toggle-btn:hover {
  box-shadow: 0 15px 40px rgba(37, 99, 235, 0.6);
  transform: scale(1.1);
  animation: none;}#chatToggleBtn {
  position: fixed;
  bottom: 25px;
  right: 25px;
  width: 60px;
  height: 60px;
  border-radius: 50%;
  border: none;
  background: #38bdf8; /* neon blue */
  color: #fff;
  font-size: 32px;
  cursor: pointer;
  box-shadow: 0 0 15px #38bdf8, 0 0 30px #38bdf8;
  display: flex;
  justify-content: center;
  align-items: center;
  animation: wave 1.5s infinite;
  z-index: 1000;
}

/* Wave Animation */
@keyframes wave {
  0% { transform: rotate(0deg); }
  15% { transform: rotate(14deg); }
  30% { transform: rotate(-8deg); }
  45% { transform: rotate(14deg); }
  60% { transform: rotate(-4deg); }
  75% { transform: rotate(10deg); }
  100% { transform: rotate(0deg); }
}


/* Chat Container */
.chat-container {
  position: fixed;
  bottom: 120px;
  right: 40px;
  width: 420px;
  height: 600px;
  background: white;
  border-radius: 24px;
  box-shadow: 0 25px 60px rgba(0,0,0,0.3);
  display: none;
  flex-direction: column;
  overflow: hidden;
  z-index: 1000;
  animation: chatSlide 0.4s ease-out;
}

@keyframes chatSlide {
  from { opacity: 0; transform: translateY(20px) scale(0.95); }
  to { opacity: 1; transform: translateY(0) scale(1); }
}

.chat-header {
  background: linear-gradient(135deg, #2563eb, #4f46e5);
  color: white;
  padding: 20px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.chat-header h3 {
  margin: 0;
  font-size: 1.2rem;
  font-weight: 700;
}

.chat-close {
  background: rgba(255,255,255,0.2);
  border: none;
  color: white;
  width: 32px;
  height: 32px;
  border-radius: 50%;
  cursor: pointer;
  font-size: 1.2rem;
  display: flex;
  align-items: center;
  justify-content: center;
}

.chat-close:hover {
  background: rgba(255,255,255,0.3);
}

/* Chat Box */
.chat-box { 
  flex: 1;
  padding: 20px; 
  overflow-y: auto; 
  background: linear-gradient(to bottom, #f8fafc, #f1f5f9);
  display: flex; 
  flex-direction: column; 
  gap: 15px; 
}

.chat-box::-webkit-scrollbar {
  width: 6px;
}

.chat-box::-webkit-scrollbar-thumb {
  background: #cbd5e1;
  border-radius: 10px;
}

/* Input Area */
.input-area { 
  display: flex; 
  padding: 18px; 
  border-top: 1px solid #e2e8f0;
  background: white;
  gap: 10px;
}

.input-area input { 
  flex: 1; 
  padding: 12px 16px; 
  border-radius: 12px; 
  border: 2px solid #e2e8f0;
  font-size: 0.95rem;
  font-family: 'Plus Jakarta Sans', sans-serif;
}

.input-area input:focus {
  outline: none;
  border-color: var(--primary);
  box-shadow: 0 0 8px rgba(37, 99, 235, 0.3);
}

.input-area button { 
  background: linear-gradient(135deg, #2563eb, #4f46e5); 
  color: white; 
  border: none; 
  padding: 12px 20px; 
  border-radius: 12px; 
  cursor: pointer;
  font-weight: 600;
  box-shadow: 0 4px 12px rgba(37, 99, 235, 0.3);
}

.input-area button:hover {
  box-shadow: 0 6px 18px rgba(37, 99, 235, 0.5);
  transform: translateY(-2px);
}

.input-area button:disabled {
  opacity: 0.6;
  cursor: not-allowed;
}

/* Messages */
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
  from { opacity: 0; transform: translateY(10px); }
  to { opacity: 1; transform: translateY(0); }
}

.user { 
  background: linear-gradient(135deg, #2563eb, #4f46e5); 
  color: white; 
  margin-left: auto; 
  border-bottom-right-radius: 4px;
  box-shadow: 0 4px 12px rgba(37, 99, 235, 0.3);
}

.bot { 
  background: white; 
  border: 1px solid #e2e8f0;
  color: var(--text-main);
  border-bottom-left-radius: 4px;
  box-shadow: 0 2px 8px rgba(0,0,0,0.05);
}

.typing-indicator {
    display: flex;
    gap: 4px;
    padding: 12px 16px;
    background: white;
    border-radius: 16px;
    width: fit-content;
    border: 1px solid #e2e8f0;
}

.typing-dot {
    width: 8px;
    height: 8px;
    background: var(--primary);
    border-radius: 50%;
    animation: typing 1.4s infinite;
}

.typing-dot:nth-child(2) { animation-delay: 0.2s; }
.typing-dot:nth-child(3) { animation-delay: 0.4s; }

@keyframes typing {
    0%, 60%, 100% { transform: translateY(0); opacity: 0.5; }
    30% { transform: translateY(-8px); opacity: 1; }
}

/* Footer */
footer { 
    background: var(--dark-bg); 
    color: #94a3b8; 
    padding: 100px 40px 40px; 
}

.footer-content {
    max-width: 1200px;
    margin: 0 auto;
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
    gap: 40px;
}

.footer-col h4 { 
    color: white; 
    margin-bottom: 25px; 
    font-size: 1.2rem; 
}

.footer-col ul { 
    list-style: none; 
    padding: 0; 
}

.footer-col ul li { 
    margin-bottom: 12px; 
}

.footer-col a { 
    color: #94a3b8; 
    text-decoration: none; 
}

.footer-col a:hover { 
    color: var(--hot-pink); 
}

.footer-bottom { 
    border-top: 1px solid rgba(255,255,255,0.05); 
    margin-top: 80px; 
    padding-top: 40px; 
    text-align: center; 
    font-size: 0.85rem; 
}

@media (max-width: 768px) { 
    .hero h1 { font-size: 2.5rem; } 
    nav ul { display: none; }
    .chat-container {
        width: calc(100vw - 40px);
        right: 20px;
        bottom: 100px;
    }
    .chat-toggle-btn {
        right: 20px;
    }
}

.input-field {
  width: 100%;
  padding: 14px;
  margin: 10px 0;
  border-radius: 12px;
  border: 2px solid #e2e8f0;
  font-size: 0.95rem;
}

.input-field:focus {
  outline: none;
  border-color: #2563eb;
  box-shadow: 0 0 8px rgba(37,99,235,0.3);
}

/* ===============================
   LOGIN & REGISTER SIZE UPGRADE
   =============================== */

/* Bigger modal container */
.modal-content {
    max-width: 700px;          /* increased width */
    width: 92%;
    min-height: 600px;         /* increased height */
    padding: 60px 60px;        /* more inner space */
    border-radius: 32px;
}

/* Register modal needs more space */
/* FIXED: Register modal fits fully on one screen */
/* ULTRA-COMPACT: Register modal fully visible at 100% */
/* PERFECT FIT REGISTER MODAL — FULL PAGE, NO SCROLL */
#registerModal .modal-content {
    max-width: 450px;           /* Slightly narrower for a sleeker look */
    width: 90%;
    max-height: 90vh;          /* Increased slightly to avoid cutting off the 'Submit' button */
    padding: 30px;             /* Balanced padding */
    border-radius: 12px;       /* Modern rounded corners */
    display: flex;
    flex-direction: column;
    gap: 15px;                 /* Consistent spacing between form groups */
    overflow-y: auto;          /* Allows scrolling ONLY if the screen is very small */
}

/* Style the labels for better readability */
#registerModal label {
    font-size: 14px;
    font-weight: 600;
    margin-bottom: 5px;
    display: block;
}

/* Style the inputs to match the image */
#registerModal input {
    width: 100%;
    padding: 12px;
    border: 1px solid #ddd;
    border-radius: 8px;
    background-color: #f9f9f9;
}#registerModal .input-field,
#registerModal textarea {
    padding: 10px 12px;
    font-size: 0.85rem;
    border-radius: 10px;
}

@media (max-height: 650px) {
    #registerModal .modal-content {
        max-width: 480px;
        padding: 24px;
    }
}


/* Improve form spacing */
.modal-content form {
    margin-top: 25px;
}

/* Inputs spacing */
.modal-content .input-field,
.modal-content .F,
.modal-content textarea {
    padding: 16px;
    font-size: 1rem;
    border-radius: 14px;
}

/* Field group spacing (register page) */
.field-group {
    margin-bottom: 18px;
}

/* Headings bigger */
.modal-content h2 {
    font-size: 2.1rem;
    margin-bottom: 25px;
}

/* Buttons bigger */
.modal-content .btn {
    padding: 16px;
    font-size: 1.05rem;
    border-radius: 14px;
}

/* Scroll only if content overflows (no cutoff) */
.modal-content {
    overflow-y: auto;
}

/* Mobile optimization */
@media (max-width: 768px) {
    .modal-content {
        max-width: 95%;
        min-height: auto;
        padding: 40px 30px;
    }

    #registerModal .modal-content {
        min-height: auto;
    }
}.logo-video {
  position: fixed;     /* stays always visible */
  top: 15px;
  left: 15px;          /* LEFT SIDE */
  z-index: 9999;       /* above everything */
}

.logo-video video {
  width: 120px;        /* logo size */
  height: auto;
  border-radius: 12px;
}
.error-msg {
        color: #ff4d4d;
        font-size: 12px;
        margin-top: 5px;
        font-weight: 500;
    }

/* ========================================
   PERFECT HEADER - EVERYTHING FITS
   ======================================== */

/* Logo - Big and Visible */
.logo-video {
  position: relative;
  top: auto;
  left: auto;
  z-index: auto;
  margin-right: 15px;
  flex-shrink: 0;
}

.logo-video video {
  width: 140px;        /* Balanced size */
  height: auto;
  border-radius: 12px;
  display: block;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
}

/* Brand Title - Fits perfectly */
.brand-title { 
    color: var(--hot-pink) !important; 
    font-size: 18px;     /* Adjusted to fit all nav items */
    font-weight: 800; 
    text-shadow: 0 0 15px rgba(255, 46, 151, 0.5); 
    margin-left: 0 !important;
    letter-spacing: -0.5px; 
    white-space: nowrap;
}

/* Header Navigation - Compact but spacious */
nav {
    display: flex;
    justify-content: space-between;
    align-items: center;
    max-width: 1400px;  /* Wider to fit everything */
    margin: 0 auto;
    padding: 12px 20px;  /* Balanced padding */
}

/* Left side: Logo + Title */
nav > div:first-child {
    display: flex;
    align-items: center;
    gap: 12px;
    flex-shrink: 0;  /* Don't shrink this section */
}

/* Right side: Navigation Links */
nav ul { 
    display: flex; 
    list-style: none; 
    gap: 10px;  /* Tighter spacing to fit all items */
    align-items: center;
    margin: 0;
    padding: 0;
    flex-wrap: nowrap;  /* Keep on one line */
}

/* Navigation Items - Smaller but readable */
nav ul li a, .nav-button-js { 
    color: #f1f5f9; 
    text-decoration: none; 
    font-weight: 600; 
    font-size: 0.85rem;  /* Slightly smaller */
    padding: 8px 12px;   /* Compact padding */
    border-radius: 8px; 
    cursor: pointer;
    white-space: nowrap;  /* Don't break text */
}

nav ul li a:hover { 
    color: var(--hot-pink); 
    background: rgba(255,255,255,0.05); 
    transform: translateY(-2px);
}

/* Login & Register Buttons */
#openLoginBtn, #openRegisterBtn { 
    background: rgba(255,255,255,0.1); 
    border: 1px solid rgba(255,255,255,0.1); 
}

#openLoginBtn:hover { 
    background: var(--primary); 
    border-color: var(--primary); 
}

#openRegisterBtn { 
    background: var(--primary); 
    color: white; 
}

#openRegisterBtn:hover { 
    background: #1d4ed8; 
    box-shadow: 0 0 15px var(--primary-glow); 
    transform: translateY(-2px);
}

/* ========================================
   RESPONSIVE - Mobile Adjustments
   ======================================== */

@media (max-width: 1200px) {
    .brand-title {
        font-size: 16px;
    }
    
    nav ul {
        gap: 8px;
    }
    
    nav ul li a, .nav-button-js {
        font-size: 0.8rem;
        padding: 6px 10px;
    }
}

@media (max-width: 992px) {
    .logo-video video {
        width: 100px;
    }
    
    .brand-title {
        font-size: 14px;
    }
    
    nav ul {
        gap: 6px;
    }
    
    nav ul li a, .nav-button-js {
        font-size: 0.75rem;
        padding: 6px 8px;
    }
}

@media (max-width: 768px) { 
    nav ul { 
        display: none;  /* Hide nav on mobile, add hamburger menu */
    }
    
    .logo-video video {
        width: 100px;
    }
    
    .brand-title {
        font-size: 16px;
    }
}

.stats-section {
    background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
    padding: 80px 20px;
    margin: 60px 0;
    position: relative;
    overflow: hidden;
}

.stats-section::before {
    content: '';
    position: absolute;
    width: 600px;
    height: 600px;
    background: radial-gradient(circle, rgba(255,255,255,0.1) 0%, transparent 70%);
    top: -300px;
    right: -300px;
    animation: rotate 20s linear infinite;
}

.stats-container {
    max-width: 1200px;
    margin: 0 auto;
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
    gap: 40px;
    position: relative;
    z-index: 2;
}

.stat-box {
    text-align: center;
    color: white;
    animation: fadeInUp 0.8s ease backwards;
}

.stat-box:nth-child(2) { animation-delay: 0.2s; }
.stat-box:nth-child(3) { animation-delay: 0.4s; }
.stat-box:nth-child(4) { animation-delay: 0.6s; }

.stat-number {
    font-size: 3.5rem;
    font-weight: 800;
    display: block;
    margin-bottom: 10px;
    text-shadow: 0 4px 20px rgba(0,0,0,0.3);
}

.stat-label {
    font-size: 1.1rem;
    opacity: 0.95;
    font-weight: 600;
}

.stat-icon {
    font-size: 2.5rem;
    margin-bottom: 15px;
    opacity: 0.8;
}

/* ========================================
   LIVE NOTIFICATION TICKER
   ======================================== */
.notification-ticker {
    background: linear-gradient(90deg, #ff7e5f, #feb47b);
    padding: 12px 0;
    overflow: hidden;
    position: relative;
    box-shadow: 0 4px 15px rgba(255, 126, 95, 0.3);
}

.ticker-content {
    display: flex;
    animation: scroll 25s linear infinite;
    white-space: nowrap;
}

.ticker-item {
    display: inline-flex;
    align-items: center;
    margin-right: 60px;
    color: white;
    font-weight: 600;
    font-size: 0.95rem;
}

.ticker-item i {
    margin-right: 10px;
    font-size: 1.2rem;
}

@keyframes scroll {
    0% { transform: translateX(0); }
    100% { transform: translateX(-50%); }
}

/* ========================================
   PROGRESS TRACKER SECTION
   ======================================== */
.progress-tracker {
    max-width: 1200px;
    margin: 80px auto;
    padding: 60px 40px;
    background: white;
    border-radius: 30px;
    box-shadow: 0 20px 60px rgba(0,0,0,0.1);
}

.progress-tracker h2 {
    text-align: center;
    font-size: 2.5rem;
    margin-bottom: 50px;
    color: #1e293b;
}

.progress-grid {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
    gap: 30px;
}

.progress-card {
    padding: 30px;
    border-radius: 20px;
    background: linear-gradient(135deg, #f8fafc, #e0e7ff);
    border: 2px solid #e2e8f0;
    transition: all 0.3s ease;
}

.progress-card:hover {
    transform: translateY(-5px);
    box-shadow: 0 15px 40px rgba(37, 99, 235, 0.2);
    border-color: #2563eb;
}

.progress-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 20px;
}

.progress-title {
    font-size: 1.2rem;
    font-weight: 700;
    color: #1e293b;
}

.progress-percentage {
    font-size: 1.5rem;
    font-weight: 800;
    color: #2563eb;
}

.progress-bar-container {
    background: #e2e8f0;
    height: 10px;
    border-radius: 10px;
    overflow: hidden;
    margin-bottom: 15px;
}

.progress-bar {
    height: 100%;
    background: linear-gradient(90deg, #2563eb, #4f46e5);
    border-radius: 10px;
    transition: width 1.5s ease;
    box-shadow: 0 0 10px rgba(37, 99, 235, 0.5);
}

.progress-info {
    display: flex;
    justify-content: space-between;
    font-size: 0.85rem;
    color: #64748b;
}

/* ========================================
   TESTIMONIAL CAROUSEL
   ======================================== */
.testimonial-section {
    padding: 100px 20px;
    background: linear-gradient(to bottom, #f8fafc, #e0e7ff);
}

.testimonial-section h2 {
    text-align: center;
    font-size: 2.8rem;
    margin-bottom: 60px;
    color: #1e293b;
}

.testimonial-carousel {
    max-width: 900px;
    margin: 0 auto;
    position: relative;
}

.testimonial-card {
    background: white;
    padding: 50px;
    border-radius: 30px;
    box-shadow: 0 20px 60px rgba(0,0,0,0.1);
    text-align: center;
    display: none;
    animation: fadeInScale 0.6s ease;
}

.testimonial-card.active {
    display: block;
}

@keyframes fadeInScale {
    from { opacity: 0; transform: scale(0.95); }
    to { opacity: 1; transform: scale(1); }
}

.testimonial-avatar {
    width: 100px;
    height: 100px;
    border-radius: 50%;
    background: linear-gradient(135deg, #667eea, #764ba2);
    margin: 0 auto 25px;
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 3rem;
    color: white;
}

.testimonial-text {
    font-size: 1.3rem;
    line-height: 1.8;
    color: #475569;
    margin-bottom: 25px;
    font-style: italic;
}

.testimonial-author {
    font-weight: 700;
    color: #1e293b;
    font-size: 1.1rem;
}

.testimonial-role {
    color: #64748b;
    font-size: 0.95rem;
}

.testimonial-dots {
    display: flex;
    justify-content: center;
    gap: 12px;
    margin-top: 40px;
}

.dot {
    width: 12px;
    height: 12px;
    border-radius: 50%;
    background: #cbd5e1;
    cursor: pointer;
    transition: all 0.3s ease;
}

.dot.active {
    background: #2563eb;
    transform: scale(1.3);
}

/* ========================================
   SKILL BADGES SECTION
   ======================================== */
.skills-showcase {
    max-width: 1200px;
    margin: 80px auto;
    padding: 0 20px;
}

.skills-showcase h2 {
    text-align: center;
    font-size: 2.5rem;
    margin-bottom: 50px;
    color: #1e293b;
}

.badge-container {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    gap: 20px;
}

.skill-badge {
    padding: 15px 30px;
    border-radius: 50px;
    background: linear-gradient(135deg, #667eea, #764ba2);
    color: white;
    font-weight: 600;
    box-shadow: 0 8px 20px rgba(102, 126, 234, 0.3);
    cursor: pointer;
    transition: all 0.3s ease;
    animation: fadeInUp 0.6s ease backwards;
}

.skill-badge:nth-child(odd) {
    background: linear-gradient(135deg, #f59e0b, #d97706);
}

.skill-badge:hover {
    transform: translateY(-5px) scale(1.05);
    box-shadow: 0 12px 30px rgba(102, 126, 234, 0.5);
}

/* ========================================
   LIVE ACTIVITY FEED
   ======================================== */
.activity-feed {
    max-width: 600px;
    margin: 80px auto;
    padding: 0 20px;
}

.activity-feed h3 {
    text-align: center;
    font-size: 2rem;
    margin-bottom: 40px;
    color: #1e293b;
}

.activity-list {
    background: white;
    border-radius: 20px;
    padding: 30px;
    box-shadow: 0 10px 40px rgba(0,0,0,0.1);
    max-height: 400px;
    overflow-y: auto;
}

.activity-item {
    display: flex;
    align-items: center;
    padding: 15px;
    border-left: 4px solid #2563eb;
    margin-bottom: 15px;
    background: #f8fafc;
    border-radius: 10px;
    animation: slideInLeft 0.5s ease backwards;
}

.activity-item:nth-child(2) { animation-delay: 0.1s; }
.activity-item:nth-child(3) { animation-delay: 0.2s; }
.activity-item:nth-child(4) { animation-delay: 0.3s; }

@keyframes slideInLeft {
    from { opacity: 0; transform: translateX(-20px); }
    to { opacity: 1; transform: translateX(0); }
}

.activity-icon {
    font-size: 1.5rem;
    margin-right: 15px;
    color: #2563eb;
}

.activity-text {
    flex: 1;
}

.activity-user {
    font-weight: 700;
    color: #1e293b;
}

.activity-action {
    color: #64748b;
}

.activity-time {
    font-size: 0.85rem;
    color: #94a3b8;
}

/* ========================================
   RESPONSIVE ADJUSTMENTS
   ======================================== */
@media (max-width: 768px) {
    .stat-number { font-size: 2.5rem; }
    .testimonial-text { font-size: 1.1rem; }
    .progress-tracker { padding: 40px 20px; }
}

/* Fix: stop global transition from breaking panel slide */
#sidePanel {
  transition: right 0.45s cubic-bezier(0.4,0,0.2,1) !important;
}
#panelBackdrop {
  transition: opacity 0.35s ease !important;
}
</style>

</head>
<body>

<header>
    <nav>
        <div style="display:flex; align-items:center;">
           <!-- Example: embedding audio -->
<div class="logo-video">
  <video autoplay loop muted>
    <source src="logo.mp4" type="video/mp4">
    Your browser does not support the video tag.
  </video>
</div>



           
            <h1 class="brand-title">Knowledge Check Demonstration </h1>
        </div>
        <ul>
            <li><a href="index1.jsp">Home</a></li>
            <li><a href="javascript:void(0)" onclick="openPanel('services')">Services</a></li>
<li><a href="javascript:void(0)" onclick="openPanel('about')">About Us</a></li>
<li><a href="javascript:void(0)" onclick="openPanel('contact')">Contact</a></li>

            <li id="openLoginBtn" class="nav-button-js">LogIn</li>
            <li id="openRegisterBtn" class="nav-button-js">Register</li>
        </ul> 
    </nav>  
</header>
<div class="notification-ticker">
    <div class="ticker-content">
        <div class="ticker-item">
            <i class="fas fa-fire"></i>
            <span>&#127891; MHCET 2026MCA Registration: Valid till 10 Feb 2026</span>
        </div>
        <div class="ticker-item">
            <i class="fas fa-trophy"></i>
            <span>&#127775;
             5,000+ students enrolled this week</span>
        </div>
        <div class="ticker-item">
            <i class="fas fa-star"></i>
            <span>&#9889;
             New Java Advanced Course now available</span>
        </div>
        <div class="ticker-item">
            <i class="fas fa-graduation-cap"></i>
            <span>&#127891;
             Mike completed 10 courses this month!</span>
        </div>
        <div class="ticker-item">
            <i class="fas fa-medal"></i>
            <span>&#127942;
             Limited time: 30% off on all certifications</span>
        </div>
        <!-- Duplicate for seamless loop -->
        <div class="ticker-item">
            <i class="fas fa-fire"></i>
            <span>&#127881;Sarah just earned Python Developer Certificate!</span>
        </div>
        <div class="ticker-item">
            <i class="fas fa-trophy"></i>
            <span>&#127775; 5,000+ students enrolled this week</span>
        </div>
        <div class="ticker-item">
            <i class="fas fa-star"></i>
            <span>&#9889; New Java Advanced Course now available</span>
        </div>
        <div class="ticker-item">
            <i class="fas fa-graduation-cap"></i>
            <span>&#127891; Mike completed 10 courses this month!</span>
        </div>
        <div class="ticker-item">
            <i class="fas fa-medal"></i>
            <span>&#127891; MHCET 2026MCA Registration: Valid till 10 Feb 2026</span>

        </div>
    </div>
</div>
<div style="text-align: center; margin: -15px 0 20px 0;">
    <a href="NewsServlet" class="btn-news">
        <i class="fas fa-bullhorn"></i> Platform News & Updates
    </a>
</div>

<!-- Login & Register Modals -->
<div id="loginModal" class="modal">
  <div class="modal-content">
    <span class="close" onclick="closeModal('loginModal')">&times;</span>

    <h2>Welcome Back</h2>

    <!-- FORM SENDS DATA TO JAVA SERVLET -->
   <form id="loginForm" action="Validate" method="post">

      <!-- NAME FIELD -->
   

      <!-- EMAIL FIELD -->
      <input 
        type="email" 
        name="Name"
        placeholder="Email" 
        required 
        class="input-field"
      >
      <div class="error-msg">
                <% String Error=(String)request.getAttribute("Error"); if(Error!=null) out.print(Error); %>
            </div>

      <!-- PASSWORD FIELD -->
      <input 
        type="password" 
        name="Password"
        placeholder="Password" 
        required 
        class="input-field"
      ><div class="error-msg">
                <% String regu=(String)request.getAttribute("regu"); if(regu!=null) out.print(regu); %>
            </div>
       <div class="error-msg">
                <% String E=(String)request.getAttribute("E"); if(E!=null) out.print(E); %>
            </div>

      <INput type="submit" value="Login" class="btn" style="width:100%;" >
      <div class="Error" style="text-align: center; margin-top: 10px;">
            <% String U=(String)request.getAttribute("U"); if(U!=null) out.print(U); %>
        </div>
    </form>

    <p style="margin-top:15px; color:#64748b;">
      No account?
      <span style="color:#2563eb; cursor:pointer;"
        onclick="closeModal('loginModal'); openRegisterBtn.click();">
        Register
      </span>
    </p>
  </div>
</div>



<div id="registerModal" class="modal">
  <div class="modal-content">
    <span class="close" onclick="closeModal('registerModal')">&times;</span>

    <h2>Create Account</h2>

   <form id="registerForm" action="New" method="post" enctype="multipart/form-data">

     <div class="field-group">
        <label><span class="M">*</span>Your Name</label>
        <input type="text" class="input-field" name="Name" value="<%=session.getAttribute("name2")!=null?session.getAttribute("name2"):"" %>" placeholder="e.g. Satya Nadella">
        <div class="error-msg"><%= request.getAttribute("E") != null ? request.getAttribute("E") : "" %></div>
    </div>

    <div class="field-group">
        <label><span class="M">*</span>Email Address</label>
        <input type="email" class="input-field" name="email" value="<%=session.getAttribute("email")!=null?session.getAttribute("email"):"" %>" placeholder="Satya@example.com">
        <div class="error-msg">
            <%= request.getAttribute("Error") != null ? request.getAttribute("Error") : "" %>
            <%= request.getAttribute("Email") != null ? request.getAttribute("Email") : "" %>
        </div>
    </div>

    <div class="field-group">
        <label><span class="M">*</span>Mobile Number</label>
        <input type="number" class="input-field" name="Number" value="<%=session.getAttribute("number")!=null?session.getAttribute("number"):"" %>" placeholder="+91 0000000000">
        <div class="error-msg"><%= request.getAttribute("M") != null ? request.getAttribute("M") : "" %></div>
    </div>

    <div class="field-group">
        <label><span class="M">*</span>Class</label>
        <input type="text" class="input-field" name="C" value="<%=session.getAttribute("C")!=null?session.getAttribute("C"):"" %>" placeholder="Current Grade/Class">
        <div class="error-msg"><%= request.getAttribute("Class") != null ? request.getAttribute("Class") : "" %></div>
    </div>

    <div class="field-group">
        <label><span class="M">*</span>Create Password</label>
        <input type="password" class="input-field" name="Password" placeholder="Min 8 characters">
        <div class="error-msg"><%= request.getAttribute("Password") != null ? request.getAttribute("Password") : "" %></div>
        <div class="error-msg"><%= request.getAttribute("regu") != null ? request.getAttribute("regu") : "" %></div>
    </div>

    <div class="field-group">
        <label><span class="M">*</span>Confirm Password</label>
        <input type="password" class="input-field" name="P" placeholder="Repeat password">
        <div class="error-msg"><%= request.getAttribute("P") != null ? request.getAttribute("P") : "" %></div>
    </div>

    <div class="field-group">
        <label>Residential Address</label>
        <textarea name="A" class="input-field" placeholder="Enter full address..."><%=session.getAttribute("Addr")!=null?session.getAttribute("Addr"):"" %></textarea>
        <div class="error-msg"><%= request.getAttribute("Address") != null ? request.getAttribute("Address") : "" %></div>
    </div>
    
    
    
    
    
    
    <div class="field-group">
    <label>Upload Photo</label>
    <input type="file" name="photo" accept="image/*">
</div>
    

    <!-- FIXED: Changed Button to button (lowercase) -->
    <button type="submit" class="btn" style="width:100%;">Register</button>
      
    <div class="error-msg" style="text-align:center; margin-top:10px;">
        <%= request.getAttribute("U") != null ? request.getAttribute("U") : "" %>
    </div>
    </form>

    <p style="margin-top:15px; color:#64748b;">
      Already have an account?
      <span style="color:#2563eb; cursor:pointer;"
        onclick="closeModal('registerModal'); openLoginBtn.click();">
        Login
      </span>
    </p>
  </div>
</div>



<!-- Hero Section -->
<section id="home" class="hero">
    <div class="hero-content">
        <h1>Master Programming.<br>Earn Validated Credentials.</h1>
        <p>Expertly crafted courses with integrated knowledge assessments to prove your practical expertise.</p>
        <a href="Scroll1.jsp" class="btn">
            Explore All Courses <i class="fas fa-arrow-right" style="margin-left:10px;"></i>
        </a>
    </div>
</section>


<section class="stats-section">
    <div class="stats-container">
        <div class="stat-box">
            <i class="fas fa-users stat-icon"></i>
            <span class="stat-number" data-target="50000">100</span>
            <span class="stat-label">Active Students</span>
        </div>
        <div class="stat-box">
            <i class="fas fa-book stat-icon"></i>
            <span class="stat-number" data-target="10">10</span>
            <span class="stat-label">Courses Available</span>
        </div>
        <div class="stat-box">
            <i class="fas fa-certificate stat-icon"></i>
            <span class="stat-number" data-target="25000">10</span>
            <span class="stat-label">Certificates Issued</span>
        </div>
        <div class="stat-box">
            <i class="fas fa-star stat-icon"></i>
            <span class="stat-number" data-target="98">94</span>
            <span class="stat-label">Success Rate %</span>
        </div>
    </div>
</section>

<!-- Features Section -->
<section id="features" class="features">
    <h2 style="text-align: center; font-size: 2.8rem; letter-spacing: -1px; margin-bottom: 10px;">A Better Way to Learn</h2>
    <p style="text-align: center; color: var(--text-muted); margin-bottom: 50px;">Complete end-to-end certification ecosystem.</p>
    <div class="feature-grid">
        <div class="feature-item">
            <i class="fas fa-book-open"></i>
            <h3>Interactive Learning</h3>
            <p>Master Python, Java, and JavaScript through curriculum designed by industry experts.</p>
        </div>
        <div class="feature-item">
            <i class="fas fa-shield-alt"></i>
            <h3>Skill Validation</h3>
            <p>Go beyond quizzes. Our assessments ensure you can actually apply what you've learned.</p>
        </div>
        <div class="feature-item">
            <i class="fas fa-certificate"></i>
            <h3>Digital Credentials</h3>
            <p>Earn professional, shareable certificates that demonstrate your mastery to employers.</p>
        </div>
    </div>
</section>
<section class="progress-tracker">
    <h2>  &#128202;Your Learning Journey</h2>
    <div class="progress-grid">
        <div class="progress-card">
            <div class="progress-header">
                <span class="progress-title">Python Mastery</span>
                <span class="progress-percentage">75%</span>
            </div>
            <div class="progress-bar-container">
                <div class="progress-bar" style="width: 0%" data-progress="75"></div>
            </div>
            <div class="progress-info">
                <span>15/20 Lessons</span>
                <span>5 Days Left</span>
            </div>
        </div>
        
        <div class="progress-card">
            <div class="progress-header">
                <span class="progress-title">JavaScript Pro</span>
                <span class="progress-percentage">60%</span>
            </div>
            <div class="progress-bar-container">
                <div class="progress-bar" style="width: 0%" data-progress="60"></div>
            </div>
            <div class="progress-info">
                <span>12/20 Lessons</span>
                <span>8 Days Left</span>
            </div>
        </div>
        
        <div class="progress-card">
            <div class="progress-header">
                <span class="progress-title">Java Developer</span>
                <span class="progress-percentage">40%</span>
            </div>
            <div class="progress-bar-container">
                <div class="progress-bar" style="width: 0%" data-progress="40"></div>
            </div>
            <div class="progress-info">
                <span>8/20 Lessons</span>
                <span>12 Days Left</span>
            </div>
        </div>
    </div>
</section>


<section class="testimonial-section">
    <h2>&#128172; What Our Students Say</h2>
    <div class="testimonial-carousel">
        <div class="testimonial-card active">
            <div class="testimonial-avatar"> &#128104;&#8205;&#128187;</div>
            <p class="testimonial-text">"This platform transformed my career! The interactive assessments really proved I could apply what I learned. Got hired within 2 weeks of certification!"</p>
            <div class="testimonial-author">Alex Johnson</div>
            <div class="testimonial-role">Software Engineer at Google</div>
        </div>
        
        <div class="testimonial-card">
            <div class="testimonial-avatar">  &#128105;&#8205;&#128188;</div>
            <p class="testimonial-text">"Best online learning experience ever. The curriculum is industry-relevant and the certificates are recognized by employers. Highly recommend!"</p>
            <div class="testimonial-author">Priya Sharma</div>
            <div class="testimonial-role">Full Stack Developer at Microsoft</div>
        </div>
        
        <div class="testimonial-card">
            <div class="testimonial-avatar">&#128104;&#8205;&#127891;</div>
            <p class="testimonial-text">"From complete beginner to confident programmer in just 3 months. The step-by-step approach and real-world projects made all the difference."</p>
            <div class="testimonial-author">Michael Chen</div>
            <div class="testimonial-role">Junior Developer at Amazon</div>
        </div>
        
        <div class="testimonial-dots">
            <span class="dot active" onclick="showTestimonial(0)"></span>
            <span class="dot" onclick="showTestimonial(1)"></span>
            <span class="dot" onclick="showTestimonial(2)"></span>
        </div>
    </div>
</section>

<!-- Skill Badges Section -->
<section class="skills-showcase">
    <h2>  &#127919; Master These In-Demand Skills</h2>
    <div class="badge-container">
        <div class="skill-badge" style="animation-delay: 0s;">Python</div>
        <div class="skill-badge" style="animation-delay: 0.1s;">JavaScript</div>
        <div class="skill-badge" style="animation-delay: 0.2s;">Java</div>
        <div class="skill-badge" style="animation-delay: 0.3s;">React</div>
        <div class="skill-badge" style="animation-delay: 0.4s;">Node.js</div>
        <div class="skill-badge" style="animation-delay: 0.5s;">SQL</div>
        <div class="skill-badge" style="animation-delay: 0.6s;">Git & GitHub</div>
        <div class="skill-badge" style="animation-delay: 0.7s;">MongoDB</div>
        <div class="skill-badge" style="animation-delay: 0.8s;">Machine Learning</div>
        <div class="skill-badge" style="animation-delay: 0.9s;">Cloud Computing</div>
    </div>
</section>

<!-- Live Activity Feed -->
<section class="activity-feed">
    <h3>&#128293; Live Activity</h3>
    <div class="activity-list">
        <div class="activity-item">
            <i class="fas fa-trophy activity-icon"></i>
            <div class="activity-text">
                <div><span class="activity-user">Emma Wilson</span> <span class="activity-action">completed Java Certification</span></div>
                <div class="activity-time">2 minutes ago</div>
            </div>
        </div>
        
        <div class="activity-item">
            <i class="fas fa-star activity-icon"></i>
            <div class="activity-text">
                <div><span class="activity-user">Raj Patel</span> <span class="activity-action">earned 5-star rating in Python</span></div>
                <div class="activity-time">5 minutes ago</div>
            </div>
        </div>
        
        <div class="activity-item">
            <i class="fas fa-graduation-cap activity-icon"></i>
            <div class="activity-text">
                <div><span class="activity-user">Maria Garcia</span> <span class="activity-action">started JavaScript Bootcamp</span></div>
                <div class="activity-time">12 minutes ago</div>
            </div>
        </div>
        
        <div class="activity-item">
            <i class="fas fa-medal activity-icon"></i>
            <div class="activity-text">
                <div><span class="activity-user">Tom Brown</span> <span class="activity-action">unlocked Database Expert badge</span></div>
                <div class="activity-time">18 minutes ago</div>
            </div>
        </div>
    </div>
</section>

<!-- Chat Toggle Button -->


<!-- First Chat: AI ChatBot -->

<footer>
    <div class="footer-content">
        <div class="footer-col">
            <h4>Platform</h4>
            <ul>
                <li><a href="Scroll1.jsp">Courses</a></li>
                <li><a href="#">Certifications</a></li>
                <li><a href="#">Learning Paths</a></li>
                <li><a href="#">Pricing</a></li>
            </ul>
        </div>
        <div class="footer-col">
            <h4>Company</h4>
            <ul>
                <li><a href="about.html">About Us</a></li>
                <li><a href="#">Careers</a></li>
                <li><a href="#">Blog</a></li>
                <li><a href="contact.html">Contact</a></li>
            </ul>
        </div>
        <div class="footer-col">
            <h4>Resources</h4>
            <ul>
                <li><a href="#">Documentation</a></li>
                <li><a href="#">Community</a></li>
                <li><a href="#">Support</a></li>
                <li><a href="#">FAQ</a></li>
            </ul>
        </div>
        <div class="footer-col">
            <h4>Legal</h4>
            <ul>
                <li><a href="#">Privacy Policy</a></li>
                <li><a href="#">Terms of Service</a></li>
                <li><a href="#">Cookie Policy</a></li>
            </ul>
        </div>
    </div>
    <div class="footer-bottom">
        <p>&copy;
         2024 Knowledge Check. All rights reserved. Built with  &#x2665; for learners worldwide.</p>
    </div>
</footer>
<script>
document.addEventListener('DOMContentLoaded', function () {
	  // Modal button references
	  window.openLoginBtn = document.getElementById('openLoginBtn');
	  window.openRegisterBtn = document.getElementById('openRegisterBtn');

	  const loginModal = document.getElementById('loginModal');
	  const registerModal = document.getElementById('registerModal');

	  // Open modals
	  openLoginBtn.onclick = () => {
	    loginModal.style.display = 'flex';
	    registerModal.style.display = 'none';
	  };
	  
	  openRegisterBtn.onclick = () => {
	    registerModal.style.display = 'flex';
	    loginModal.style.display = 'none';
	  };

	  // DEBUG: Check if form is submitting
	  const registerForm = document.getElementById('registerForm');
	  if (registerForm) {
	    registerForm.addEventListener('submit', function(e) {
	      console.log('&#x2713;Form is being submitted to servlet');
	      // Don't use e.preventDefault() - let it submit naturally
	    });
	  }
	});

	// Close modal function
	window.closeModal = function(id) {
	  document.getElementById(id).style.display = 'none';
	};

	// Click outside modal to close
	// Click outside modal to close
window.onclick = (e) => {
  if (e.target.classList.contains('modal')) {
    e.target.style.display = 'none';
  }
  // Do NOT close panel here - panel uses its own backdrop onclick
};
</script>





<script>
function animateCounter(element) {
    const target = parseInt(element.getAttribute('data-target'));
    const duration = 2000;
    const increment = target / (duration / 16);
    let current = 0;
    
    const updateCounter = () => {
        current += increment;
        if (current < target) {
            element.textContent = Math.floor(current).toLocaleString();
            requestAnimationFrame(updateCounter);
        } else {
            element.textContent = target.toLocaleString();
        }
    };
    
    updateCounter();
}

// Trigger counter animation when stats section is visible
const observerStats = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            const counters = entry.target.querySelectorAll('.stat-number');
            counters.forEach(counter => animateCounter(counter));
            observerStats.unobserve(entry.target);
        }
    });
}, { threshold: 0.5 });

const statsSection = document.querySelector('.stats-section');
if (statsSection) {
    observerStats.observe(statsSection);
}

// ========================================
// PROGRESS BAR ANIMATION
// ========================================
const observerProgress = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            const progressBars = entry.target.querySelectorAll('.progress-bar');
            progressBars.forEach(bar => {
                const progress = bar.getAttribute('data-progress');
                setTimeout(() => {
                    bar.style.width = progress + '%';
                }, 200);
            });
            observerProgress.unobserve(entry.target);
        }
    });
}, { threshold: 0.3 });

const progressTracker = document.querySelector('.progress-tracker');
if (progressTracker) {
    observerProgress.observe(progressTracker);
}

// ========================================
// TESTIMONIAL CAROUSEL
// ========================================
let currentTestimonial = 0;
const testimonialCards = document.querySelectorAll('.testimonial-card');
const dots = document.querySelectorAll('.dot');

function showTestimonial(index) {
    testimonialCards.forEach(card => card.classList.remove('active'));
    dots.forEach(dot => dot.classList.remove('active'));
    
    testimonialCards[index].classList.add('active');
    dots[index].classList.add('active');
    currentTestimonial = index;
}

// Auto-rotate testimonials every 5 seconds
setInterval(() => {
    currentTestimonial = (currentTestimonial + 1) % testimonialCards.length;
    showTestimonial(currentTestimonial);
}, 5000);

// ========================================
// LIVE ACTIVITY FEED UPDATES
// ========================================
const activities = [
    { user: "Lisa Anderson", action: "completed React Course", icon: "trophy" },
    { user: "David Kim", action: "earned Full Stack badge", icon: "medal" },
    { user: "Sophie Turner", action: "started AI Fundamentals", icon: "graduation-cap" },
    { user: "James Miller", action: "achieved 100% in Python quiz", icon: "star" }
];

function addNewActivity() {
    const activityList = document.querySelector('.activity-list');
    if (!activityList) return;
    
    const randomActivity = activities[Math.floor(Math.random() * activities.length)];
    
    const newActivity = document.createElement('div');
    newActivity.className = 'activity-item';
    newActivity.style.animation = 'slideInLeft 0.5s ease';
    newActivity.innerHTML = `
        <i class="fas fa-${randomActivity.icon} activity-icon"></i>
        <div class="activity-text">
            <div><span class="activity-user">${randomActivity.user}</span> <span class="activity-action">${randomActivity.action}</span></div>
            <div class="activity-time">Just now</div>
        </div>
    `;
    
    activityList.insertBefore(newActivity, activityList.firstChild);
    
    // Remove oldest activity if more than 5
    if (activityList.children.length > 5) {
        activityList.removeChild(activityList.lastChild);
    }
}

// Add new activity every 15 seconds
setInterval(addNewActivity, 15000);

// ========================================
// SKILL BADGE HOVER EFFECTS
// ========================================
document.querySelectorAll('.skill-badge').forEach(badge => {
    badge.addEventListener('mouseenter', function() {
        this.style.transform = 'translateY(-5px) scale(1.05) rotate(2deg)';
    });
    
    badge.addEventListener('mouseleave', function() {
        this.style.transform = 'translateY(0) scale(1) rotate(0deg)';
    });
});
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
        makeTeamCard('\uD83D\uDC68\u200D\uD83D\uDCBB','Amrapali Raddi','Founder & CEO','Computer Science Student, from Sangola Mahavidyalaya Sangola. Passionate about democratising technical education.','linear-gradient(135deg,#1e3a8a,#0f172a)'),
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

</body>
</html>