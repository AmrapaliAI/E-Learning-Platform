<!DOCTYPE html>
<html>
<head>
<style>
    /* Global Reset & Background */
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        min-height: 100vh;
        margin: 0;
        padding: 20px;
    }

    h1 {
        color: white;
        text-shadow: 2px 2px 4px rgba(0,0,0,0.2);
        margin-bottom: 20px;
    }

    /* Modern Glassmorphism Card */
    .U1 {
        background: #ffffff;
        width: 100%;
        max-width: 450px;
        padding: 40px;
        border-radius: 20px;
        box-shadow: 0 15px 35px rgba(0,0,0,0.2);
        box-sizing: border-box;
    }

    /* Labels and Icons */
    .field-group {
        margin-bottom: 18px;
    }

    label {
        display: block;
        font-weight: 600;
        color: #444;
        margin-bottom: 8px;
        font-size: 14px;
    }

    .M { color: #ff4d4d; margin-right: 4px; } /* Red asterisk */

    /* Sleek Inputs */
    .F {
        width: 100%;
        padding: 12px 15px;
        border: 2px solid #e1e8ef;
        border-radius: 10px;
        font-size: 15px;
        transition: all 0.3s ease;
        box-sizing: border-box; /* Critical for layout */
    }

    .F:focus {
        outline: none;
        border-color: #667eea;
        box-shadow: 0 0 8px rgba(102, 126, 234, 0.3);
    }

    textarea.F {
        resize: none;
        height: 80px;
    }

    /* Attractive Error Messages */
    .error-msg {
        color: #ff4d4d;
        font-size: 12px;
        margin-top: 5px;
        font-weight: 500;
    }

    /* Primary Submit Button */
    input[type="submit"] {
        background: linear-gradient(to right, #667eea, #764ba2);
        color: white;
        border: none;
        padding: 15px;
        width: 100%;
        border-radius: 10px;
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
        transition: transform 0.2s, box-shadow 0.2s;
        margin-top: 10px;
    }

    input[type="submit"]:hover {
        transform: translateY(-2px);
        box-shadow: 0 5px 15px rgba(118, 75, 162, 0.4);
    }
</style>

<body>

<h1>Student Registration</h1>

<form action="New" class="U1" method="post">
    
    <div class="field-group">
        <label><span class="M">*</span>Your Name</label>
        <input type="text" name="Name" value="<%=session.getAttribute("name2")!=null?session.getAttribute("name2"):"" %>" class="F" placeholder="e.g. John Doe">
        <div class="error-msg"><%= request.getAttribute("E") != null ? request.getAttribute("E") : "" %></div>
    </div>

    <div class="field-group">
        <label><span class="M">*</span>Email Address</label>
        <input type="email" name="email" value="<%=session.getAttribute("email")!=null?session.getAttribute("email"):"" %>" class="F" placeholder="john@example.com">
        <div class="error-msg">
            <%= request.getAttribute("Error") != null ? request.getAttribute("Error") : "" %>
            <%= request.getAttribute("Email") != null ? request.getAttribute("Email") : "" %>
        </div>
    </div>

    <div class="field-group">
        <label><span class="M">*</span>Mobile Number</label>
        <input type="number" name="Number" value="<%=session.getAttribute("number")!=null?session.getAttribute("number"):"" %>" class="F" placeholder="+91 0000000000">
        <div class="error-msg"><%= request.getAttribute("M") != null ? request.getAttribute("M") : "" %></div>
    </div>

    <div class="field-group">
        <label><span class="M">*</span>Class</label>
        <input type="text" name="C" value="<%=session.getAttribute("C")!=null?session.getAttribute("C"):"" %>" class="F" placeholder="Current Grade/Class">
        <div class="error-msg"><%= request.getAttribute("Class") != null ? request.getAttribute("Class") : "" %></div>
    </div>

    <div class="field-group">
        <label><span class="M">*</span>Create Password</label>
        <input type="password" name="Password" class="F" placeholder="Min 8 characters">
        <div class="error-msg"><%= request.getAttribute("Password") != null ? request.getAttribute("Password") : "" %></div>
    </div><div class="error-msg"><%= request.getAttribute("regu") != null ? request.getAttribute("regu") : "" %></div>
    </div>

    <div class="field-group">
        <label><span class="M">*</span>Confirm Password</label>
        <input type="password" name="P" class="F" placeholder="Repeat password">
        <div class="error-msg"><%= request.getAttribute("P") != null ? request.getAttribute("P") : "" %></div>
    </div><div class="error-msg"><%= request.getAttribute("regu4") != null ? request.getAttribute("regu4") : "" %></div>
    </div>

    <div class="field-group">
        <label>Residential Address</label>
        <textarea name="A" class="F" placeholder="Enter full address..."><%=session.getAttribute("Addr")!=null?session.getAttribute("Addr"):"" %></textarea>
        <div class="error-msg"><%= request.getAttribute("Address") != null ? request.getAttribute("Address") : "" %></div>
    </div>

    <input type="submit" value="Register Now">
    
    <div class="error-msg" style="text-align:center; margin-top:10px;">
        <%= request.getAttribute("U") != null ? request.getAttribute("U") : "" %>
    </div>
</form>

</body>