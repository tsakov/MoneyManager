package lu.uni2013.tp4.ejb.entity;

import lu.uni2013.tp2.ejb.entity.helper.AbstractDBObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: schullto
 */
@Entity
@XmlRootElement
public class User extends AbstractDBObject {
    private String username;
    private String password;
    private boolean adminRole;

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "adminRole")
    public boolean isAdminRole() {
        return adminRole;
    }

    public void setAdminRole(boolean adminRole) {
        this.adminRole = adminRole;
    }
}
