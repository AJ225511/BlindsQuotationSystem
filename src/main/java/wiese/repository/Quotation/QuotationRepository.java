package wiese.repository.Quotation;

import wiese.domains.Quotation.Quotation;
import wiese.repository.Repository;

import java.util.Set;

public interface QuotationRepository extends Repository<Quotation, Integer> {
    Set<Quotation> getAll();
}
