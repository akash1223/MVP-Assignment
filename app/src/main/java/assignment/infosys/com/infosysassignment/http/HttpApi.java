package assignment.infosys.com.infosysassignment.http;



import assignment.infosys.com.infosysassignment.apimodel.Facts;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


/**
 * Created by dell on 22-Apr-18.
 */

public interface HttpApi {

    String BASE_ENDPOINT="https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/";

    @GET("facts.json")
    Observable<Facts> getFacts();

}
