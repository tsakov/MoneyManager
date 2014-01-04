package lu.uni.moneymanager.jpa.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import java.util.List;
import lu.uni.moneymanager.jpa.entity.BankAccount;
import lu.uni.moneymanager.jpa.entity.User;

@Named
@Stateless
public class BankAccountFacade extends AbstractFacade {

    public List<BankAccount> getAllForUser(User user) {
        return em.createQuery("SELECT ba FROM BankAccount ba where ba.user = :user", BankAccount.class)
                .setParameter("user", user).getResultList();
    }
}
