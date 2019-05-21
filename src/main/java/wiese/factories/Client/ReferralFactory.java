package wiese.factories.Client;

import wiese.domains.Client.Referral;
import wiese.util.Misc;

public class ReferralFactory {

    public static Referral getReferral() {
        return (Referral) new Referral.Builder()
                .referralId(Misc.generateId())
                .build();
    }
}
