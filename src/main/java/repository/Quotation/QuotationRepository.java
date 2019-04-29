package repository.Quotation;

import domains.Quotation.Quotation;
import repository.Repository;

import java.util.HashSet;
import java.util.Set;

public interface QuotationRepository extends Repository <Quotation, Integer> {
    Set<Quotation> getAll();
}
