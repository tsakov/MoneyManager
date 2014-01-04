package lu.uni2013.tp4.jsf.bean.model;

import lu.uni2013.tp4.ejb.entity.User;
import lu.uni2013.tp4.ejb.entity.UserComment;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * User: schullto
 */
@SessionScoped
@Named
public class SessionData implements Serializable {
    private User loggedUser;
    private UserComment selectedUserComment;

    public boolean isLoggedIn() {
        return loggedUser != null;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public UserComment getSelectedUserComment() {
        return selectedUserComment;
    }

    public void setSelectedUserComment(UserComment selectedUserComment) {
        this.selectedUserComment = selectedUserComment;
    }
}
