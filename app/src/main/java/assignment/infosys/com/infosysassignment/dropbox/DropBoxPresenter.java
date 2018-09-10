package assignment.infosys.com.infosysassignment.dropbox;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import assignment.infosys.com.infosysassignment.apimodel.Facts;
import assignment.infosys.com.infosysassignment.root.BaseView;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by user on 03-Mar-18.
 */

public class DropBoxPresenter implements DropBoxContractMVP.Presenter {

    private DropBoxContractMVP.View view;
    private Subscription subscription = null;
    private DropBoxContractMVP.Model model;

    public DropBoxPresenter(DropBoxContractMVP.Model model) {
        this.model = model;
    }

    @Override
    public void loaddata() {
        view.showProgressIndicator(true);
        subscription = model.result().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Facts>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        if (view != null) {
                            view.showSnackBar("Error getting movies");
                        }
                    }

                    @Override
                    public void onNext(Facts facts) {
                        if (view != null) {
                            view.updateActionbar(facts.getTitle());
                            List<Facts.Data> mList=new ArrayList<>();
                            Observable.from(facts.getData())
                                    .filter(data -> data.getTitle() != null && !data.getTitle().equals(""))
                                    .subscribe(new Observer<Facts.Data>() {
                                        @Override
                                        public void onCompleted() {
                                            view.showProgressIndicator(false);
                                            view.updateList(mList);
                                        }

                                        @Override
                                        public void onError(Throwable e) {

                                        }

                                        @Override
                                        public void onNext(Facts.Data data) {
                                            mList.add(data);
                                        }
                                    });

                        }
                    }
                });
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
