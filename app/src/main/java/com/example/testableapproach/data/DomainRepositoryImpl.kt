package com.example.testableapproach.data

import com.example.testableapproach.data.repositories.DatabaseRepository
import com.example.testableapproach.data.repositories.NetworkRepository
import com.example.testableapproach.data.retrofit.model.GithubUsersDto
import com.example.testableapproach.data.roomdatabase.RoomModel
import com.example.testableapproach.domain.DomainRepository
import com.example.testableapproach.domain.model.DomainUsersModel

class DomainRepositoryImpl(
    private val networkRepository: NetworkRepository,
    private val databaseRepository: DatabaseRepository
) : DomainRepository {

    override suspend fun getFromNetwork(): List<DomainUsersModel> {
        val data = networkRepository.getUsersFromNetwork()
        databaseRepository.save(data.toRoomModel())
        return data.toDomainModel()
    }
}

fun List<GithubUsersDto>.toDomainModel() = this.map {
    DomainUsersModel(
        avatar_url = it.avatar_url,
        events_url = it.events_url,
        followers_url = it.followers_url,
        following_url = it.following_url,
        gists_url = it.gists_url,
        gravatar_id = it.gravatar_id,
        html_url = it.html_url,
        id = it.id,
        login = it.login,
        node_id = it.node_id,
        organizations_url = it.organizations_url,
        received_events_url = it.received_events_url,
        repos_url = it.repos_url,
        site_admin = it.site_admin,
        starred_url = it.starred_url,
        subscriptions_url = it.subscriptions_url,
        type = it.type,
        url = it.url,
    )
}

fun List<GithubUsersDto>.toRoomModel() = this.map {
    RoomModel(
        id = it.id,
        avatar_url = it.avatar_url,
        events_url = it.events_url,
        followers_url = it.followers_url,
        following_url = it.following_url,
        gists_url = it.gists_url,
        gravatar_id = it.gravatar_id,
        html_url = it.html_url,
        login = it.login,
        node_id = it.node_id,
        organizations_url = it.organizations_url,
        received_events_url = it.received_events_url,
        repos_url = it.repos_url,
        site_admin = it.site_admin,
        starred_url = it.starred_url,
        subscriptions_url = it.subscriptions_url,
        type = it.type,
        url = it.url,
    )
}