import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class KeyLinkedPurchaseList implements Serializable {


    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id")
    private int courseId;


    public KeyLinkedPurchaseList() {
    }

    public KeyLinkedPurchaseList(int studentsId, int courseId) {
        this.studentId = studentsId;
        this.courseId = courseId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Key)) return false;
        Key that = (Key) o;
        return Objects.equals(getCourseId(), that.getCourseId()) &&
                Objects.equals(getStudentId(), that.getStudentId());
    }


    @Override
    public int hashCode() {
        return Objects.hash(getCourseId(), getStudentId());
    }
}
