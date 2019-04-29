package repository.Supplier;

import domains.Supplier.AssembleStatus;
import repository.Repository;

import java.util.HashSet;
import java.util.Set;

public interface AssembleStatusRepository extends Repository <AssembleStatus, Integer> {
    Set<AssembleStatus> getAll();
}
