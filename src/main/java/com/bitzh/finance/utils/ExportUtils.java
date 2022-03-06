package com.bitzh.finance.utils;

import com.bitzh.finance.entity.FlowOfFunds;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExportUtils {
    /**
     * 用户导出资金记录数据
     *
     * @param list
     * @param sheetName
     */
    public static ByteArrayOutputStream exportRecord(List<FlowOfFunds> list, String sheetName) {
        //1.组装excel文档
        //1.1创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //1.2创建样式
        HSSFCellStyle baseStyle = ExportHSSFCellStyle.createBaseStyle(workbook);
        HSSFCellStyle subTitleStyle = ExportHSSFCellStyle.createSubTitleStyle(workbook);
        HSSFCellStyle tableTitleStyle = ExportHSSFCellStyle.createTableTitleStyle(workbook);
        HSSFCellStyle titleStyle = ExportHSSFCellStyle.createTitleStyle(workbook);
        //1.3在工作簿创建sheet
        HSSFSheet sheet = workbook.createSheet(sheetName);
        //1.4设置sheet
        sheet.setDefaultColumnWidth(25);
        //1.5合并
        CellRangeAddress region1 = new CellRangeAddress(0, 0, 0, 5);
        CellRangeAddress region2 = new CellRangeAddress(1, 1, 0, 5);
        sheet.addMergedRegion(region1);
        sheet.addMergedRegion(region2);
        //1.6.1创建第一行
        int index = 0;
        HSSFRow row1 = sheet.createRow(index);
        //1.6.2在第一行里面创建一个单元格
        HSSFCell row1_cell1 = row1.createCell(0);
        //1.6.3设置标题样式
        row1_cell1.setCellStyle(titleStyle);
        //1.6.4设置单元格内容
        row1_cell1.setCellValue("资金记录列表");

        //1.7.1第二行
        index++;
        HSSFRow row2 = sheet.createRow(index);
        //1.7.2在第一行里面创建一个单元格
        HSSFCell row2_cell1 = row2.createCell(0);
        //1.7.3设置标题样式
        row2_cell1.setCellStyle(subTitleStyle);
        //1.7.4设置单元格内容
        row2_cell1.setCellValue("总条数：" + list.size() + "   导出时间：" + new Date().toString());

        //1.8.1第三行
        String[] titles = {"序号", "金额", "类型", "来源", "时间", "备注"};
        index++;
        HSSFRow row3 = sheet.createRow(index);
        for (int i = 0; i < titles.length; i++) {
            HSSFCell row3_cell = row3.createCell(i);
            row3_cell.setCellStyle(tableTitleStyle);
            row3_cell.setCellValue(titles[i]);
        }

        //1.9第四行
        for (int i = 0; i < list.size(); i++) {
            index++;
            FlowOfFunds flowOfFund = list.get(i);
            HSSFRow row = sheet.createRow(index);
            //1.创建序号列
            HSSFCell row_No = row.createCell(0);
            row_No.setCellStyle(baseStyle);
            row_No.setCellValue(i + 1);
            //2.创建金额列
            HSSFCell row_money = row.createCell(1);
            row_money.setCellStyle(baseStyle);
            row_money.setCellValue(flowOfFund.getFlowmoney().toString());
            //3.创建类型列
            HSSFCell row_type = row.createCell(2);
            row_type.setCellStyle(baseStyle);
            String type = new String();
            if (flowOfFund.getType() == 1) {
                type = "支出";
            } else if (flowOfFund.getType() == 2) {
                type = "收入";
            }
            row_type.setCellValue(type);
            //4.创建来源列
            HSSFCell row_source = row.createCell(3);
            row_source.setCellStyle(baseStyle);
            row_source.setCellValue(flowOfFund.getSource());
            //5.创建时间列
            HSSFCell row_createtime = row.createCell(4);
            row_createtime.setCellStyle(baseStyle);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = sdf.format(flowOfFund.getCreatetime());
            row_createtime.setCellValue(dateString);
            //6.创建备注列
            HSSFCell row_desc = row.createCell(5);
            row_desc.setCellStyle(baseStyle);
            row_desc.setCellValue(flowOfFund.getFunddesc());
        }
        //到此excel组装完毕

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //把workbook里面的数据写到outputStream

        try {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputStream;

    }
}

