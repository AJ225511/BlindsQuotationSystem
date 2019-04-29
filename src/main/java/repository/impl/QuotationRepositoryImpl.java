package repository.impl;

import domains.Quotation.Quotation;
import repository.Quotation.QuotationRepository;

import java.util.HashSet;
import java.util.Set;

public class QuotationRepositoryImpl implements QuotationRepository{

    private static QuotationRepositoryImpl repository = null;
    private Set<Quotation> quotations;

    private QuotationRepositoryImpl(){
        this.quotations = new HashSet<>();
    }

    public static QuotationRepositoryImpl getRepository(){
        if(repository == null) repository = new QuotationRepositoryImpl();
        return repository;
    }

    public Quotation find(String id){
        return quotations.stream().filter(quotation -> quotation.getQuotationId() == id).findAny().orElse(null);
    }

    @Override
    public Set<Quotation> getAll() {
        return quotations;
    }

    @Override
    public Quotation create(Quotation quotation) {
        this.quotations.add(quotation);
        return quotation;
    }

    @Override
    public Quotation update(Quotation quotation) {
        Quotation quotation1 = find(quotation.getQuotationId());
        if(quotations.contains(quotation1)){
            quotations.remove(quotation1);
            quotations.add(quotation);
        }
        return quotation1;
    }

    @Override
    public void delete(Integer id) {

        Quotation quotation = find(Integer.toString(id));
        quotations.remove(quotation);

    }

    @Override
    public Quotation read(Integer id) {
        Quotation quotation = find(Integer.toString(id));
        if(quotation == null){
            return null;
        }
        else{
            return quotation;
        }
    }
}

