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
/*
    public User(){}

    public User(Long id, String username, String password, String name, String email, Gender gender, LocalDate dob, boolean enabled){
        this.id = id;
        this.username =username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.dob = dob;
        this.enabled = enabled;
    }

    public User(String username, String password, String name, String email, Gender gender, LocalDate dob, boolean enabled){
        this(null, username, password, name, email, gender, dob, enabled);
    }
    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    public String getUsername(){return username;}
    public void setUsername(String username){this.username = username;}

    public String getPassword(){return password;}
    public void  setPassword(String password){this.password = password;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}

    public Gender getGender(){return gender;}
    public void setGender(Gender gender){this.gender = gender;}

    public LocalDate getDob(){return dob;}
    public void setDob(LocalDate dob){this.dob = dob;}

    public boolean getEnabled(){return enabled;}
    public void setEnabled(boolean enabled){this.enabled = enabled;}
*/
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
