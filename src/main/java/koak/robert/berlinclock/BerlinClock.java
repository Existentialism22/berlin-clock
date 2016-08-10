package koak.robert.berlinclock;

public class BerlinClock {

    String getLine0(int sec) {
        return (sec % 4 < 2 ) ? "Y" : "X";
    }
}
