package wiese.service.Supplier;

import wiese.domains.Supplier.AssembleStatus;
import wiese.service.Service;

import java.util.Set;

public interface AssembleStatusService extends Service<AssembleStatus, Integer> {
    Set<AssembleStatus> getAll();
}
