package com.msg.translator.service;

import com.msg.translator.dao.PmkDao;
import com.msg.translator.model.PmkFormula;
import java.util.List;

public class PmkService {
    
	private PmkDao pmkDao;
    private TranslateService translateService;
    
    public PmkService(PmkDao pmkDao, TranslateService translateService) {
    	this.pmkDao = pmkDao;
    	this.translateService = translateService;
    }
    
    public void translate() {
        List<PmkFormula> formulaList = pmkDao.getAll();
        for(PmkFormula formula : formulaList) {
            String translated = translateService.translate(formula.getFormulaTextWork());
            formula.setFormulaTextWork(translated);
            pmkDao.store(formula);
        }
    }
    
}
