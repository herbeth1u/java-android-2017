package work.beltran.kotlinandroidmvp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import work.beltran.kotlinandroidmvp.App;
import work.beltran.kotlinandroidmvp.R;
import work.beltran.kotlinandroidmvp.model.Repo;

public class MainActivity extends AppCompatActivity implements MainView {
    @Inject
    protected MainPresenter presenter;

    @BindView(R.id.textError) TextView textError;
    @BindView(R.id.progressBar) ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.setDebug(true);
        ButterKnife.bind(this);
        App.get().appComponent.inject(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.attachView(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.loadRepos();
    }

    @Override
    public void onStop() {
        presenter.detachView();
        super.onStop();
    }

    @Override
    public void showError(String localizedMessage) {
        textError.setText(localizedMessage);
        textError.setVisibility(View.VISIBLE);
    }

    @Override
    public void showList(List<Repo> it) {
        Log.e("D", it.toString());
    }

    @Override
    public void showLoading(boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void hideError() {
        textError.setVisibility(View.GONE);
    }
}

