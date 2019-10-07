package wiese.domains.Supplier;

import javax.persistence.*;

public class AssembleStatus {

    @Id
    private String assembleStatusId;
    @OneToMany()
    private String desc;

    public AssembleStatus() {
    }

    public AssembleStatus(Builder builder) {
        this.assembleStatusId = builder.assembleStatusId;
        this.desc = builder.desc;
    }

    public String getAssembleStatusId() {
        return assembleStatusId;
    }

    public String getDesc(){
        return desc;
    }

    @Override
    public String toString() {
        return "AssembleStatus{" +
                "assembleStatusId='" + assembleStatusId + '\'' +
                "desc='" + desc + '\'' +
                '}';
    }

    public static class Builder {

        private String assembleStatusId, desc;

        public Builder assembleStatusId(String assembleStatusId) {
            this.assembleStatusId = assembleStatusId;
            return this;
        }

        public Builder desc(String desc){
            this.desc = desc;
            return this;
        }

        public Builder copy(AssembleStatus assembleStatus){
            this.assembleStatusId = assembleStatus.assembleStatusId;
            this.desc = assembleStatus.desc;
            return this;
        }

        public AssembleStatus build() {
            return new AssembleStatus(this);
        }
    }

}

