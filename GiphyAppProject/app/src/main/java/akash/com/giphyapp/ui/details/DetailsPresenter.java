package akash.com.giphyapp.ui.details;

import javax.inject.Inject;

import akash.com.giphyapp.data.DataManager;
import akash.com.giphyapp.data.model.ReviewModel;
import akash.com.giphyapp.ui.base.BasePresenter;
import akash.com.giphyapp.utills.rx.SchedulerProvider;
import io.objectbox.Box;
import io.reactivex.disposables.CompositeDisposable;

public class DetailsPresenter<V extends DetailsMvpView> extends BasePresenter<V>
        implements DetailsMvpPresenter<V> {

    private static final String TAG = "MainPresenter";

    @Inject
    public DetailsPresenter(DataManager dataManager, SchedulerProvider schedulerProvider,
                            CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void updateTextCount(long id, int upV, int dnV, String vidId) {
        Box<ReviewModel> voteBox = getMvpView().getBox().boxFor(ReviewModel.class);

        ReviewModel rm = new ReviewModel();
        rm.setId(id);
        rm.setGifId(vidId);
        rm.setThumbUp(upV);
        rm.setThumbDown(dnV);
        voteBox.put(rm);

// //     IF WANT TO ADD ONLY ONE UP/DOWN VOTE FOR GIF
//        if (isUp) {
//            rm.setThumbDown(0);
//            rm.setThumbUp(1);
//        } else {
//            rm.setThumbDown(1);
//            rm.setThumbUp(0);
//        }

        getMvpView().getReviews();
    }
}