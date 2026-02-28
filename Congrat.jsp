<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><head>
<!-- Add ResponsiveVoice API -->
<script
src="https://code.responsivevoice.org/responsivevoice.js?key=SSaAv3or"></script><meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Congratulations</title>
<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    body {
        height: 100vh;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(
            rgba(0,0,0,0.7),
            rgba(0,0,0,0.7)
        ), url("data-sciences.jpg");
        background-size: cover;
        background-position: center;
        background-attachment: fixed;
        display: flex;
        justify-content: center;
        align-items: center;
        color: white;
        overflow: hidden;
        position: relative;
    }

    /* Animated Confetti Background */
    .confetti {
        position: fixed;
        width: 10px;
        height: 10px;
        background: #ffd700;
        position: absolute;
        animation: confetti-fall 3s linear infinite;
    }

    @keyframes confetti-fall {
        to {
            transform: translateY(100vh) rotate(360deg);
            opacity: 0;
        }
    }

    /* Main Card */
    .congrats-card {
        background: rgba(255, 255, 255, 0.15);
        backdrop-filter: blur(15px);
        border-radius: 30px;
        padding: 60px 70px;
        text-align: center;
        box-shadow: 
            0 30px 80px rgba(0,0,0,0.7),
            0 0 0 1px rgba(255,255,255,0.1);
        animation: cardEntrance 1s ease-out;
        max-width: 600px;
        position: relative;
        border: 2px solid rgba(255, 165, 0, 0.3);
    }

    @keyframes cardEntrance {
        from { 
            opacity: 0; 
            transform: scale(0.8) translateY(50px); 
        }
        to { 
            opacity: 1; 
            transform: scale(1) translateY(0); 
        }
    }

    /* Trophy Icon */
    .trophy-container {
        margin-bottom: 20px;
        animation: trophyBounce 2s ease-in-out infinite;
    }

    @keyframes trophyBounce {
        0%, 100% { transform: translateY(0) rotate(0deg); }
        50% { transform: translateY(-15px) rotate(5deg); }
    }

    .trophy {
        font-size: 100px;
        filter: drop-shadow(0 10px 20px rgba(255, 215, 0, 0.5));
    }

    /* Heading */
    .congrats-card h1 {
        color: #ffa500;
        font-size: 56px;
        margin-bottom: 15px;
        text-shadow: 
            0 0 20px rgba(255, 165, 0, 0.8),
            3px 3px 8px rgba(0, 0, 0, 0.8);
        animation: glow 2s ease-in-out infinite alternate;
        font-weight: 900;
        letter-spacing: 2px;
    }

    @keyframes glow {
        from { text-shadow: 0 0 10px rgba(255, 165, 0, 0.5), 3px 3px 8px rgba(0, 0, 0, 0.8); }
        to { text-shadow: 0 0 30px rgba(255, 215, 0, 1), 3px 3px 8px rgba(0, 0, 0, 0.8); }
    }

    /* Success Message */
    .congrats-card p {
        font-size: 22px;
        margin-bottom: 30px;
        color: #f8fafc;
        line-height: 1.6;
        font-weight: 500;
        text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.6);
    }

    /* Image Container */
    .image-container {
        margin: 30px 0;
        position: relative;
    }

    .congrats-card img {
        width: 200px;
        border-radius: 20px;
        box-shadow: 0 15px 40px rgba(0, 0, 0, 0.5);
        animation: imagePulse 2s ease-in-out infinite;
        border: 4px solid rgba(255, 215, 0, 0.5);
    }

    @keyframes imagePulse {
        0%, 100% { transform: scale(1); }
        50% { transform: scale(1.08); }
    }

    /* Stars Animation */
    .stars {
        font-size: 40px;
        margin: 20px 0;
        animation: starSpin 3s linear infinite;
    }

    @keyframes starSpin {
        from { transform: rotate(0deg); }
        to { transform: rotate(360deg); }
    }

    /* Button */
    .btn {
        display: inline-block;
        padding: 18px 45px;
        background: linear-gradient(135deg, #f59e0b, #d97706);
        color: white;
        text-decoration: none;
        border-radius: 50px;
        font-size: 20px;
        font-weight: 700;
        transition: all 0.3s ease;
        box-shadow: 
            0 10px 30px rgba(245, 158, 11, 0.5),
            inset 0 -3px 0 rgba(0, 0, 0, 0.2);
        position: relative;
        overflow: hidden;
        margin-top: 15px;
    }

    .btn::before {
        content: '';
        position: absolute;
        top: 50%;
        left: 50%;
        width: 0;
        height: 0;
        border-radius: 50%;
        background: rgba(255, 255, 255, 0.3);
        transform: translate(-50%, -50%);
        transition: width 0.6s, height 0.6s;
    }

    .btn:hover::before {
        width: 300px;
        height: 300px;
    }

    .btn:hover {
        transform: translateY(-5px);
        box-shadow: 
            0 15px 40px rgba(245, 158, 11, 0.7),
            inset 0 -3px 0 rgba(0, 0, 0, 0.2);
    }

    .btn span {
        position: relative;
        z-index: 1;
    }

    /* Speaking Indicator */
    .speaking-indicator {
        position: fixed;
        top: 30px;
        right: 30px;
        background: linear-gradient(135deg, #10b981, #059669);
        backdrop-filter: blur(10px);
        border: 2px solid rgba(255, 255, 255, 0.3);
        border-radius: 50px;
        padding: 12px 25px;
        display: flex;
        align-items: center;
        gap: 10px;
        box-shadow: 0 8px 20px rgba(16, 185, 129, 0.4);
        animation: pulse 1.5s ease-in-out infinite;
        color: white;
        font-weight: 600;
        font-size: 14px;
    }

    @keyframes pulse {
        0%, 100% { transform: scale(1); opacity: 1; }
        50% { transform: scale(1.05); opacity: 0.9; }
    }

    .speaking-wave {
        display: flex;
        gap: 3px;
        align-items: center;
    }

    .speaking-bar {
        width: 3px;
        height: 15px;
        background: white;
        border-radius: 3px;
        animation: wave 1s ease-in-out infinite;
    }

    .speaking-bar:nth-child(1) { animation-delay: 0s; }
    .speaking-bar:nth-child(2) { animation-delay: 0.1s; }
    .speaking-bar:nth-child(3) { animation-delay: 0.2s; }
    .speaking-bar:nth-child(4) { animation-delay: 0.3s; }

    @keyframes wave {
        0%, 100% { height: 15px; }
        50% { height: 25px; }
    }

    /* Fireworks Effect */
    .firework {
        position: absolute;
        width: 4px;
        height: 4px;
        background: #ffd700;
        border-radius: 50%;
        animation: firework 1s ease-out forwards;
    }

    @keyframes firework {
        0% {
            transform: translate(0, 0);
            opacity: 1;
        }
        100% {
            transform: translate(var(--x), var(--y));
            opacity: 0;
        }
    }

    /* Responsive Design */
    @media (max-width: 768px) {
        .congrats-card {
            padding: 40px 30px;
            margin: 20px;
        }
        
        .congrats-card h1 {
            font-size: 40px;
        }
        
        .congrats-card p {
            font-size: 18px;
        }
        
        .congrats-card img {
            width: 150px;
        }
    }
</style>
</head>
<body>

<!-- Speaking Indicator (shows when voice is speaking) -->
<div class="speaking-indicator" id="speakingIndicator" style="display: none;">
    <div class="speaking-wave">
        <div class="speaking-bar"></div>
        <div class="speaking-bar"></div>
        <div class="speaking-bar"></div>
        <div class="speaking-bar"></div>
    </div>
    <span>Speaking...</span>
</div>

<!-- Confetti Background -->
<script>
// Generate confetti
for(let i = 0; i < 50; i++) {
    let confetti = document.createElement('div');
    confetti.className = 'confetti';
    confetti.style.left = Math.random() * 100 + 'vw';
    confetti.style.animationDelay = Math.random() * 3 + 's';
    confetti.style.background = ['#ffd700', '#ff6b6b', '#4ecdc4', '#45b7d1', '#f39c12'][Math.floor(Math.random() * 5)];
    document.body.appendChild(confetti);
}
</script>

<!-- Main Congratulations Card -->
<div class="congrats-card">
    <div class="trophy-container">
        <div class="trophy"> &#x1F3C6;</div>
    </div>
    
    <h1>&#x1F389; Congratulations! &#x1F389;</h1>
    
    <p>You have successfully completed the course<br>with outstanding achievement!</p>
    
    <div class="stars">&#x2B50;&#x2728;&#x2B50;
</div>
    
    <div class="image-container">
        <img src="Cong.jpg" alt="Congratulations">
    </div>
    
    <a class="btn" href="Certificate.jsp">
        <span>&#x1F393; View Your Achievement</span>
    </a>
</div>

<script>
// Using ResponsiveVoice API - MUCH MORE RELIABLE
window.addEventListener('load', function() {
    setTimeout(function() {
        if (typeof responsiveVoice !== 'undefined') {
            document.getElementById('speakingIndicator').style.display = 'flex';
            
            responsiveVoice.speak(
                "Congratulations! You have successfully completed the course with outstanding achievement. Excellent work!",
                "UK English Female",
                {
                    pitch: 1.2,
                    rate: 0.9,
                    volume: 1,
                    onend: function() {
                        document.getElementById('speakingIndicator').style.display = 'none';
                    }
                }
            );
        }
    }, 1000);
});

// Fireworks code remains the same
function createFirework(x, y) {
    for(let i = 0; i < 30; i++) {
        const firework = document.createElement('div');
        firework.className = 'firework';
        firework.style.left = x + 'px';
        firework.style.top = y + 'px';
        
        const angle = (Math.PI * 2 * i) / 30;
        const velocity = 50 + Math.random() * 50;
        firework.style.setProperty('--x', Math.cos(angle) * velocity + 'px');
        firework.style.setProperty('--y', Math.sin(angle) * velocity + 'px');
        
        firework.style.background = ['#ffd700', '#ff6b6b', '#4ecdc4', '#45b7d1'][Math.floor(Math.random() * 4)];
        
        document.body.appendChild(firework);
        
        setTimeout(() => firework.remove(), 1000);
    }
}

setTimeout(() => createFirework(window.innerWidth / 2, window.innerHeight / 3), 1200);
setTimeout(() => createFirework(window.innerWidth / 3, window.innerHeight / 2), 1700);
setTimeout(() => createFirework(2 * window.innerWidth / 3, window.innerHeight / 2), 2200);
</script>
</body>
</html>