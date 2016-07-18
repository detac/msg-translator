package com.msg.translator.model;

import java.util.List;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = { "objectId", "domainId", "nonTranslatedTerms" })
public class NonTranslatedTerms {

  private String objectId;

  private String domainId;

  private List<GlossaryEntry> nonTranslatedTerms = new ArrayList<>();

  public NonTranslatedTerms() {
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

  public List<GlossaryEntry> getNonTranslatedTerms() {
    return nonTranslatedTerms;
  }

  public void setNonTranslatedTerms(List<GlossaryEntry> nonTranslatedTerms) {
    this.nonTranslatedTerms = nonTranslatedTerms;
  }
}
