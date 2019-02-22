package akash.com.giphyapp.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import akash.com.giphyapp.BuildConfig;
import akash.com.giphyapp.data.AppDataManager;
import akash.com.giphyapp.data.DataManager;
import akash.com.giphyapp.data.network.ApiHeader;
import akash.com.giphyapp.data.network.ApiHelper;
import akash.com.giphyapp.data.network.AppApiHelper;
import akash.com.giphyapp.di.ApiInfo;
import akash.com.giphyapp.di.ApplicationContext;
import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey) {
        return new ApiHeader.ProtectedApiHeader(apiKey);
    }
}


