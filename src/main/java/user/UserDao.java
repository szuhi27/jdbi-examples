package user;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RegisterBeanMapper(User.class)
public interface UserDao {

    /*
    void createTable(): létrehozza a felhasználók adatait tároló adatbázis táblát
Long insert(User user): az adott felhasználó mentése az adatbázisba, a felhasználó automatikusan generált azonosítóját adja vissza
Optional<User> findById(long id): az adott azonosítójú felhasználó betöltése az adatbázisból
Optional<User> findByUsername(String username): az adott felhasználói nevű felhasználó betöltése az adatbázisból
void delete(User user): az adott felhasználó törlése az adatbázisból
List<User> list(): az összes felhasználó betöltése az adatbázisból
     */
    @SqlUpdate("""
      CREATE TABLE user (
        id IDENTITY PRIMARY KEY,
        username VARCHAR NOT NULL,
        password VARCHAR NOT NULL,
        name VARCHAR NOT NULL,
        email VARCHAR NOT NULL,
        gender VARCHAR NOT NULL,
        dob DATE NOT NULL,
        enable VARCHAR NOT NULL
    )      
    """
    )

    void createTable();

    @SqlUpdate("INSERT INTO user (username, password, name, email, gender, dob, enable) " +
            "VALUES (:username, :password, :name, :email, :gender, :dob, :enable)")
    @GetGeneratedKeys
    Long insert(@Bind("username") String username, @Bind("password") String password, @Bind("name") String name,
                @Bind("email") String email, @Bind("gender") User.Gender gender,
                @Bind("dob") LocalDate dob, @Bind("enable") boolean enable);

    @SqlUpdate("INSERT INTO user (username, password, name, email, gender, dob, enable) " +
            "VALUES (:username, :password, :name, :email, :gender, :dob, :enable)")
    @GetGeneratedKeys
    Long insert(@BindBean User user);

    @SqlQuery("SELECT * FROM user WHERE id = :id")
    Optional<User> findById(@Bind("id") Long id);

    @SqlQuery("SELECT * FROM user WHERE username = :username")
    Optional<User> findByUsername(@Bind("username") String username);

    @SqlQuery("SELECT * FROM user ORDER BY username")
    List<User> listUsers();

    //@SqlQuery
    //void delete( User user)
}
