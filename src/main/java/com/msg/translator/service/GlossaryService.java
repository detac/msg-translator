package com.msg.translator.service;

import com.msg.translator.dao.GlossaryDao;
import com.msg.translator.model.EntryType;
import com.msg.translator.model.GlossaryEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GlossaryService {

  private GlossaryDao glossaryDao;

  private HashMap<EntryType, HashMap<String, String>> map;

  public GlossaryService() {
    glossaryDao = new GlossaryDao();
  }

  public void init() {
    map = new HashMap<>();
    List<GlossaryEntry> list = glossaryDao.loadGlossary();

    for (EntryType et : EntryType.values()) {
      HashMap<String, String> geMap = new HashMap<>();
      
      List<GlossaryEntry> removeFromList = new ArrayList<>();
      for (GlossaryEntry ge : list) {
        if (ge.getType() == et) {
          geMap.put(ge.getOriginal(), ge.getTranslated());
          removeFromList.add(ge);
        }
      }
      
      list.removeAll(removeFromList);
      
      map.put(et, geMap);
    }
  }

  public String translate(EntryType type, String orginal) {
    return map.get(type).get(orginal);
  }
}
