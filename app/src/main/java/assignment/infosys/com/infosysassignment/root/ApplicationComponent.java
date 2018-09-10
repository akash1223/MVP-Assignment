package assignment.infosys.com.infosysassignment.root;


import javax.inject.Singleton;

import assignment.infosys.com.infosysassignment.dropbox.DropBoxModule;
import assignment.infosys.com.infosysassignment.dropbox.FragmentDropBox;
import assignment.infosys.com.infosysassignment.http.ApiModule;
import dagger.Component;

@Singleton
@Component(modules = { ApplicationModule.class,ApiModule.class, DropBoxModule.class})
public interface ApplicationComponent {

    void inject(BaseFragment target);
    void inject(FragmentDropBox target);
}
