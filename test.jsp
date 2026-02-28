<%@ page import="java.util.List" %>
<%@ page import="User.Question" %>
<%@ page import="java.lang.Character" %>
<% 
    // 1. Retrieve the randomized quiz list from the session
    List<Question> quizQuestions = (List<Question>) session.getAttribute("currentQuizQuestions");
    
    // Safety check in case the session list is empty or missing
    if (quizQuestions == null || quizQuestions.isEmpty()) {
        // Handle case where quiz hasn't been started (e.g., redirect to start page)
        response.sendRedirect("index1.jsp"); 
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            background-image: url("data-sciences.jpg");
            background-size: cover;
            background-attachment: fixed;
            background-position: center;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            padding: 20px;
            min-height: 100vh;
            position: relative;
        }

        body::before {
            content: '';
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.4);
            z-index: 0;
        }

        #quiz-timer {
            color: #ff4444;
            font-size: 28px;
            font-weight: bold;
            background: rgba(255, 255, 255, 0.95);
            padding: 15px 30px;
            border-radius: 12px;
            text-align: center;
            box-shadow: 0 8px 25px rgba(255, 68, 68, 0.3);
            position: sticky;
            top: 20px;
            z-index: 1000;
            margin-bottom: 20px;
            backdrop-filter: blur(10px);
            border: 3px solid #ff4444;
            animation: pulse 2s infinite;
        }

        @keyframes pulse {
            0%, 100% { transform: scale(1); }
            50% { transform: scale(1.02); }
        }

        hr {
            border: none;
            height: 3px;
            background: linear-gradient(90deg, #667eea, #764ba2, #667eea);
            margin-bottom: 30px;
            border-radius: 5px;
            position: relative;
            z-index: 1;
        }

        .U {
            border: 5px solid #667eea;
            width: 90%;
            max-width: 1000px;
            font-size: 18px;
            margin: 0 auto;
            background: rgba(255, 255, 255, 0.98);
            border-radius: 20px;
            padding: 50px 60px;
            box-shadow: 0 15px 50px rgba(0, 0, 0, 0.3);
            position: relative;
            z-index: 1;
            backdrop-filter: blur(10px);
        }

        h5 {
            font-size: 22px;
            color: #1e293b;
            margin-bottom: 20px;
            margin-top: 35px;
            padding: 18px 25px;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            border-radius: 12px;
            box-shadow: 0 6px 20px rgba(102, 126, 234, 0.3);
            font-weight: 700;
            line-height: 1.6;
        }

        label {
            display: block;
            font-size: 19px;
            padding: 16px 20px;
            margin-bottom: 15px;
            background: white;
            border: 3px solid #e2e8f0;
            border-radius: 12px;
            cursor: pointer;
            transition: all 0.3s ease;
            box-shadow: 0 3px 10px rgba(0, 0, 0, 0.05);
            position: relative;
            overflow: hidden;
        }

        label:hover {
            background: linear-gradient(135deg, #f0f4ff 0%, #e8f0ff 100%);
            border-color: #667eea;
            transform: translateX(8px);
            box-shadow: 0 6px 20px rgba(102, 126, 234, 0.2);
        }

        label.selected {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            border-color: #667eea;
            font-weight: 600;
            box-shadow: 0 8px 25px rgba(102, 126, 234, 0.4);
        }

        input[type="radio"] {
            width: 22px;
            height: 22px;
            margin-right: 15px;
            cursor: pointer;
            accent-color: #667eea;
            vertical-align: middle;
        }

        BR {
            display: none;
        }

        Center {
            margin-top: 50px;
            padding-top: 30px;
            border-top: 4px solid #e2e8f0;
        }

        input[type="Submit"] {
            height: 60px;
            width: 200px;
            border: 4px solid #10b981;
            color: white;
            font-size: 24px;
            border-radius: 30px;
            background: linear-gradient(135deg, #10b981 0%, #059669 100%);
            cursor: pointer;
            font-weight: bold;
            box-shadow: 0 8px 25px rgba(16, 185, 129, 0.4);
            transition: all 0.3s ease;
            text-transform: uppercase;
            letter-spacing: 2px;
        }

        input[type="Submit"]:hover {
            transform: translateY(-4px);
            box-shadow: 0 12px 35px rgba(16, 185, 129, 0.5);
            background: linear-gradient(135deg, #059669 0%, #047857 100%);
        }

        input[type="Submit"]:active {
            transform: translateY(-2px);
        }

        .time-display {
            font-size: 23px;
            font-weight: bold;
            color: orange;
        }

        #current-local-time {
            color: green;
        }

        B {
            font-size: 19px;
        }

        /* Responsive design */
        @media (max-width: 768px) {
            .U {
                width: 95%;
                padding: 30px 25px;
                font-size: 16px;
            }

            h5 {
                font-size: 18px;
                padding: 15px 20px;
            }

            label {
                font-size: 17px;
                padding: 14px 18px;
            }

            #quiz-timer {
                font-size: 22px;
                padding: 12px 20px;
            }

            input[type="Submit"] {
                width: 160px;
                height: 55px;
                font-size: 20px;
            }
        }

        /* Scroll to top button */
        .scroll-top {
            position: fixed;
            bottom: 30px;
            right: 30px;
            width: 55px;
            height: 55px;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            border: none;
            border-radius: 50%;
            font-size: 24px;
            cursor: pointer;
            box-shadow: 0 6px 20px rgba(102, 126, 234, 0.4);
            opacity: 0;
            transition: all 0.3s ease;
            z-index: 999;
        }

        .scroll-top.visible {
            opacity: 1;
        }

        .scroll-top:hover {
            transform: translateY(-5px);
            box-shadow: 0 8px 25px rgba(102, 126, 234, 0.5);
        }
    </style>
</head>
<body>
    <div id="quiz-timer">Time Remaining: 40:00</div>
    <hr/>
    
    <form class="U" method="POST" action="QuizCheckServlet">
        <% 
            int questionNum = 1;
            // 2. Loop through every Question object in the randomized list
            for (Question q : quizQuestions) { 
        %>
            <h5>Q<%= questionNum %>: <%= q.getQuestionText() %></h5>
            
            <% 
                int optionIndex = 0;
                // 4. Loop through the List<String> of options
                for (String optionText : q.getOptions()) { 
                    // Calculate the option letter (A=65, B=66, etc.)
                    char optionLetter = (char)('A' + optionIndex);
            %>
                <label data-question="<%= questionNum %>">
                    <input type="radio" 
                           name="answer_<%= questionNum %>" 
                           value="<%= optionIndex %>" 
                           onclick="toggleRadio(this)">
                    <%= optionLetter %>. <%= optionText %>
                </label>
                <BR><BR>
            <% 
                    optionIndex++;
                } 
            %>
        <% 
                questionNum++;
            } 
        %>
        
        <Center>
            <input type="Submit" value="Submit">
        </Center>
    </form>

    <button class="scroll-top" id="scrollTopBtn" onclick="scrollToTop()">↑</button>
    
    <script src="time1.js"></script>
    <script>
        let R = null;
        
        function toggleRadio(currentRadio) {
            const label = currentRadio.closest('label');
            const questionName = currentRadio.name;
            
            // Remove selected class from all labels in the same question
            const allLabelsInQuestion = document.querySelectorAll(`label[data-question="${label.getAttribute('data-question')}"]`);
            allLabelsInQuestion.forEach(l => l.classList.remove('selected'));
            
            if (currentRadio === R) {
                currentRadio.checked = false;
                R = null;
            } else {
                R = currentRadio;
                label.classList.add('selected');
            }
        }

        // Scroll to top functionality
        window.addEventListener('scroll', function() {
            const scrollBtn = document.getElementById('scrollTopBtn');
            if (window.pageYOffset > 300) {
                scrollBtn.classList.add('visible');
            } else {
                scrollBtn.classList.remove('visible');
            }
        });
        
        function scrollToTop() {
            window.scrollTo({ top: 0, behavior: 'smooth' });
        }

        // Add selected class on page load if radio is checked
        document.addEventListener('DOMContentLoaded', function() {
            const checkedRadios = document.querySelectorAll('input[type="radio"]:checked');
            checkedRadios.forEach(radio => {
                radio.closest('label').classList.add('selected');
            });
        });
    </script>
</body>
</html>