package wiese.repository.Invoice;

import wiese.domains.Invoice.Invoice;
import wiese.factories.Invoice.InvoiceFactory;
import wiese.repository.impl.InvoiceRepositoryImpl;
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
public class InvoiceRepositoryImplTest {

    @Autowired
    private InvoiceRepositoryImpl invoiceRepository;
    private String clientId = null;

    @Test
    public void create() {

        Invoice invoice = InvoiceFactory.getInvoice("12 April", "2x Blinds");
        invoiceRepository.create(invoice);

        Assert.assertNotNull(invoiceRepository.getAll());
    }

    @Test
    public void read() {
        try {
            Invoice invoice = InvoiceFactory.getInvoice("12 April", "2x Blinds");
            invoiceRepository.create(invoice);

            Assert.assertNotNull(invoiceRepository.getAll());
            System.out.println(invoice);

            Invoice invoice1 = invoiceRepository.read(Integer.parseInt(invoice.getInvoiceId()));
            Assert.assertEquals(invoice, invoice1);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
        }

    }

    @Test
    public void update() {

        Invoice invoice = InvoiceFactory.getInvoice("12 April", "2x Blinds");
        invoiceRepository.create(invoice);

        Assert.assertNotNull(invoiceRepository.getAll());
        Invoice invoice1 = InvoiceFactory.getInvoice("13 April", "5x Blinds");
        invoice1.setInvoiceId(invoice.getInvoiceId());
        invoiceRepository.update(invoice1);

        Invoice updatedInvoice = invoiceRepository.find(invoice1.getInvoiceId());
        Assert.assertEquals(invoice1, updatedInvoice);

        System.out.println(updatedInvoice);

    }

    @Test
    public void delete() {
        try {
            Invoice invoice = InvoiceFactory.getInvoice("12 April", "2x Blinds");
            invoiceRepository.create(invoice);

            Assert.assertNotNull(invoiceRepository.getAll());
            invoiceRepository.delete(Integer.parseInt(invoice.getInvoiceId()));
            Invoice deleted = invoiceRepository.find(invoice.getInvoiceId());
            Assert.assertNull(deleted);

            System.out.println(deleted);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
        }


    }
}

