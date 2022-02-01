import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
@Entity
@Table(name="subscriptions")
public class Subscription {

@Column(name = "student_id")
    private int studentId;

@Column(name = "course_id")
public int courseId;


@Column(name = "subscription_date")
    private LocalDateTime localDateTime;


    public Subscription() {

    }



    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
