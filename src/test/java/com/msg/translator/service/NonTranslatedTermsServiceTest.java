package com.msg.translator.service;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.msg.translator.model.EntryType;
import com.msg.translator.model.GlossaryEntry;
import com.msg.translator.model.NonTranslatedTerms;

public class NonTranslatedTermsServiceTest {

	@Test
	public void marshalXMlToFile() {
		NonTranslatedTermsService nonTranslatedTermsService = new NonTranslatedTermsService("src//test//resources//");

		NonTranslatedTerms nonTranslatedTermsA = new NonTranslatedTerms();
		nonTranslatedTermsA.setObjectId("A");
		nonTranslatedTermsA.setDomainId("A");

		List<GlossaryEntry> notTranslatedA = new ArrayList<>();
		notTranslatedA.add(new GlossaryEntry(EntryType.METHODS, "A"));
		notTranslatedA.add(new GlossaryEntry(EntryType.LOCAL_OBJECTS, "AA"));
		notTranslatedA.add(new GlossaryEntry(EntryType.OBJECT_ATTRIBUTES, "AAA"));
		nonTranslatedTermsA.setNonTranslated(notTranslatedA);

		File fileNonTranslatedTermsA = new File("src//test//resources//A.xml");
		if (fileNonTranslatedTermsA.exists()) {
			fileNonTranslatedTermsA.delete();
		}

		nonTranslatedTermsService.marshalXMlToFile(nonTranslatedTermsA);
		assertTrue(fileNonTranslatedTermsA.exists());
	}
}
