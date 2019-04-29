package service.Supplier;

import domains.Supplier.AssembleStatus;
import service.Service;

import java.util.HashSet;
import java.util.Set;

public interface AssembleStatusService extends Service<AssembleStatus, Integer> {
    Set<AssembleStatus> getAll();
}
