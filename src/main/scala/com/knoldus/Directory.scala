package com.knoldus

import java.io.{File, PrintWriter}

import scala.io.Source


class Directory extends Files {

  val getInputSourceDataPath = "src/main/resources/inputDir"
  val getOutputDataPath = "src/main/resources/"

  override def getListOfFiles: List[File] = {
    val d = new File(getInputSourceDataPath)
    if (d.exists && d.isDirectory) {
      d.listFiles.toList
    } else {
      List[File]()
    }
  }

  override def getFileNameAndContent(files: List[File]): List[(String, String)] = {
    for (file <- files if file.isFile) yield (file.getName, Source.fromFile(file).mkString)
  }

  override def capitalizeFileContent(files: List[(String, String)]): List[(String, String)] = {
    files.map { file => (file._1, file._2.toUpperCase)
    }
  }

  override def writeFilesFromNameAndContent(files: List[(String, String)], dir: String): Int = {
    files.foreach { file =>
      val writer = new PrintWriter(new File(getOutputDataPath + dir + "/" + file._1))
      writer.write(file._2)
      writer.close()
    }
    1
  }

  override def getUniqueWordWithCountFromFiles(files: List[(String, String)]): List[(String, String)] = {
    files.map { file =>
      (file._1,
        Source.fromFile(getInputSourceDataPath + "/" + file._1)
          .getLines
          .flatMap(_.split("\\W+"))
          .foldLeft(Map.empty[String, Int]) {
            (count, word) => count + (word.toLowerCase -> (count.getOrElse(word.toLowerCase, 0) + 1))
          }.toString().substring(8).reverse.substring(1).reverse.replace(", ", "\n"))
    }
  }
}