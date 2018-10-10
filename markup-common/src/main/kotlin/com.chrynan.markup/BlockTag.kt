@file:Suppress("unused")

package com.chrynan.markup

import com.chrynan.spannable.SpannableText

sealed class BlockTag : Tag {

    data class Text(val spannableText: SpannableText<SpanTag.TextSpanTag>) : BlockTag()

    data class Embedded(
            val type: String,
            val format: String? = null,
            val sourceId: String? = null,
            val sourceUrl: String? = null,
            val content: String? = null
    ) : BlockTag()

    data class Code(
            val sourceId: String? = null,
            val language: String? = null,
            val content: String
    ) : BlockTag()

    data class HeaderOne(val content: String) : BlockTag()

    data class HeaderTwo(val content: String) : BlockTag()

    data class HeaderThree(val content: String) : BlockTag()

    data class OrderedList(val listItems: List<SpannableText<SpanTag.TextSpanTag>>) : BlockTag()

    data class UnorderedList(val listItems: List<SpannableText<SpanTag.TextSpanTag>>) : BlockTag()

    data class Quote(
            val sourceId: String? = null,
            val content: SpannableText<SpanTag.QuoteSpanTag>
    ) : BlockTag()

    data class Image(
            val format: String? = null,
            val sourceId: String? = null, // Source ID Referencing a Bibliography Source
            val sourceUrl: String,
            val description: String? = null
    ) : BlockTag()

    data class Video(
            val format: String? = null,
            val sourceId: String? = null,
            val sourceUrl: String,
            val description: String? = null
    ) : BlockTag()

    data class Audio(
            val format: String? = null,
            val sourceId: String? = null,
            val sourceUrl: String,
            val description: String? = null
    ) : BlockTag()

    data class AttentionNote(val content: SpannableText<SpanTag.TextSpanTag>) : BlockTag()
}