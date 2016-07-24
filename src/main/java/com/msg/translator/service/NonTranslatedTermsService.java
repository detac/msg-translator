package com.msg.translator.service;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.msg.translator.model.GlossaryEntry;
import com.msg.translator.model.NonTranslatedTerms;

public class NonTranslatedTermsService {

	private String pathname;

	@SuppressWarnings("unused")
	private NonTranslatedTermsService() {
	}

	public NonTranslatedTermsService(String pathname) {
		this.pathname = pathname;
	}

	public void marshalXMlToFile(NonTranslatedTerms nonTranslatedTerms) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(NonTranslatedTerms.class, GlossaryEntry.class);

			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			File file = new File(pathname + nonTranslatedTerms.getObjectId() + ".xml");
			jaxbMarshaller.marshal(nonTranslatedTerms, file);
		} catch (JAXBException e) {
			System.out.println("NonTranslatedTermsService.marshalXMlToFile(): " + e);
		}

	}
}
