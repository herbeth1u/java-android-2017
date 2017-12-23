package work.beltran.kotlinandroidmvp.api;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import work.beltran.kotlinandroidmvp.model.Repo;

public interface GithubService {
    @GET("users/{user}/repos")
    Single<List<Repo>> listRepos(@Path("user") String user);
}