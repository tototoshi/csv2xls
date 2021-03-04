package com.github.tototoshi.csv2xls

import com.github.tototoshi.csv.CSVReader
import org.apache.poi.hssf.usermodel.HSSFWorkbook

import java.io.FileOutputStream
import scala.util.Using

object Converter {

  def run(config: Config): Unit = {
    Using.resource(new HSSFWorkbook()) { wb =>
      wb.getFontAt(0).setFontName("MS P ゴシック")

      val s1 = wb.createSheet(config.sheet)

      Using.resource(CSVReader.open(config.in, config.encoding)) { reader =>
        val rowValues = reader.all

        for {
          (cellValues, i) <- rowValues.zipWithIndex
          row = s1.createRow(i)
          (cellValue, j) <- cellValues.zipWithIndex
          cell = row.createCell(j)
        } {
          cell.setCellValue(cellValues(j))
        }

        Using.resource(new FileOutputStream(config.out)) {
          fos => wb.write(fos)
        }
      }
    }
  }

}
