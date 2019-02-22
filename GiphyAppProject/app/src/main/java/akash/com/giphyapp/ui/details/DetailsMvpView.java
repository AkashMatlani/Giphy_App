package akash.com.giphyapp.ui.details;

import akash.com.giphyapp.ui.base.MvpView;

public interface DetailsMvpView  extends MvpView {
    void doThumbsUp();

    void doThumbsDown();

    void getReviews();
}
