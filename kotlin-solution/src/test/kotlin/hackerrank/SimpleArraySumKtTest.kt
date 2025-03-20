package hackerrank

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

open class SimpleArraySumKtTest : StringSpec({

    "should return sum of array elements" {
        simpleArraySum(arrayOf(1, 2, 3, 4, 5)) shouldBe 15
        simpleArraySum(arrayOf(10, 20, 30, 40)) shouldBe 100
        simpleArraySum(arrayOf(-1, -2, -3, -4)) shouldBe -10
        simpleArraySum(arrayOf(0, 0, 0, 0)) shouldBe 0
        simpleArraySum(emptyArray()) shouldBe 0 // 빈 배열
    }
})
