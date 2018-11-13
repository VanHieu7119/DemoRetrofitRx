package music_39.framgia.com.demoretrofitrx;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private HeroAdapter mHeroAdapter;
    private RecyclerView mRecyclerView;
    private ProgressDialog mProgressDialog;
    private CompositeDisposable mCompositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        getData();
    }

    @Override
    protected void onDestroy() {
        mCompositeDisposable.clear();
        super.onDestroy();
    }

    private void initView() {
        mCompositeDisposable = new CompositeDisposable();
        mRecyclerView = findViewById(R.id.recyclerView_Heroes);
        mHeroAdapter = new HeroAdapter(this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mHeroAdapter);
        mProgressDialog = new ProgressDialog(this);
    }

    private void getData() {
        mProgressDialog.show();
        API service = ServiceGenerator.createService(API.class);
        Disposable disposable = service.getHeroes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Hero>>() {
                    @Override
                    public void accept(List<Hero> heroes) {
                        mHeroAdapter.updateAdapter(heroes);
                        mProgressDialog.dismiss();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
        mCompositeDisposable.add(disposable);

    }
}
