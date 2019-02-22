package akash.com.giphyapp.ui.main;

import java.util.List;

import akash.com.giphyapp.data.model.MainResponse;
import akash.com.giphyapp.ui.base.MvpView;

public interface MainMvpView extends MvpView {

    void updateAdapter(List<MainResponse.DataInner> blogList);

}
