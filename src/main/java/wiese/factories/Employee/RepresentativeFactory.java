package wiese.factories.Employee;

import wiese.domains.Employeee.Representative;
import wiese.util.Misc;

public class RepresentativeFactory {

    public static Representative getRepresentative() {
        return (Representative) new Representative.Builder()
                .representativeId(Misc.generateId())
                .build();
    }
}
