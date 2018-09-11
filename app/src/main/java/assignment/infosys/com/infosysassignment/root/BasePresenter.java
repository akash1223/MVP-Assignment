package assignment.infosys.com.infosysassignment.root;

import assignment.infosys.com.infosysassignment.dropbox.DropBoxContractMVP;

public interface BasePresenter {
    boolean loaddata(boolean isRefrsh);
    void rxUnsubscribe();
    void setView(BaseView view);
}
