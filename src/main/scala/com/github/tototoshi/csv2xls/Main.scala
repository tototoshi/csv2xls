package com.github.tototoshi.csv2xls

import java.io.{ File, FileOutputStream }
import com.github.tototoshi.csv.CSVReader
import com.github.tototoshi.csv2xls.buildinfo.BuildInfo
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import scopt.OptionParser

case class Config(in: File, out: File = new File("out.xls"), sheet: String = "sheet1", encoding: String = "UTF-8")

object Main {

  val parser = new OptionParser[Config]("csv2xls") {
    head(BuildInfo.name, BuildInfo.version)
    version('v', "version").text("Print the version")
    help('h', "help").text("Print a help")
    opt[File]('o', "out") action { (out, c) => c.copy(out = out) } text "Specify an output file"
    opt[String]('s', "sheet") action { (sheet, c) => c.copy(sheet = sheet) } text "Specify the sheet name"
    opt[String]('e', "encoding") action { (encoding, c) => c.copy(encoding = encoding) } text "Specify the encoding of csv file (default: utf-8)"
    arg[File]("<file>") action { (in, c) => c.copy(in = in) } text "Specify an input file"
  }

  def main(args: Array[String]): Unit = {
    parser.parse(args, Config(null)) match {
      case Some(config) =>
        val wb = new HSSFWorkbook()

        wb.getFontAt(0).setFontName("MS P ゴシック")

        val s1 = wb.createSheet(config.sheet)

        val reader = CSVReader.open(config.in, config.encoding)

        val rowValues = reader.all

        for {
          (cellValues, i) <- rowValues.zipWithIndex
          row = s1.createRow(i)
          (cellValue, j) <- cellValues.zipWithIndex
          cell = row.createCell(j)
        } {
          cell.setCellValue(cellValues(j))
        }

        val fos = new FileOutputStream(config.out)
        wb.write(fos)

        reader.close()
        fos.close()
      case None =>
        sys.exit(1)
    }

  }
}
