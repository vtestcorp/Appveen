package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class DataReader {
		private static XSSFSheet ExcelWSheet;
		private static XSSFWorkbook ExcelWBook;
		private static XSSFCell Cell;
		private static XSSFRow Row;
		public static DataFormatter formatter = new DataFormatter();
		static Object Data[][];

		public static Object[][] readExcelFile(String filepath, String sheetIndexNumber) {

			try {

				String basepath = System.getProperty("user.dir");
				File file = new File(basepath +filepath );
				System.out.println(file);
				FileInputStream fs = new FileInputStream(file);
				ExcelWBook = new XSSFWorkbook(fs);
				String sheetName=(ExcelWBook.getSheetName(Integer.parseInt(sheetIndexNumber)));
				ExcelWSheet = ExcelWBook.getSheet(sheetName);
				System.out.println(ExcelWSheet.getLastRowNum());
				int rowcount = ExcelWSheet.getPhysicalNumberOfRows();
				Row = ExcelWSheet.getRow(0);
				Data = new Object[rowcount][Row.getLastCellNum()];
				System.out.println(rowcount);

				for (int i = 0; i < rowcount; i++) {
					Row = ExcelWSheet.getRow(i);
					for (int j = 0; j < Row.getLastCellNum(); j++) {
						if (Row == null)
							Data[i][j] = "";
						else {
							Cell = Row.getCell(j);
							if (Cell == null)
								Data[i][j] = ""; // if it get Null value it pass no data
							else {
								String value = formatter.formatCellValue(Cell);
								Data[i][j] = value; // This formatter get my all values as string i.e integer, float all
													// type data value
							}
						}
					}
				}
			} catch (FileNotFoundException e) {
				System.out.println("Unable to find the file");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Data;
		}
		@SuppressWarnings("unused")
		public JSONObject readJSONFile(String filepath) {
			
			JsonParser parser=new JsonParser();
			Object jObject=null;
			try {
				jObject=parser.parse(new FileReader(filepath));
			} catch (JsonIOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonSyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JSONObject jsonObject=(JSONObject)jObject;
			return null;
			
		}
	}
