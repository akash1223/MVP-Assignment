package assignment.infosys.com.infosysassignment.dropbox;

import assignment.infosys.com.infosysassignment.apimodel.Facts;
import assignment.infosys.com.infosysassignment.root.BasePresenter;
import assignment.infosys.com.infosysassignment.root.BaseView;
import rx.Observable;

public class DropBoxContractMVP {

    interface View extends BaseView
    {
        void updateData(Facts viewModel);

    }
    interface Presenter extends BasePresenter
    {

    }
    interface Model
    {
        Observable<Facts> result();
    }
}
