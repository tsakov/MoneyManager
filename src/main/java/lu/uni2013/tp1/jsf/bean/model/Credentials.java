package lu.uni2013.tp1.jsf.bean.model;

import javax.enterprise.inject.Model;

/**
 * User: schullto
 */
@Model
public class Credentials {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
