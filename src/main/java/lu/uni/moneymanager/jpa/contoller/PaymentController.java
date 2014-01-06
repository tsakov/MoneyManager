package lu.uni.moneymanager.jpa.contoller;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lu.uni.moneymanager.jpa.entity.Payment;
import lu.uni.moneymanager.jpa.facade.AbstractFacade;
import lu.uni.moneymanager.jpa.facade.PaymentFacade;
import lu.uni.moneymanager.jsf.bean.model.SessionData;

@Named
@ConversationScoped
public class PaymentController extends AbstractController<Payment> {

    @Inject
    private Conversation conversation;
    @Inject
    private PaymentFacade facade;
    @Inject
    private SessionData sessionData;

    @Override
    public Class getClazz() {
        return Payment.class;
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
        super.startNewEntity(outcome);
        editEntity.setBankAccount(sessionData.getSelectedBankAccount());
        return outcome;
    }
}
