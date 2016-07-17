package com.msg.translator.model;

public class PmkFormula {
    private String objectId;
    private String domainId;
    private String formulaTextWork;

    public PmkFormula() {
    }

    public PmkFormula(String objectId, String domainId, String formulaTextWork) {
        this.objectId = objectId;
        this.domainId = domainId;
        this.formulaTextWork = formulaTextWork;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public String getFormulaTextWork() {
        return formulaTextWork;
    }

    public void setFormulaTextWork(String formulaTextWork) {
        this.formulaTextWork = formulaTextWork;
    }
    //TODO: Popuni sa ostalim poljima iz tabele, mada za ovaj zadatak to nije bitno
}
