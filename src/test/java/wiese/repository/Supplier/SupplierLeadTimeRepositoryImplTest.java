package wiese.repository.Supplier;

import wiese.domains.Supplier.SupplierLeadTime;
import wiese.factories.Supplier.SupplierLeadTimeFactory;
import wiese.repository.impl.SupplierLeadTimeRepositoryImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class SupplierLeadTimeRepositoryImplTest {

    @Autowired
    private SupplierLeadTimeRepositoryImpl supplierLeadTimeRepository;
    private String clientId = null;

    @Test
    public void create() {
        SupplierLeadTime supplierLeadTime = SupplierLeadTimeFactory.getSupplierLeadTime();
        supplierLeadTimeRepository.create(supplierLeadTime);
        Assert.assertNotNull(supplierLeadTimeRepository.getAll());
    }

    @Test
    public void read() {
        try {
            SupplierLeadTime supplierLeadTime = SupplierLeadTimeFactory.getSupplierLeadTime();
            supplierLeadTimeRepository.create(supplierLeadTime);

            System.out.println(supplierLeadTime.getLeadTimeId());

            SupplierLeadTime supplierLeadTime1 = supplierLeadTimeRepository.read(Integer.parseInt(supplierLeadTime.getLeadTimeId()));
            System.out.println(supplierLeadTime1);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
        }
    }

    @Test
    public void update() {
        SupplierLeadTime supplierLeadTime = SupplierLeadTimeFactory.getSupplierLeadTime();
        supplierLeadTimeRepository.create(supplierLeadTime);

        SupplierLeadTime supplierLeadTime2 = SupplierLeadTimeFactory.getSupplierLeadTime();
        supplierLeadTime2.setLeadTimeId(supplierLeadTime.getLeadTimeId());

        supplierLeadTimeRepository.update(supplierLeadTime2);
        System.out.println(supplierLeadTime);
        System.out.println(supplierLeadTime2);

        SupplierLeadTime supplierLeadTime3 = supplierLeadTimeRepository.find(supplierLeadTime2.getLeadTimeId());
        Assert.assertEquals(supplierLeadTime2, supplierLeadTime3);
        System.out.println(supplierLeadTime3);
    }

    @Test
    public void delete() {
        try {
            SupplierLeadTime supplierLeadTime = SupplierLeadTimeFactory.getSupplierLeadTime();
            supplierLeadTimeRepository.create(supplierLeadTime);
            Assert.assertNotNull(supplierLeadTimeRepository.getAll());

            supplierLeadTimeRepository.delete(Integer.parseInt(supplierLeadTime.getLeadTimeId()));
            SupplierLeadTime deleted = supplierLeadTimeRepository.find(supplierLeadTime.getLeadTimeId());
            Assert.assertNull(deleted);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
        }
    }
}

