@file:Suppress("unused")

package com.chrynan.markup.model

sealed class Source(val uniqueId: String) {

    interface CommonSource {

        val authors: List<Person>
        val publisher: Publisher?
        val publicationDate: Long?
        val publishingPlace: String?
    }

    interface WrittenSource {

        val edition: Int?
        val volume: Int?
        val startPage: Int?
        val endPage: Int?
        val startLine: Int?
        val endLine: Int?
    }

    interface OnlineSource {

        val url: String
        val editors: List<Person>
        val retrievedDate: Long?
        val siteTitle: String?
    }

    interface UniqueSource {

        val articleId: String
    }

    interface PersonSource {

        val person: Person?
        val date: Long?
        val credentials: String?
        val communicationMethod: String?
    }

    interface AttributionAssociationSource {

        val hasConnectionToSource: Boolean?
        val sourceConnection: String?
        val disclosureStatement: String?
    }

    data class Book(
            val id: String,
            val title: String,
            override val authors: List<Person> = emptyList(),
            override val publicationDate: Long? = null,
            override val publisher: Publisher? = null,
            override val publishingPlace: String? = null,
            override val edition: Int? = null,
            override val volume: Int? = null,
            override val startPage: Int? = null,
            override val endPage: Int? = null,
            override val startLine: Int? = null,
            override val endLine: Int? = null,
            override val hasConnectionToSource: Boolean? = null,
            override val sourceConnection: String? = null,
            override val disclosureStatement: String? = null
    ) : Source(uniqueId = id),
            CommonSource,
            WrittenSource,
            AttributionAssociationSource

    data class Magazine(
            val id: String,
            val magazineName: String,
            val articleTitle: String? = null,
            override val authors: List<Person> = emptyList(),
            override val publicationDate: Long? = null,
            override val publisher: Publisher? = null,
            override val publishingPlace: String? = null,
            override val edition: Int? = null,
            override val volume: Int? = null,
            override val startPage: Int? = null,
            override val endPage: Int? = null,
            override val startLine: Int? = null,
            override val endLine: Int? = null,
            override val hasConnectionToSource: Boolean? = null,
            override val sourceConnection: String? = null,
            override val disclosureStatement: String? = null
    ) : Source(uniqueId = id),
            CommonSource,
            WrittenSource,
            AttributionAssociationSource

    data class Encyclopedia(
            val id: String,
            val encyclopediaName: String,
            val articleTitle: String? = null,
            override val authors: List<Person> = emptyList(),
            override val publisher: Publisher? = null,
            override val publicationDate: Long? = null,
            override val publishingPlace: String? = null,
            override val edition: Int? = null,
            override val volume: Int? = null,
            override val startPage: Int? = null,
            override val endPage: Int? = null,
            override val startLine: Int? = null,
            override val endLine: Int? = null,
            override val hasConnectionToSource: Boolean? = null,
            override val sourceConnection: String? = null,
            override val disclosureStatement: String? = null
    ) : Source(uniqueId = id),
            CommonSource,
            WrittenSource,
            AttributionAssociationSource

    data class Web(
            val id: String,
            val title: String,
            override val url: String,
            override val siteTitle: String? = null,
            override val editors: List<Person> = emptyList(),
            override val authors: List<Person> = emptyList(),
            override val publisher: Publisher? = null,
            override val publicationDate: Long? = null,
            override val publishingPlace: String? = null,
            override val retrievedDate: Long? = null,
            override val hasConnectionToSource: Boolean? = null,
            override val sourceConnection: String? = null,
            override val disclosureStatement: String? = null
    ) : Source(uniqueId = id),
            CommonSource,
            OnlineSource,
            AttributionAssociationSource

    data class OnlineArticle(
            val id: String,
            val title: String,
            override val articleId: String,
            override val url: String,
            override val siteTitle: String? = null,
            override val editors: List<Person> = emptyList(),
            override val authors: List<Person> = emptyList(),
            override val publisher: Publisher? = null,
            override val publicationDate: Long? = null,
            override val publishingPlace: String? = null,
            override val retrievedDate: Long? = null,
            override val hasConnectionToSource: Boolean? = null,
            override val sourceConnection: String? = null,
            override val disclosureStatement: String? = null
    ) : Source(uniqueId = id),
            CommonSource,
            OnlineSource,
            UniqueSource,
            AttributionAssociationSource

    data class Direct(
            val id: String,
            override val person: Person? = null,
            override val date: Long? = null,
            override val credentials: String? = null,
            override val hasConnectionToSource: Boolean? = null,
            override val sourceConnection: String? = null,
            override val disclosureStatement: String? = null,
            override val communicationMethod: String? = null
    ) : Source(uniqueId = id),
            PersonSource,
            AttributionAssociationSource
}