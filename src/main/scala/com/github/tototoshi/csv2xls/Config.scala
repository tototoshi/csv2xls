package com.github.tototoshi.csv2xls

import java.io.File

case class Config(in: File, out: File = new File("out.xls"), sheet: String = "sheet1", encoding: String = "UTF-8")
