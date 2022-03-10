import org.redisson.Redisson;
import org.redisson.api.RKeys;
import org.redisson.api.RList;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;

import java.util.Date;

import static java.lang.System.out;

public class RedisStorage {
    private static final String NAME_KEY = "ListUsers";
    private RedissonClient redisson;
    private RKeys rKeys;
    private RList<String> users;



    void init() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        try {
            redisson = Redisson.create(config);
        } catch (RedisConnectionException Exc) {
            out.println("Не удалось подключиться к Redis");
            out.println(Exc.getMessage());
        }
        deleteDB();
        users = redisson.getList(NAME_KEY);

    }

    public RList<String> getUsers() {
        return users;
    }
    public void addUser(String nameUser){
        users.add(nameUser);
    }

    public void addUser(int newPlace, String nameUser){
        users.add(newPlace, nameUser);
    }
    public String getUserId(int usersId){
        return users.get(usersId);
    }

    void shutdown() {
        redisson.shutdown();
    }
    public void deleteDB(){
        rKeys = redisson.getKeys();
        rKeys.delete(NAME_KEY);
    }


}
