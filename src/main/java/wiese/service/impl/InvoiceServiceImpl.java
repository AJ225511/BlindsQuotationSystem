package wiese.service.impl;

import org.springframework.stereotype.Service;
import wiese.domains.Invoice.Invoice;
import wiese.repository.Invoice.InvoiceRepository;
import wiese.repository.impl.InvoiceRepositoryImpl;
import wiese.service.Invoice.InvoiceService;

import java.util.Set;

@Service("InvoiceServiceImpl")
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceServiceImpl service = null;
    private InvoiceRepository repository;
    private Integer id;

    public InvoiceServiceImpl(){
        repository = InvoiceRepositoryImpl.getRepository();
    }

    public InvoiceService getService(){
        if(service == null) service = new InvoiceServiceImpl();
        return service;
    }

    @Override
    public Set<Invoice> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Invoice create(Invoice invoice) {
        return this.repository.create(invoice);
    }

    @Override
    public Invoice update(Invoice invoice) {
        return this.repository.update(invoice);
    }

    @Override
    public void delete(Integer integer) {
        this.repository.delete(id);
    }

    @Override
    public Invoice read(Integer integer) {
        return this.repository.read(id);
    }
}
