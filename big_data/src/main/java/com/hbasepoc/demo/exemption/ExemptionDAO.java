package com.hbasepoc.demo.exemption;


public class ExemptionDAO {
    private String developerUsername;
    private String service;
    private String developerBranch;
    private    String [] exemptionFiles;
    private String uniqueId;

    public ExemptionDAO(Builder _builder){
        this.developerBranch = _builder.developerBranch;
        this.exemptionFiles = _builder.exemptionFiles;
        this.service = _builder.service;
        this.developerUsername = _builder.developerUsername;
        this.uniqueId  = _builder.uniqueId;
    }

    public String[] getExemptionFiles() {
        return this.exemptionFiles;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public String getDeveloperBranch() {
        return this.developerBranch;
    }

    public String getDeveloperUsername() {
        return this.developerUsername;
    }

    public String getService() {
        return this.service;
    }

    static class  Builder{
        public String developerUsername;
        public String service;
        public String developerBranch;
        public String [] exemptionFiles;
        public String uniqueId;

        public Builder setDeveloperBranch(String developerBranch) {
            this.developerBranch = developerBranch;
            return this;
        }

        public Builder setDeveloperUsername(String developerUsername) {
            this.developerUsername = developerUsername;
            return this;
        }

        public Builder setUniqueId(String uniqueId) {
            this.uniqueId = uniqueId;
            return this;
        }

        public Builder setService(String service) {
            this.service = service;
            return this;
        }

        public Builder setExemptionFiles(String[] exemptionFiles) {
            this.exemptionFiles = exemptionFiles;
            return this;
        }
        public ExemptionDAO build(){
            return  new ExemptionDAO(this);
        }
    }

}
