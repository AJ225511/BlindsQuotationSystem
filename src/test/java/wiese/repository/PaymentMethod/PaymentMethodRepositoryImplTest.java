package wiese.repository.PaymentMethod;

import wiese.domains.PaymentMethod.PaymentMethod;
import wiese.factories.PaymentMethod.PaymentMethodFactory;
import wiese.repository.impl.PaymentMethodRepositoryImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)

public class PaymentMethodRepositoryImplTest {

    @Autowired
    private PaymentMethodRepositoryImpl paymentMethodRepository;
    private String clientId = null;

    @Test
    public void create(){

        PaymentMethod paymentMethod = PaymentMethodFactory.getPaymentMethod(100, "14 April 2019");
        paymentMethodRepository.create(paymentMethod);

        Assert.assertNotNull(paymentMethodRepository.getAll());
    }

    @Test
    public void read(){
        try {
            PaymentMethod paymentMethod = PaymentMethodFactory.getPaymentMethod(100, "14 April 2019");
            paymentMethodRepository.create(paymentMethod);

            Assert.assertNotNull(paymentMethodRepository.getAll());
            System.out.println(paymentMethod);

            PaymentMethod paymentMethod1 = paymentMethodRepository.read(Integer.parseInt(paymentMethod.getPaymentId()));
            Assert.assertEquals(paymentMethod, paymentMethod1);
        }
        catch (NumberFormatException nfe){
            System.out.println(nfe);
        }

    }

    @Test
    public void update(){

        PaymentMethod paymentMethod = PaymentMethodFactory.getPaymentMethod(100, "14 April 2019");
        paymentMethodRepository.create(paymentMethod);

        Assert.assertNotNull(paymentMethodRepository.getAll());
        PaymentMethod paymentMethod1 = PaymentMethodFactory.getPaymentMethod(600, "17 April 2019");
        paymentMethod1.setPaymentId(paymentMethod.getPaymentId());
        paymentMethodRepository.update(paymentMethod1);

        PaymentMethod updatedPaymentMethod = paymentMethodRepository.find(paymentMethod1.getPaymentId());
        Assert.assertEquals(paymentMethod1, updatedPaymentMethod);

        System.out.println(updatedPaymentMethod);

    }

    @Test
    public void delete(){
        try {
            PaymentMethod paymentMethod = PaymentMethodFactory.getPaymentMethod(100, "14 April 2019");
            paymentMethodRepository.create(paymentMethod);

            Assert.assertNotNull(paymentMethodRepository.getAll());
            paymentMethodRepository.delete(Integer.parseInt(paymentMethod.getPaymentId()));
            PaymentMethod deleted = paymentMethodRepository.find(paymentMethod.getPaymentId());
            Assert.assertNull(deleted);

            System.out.println(deleted);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println(nfe);
        }


    }
}
