package wiese.factory.Invoice;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import wiese.domains.Invoice.Invoice;
import wiese.factories.Invoice.InvoiceFactory;

public class InvoiceFactoryTest {
    @Before
    public void setUp() throws Exception{

    }
    @Test
    public void getInvoice(){

        Invoice invoice = InvoiceFactory.getInvoice("12 May 2019", "3x Venetian Blinds");
        Assert.assertNotNull(invoice.getInvoiceId());
        System.out.println(invoice.getInvoiceItems());
    }
}
