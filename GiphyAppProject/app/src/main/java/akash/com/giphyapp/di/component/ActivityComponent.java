package akash.com.giphyapp.di.component;

import akash.com.giphyapp.di.PerActivity;
import akash.com.giphyapp.di.module.ActivityModule;
import akash.com.giphyapp.ui.details.DetailsActivity;
import akash.com.giphyapp.ui.main.MainActivity;
import akash.com.giphyapp.ui.splash.SplashActivity;
import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(SplashActivity activity);

    void inject(MainActivity activity);

    void inject(DetailsActivity activity);
}
