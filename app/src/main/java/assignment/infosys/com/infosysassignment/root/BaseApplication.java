package assignment.infosys.com.infosysassignment.root;

import android.app.Application;
import android.content.Context;

import assignment.infosys.com.infosysassignment.http.ApiModule;

/**
 * Created by user on 03-Mar-18.
 */

public class BaseApplication extends Application {


    private BaseActivity mCurrentActivity;

    private static Context appContext;
    public static BaseApplication mInstance;
    private ApplicationComponent component;
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
        component = DaggerApplicationComponent.builder()
                .apiModule(new ApiModule())
                .build();
    }


}
