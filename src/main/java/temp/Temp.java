package temp;

import com.example.demo6.model.User;
import org.bson.types.ObjectId;

import java.util.HashSet;
import java.util.Set;

/**
 * File comments...
 *
 * @author Kenny Fang
 * @version 1.0
 * @date 2017/8/21 20:43
 */
public class Temp {
    public static void main(String[] args) {
        User user = new User(ObjectId.get().toHexString(), 1, "aaa", null);

        Set<User> userSet = new HashSet();
        userSet.add(user);

        for(User userT : userSet) {
            System.out.println(userSet.size() + ": " + userT.getUserId() + userT.getUserName());
        }

        user.setUserName("bbbb");
        userSet.add(user);

        for(User userT : userSet) {
            System.out.println(userSet.size() + ": " + userT.getUserId() + userT.getUserName());
        }
    }
}
