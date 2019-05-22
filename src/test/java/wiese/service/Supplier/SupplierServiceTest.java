package wiese.service.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import wiese.domains.Supplier.Supplier;
import wiese.factories.Supplier.SupplierFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wiese.service.impl.SupplierServiceImpl;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SupplierServiceTest {
    @Autowired
    private SupplierServiceImpl supplierService;

    @Test
    public void create(){
        Supplier supplier = SupplierFactory.getSupplier("Bayview Blinds", "12 Bratton Way");
        supplierService.create(supplier);

        assertNotNull(supplierService.getAll());
        System.out.println(supplier.getSupplierName());
    }

    @Test
    public void read(){
        try {
            Supplier supplier = SupplierFactory.getSupplier("Bayview Blinds", "12 Bratton Way");
            supplierService.create(supplier);

            Supplier supplier1 = supplierService.read(Integer.parseInt(supplier.getSupplierId()));
            assertEquals(supplier, supplier1);
        }
        catch (NumberFormatException nfe){
            System.out.println(nfe);
        }

    }

    @Test
    public void update() {
        try {
            Supplier supplier = SupplierFactory.getSupplier("Bayview Blinds", "12 Bratton Way");
            supplierService.create(supplier);

            Supplier supplier1 = SupplierFactory.getSupplier("Taylor Blinds", "2 Round Drive");
            supplier1.setSupplierId(supplier.getSupplierId());
            supplierService.update(supplier1);
            System.out.println("Original: \n"+supplier.getSupplierName());
            System.out.println("Updated: \n"+supplier1.getSupplierName());

            Supplier supplier2 = supplierService.read(Integer.parseInt(supplier1.getSupplierId()));
            assertEquals(supplier1, supplier2);
        }
        catch (NumberFormatException nfe){
            System.out.println(nfe);
        }
    }
    @Test
    public void delete(){
        try {
            Supplier supplier = SupplierFactory.getSupplier("Table Bay Blinds", "12 Tree Road");
            supplierService.create(supplier);

            assertNotNull(supplierService.getAll());
            Supplier supplier1 = supplierService.read(Integer.parseInt(supplier.getSupplierId()));
            assertNull(supplier1);
        }catch (NumberFormatException nfe){
            System.out.println(nfe);
        }
    }
}
