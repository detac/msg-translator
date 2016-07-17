package com.msg.translator.service;

import com.msg.translator.dao.GlossaryDao;
import com.msg.translator.model.EntryType;

public class GlossaryService {
	
    private GlossaryDao dao;
            
    public GlossaryService() {
        dao = new GlossaryDao();
    }
    
    public void init() {
        //iskoristis dao, te ucitas sve reci
        //kad ih ucitas, sacuvas ih u pogodnu strukturu(npr. hashmapu)
    }
    
    public String translate(EntryType type, String orginal) {
        //u gore definisanoj strukturi, pronadje odgovaraju entry typa, 
        //zatim pronadje rec, ako ima ako ne vrati null
        return null;//ili pronadjenu rec.
    }
}
