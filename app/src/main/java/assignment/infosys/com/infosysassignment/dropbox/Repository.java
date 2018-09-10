package assignment.infosys.com.infosysassignment.dropbox;



import assignment.infosys.com.infosysassignment.apimodel.Facts;
import rx.Observable;

/**
 * Created by user on 03-Mar-18.
 */

public interface Repository {
    Observable<Facts> getFactsFromNetwork();

}
