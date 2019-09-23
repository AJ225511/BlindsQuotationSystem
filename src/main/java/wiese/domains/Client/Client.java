package wiese.domains.Client;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class Client {

    private String clientId, clientName, clientAddress, clientEmail;
    private int clientPhone;

    private Client() {
    }

    public Client(Builder builder) {
        this.clientId = builder.clientId;
        this.clientName = builder.clientName;
        this.clientAddress = builder.clientAddress;
        this.clientEmail = builder.clientEmail;
        this.clientPhone = builder.clientPhone;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public int getClientPhone() {
        return clientPhone;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public void setClientPhone(int clientPhone) {
        this.clientPhone = clientPhone;
    }

    public static class Builder {

        private String clientId, clientName, clientAddress, clientEmail;
        private int clientPhone;

        public Builder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public Builder clientName(String clientName) {
            this.clientName = clientName;
            return this;
        }

        public Builder clientAddress(String clientAddress) {
            this.clientAddress = clientAddress;
            return this;
        }

        public Builder clientEmail(String clientEmail) {
            this.clientEmail = clientEmail;
            return this;
        }

        public Builder clientPhone(int clientPhone) {
            this.clientPhone = clientPhone;
            return this;
        }

        public Client build() {
            return new Client(this);
        }
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId: '" + clientId + '\'' +
                ", clientName: '" + clientName + '\'' +
                ", clientAddress: '" + clientAddress + '\'' +
                ", clientEmail: '" + clientEmail + '\'' +
                ", clientPhone: '" + clientPhone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return clientId.equals(client.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId);
    }
}
