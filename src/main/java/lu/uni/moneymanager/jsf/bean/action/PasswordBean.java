package lu.uni.moneymanager.jsf.bean.action;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import lu.uni.moneymanager.jpa.facade.UserFacade;
import lu.uni.moneymanager.jsf.bean.model.ChangePassword;
import lu.uni.moneymanager.jsf.bean.model.SessionData;

@Model
public class PasswordBean {

    @Inject
    private UserFacade userFacade;
    @Inject
    private ChangePassword changePassword;
    @Inject
    private SessionData sessionData;

    private boolean isValid() {
        return sessionData.getLoggedUser().getPassword().equals(changePassword.getOldPassword())
                && changePassword.getNewPassword().equals(changePassword.getRetypeNewPassword())
                && !changePassword.getOldPassword().equals(changePassword.getNewPassword());
    }

    public void changePassword() {
        if (isValid()) {
            sessionData.getLoggedUser().setPassword(changePassword.getNewPassword());
            userFacade.saveOrUpdate(sessionData.getLoggedUser());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Password changed!"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Provided information is invalid.", null));
        }
    }
}
