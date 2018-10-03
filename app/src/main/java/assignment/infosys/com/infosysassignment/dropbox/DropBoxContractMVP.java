package assignment.infosys.com.infosysassignment.dropbox;

import android.content.Context;
import android.support.annotation.StringRes;

import java.util.List;

import assignment.infosys.com.infosysassignment.apimodel.Facts;
import rx.Observable;

public class DropBoxContractMVP {

    public interface View
    {
        void updateActionbar(String title);
        void updateList(List<Facts.Data> mList);
        void ErrorInDataLoad();
        void showProgressIndicator(boolean show);
        void makeToast(@StringRes int message);
        void showSnackBar(String s);
        Context getViewContext();

    }
    public interface Presenter
    {
        boolean loaddata(boolean isRefrsh);
        void rxUnsubscribe();
        void setView(View view);
    }

}
