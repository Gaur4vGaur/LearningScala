package codekata.ddcn

object BowlingGameKata {

  def calculateScore(scores: Array[Int]): Int = {
    scores.reduceLeft(_ + _)
  }

}
