package com.knoldus

import java.io.File

object ETL {

  val source = new Directory

  val inputFiles = source.getListOfFiles

  val fileContent = source.getFileNameAndContent(inputFiles)

  val partOneETL: Boolean = {

    try {
      val capitalizedFileContent = source.capitalizeFileContent(fileContent)
      val output = "capitalizedFileContent"
      if (source.writeFilesFromNameAndContent(capitalizedFileContent, output) == 1) true else false
    } catch {
      case e: Exception => false
    }
  }
  val partTwoETL: Boolean = {
    try {
      val uniqueWordCount = source.getUniqueWordWithCountFromFiles(fileContent)
      val output = "uniqueWordCount"
      if (source.writeFilesFromNameAndContent(uniqueWordCount, output) == 1) true else false
    } catch {
      case e: Exception => false
    }
  }
}
