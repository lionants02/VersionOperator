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

import kotlin.math.max

class VersionOperator(val version: String, private val delimiters: Char = '.') : Comparable<VersionOperator> {
    private val versionBlock = version.versionBlock()
    override fun equals(other: Any?): Boolean {
        if (other === this) return true
        if (other == null) return false
        if (other !is VersionOperator) return false
        return this.compareTo(other) == 0
    }

    override fun compareTo(other: VersionOperator): Int {
        val versionBlockSize = versionBlock.size
        val otherVersionBlockSize = other.versionBlock.size
        val length = max(versionBlockSize, otherVersionBlockSize)

        for (i in 0 until length) {
            val thisVersion = if (i < versionBlockSize) Integer.parseInt(versionBlock[i]) else 0
            val otherVersion = if (i < otherVersionBlockSize) Integer.parseInt(other.versionBlock[i]) else 0
            if (thisVersion < otherVersion) return -1
            if (thisVersion > otherVersion) return 1
        }
        return 0
    }

    override fun hashCode(): Int = version.hashCode()

    private fun String.versionBlock(): List<String> {
        return utilVersionBlock(this, delimiters)
    }
}

fun String.VersionOp() = VersionOperator(this)

internal fun utilVersionBlock(source: String, delimiters: Char): List<String> {
    val replaceSoruce = source.replace(Regex("""^([\d.]+).*$"""), "$1")
    return replaceSoruce.split(delimiters)
}
