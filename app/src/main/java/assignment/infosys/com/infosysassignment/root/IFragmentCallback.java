package assignment.infosys.com.infosysassignment.root;

import android.app.Fragment;
import android.os.Bundle;

public interface IFragmentCallback {

    void onDataReceivedFromFragment(Bundle bundle);
    void toolbarTitle(String title);

}
