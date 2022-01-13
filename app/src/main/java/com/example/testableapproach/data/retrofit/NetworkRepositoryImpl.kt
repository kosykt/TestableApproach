package com.example.testableapproach.data.retrofit

import com.example.testableapproach.data.repositories.NetworkRepository
import com.example.testableapproach.data.retrofit.model.GithubUsersDto
import com.example.testableapproach.data.retrofit.model.GithubUsersDtoItem

class NetworkRepositoryImpl(private val retrofitService: RetrofitService): NetworkRepository {

    override fun getUsersFromNetwork(): GithubUsersDto {
        val v = GithubUsersDto()
        val a = GithubUsersDtoItem(
            avatar_url = "avatar_url",
            events_url = "events_url",
            followers_url = "followers_url",
            following_url = "following_url",
            gists_url = "gists_url",
            gravatar_id = "gravatar_id",
            html_url = "html_url",
            id = 1,
            login = "login",
            node_id = "node_id",
            organizations_url = "organizations_url",
            received_events_url = "received_events_url",
            repos_url = "repos_url",
            site_admin = false,
            starred_url = "starred_url",
            subscriptions_url = "subscriptions_url",
            type = "type",
            url = "url",
        )
        v.add(a)
        v.add(a)
        v.add(a)
        return v
    }
}