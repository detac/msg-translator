package com.msg.translator.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "glossaryEntry")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "type", "orginal", "translated" })
public class GlossaryEntry {

	@XmlElement
	private EntryType type;

	@XmlElement
	private String orginal;

	@XmlElement
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
		return "GlossaryEntry : type[" + type + "] orginal[" + orginal + "] translated[" + translated + "]";
	}

}
