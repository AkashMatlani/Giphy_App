package akash.com.giphyapp.data.network;

import com.rx2androidnetworking.Rx2AndroidNetworking;

import javax.inject.Inject;
import javax.inject.Singleton;

import akash.com.giphyapp.data.model.MainResponse;
import io.reactivex.Single;

@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }

    @Override
    public Single<MainResponse> getBlogApiCall(String keyWord) {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_BLOG + keyWord)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectSingle(MainResponse.class);
    }

}


