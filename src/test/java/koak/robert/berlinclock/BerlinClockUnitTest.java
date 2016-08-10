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
    public void getLine0() {
        assertThat(testObj.getLine0(0)).isEqualTo("Y");
        assertThat(testObj.getLine0(1)).isEqualTo("Y");
        assertThat(testObj.getLine0(2)).isEqualTo("X");
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

}
