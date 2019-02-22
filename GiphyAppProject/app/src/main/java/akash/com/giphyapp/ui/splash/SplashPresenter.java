package akash.com.giphyapp.ui.splash;

import javax.inject.Inject;

import akash.com.giphyapp.data.DataManager;
import akash.com.giphyapp.ui.base.BasePresenter;
import akash.com.giphyapp.utills.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

public class SplashPresenter<V extends SplashMvpView> extends BasePresenter<V>
        implements SplashMvpPresenter<V> {

    @Inject
    public SplashPresenter(DataManager dataManager, SchedulerProvider schedulerProvider,
                           CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);

        getMvpView().openMainActivity();
    }
}

