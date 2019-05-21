package wiese.repository.impl;

import org.springframework.stereotype.Repository;
import wiese.domains.Invoice.Invoice;
import wiese.repository.Invoice.InvoiceRepository;

import java.util.HashSet;
import java.util.Set;

@Repository("InvoiceInMemory")
public class InvoiceRepositoryImpl implements InvoiceRepository {

    private static InvoiceRepositoryImpl repository = null;
    private Set<Invoice> invoices;

    private InvoiceRepositoryImpl(){
        this.invoices = new HashSet<>();
    }

    public static InvoiceRepositoryImpl getRepository(){
        if(repository == null) repository = new InvoiceRepositoryImpl();
        return repository;
    }

    public Invoice find(String id){
        return invoices.stream().filter(invoice -> invoice.getInvoiceId() == id).findAny().orElse(null);
    }

    @Override
    public Set<Invoice> getAll() {
        return invoices;
    }

    @Override
    public Invoice create(Invoice invoice) {
        this.invoices.add(invoice);
        return invoice;
    }

    @Override
    public Invoice update(Invoice invoice) {
        Invoice invoice1 = find(invoice.getInvoiceId());
        if(invoices.contains(invoice1)){
            invoices.remove(invoice1);
            invoices.add(invoice);
        }
        return invoice1;
    }

    @Override
    public void delete(Integer id) {

        Invoice invoice = find(Integer.toString(id));
        invoices.remove(invoice);

    }

    @Override
    public Invoice read(Integer id) {
        Invoice invoice = find(Integer.toString(id));
        if(invoice == null){
            return null;
        }
        else{
            return invoice;
        }
    }
}
