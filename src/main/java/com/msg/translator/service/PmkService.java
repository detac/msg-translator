package com.msg.translator.service;

import com.msg.translator.dao.PmkDao;
import com.msg.translator.model.GlossaryEntry;
import com.msg.translator.model.NonTranslatedTerms;
import com.msg.translator.model.PmkFormula;

import java.util.ArrayList;
import java.util.List;

public class PmkService {

  private PmkDao pmkDao;

  private TranslateService translateService;

  private NonTranslatedTermsService nonTranslatedTermsService;

  public PmkService(PmkDao pmkDao) {
    this.pmkDao = pmkDao;
    this.translateService = new TranslateService();
    this.nonTranslatedTermsService = new NonTranslatedTermsService();
  }

  public void translate() {
    List<NonTranslatedTerms> nonTranslatedTermsList = new ArrayList<>();

    List<PmkFormula> formulaList = pmkDao.getAll();
    for (PmkFormula formula : formulaList) {
      String translated = translateService.translate(formula.getFormulaTextWork());
      formula.setFormulaTextWork(translated);
      pmkDao.store(formula, true);
      
      //System.out.println("ObjectID " + formula.getObjectId() + " : \n" + translated + "\n");

      List<GlossaryEntry> notTranslated = translateService.getNotTranslated();
      if (!notTranslated.isEmpty()) {
        NonTranslatedTerms nonTranslatedTerms = new NonTranslatedTerms();
        nonTranslatedTerms.setObjectId(formula.getObjectId());
        nonTranslatedTerms.setDomainId(formula.getDomainId());
        nonTranslatedTerms.setNonTranslatedTerms(notTranslated);
        
        nonTranslatedTermsList.add(nonTranslatedTerms);
      }
    }

    nonTranslatedTermsService.setList(nonTranslatedTermsList);
    nonTranslatedTermsService.marshalXMlToFile();
  }

}
