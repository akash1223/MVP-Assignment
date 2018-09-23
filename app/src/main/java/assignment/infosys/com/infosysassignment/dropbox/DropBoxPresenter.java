package assignment.infosys.com.infosysassignment.dropbox;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import assignment.infosys.com.infosysassignment.R;
import assignment.infosys.com.infosysassignment.apimodel.Facts;
import assignment.infosys.com.infosysassignment.http.Internet;
import assignment.infosys.com.infosysassignment.root.BaseView;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by user on 10-Set-18.
 */

public class DropBoxPresenter implements DropBoxContractMVP.Presenter {

    private DropBoxContractMVP.View view;
    private Subscription subscription = null;
    private DropBoxContractMVP.Model model;

    public DropBoxPresenter(DropBoxContractMVP.Model model) {
        this.model = model;
    }

    @Override
    public boolean loaddata(boolean isRefresh) {
        if (!Internet.isNetworkAvailable(view.getViewContext())) {
            if (view != null) {
                view.makeToast(R.string.no_internet);
                view.ErrorInDataLoad();
            }
            return false;
        }
        try {
            subscription = model.result().subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(() -> {
                        if (!isRefresh)
                            view.showProgressIndicator(true);
                    })
                    .subscribe(new Observer<Facts>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            e.printStackTrace();
                            if (view != null) {
                                view.showSnackBar("Error getting Data");
                                view.ErrorInDataLoad();
                            }
                        }

                        @Override
                        public void onNext(Facts facts) {
                            if (view != null) {
                                view.updateActionbar(facts.getTitle());
                                filterData(facts.getData());

                            }
                        }
                    });
            return true;
        } catch (Exception ex) {
            view.ErrorInDataLoad();
            return false;
        }

    }


    public boolean filterData(List<Facts.Data> mListData) {
        try {
            List<Facts.Data> mList = new ArrayList<>();
            Observable.from(mListData)
                    .filter(data -> data.getTitle() != null && !data.getTitle().equals(""))
                    .subscribe(new Observer<Facts.Data>() {
                        @Override
                        public void onCompleted() {
                            view.showProgressIndicator(false);
                            view.updateList(mList);
                        }

                        @Override
                        public void onError(Throwable e) {
                            if (view != null)
                                view.showSnackBar("Error in data load");
                        }

                        @Override
                        public void onNext(Facts.Data data) {
                            mList.add(data);
                        }
                    });
            return true;
        } catch (Exception ex) {
            return false;
        }

    }

    @Override
    public void rxUnsubscribe() {
        if (subscription != null) {
            if (!subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }
        }
    }

    @Override
    public void setView(BaseView view) {
        this.view = (DropBoxContractMVP.View) view;
    }
}
