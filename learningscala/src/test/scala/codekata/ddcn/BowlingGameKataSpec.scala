package codekata.ddcn

import org.scalatest.{FlatSpec, Matchers}
import BowlingGameKata._

class BowlingGameKataSpec extends FlatSpec with Matchers {

  "Bowling Game Scorer" should "return the total of two balls when given one frame " in {
    addFrame(1, 4) shouldBe 5
  }



}