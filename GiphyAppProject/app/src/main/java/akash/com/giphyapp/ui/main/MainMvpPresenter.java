package akash.com.giphyapp.ui.main;

import akash.com.giphyapp.di.PerActivity;
import akash.com.giphyapp.ui.base.MvpPresenter;

@PerActivity
public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    void doSearch(String keyWord);

}