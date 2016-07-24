package com.msg.translator.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="nonTranslatedTerms")
@XmlAccessorType (XmlAccessType.FIELD)
@XmlType(propOrder = { "objectId", "domainId", "nonTranslated" })
public class NonTranslatedTerms {

	@XmlElement
	private String objectId;

	@XmlElement
	private String domainId;

	@XmlElementWrapper
	@XmlElement(name = "glossaryEntry")
	private List<GlossaryEntry> nonTranslated;

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

	public List<GlossaryEntry> getNonTranslated() {
		return nonTranslated;
	}

	public void setNonTranslated(List<GlossaryEntry> nonTranslated) {
		this.nonTranslated = nonTranslated;
	}
}
