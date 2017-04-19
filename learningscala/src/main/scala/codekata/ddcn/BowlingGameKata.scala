package codekata.ddcn

import scala.annotation.tailrec

object BowlingGameKata {

  def calculateScore(scores: List[Int]): Int = {
    //scores.reduceLeft(_ + _)

    @tailrec
    def accumulate(scoresList: List[Int], isSpare:Boolean = false,
                   isStrike: Boolean = false, accumulator: Int = 0): Int = {
      scoresList match {
        case Nil => accumulator
        case bowl :: Nil => bowl + accumulator
        case bowl :: tail if(bowl == 10) => accumulate(tail, isStrike = true, accumulator = (accumulator + bowl))
        case bowl :: secondBowl :: tail =>
          val sum = accumulator + (if(isSpare || isStrike) bowl * 2 else bowl) + (if(isStrike) secondBowl * 2 else secondBowl)
          accumulate(tail, (bowl+secondBowl) == 10, accumulator = sum)
      }
    }

    accumulate(scores, false, false, 0)
  }

}
