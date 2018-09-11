package assignment.infosys.com.infosysassignment.dropbox;

import java.util.List;

import assignment.infosys.com.infosysassignment.apimodel.Facts;
import assignment.infosys.com.infosysassignment.root.BasePresenter;
import assignment.infosys.com.infosysassignment.root.BaseView;
import rx.Observable;

public class DropBoxContractMVP {

    public interface View extends BaseView
    {
        void updateActionbar(String title);
        void updateList(List<Facts.Data> mList);
        void ErrorInDataLoad();

    }
    public interface Presenter extends BasePresenter
    {

    }
    public interface Model
    {
        Observable<Facts> result();
    }
}
