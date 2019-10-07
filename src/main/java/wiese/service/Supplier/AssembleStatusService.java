package wiese.service.Supplier;

import wiese.domains.Supplier.AssembleStatus;
import wiese.service.Service;

import java.util.List;
import java.util.Set;

public interface AssembleStatusService extends Service<AssembleStatus, String> {
    AssembleStatus retrieveByDesc(String assembleDesc);
    List<AssembleStatus> getAll();
}
