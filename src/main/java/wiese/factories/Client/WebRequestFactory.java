package wiese.factories.Client;

import wiese.domains.Client.WebRequest;
import wiese.util.Misc;

public class WebRequestFactory {

    public static WebRequest getWebRequest() {
        return (WebRequest) new WebRequest.Builder()
                .requestId(Misc.generateId())
                .build();
    }
}
