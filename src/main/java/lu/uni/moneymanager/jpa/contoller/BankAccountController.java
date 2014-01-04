package lu.uni.moneymanager.jpa.contoller;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lu.uni.moneymanager.jpa.entity.BankAccount;
import lu.uni.moneymanager.jpa.facade.AbstractFacade;
import lu.uni.moneymanager.jpa.facade.BankAccountFacade;

@Named
@ConversationScoped
public class BankAccountController extends AbstractController<BankAccount> {

    @Inject
    private Conversation conversation;
    @Inject
    private BankAccountFacade facade;
//    @Inject
//    private SessionData sessionData;

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
    public String startNewEntity() {
        super.startNewEntity();
//        editEntity.setUser(sessionData.getLoggedUser());
        return null;
    }
}
