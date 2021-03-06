import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class KeyPurchaseList implements Serializable {

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "course_name")
    private String courseName;

    public KeyPurchaseList() {
    }

    public KeyPurchaseList(String studentName, String courseName) {
        this.studentName = studentName;
        this.courseName = courseName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Key)) return false;
        KeyPurchaseList that = (KeyPurchaseList) o;
        return Objects.equals(getCourseName(), that.getCourseName()) &&
                Objects.equals(getStudentName(), that.getStudentName());
    }


    @Override
    public int hashCode() {
        return Objects.hash(getCourseName(), getStudentName());
    }
}
