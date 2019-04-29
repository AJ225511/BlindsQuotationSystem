package service.Quotation;

import domains.Quotation.Quotation;
import service.Service;

import java.util.HashSet;
import java.util.Set;

public interface QuotationService extends Service<Quotation, Integer> {
    Set<Quotation> getAll();
}
