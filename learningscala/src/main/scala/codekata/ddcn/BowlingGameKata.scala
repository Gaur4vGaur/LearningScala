package codekata.ddcn

import scala.annotation.tailrec

object BowlingGameKata {

  def calculateScore(scores: List[Int]): Int = {
    //scores.reduceLeft(_ + _)

    @tailrec
    def accumulate(scoresList: List[Int], accumulator: Int): Int = {
      scoresList match {
        case Nil => accumulator
        case bowl :: Nil => bowl + accumulator
        case bowl :: secondBowl :: tail => println(tail); accumulate(tail, (accumulator + bowl + secondBowl))
      }
    }

    accumulate(scores, 0)
  }

}
