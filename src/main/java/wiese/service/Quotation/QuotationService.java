package wiese.service.Quotation;

import wiese.domains.Quotation.Quotation;
import wiese.service.Service;

import java.util.List;
import java.util.Set;

public interface QuotationService extends Service<Quotation, String> {
    Quotation retrieveByDesc(String quotationDesc);
    List<Quotation> getAll();
}
