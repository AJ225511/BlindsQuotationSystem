package repository;

import domains.Supplier.SupplierLeadTime;
import factories.Supplier.SupplierLeadTimeFactory;
import repository.Supplier.SupplierLeadTimeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.impl.SupplierLeadTimeRepositoryImpl;

import static org.junit.Assert.*;


public class SupplierLeadTimeRepositoryImplTest {

    SupplierLeadTimeRepositoryImpl supplierLeadTimeRepository;

    @Before
    public void setUp() throws Exception{

        supplierLeadTimeRepository = SupplierLeadTimeRepositoryImpl.getRepository();
    }

    @Test
    public void create(){
        SupplierLeadTime supplierLeadTime = SupplierLeadTimeFactory.getSupplierLeadTime();
        supplierLeadTimeRepository.create(supplierLeadTime);
        Assert.assertNotNull(supplierLeadTimeRepository.getAll());
    }

    @Test
    public void read(){
        try {
            SupplierLeadTime supplierLeadTime = SupplierLeadTimeFactory.getSupplierLeadTime();
            supplierLeadTimeRepository.create(supplierLeadTime);

            System.out.println(supplierLeadTime.getLeadTimeId());

            SupplierLeadTime supplierLeadTime1 = supplierLeadTimeRepository.read(Integer.parseInt(supplierLeadTime.getLeadTimeId()));
            System.out.println(supplierLeadTime1);
        }
        catch (NumberFormatException nfe){
            System.out.println(nfe);
        }
    }

    @Test
    public void update(){
        SupplierLeadTime supplierLeadTime = SupplierLeadTimeFactory.getSupplierLeadTime();
        supplierLeadTimeRepository.create(supplierLeadTime);

        SupplierLeadTime supplierLeadTime2 = SupplierLeadTimeFactory.getSupplierLeadTime();
        supplierLeadTime2.setLeadTimeId(supplierLeadTime.getLeadTimeId());

        supplierLeadTimeRepository.update(supplierLeadTime2);
        System.out.println(supplierLeadTime);
        System.out.println(supplierLeadTime2);

        SupplierLeadTime supplierLeadTime3 = supplierLeadTimeRepository.find(supplierLeadTime2.getLeadTimeId());
        Assert.assertEquals(supplierLeadTime2,supplierLeadTime3);
        System.out.println(supplierLeadTime3);
    }

    @Test
    public void delete(){
        try {
            SupplierLeadTime supplierLeadTime = SupplierLeadTimeFactory.getSupplierLeadTime();
            supplierLeadTimeRepository.create(supplierLeadTime);
            Assert.assertNotNull(supplierLeadTimeRepository.getAll());

            supplierLeadTimeRepository.delete(Integer.parseInt(supplierLeadTime.getLeadTimeId()));
            SupplierLeadTime deleted = supplierLeadTimeRepository.find(supplierLeadTime.getLeadTimeId());
            Assert.assertNull(deleted);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println(nfe);
        }
    }
}

