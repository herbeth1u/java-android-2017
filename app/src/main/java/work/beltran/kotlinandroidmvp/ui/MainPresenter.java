package work.beltran.kotlinandroidmvp.ui;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import work.beltran.kotlinandroidmvp.api.GithubService;
import work.beltran.kotlinandroidmvp.di.Schedulers;
import work.beltran.kotlinandroidmvp.model.Repo;

class MainPresenter {
    private GithubService githubService;
    private Schedulers schedulers;
    private MainView view;
    private CompositeDisposable composite = new CompositeDisposable();

    @Inject
    MainPresenter(GithubService githubService, Schedulers schedulers) {
        this.githubService = githubService;
        this.schedulers = schedulers;
    }

    void attachView(MainView view) {
        this.view = view;
    }

    void loadRepos() {
        composite.add(githubService.listRepos("herbeth1u")
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
                .doOnSubscribe(disposable -> view.showLoading(true))
                .doFinally(() -> view.showLoading(false))
                .subscribe(this::onNext, this::onError));
    }

    private void onNext(List<Repo> list) {
        view.hideError();
        view.showList(list);
    }

    private void onError(Throwable throwable) {
        view.showError(throwable.getLocalizedMessage());
    }

    void detachView() {
        composite.clear();
        this.view = null;
    }
}