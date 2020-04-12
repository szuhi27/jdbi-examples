package user;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.AllowUnusedBindings;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.*;

import java.util.List;
import java.util.Optional;

@RegisterBeanMapper(User.class)
public interface UserDao {

    @SqlUpdate("""
      CREATE TABLE user (
        id IDENTITY PRIMARY KEY,
        username VARCHAR NOT NULL,
        password VARCHAR NOT NULL,
        name VARCHAR NOT NULL,
        email VARCHAR NOT NULL,
        gender VARCHAR NOT NULL,
        dob DATE NOT NULL,
        enabled BOOLEAN NOT NULL
    )      
    """
    )

    void createTable();

    @SqlUpdate("INSERT INTO user (username, password, name, email, gender, dob, enabled) " +
            "VALUES (:username, :password, :name, :email, :gender, :dob, :enabled)")
    @GetGeneratedKeys
    Long insert(@BindBean User user);

    @SqlQuery("SELECT * FROM user WHERE id = :id")
    Optional<User> findById(@Bind("id") Long id);

    @SqlQuery("SELECT * FROM user WHERE username = :username")
    Optional<User> findByUsername(@Bind("username") String username);


    @SqlQuery("SELECT * FROM user ORDER BY id")
    List<User> listUsers();

    @SqlUpdate("DELETE FROM user WHERE username = :username")
    @AllowUnusedBindings
    void delete(@BindBean User user);
}
