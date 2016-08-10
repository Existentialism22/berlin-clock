package koak.robert.berlinclock;

public class BerlinClock {

    public static final int LINE_1_EACH_LAMP_HOURS = 5;
    public static final String LAMP_OFF = "X";
    public static final String LAMP_YELLOW = "Y";
    public static final String LAMP_RED = "R";

    String getLine0(int sec) {
        return (sec % 4 < 2) ? LAMP_YELLOW : LAMP_OFF;
    }

    String getLine1(int hour) {
        int numberOfOnLamps = hour / LINE_1_EACH_LAMP_HOURS;
        return turnNumberOfOnLampsToString(numberOfOnLamps);
    }

    String getLine2(int hour) {
        int numberOfOnLamps = hour % LINE_1_EACH_LAMP_HOURS;
        return turnNumberOfOnLampsToString(numberOfOnLamps);
    }

    private String turnNumberOfOnLampsToString(int numberOfOnLamps) {
        String returnable = "";
        for (int i = 1; i < LINE_1_EACH_LAMP_HOURS; i++) {
            if (i <= numberOfOnLamps) {
                returnable += LAMP_RED;
            } else {
                returnable += LAMP_OFF;
            }
        }
        return returnable;
    }
}
