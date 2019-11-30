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
import org.junit.Test

class VersionOperatorTest {

    val mainVersion = VersionOperator("9.2")

    @Test
    fun compareEqual() {
        val testVersion = "9.2.0".VersionOp()

        (mainVersion < testVersion) `should be equal to` false
        (mainVersion > testVersion) `should be equal to` false
        (mainVersion == testVersion) `should be equal to` true
    }

    @Test
    fun compareEqual2() {
        val testVersion = VersionOperator("9.2.0.0.0.0")

        (mainVersion < testVersion) `should be equal to` false
        (mainVersion > testVersion) `should be equal to` false
        (mainVersion == testVersion) `should be equal to` true
    }

    @Test
    fun compareEqual3() {
        val testVersion = VersionOperator("9.2-devMainVersion")

        (mainVersion < testVersion) `should be equal to` false
        (mainVersion > testVersion) `should be equal to` false
        (mainVersion == testVersion) `should be equal to` true
    }

    @Test
    fun instantEqual() {
        (mainVersion == mainVersion) `should be equal to` true
    }

    @Test
    fun `Main version is less than minor version`() {
        val minor = VersionOperator("10")

        (mainVersion < minor) `should be equal to` true
        (mainVersion > minor) `should be equal to` false
        (mainVersion == minor) `should be equal to` false
    }

    @Test
    fun `Main version is less than minor version 2`() {
        val minor = VersionOperator("9.2.1.1.1.1")

        (mainVersion < minor) `should be equal to` true
        (mainVersion > minor) `should be equal to` false
        (mainVersion == minor) `should be equal to` false
    }

    @Test
    fun `Main version is less than minor version 3`() {
        val minor = "9.2.1a-Test-dev".VersionOp()

        (mainVersion < minor) `should be equal to` true
        (mainVersion > minor) `should be equal to` false
        (mainVersion == minor) `should be equal to` false
    }

    @Test
    fun `Main version rather than minor version`() {
        val minor = VersionOperator("9.1.9")

        (mainVersion < minor) `should be equal to` false
        (mainVersion > minor) `should be equal to` true
        (mainVersion == minor) `should be equal to` false
    }

    @Test
    fun `Main version rather than minor version 2`() {
        val minor = "1".VersionOp()

        (mainVersion < minor) `should be equal to` false
        (mainVersion > minor) `should be equal to` true
        (mainVersion == minor) `should be equal to` false
    }

    @Test
    fun `Main version rather than minor version 3`() {
        val minor = "1.0FirstVersion".VersionOp()

        (mainVersion < minor) `should be equal to` false
        (mainVersion > minor) `should be equal to` true
        (mainVersion == minor) `should be equal to` false
    }
}
