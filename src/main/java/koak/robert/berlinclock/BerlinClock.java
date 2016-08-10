package koak.robert.berlinclock;

public class BerlinClock {

    public static final int MAJOR_LAMP_QUANT = 5;

    public static final String LAMP_OFF = "X";
    public static final String LAMP_YELLOW = "Y";
    public static final String LAMP_RED = "R";

    String getLine0(int sec) {
        return (sec % 4 < 2) ? LAMP_YELLOW : LAMP_OFF;
    }

    String getLine1(int hour) {
        int numberOfLampsOn = hour / MAJOR_LAMP_QUANT;
        return turnNumberOfOnLampsToString(numberOfLampsOn, LAMP_RED);
    }

    String getLine2(int hour) {
        int numberOfLampsOn = hour % MAJOR_LAMP_QUANT;
        return turnNumberOfOnLampsToString(numberOfLampsOn, LAMP_RED);
    }

    private String turnNumberOfOnLampsToString(int numberOfLampsOn, String onLampColour) {
        String returnable = "";
        for (int i = 0; i < 4; i++) {
            if (i < numberOfLampsOn) {
                returnable += onLampColour;
            } else {
                returnable += LAMP_OFF;
            }
        }
        return returnable;
    }

    String getLine3(int min) {
        int numberOfLampsOn = min / MAJOR_LAMP_QUANT;

        String returnable = "";
        for (int i = 0; i < 11; i++) {
            if (i < numberOfLampsOn) {
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

    String getLine4(int min) {
        int numberOfLampsOn = min % MAJOR_LAMP_QUANT;
        return turnNumberOfOnLampsToString(numberOfLampsOn, LAMP_YELLOW);
    }
}
