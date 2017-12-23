package work.beltran.kotlinandroidmvp.di;

import io.reactivex.Scheduler;

public interface Schedulers {
    Scheduler io();

    Scheduler ui();
}