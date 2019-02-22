package akash.com.giphyapp.data;

import akash.com.giphyapp.data.network.ApiHelper;

public interface DataManager extends ApiHelper {

    void updateApiHeader(Long userId, String accessToken);
}