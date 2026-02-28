package User;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ChatServlet")
public class ChatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/plain;charset=UTF-8");
        String message = request.getParameter("message");
        String reply = getBotReply(message);
        response.getWriter().write(reply);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    
    private String getBotReply(String message) {
        if(message == null || message.trim().isEmpty()) {
            return "I didn't understand.";
        }
        
        message = message.trim().toLowerCase();
        
        // JAVA RELATED
        if(message.contains("java type") || message.contains("types of java")) {
            return "Java has three main types: 1) JDK (Java Development Kit) - contains tools for developing Java applications, 2) JRE (Java Runtime Environment) - provides libraries and JVM to run Java applications, 3) JVM (Java Virtual Machine) - executes Java bytecode on any platform.";
        } 
        else if(message.contains("java feature") || message.contains("features of java")) {
            return "Key Java features: 1) Platform Independent (Write Once, Run Anywhere), 2) Object-Oriented, 3) Secure, 4) Robust (strong memory management), 5) Multithreaded, 6) Architectural Neutral, 7) High Performance with JIT compiler, 8) Distributed computing support.";
        }
        else if(message.contains("oops") || message.contains("oop concept")) {
            return "OOP concepts in Java: 1) Encapsulation - bundling data and methods, 2) Inheritance - acquiring properties from parent class, 3) Polymorphism - one interface, multiple implementations, 4) Abstraction - hiding implementation details. These enable code reusability and modularity.";
        }
        else if(message.contains("java collection") || message.contains("collection framework")) {
            return "Java Collection Framework includes: List (ArrayList, LinkedList), Set (HashSet, TreeSet, LinkedHashSet), Map (HashMap, TreeMap, LinkedHashMap), Queue (PriorityQueue, Deque). Collections provide dynamic data structures for storing and manipulating groups of objects.";
        }
        else if(message.contains("exception handling") && message.contains("java")) {
            return "Java Exception Handling uses try-catch-finally blocks. Exceptions are: Checked (IOException, SQLException) - must be handled, Unchecked (NullPointerException, ArrayIndexOutOfBounds) - runtime exceptions. Use throw to raise exceptions and throws to declare them.";
        }
        else if(message.contains("multithreading") || message.contains("thread")) {
            return "Java Multithreading allows concurrent execution. Create threads by: 1) Extending Thread class, 2) Implementing Runnable interface. Thread lifecycle: New, Runnable, Running, Blocked, Dead. Use synchronized keyword for thread safety and avoid race conditions.";
        }
        
        // PYTHON RELATED
        else if(message.contains("python feature") || message.contains("features of python")) {
            return "Python features: 1) Easy to learn and read, 2) Interpreted language, 3) Dynamically typed, 4) Extensive standard library, 5) Supports multiple programming paradigms (OOP, functional, procedural), 6) Cross-platform, 7) Large community support, 8) Excellent for data science and AI.";
        }
        else if(message.contains("python data type") || message.contains("data types in python")) {
            return "Python data types: 1) Numeric (int, float, complex), 2) Sequence (list, tuple, range), 3) Text (str), 4) Mapping (dict), 5) Set (set, frozenset), 6) Boolean (bool), 7) Binary (bytes, bytearray). Python is dynamically typed, so no explicit declaration needed.";
        }
        else if(message.contains("python vs java")) {
            return "Python vs Java: Python is interpreted, dynamically typed, uses indentation for blocks, better for rapid development and data science. Java is compiled, statically typed, uses braces, better for large enterprise applications and Android development. Both are cross-platform and object-oriented.";
        }
        else if(message.contains("python library") || message.contains("python libraries")) {
            return "Popular Python libraries: NumPy (numerical computing), Pandas (data manipulation), Matplotlib (visualization), Scikit-learn (machine learning), TensorFlow/PyTorch (deep learning), Django/Flask (web development), Requests (HTTP), BeautifulSoup (web scraping), OpenCV (computer vision).";
        }
        else if(message.contains("decorator") && message.contains("python")) {
            return "Python decorators are functions that modify other functions. Syntax: @decorator_name above function definition. Common uses: @staticmethod, @classmethod, @property. Decorators enable code reusability and clean syntax for cross-cutting concerns like logging, authentication, and caching.";
        }
        else if(message.contains("python")) {
            return "Python is a high-level, interpreted programming language known for simplicity and readability. Created by Guido van Rossum in 1991. Used for web development, data science, AI, automation, and more.";
        }
        
        // AI RELATED
        else if(message.contains("machine learning") || message.contains("ml")) {
            return "Machine Learning is a subset of AI where systems learn from data without explicit programming. Types: 1) Supervised Learning (labeled data), 2) Unsupervised Learning (unlabeled data), 3) Reinforcement Learning (reward-based). Applications: image recognition, recommendation systems, fraud detection.";
        }
        else if(message.contains("deep learning") || message.contains("neural network")) {
            return "Deep Learning uses artificial neural networks with multiple layers. Key architectures: CNN (image processing), RNN/LSTM (sequential data), Transformer (NLP). Requires large datasets and computational power. Powers applications like ChatGPT, image generation, and autonomous vehicles.";
        }
        else if(message.contains("ai algorithm") || message.contains("ml algorithm")) {
            return "Popular ML algorithms: 1) Linear/Logistic Regression, 2) Decision Trees, 3) Random Forest, 4) SVM (Support Vector Machine), 5) K-Means Clustering, 6) K-Nearest Neighbors, 7) Naive Bayes, 8) Neural Networks. Choose based on problem type (classification, regression, clustering).";
        }
        else if(message.contains("nlp") || message.contains("natural language processing")) {
            return "NLP (Natural Language Processing) enables computers to understand human language. Applications: chatbots, sentiment analysis, machine translation, text summarization. Techniques: tokenization, stemming, lemmatization, word embeddings (Word2Vec, BERT), transformers.";
        }
        else if(message.contains("ai") || message.contains("artificial intelligence")) {
            return "AI is a branch of computer science that simulates human intelligence in machines. Includes machine learning, deep learning, NLP, computer vision, robotics. Applications span healthcare, finance, transportation, entertainment, and more.";
        }
        
        // DBMS RELATED
        else if(message.contains("sql") && !message.contains("nosql")) {
            return "SQL (Structured Query Language) is used to manage relational databases. Key commands: SELECT (retrieve), INSERT (add), UPDATE (modify), DELETE (remove). Clauses: WHERE, GROUP BY, HAVING, ORDER BY, JOIN. SQL ensures data integrity and supports complex queries.";
        }
        else if(message.contains("normalization")) {
            return "Database Normalization reduces redundancy and dependency. Normal forms: 1NF (atomic values), 2NF (no partial dependency), 3NF (no transitive dependency), BCNF (Boyce-Codd). Benefits: data integrity, reduced redundancy, easier maintenance. Denormalization may be used for performance.";
        }
        else if(message.contains("acid") && message.contains("propert")) {
            return "ACID properties ensure reliable database transactions: 1) Atomicity - all or nothing execution, 2) Consistency - maintains database integrity, 3) Isolation - concurrent transactions don't interfere, 4) Durability - committed changes persist. Critical for financial systems and data reliability.";
        }
        else if(message.contains("nosql")) {
            return "NoSQL databases handle unstructured/semi-structured data. Types: 1) Document (MongoDB, CouchDB), 2) Key-Value (Redis, DynamoDB), 3) Column-family (Cassandra, HBase), 4) Graph (Neo4j). Benefits: scalability, flexibility, high performance for specific use cases. Trade-off: eventual consistency vs ACID.";
        }
        else if(message.contains("join") && message.contains("type")) {
            return "SQL JOIN types: 1) INNER JOIN - matching rows from both tables, 2) LEFT JOIN - all from left + matching from right, 3) RIGHT JOIN - all from right + matching from left, 4) FULL OUTER JOIN - all rows from both, 5) CROSS JOIN - cartesian product. Joins combine related data from multiple tables.";
        }
        else if(message.contains("index") && message.contains("database")) {
            return "Database indexes improve query performance by creating fast lookup structures. Types: clustered (physical order), non-clustered (separate structure), unique, composite. Trade-offs: faster reads but slower writes and additional storage. Use indexes on frequently queried and join columns.";
        }
        else if(message.contains("dbms")) {
            return "DBMS (Database Management System) is software that manages databases. Popular systems: MySQL, PostgreSQL, Oracle, SQL Server, MongoDB. Functions: data storage, retrieval, security, backup, concurrency control. Enables efficient data management for applications.";
        }
        
        // INDIAN CONSTITUTION RELATED
        else if(message.contains("fundamental right")) {
            return "Fundamental Rights (Articles 12-35): 1) Right to Equality, 2) Right to Freedom, 3) Right against Exploitation, 4) Right to Freedom of Religion, 5) Cultural and Educational Rights, 6) Right to Constitutional Remedies. These are justiciable rights enforceable by courts.";
        }
        else if(message.contains("directive principle") || message.contains("dpsp")) {
            return "Directive Principles of State Policy (Articles 36-51) are non-justiciable guidelines for governance. Include: equal pay, free legal aid, uniform civil code, right to work, environmental protection. Though not enforceable by courts, they guide policy-making and legislation.";
        }
        else if(message.contains("amendment") && message.contains("constitution")) {
            return "Indian Constitution can be amended under Article 368. Types: 1) Simple majority (some provisions), 2) Special majority (2/3 present + majority of total), 3) Special majority + state ratification (federal provisions). 106 amendments passed so far. Basic Structure doctrine limits amendment power.";
        }
        else if(message.contains("preamble")) {
            return "Preamble declares India as SOVEREIGN, SOCIALIST, SECULAR, DEMOCRATIC, REPUBLIC. Objectives: JUSTICE (social, economic, political), LIBERTY (thought, expression, belief, faith, worship), EQUALITY (status, opportunity), FRATERNITY (dignity of individual, unity and integrity of nation). 42nd Amendment added Socialist, Secular, Integrity.";
        }
        else if(message.contains("parliament") || message.contains("lok sabha") || message.contains("rajya sabha")) {
            return "Indian Parliament consists of: 1) Lok Sabha (House of People) - 543 elected + 2 nominated, 5-year term, 2) Rajya Sabha (Council of States) - 245 members, 1/3 retire every 2 years, 3) President. Parliament makes laws, controls finances, and holds government accountable.";
        }
        else if(message.contains("indian constitution")) {
            return "The Indian Constitution is the supreme law of India, adopted on 26 January 1950. It's the world's longest written constitution with 470 articles, 12 schedules. Dr. B.R. Ambedkar is the chief architect. It establishes a federal, parliamentary, democratic republic with fundamental rights and duties.";
        }
        
        // HTML RELATED
        else if(message.contains("html tag") || message.contains("html tags")) {
            return "Common HTML tags: Structural (<html>, <head>, <body>), Headings (<h1>-<h6>), Paragraph (<p>), Links (<a>), Images (<img>), Lists (<ul>, <ol>, <li>), Tables (<table>, <tr>, <td>), Forms (<form>, <input>, <button>), Semantic (<header>, <footer>, <nav>, <section>, <article>).";
        }
        else if(message.contains("html5") || message.contains("html 5")) {
            return "HTML5 features: 1) Semantic elements (header, nav, footer, article), 2) Multimedia support (<audio>, <video>), 3) Canvas for graphics, 4) Local storage, 5) Geolocation API, 6) Form enhancements (email, date, range inputs), 7) Drag and drop, 8) Web workers. Reduces need for plugins.";
        }
        else if(message.contains("semantic html")) {
            return "Semantic HTML uses meaningful tags that describe content purpose: <header>, <nav>, <main>, <section>, <article>, <aside>, <footer>. Benefits: better SEO, improved accessibility for screen readers, clearer code structure, easier maintenance. Prefer semantic tags over generic <div> when possible.";
        }
        else if(message.contains("html form")) {
            return "HTML Forms collect user input. Key elements: <form>, <input> (text, email, password, checkbox, radio), <textarea>, <select>, <button>. Attributes: action (submission URL), method (GET/POST), name, placeholder, required. Use labels for accessibility and validation attributes for data integrity.";
        }
        else if(message.contains("html")) {
            return "HTML (HyperText Markup Language) is used to create the structure of web pages. It uses tags (elements) to define content like headings, paragraphs, links, images. HTML5 is the latest version with enhanced features for modern web applications.";
        }
        
        // CSS RELATED
        else if(message.contains("css selector")) {
            return "CSS Selectors: 1) Element (p, div), 2) Class (.classname), 3) ID (#idname), 4) Attribute ([type='text']), 5) Pseudo-class (:hover, :first-child), 6) Pseudo-element (::before, ::after), 7) Combinators (descendant, child >, adjacent +, sibling ~). Specificity determines which rule applies.";
        }
        else if(message.contains("css box model")) {
            return "CSS Box Model: Every element is a box with 4 parts: 1) Content - actual content, 2) Padding - space inside border, 3) Border - surrounds padding, 4) Margin - space outside border. box-sizing: border-box includes padding and border in width/height calculation.";
        }
        else if(message.contains("flexbox") || message.contains("flex")) {
            return "CSS Flexbox is a one-dimensional layout system. Container properties: display: flex, flex-direction, justify-content (main axis), align-items (cross axis), flex-wrap. Item properties: flex-grow, flex-shrink, flex-basis, align-self. Perfect for responsive layouts and component alignment.";
        }
        else if(message.contains("css grid")) {
            return "CSS Grid is a two-dimensional layout system. Properties: display: grid, grid-template-columns, grid-template-rows, gap, grid-area. Items can span multiple rows/columns. More powerful than Flexbox for complex layouts. Use Grid for page layout, Flexbox for components.";
        }
        else if(message.contains("responsive") && message.contains("css")) {
            return "Responsive CSS techniques: 1) Media queries (@media), 2) Flexible layouts (%, vh, vw), 3) Flexbox/Grid, 4) Mobile-first approach, 5) Responsive images (max-width: 100%), 6) CSS variables for theming. Breakpoints: mobile (< 768px), tablet (768-1024px), desktop (> 1024px).";
        }
        else if(message.contains("css animation")) {
            return "CSS Animations: 1) Transitions - smooth changes (transition: property duration), 2) Keyframe animations (@keyframes with animation property). Properties: animation-duration, animation-timing-function, animation-delay, animation-iteration-count. Use transform and opacity for best performance.";
        }
        else if(message.contains("css")) {
            return "CSS (Cascading Style Sheets) is used to style HTML elements on web pages. It controls colors, fonts, layouts, spacing, and responsiveness. CSS3 includes modern features like animations, flexbox, grid, and media queries for responsive design.";
        }
        
        // JAVASCRIPT RELATED
        else if(message.contains("javascript data type")) {
            return "JavaScript data types: Primitive (String, Number, Boolean, Undefined, Null, Symbol, BigInt) and Reference (Object, Array, Function). JavaScript is loosely typed. Use typeof to check types. ES6 introduced let/const for better scope control vs var.";
        }
        else if(message.contains("javascript function") || message.contains("arrow function")) {
            return "JavaScript functions: 1) Function declaration (function name(){}), 2) Function expression (const name = function(){}), 3) Arrow function (const name = () => {}) - shorter syntax, lexical 'this'. Features: first-class citizens, closures, callbacks, higher-order functions, default parameters.";
        }
        else if(message.contains("promise") || message.contains("async await")) {
            return "JavaScript asynchronous programming: 1) Callbacks (older approach), 2) Promises (then/catch) - handles async operations, 3) Async/Await (modern syntax) - cleaner async code. States: pending, fulfilled, rejected. Use try-catch with async/await for error handling.";
        }
        else if(message.contains("dom") && message.contains("javascript")) {
            return "DOM (Document Object Model) represents HTML as objects. JavaScript can manipulate DOM: select elements (getElementById, querySelector), modify content (innerHTML, textContent), change styles, add/remove elements, handle events. Methods: createElement, appendChild, removeChild, setAttribute.";
        }
        else if(message.contains("es6") || message.contains("ecmascript")) {
            return "ES6/ES2015 features: 1) let/const, 2) Arrow functions, 3) Template literals, 4) Destructuring, 5) Spread/Rest operators, 6) Classes, 7) Modules (import/export), 8) Promises, 9) Default parameters, 10) Map/Set collections. Modern JavaScript development relies heavily on ES6+ features.";
        }
        else if(message.contains("javascript framework") || message.contains("js framework")) {
            return "Popular JavaScript frameworks/libraries: 1) React - component-based UI library, 2) Angular - full-featured framework, 3) Vue.js - progressive framework, 4) Node.js - server-side JavaScript, 5) Express.js - web framework for Node, 6) Next.js - React framework with SSR. Choose based on project needs.";
        }
        else if(message.contains("javascript")) {
            return "JavaScript is a programming language that adds interactivity to web pages. It runs in browsers and on servers (Node.js). Features: event handling, DOM manipulation, asynchronous programming, dynamic typing. Essential for modern web development alongside HTML and CSS.";
        }
        
        // .NET CORE RELATED
        else if(message.contains("dot net") || message.contains("dotnet") || message.contains(".net core")) {
            return ".NET Core is a cross-platform, open-source framework for building modern applications. Features: 1) Cross-platform (Windows, Linux, macOS), 2) High performance, 3) Microservices support, 4) Cloud-ready, 5) Side-by-side versioning. Successor to .NET Framework, now unified as .NET 5/6/7/8.";
        }
        else if(message.contains("asp.net core") || message.contains("aspnet")) {
            return "ASP.NET Core is a framework for building web applications and APIs. Features: 1) MVC pattern, 2) Dependency injection, 3) Middleware pipeline, 4) Razor Pages, 5) Web API, 6) Blazor (WebAssembly). Built-in support for authentication, authorization, and configuration.";
        }
        else if(message.contains("c#") || message.contains("csharp")) {
            return "C# is the primary language for .NET. Features: 1) Object-oriented, 2) Type-safe, 3) Modern syntax (LINQ, async/await, pattern matching), 4) Garbage collection, 5) Strong typing, 6) Cross-platform with .NET Core. Used for web, desktop, mobile (Xamarin), and game development (Unity).";
        }
        else if(message.contains("entity framework") || message.contains("ef core")) {
            return "Entity Framework Core is an ORM (Object-Relational Mapper) for .NET. Features: 1) Code-First or Database-First, 2) LINQ queries, 3) Change tracking, 4) Migrations, 5) Supports multiple databases (SQL Server, PostgreSQL, SQLite, MySQL). Simplifies database operations with C# objects.";
        }
        else if(message.contains("dependency injection") && (message.contains(".net") || message.contains("dotnet"))) {
            return ".NET Core has built-in Dependency Injection. Lifetimes: 1) Transient - new instance each time, 2) Scoped - one instance per request, 3) Singleton - one instance for application. Benefits: loose coupling, testability, maintainability. Register services in Program.cs/Startup.cs.";
        }
        else if(message.contains("middleware") && message.contains(".net")) {
            return "ASP.NET Core middleware forms a request pipeline. Each component can: 1) Process requests, 2) Pass to next middleware, 3) Process responses. Order matters! Common middleware: authentication, routing, static files, CORS, exception handling. Custom middleware can be created for cross-cutting concerns.";
        }
        
        // DEFAULT RESPONSE
        else {
            return "I am still learning! I can answer questions about Java, Python, AI/ML, DBMS, Indian Constitution, HTML, CSS, JavaScript, and .NET Core. Try asking about specific topics like 'What are Python features?' or 'Explain SQL joins'.";
        }
    }
}