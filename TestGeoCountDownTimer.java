package project1;

import org.junit.Test;

import java.io.IOException;
import java.time.Month;

import static org.junit.Assert.*;

public class TestGeoCountDownTimer {

    /**
     * The following are simple JUnit test cases... After talking with your instructor, create
     * many, many more that shows that your code is functioning correctly.
     */

    @Test
    public void testConstructor1() {
        GeoCountDownTimer s = new GeoCountDownTimer(2121, 5, 10);
        assertEquals(s.toDateString(), "5/10/2121");
    }

    @Test
    public void testConstructor1_1() {
        GeoCountDownTimer s = new GeoCountDownTimer(2121, 1, 11);
        assertEquals(s.toDateString(), "1/11/2121");
    }

    @Test
    public void testConstructor1_2() {
        GeoCountDownTimer s = new GeoCountDownTimer();
        assertEquals(s.toDateString(), "1/1/2022");
    }

    @Test(expected = IllegalArgumentException.class)//Gavin1
    public void testConstructor1_3() {
        GeoCountDownTimer s = new GeoCountDownTimer(2021, 0, 1);
        assertEquals(s.toString(), "0/1/2021");
    }

    @Test
    public void testOther() {//Gavin2
        GeoCountDownTimer gdc1 = new GeoCountDownTimer(2022, 1, 1);
        GeoCountDownTimer s1 = new GeoCountDownTimer(gdc1);
        assertEquals(s1.toDateString(), "1/1/2022");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor2_1() {//Gavin3
        GeoCountDownTimer s = new GeoCountDownTimer("");
        assertEquals(s.toDateString(), "");
    }

    @Test
    public void testConstructor2_3() {//Gavin4
        GeoCountDownTimer s = new GeoCountDownTimer("0/0/0");
        assertEquals(s.toDateString(), "0/0/0");
    }

    @Test
    public void testConstructor2_4() {//Gavin5
        GeoCountDownTimer s = new GeoCountDownTimer("1/1/2022");
        assertEquals(s.toDateString(), "1/1/2022");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor2_5() {//Gavin6
        String s2 = null;
        GeoCountDownTimer s = new GeoCountDownTimer(s2);


    }


    @Test
    public void testCompareTo1() {//Gavin7
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 5, 9);
        GeoCountDownTimer s2 = new GeoCountDownTimer(2121, 6, 1);
        GeoCountDownTimer s3 = new GeoCountDownTimer(2121, 5, 8);
        GeoCountDownTimer s4 = new GeoCountDownTimer(2121, 5, 9);


        assertTrue(s2.compareTo(s1) > 0);

        assertTrue(s1.compareTo(s4) == 0);
    }


    @Test
    public void testCompareTo1_1() {//Gavin8
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 5, 9);
        GeoCountDownTimer s2 = new GeoCountDownTimer(2221, 6, 1);
        GeoCountDownTimer s3 = new GeoCountDownTimer(2100, 5, 9);
        GeoCountDownTimer s4 = new GeoCountDownTimer(2121, 5, 9);


        assertTrue(s2.compareTo(s1) > 0);
        assertTrue(s3.compareTo(s1) < 0);
        assertTrue(s1.compareTo(s4) == 0);
    }

    @Test
    public void testCompareTo1_2() {//Gavin9
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 5, 9);
        GeoCountDownTimer s2 = new GeoCountDownTimer(2121, 5, 11);
        GeoCountDownTimer s3 = new GeoCountDownTimer(2121, 4, 9);
        GeoCountDownTimer s4 = new GeoCountDownTimer(2121, 5, 9);


