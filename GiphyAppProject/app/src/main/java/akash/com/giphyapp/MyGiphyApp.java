package akash.com.giphyapp;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;

import javax.inject.Inject;
import akash.com.giphyapp.data.DataManager;
import akash.com.giphyapp.data.model.MyObjectBox;
import akash.com.giphyapp.di.component.ApplicationComponent;
import akash.com.giphyapp.di.component.DaggerApplicationComponent;
import akash.com.giphyapp.di.module.ApplicationModule;
import akash.com.giphyapp.utills.AppLogger;
import io.objectbox.BoxStore;

public class MyGiphyApp  extends Application {
    @Inject
    DataManager mDataManager;

    private BoxStore boxStore;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

        AppLogger.init();

        AndroidNetworking.initialize(getApplicationContext());
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
        }

        boxStore = MyObjectBox.builder().androidContext(MyGiphyApp.this).build();
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

    public BoxStore getBoxStore() {
        return boxStore;
    }
}




