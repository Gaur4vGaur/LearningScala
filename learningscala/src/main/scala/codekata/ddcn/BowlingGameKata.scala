package codekata.ddcn

import scala.annotation.tailrec

object BowlingGameKata {

  def addFrame(frame: (Int, Int)): Int = frame._1 + frame._2

  def calculateScore(gameStats: List[(Int, Int)]): Int = {

    @tailrec
    def scoreMe(gameStats: List[(Int, Int)], accumulativeTotal: Int): Int = {
      gameStats match {
        case Nil => accumulativeTotal
        case (head :: tail) => scoreMe(tail, accumulativeTotal + addFrame(head))
      }
    }

    scoreMe(gameStats, 0)
  }

}
