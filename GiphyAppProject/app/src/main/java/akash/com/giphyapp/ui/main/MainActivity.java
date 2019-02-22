package akash.com.giphyapp.ui.main;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import akash.com.giphyapp.R;
import akash.com.giphyapp.data.model.MainResponse;
import akash.com.giphyapp.ui.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainMvpView  {

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @Inject
    GiphyListAdapter mBlogAdapter;

    @Inject
    LinearLayoutManager mLayoutManager;

    @BindView(R.id.blog_recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.searchEt)
    EditText searchEt;

    @BindView(R.id.onlineInput_)
    RelativeLayout onlineInput_;

    @BindView(R.id.offlineText_)
    TextView offlineText_;

    Gson gson;

    public static final String NoInterNet = "OFFLINE_GIF_DATA";
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        gson = new Gson();

        setUp();
    }

    @OnClick({R.id.searchBtn})
    void searchClick() {
        String search_ = searchEt.getText().toString().trim();
        if (search_.isEmpty()) {
            showMessage("Please enter Search Keyword.");
            return;
        }
        hideKeyboard();
        mPresenter.doSearch(search_);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDetach();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpInterNet();
    }

    @Override
    protected void setUp() {
        pref = getApplicationContext().getSharedPreferences(NoInterNet, MODE_PRIVATE);
        editor = pref.edit();

        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mBlogAdapter);
    }

    private void setUpInterNet() {
        if (isNetworkConnected()) {
            offlineText_.setVisibility(View.GONE);
            onlineInput_.setVisibility(View.VISIBLE);
        } else {
            offlineText_.setVisibility(View.VISIBLE);
            onlineInput_.setVisibility(View.GONE);
            setOfflineView();
        }
    }

    private void setOfflineView() {
        String listGIF = pref.getString("offline_data", "[]");
        ArrayList<MainResponse.DataInner> dataInner = new ArrayList<>();
        MainResponse.DataInner[] response = gson.fromJson(listGIF, MainResponse.DataInner[].class);
        Collections.addAll(dataInner, response);
        updateAdapter(dataInner);
    }

    @Override
    public void updateAdapter(List<MainResponse.DataInner> blogList) {
        mBlogAdapter.clearData();
        mBlogAdapter.addItems(blogList);

        String listGIF = gson.toJson(blogList);
        editor.putString("offline_data", listGIF);
        editor.apply();
    }
}


