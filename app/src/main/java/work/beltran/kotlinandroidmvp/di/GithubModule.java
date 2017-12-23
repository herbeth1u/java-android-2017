package work.beltran.kotlinandroidmvp.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import work.beltran.kotlinandroidmvp.api.GithubService;

@Module
class GithubModule {
    @Provides
    @Singleton
    Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    GithubService githubService(Retrofit retrofit) {
        return retrofit.create(GithubService.class);
    }
}