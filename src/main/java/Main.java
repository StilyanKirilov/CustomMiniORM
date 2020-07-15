import entities.User;
import orm.Connector;
import orm.EntityManager;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {

        String username = "root";
        String password = "12345";

        Connector.createConnection(username, password, "orm_db");
        EntityManager<User> entityManager = new EntityManager<>(Connector.getConnection());

//        User user = new User("Sasho", "12345", 21, new Date());
        User user = entityManager.findFirst(User.class," id = 3 ");
        entityManager.delete(user);
        System.out.println("User 3 is deleted");
//        entityManager.persist(user2);
//        List<User> users = (List<User>) entityManager.find(User.class, " age > 23");
//
//        for (User userr : users) {
//            System.out.println(userr.getUsername());
//        }
//        System.out.println("--------------");
//        List<User> allUsers = (List<User>) entityManager.find(User.class);
//        for (User userr : allUsers) {
//            System.out.println(userr.getUsername());
//        }
    }
}
