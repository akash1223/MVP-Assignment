package assignment.infosys.com.infosysassignment.dropbox;

import assignment.infosys.com.infosysassignment.apimodel.Facts;
import assignment.infosys.com.infosysassignment.http.HttpApi;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class DropBoxRepository implements Repository {


    HttpApi mHttpApi;
    public DropBoxRepository()
    {

    }

    @Override
    public Observable<Facts> getFactsFromNetwork() {
        Observable<Facts> dropBoxObservable = mHttpApi.getFacts();

        return dropBoxObservable;
    }
}
