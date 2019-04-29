package repository;

import domains.PaymentMethod.PaymentMethod;
import factories.PaymentMethod.PaymentMethodFactory;
import repository.impl.PaymentMethodRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PaymentMethodRepositoryImplTest {

    PaymentMethodRepositoryImpl paymentMethodRepository;

    @Before
    public void setUp() throws Exception{
        paymentMethodRepository = PaymentMethodRepositoryImpl.getRepository();
    }

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
