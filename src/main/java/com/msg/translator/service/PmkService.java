package com.msg.translator.service;

import com.msg.translator.dao.PmkDao;
import com.msg.translator.model.GlossaryEntry;
import com.msg.translator.model.NonTranslatedTerms;
import com.msg.translator.model.PmkFormula;
import java.util.List;

public class PmkService {

	private PmkDao pmkDao;

	private TranslateService translateService;

	private NonTranslatedTermsService nonTranslatedTermsService;

	public PmkService(PmkDao pmkDao, TranslateService translateService,
			NonTranslatedTermsService nonTranslatedTermsService) {
		this.pmkDao = pmkDao;
		this.translateService = translateService;
		this.nonTranslatedTermsService = nonTranslatedTermsService;
	}

	public void translate(boolean store) {

		List<PmkFormula> formulaList = pmkDao.getAll();
		for (PmkFormula formula : formulaList) {
			String translated = translateService.translate(formula.getFormulaTextWork());
			formula.setFormulaTextWork(translated);
			pmkDao.store(formula, store);

			System.out.println("ObjectID " + formula.getObjectId() + " : \n \n" + translated + "\n");

			List<GlossaryEntry> notTranslated = translateService.getNotTranslated();
			if (!notTranslated.isEmpty()) {

				System.out.println("");
				System.out.println("**********");
				System.out.println("");

				System.out.println("Not treslated terms: ");
				for (GlossaryEntry glossaryEntry : notTranslated) {
					System.out.println(glossaryEntry);
				}

				System.out.println("");
				System.out.println("**********");
				System.out.println("");

				NonTranslatedTerms nonTranslatedTerms = new NonTranslatedTerms();
				nonTranslatedTerms.setObjectId(formula.getObjectId());
				nonTranslatedTerms.setDomainId(formula.getDomainId());
				nonTranslatedTerms.setNonTranslatedTerms(notTranslated);

				nonTranslatedTermsService.marshalXMlToFile(nonTranslatedTerms, "src//main//resources//");
			}
		}

	}

}
