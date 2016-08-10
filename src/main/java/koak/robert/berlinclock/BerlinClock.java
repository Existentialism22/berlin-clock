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
        return turnNumberOfLampsOnToString(numberOfLampsOn, LAMP_RED, 4);
    }

    String getLine2(int hour) {
        int numberOfLampsOn = hour % MAJOR_LAMP_QUANT;
        return turnNumberOfLampsOnToString(numberOfLampsOn, LAMP_RED, 4);
    }

    String getLine3(int min) {
        int numberOfLampsOn = min / MAJOR_LAMP_QUANT;
        return turnNumberOfLampsOnToString(numberOfLampsOn, LAMP_YELLOW, 11).replaceAll("YYY", "YYR");
    }

    String getLine4(int min) {
        int numberOfLampsOn = min % MAJOR_LAMP_QUANT;
        return turnNumberOfLampsOnToString(numberOfLampsOn, LAMP_YELLOW, 4);
    }

    private String turnNumberOfLampsOnToString(int numberOfLampsOn, String onLampColour, int length) {
        String returnable = "";
        for (int i = 0; i < length; i++) {
            if (i < numberOfLampsOn) {
                returnable += onLampColour;
            } else {
                returnable += LAMP_OFF;
            }
        }
        return returnable;
    }
}