        assertTrue(s2.compareTo(s1) > 0);
        assertTrue(s3.compareTo(s1) < 0);
        assertTrue(s1.compareTo(s4) == 0);
    }

    @Test
    public void testCompareTo1_3() {//Gavin9
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 5, 9);
        GeoCountDownTimer s2 = new GeoCountDownTimer(2121, 5, 11);
        GeoCountDownTimer s3 = new GeoCountDownTimer(2121, 4, 9);
        GeoCountDownTimer s4 = new GeoCountDownTimer(2121, 5, 9);


        assertTrue(s1.compareTo(s2) > 0);

    }

    //	Create more, many more tests


    @Test
    public void testConstructor3() {//Gavin10
        GeoCountDownTimer s = new GeoCountDownTimer("5/10/2121");
        assertTrue(s.toDateString().equals("5/10/2121"));


    }


    @Test
    public void testConstructor3_1() {//Gavin11
        GeoCountDownTimer s = new GeoCountDownTimer("2/29/2121");
        assertTrue(s.toDateString().equals("2/29/2121"));

    }

    @Test
    public void testDecMonth() {//Gavin12
        GeoCountDownTimer s = new GeoCountDownTimer(2022, 5, 10);
        s.dec();
    }


    @Test
    public void testDecDay() {//Gavin13
        GeoCountDownTimer s = new GeoCountDownTimer(2022, 5, 10);
        s.dec();
    }

    @Test
    public void testDecYear() {//Gavin14
        GeoCountDownTimer s = new GeoCountDownTimer(2022, 5, 10);
        s.dec();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDec() {//Gavin15
        GeoCountDownTimer s = new GeoCountDownTimer(2022, 5, 10);
        GeoCountDownTimer s1 = new GeoCountDownTimer(2022, 5, 10);
        s1.dec(0);
        assertTrue(s1.toDateString().equals(s.toDateString()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDec1() {//Gavin16
        GeoCountDownTimer s = new GeoCountDownTimer(2022, 5, 0);
        s.dec();


    }

    @Test(expected = IllegalArgumentException.class)
    public void isLeapYear() {//Gavin17
        int year = 2020;
        GeoCountDownTimer s1 = new GeoCountDownTimer(year, 3, 1);
        s1.dec();
        System.out.println(s1.toDateString());
        assertTrue(true);
    }

    @Test
    public void isLeapYear1() {//Gavin17
        int year = 2024;
        GeoCountDownTimer s1 = new GeoCountDownTimer(year, 3, 1);
        s1.dec();
        System.out.println(s1.toDateString());
        assertTrue(true);
    }



    @Test
    public void isLeapYear2() {//Gavin17
        int year = 2028;
        GeoCountDownTimer s1 = new GeoCountDownTimer(year, 3, 1);
        s1.dec();
        System.out.println(s1.toDateString());
        assertTrue(true);
    }

    @Test
    public void testDec2() {
        GeoCountDownTimer s = new GeoCountDownTimer();
    }


    @Test
    public void isLeapYear3() {//Gavin54
        GeoCountDownTimer s1 = new GeoCountDownTimer(2022, 3, 1);
        s1.dec();
        System.out.println(s1.toDateString());
        assertFalse(false);


    }

    public void testAddMethod() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 5, 10);
        s1.inc(365);
        assertTrue(s1.toDateString().equals("5/10/2122"));

        s1 = new GeoCountDownTimer(2120, 1, 10);

        for (int i = 0; i < 366; i++)
            s1.inc();
        assertTrue(s1.toDateString().equals("1/10/2121"));

        s1 = new GeoCountDownTimer(2022, 5, 10);

        for (int i = 0; i < 31665; i++)
            s1.inc();

        for (int i = 0; i < 31665; i++)
            s1.dec();

        assertTrue(s1.toDateString().equals("5/10/2022"));

    }


    // must have a separate test for each Exception
    @Test(expected = IllegalArgumentException.class)
    public void testContuctor1() {
        new GeoCountDownTimer(2, -3, -3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContuctor2() {
        new GeoCountDownTimer("2,-3/-3");

    }

    @Test
    public void testEqual() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(3000, 5, 9);
        GeoCountDownTimer s2 = new GeoCountDownTimer(2121, 6, 1);
        GeoCountDownTimer s3 = new GeoCountDownTimer(2121, 5, 5);
        GeoCountDownTimer s4 = new GeoCountDownTimer(3000, 5, 9);
        GeoCountDownTimer s5 = new GeoCountDownTimer(3000, 5, 9);

        assertEquals(s4, s5);
        assertFalse(s1.equals(s2));
        assertTrue(s1.equals(s4));


    }

    @Test(expected = IllegalArgumentException.class)
    public void testCompareTo() {//Gavin18
        GeoCountDownTimer s1 = new GeoCountDownTimer();
        GeoCountDownTimer s2 = null;
        s1.compareTo(s2);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testEquals() {//Gavin19
        GeoCountDownTimer s1 = new GeoCountDownTimer();
        GeoCountDownTimer s2 = null;
        s1.equals(s2);

    }

    @Test
    public void testLoadSave() {//Gavin20
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 9, 1);
        GeoCountDownTimer s2 = new GeoCountDownTimer(2121, 9, 1);


        s1.save("file1");
        s1 = new GeoCountDownTimer(2111, 1, 1);  // resets to zero
        s1.load("file1");
        assertTrue(s2.equals(s1));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testLoadSave1() {//Gavin21
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 9, 1);
        GeoCountDownTimer s2 = new GeoCountDownTimer(2121, 9, 1);

        s1.save("file1");
        s1 = new GeoCountDownTimer(2111, 1, 1);  // resets to zero
        s1.load(null);
        assertEquals(s1, s2);

    }


    @Test(expected = IllegalArgumentException.class)
    public void testLoadSave2() {//Gavin21
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 9, 1);
        GeoCountDownTimer s2 = new GeoCountDownTimer(2121, 9, 1);
        s1.save("wow/cool.txt");


    }


    @Test
    public void testDaysToGo() {//Gavin22
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 2, 9);
        assertTrue(s1.daysToGo("2/1/2121") == 8);
        assertTrue(s1.daysToGo("2/8/2121") == 1);
        assertTrue(s1.daysToGo("2/9/2121") == 0);
    }


    @Test
    public void testDaysToGo1() {//Gavin51
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 2, 9);
        assertTrue(s1.daysToGo("2/1/2121") == 8);
        assertTrue(s1.daysToGo("2/8/2121") == 1);
        assertTrue(s1.daysToGo("2/9/2121") == 0);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testDaysToGo2() {//Gavin52
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 2, 9);
        String s2 = null;
        s1.daysToGo(s2);
    }

    @Test
    public void testDaysInFuture() {//Gavin23
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 12, 9);
        GeoCountDownTimer s2 = new GeoCountDownTimer(2121, 12, 19);

        assertTrue(s1.daysInFuture(10).equals(s2));

    }


    @Test
    public void testToString() {
        GeoCountDownTimer s = new GeoCountDownTimer(2121, 12, 1);
        System.out.println(s);
    }

    @Test
    public void testDaysInFuture3() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 12, 1);
        GeoCountDownTimer s2 = new GeoCountDownTimer(2121, 11, 30);
        assertEquals(s1.daysInFuture(-1), s2);
    }

    @Test
    public void testDaysInFuture2() {
        int n = 0;
        GeoCountDownTimer s = new GeoCountDownTimer("2/1/2022");
        GeoCountDownTimer s1 = new GeoCountDownTimer("2/1/2022");
        assertEquals(s.daysInFuture(n), s1);
    }

    @Test
    public void testDaysInFuture1() {
        GeoCountDownTimer s = new GeoCountDownTimer(2121, 12, 9);
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 12, 9);

    }

    @Test(expected = IllegalArgumentException.class)//Gavin24
    public void testConstructor1_4() {
        GeoCountDownTimer s = new GeoCountDownTimer(2023, 10, 0);
        assertEquals(s.toDateString(), "10/0/2023");
    }

    @Test(expected = IllegalArgumentException.class)//Gavin25
    public void testConstructor1_5() {
        GeoCountDownTimer s = new GeoCountDownTimer(0, 10, 15);
        assertEquals(s.toDateString(), "10/15/0");
    }

    @Test(expected = IllegalArgumentException.class)//Gavin26
    public void testConstructor1_6() {
        GeoCountDownTimer s = new GeoCountDownTimer(2023, -1, 12);
        assertEquals(s.toDateString(), "-1/12/2023");
    }

    @Test(expected = IllegalArgumentException.class)//Gavin27
    public void testConstructor1_7_1() {
        GeoCountDownTimer s = new GeoCountDownTimer(2023, 8, -1);
        assertEquals(s.toDateString(), "8/-1/2023");
    }

    @Test
    public void testConstructor1_8() {//Gavin28
        GeoCountDownTimer s = new GeoCountDownTimer(2050, 8, 10);
        assertEquals(s.toDateString(), "8/10/2050");
    }

    @Test
    public void testConstructor1_9() {//Gavin29
        GeoCountDownTimer s = new GeoCountDownTimer(3000, 8, 11);
        assertEquals(s.toDateString(), "8/11/3000");
    }

    @Test
    public void testConstructor1_10() {//Gavin30
        GeoCountDownTimer s = new GeoCountDownTimer(2025, 8, 30);
        assertEquals(s.toDateString(), "8/30/2025");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1_11() {//Gavin31
        GeoCountDownTimer s = new GeoCountDownTimer(2005, 8, 30);
        assertEquals(s.toDateString(), "8/30/2025");
    }

    @Test
    public void testConstructor1_12() {//Gavin32
        GeoCountDownTimer s = new GeoCountDownTimer(202555, 8, 30);
        assertEquals(s.toDateString(), "8/30/202555");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOther_1() {//Gavin33
        GeoCountDownTimer gdc1 = new GeoCountDownTimer(2021, 1, 1);
        GeoCountDownTimer s1 = new GeoCountDownTimer(gdc1);
        assertEquals(s1.toDateString(), "1/1/2021");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOther_2() {//Gavin34
        GeoCountDownTimer gdc1 = new GeoCountDownTimer(0, 1, 1);
        GeoCountDownTimer s1 = new GeoCountDownTimer(gdc1);
        assertEquals(s1.toDateString(), "1/1/0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOther_3() {//Gavin35
        GeoCountDownTimer gdc1 = new GeoCountDownTimer(-1, 1, 1);
        GeoCountDownTimer s1 = new GeoCountDownTimer(gdc1);
        assertEquals(s1.toDateString(), "1/1/-1");
    }


    @Test(expected = IllegalArgumentException.class)
    public void testOther_4() {//36
        GeoCountDownTimer gdc1 = new GeoCountDownTimer(2022, 0, 1);
        GeoCountDownTimer s1 = new GeoCountDownTimer(gdc1);
        assertEquals(s1.toDateString(), "0/1/2022");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOther_5() {//Gavin37
        GeoCountDownTimer gdc1 = new GeoCountDownTimer(2022, -1, 1);
        GeoCountDownTimer s1 = new GeoCountDownTimer(gdc1);
        assertEquals(s1.toDateString(), "-1/1/2022");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOther_6() {//Gavin38
        GeoCountDownTimer gdc1 = new GeoCountDownTimer(2022, 1, 0);
        GeoCountDownTimer s1 = new GeoCountDownTimer(gdc1);
        assertEquals(s1.toDateString(), "1/0/2022");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOther_7() {//Gavin39
        GeoCountDownTimer gdc1 = new GeoCountDownTimer(2022, 1, -1);
        GeoCountDownTimer s1 = new GeoCountDownTimer(gdc1);
        assertEquals(s1.toDateString(), "1/-1/2022");
    }

    @Test
    public void testConstructor2_6() {//Gavin40
        GeoCountDownTimer s = new GeoCountDownTimer("0/1/2022");
        assertEquals(s.toDateString(), "0/1/2022");
    }

    @Test
    public void testConstructor2_7() {//Gavin41
        GeoCountDownTimer s = new GeoCountDownTimer("-1/1/2022");
        assertEquals(s.toDateString(), "-1/1/2022");
    }


    @Test
    public void testConstructor2_8() {//Gavin42
        GeoCountDownTimer s = new GeoCountDownTimer("1/0/2022");
        assertEquals(s.toDateString(), "1/0/2022");
    }


    @Test
    public void testConstructor2_9() {//Gavin43
        GeoCountDownTimer s = new GeoCountDownTimer("1/-1/2022");
        assertEquals(s.toDateString(), "1/-1/2022");
    }


    @Test
    public void testConstructor2_10() {//Gavin44
        GeoCountDownTimer s = new GeoCountDownTimer("1/1/2021");
        assertEquals(s.toDateString(), "1/1/2021");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor2_11() {//Gavin45
        GeoCountDownTimer s = new GeoCountDownTimer("1/1/2022/10");
        assertEquals(s.toDateString(), "1/1/2022/10");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor2_12() {//Gavin46
        GeoCountDownTimer s = new GeoCountDownTimer("1/1");
        assertEquals(s.toDateString(), "1/1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor2_13() {//Gavin47
        GeoCountDownTimer s = new GeoCountDownTimer("1/1/");
        assertEquals(s.toDateString(), "1/1/");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor2_14() {//Gavin48
        GeoCountDownTimer s = new GeoCountDownTimer("1/");
        assertEquals(s.toDateString(), "1/");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor2_15() {//Gavin49
        GeoCountDownTimer s = new GeoCountDownTimer("1");
        assertEquals(s.toDateString(), "1");


    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor2_16() {//Gavin50
        GeoCountDownTimer s = new GeoCountDownTimer("1/1/2022/10/10");
        assertEquals(s.toDateString(), "1/1/2022/10/10");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor2_17() {//Niki1
        GeoCountDownTimer s = new GeoCountDownTimer("FAILED TEST NOT A DATE BRO");
        assertEquals(s.toDateString(), "FAILED TEST NOT A DATE BRO");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor3_3() {//Niki2
        GeoCountDownTimer s = new GeoCountDownTimer("");
        assertTrue(s.toDateString().equals(""));


    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor3_4() {//Niki3
        GeoCountDownTimer s = new GeoCountDownTimer("NOT CORRECT");
        assertTrue(s.toDateString().equals("NOT CORRECT"));


    }

    @Test
    public void testConstructor3_5() {//Niki4
        GeoCountDownTimer s = new GeoCountDownTimer("2/29/3000");
        assertTrue(s.toDateString().equals("2/29/3000"));


    }


    @Test(expected = IllegalArgumentException.class)
    public void testConstructor3_6() {//Niki5
        GeoCountDownTimer s = new GeoCountDownTimer("1/1/1/1");
        assertTrue(s.toDateString().equals("1/1/1/1"));


    }


    @Test(expected = IllegalArgumentException.class)
    public void testConstructor3_7() {//Niki6
        GeoCountDownTimer s = new GeoCountDownTimer("2/29/");
        assertTrue(s.toDateString().equals("2/29/"));


    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor3_8() {//Niki7
        GeoCountDownTimer s = new GeoCountDownTimer("2/29");
        assertTrue(s.toDateString().equals("2/29"));


    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor3_9() {//Niki8
        GeoCountDownTimer s = new GeoCountDownTimer("2/2");
        assertTrue(s.toDateString().equals("2/2"));


    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor3_10() {//Niki9
        GeoCountDownTimer s = new GeoCountDownTimer("2/");
        assertTrue(s.toDateString().equals("2/"));


    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor3_11() {//Niki10
        GeoCountDownTimer s = new GeoCountDownTimer("2");
        assertTrue(s.toDateString().equals("2"));


    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor3_12() {//Niki11
        GeoCountDownTimer s = new GeoCountDownTimer("/");
        assertTrue(s.toDateString().equals("/"));


    }


    @Test(expected = IllegalArgumentException.class)
    public void testDecMonth_1() {//Niki12
        GeoCountDownTimer s = new GeoCountDownTimer(2020, 5, 10);
        s.dec();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecMonth_2() {//Niki13
        GeoCountDownTimer s = new GeoCountDownTimer(-1, 5, 10);
        s.dec();
    }


    @Test(expected = IllegalArgumentException.class)
    public void testDecMonth_3() {//Niki14
        GeoCountDownTimer s = new GeoCountDownTimer(0, 5, 10);
        s.dec();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecMonth_4() {//Niki15
        GeoCountDownTimer s = new GeoCountDownTimer(2022, 0, 10);
        s.dec();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecMonth_5() {//Niki16
        GeoCountDownTimer s = new GeoCountDownTimer(2022, -1, 10);
        s.dec();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecMonth_6() {//Niki17
        GeoCountDownTimer s = new GeoCountDownTimer(2022, 5, 0);
        s.dec();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecMonth_7() {//Niki18
        GeoCountDownTimer s = new GeoCountDownTimer(2022, 5, -1);
        s.dec();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecDay_1() {//Niki19
        GeoCountDownTimer s = new GeoCountDownTimer(2020, 5, 10);
        s.dec();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecDay_2() {//Niki20
        GeoCountDownTimer s = new GeoCountDownTimer(-1, 5, 10);
        s.dec();
    }


    @Test(expected = IllegalArgumentException.class)
    public void testDecDay_3() {//Niki21
        GeoCountDownTimer s = new GeoCountDownTimer(0, 5, 10);
        s.dec();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecDay_4() {//Niki22
        GeoCountDownTimer s = new GeoCountDownTimer(2022, 0, 10);
        s.dec();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecDay_5() {//Niki23
        GeoCountDownTimer s = new GeoCountDownTimer(2022, -1, 10);
        s.dec();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecDay_6() {//Niki24
        GeoCountDownTimer s = new GeoCountDownTimer(2022, 5, 0);
        s.dec();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecDay_7() {//Niki25
        GeoCountDownTimer s = new GeoCountDownTimer(2022, 5, -1);
        s.dec();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecYear_1() {//Niki26
        GeoCountDownTimer s = new GeoCountDownTimer(2020, 5, 10);
        s.dec();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecYear_2() {//Niki27
        GeoCountDownTimer s = new GeoCountDownTimer(-1, 5, 10);
        s.dec();
    }


    @Test(expected = IllegalArgumentException.class)
    public void testDecYear_3() {//Niki28
        GeoCountDownTimer s = new GeoCountDownTimer(0, 5, 10);
        s.dec();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecYear_4() {//Niki29
        GeoCountDownTimer s = new GeoCountDownTimer(2022, 0, 10);
        s.dec();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecYear_5() {//Niki30
        GeoCountDownTimer s = new GeoCountDownTimer(2022, -1, 10);
        s.dec();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecYear_6() {//Niki31
        GeoCountDownTimer s = new GeoCountDownTimer(2022, 5, 0);
        s.dec();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecYear_7() {//Niki32
        GeoCountDownTimer s = new GeoCountDownTimer(2022, 5, -1);
        s.dec();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDec_1() {//Niki33
        GeoCountDownTimer s = new GeoCountDownTimer(2020, 5, 10);
        s.dec();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDec_2() {//Niki34
        GeoCountDownTimer s = new GeoCountDownTimer(-1, 5, 10);
        s.dec();
    }


    @Test(expected = IllegalArgumentException.class)
    public void testDec_3() {//Niki35
        GeoCountDownTimer s = new GeoCountDownTimer(0, 5, 10);
        s.dec();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDec_4() {//Niki36
        GeoCountDownTimer s = new GeoCountDownTimer(2022, 0, 10);
        s.dec();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDec_5() {//Niki37
        GeoCountDownTimer s = new GeoCountDownTimer(2022, -1, 10);
        s.dec();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDec_6() {//Niki38
        GeoCountDownTimer s = new GeoCountDownTimer(2022, 5, 0);
        s.dec();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDec_7() {//Niki39
        GeoCountDownTimer s = new GeoCountDownTimer(2022, 5, -1);
        s.dec();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDec_8() {//Niki39
        GeoCountDownTimer s = new GeoCountDownTimer(2022, 1, 1);
        s.dec();
    }

    @Test
    public void testDecMonthy() {
        GeoCountDownTimer s = new GeoCountDownTimer(2023, 1, 1);
        s.dec();
        assertEquals(s.toDateString(), "12/31/2022");
    }

    @Test
    public void testIncTRUEEEE() {
        GeoCountDownTimer s = new GeoCountDownTimer(2023, 12, 31);
        s.inc();
        assertEquals(s.toDateString(), "1/1/2024");
    }

    @Test
    public void testIncLEAP() {
        GeoCountDownTimer s = new GeoCountDownTimer(2024, 2, 29);
        s.inc();
        assertEquals(s.toDateString(), "3/1/2024");
    }

    @Test
    public void testInc1() {
        GeoCountDownTimer s = new GeoCountDownTimer(2023, 12, 31);
        s.inc();
        assertEquals(s.toDateString(), "1/1/2024");
    }


    @Test(expected = IllegalArgumentException.class)
    public void testContuctor3() {//Niki40
        new GeoCountDownTimer(0, 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContuctor4() {//Niki41
        new GeoCountDownTimer(0, 1, 3);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testContuctor4_1() {//Niki42
        new GeoCountDownTimer(1, 0, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContuctor5() {//Niki43
        new GeoCountDownTimer(1, 1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContuctor6() {//Niki44
        new GeoCountDownTimer(-1, 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContuctor7() {//Niki45
        new GeoCountDownTimer(1, -1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContuctor8() {//Niki46
        new GeoCountDownTimer(1, 1, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContuctor9() {//Niki47
        new GeoCountDownTimer("/1/1/3/");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testContuctor10() {//Niki48
        new GeoCountDownTimer("1/1/3/1");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testContuctor11() {//Niki49
        new GeoCountDownTimer("1/1/");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testContuctor12() {//Niki50
        new GeoCountDownTimer("1/1");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testContuctor13() {//Niki51
        new GeoCountDownTimer("1/");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testContuctor14() {//Niki52
        new GeoCountDownTimer("0");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testContuctor15() {//Niki53
        new GeoCountDownTimer("/");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testContuctor16() {//Niki54
        new GeoCountDownTimer("NOT APPLICABLE BRO");

    }

}