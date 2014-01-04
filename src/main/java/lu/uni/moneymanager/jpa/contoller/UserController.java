package lu.uni.moneymanager.jpa.contoller;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lu.uni.moneymanager.jpa.entity.User;
import lu.uni.moneymanager.jpa.facade.AbstractFacade;
import lu.uni.moneymanager.jpa.facade.UserFacade;

@Named
@ConversationScoped
public class UserController extends AbstractController<User> {

    @Inject
    private Conversation conversation;
    @Inject
    private UserFacade facade;

    @Override
    public Class getClazz() {
        return User.class;
    }

    @Override
    public Conversation getConversation() {
        return conversation;
    }

    @Override
    public AbstractFacade getFacade() {
        return facade;
    }
}
