package translator;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.msg.translator.dao.DatabaseConnection;
import com.msg.translator.dao.DatabaseConnectionSQLite;
import com.msg.translator.dao.GlossaryDao;
import com.msg.translator.dao.PmkDao;
import com.msg.translator.model.EntryType;
import com.msg.translator.model.GlossaryEntry;
import com.msg.translator.model.NonTranslatedTerms;
import com.msg.translator.model.PmkFormula;
import com.msg.translator.service.GlossaryService;
import com.msg.translator.service.NonTranslatedTermsService;

public class Translator {

  @Test
  public void loadGlossary() {
    GlossaryDao glossaryDao = new GlossaryDao();
    List<GlossaryEntry> result = glossaryDao.loadGlossary();
    assertEquals(47, result.size());
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

  @Test
  public void databaseConnectionSQLite() {
    DatabaseConnection databaseConnection = new DatabaseConnectionSQLite();
    assertTrue(databaseConnection.isConnected());
    assertTrue(databaseConnection.close());
  }

  @Test
  public void getAll() {
    DatabaseConnection databaseConnection = new DatabaseConnectionSQLite();
    if (databaseConnection.isConnected()) {
      PmkDao pmkDao = new PmkDao(databaseConnection);
      List<PmkFormula> result = pmkDao.getAll();
      databaseConnection.close();
      assertTrue(result.size() == 3);
    }
  }

  @Test
  public void store() {
    DatabaseConnection databaseConnection = new DatabaseConnectionSQLite();
    if (databaseConnection.isConnected()) {
      PmkDao pmkDao = new PmkDao(databaseConnection);

      PmkFormula pmkFormula = new PmkFormula();
      pmkFormula.setObjectId("test1");
      pmkFormula.setDomainId("test2");
      pmkFormula.setFormulaTextWork("updated value");

      int result = pmkDao.store(pmkFormula, true);

      databaseConnection.close();
      assertTrue(result == 1);
    }
  }

  @Test
  public void translate() {
    GlossaryService glossaryService = new GlossaryService();
    glossaryService.init();
    String actual = "";

    actual = glossaryService.translate(EntryType.PATHS, "zzzxxxccc");
    assertNull(actual);
    
    actual = glossaryService.translate(EntryType.PATHS, "pathBtr");
    assertEquals("pathPrem", actual);
    
    actual = glossaryService.translate(EntryType.EXTERNAL_OBJECTS, "extVObj");
    assertEquals("extInsObj", actual);
    
    actual = glossaryService.translate(EntryType.OBJECT_ATTRIBUTES, "Beginn");
    assertEquals("Begin", actual);
    
    actual = glossaryService.translate(EntryType.METHODS, "vtm_Initialisieren");
    assertEquals("vtm_Initialize", actual);
    
    actual = glossaryService.translate(EntryType.LOCAL_OBJECTS, "objBtr");
    assertEquals("objPrem", actual);
    
    actual = glossaryService.translate(EntryType.LOCAL_VARIABLES, "li_BeitragManuellKnz");
    assertEquals("li_FlagManualRating", actual);
    
    actual = glossaryService.translate(EntryType.GLOBAL_VARIABLES, "bCheckZuNaGueltig");
    assertEquals("bCheckDiSuValid", actual);
    
    actual = glossaryService.translate(EntryType.CONSTANTS, "LP_ZUNATYP_PRAEMAENDZURFAELLIGK");
    assertEquals("LP_DISUTYPE_PREMIUMCHANGEATDUEDATE", actual);
  }

}
