package wiese.factories.Supplier;

import wiese.domains.Supplier.AssembleStatus;
import wiese.util.Misc;

public class AssembleStatusFactory {

    public static AssembleStatus getAssembleStatus(){
        return(AssembleStatus) new AssembleStatus.Builder()
                .assembleStatusId(Misc.generateId())
                .build();
    }
}
