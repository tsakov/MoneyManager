package lu.uni2013.tp4.ws.soap;

import javax.jws.WebService;

/**
 * User: schullto
 * Date: 11/21/13
 * Time: 9:43 PM
 */
@WebService
public class SoapCalculator {
    /*
    http://localhost:8080/tp4/SoapCalculator?wsdl
     */
    public int sum(int add1, int add2) {
        return add1 + add2;
    }

    public int multiply(int mul1, int mul2) {
        return mul1 * mul2;
    }
}