package be.vergauwen.simon.androidgradlejacoco.core.service

import be.vergauwen.simon.androidgradlejacoco.core.model.GitHubRepo
import retrofit2.http.GET
import rx.Observable

interface GithubAPI {

  @GET("/users/google/repos")
  fun getRepos(): Observable<List<GitHubRepo>>
}