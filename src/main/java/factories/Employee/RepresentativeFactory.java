package factories.Employee;

import domains.Employeee.Representative;
import util.Misc;

public class RepresentativeFactory {

    public static Representative getRepresentative(){
        return( Representative) new  Representative.Builder()
                .representativeId(Misc.generateId())
                .build();
    }
}
