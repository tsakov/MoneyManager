package lu.uni.moneymanager.jpa.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import java.util.List;
import lu.uni.moneymanager.jpa.entity.BankAccount;
import lu.uni.moneymanager.jpa.entity.Payment;

@Named
@Stateless
public class PaymentFacade extends AbstractFacade {

    public List<Payment> getAllForBankAccount(BankAccount bankAccount) {
        return em.createQuery("from Payment p where p.bankAccount = :bankAccount", Payment.class)
                .setParameter("bankAccount", bankAccount).getResultList();
    }
}
