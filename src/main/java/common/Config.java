package common;

import constants.Constant;

public class Config {
    public static final String PLATFORM_AND_BROWSER = "win_chrome";

    //clear browser cookies after each iteration
    public static final Boolean CLEAR_COOKIES_AND_STORAGE = true;

    //To keep the browser open after suite
    //If true - browser close
    public static final Boolean HOLD_BROWSER_OPEN = true;

    // Передается название страницы "regres" или "test"
    public static final String TEST_URL = "test";

}