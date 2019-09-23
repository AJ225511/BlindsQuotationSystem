package wiese.service.Invoice;

import org.springframework.beans.factory.annotation.Autowired;
import wiese.domains.Invoice.Invoice;
import wiese.factories.Invoice.InvoiceFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wiese.service.impl.InvoiceServiceImpl;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceServiceTest {
    @Autowired
    private InvoiceServiceImpl invoiceService;

    @Test
    public void create() {
        Invoice invoice = InvoiceFactory.getInvoice("12 May 2019", "1x Venetian Blinds");
        invoiceService.create(invoice);

        assertNotNull(invoiceService.getAll());
        System.out.println(invoice);
    }

    @Test
    public void read() {
        try {
            Invoice invoice = InvoiceFactory.getInvoice("12 May 2019", "1x Venetian Blinds");
            invoiceService.create(invoice);

            Invoice invoice1 = invoiceService.read(Integer.parseInt(invoice.getInvoiceId()));
            assertEquals(invoice, invoice1);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
        }

    }

    @Test
    public void update() {
        try {
            Invoice invoice = InvoiceFactory.getInvoice("11 May 2019", "2x Venetian Blinds");
            invoiceService.create(invoice);

            Invoice invoice1 = InvoiceFactory.getInvoice("15 May 2019", "5x Venetian Blinds");
            invoice1.setInvoiceId(invoice.getInvoiceId());
            invoiceService.update(invoice1);
            System.out.println("Original: \n" + invoice);
            System.out.println("Updated: \n" + invoice1);

            Invoice invoice2 = invoiceService.read(Integer.parseInt(invoice1.getInvoiceId()));
            assertEquals(invoice1, invoice2);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
        }
    }

    @Test
    public void delete() {
        try {
            Invoice invoice = InvoiceFactory.getInvoice("22 May 2019", "3x Venetian Blinds");
            invoiceService.create(invoice);

            assertNotNull(invoiceService.getAll());
            Invoice invoice1 = invoiceService.read(Integer.parseInt(invoice.getInvoiceId()));
            assertNull(invoice1);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
        }
    }
}


