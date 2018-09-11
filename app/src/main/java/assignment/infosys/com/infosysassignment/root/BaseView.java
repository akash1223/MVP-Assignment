package assignment.infosys.com.infosysassignment.root;

import android.content.Context;
import android.support.annotation.StringRes;

public interface BaseView {
    void showProgressIndicator(boolean show);
    void makeToast(@StringRes int message);
    void showSnackBar(String s);
    Context getViewContext();
}
