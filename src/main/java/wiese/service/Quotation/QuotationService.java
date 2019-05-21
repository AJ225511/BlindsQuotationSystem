package wiese.service.Quotation;

import wiese.domains.Quotation.Quotation;
import wiese.service.Service;

import java.util.Set;

public interface QuotationService extends Service<Quotation, Integer> {
    Set<Quotation> getAll();
}
