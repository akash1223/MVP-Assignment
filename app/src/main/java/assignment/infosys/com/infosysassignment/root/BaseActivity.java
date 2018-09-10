package assignment.infosys.com.infosysassignment.root;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.FrameLayout;

import assignment.infosys.com.infosysassignment.R;
import assignment.infosys.com.infosysassignment.custom_control.CustLoader;
import assignment.infosys.com.infosysassignment.http.HttpApi;


public abstract class BaseActivity extends AppCompatActivity implements IFragmentCallback {


    protected Fragment currentFrag;
    private static final String SHARED_PREFS = "APP_PREFS";
    protected HttpApi networkApiCall;
    public static float dpToPx(Context context, float valueInDp) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, valueInDp, metrics);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     }

    protected SharedPreferences getMyPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        return sharedPreferences;
    }



    protected void loadFragment(Fragment fragment, String tag, boolean addToBackStack, boolean animate) {
        loadFragment(getSupportFragmentManager(), fragment, tag, addToBackStack, R.id.fl_container, false, animate);
    }



    protected void  loadFragment(final FragmentManager fragmentManager, final Fragment fragment, final String tag, final boolean addToBackStack, final int containerId, final boolean clearBackstack, final boolean animate) {
        new Handler().post(new Runnable() {

            public void run() {


                try {

                 if (clearBackstack)
                        clearBackStackInclusive();

                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    if (addToBackStack)
                        transaction.addToBackStack(tag);
                    if (animate)
                        transaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right, R.anim.slide_in_right, R.anim.slide_out_left);
                    transaction.replace(containerId, fragment, tag)
                            .commit();
                    currentFrag = fragment;
                    fragmentManager.executePendingTransactions();
                } catch (Exception ex) {
                     String str=ex+"";
                }

            }
        });
    }



    public void clearBackStackInclusive() {
        boolean mIsInfalting = false;
        try {
            if (!mIsInfalting) {
                FragmentManager fm = getSupportFragmentManager();
                int backStackEntryCount = fm.getBackStackEntryCount();
                if (backStackEntryCount > 0) {
                    fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    FrameLayout holder = (FrameLayout) findViewById(R.id.fl_container);
                    FragmentTransaction trans = fm.beginTransaction();
                    for (Fragment fragment : getSupportFragmentManager().getFragments()) {
                        if (fragment != null) trans.remove(fragment);
                    }
                    trans.commit();
                    holder.removeAllViews();
                }
            }
        } catch (Exception ex) {
        }
    }



}
