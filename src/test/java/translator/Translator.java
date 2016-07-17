package translator;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.msg.translator.dao.GlossaryDao;
import com.msg.translator.model.GlossaryEntry;

public class Translator {

	@Test
	public void loadGlossary() {
		GlossaryDao glossaryDao = new GlossaryDao();
		List<GlossaryEntry> result = glossaryDao.loadGlossary();
		assertEquals(46, result.size());
	}

}
