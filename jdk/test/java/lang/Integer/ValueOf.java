/*
 * Copyright 2009 Sun Microsystems, Inc.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,
 * CA 95054 USA or visit www.sun.com if you need additional information or
 * have any questions.
 */

/**
 * @test
 * @bug 6807702
 * @summary Basic test for Integer.valueOf
 * @run main ValueOf
 * @run main/othervm -esa -XX:+AggressiveOpts ValueOf
 */

public class ValueOf {

    // test Integer.valueOf over this range (inclusive)
    private static final int TEST_LOW  = -1024;
    private static final int TEST_HIGH = 24576;

    public static void main(String[] args) {
        int i = TEST_LOW;
        while (i <= TEST_HIGH) {
            // check that valueOf stores i
            if (Integer.valueOf(i).intValue() != i)
                throw new RuntimeException();

            // check that the same object is returned for integral values
            // in the range -128 to 127 (inclusive)
            if (i >= -128 && i <= 127) {
                if (Integer.valueOf(i) != Integer.valueOf(i))
                    throw new RuntimeException();
            }

            i++;
        }
    }
}
