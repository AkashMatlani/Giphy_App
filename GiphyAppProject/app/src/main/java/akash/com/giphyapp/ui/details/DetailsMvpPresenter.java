package akash.com.giphyapp.ui.details;

import akash.com.giphyapp.ui.base.MvpPresenter;

public interface DetailsMvpPresenter<V extends DetailsMvpView> extends MvpPresenter<V> {

    void updateTextCount(long id, int upV, int dnV, String vidId);

}
