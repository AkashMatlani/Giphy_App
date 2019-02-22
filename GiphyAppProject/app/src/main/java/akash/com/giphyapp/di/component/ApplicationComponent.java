package akash.com.giphyapp.di.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import akash.com.giphyapp.MyGiphyApp;
import akash.com.giphyapp.data.DataManager;
import akash.com.giphyapp.di.ApplicationContext;
import akash.com.giphyapp.di.module.ApplicationModule;
import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(MyGiphyApp app);

    //void inject(SyncService service);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}
