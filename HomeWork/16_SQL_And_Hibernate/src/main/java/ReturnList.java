import java.util.List;

public class ReturnList {

    List<Course> courseList;
    List<PurchaseList> purchaseLists;
    List<Student> studentList;

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<PurchaseList> getPurchaseLists() {
        return purchaseLists;
    }

    public void setPurchaseLists(List<PurchaseList> purchaseLists) {
        this.purchaseLists = purchaseLists;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
