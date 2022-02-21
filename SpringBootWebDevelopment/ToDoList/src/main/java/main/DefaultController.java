package main;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.util.Random;

@RestController
public class DefaultController
{
    @RequestMapping("/")
    public String index(){
        int guestNumber = new Random().nextInt(101);
        return "Привет наш " + guestNumber + " друг. Ты зашел к нам в этот непростой для страны час"
                + " →\n " + LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute();
    }

}
