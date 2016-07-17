package com.msg.translator.service;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.msg.translator.model.NonTranslatedTerms;

public class NonTranslatedTermsService {

	private List<NonTranslatedTerms> list;

	public NonTranslatedTermsService() {
	}

	public void marshalXMlToFile() {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(NonTranslatedTerms.class);

			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			for (NonTranslatedTerms nonTranslatedTerms : list) {
				File file = new File("/home/visual/dev/projects/eclipse/goca/translator/src/main/resources/"
						+ nonTranslatedTerms.getObjectId() + ".xml");
				jaxbMarshaller.marshal(nonTranslatedTerms, file);
			}
		} catch (JAXBException e) {
			System.out.println("NonTranslatedTermsService.marshalXMlToFile(): " + e);
		}

	}

	public List<NonTranslatedTerms> getList() {
		return list;
	}

	public void setList(List<NonTranslatedTerms> list) {
		this.list = list;
	}

}
