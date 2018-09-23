package assignment.infosys.com.infosysassignment.dropbox;

import android.app.FragmentManager;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import assignment.infosys.com.infosysassignment.R;
import assignment.infosys.com.infosysassignment.root.BaseActivity;
import assignment.infosys.com.infosysassignment.root.BaseFragment;

public class DropBoxActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        FragmentDropBox mDropFragment = (FragmentDropBox) fm.findFragmentByTag("FragmentDropBox");
        if(mDropFragment==null) {
            mDropFragment = FragmentDropBox.newInstance();
            onFragmentLoadRequest(mDropFragment, "FragmentDropBox", false, true);
        }
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle(mDropFragment.actionBarTitle);

    }


    @Override
    public void onFragmentLoadRequest(Fragment fragment, String tag, boolean addToBackStack, boolean animate) {
        loadFragment(fragment, tag, addToBackStack, animate);
    }

    @Override
    public void onDataReceivedFromFragment(Bundle bundle) {

    }

      @Override
    public void toolbarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }


}
