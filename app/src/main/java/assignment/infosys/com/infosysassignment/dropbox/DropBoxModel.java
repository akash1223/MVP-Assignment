package assignment.infosys.com.infosysassignment.dropbox;


/**
 * Created by user on 03-Mar-18.
 */
import android.util.Log;


import assignment.infosys.com.infosysassignment.apimodel.Facts;
import rx.Observable;
import rx.functions.Func2;

public class DropBoxModel implements DropBoxContractMVP.Model{

    private Repository repository;

    public DropBoxModel(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<Facts> result() {
        return repository.getFactsFromNetwork();
    }
}
