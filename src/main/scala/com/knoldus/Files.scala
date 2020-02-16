package com.knoldus

import java.io.File

trait Files {
  def getListOfFiles: List[File]

  def getFileNameAndContent(files: List[File]): List[(String, String)]

  def capitalizeFileContent(files: List[(String, String)]): List[(String, String)]

  def writeFilesFromNameAndContent(files: List[(String, String)], dir: String): Int

  def getUniqueWordWithCountFromFiles(files: List[(String, String)]): List[(String, String)]
}
