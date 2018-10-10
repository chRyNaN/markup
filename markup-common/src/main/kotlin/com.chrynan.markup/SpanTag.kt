@file:Suppress("unused")

package com.chrynan.markup

import com.chrynan.spannable.MutableSpan
import com.chrynan.spannable.Span

sealed class SpanTag : Tag,
        Span,
        MutableSpan {

    sealed class TextSpanTag : SpanTag() {

        data class Bold(
                override var startIndexInclusive: Int,
                override var endIndexExclusive: Int
        ) : TextSpanTag() {

            override fun copyWithRange(startInclusive: Int, endExclusive: Int): Bold =
                    copy(startIndexInclusive = startInclusive, endIndexExclusive = endExclusive)
        }

        data class Italic(
                override var startIndexInclusive: Int,
                override var endIndexExclusive: Int
        ) : TextSpanTag() {

            override fun copyWithRange(startInclusive: Int, endExclusive: Int): Italic =
                    copy(startIndexInclusive = startInclusive, endIndexExclusive = endExclusive)
        }

        data class BoldAndItalic(
                override var startIndexInclusive: Int,
                override var endIndexExclusive: Int
        ) : TextSpanTag() {

            override fun copyWithRange(startInclusive: Int, endExclusive: Int): BoldAndItalic =
                    copy(startIndexInclusive = startInclusive, endIndexExclusive = endExclusive)
        }

        data class Highlight(
                override var startIndexInclusive: Int,
                override var endIndexExclusive: Int
        ) : TextSpanTag() {

            override fun copyWithRange(startInclusive: Int, endExclusive: Int): Highlight =
                    copy(startIndexInclusive = startInclusive, endIndexExclusive = endExclusive)
        }

        data class Subscript(
                override var startIndexInclusive: Int,
                override var endIndexExclusive: Int
        ) : TextSpanTag() {

            override fun copyWithRange(startInclusive: Int, endExclusive: Int): Subscript =
                    copy(startIndexInclusive = startInclusive, endIndexExclusive = endExclusive)
        }

        data class Superscript(
                override var startIndexInclusive: Int,
                override var endIndexExclusive: Int
        ) : TextSpanTag() {

            override fun copyWithRange(startInclusive: Int, endExclusive: Int): Superscript =
                    copy(startIndexInclusive = startInclusive, endIndexExclusive = endExclusive)
        }

        // Do we need content content properties since these are spans already indicating the start and end of the content?
        data class Link(
                override var startIndexInclusive: Int,
                override var endIndexExclusive: Int,
                val url: String
        ) : TextSpanTag() {

            override fun copyWithRange(startInclusive: Int, endExclusive: Int): Link =
                    copy(startIndexInclusive = startInclusive, endIndexExclusive = endExclusive)
        }

        // Link to content in this article - Not sure how to implement this yet
        data class RelativeLink(
                override var startIndexInclusive: Int,
                override var endIndexExclusive: Int
        ) : TextSpanTag() {

            override fun copyWithRange(startInclusive: Int, endExclusive: Int): RelativeLink =
                    copy(startIndexInclusive = startInclusive, endIndexExclusive = endExclusive)
        }

        data class FootNoteSource(
                val sourceId: String,
                val name: String,
                override var startIndexInclusive: Int,
                override var endIndexExclusive: Int
        ) : TextSpanTag() {

            override fun copyWithRange(startInclusive: Int, endExclusive: Int): FootNoteSource =
                    copy(startIndexInclusive = startInclusive, endIndexExclusive = endExclusive)
        }

        // Emoji's should be supported naturally but this could provide additional accessibility information about them
        data class Emoji(
                override var startIndexInclusive: Int,
                override var endIndexExclusive: Int,
                val description: String? = null
        ) : TextSpanTag() {

            override fun copyWithRange(startInclusive: Int, endExclusive: Int): Emoji =
                    copy(startIndexInclusive = startInclusive, endIndexExclusive = endExclusive)
        }

        data class EpochTime(
                override var startIndexInclusive: Int,
                override var endIndexExclusive: Int,
                val millisecondsSinceEpoch: Long
        ) : TextSpanTag() {

            override fun copyWithRange(startInclusive: Int, endExclusive: Int): EpochTime =
                    copy(startIndexInclusive = startInclusive, endIndexExclusive = endExclusive)
        }

        data class TimeFormat(
                override var startIndexInclusive: Int,
                override var endIndexExclusive: Int,
                val format: String,
                val value: String
        ) : TextSpanTag() {

            override fun copyWithRange(startInclusive: Int, endExclusive: Int): TimeFormat =
                    copy(startIndexInclusive = startInclusive, endIndexExclusive = endExclusive)
        }

        data class TimeDuration(
                override var startIndexInclusive: Int,
                override var endIndexExclusive: Int,
                val unit: String,
                val value: kotlin.Number
        ) : TextSpanTag() {

            override fun copyWithRange(startInclusive: Int, endExclusive: Int): TimeDuration =
                    copy(startIndexInclusive = startInclusive, endIndexExclusive = endExclusive)
        }

        data class TimeRange(
                override var startIndexInclusive: Int,
                override var endIndexExclusive: Int,
                val startMillisecondsSinceEpoch: Long,
                val endMillisecondsSinceEpoch: Long
        ) : TextSpanTag() {

            override fun copyWithRange(startInclusive: Int, endExclusive: Int): TimeRange =
                    copy(startIndexInclusive = startInclusive, endIndexExclusive = endExclusive)
        }

        data class LocationPlaceID(
                override var startIndexInclusive: Int,
                override var endIndexExclusive: Int,
                val placeID: String,
                val provider: String,
                val sourceUrl: String
        ) : TextSpanTag() {

            override fun copyWithRange(startInclusive: Int, endExclusive: Int): LocationPlaceID =
                    copy(startIndexInclusive = startInclusive, endIndexExclusive = endExclusive)
        }

        data class LocationLatLong(
                override var startIndexInclusive: Int,
                override var endIndexExclusive: Int,
                val latitude: String,
                val longitude: String,
                val altitude: String? = null
        ) : TextSpanTag() {

            override fun copyWithRange(startInclusive: Int, endExclusive: Int): LocationLatLong =
                    copy(startIndexInclusive = startInclusive, endIndexExclusive = endExclusive)
        }

        data class LocationAddress(
                override var startIndexInclusive: Int,
                override var endIndexExclusive: Int,
                val address: String
        ) : TextSpanTag() {

            override fun copyWithRange(startInclusive: Int, endExclusive: Int): LocationAddress =
                    copy(startIndexInclusive = startInclusive, endIndexExclusive = endExclusive)
        }

        data class Unit(
                override var startIndexInclusive: Int,
                override var endIndexExclusive: Int,
                val unit: String,
                val value: kotlin.Number,
                val format: String
        ) : TextSpanTag() {

            override fun copyWithRange(startInclusive: Int, endExclusive: Int): Unit =
                    copy(startIndexInclusive = startInclusive, endIndexExclusive = endExclusive)
        }

        data class Currency(
                override var startIndexInclusive: Int,
                override var endIndexExclusive: Int,
                val currencyUnit: String,
                val value: kotlin.Number
        ) : TextSpanTag() {

            override fun copyWithRange(startInclusive: Int, endExclusive: Int): Currency =
                    copy(startIndexInclusive = startInclusive, endIndexExclusive = endExclusive)
        }

        data class Number(
                override var startIndexInclusive: Int,
                override var endIndexExclusive: Int,
                val value: kotlin.Number,
                val format: String
        ) : TextSpanTag() {

            override fun copyWithRange(startInclusive: Int, endExclusive: Int): Number =
                    copy(startIndexInclusive = startInclusive, endIndexExclusive = endExclusive)
        }

        data class InlineQuote(
                override var startIndexInclusive: Int,
                override var endIndexExclusive: Int,
                val sourceId: String
        ) : TextSpanTag() {

            override fun copyWithRange(startInclusive: Int, endExclusive: Int): InlineQuote =
                    copy(startIndexInclusive = startInclusive, endIndexExclusive = endExclusive)
        }

        data class Aside(
                override var startIndexInclusive: Int,
                override var endIndexExclusive: Int,
                val message: String
        ) : TextSpanTag() {

            override fun copyWithRange(startInclusive: Int, endExclusive: Int): Aside =
                    copy(startIndexInclusive = startInclusive, endIndexExclusive = endExclusive)
        }

        data class PhoneNumber(
                override var startIndexInclusive: Int,
                override var endIndexExclusive: Int,
                val fullPhoneNumber: String,
                val countryCode: String? = null,
                val extension: String? = null,
                val number: String? = null
        ) : TextSpanTag() {

            override fun copyWithRange(startInclusive: Int, endExclusive: Int): PhoneNumber =
                    copy(startIndexInclusive = startInclusive, endIndexExclusive = endExclusive)
        }

        data class Person(
                override var startIndexInclusive: Int,
                override var endIndexExclusive: Int,
                val name: String,
                val url: String? = null
        ) : TextSpanTag() {

            override fun copyWithRange(startInclusive: Int, endExclusive: Int): Person =
                    copy(startIndexInclusive = startInclusive, endIndexExclusive = endExclusive)
        }
    }

    sealed class QuoteSpanTag : SpanTag() {

        data class Emphasis(
                override var startIndexInclusive: Int,
                override var endIndexExclusive: Int,
                val added: Boolean
        ) : QuoteSpanTag() {

            override fun copyWithRange(startInclusive: Int, endExclusive: Int): Emphasis =
                    copy(startIndexInclusive = startInclusive, endIndexExclusive = endExclusive)
        }
    }
}