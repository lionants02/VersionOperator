/*
 * MIT License
 *
 * Copyright (c) 2019 Max Thanachai Thongkum
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 *
 */

package soulbit.version.operator

import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.`should equal`
import org.junit.Test

class UtilTest {

    @Test
    fun `utilVersionBlock$StringVersionOperator`() {
        val test = utilVersionBlock("10.2.3", '.')

        test[0] `should be equal to` "10"
        test[1] `should be equal to` "2"
        test[2] `should be equal to` "3"
    }

    @Test
    fun cutString() {
        val test = utilVersionBlock("10.2a.3", '.')
        val testEqual = arrayListOf<String>("10", "2")

        test `should equal` testEqual
    }

    @Test
    fun cutString2() {
        val test = utilVersionBlock("5.0.1communityMy", '.')
        val testEqual = arrayListOf<String>("5", "0", "1")

        test `should equal` testEqual
    }
}
