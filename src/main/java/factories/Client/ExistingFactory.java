package factories.Client;

import domains.Client.Existing;

public class ExistingFactory {

    public static Existing getExisting(String joinDate){
        return(Existing) new Existing.Builder()
                .joinDate(joinDate)
                .build();
    }
}
