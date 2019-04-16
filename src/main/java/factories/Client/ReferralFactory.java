package factories.Client;

import domains.Client.Referral;
import util.Misc;

public class ReferralFactory {

    public static Referral getReferral() {
        return (Referral) new Referral.Builder()
                .referralId(Misc.generateId())
                .build();
    }
}
