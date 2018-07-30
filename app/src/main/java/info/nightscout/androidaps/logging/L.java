package info.nightscout.androidaps.logging;

import java.util.ArrayList;
import java.util.List;

import info.nightscout.utils.SP;

public class L {

    public static class LogElement {
        String name;
        boolean defaultValue;
        boolean enabled;
        boolean requiresRestart = false;

        LogElement(String name, boolean defaultValue) {
            this.name = name;
            this.defaultValue = defaultValue;
            enabled = SP.getBoolean(getSPName(), defaultValue);
        }

       LogElement(String name, boolean defaultValue, boolean requiresRestart) {
            this.name = name;
            this.defaultValue = defaultValue;
            this.requiresRestart = requiresRestart;
            enabled = SP.getBoolean(getSPName(), defaultValue);
        }

        LogElement(boolean defaultValue) {
            this.name = "NONEXISTING";
            this.defaultValue = defaultValue;
            enabled = defaultValue;
        }

        private String getSPName() {
            return "log_" + name;
        }

    }

    private static List<LogElement> logElements;

    static {
        initialize();
    }

    private static LogElement findByName(String name) {
        for (LogElement element: logElements
             ) {
            if (element.name.equals(name))
                return element;
        }
        return new LogElement(false);
    }

    public static boolean isEnabled(String name) {
        return findByName(name).enabled;
    }

    public static final String CORE = "CORE";
    public static final String AUTOSENS = "AUTOSENS";
    public static final String EVENTS = "EVENTS";
    public static final String BGSOURCE = "BGSOURCE";
    public static final String OVERVIEW = "OVERVIEW";
    public static final String NOTIFICATION = "NOTIFICATION";
    public static final String ALARM = "ALARM";
    public static final String DATASERVICE = "DATASERVICE";
    public static final String DATABASE = "DATABASE";
    public static final String DATAFOOD = "DATAFOOD";
    public static final String DATATREATMENTS = "DATATREATMENTS";
    public static final String NSCLIENT = "NSCLIENT";
    public static final String OBJECTIVES = "OBJECTIVES";
    public static final String PUMP = "PUMP";
    public static final String PUMPQUEUE = "PUMPQUEUE";
    public static final String PUMPCOMM = "PUMPCOMM";
    public static final String PUMPBTCOMM = "PUMPBTCOMM";
    public static final String APS = "APS";
    public static final String PROFILE = "PROFILE";
    public static final String CONFIGBUILDER = "CONFIGBUILDER";

    private static void initialize() {
        logElements = new ArrayList<>();
        logElements.add(new LogElement(CORE, true));
        logElements.add(new LogElement(CONFIGBUILDER, true));
        logElements.add(new LogElement(AUTOSENS, false));
        logElements.add(new LogElement(EVENTS, false, true));
        logElements.add(new LogElement(BGSOURCE, true));
        logElements.add(new LogElement(OVERVIEW, true));
        logElements.add(new LogElement(NOTIFICATION, true));
        logElements.add(new LogElement(ALARM, false));
        logElements.add(new LogElement(DATASERVICE, true));
        logElements.add(new LogElement(DATABASE, true));
        logElements.add(new LogElement(DATAFOOD, true));
        logElements.add(new LogElement(DATATREATMENTS, true));
        logElements.add(new LogElement(NSCLIENT, true));
        logElements.add(new LogElement(OBJECTIVES, false));
        logElements.add(new LogElement(PUMP, true));
        logElements.add(new LogElement(PUMPQUEUE, true));
        logElements.add(new LogElement(PUMPCOMM, true));
        logElements.add(new LogElement(PUMPBTCOMM, false));
        logElements.add(new LogElement(APS, true));
        logElements.add(new LogElement(PROFILE, true));
    }

}