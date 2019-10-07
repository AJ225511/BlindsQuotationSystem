package wiese.domains.Client;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Objects;

@EntityScan
public class Client {
    
    @Id
    private String clientId, clientName, clientAddress, clientEmail;
    @OneToMany()
    private String desc;

    public Client() {
    }

    public Client(Builder builder) {
        this.clientId = builder.clientId;
        this.clientAddress=builder.clientAddress;
        this.clientEmail=builder.clientEmail;
        this.clientName=builder.clientName;
        this.desc = builder.desc;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public String getClientName() {
        return clientName;
    }

    public String getDesc(){
        return desc;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId='" + clientId + '\'' +
                "clientAddress='" + clientAddress + '\'' +
                "clientEmail='" + clientEmail + '\'' +
                "clientName='" + clientName + '\'' +
                "desc='" + desc + '\'' +
                '}';
    }

    public static class Builder {

        private String clientId,clientName, clientAddress, clientEmail, desc;

        public Builder clientId(String clientId) {
            this.clientId = clientId;
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

        public Builder clientName(String clientName) {
            this.clientName = clientName;
            return this;
        }

        public Builder desc(String desc){
            this.desc = desc;
            return this;
        }

        public Builder copy(Client client){
            this.clientId = client.clientId;
            this.clientAddress=client.clientAddress;
            this.clientName=client.clientName;
            this.clientEmail=client.clientEmail;
            this.desc = client.desc;
            return this;
        }

        public Client build() {
            return new Client(this);
        }
    }

}
