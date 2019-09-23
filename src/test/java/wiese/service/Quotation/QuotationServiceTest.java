package wiese.service.Quotation;

import org.springframework.beans.factory.annotation.Autowired;
import wiese.domains.Quotation.Quotation;
import wiese.factories.Quotation.QuotationFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wiese.service.impl.QuotationServiceImpl;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuotationServiceTest {
    @Autowired
    private QuotationServiceImpl quotationService;

    @Test
    public void create() {
        Quotation quotation = QuotationFactory.getQuotation("12 April 2019");
        quotationService.create(quotation);

        assertNotNull(quotationService.getAll());
        System.out.println(quotation.getQuotationDate());
    }

    @Test
    public void read() {
        try {
            Quotation quotation = QuotationFactory.getQuotation("12 April 2019");
            quotationService.create(quotation);

            Quotation quotation1 = quotationService.read(Integer.parseInt(quotation.getQuotationId()));
            assertEquals(quotation, quotation1);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
        }

    }

    @Test
    public void update() {
        try {
            Quotation quotation = QuotationFactory.getQuotation("15 April 2019");
            quotationService.create(quotation);

            Quotation quotation1 = QuotationFactory.getQuotation("16 April 2019");
            quotation1.setQuotationId(quotation.getQuotationId());
            quotationService.update(quotation1);
            System.out.println("Original: \n" + quotation.getQuotationDate());
            System.out.println("Updated: \n" + quotation1.getQuotationDate());

            Quotation quotation2 = quotationService.read(Integer.parseInt(quotation1.getQuotationId()));
            assertEquals(quotation1, quotation2);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
        }
    }

    @Test
    public void delete() {
        try {
            Quotation quotation = QuotationFactory.getQuotation("12 April 2019");
            quotationService.create(quotation);

            assertNotNull(quotationService.getAll());
            Quotation quotation1 = quotationService.read(Integer.parseInt(quotation.getQuotationId()));
            assertNull(quotation1);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
        }
    }
}

