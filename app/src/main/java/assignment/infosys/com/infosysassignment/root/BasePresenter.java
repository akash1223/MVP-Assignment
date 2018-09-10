package assignment.infosys.com.infosysassignment.root;

import assignment.infosys.com.infosysassignment.dropbox.DropBoxContractMVP;

public interface BasePresenter {
    void loaddata();
    void rxUnsubscribe();
    void setView(BaseView view);
}
