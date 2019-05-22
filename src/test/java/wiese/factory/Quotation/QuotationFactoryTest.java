package wiese.factory.Quotation;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import wiese.domains.Quotation.Quotation;
import wiese.factories.Quotation.QuotationFactory;

public class QuotationFactoryTest {
    @Before
    public void setUp() throws Exception{

    }
    @Test
    public void getQuotation(){

        Quotation quotation = QuotationFactory.getQuotation("12 February 2019");
        Assert.assertNotNull(quotation.getQuotationId());
        System.out.println(quotation.getQuotationDate());
    }
}

