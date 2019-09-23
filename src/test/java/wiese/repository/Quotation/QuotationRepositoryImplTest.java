package wiese.repository.Quotation;

import wiese.domains.Quotation.Quotation;
import wiese.factories.Quotation.QuotationFactory;
import wiese.repository.impl.QuotationRepositoryImpl;
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

public class QuotationRepositoryImplTest {

    @Autowired
    private QuotationRepositoryImpl quotationRepository;
    private String clientId = null;

    @Test
    public void create() {

        Quotation quotation = QuotationFactory.getQuotation("11 April 2019");
        quotationRepository.create(quotation);

        Assert.assertNotNull(quotationRepository.getAll());
    }

    @Test
    public void read() {
        try {
            Quotation quotation = QuotationFactory.getQuotation("11 April 2019");
            quotationRepository.create(quotation);

            Assert.assertNotNull(quotationRepository.getAll());
            System.out.println(quotation);

            Quotation quotation1 = quotationRepository.read(Integer.parseInt(quotation.getQuotationId()));
            Assert.assertEquals(quotation, quotation1);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
        }

    }

    @Test
    public void update() {

        Quotation quotation = QuotationFactory.getQuotation("11 April 2019");
        quotationRepository.create(quotation);

        Assert.assertNotNull(quotationRepository.getAll());
        Quotation quotation1 = QuotationFactory.getQuotation("16 April 2019");
        quotation1.setQuotationId(quotation.getQuotationId());
        quotationRepository.update(quotation1);

        Quotation updatedQuotation = quotationRepository.find(quotation1.getQuotationId());
        Assert.assertEquals(quotation1, updatedQuotation);

        System.out.println(updatedQuotation);

    }

    @Test
    public void delete() {
        try {
            Quotation quotation = QuotationFactory.getQuotation("11 April 2019");
            quotationRepository.create(quotation);

            Assert.assertNotNull(quotationRepository.getAll());
            quotationRepository.delete(Integer.parseInt(quotation.getQuotationId()));
            Quotation deleted = quotationRepository.find(quotation.getQuotationId());
            Assert.assertNull(deleted);

            System.out.println(deleted);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
        }


    }
}

