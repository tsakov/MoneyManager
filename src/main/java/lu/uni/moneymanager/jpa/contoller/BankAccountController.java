package lu.uni.moneymanager.jpa.contoller;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lu.uni.moneymanager.jpa.entity.BankAccount;
import lu.uni.moneymanager.jpa.facade.AbstractFacade;
import lu.uni.moneymanager.jpa.facade.BankAccountFacade;
import lu.uni.moneymanager.jsf.bean.model.SessionData;

@Named
@ConversationScoped
public class BankAccountController extends AbstractController<BankAccount> {

    @Inject
    private Conversation conversation;
    @Inject
    private BankAccountFacade facade;
    @Inject
    private SessionData sessionData;

    @Override
    public Class getClazz() {
        return BankAccount.class;
    }

    @Override
    public Conversation getConversation() {
        return conversation;
    }

    @Override
    public AbstractFacade getFacade() {
        return facade;
    }

    @Override
    public String startNewEntity(String outcome) {
        super.startNewEntity(null);
        editEntity.setUser(sessionData.getLoggedUser());
        return outcome;
    }

    public String viewPayments(BankAccount bankAccount, String outcome) {
        sessionData.setSelectedBankAccount(bankAccount);
        return outcome;
    }
}
