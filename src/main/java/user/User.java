package user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {

    public static enum Gender {
        FEMALE,
        MALE
    }

    private Long id;
    private String username;
    private String password;
    private String name;
    private String email;
    private Gender gender;
    private LocalDate dob;
    private boolean enabled;

    @Override
    public String toString(){
        return "User{" +
                "id: " +id+
                ", username:" +username+
                ", password:" +password+
                ", name:" +name+
                ", email:" +email+
                ", gender:" +gender+
                ", date of birth:" +dob+
                ", enabled:" +enabled+
                '}';
    }

}
