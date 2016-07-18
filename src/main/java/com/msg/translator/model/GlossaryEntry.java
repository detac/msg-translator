package com.msg.translator.model;

public class GlossaryEntry {

  private EntryType type;

  private String orginal;

  private String translated;

  public GlossaryEntry() {
  }

  public GlossaryEntry(EntryType type, String orginal) {
    this.type = type;
    this.orginal = orginal;
  }

  public EntryType getType() {
    return type;
  }

  public void setType(EntryType type) {
    this.type = type;
  }

  public String getOriginal() {
    return orginal;
  }

  public void setOriginal(String original) {
    this.orginal = original;
  }

  public String getTranslated() {
    return translated;
  }

  public void setTranslated(String translated) {
    this.translated = translated;
  }

  @Override
  public String toString() {
    return "Translation for term " + orginal + " not found.";
  }

}
