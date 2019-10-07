package wiese.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wiese.domains.Supplier.SupplierLeadTime;
import wiese.repository.Supplier.SupplierLeadTimeRepository;
import wiese.service.Supplier.SupplierLeadTimeService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SupplierLeadTimeServiceImpl implements SupplierLeadTimeService {

    private static SupplierLeadTimeServiceImpl leadTimeService = null;
    @Autowired
    private SupplierLeadTimeRepository leadTimeRepository;

    private SupplierLeadTimeServiceImpl() {

    }

    public static SupplierLeadTimeService getSupplierLeadTimeService() {
        if (leadTimeService == null) leadTimeService = new SupplierLeadTimeServiceImpl();
        return leadTimeService;
    }

    @Override
    public SupplierLeadTime create(SupplierLeadTime leadTime) {
        return this.leadTimeRepository.save(leadTime);
    }

    @Override
    public SupplierLeadTime read(String s){
        Optional<SupplierLeadTime> leadTime = this.leadTimeRepository.findById(s);
        return leadTime.orElse(null);
    }

    @Override
    public SupplierLeadTime update(SupplierLeadTime leadTime){
        return this.leadTimeRepository.save(leadTime);
    }

    @Override
    public void delete(String s){
        this.leadTimeRepository.deleteById(s);
    }

    @Override
    public SupplierLeadTime retrieveByDesc(String assembleDesc){
        List<SupplierLeadTime> leadTimees = getAll();
        for(SupplierLeadTime leadTime: leadTimees){
            if(leadTime.getDesc().equalsIgnoreCase(assembleDesc)) return leadTime;
        }
        return null;
    }

    @Override
    public List<SupplierLeadTime> getAll(){
        return this.leadTimeRepository.findAll();
    }
}

