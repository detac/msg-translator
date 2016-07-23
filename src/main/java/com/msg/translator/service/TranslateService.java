package com.msg.translator.service;

import com.msg.translator.model.EntryType;
import com.msg.translator.model.GlossaryEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TranslateService {

	private GlossaryService glossaryService;

	List<GlossaryEntry> notTranslated;

	public TranslateService(GlossaryService glossaryService) {
		this.glossaryService = glossaryService;
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
				String orginal = extractTranslatableTerm(line);
				String translated = glossaryService.translate(orginal);
				if (translated == null) {
					GlossaryEntry glossaryEntry = new GlossaryEntry(entryType, orginal);
					notTranslated.add(glossaryEntry);
				} else {
					translatedFormula = translatedFormula.replaceAll(orginal, translated);
				}
			}
		}
		scanner.close();
		return translatedFormula;
	}

	public String extractTranslatableTerm(String line) {
		String[] splitLine = line.split("\\s+");
		return splitLine[splitLine.length - 1];
	}

	public List<GlossaryEntry> getNotTranslated() {
		return notTranslated;
	}
}
