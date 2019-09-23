package wiese.factories.Client;

import wiese.domains.Client.Client;
import wiese.util.Misc;

public class ClientFactory {

    public static Client getClient(String clientName, String clientAddress, String clientEmail, int clientPhone) {
        return new Client.Builder()
                .clientPhone(clientPhone)
                .clientName(clientName)
                .clientAddress(clientAddress)
                .clientEmail(clientEmail)
                .clientId(Misc.generateId())
                .build();
    }
}
