package work.beltran.kotlinandroidmvp.ui;

import java.util.List;

import work.beltran.kotlinandroidmvp.model.Repo;

interface MainView {
    void showError(String localizedMessage);
    void  showList(List<Repo> it);
    void  showLoading(boolean show);
    void  hideError();
}