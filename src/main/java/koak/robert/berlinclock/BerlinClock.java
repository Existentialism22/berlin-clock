package koak.robert.berlinclock;

public class BerlinClock {

    public static final int MAJOR_LAMP_REP = 5;
    public static final String LAMP_OFF = "X";
    public static final String LAMP_YELLOW = "Y";
    public static final String LAMP_RED = "R";

    String getLine0(int sec) {
        return (sec % 4 < 2) ? LAMP_YELLOW : LAMP_OFF;
    }

    String getLine1(int hour) {
        int numberOfOnLamps = hour / MAJOR_LAMP_REP;
        return turnNumberOfOnLampsToHour(numberOfOnLamps);
    }

    String getLine2(int hour) {
        int numberOfOnLamps = hour % MAJOR_LAMP_REP;
        return turnNumberOfOnLampsToHour(numberOfOnLamps);
    }

    private String turnNumberOfOnLampsToHour(int numberOfOnLamps) {
        String returnable = "";
        for (int i = 0; i < 4; i++) {
            if (i < numberOfOnLamps) {
                returnable += LAMP_RED;
            } else {
                returnable += LAMP_OFF;
            }
        }
        return returnable;
    }

    public String getLine3(int min) {
        int numberOfOnLamps = min / MAJOR_LAMP_REP;

        String returnable = "";
        for (int i = 0; i < 11; i++) {
            if (i < numberOfOnLamps) {
                if (i % 3 == 2) {
                    returnable += LAMP_RED;
                } else {
                    returnable += LAMP_YELLOW;
                }
            } else {
                returnable += LAMP_OFF;
            }
        }
        return returnable;
    }
}
