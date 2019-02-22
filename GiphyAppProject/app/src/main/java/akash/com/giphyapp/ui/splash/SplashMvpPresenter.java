package akash.com.giphyapp.ui.splash;

import akash.com.giphyapp.di.PerActivity;
import akash.com.giphyapp.ui.base.MvpPresenter;

@PerActivity
public interface SplashMvpPresenter<V extends SplashMvpView> extends MvpPresenter<V> {
}
