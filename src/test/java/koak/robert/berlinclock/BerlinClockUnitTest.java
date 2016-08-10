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



}
