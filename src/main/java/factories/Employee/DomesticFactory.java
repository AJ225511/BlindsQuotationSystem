package factories.Employee;

import domains.Employeee.Domestic;

public class DomesticFactory {

    public static Domestic getDomestic(String daysOnDuty){
        return(Domestic) new Domestic.Builder()
                .daysOnDuty(daysOnDuty)
                .build();
    }
}
