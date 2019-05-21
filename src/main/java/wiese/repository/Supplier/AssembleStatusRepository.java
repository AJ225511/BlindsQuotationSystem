package wiese.repository.Supplier;

import wiese.domains.Supplier.AssembleStatus;
import wiese.repository.Repository;

import java.util.Set;

public interface AssembleStatusRepository extends Repository <AssembleStatus, Integer> {
    Set<AssembleStatus> getAll();
}
