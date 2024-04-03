package com.thindie.tasks_costs

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class WeekDetectionTest {
    @Test
    fun week_Detection_Correct() {
        assertEquals(
            1,
            buildRangeIndexedFromNonZero(step = 7, times = 52).first { 7 in it.first }.second
        )
    }
}