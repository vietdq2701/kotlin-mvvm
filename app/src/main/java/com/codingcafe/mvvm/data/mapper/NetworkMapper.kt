package com.codingcafe.mvvm.data.mapper

import com.codingcafe.mvvm.data.model.Blog
import com.codingcafe.mvvm.data.response.BlogNetworkResponse
import com.codingcafe.mvvm.util.EntityMapper
import javax.inject.Inject

class NetworkMapper
@Inject
constructor() : EntityMapper<BlogNetworkResponse, Blog> {

    override fun mapFromEntity(entity: BlogNetworkResponse): Blog {
        return Blog(
            id = entity.id,
            title = entity.title,
            body = entity.body,
            image = entity.image,
            category = entity.category
        )
    }

    override fun mapToEntity(domainModel: Blog): BlogNetworkResponse {
        return BlogNetworkResponse(
            id = domainModel.id,
            title = domainModel.title,
            body = domainModel.body,
            image = domainModel.image,
            category = domainModel.category
        )
    }

    fun mapFromEntityList(responses: List<BlogNetworkResponse>): List<Blog> {
        return responses.map { mapFromEntity(it) }
    }

}
