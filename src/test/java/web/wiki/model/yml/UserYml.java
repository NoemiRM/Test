package web.wiki.model.yml;

/**
 * Created by PilarRM on 2/6/20.
 */
public class UserYml {
    private String user;
    private String email;
    private String password;
    private String access;

    public UserYml() {
    }


    public UserYml(String user, String email, String password, String access) {
        this.user = user;
        this.email = email;
        this.password = password;
        this.access = access;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    @Override
    public String toString() {
        return "UserYml{" +
                "user='" + user + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", access='" + access + '\'' +
                '}';
    }
}
