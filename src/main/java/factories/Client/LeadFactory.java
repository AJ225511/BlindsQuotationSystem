package factories.Client;

import domains.Client.Lead;
import util.Misc;

public class LeadFactory {

    public static Lead getLead(String leadDate){
        return new Lead.Builder()
                .leadDate(leadDate)
                .leadId(Misc.generateId())
                .build();
    }
}
