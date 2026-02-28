package User;

import javax.persistence.*;

@Entity
@Table(name = "course_content")
public class Course_Content {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String courseName; // e.g., "Java", "Python"

    @Column(nullable = false)
    private String topic;      // e.g., "Basics", "OOP", "Loops"

    @Column(length = 5000)
    private String content;    // The actual explanation

    // Constructors
    public Course_Content() {}

    public Course_Content(String courseName, String topic, String content) {
        this.courseName = courseName;
        this.topic = topic;
        this.content = content;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getTopic() { return topic; }
    public void setTopic(String topic) { this.topic = topic; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
