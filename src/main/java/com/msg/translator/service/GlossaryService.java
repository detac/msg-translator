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

    for (EntryType entryType : EntryType.values()) {
      HashMap<String, String> geMap = new HashMap<>();
      
      List<GlossaryEntry> removeFromList = new ArrayList<>();
      for (GlossaryEntry glossaryEntry : list) {
        if (glossaryEntry.getType() == entryType) {
          geMap.put(glossaryEntry.getOriginal(), glossaryEntry.getTranslated());
          removeFromList.add(glossaryEntry);
        }
      }
      
      list.removeAll(removeFromList);
      
      map.put(entryType, geMap);
    }
  }

  public String translate(EntryType type, String orginal) {
    return map.get(type).get(orginal);
  }
}
