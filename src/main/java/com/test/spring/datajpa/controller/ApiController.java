package com.test.spring.datajpa.controller;

import java.io.ByteArrayOutputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.spring.datajpa.model.Announcement;
import com.test.spring.datajpa.model.Symbol;
import com.test.spring.datajpa.service.DataExtractorService;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	DataExtractorService dataExtractorService;

	@GetMapping(value = "/download")
	public ResponseEntity<ByteArrayResource> downloadTemplate() throws Exception {
		try {
			List<Announcement> symbolData = extractData();
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			XSSFWorkbook workbook = createWorkBook(symbolData);
			HttpHeaders header = new HttpHeaders();
			header.setContentType(new MediaType("application", "force-download"));
			header.set(HttpHeaders.CONTENT_DISPOSITION,
					"attachment; filename=DataExtract_" + getCurrentTimeStamp() + ".xlsx");
			workbook.write(stream);
			workbook.close();
			return new ResponseEntity<>(new ByteArrayResource(stream.toByteArray()), header, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private String getCurrentTimeStamp() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_kk:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	private void createCell(Row row, int columnCount, Object value, CellStyle style, XSSFSheet sheet) {
		sheet.autoSizeColumn(columnCount);
		Cell cell = row.createCell(columnCount);
		if (value instanceof Integer) {
			cell.setCellValue((Integer) value);
		} else if (value instanceof Double) {
			cell.setCellValue((Double) value);
		} else if (value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
		} else if (value instanceof Date) {
			cell.setCellValue(getFormattedDate((Date) value));
		} else {
			cell.setCellValue((String) value);
		}
		cell.setCellStyle(style);
	}

	private String getFormattedDate(Date date) {
		ZonedDateTime zonedDateTime = date.toInstant().atZone(ZoneId.of("Australia/Sydney"));
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss a");
		return format.format(zonedDateTime);
	}

	private XSSFWorkbook createWorkBook(List<Announcement> announcements) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Data");
		createHeaderRow(workbook, sheet);
		writeDatalines(workbook, sheet, announcements);
		return workbook;
	}

	private void createHeaderRow(XSSFWorkbook workbook, XSSFSheet sheet) {
		Row row = sheet.createRow(0);
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);
		createCell(row, 0, "Display Symbol", style, sheet);
		createCell(row, 1, "Symbol", style, sheet);
		createCell(row, 2, "Headline", style, sheet);
		createCell(row, 3, "Date", style, sheet);
		createCell(row, 4, "Price Ask", style, sheet);
		createCell(row, 5, "Price Bid", style, sheet);
		createCell(row, 6, "Price Last", style, sheet);
		createCell(row, 7, "Price Change", style, sheet);
		createCell(row, 8, "Market Capital", style, sheet);
	}

	private void writeDatalines(XSSFWorkbook workbook, XSSFSheet sheet, List<Announcement> announcements) {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Announcement announcement : announcements) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, announcement.getSymbol(), style, sheet);
			createCell(row, columnCount++, announcement.getCompanyInfo().get(0).getSymbol(), style, sheet);
			createCell(row, columnCount++, announcement.getHeadline(), style, sheet);
			createCell(row, columnCount++, announcement.getDate(), style, sheet);
			createCell(row, columnCount++, announcement.getSymbolData().getPriceAsk(), style, sheet);
			createCell(row, columnCount++, announcement.getSymbolData().getPriceBid(), style, sheet);
			createCell(row, columnCount++, announcement.getSymbolData().getPriceLast(), style, sheet);
			createCell(row, columnCount++, announcement.getSymbolData().getPriceChange(), style, sheet);
			createCell(row, columnCount++, announcement.getSymbolData().getMarketCap(), style, sheet);

		}

	}

	private List<Announcement> extractData() {
		List<Announcement> announcements = dataExtractorService.getAnnouncements();
		announcements.forEach(announcement -> {
			Symbol symbol = dataExtractorService.getSymbolData(announcement);
			announcement.setSymbolData(symbol);
		});
		return announcements;
	}

}
