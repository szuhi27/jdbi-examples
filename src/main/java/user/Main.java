package user;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.time.LocalDate;

import static user.User.Gender.FEMALE;
import static user.User.Gender.MALE;

public class Main {

    public static void main(String[] args) {
        Jdbi jdbi = Jdbi.create("jdbc:h2:mem:test");
        jdbi.installPlugin(new SqlObjectPlugin());
        try (Handle handle = jdbi.open()) {
            UserDao dao = handle.attach(UserDao.class);
            dao.createTable();
            /*dao.insert(new User("alma", "kutyus", "Kis Béla", "alma@gmail.com", User.Gender.MALE, LocalDate.of(2015,2,5), false));;*/
            User userA = User.builder()
                    .name("James Bond").username("007").password("spy").email("jb007@gmail.com").gender(MALE)
                    .dob(LocalDate.of(1920,11,11)).enabled(true).build();
            User userB = User.builder()
                    .name("Kis Béla").username("alma").password("kutyus").email("alma@gmail.com").gender(MALE)
                    .dob(LocalDate.of(2001,2,8)).build();
            User userC = User.builder()
                    .name("Nagy Erdő").username("lomb").password("korona").email("fa@gmail.com").gender(FEMALE)
                    .dob(LocalDate.of(1996,12,29)).enabled(true).build();
            dao.insert(userA); dao.insert(userB); dao.insert(userC);
            dao.listUsers().stream().forEach(System.out::println);
            dao.findById(1L).stream().forEach(System.out::println);
            dao.findByUsername("lomb").stream().forEach(System.out::println);
            dao.delete(userA);
            dao.listUsers().stream().forEach(System.out::println);
        }
    }
}
