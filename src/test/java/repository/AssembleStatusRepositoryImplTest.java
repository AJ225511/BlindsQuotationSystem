package repository;

import domains.Supplier.AssembleStatus;
import factories.Supplier.AssembleStatusFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.impl.AssembleStatusRepositoryImpl;

import static org.junit.Assert.*;

public class AssembleStatusRepositoryImplTest {

    AssembleStatusRepositoryImpl assembleStatusRepository;

    @Before
    public void setUp() throws Exception{

        assembleStatusRepository = AssembleStatusRepositoryImpl.getRepository();
    }

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
}
