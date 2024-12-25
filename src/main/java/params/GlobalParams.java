package params;


import lombok.Setter;

public class GlobalParams {
    //    private static ThreadLocal<String> browserName = new ThreadLocal<String>();
    @Setter
    private static String browserName = null;

    @Setter
    private static String environmentName = null;

//    public static void setBrowserName(String browser){
//        browserName.set(browser);
//    }

    public static String getBrowserName() {
        if (browserName != null)
            return browserName;
        else
            throw new RuntimeException("browser not specified in the testng.xml");
    }

    public static String getEnvironmentName() {
        if (environmentName != null)
            return environmentName;
        else
            throw new RuntimeException("Environment not specified in the testng.xml");
    }

//    public static String getBrowserName(){
//        return browserName.get();
//    }

//    public void initializeGlobalParams(){
//        setBrowserName("chrome");
//    }
}
