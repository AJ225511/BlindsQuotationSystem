package domains.Client;

public class Client {

    private String clientId, clientName, clientAddress, clientEmail;
    private int clientPhone;

    private Client(){}

    public Client(Builder builder){
        this.clientId = builder.clientId;
        this.clientName = builder.clientName;
        this.clientAddress = builder.clientAddress;
        this.clientEmail = builder.clientEmail;
        this.clientPhone = builder.clientPhone;
    }

    public String getClientId(){
        return clientId;
    }

    public String getClientName(){
        return clientName;
    }

    public String getClientAddress(){
        return clientAddress;
    }

    public String getClientEmail(){
        return clientEmail;
    }

    public int getClientPhone(){
        return clientPhone;
    }

    public static class Builder{

        private String clientId, clientName, clientAddress, clientEmail;
        private int clientPhone;

        public Builder clientId(String clientId){
            this.clientId=clientId;
            return this;
        }

        public Builder clientName(String clientName){
            this.clientName=clientName;
            return this;
        }

        public Builder clientAddress(String clientAddress){
            this.clientAddress=clientAddress;
            return this;
        }

        public Builder clientEmail(String clientEmail){
            this.clientEmail=clientEmail;
            return this;
        }

        public Builder clientPhone(int clientPhone){
            this.clientPhone = clientPhone;
            return this;
        }

        public Client build(){
            return new Client(this);
        }
    }

    @Override
    public String toString(){
        return "Client{"+
                "clientId: '"+ clientId + '\''+
                ", clientName: '" + clientName +'\'' +
                ", clientAddress: '" + clientAddress +'\'' +
                ", clientEmail: '" + clientEmail +'\'' +
                ", clientPhone: '" + clientPhone +'\'' +
                '}';
    }
}
