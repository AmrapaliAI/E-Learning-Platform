<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Login | Premium Experience</title>
    <style>
        :root {
            --primary: #667eea;
            --secondary: #764ba2;
            --accent: #ff007a;
            --glass: rgba(255, 255, 255, 0.9);
            --text: #2d3748;
        }

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Inter', -apple-system, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 20px;
            overflow: hidden;
        }

        /* Animated Background Orbs */
        .orb {
            position: absolute;
            border-radius: 50%;
            filter: blur(80px);
            z-index: 0;
            opacity: 0.4;
            animation: float 10s infinite alternate;
        }
        .orb-1 { width: 400px; height: 400px; background: #8fd3f4; top: -100px; left: -100px; }
        .orb-2 { width: 300px; height: 300px; background: #f68084; bottom: -50px; right: -50px; animation-delay: -2s; }

        @keyframes float {
            0% { transform: translate(0, 0); }
            100% { transform: translate(30px, 50px); }
        }

        .login-container {
            background: var(--glass);
            backdrop-filter: blur(15px);
            border: 1px solid rgba(255, 255, 255, 0.3);
            border-radius: 24px;
            box-shadow: 0 25px 50px -12px rgba(0, 0, 0, 0.25);
            padding: 40px;
            width: 100%;
            max-width: 420px;
            position: relative;
            z-index: 10;
            animation: slideUp 0.8s cubic-bezier(0.16, 1, 0.3, 1);
        }

        @keyframes slideUp {
            from { opacity: 0; transform: translateY(40px); }
            to { opacity: 1; transform: translateY(0); }
        }

        h1 {
            color: var(--text);
            font-size: 2rem;
            text-align: center;
            margin-bottom: 30px;
            font-weight: 800;
        }

        .input-group {
            position: relative;
            margin-bottom: 20px;
        }

        label {
            display: block;
            font-size: 0.9rem;
            font-weight: 600;
            color: #555;
            margin-bottom: 8px;
            margin-left: 5px;
        }

        .F {
            width: 100%;
            padding: 14px 18px;
            border: 2px solid #e2e8f0;
            border-radius: 12px;
            font-size: 1rem;
            transition: all 0.3s;
            background: white;
            color: var(--text);
        }

        .F:focus {
            outline: none;
            border-color: var(--primary);
            box-shadow: 0 0 0 4px rgba(102, 126, 234, 0.15);
        }

        #u {
            position: absolute;
            right: 15px;
            top: 42px;
            cursor: pointer;
            font-size: 1.2rem;
            opacity: 0.6;
            transition: 0.3s;
        }

        #u:hover { opacity: 1; color: var(--primary); }

        .Error {
            color: #e53e3e;
            font-size: 0.85rem;
            margin-top: 5px;
            font-weight: 500;
        }

        button {
            width: 100%;
            padding: 16px;
            background: linear-gradient(135deg, var(--primary) 0%, var(--secondary) 100%);
            color: white;
            border: none;
            border-radius: 12px;
            font-size: 1.1rem;
            font-weight: 700;
            cursor: pointer;
            transition: all 0.3s;
            margin-top: 10px;
            box-shadow: 0 10px 15px -3px rgba(102, 126, 234, 0.4);
        }

        button:hover {
            transform: translateY(-2px);
            box-shadow: 0 20px 25px -5px rgba(102, 126, 234, 0.5);
            filter: brightness(1.1);
        }

        button:active { transform: translateY(0); }

        .footer-text {
            text-align: center;
            margin-top: 25px;
            font-size: 0.9rem;
            color: #718096;
        }

        .footer-text a {
            color: var(--primary);
            text-decoration: none;
            font-weight: 600;
        }

        .footer-text a:hover { text-decoration: underline; }

    </style>
</head>
<body>

<div class="orb orb-1"></div>
<div class="orb orb-2"></div>

<div class="login-container">
    <h1>Welcome Back</h1>

    <form action="Validate" method="post">
        
        <div class="input-group">
            <label>Email Address</label>
            <input type="text" name="Name" class="F" placeholder="name@company.com" autocomplete="username">
            <div class="Error">
                <% String Error=(String)request.getAttribute("Error"); if(Error!=null) out.print(Error); %>
            </div>
        </div>

        <div class="input-group">
            <label>Password</label>
            <input type="password" id="passwordField" name="Password" class="F" placeholder="" autocomplete="current-password">
            <span id="u" onclick="togglePasswordVisibility()">&#128065;</span>
            <div class="Error">
                <% String E=(String)request.getAttribute("E"); if(E!=null) out.print(E); %>
            </div>
        </div>
        <div class="Error">
                <% String regu=(String)request.getAttribute("regu"); if(regu!=null) out.print(regu); %>
            </div>

        <button type="submit">Sign In</button>

        <div class="Error" style="text-align: center; margin-top: 10px;">
            <% String U=(String)request.getAttribute("U"); if(U!=null) out.print(U); %>
        </div>

        <p class="footer-text">
            Don't have an account? <a href="Register.jsp">Register here</a>
        </p>
        
        <div class="Error">
            <% String Invalid=(String)request.getAttribute("Invalid"); if(Invalid!=null) out.print(Invalid); %>
        </div>
    </form>
</div>

<script>
function togglePasswordVisibility() {
    const passwordInput = document.getElementById('passwordField');
    const icon = document.getElementById('u');
    
    if (passwordInput.type === 'password') {
        passwordInput.type = 'text';
        icon.innerHTML = '&#128584;';
    } else {
        passwordInput.type = 'password';
        icon.innerHTML  ='&#128065;'
    }
}
</script>

</body>
</html>