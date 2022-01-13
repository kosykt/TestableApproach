package com.example.testableapproach.data

import com.example.testableapproach.data.repositories.NetworkRepository
import com.example.testableapproach.domain.DomainRepository
import com.example.testableapproach.domain.model.DomainUsersModel

class DomainRepositoryImpl(
    private val networkRepository: NetworkRepository
) : DomainRepository {

    override fun get(): List<DomainUsersModel> {
        return networkRepository.getUsersFromNetwork().map {
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
    }

}