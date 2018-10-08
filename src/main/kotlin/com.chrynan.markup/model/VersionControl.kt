package com.chrynan.markup.model

data class VersionControl(
        val versionNumber: Int,
        val versionCode: String,
        val type: String? = null,
        val lastUpdated: Long,
        val sourceUrl: String? = null
)