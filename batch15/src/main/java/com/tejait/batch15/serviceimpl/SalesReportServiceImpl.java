package com.tejait.batch15.serviceimpl;

import com.tejait.batch15.model.SalesReport;
import com.tejait.batch15.repository.SalesReportRepository;
import com.tejait.batch15.service.SalesReportService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class SalesReportServiceImpl implements SalesReportService {

    private final SalesReportRepository repository;

    @Transactional
    @Override
    public void uploadExcel(Integer appId, MultipartFile file) {

        List<SalesReport> list = new ArrayList<>();

        try {

            InputStream is = file.getInputStream();
            Workbook workbook = WorkbookFactory.create(is);
            Sheet sheet = workbook.getSheetAt(0);

            DataFormatter formatter = new DataFormatter();

            // Excel data starts from row 7
            for (int i = 6; i <= sheet.getLastRowNum(); i++) {

                Row row = sheet.getRow(i);
                if (row == null) continue;

                String dateVal = formatter.formatCellValue(row.getCell(0)).trim();
                if (dateVal.isEmpty()) continue;

                SalesReport s = new SalesReport();
                s.setAppId(appId);

                s.setDate(dateVal);
                s.setOrderno(formatter.formatCellValue(row.getCell(1)));
                s.setInvoiceno(formatter.formatCellValue(row.getCell(2)));
                s.setPartyName(formatter.formatCellValue(row.getCell(3)));
                s.setPartyPhoneNum(formatter.formatCellValue(row.getCell(5)));

                s.setTotalAmount(parseSafeDouble(row.getCell(7)));
                s.setRecievedOrPaidAmount(parseSafeDouble(row.getCell(9)));
                s.setBalanceAmount(parseSafeDouble(row.getCell(11)));

                list.add(s);
            }

            repository.saveAll(list);

            log.info("Successfully saved {} records for appId {}", list.size(), appId);

        } catch (Exception e) {

            log.error("Excel processing failed", e);

            throw new RuntimeException("Error processing Excel file", e);
        }
    }

    private Double parseSafeDouble(Cell cell) {

        if (cell == null) return 0.0;

        try {

            if (cell.getCellType() == CellType.NUMERIC ||
                    cell.getCellType() == CellType.FORMULA) {

                return cell.getNumericCellValue();
            }

            String val = new DataFormatter()
                    .formatCellValue(cell)
                    .replaceAll("[^0-9.]", "");

            return val.isEmpty() ? 0.0 : Double.parseDouble(val);

        } catch (Exception e) {

            return 0.0;
        }
    }

    @Override
    public void saveAll(Integer appId, List<SalesReport> list) {

        if (list == null) return;

        list.forEach(d -> d.setAppId(appId));

        repository.saveAll(list);
    }

    @Override
    public List<SalesReport> getAllByAppId(Integer appId) {

        return repository.findAllByAppId(appId);
    }
}