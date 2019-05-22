package wiese.factory.PaymentMethod;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import wiese.domains.PaymentMethod.PaymentMethod;
import wiese.factories.PaymentMethod.PaymentMethodFactory;

public class PaymentMethodFactoryTest {
    @Before
    public void setUp() throws Exception{

    }
    @Test
    public void getPaymentMethod(){

        PaymentMethod paymentMethod = PaymentMethodFactory.getPaymentMethod(600, "11 April 2019");
        Assert.assertNotNull(paymentMethod.getPaymentId());
        System.out.println(paymentMethod.getPaymentAmount());
    }
}
