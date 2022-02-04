import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "purchaselist")
public class PurchaseList {

   @EmbeddedId
    private KeyPurchaseList keyPurchaseList;

    @Column(name = "student_name", insertable = false, updatable = false)
    private String studentName;

    @Column(name = "course_name", insertable = false, updatable = false)
    private String courseName;

    private int price;
    @Column(name = "subscription_date")

    private LocalDateTime subscriptionDate;

 public PurchaseList() {
   }

 public KeyPurchaseList getKeyPurchaseList() {
  return keyPurchaseList;
 }

 public void setKeyPurchaseList(KeyPurchaseList keyPurchaseList) {
  this.keyPurchaseList = keyPurchaseList;
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

 public int getPrice() {
  return price;
 }

 public void setPrice(int price) {
  this.price = price;
 }

 public LocalDateTime getSubscriptionDate() {
  return subscriptionDate;
 }

 public void setSubscriptionDate(LocalDateTime subscriptionDate) {
  this.subscriptionDate = subscriptionDate;
 }
}
