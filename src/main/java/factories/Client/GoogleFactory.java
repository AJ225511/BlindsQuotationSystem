package factories.Client;

import domains.Client.Google;

public class GoogleFactory {

    public static Google getGoogle(String browseDate) {
        return (Google) new Google.Builder()
                .browseDate(browseDate)
                .build();
    }
}