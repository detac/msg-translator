package com.msg.translator.service;

import java.util.HashMap;
import java.util.List;

import com.msg.translator.dao.GlossaryDao;
import com.msg.translator.model.GlossaryEntry;

public class GlossaryService {

	private GlossaryDao glossaryDao;

	private HashMap<String, String> map;

	public GlossaryService(GlossaryDao glossaryDao) {
		this.glossaryDao = glossaryDao;
	}

	public void init() {
		List<GlossaryEntry> glossaryEntries = glossaryDao.loadGlossary();

		map = new HashMap<>();
		for (GlossaryEntry glossaryEntry : glossaryEntries) {
			map.put(glossaryEntry.getOriginal(), glossaryEntry.getTranslated());
		}
	}

	public String translate(String orginal) {
		return map.get(orginal);
	}
}
