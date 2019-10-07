package wiese.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wiese.domains.Invoice.Invoice;
import wiese.repository.Invoice.InvoiceRepository;
import wiese.service.Invoice.InvoiceService;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private static InvoiceServiceImpl assembleStatusService = null;
    @Autowired
    private InvoiceRepository assembleStatusRepository;

    private InvoiceServiceImpl() {

    }

    public static InvoiceService getInvoiceService() {
        if (assembleStatusService == null) assembleStatusService = new InvoiceServiceImpl();
        return assembleStatusService;
    }

    @Override
    public Invoice create(Invoice assembleStatus) {
        return this.assembleStatusRepository.save(assembleStatus);
    }

    @Override
    public Invoice read(String s){
        Optional<Invoice> assembleStatus = this.assembleStatusRepository.findById(s);
        return assembleStatus.orElse(null);
    }

    @Override
    public Invoice update(Invoice assembleStatus){
        return this.assembleStatusRepository.save(assembleStatus);
    }

    @Override
    public void delete(String s){
        this.assembleStatusRepository.deleteById(s);
    }

    @Override
    public Invoice retrieveByDesc(String assembleDesc){
        List<Invoice> assembleStatuses = getAll();
        for(Invoice assembleStatus: assembleStatuses){
            if(assembleStatus.getDesc().equalsIgnoreCase(assembleDesc)) return assembleStatus;
        }
        return null;
    }

    @Override
    public List<Invoice> getAll(){
        return this.assembleStatusRepository.findAll();
    }
}
