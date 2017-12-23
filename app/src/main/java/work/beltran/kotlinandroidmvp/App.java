package work.beltran.kotlinandroidmvp;

import android.app.Application;

import work.beltran.kotlinandroidmvp.di.AppComponent;
import work.beltran.kotlinandroidmvp.di.DaggerAppComponent;

public class App extends Application {
    public AppComponent appComponent;
    private static App instance;

    public static App get() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appComponent = DaggerAppComponent.create();
    }
}