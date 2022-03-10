import java.util.Random;

import static java.lang.System.out;

public class RedisTest {

    private static final int SLEEP = 1000; // 1 секунда



    public static void main(String[] args) throws InterruptedException {

        RedisStorage redis = new RedisStorage();
        redis.init();
        for(int i = 1; i <=20; i++) {
            int user_id = i;
            String nameUser = "User " + user_id;
            redis.addUser(nameUser);
        }

        for (;;){
            for (int i = 0; i <= redis.getUsers().size()-1; i++) {
                out.println("На главной странице показываем пользователя " + redis.getUserId(i));
                Thread.sleep(SLEEP);
            if (i!=0 && (i+1) % 10 == 0) {
                int user = new Random().nextInt(0, i);
                out.println("> Пользователь " + redis.getUserId(user) + " оплатил услугу.");
                out.println("На главной странице показываем пользователя " + redis.getUserId(user));
                Thread.sleep(SLEEP);
            }
            }
        }


//        redis.shutdown();
    }
}
