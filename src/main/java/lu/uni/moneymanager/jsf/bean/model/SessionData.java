package lu.uni.moneymanager.jsf.bean.model;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import lu.uni.moneymanager.jpa.entity.User;

@SessionScoped
@Named
public class SessionData implements Serializable {
    private User loggedUser;
//    private UserComment selectedUserComment;

    public boolean isLoggedIn() {
        return loggedUser != null;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

//    public UserComment getSelectedUserComment() {
//        return selectedUserComment;
//    }
//
//    public void setSelectedUserComment(UserComment selectedUserComment) {
//        this.selectedUserComment = selectedUserComment;
//    }
}
