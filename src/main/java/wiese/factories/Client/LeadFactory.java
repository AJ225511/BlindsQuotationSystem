package wiese.factories.Client;

import wiese.domains.Client.Lead;
import wiese.util.Misc;

public class LeadFactory {

    public static Lead getLead(String leadDate){
        return new Lead.Builder()
                .leadDate(leadDate)
                .leadId(Misc.generateId())
                .build();
    }
}
