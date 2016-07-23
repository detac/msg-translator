package com.msg.translator.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.msg.translator.dao.GlossaryDao;

public class GlossaryServiceTest {

	@Test
	public void translate() {
		GlossaryDao glossaryDao = new GlossaryDao();
		GlossaryService glossaryService = new GlossaryService(glossaryDao);
		glossaryService.init();

		String actual = "";

		// PATHS
		actual = glossaryService.translate("zzzxxxccc");
		assertNull(actual);

		// PATHS
		actual = glossaryService.translate("pathBtr");
		assertEquals("pathPrem", actual);

		// EXTERNAL_OBJECTS
		actual = glossaryService.translate("extVObj");
		assertEquals("extInsObj", actual);

		// OBJECT_ATTRIBUTES
		actual = glossaryService.translate("Beginn");
		assertEquals("Begin", actual);

		// METHODS
		actual = glossaryService.translate("vtm_Initialisieren");
		assertEquals("vtm_Initialize", actual);

		// LOCAL_OBJECTS
		actual = glossaryService.translate("objBtr");
		assertEquals("objPrem", actual);

		// LOCAL_VARIABLES
		actual = glossaryService.translate("li_BeitragManuellKnz");
		assertEquals("li_FlagManualRating", actual);
	}
}
