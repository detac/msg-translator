package com.msg.translator.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.msg.translator.dao.GlossaryDao;
import com.msg.translator.model.GlossaryEntry;
import com.msg.translator.utils.FileUtil;

public class TranslateServiceTest {

	@Test
	public void translate() {
		GlossaryDao glossaryDao = new GlossaryDao();
		GlossaryService glossaryService = new GlossaryService(glossaryDao);
		TranslateService translateService = new TranslateService(glossaryService);
		
		String formulaGer = FileUtil.read("src//test//resources//8WH6000T11_ger.txt");
		assertFalse(formulaGer.isEmpty());
		
		String translatedFormula = translateService.translate(formulaGer);
		assertFalse(translatedFormula.isEmpty());
		
		String formulaEng = FileUtil.read("src//test//resources//8WH6000T11_eng.txt");
		assertFalse(formulaEng.isEmpty());
		
		assertTrue(translatedFormula.equals(formulaEng));

		List<GlossaryEntry> notTranslated = translateService.getNotTranslated();
		assertTrue(notTranslated.size() == 6);
	}

}
