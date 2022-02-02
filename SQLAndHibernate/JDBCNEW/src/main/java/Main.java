import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {

        Session session = SessionFactory.getSession().openSession();
        Transaction transaction = session.beginTransaction();
        Course course = session.get(Course.class, 1);

        Subscription subscription = session.get(Subscription.class, new Key(2, 1));
        System.out.println(subscription.getLocalDateTime().getMonth() + " => " + subscription.getCourseId());

        PurchaseList purchaseList = session.get(PurchaseList.class,new KeyPurchaseList("Шведов Юрий", "Figma"));
        System.out.println(purchaseList.getStudentName() + " => " + purchaseList.getCourseName());
        transaction.commit();
        session.close();
    }
}
