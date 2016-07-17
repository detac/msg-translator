package com.msg.translator.service;

import com.msg.translator.dao.PmkDao;
import com.msg.translator.model.PmkFormula;
import java.util.List;

public class PmkService {
    private PmkDao dao;
    private TranslateService tranService;
    public PmkService() {
        dao = new PmkDao();
        tranService = new TranslateService();
    }
    
    public void translate() {
        List<PmkFormula> formulaList = dao.getAll();
        for(PmkFormula formula : formulaList) {
            String translated = tranService.translate(formula.getFormulaTextWork());
            formula.setFormulaTextWork(translated);
            dao.store(formula);
        }
    }
    
}
