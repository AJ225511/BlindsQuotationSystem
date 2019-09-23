package wiese.service.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import wiese.domains.Supplier.AssembleStatus;
import wiese.factories.Supplier.AssembleStatusFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wiese.service.impl.AssembleStatusServiceImpl;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssembleStatusServiceTest {
    @Autowired
    private AssembleStatusServiceImpl assembleStatusService;

    @Test
    public void create() {
        AssembleStatus assembleStatus = AssembleStatusFactory.getAssembleStatus();
        assembleStatusService.create(assembleStatus);

        assertNotNull(assembleStatusService.getAll());
        System.out.println(assembleStatus);
    }

    @Test
    public void read() {
        try {
            AssembleStatus assembleStatus = AssembleStatusFactory.getAssembleStatus();
            assembleStatusService.create(assembleStatus);

            AssembleStatus assembleStatus1 = assembleStatusService.read(Integer.parseInt(assembleStatus.getAssembleStatusId()));
            assertEquals(assembleStatus, assembleStatus1);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
        }

    }

    @Test
    public void update() {
        try {
            AssembleStatus assembleStatus = AssembleStatusFactory.getAssembleStatus();
            assembleStatusService.create(assembleStatus);

            AssembleStatus assembleStatus1 = AssembleStatusFactory.getAssembleStatus();
            assembleStatus1.setAssembleStatusId(assembleStatus.getAssembleStatusId());
            assembleStatusService.update(assembleStatus1);
            System.out.println("Original: \n" + assembleStatus);
            System.out.println("Updated: \n" + assembleStatus1);

            AssembleStatus assembleStatus2 = assembleStatusService.read(Integer.parseInt(assembleStatus1.getAssembleStatusId()));
            assertEquals(assembleStatus1, assembleStatus2);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
        }
    }

    @Test
    public void delete() {
        try {
            AssembleStatus assembleStatus = AssembleStatusFactory.getAssembleStatus();
            assembleStatusService.create(assembleStatus);

            assertNotNull(assembleStatusService.getAll());
            AssembleStatus assembleStatus1 = assembleStatusService.read(Integer.parseInt(assembleStatus.getAssembleStatusId()));
            assertNull(assembleStatus1);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
        }
    }
}

