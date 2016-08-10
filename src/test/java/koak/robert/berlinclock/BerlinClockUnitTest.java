package koak.robert.berlinclock;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BerlinClockUnitTest {

    private BerlinClock testObj;

    @Before
    public void setUp() throws Exception {
        testObj = new BerlinClock();
    }

    @Test
    public void convert_midnight() {
        assertThat(testObj.convert(0, 0, 0)).isEqualTo(
                        "Y\n" +
                        "XXXX\n" +
                        "XXXX\n" +
                        "XXXXXXXXXXX\n" +
                        "XXXX");
    }

    @Test
    public void convert_21_46_48() {
        assertThat(testObj.convert(21, 46, 48)).isEqualTo(
                        "Y\n" +
                        "RRRR\n" +
                        "RXXX\n" +
                        "YYRYYRYYRXX\n" +
                        "YXXX");
    }

    @Test
    public void convert_23_59_59() {
        assertThat(testObj.convert(23, 59, 59)).isEqualTo(
                        "X\n" +
                        "RRRR\n" +
                        "RRRX\n" +
                        "YYRYYRYYRYY\n" +
                        "YYYY");
    }

    @Test
    public void getLine0() {
        assertThat(testObj.getLine0(0)).isEqualTo("Y");
        assertThat(testObj.getLine0(1)).isEqualTo("X");
        assertThat(testObj.getLine0(2)).isEqualTo("Y");
        assertThat(testObj.getLine0(3)).isEqualTo("X");
        assertThat(testObj.getLine0(4)).isEqualTo("Y");
        assertThat(testObj.getLine0(59)).isEqualTo("X");
    }

    @Test
    public void getLine1() {
        assertThat(testObj.getLine1(0)).isEqualTo("XXXX");
        assertThat(testObj.getLine1(1)).isEqualTo("XXXX");
        assertThat(testObj.getLine1(2)).isEqualTo("XXXX");
        assertThat(testObj.getLine1(3)).isEqualTo("XXXX");
        assertThat(testObj.getLine1(4)).isEqualTo("XXXX");

        assertThat(testObj.getLine1(5)).isEqualTo("RXXX");
        assertThat(testObj.getLine1(6)).isEqualTo("RXXX");
        assertThat(testObj.getLine1(7)).isEqualTo("RXXX");
        assertThat(testObj.getLine1(8)).isEqualTo("RXXX");
        assertThat(testObj.getLine1(9)).isEqualTo("RXXX");

        assertThat(testObj.getLine1(10)).isEqualTo("RRXX");
        assertThat(testObj.getLine1(11)).isEqualTo("RRXX");
        assertThat(testObj.getLine1(12)).isEqualTo("RRXX");
        assertThat(testObj.getLine1(13)).isEqualTo("RRXX");
        assertThat(testObj.getLine1(14)).isEqualTo("RRXX");

        assertThat(testObj.getLine1(15)).isEqualTo("RRRX");
        assertThat(testObj.getLine1(19)).isEqualTo("RRRX");

        assertThat(testObj.getLine1(20)).isEqualTo("RRRR");
        assertThat(testObj.getLine1(23)).isEqualTo("RRRR");
    }

    @Test
    public void getLine2() {
        assertThat(testObj.getLine2(0)).isEqualTo("XXXX");
        assertThat(testObj.getLine2(1)).isEqualTo("RXXX");
        assertThat(testObj.getLine2(2)).isEqualTo("RRXX");
        assertThat(testObj.getLine2(3)).isEqualTo("RRRX");
        assertThat(testObj.getLine2(4)).isEqualTo("RRRR");
        assertThat(testObj.getLine2(5)).isEqualTo("XXXX");
        assertThat(testObj.getLine2(23)).isEqualTo("RRRX");
    }

    @Test
    public void getLine3() {
        assertThat(testObj.getLine3(0)).isEqualTo("XXXXXXXXXXX");
        assertThat(testObj.getLine3(4)).isEqualTo("XXXXXXXXXXX");

        assertThat(testObj.getLine3(5)).isEqualTo("YXXXXXXXXXX");
        assertThat(testObj.getLine3(9)).isEqualTo("YXXXXXXXXXX");

        assertThat(testObj.getLine3(10)).isEqualTo("YYXXXXXXXXX");
        assertThat(testObj.getLine3(14)).isEqualTo("YYXXXXXXXXX");

        assertThat(testObj.getLine3(15)).isEqualTo("YYRXXXXXXXX");
        assertThat(testObj.getLine3(19)).isEqualTo("YYRXXXXXXXX");

        assertThat(testObj.getLine3(20)).isEqualTo("YYRYXXXXXXX");
        assertThat(testObj.getLine3(24)).isEqualTo("YYRYXXXXXXX");

        assertThat(testObj.getLine3(25)).isEqualTo("YYRYYXXXXXX");
        assertThat(testObj.getLine3(29)).isEqualTo("YYRYYXXXXXX");

        assertThat(testObj.getLine3(30)).isEqualTo("YYRYYRXXXXX");
        assertThat(testObj.getLine3(34)).isEqualTo("YYRYYRXXXXX");

        assertThat(testObj.getLine3(55)).isEqualTo("YYRYYRYYRYY");
        assertThat(testObj.getLine3(59)).isEqualTo("YYRYYRYYRYY");
    }

    @Test
    public void getLine4() {
        assertThat(testObj.getLine4(0)).isEqualTo("XXXX");
        assertThat(testObj.getLine4(1)).isEqualTo("YXXX");
        assertThat(testObj.getLine4(2)).isEqualTo("YYXX");
        assertThat(testObj.getLine4(3)).isEqualTo("YYYX");
        assertThat(testObj.getLine4(4)).isEqualTo("YYYY");
        assertThat(testObj.getLine4(5)).isEqualTo("XXXX");
        assertThat(testObj.getLine4(6)).isEqualTo("YXXX");
        assertThat(testObj.getLine4(59)).isEqualTo("YYYY");
    }
}
