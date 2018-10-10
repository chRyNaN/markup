@file:Suppress("unused")

package com.chrynan.markup.model

data class Article(
        val id: String,
        val authors: List<Person> = emptyList(),
        val editors: List<Person> = emptyList(),
        val versionControl: VersionControl? = null,
        val lastUpdated: Long,
        val created: Long,
        val title: String,
        val subTitle: String,
        val description: String,
        val imageUrl: String? = null,
        val category: String? = null,
        val subcategories: List<String> = emptyList(),
        val tags: List<String> = emptyList(),
        val language: String,
        val contentSourceUrl: String? = null,
        val content: Content? = null,
        val sources: List<Source> = emptyList(),
        val publisher: Publisher? = null
)