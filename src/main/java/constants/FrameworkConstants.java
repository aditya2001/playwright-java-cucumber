package constants;

public class FrameworkConstants {

    private FrameworkConstants() {

    }

    private static final int EXPLICITWAIT = 10;
    private static final String CONFIGPATH= System.getProperty("user.dir") +"/src/test/resources/config/";
    private static final String RESOURCESPATH= System.getProperty("user.dir") +"/src/test/resources/";
    private static final String CONFIGFILE= "/config.properties";

    public static int getExplicitWait() {
        return EXPLICITWAIT;
    }

    public static String getConfigFile() {
        return CONFIGFILE;
    }

    public static String getConfigPath() {
        return CONFIGPATH;
    }

    public static String getResourcePath() {
        return RESOURCESPATH;
    }

}