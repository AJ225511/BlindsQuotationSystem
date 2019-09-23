package wiese.service.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import wiese.domains.Supplier.SupplierLeadTime;
import wiese.factories.Supplier.SupplierLeadTimeFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wiese.service.impl.SupplierLeadTimeServiceImpl;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SupplierLeadTimeServiceTest {
    @Autowired
    private SupplierLeadTimeServiceImpl supplierLeadTimeService;

    @Test
    public void create() {
        SupplierLeadTime supplierLeadTime = SupplierLeadTimeFactory.getSupplierLeadTime();
        supplierLeadTimeService.create(supplierLeadTime);

        assertNotNull(supplierLeadTimeService.getAll());
        System.out.println(supplierLeadTime);
    }

    @Test
    public void read() {
        try {
            SupplierLeadTime supplierLeadTime = SupplierLeadTimeFactory.getSupplierLeadTime();
            supplierLeadTimeService.create(supplierLeadTime);

            SupplierLeadTime supplierLeadTime1 = supplierLeadTimeService.read(Integer.parseInt(supplierLeadTime.getLeadTimeId()));
            assertEquals(supplierLeadTime, supplierLeadTime1);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
        }

    }

    @Test
    public void update() {
        try {
            SupplierLeadTime supplierLeadTime = SupplierLeadTimeFactory.getSupplierLeadTime();
            supplierLeadTimeService.create(supplierLeadTime);

            SupplierLeadTime supplierLeadTime1 = SupplierLeadTimeFactory.getSupplierLeadTime();
            supplierLeadTime1.setLeadTimeId(supplierLeadTime.getLeadTimeId());
            supplierLeadTimeService.update(supplierLeadTime1);
            System.out.println("Original: \n" + supplierLeadTime);
            System.out.println("Updated: \n" + supplierLeadTime1);

            SupplierLeadTime supplierLeadTime2 = supplierLeadTimeService.read(Integer.parseInt(supplierLeadTime1.getLeadTimeId()));
            assertEquals(supplierLeadTime1, supplierLeadTime2);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
        }
    }

    @Test
    public void delete() {
        try {
            SupplierLeadTime supplierLeadTime = SupplierLeadTimeFactory.getSupplierLeadTime();
            supplierLeadTimeService.create(supplierLeadTime);

            assertNotNull(supplierLeadTimeService.getAll());
            SupplierLeadTime supplierLeadTime1 = supplierLeadTimeService.read(Integer.parseInt(supplierLeadTime.getLeadTimeId()));
            assertNull(supplierLeadTime1);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
        }
    }
}
