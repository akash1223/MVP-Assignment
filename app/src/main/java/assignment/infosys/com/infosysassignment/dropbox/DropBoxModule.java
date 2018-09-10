package assignment.infosys.com.infosysassignment.dropbox;


import javax.inject.Singleton;

import assignment.infosys.com.infosysassignment.http.HttpApi;
import dagger.Module;
import dagger.Provides;

/**
 * Created by user on 03-Mar-18.
 */
@Module
public class DropBoxModule {
    @Provides
    public DropBoxContractMVP.Presenter provideTopDropBoxPresenter(DropBoxContractMVP.Model topMoviesModel) {
        return new DropBoxPresenter(topMoviesModel);
    }

    @Provides
    public DropBoxContractMVP.Model provideDropBoxModel(Repository repository) {
        return new DropBoxModel(repository);
    }

    @Singleton
    @Provides
    public Repository provideRepo(HttpApi mHttpApi) {
        return new DropBoxRepository(mHttpApi);
    }

}
