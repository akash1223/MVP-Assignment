package assignment.infosys.com.infosysassignment.dropbox;


import javax.inject.Singleton;

import assignment.infosys.com.infosysassignment.http.HttpApi;
import dagger.Module;
import dagger.Provides;

/**
 * Created by user on 03-Mar-18.
 * Dagger implementation for MVP(model,view presenter) instance creation
 */
@Module
public class DropBoxDependencyInjection {
    @Provides
    public DropBoxContractMVP.Presenter provideTopDropBoxPresenter(DropBoxRepository dropRepository) {
        return new DropBoxPresenter(dropRepository);
    }

    @Singleton
    @Provides
    public DropBoxRepository provideRepo(HttpApi mHttpApi) {
        return new DropBoxRepository(mHttpApi);
    }

}
