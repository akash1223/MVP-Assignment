package assignment.infosys.com.infosysassignment;

import android.app.Application;
import android.content.Context;

/**
 * Created by user on 03-Mar-18.
 */

public class BaseApplication extends Application {


    private BaseActivity mCurrentActivity;

    private static Context appContext;
    public static BaseApplication mInstance;

    public static BaseApplication getInstance() {
        if (mInstance == null) {
            mInstance = new BaseApplication();
        }
        return mInstance;
    }

    public void setCurrentActivity(BaseActivity baseActivity) {
        mCurrentActivity = baseActivity;
    }

    public static Context getBaseApplicationContext() {
        return appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appContext = getApplicationContext();

    }


}
