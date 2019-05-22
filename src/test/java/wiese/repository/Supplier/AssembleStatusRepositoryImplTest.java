package wiese.repository.Supplier;

import wiese.domains.Supplier.AssembleStatus;
import wiese.factories.Supplier.AssembleStatusFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wiese.repository.impl.AssembleStatusRepositoryImpl;

import java.io.IOException;

import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class AssembleStatusRepositoryImplTest {

    @Autowired
    private AssembleStatusRepositoryImpl assembleStatusRepository;
    private String assembleId = null;

    @Test
    public void create(){
        AssembleStatus assembleStatus = AssembleStatusFactory.getAssembleStatus();
        assembleStatusRepository.create(assembleStatus);
        Assert.assertNotNull(assembleStatusRepository.getAll());
    }

    @Test
    public void read(){
        try {
            AssembleStatus assembleStatus = AssembleStatusFactory.getAssembleStatus();
            assembleStatusRepository.create(assembleStatus);

            System.out.println(assembleStatus.getAssembleStatusId());

            AssembleStatus assembleStatus1 = assembleStatusRepository.read(Integer.parseInt(assembleStatus.getAssembleStatusId()));
            System.out.println(assembleStatus1);
        }
        catch (NumberFormatException nfe){
            System.out.println(nfe);
        }
    }

    @Test
    public void update(){
        AssembleStatus assembleStatus = AssembleStatusFactory.getAssembleStatus();
        assembleStatusRepository.create(assembleStatus);

        AssembleStatus assembleStatus2 = AssembleStatusFactory.getAssembleStatus();
        assembleStatus2.setAssembleStatusId(assembleStatus.getAssembleStatusId());

        assembleStatusRepository.update(assembleStatus2);
        System.out.println(assembleStatus);
        System.out.println(assembleStatus2);

        AssembleStatus assembleStatus3 = assembleStatusRepository.find(assembleStatus2.getAssembleStatusId());
        Assert.assertEquals(assembleStatus2,assembleStatus3);
        System.out.println(assembleStatus3);
    }

    @Test
    public void delete(){
        try {
            AssembleStatus assembleStatus = AssembleStatusFactory.getAssembleStatus();
            assembleStatusRepository.create(assembleStatus);
            Assert.assertNotNull(assembleStatusRepository.getAll());

            assembleStatusRepository.delete(Integer.parseInt(assembleStatus.getAssembleStatusId()));
            AssembleStatus deleted = assembleStatusRepository.find(assembleStatus.getAssembleStatusId());
            Assert.assertNull(deleted);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println(nfe);
        }
    }

    @Test
    public void getAll(){
        Set<AssembleStatus> assembleStatus = assembleStatusRepository.getAll();
        Assert.assertEquals(4, assembleStatus.size());
    }
}
