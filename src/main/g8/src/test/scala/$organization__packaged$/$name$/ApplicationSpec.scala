package $organization$.$name$

import org.scalatest.{Matchers, WordSpecLike}

class ApplicationSpec extends WordSpecLike with Matchers {
  "+ operation" should {
    "work properly" when {
      "positive numbers are given" in {
        (1 + 1) should equal(2)
      }

      "negative numbers are given" in {
        (-1 + -1) should equal(-2)
      }

      "both positive and negative numbers are given" in {
        (1 + -1) should equal(0)
      }
    }
  }
}
