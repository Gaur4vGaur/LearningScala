package codekata.ddcn

import scala.annotation.tailrec

object BowlingGameKata {

  def calculateScore(scores: List[Int]): Int = {
    //scores.reduceLeft(_ + _)

    @tailrec
    def accumulate(scoresList: List[Int], isSpare:Boolean = false,
                   isStrike: Boolean = false, wasContinuous: Boolean = false, accumulator: Int = 0): Int = {

      val calcBowl = (bowl: Int) => if(isSpare || isStrike) bowl * 2 else bowl
      val calcSecondBowl = (secondBowl: Int) => if(isStrike) secondBowl * 2 else secondBowl

      scoresList match {
        case Nil => accumulator

        case bowl :: Nil => bowl + accumulator

        case bowl :: secondBowl :: tail if(bowl == 10) =>
          val sum = accumulator + calcBowl(bowl) + (if(wasContinuous) secondBowl else 0)
          accumulate(secondBowl :: tail, isStrike = true, wasContinuous = (secondBowl == 10), accumulator = sum)

        case bowl :: secondBowl :: tail =>
          val sum = accumulator + calcBowl(bowl) + calcSecondBowl(secondBowl)
          accumulate(tail, (bowl+secondBowl) == 10, accumulator = sum)
      }
    }

    accumulate(scores, false, false, false, 0)
  }

}
