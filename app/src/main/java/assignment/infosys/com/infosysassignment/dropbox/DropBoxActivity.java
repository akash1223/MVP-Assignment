package assignment.infosys.com.infosysassignment.dropbox;

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
        FragmentDropBox fragmentDropBox=FragmentDropBox.newInstance();
        onFragmentLoadRequest(fragmentDropBox, "FragmentDropBox", false, true);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("DropBox");

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
