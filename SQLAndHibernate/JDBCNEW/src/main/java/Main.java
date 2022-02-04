import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Session session = SessionFactory.getSession().openSession();
        Transaction transaction = session.beginTransaction();

        List<Student>  studentList = (getListEntity("Student", session)).getStudentList();
        List<Course> courseList = (getListEntity("Course", session)).getCourseList();
        List<PurchaseList> purchaseLists = (getListEntity("PurchaseList", session)).getPurchaseLists();
        updateLinkedPurchaseList(studentList, courseList, purchaseLists, session);

        transaction.commit();
        session.close();
    }

    static ReturnList getListEntity(String classSearch, Session session){
        ReturnList returnList = new ReturnList();
        switch (classSearch){
            case "Student" -> returnList.setStudentList(session.createQuery("FROM " + Student.class.getSimpleName()).getResultList());
            case "Course" -> returnList.setCourseList(session.createQuery("FROM " + Course.class.getSimpleName()).getResultList());
            case "PurchaseList" -> returnList.setPurchaseLists(session.createQuery("FROM " + PurchaseList.class.getSimpleName()).getResultList());
            default -> System.out.println("Wrong type course");
        }
        return  returnList;
    }
    static void updateLinkedPurchaseList(List<Student>  studentList,  List<Course> courseList, List<PurchaseList> purchaseLists, Session session){
        for (PurchaseList element :  purchaseLists) {
            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
            int idStudent  = (studentList.stream().filter(s -> s.getName().equals(element.getStudentName())).
                    findFirst().orElse(null)).getId();
            int idCourse = (courseList.stream().filter(s -> s.getName().equals(element.getCourseName())).
                    findFirst().orElse(null)).getId();

            KeyLinkedPurchaseList keyLinkedPurchaseList = new KeyLinkedPurchaseList(idStudent, idCourse); //добавить проверку на 0
            linkedPurchaseList.setKeyLinkedPurchaseList(keyLinkedPurchaseList);
            linkedPurchaseList.setCourseId(idCourse);
            linkedPurchaseList.setStudentId(idStudent);

            session.save(linkedPurchaseList);
        }
    }

}
