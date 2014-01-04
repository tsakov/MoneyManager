package lu.uni.moneymanager.jsf.bean.action;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import lu.uni.moneymanager.jpa.entity.User;
import lu.uni.moneymanager.jpa.facade.UserFacade;
import lu.uni.moneymanager.jsf.bean.model.Credentials;
import lu.uni.moneymanager.jsf.bean.model.SessionData;

@Model
public class LoginBean {

    @Inject
    private UserFacade userFacade;
    @Inject
    private Credentials credentials;
    @Inject
    private SessionData sessionData;

    public String login() {
        sessionData.setLoggedUser(null);
        User user = userFacade.findUserByUsername(credentials.getUsername());

        if (user != null) {
            if (user.getPassword().equals(credentials.getPassword())) {
                //login is ok;
                sessionData.setLoggedUser(user);
                return "/home.xhtml?faces-redirect=true";
            }
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Incorrect username or password!"));
        return null;
    }

    public String logout() {
        sessionData.setLoggedUser(null);
        return "/index.xhtml?faces-redirect=true";
    }
}
