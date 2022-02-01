import org.hibernate.Session;
import utils.SessionFactory;


public class Main {
    public static void main(String[] args) {

        Session session = SessionFactory.getSession();
        getNameAndAmountStudentsCourseById(2, session);
        getStudentsId(5, session);
        System.out.println("Teacher → " + Teacher.getTeacherById(3, session).getName() +
                " - " + Teacher.getTeacherById(3, session).getAge() + " years old.");
        session.close();

    }

    static void getNameAndAmountStudentsCourseById(int id, Session session){
        Course course = session.get(Course.class, id);
        System.out.println(course.getName() + " Amount students => " + course.getStudents_count());
    }

    static void getStudentsId(int id, Session session){
        Student student = session.get(Student.class, id);
        System.out.println(" This Student " + student.getName() + " =========>>> " + student.getAge() + " years old.");
    }


}
