package factories.Supplier;

import domains.Supplier.AssembleStatus;
import util.Misc;

public class AssembleStatusFactory {

    public static AssembleStatus getAssembleStatus(){
        return(AssembleStatus) new AssembleStatus.Builder()
                .assembleStatusId(Misc.generateId())
                .build();
    }
}
