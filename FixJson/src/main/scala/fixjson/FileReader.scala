package fixjson

import java.io.File

/**
  * Created by gaurav on 10/04/17.
  */
object FileReader {

  def main(args: Array[String]): Unit = {
    println("Hello World")
    val f: File = new File("/home/gaurav/Applications/projects/PAYE/tai-stubs/conf/resources/data")
    //val f: File = new File("/home/gaurav/Applications/projects/PAYE/tai-frontend/test/data")

    getRecursiveListOfFiles(f).map(enrichJsons)
    println("done")

  }

  private def getRecursiveListOfFiles(dir: File): Array[File] = {
    val these = dir.listFiles
    these ++ these.filter(_.isDirectory).flatMap(getRecursiveListOfFiles)
  }

  private def enrichJsons(file: File): Unit = {
    if(!file.isDirectory) {
      println(file.getName)
      val fileContents = scala.io.Source.fromFile(file).mkString

      import java.io.PrintWriter
      val pw = new PrintWriter(file)
      val newJson = fileContents.replaceAll("2017", "2018").replaceAll("2016", "2017").replaceAll("2015", "2016").
        replaceAll("16-17", "17-18").replaceAll("15-16", "16-17").replaceAll("11000", "11500")
      //println(newJson)
      pw.write(newJson)
      pw.close
    }

  }

}
