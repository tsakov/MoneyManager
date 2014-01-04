package lu.uni2013.tp4.ws.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * User: schullto
 * Date: 11/21/13
 * Time: 7:14 PM
 */
@WebService
public class SoapWebService {
    /*
    http://localhost:8080/tp4/SoapWebService?wsdl
     */
    @WebMethod(operationName = "testLogin")
    public boolean validateUsernamePassword(String username, String password) {
        return username.equals(password);
    }
}