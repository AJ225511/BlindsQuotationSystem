package domains.Supplier;

public class AssembleStatus {

    private String assembleStatusId;

    public AssembleStatus(){}

    public AssembleStatus(Builder builder){
        this.assembleStatusId=builder.assembleStatusId;
    }

    public String getAssembleStatusId(){
        return assembleStatusId;
    }

    public void setAssembleStatusId(String assembleStatusId) {
        this.assembleStatusId = assembleStatusId;
    }

    public static class Builder{

        private String assembleStatusId;

        public Builder assembleStatusId(String assembleStatusId){
            this.assembleStatusId=assembleStatusId;
            return this;
        }

        public AssembleStatus build() {
            return new AssembleStatus(this);
        }
    }

    @Override
    public String toString() {
        return "AssembleStatus{" +
                "assembleStatusId='" + assembleStatusId + '\'' +
                '}';
    }
}
