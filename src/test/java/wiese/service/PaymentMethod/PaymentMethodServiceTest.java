//package wiese.service.PaymentMethod;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import wiese.domains.PaymentMethod.PaymentMethod;
//import wiese.factories.PaymentMethod.PaymentMethodFactory;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import wiese.service.impl.PaymentMethodServiceImpl;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class PaymentMethodServiceTest {
//    @Autowired
//    private PaymentMethodServiceImpl paymentMethodService;
//
//    @Test
//    public void create() {
//        PaymentMethod paymentMethod = PaymentMethodFactory.getPaymentMethod(500, "12 April 2019");
//        paymentMethodService.create(paymentMethod);
//
//        assertNotNull(paymentMethodService.getAll());
//        System.out.println(paymentMethod);
//    }
//
//    @Test
//    public void read() {
//        try {
//            PaymentMethod paymentMethod = PaymentMethodFactory.getPaymentMethod(500, "12 April 2019");
//            paymentMethodService.create(paymentMethod);
//
//            PaymentMethod paymentMethod1 = paymentMethodService.read(Integer.parseInt(paymentMethod.getPaymentId()));
//            assertEquals(paymentMethod, paymentMethod1);
//        } catch (NumberFormatException nfe) {
//            System.out.println(nfe);
//        }
//
//    }
//
//    @Test
//    public void update() {
//        try {
//            PaymentMethod paymentMethod = PaymentMethodFactory.getPaymentMethod(800, "15 April 2019");
//            paymentMethodService.create(paymentMethod);
//
//            PaymentMethod paymentMethod1 = PaymentMethodFactory.getPaymentMethod(1200, "16 April 2019");
//            paymentMethod1.setPaymentId(paymentMethod.getPaymentId());
//            paymentMethodService.update(paymentMethod1);
//            System.out.println("Original: \n" + paymentMethod);
//            System.out.println("Updated: \n" + paymentMethod1);
//
//            PaymentMethod paymentMethod2 = paymentMethodService.read(Integer.parseInt(paymentMethod1.getPaymentId()));
//            assertEquals(paymentMethod1, paymentMethod2);
//        } catch (NumberFormatException nfe) {
//            System.out.println(nfe);
//        }
//    }
//
//    @Test
//    public void delete() {
//        try {
//            PaymentMethod paymentMethod = PaymentMethodFactory.getPaymentMethod(700, "12 April 2019");
//            paymentMethodService.create(paymentMethod);
//
//            assertNotNull(paymentMethodService.getAll());
//            PaymentMethod paymentMethod1 = paymentMethodService.read(Integer.parseInt(paymentMethod.getPaymentId()));
//            assertNull(paymentMethod1);
//        } catch (NumberFormatException nfe) {
//            System.out.println(nfe);
//        }
//    }
//}
