package work.beltran.kotlinandroidmvp.di;

import javax.inject.Singleton;

import dagger.Component;
import work.beltran.kotlinandroidmvp.ui.MainActivity;

@Singleton
@Component(modules = {GithubModule.class, RxModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);
}