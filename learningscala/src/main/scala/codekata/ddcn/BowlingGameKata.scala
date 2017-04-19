package codekata.ddcn

import scala.annotation.tailrec

object BowlingGameKata {

  def calculateScore(scores: List[Int]): Int = {
    //scores.reduceLeft(_ + _)

    @tailrec
    def accumulate(scoresList: List[Int], isSpare:Boolean, accumulator: Int): Int = {
      scoresList match {
        case Nil => accumulator
        case bowl :: Nil => bowl + accumulator
        case bowl :: secondBowl :: tail =>
          val sum = accumulator + (if(isSpare) bowl * 2 else bowl) + secondBowl
          accumulate(tail, (bowl+secondBowl) == 10, sum)
      }
    }

    accumulate(scores, false, 0)
  }

}
