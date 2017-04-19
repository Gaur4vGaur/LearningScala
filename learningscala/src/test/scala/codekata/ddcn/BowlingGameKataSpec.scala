package codekata.ddcn

import org.scalatest.{FlatSpec, Matchers}
import BowlingGameKata._

class BowlingGameKataSpec extends FlatSpec with Matchers {

  "Bowling Game Scorer" should "add scores of 2 balls" in {
    calculateScore(Array(1,4)) shouldBe 5
  }

  it should "add scores of 3 balls" in {
    calculateScore(Array(1,4,4)) shouldBe 9
  }

}
