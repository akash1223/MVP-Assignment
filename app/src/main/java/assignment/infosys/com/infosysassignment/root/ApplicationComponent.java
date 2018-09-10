package assignment.infosys.com.infosysassignment.root;


import javax.inject.Singleton;

import assignment.infosys.com.infosysassignment.http.ApiModule;
import dagger.Component;

@Singleton
@Component(modules = { ApiModule.class})
public interface ApplicationComponent {

    void inject(BaseActivity target);


}
