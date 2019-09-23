package wiese.domains.Client;

import java.util.Objects;

public class WebRequest extends Lead {

    private String requestId;

    public WebRequest() {
    }

    public WebRequest(Builder builder) {
        super(builder);
        this.requestId = builder.requestId;
    }

    public String getRequestId() {
        return requestId;
    }

    public static class Builder extends Lead.Builder {

        private String requestId;

        public Builder requestId(String requestId) {
            this.requestId = requestId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebRequest webRequest = (WebRequest) o;
        return requestId.equals(webRequest.requestId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestId);
    }
}

