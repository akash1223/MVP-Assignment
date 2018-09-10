package assignment.infosys.com.infosysassignment.root;

import android.os.Bundle;
import android.support.v4.app.Fragment;


/**
 * Created by user on 03-Mar-18.
 */


public interface IFragmentCallback {
    void onFragmentLoadRequest(Fragment fragment, String tag, boolean addToBackStack, boolean animate);

    void onDataReceivedFromFragment(Bundle bundle);

    void toolbarTitle(String title);

}
