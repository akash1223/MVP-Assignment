package assignment.infosys.com.infosysassignment.root;

import android.app.Application;
import android.content.Context;

import assignment.infosys.com.infosysassignment.http.ApiModule;

/**
 * Created by user on 03-Mar-18.
 */

public class BaseApplication extends Application {




    private static Context appContext;
    public static BaseApplication mInstance;
    private ApplicationComponent component;
    public static BaseApplication getInstance() {
        if (mInstance == null) {
            mInstance = new BaseApplication();
        }
        return mInstance;
    }



    public static Context getBaseApplicationContext() {
        return appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appContext = getApplicationContext();
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .apiModule(new ApiModule())
                .build();

       /* Picasso.Builder builder = new Picasso.Builder(this);
        builder.downloader(new OkHttpDownloader(this, Integer.MAX_VALUE));
        Picasso built = builder.build();
        built.setIndicatorsEnabled(true);
        built.setLoggingEnabled(true);
        Picasso.setSingletonInstance(built);*/
    }
    public ApplicationComponent getComponent() {
        return component;
    }

}
