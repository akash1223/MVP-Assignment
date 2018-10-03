package assignment.infosys.com.infosysassignment.dropbox;


import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import assignment.infosys.com.infosysassignment.R;
import assignment.infosys.com.infosysassignment.root.IFragmentCallback;

public class DropBoxActivity extends AppCompatActivity implements IFragmentCallback {


    final  static String FRAGMENT_TAG="FragmentDropBox" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        FragmentDropBox mDropFragment = (FragmentDropBox) fm.findFragmentByTag(FRAGMENT_TAG);
        if(mDropFragment==null) {
            mDropFragment = FragmentDropBox.newInstance();
            mDropFragment= FragmentDropBox.newInstance();
            FragmentTransaction ft=fm.beginTransaction().add(R.id.fl_container,mDropFragment,FRAGMENT_TAG);
            ft.commit();
        }
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle(mDropFragment.actionBarTitle);

    }



    @Override
    public void onDataReceivedFromFragment(Bundle bundle) {

    }

      @Override
    public void toolbarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }


}
