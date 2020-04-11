package user;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Jdbi jdbi = Jdbi.create("jdbc:h2:mem:test");
        jdbi.installPlugin(new SqlObjectPlugin());
        try (Handle handle = jdbi.open()) {
            UserDao dao = handle.attach(UserDao.class);
            dao.createTable();
            dao.insert(new User("alma", "kutyus", "Kis Béla", "alma@gmail.com", User.Gender.MALE, LocalDate.of(2015,02,05), true));
            dao.insert(new User("zold", "kek", "Ló Fej", "csiko@gmail.com", User.Gender.FEMALE, LocalDate.of(2003,10,15), true));
            dao.listUsers().stream().forEach(System.out::println);
        }
    }
}
