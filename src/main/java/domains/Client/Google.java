package domains.Client;

public class Google extends Lead{
    private String browseDate;

    public Google(){}

    public Google(Builder builder){
        super(builder);
        this.browseDate=builder.browseDate;
    }

    public String getBrowseDateDate(){
        return browseDate;
    }

    public static class Builder extends Lead.Builder{

        private String browseDate;

        public Builder browseDate(String browseDate){
            this.browseDate=browseDate;
            return this;
        }

        @Override
        public Lead build() {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Google{" +
                "browseDate='" + browseDate + '\'' +
                '}';
    }
}
