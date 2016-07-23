package com.msg.translator.service;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.msg.translator.model.NonTranslatedTerms;

public class NonTranslatedTermsService {

	public NonTranslatedTermsService() {
	}

	public void marshalXMlToFile(NonTranslatedTerms nonTranslatedTerms, String pathname) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(NonTranslatedTerms.class);

			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			File file = new File(pathname + nonTranslatedTerms.getObjectId() + ".xml");
			jaxbMarshaller.marshal(nonTranslatedTerms, file);
		} catch (JAXBException e) {
			System.out.println("NonTranslatedTermsService.marshalXMlToFile(): " + e);
		}

	}
}
