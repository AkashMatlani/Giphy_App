package akash.com.giphyapp.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import akash.com.giphyapp.data.model.MainResponse;
import akash.com.giphyapp.di.ActivityContext;
import akash.com.giphyapp.di.PerActivity;
import akash.com.giphyapp.ui.details.DetailsMvpPresenter;
import akash.com.giphyapp.ui.details.DetailsMvpView;
import akash.com.giphyapp.ui.details.DetailsPresenter;
import akash.com.giphyapp.ui.main.GiphyListAdapter;
import akash.com.giphyapp.ui.main.MainMvpPresenter;
import akash.com.giphyapp.ui.main.MainMvpView;
import akash.com.giphyapp.ui.main.MainPresenter;
import akash.com.giphyapp.ui.splash.SplashMvpPresenter;
import akash.com.giphyapp.ui.splash.SplashMvpView;
import akash.com.giphyapp.ui.splash.SplashPresenter;
import akash.com.giphyapp.utills.rx.AppSchedulerProvider;
import akash.com.giphyapp.utills.rx.SchedulerProvider;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {
    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(
            SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    DetailsMvpPresenter<DetailsMvpView> provideDetailsPresenter(
            DetailsPresenter<DetailsMvpView> presenter) {
        return presenter;
    }

    @Provides
    GiphyListAdapter provideBlogAdapter() {
        return new GiphyListAdapter(new ArrayList<MainResponse.DataInner>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }
}

