package com.msg.translator.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.msg.translator.model.GlossaryEntry;

public class GlossaryDaoTest {
	
	@Test
	public void loadGlossary() {
		GlossaryDao glossaryDao = new GlossaryDao();
		List<GlossaryEntry> result = glossaryDao.loadGlossary();
		assertEquals(37, result.size());
	}
}
