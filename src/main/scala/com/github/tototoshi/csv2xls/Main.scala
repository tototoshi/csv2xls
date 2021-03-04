package com.github.tototoshi.csv2xls

import com.github.tototoshi.csv2xls.buildinfo.BuildInfo
import scopt.OptionParser

import java.io.File

object Main {

  private val parser = new OptionParser[Config]("csv2xls") {
    head(BuildInfo.name, BuildInfo.version)
    version('v', "version").text("Print the version")
    help('h', "help").text("Print a help")
    opt[File]('o', "out").action { (out, c) => c.copy(out = out) }.text("Specify an output file")
    opt[String]('s', "sheet").action { (sheet, c) => c.copy(sheet = sheet) }.text("Specify the sheet name")
    opt[String]('e', "encoding").action { (encoding, c) => c.copy(encoding = encoding) }.text("Specify the encoding of csv file (default: utf-8)")
    arg[File]("<file>").action { (in, c) => c.copy(in = in) }.text("Specify an input file")
  }

  def main(args: Array[String]): Unit = {
    parser.parse(args, Config(null)) match {
      case Some(config) => Converter.run(config)
      case None => sys.exit(1)
    }
  }
}
