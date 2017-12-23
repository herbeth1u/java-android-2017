package work.beltran.kotlinandroidmvp.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

@Module
class RxModule {
    @Provides
    @Singleton
    Schedulers schedulers() {
        return new Schedulers() {
            @Override
            public Scheduler io() {
                return io.reactivex.schedulers.Schedulers.io();
            }

            @Override
            public Scheduler ui() {
                return AndroidSchedulers.mainThread();
            }
        };
    }
}