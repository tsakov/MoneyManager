package lu.uni.moneymanager.service;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import lu.uni.moneymanager.jpa.entity.BankAccount;
import lu.uni.moneymanager.jpa.entity.User;
import lu.uni.moneymanager.jpa.facade.BankAccountFacade;
import lu.uni.moneymanager.jpa.facade.PaymentFacade;
import lu.uni.moneymanager.jpa.facade.UserFacade;

@Path("/balance")
public class BalanceRestService {

    @Inject
    private UserFacade userFacade;
    @Inject
    private BankAccountFacade bankAccountFacade;
    @Inject
    private PaymentFacade paymentFacade;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public double getBalanceForUser(@QueryParam("user") String username) {
        User user = userFacade.findUserByUsername(username);
        List<BankAccount> bankAccounts = bankAccountFacade.getAllForUser(user);
        double totalAmount = 0;

        for (BankAccount bankAccount : bankAccounts) {
            totalAmount += paymentFacade.getBalanceForBankAccount(bankAccount);
        }

        return totalAmount;
    }
}
