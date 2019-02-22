package akash.com.giphyapp.data.network;

import akash.com.giphyapp.data.model.MainResponse;
import io.reactivex.Single;

public interface ApiHelper {
    ApiHeader getApiHeader();

    Single<MainResponse> getBlogApiCall(String keyWord);
}
