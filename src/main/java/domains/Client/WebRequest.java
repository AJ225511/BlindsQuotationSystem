package domains.Client;

public class WebRequest extends Lead {

    private String requestId;

    public WebRequest(){}

    public WebRequest(Builder builder){
        super(builder);
        this.requestId=builder.requestId;
    }

    public String getRequestId(){
        return requestId;
    }

    public static class Builder extends Lead.Builder{

        private String requestId;

        public Builder requestId(String requestId){
            this.requestId=requestId;
            return this;
        }

        @Override
        public Lead build() {
            return null;
        }
    }

    @Override
    public String toString() {
        return "WebRequest{" +
                "requestId='" + requestId + '\'' +
                '}';
    }
}
