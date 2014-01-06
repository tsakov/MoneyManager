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

    public double getBalanceForBankAccount(BankAccount bankAccount) {
        Double incoming = em.createQuery("SELECT SUM(p.amount) FROM Payment p WHERE p.bankAccount = :bankAccount AND p.status = 'incoming'", Double.class)
                .setParameter("bankAccount", bankAccount).getSingleResult();
        if (incoming == null) {
            incoming = new Double(0);
        }

        Double outgoing = em.createQuery("SELECT SUM(p.amount) FROM Payment p WHERE p.bankAccount = :bankAccount AND p.status = 'outgoing'", Double.class)
                .setParameter("bankAccount", bankAccount).getSingleResult();
        if (outgoing == null) {
            outgoing = new Double(0);
        }

        return incoming.doubleValue() - outgoing.doubleValue();
    }
}
