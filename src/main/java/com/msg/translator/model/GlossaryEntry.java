package com.msg.translator.model;

public class GlossaryEntry {

	private EntryType type;
	private String orginal;
	private String translated;

	public GlossaryEntry() {
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

}
