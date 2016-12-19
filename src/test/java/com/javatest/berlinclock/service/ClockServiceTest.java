package com.javatest.berlinclock.service;

import com.javatest.berlinclock.model.Clock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalTime;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ClockServiceTest {

    private ClockService unit;

    @Before
    public void setUp(){
        unit = new ClockService();
    }

    @Test
    public void shouldReturnValidBerlinClockWhenCalculateBerlinClockByTimeWith101010(){
        //given
        LocalTime time = LocalTime.of(10, 10, 10);
        //when
        Clock result = unit.calculateBerlinClockByTime(time);
        //then
        assertEquals(true, result.isSecond());
        assertArrayEquals(new boolean[]{true, true, false, false}, result.getHour_5());
        assertArrayEquals(new boolean[]{false, false, false, false}, result.getHour_1());
        assertArrayEquals(new boolean[]{true, true, false, false, false, false, false, false, false, false, false}, result.getMinute_5());
        assertArrayEquals(new boolean[]{false, false, false, false}, result.getMinute_1());
    }

    @Test
    public void shouldReturnValidBerlinClockWhenCalculateBerlinClockByTimeWith000001(){
        //given
        LocalTime time = LocalTime.of(0, 0, 1);
        //when
        Clock result = unit.calculateBerlinClockByTime(time);
        //then
        assertEquals(false, result.isSecond());
        assertArrayEquals(new boolean[]{false, false, false, false}, result.getHour_5());
        assertArrayEquals(new boolean[]{false, false, false, false}, result.getHour_1());
        assertArrayEquals(new boolean[]{false, false, false, false, false, false, false, false, false, false, false}, result.getMinute_5());
        assertArrayEquals(new boolean[]{false, false, false, false}, result.getMinute_1());
    }

    @Test
    public void shouldReturnValidBerlinClockWhenCalculateBerlinClockByTimeWith235959(){
        //given
        LocalTime time = LocalTime.of(23, 59, 59);
        //when
        Clock result = unit.calculateBerlinClockByTime(time);
        //then
        assertEquals(false, result.isSecond());
        assertArrayEquals(new boolean[]{true, true, true, true}, result.getHour_5());
        assertArrayEquals(new boolean[]{true, true, true, false}, result.getHour_1());
        assertArrayEquals(new boolean[]{true, true, true, true, true, true, true, true, true, true, true}, result.getMinute_5());
        assertArrayEquals(new boolean[]{true, true, true, true}, result.getMinute_1());
    }

    @Test
    public void shouldReturnValidBerlinClockWhenCalculateBerlinClockByTimeWith120000(){
        //given
        LocalTime time = LocalTime.of(12, 00, 00);
        //when
        Clock result = unit.calculateBerlinClockByTime(time);
        //then
        assertEquals(true, result.isSecond());
        assertArrayEquals(new boolean[]{true, true, false, false}, result.getHour_5());
        assertArrayEquals(new boolean[]{true, true, false, false}, result.getHour_1());
        assertArrayEquals(new boolean[]{false, false, false, false, false, false, false, false, false, false, false}, result.getMinute_5());
        assertArrayEquals(new boolean[]{false, false, false, false}, result.getMinute_1());
    }
}
