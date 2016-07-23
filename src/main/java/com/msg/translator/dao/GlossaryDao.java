package com.msg.translator.dao;

import com.msg.translator.model.EntryType;
import com.msg.translator.model.GlossaryEntry;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GlossaryDao {

	public List<GlossaryEntry> loadGlossary() {
		List<GlossaryEntry> result = new ArrayList<>();

		File file = new File("src//main//resources//Translation-Glossary.xlsx");

		try (FileInputStream fis = new FileInputStream(file); XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
			for (int sheetIndex = 0; sheetIndex <= 5; sheetIndex++) {
				XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
				for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {

					Row row = sheet.getRow(rowIndex);
					if (row == null) {
						break;
					}

					if (row.getCell(0) == null || row.getCell(1) == null) {
						break;
					}

					// System.out.println(sheetIndex + "." + rowIndex);

					GlossaryEntry ge = new GlossaryEntry();
					ge.setType(EntryType.getEntryType(sheetIndex));
					ge.setOriginal(row.getCell(0).getStringCellValue());
					ge.setTranslated(row.getCell(1).getStringCellValue());

					result.add(ge);
				}
			}
		} catch (Exception ex) {
			System.out.println("GlossaryDao : " + ex);
		}

		return result;
	}

}
