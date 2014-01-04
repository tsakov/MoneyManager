package lu.uni2013.tp2.jsf.bean.actions;

import lu.uni2013.tp1.jsf.bean.model.Credentials;
import lu.uni2013.tp2.ejb.facades.UserFacade;
import lu.uni2013.tp4.ejb.entity.User;
import lu.uni2013.tp4.jsf.bean.model.SessionData;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * User: schullto
 */
@Model
public class LoginBean {
    @Inject
    private Logger logger;
    @Inject
    private UserFacade userFacade;
    @Inject
    private Credentials credentials;
    @Inject
    private SessionData sessionData;

    public String login() {
        logger.info("login... for user: " + credentials.getUsername());

        sessionData.setLoggedUser(null);
        User dbUser = userFacade.findUserByUsername(credentials.getUsername());
        logger.info("dbUser: " + dbUser);
        if (dbUser != null) {
            if (dbUser.getPassword().equals(credentials.getPassword())) {
                //login is ok;
                sessionData.setLoggedUser(dbUser);
                return "/home.xhtml?faces-redirect=true";
            }
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Incorrect username or password!"));
        return null;
    }

    public String logout() {
        sessionData.setLoggedUser(null);
        return "/login.xhtml?faces-redirect=true";
    }
}
