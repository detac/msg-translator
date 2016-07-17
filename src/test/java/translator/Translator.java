package translator;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.msg.translator.dao.DatabaseConnection;
import com.msg.translator.dao.DatabaseConnectionSQLite;
import com.msg.translator.dao.GlossaryDao;
import com.msg.translator.model.GlossaryEntry;
import com.msg.translator.model.NonTranslatedTerms;
import com.msg.translator.service.NonTranslatedTermsService;

public class Translator {

	@Test
	public void loadGlossary() {
		GlossaryDao glossaryDao = new GlossaryDao();
		List<GlossaryEntry> result = glossaryDao.loadGlossary();
		assertEquals(46, result.size());
	}

	@Test
	public void databaseConnectionSQLite() {
		DatabaseConnection databaseConnection = new DatabaseConnectionSQLite();
		assertTrue(databaseConnection.isConnected());
		assertTrue(databaseConnection.close());
	}

	@Test
	public void marshalXMlToFile() {
		NonTranslatedTerms nonTranslatedTermsA = new NonTranslatedTerms();
		nonTranslatedTermsA.setObjectId("A");
		nonTranslatedTermsA.setDomainId("A");
		List<String> listA = new ArrayList<>();
		listA.add("A");
		listA.add("AA");
		listA.add("AAA");
		nonTranslatedTermsA.setNonTranslatedTerms(listA);

		NonTranslatedTerms nonTranslatedTermsB = new NonTranslatedTerms();
		nonTranslatedTermsB.setObjectId("B");
		nonTranslatedTermsB.setDomainId("B");
		List<String> listB = new ArrayList<>();
		listB.add("B");
		listB.add("BB");
		listB.add("BBB");
		nonTranslatedTermsB.setNonTranslatedTerms(listB);

		NonTranslatedTermsService nonTranslatedTermsService = new NonTranslatedTermsService();
		List<NonTranslatedTerms> list = new ArrayList<>();
		list.add(nonTranslatedTermsA);
		list.add(nonTranslatedTermsB);
		nonTranslatedTermsService.setList(list);
		
		nonTranslatedTermsService.marshalXMlToFile();
	}

}
