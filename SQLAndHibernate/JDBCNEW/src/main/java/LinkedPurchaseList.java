import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class LinkedPurchaseList{

    @EmbeddedId
    private KeyLinkedPurchaseList keyLinkedPurchaseList;

    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;

    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;

    public LinkedPurchaseList() {
    }

    public KeyLinkedPurchaseList getKeyLinkedPurchaseList() {
        return keyLinkedPurchaseList;
    }

    public void setKeyLinkedPurchaseList(KeyLinkedPurchaseList keyLinkedPurchaseList) {
        this.keyLinkedPurchaseList = keyLinkedPurchaseList;
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