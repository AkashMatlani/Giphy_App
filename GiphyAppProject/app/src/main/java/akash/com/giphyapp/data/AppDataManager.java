package akash.com.giphyapp.data;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import akash.com.giphyapp.data.model.MainResponse;
import akash.com.giphyapp.data.network.ApiHeader;
import akash.com.giphyapp.data.network.ApiHelper;
import akash.com.giphyapp.di.ApplicationContext;
import io.reactivex.Single;

@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          ApiHelper apiHelper) {
        mContext = context;
        mApiHelper = apiHelper;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHelper.getApiHeader();
    }

    @Override
    public Single<MainResponse> getBlogApiCall(String keyWord) {
        return mApiHelper.getBlogApiCall(keyWord);
    }

    @Override
    public void updateApiHeader(Long userId, String accessToken) {
//        mApiHelper.getApiHeader().getProtectedApiHeader().setUserId(userId);
//        mApiHelper.getApiHeader().getProtectedApiHeader().setAccessToken(accessToken);
    }

}

