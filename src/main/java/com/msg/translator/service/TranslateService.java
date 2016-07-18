package com.msg.translator.service;

import com.msg.translator.model.EntryType;
import com.msg.translator.model.GlossaryEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TranslateService {

  private GlossaryService glossaryService;

  List<GlossaryEntry> notTranslated;

  public TranslateService() {
    this.glossaryService = new GlossaryService();
    this.glossaryService.init();
  }

  public String translate(String formula) {
    notTranslated = new ArrayList<>();
    String translatedFormula = new String(formula);

    Scanner scanner = new Scanner(formula);
    
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine().trim(); 
      EntryType entryType = EntryType.getEntryType(line);
      if (entryType != null) {
        
        String[] splitLine = line.split("\\s+");
        String orginal = splitLine[splitLine.length - 1];
        
        String translated = glossaryService.translate(entryType, orginal);
        if (translated == null) {
          GlossaryEntry glossaryEntry = new GlossaryEntry(entryType, orginal);
          notTranslated.add(glossaryEntry);
          System.out.println(glossaryEntry);
        } else {
          translatedFormula = translatedFormula.replaceAll(orginal, translated);
        }
        
      }

    }
    
    scanner.close();
    return translatedFormula;
  }

  public List<GlossaryEntry> getNotTranslated() {
    return notTranslated;
  }
}
