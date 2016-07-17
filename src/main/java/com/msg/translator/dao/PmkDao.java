package com.msg.translator.dao;

import com.msg.translator.model.PmkFormula;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class PmkDao {
    private static final String DB_LINK = "jdbc link do baze";
    private static final String LIST_ALL_SQL = "SELECT ...";//TODO: selekt, koji dohvata sve iz baze..
    private static final String STORE_SQL = "SELECT ...";//TODO: update ili insert, mozda najbolje da pitas onoga ko ti je poslao zadatak.
    
    private Connection getDB() {
        //TODO: napravi konekciju ka bazi, i vrati je u return-u;
        return null;
    }
    
    public List<PmkFormula> getAll() {
        List<PmkFormula> result = new ArrayList<>();
        //TODO:
        //Uzmes konekciju, vratis result set;
        //iteriras kroz rezult set, i za svaki red u result pravi novi objekat PmkFormula;
        //popunjavas potrebna polja, i dodajes u kolekciju;
        return result;
    }
    
    public int store(PmkFormula formula) {
        //uzmes konekciju
        //napravis prepared statement, odradis update/insert(sta vec treba).
        return 0;//todo vratis broj insertovanih, ili update-ovanih redova;
    }
}
