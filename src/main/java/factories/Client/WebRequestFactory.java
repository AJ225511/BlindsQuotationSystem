package factories.Client;

import domains.Client.WebRequest;
import util.Misc;

public class WebRequestFactory {

    public static WebRequest getWebRequest() {
        return (WebRequest) new WebRequest.Builder()
                .requestId(Misc.generateId())
                .build();
    }
}
