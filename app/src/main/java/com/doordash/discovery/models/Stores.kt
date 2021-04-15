package com.doordash.discovery.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Stores {
    inner class DeliveryFeeMonetaryFields {
        @SerializedName("currency")
        @Expose
        var currency: String? = null

        @SerializedName("display_string")
        @Expose
        var displayString: String? = null

        @SerializedName("unit_amount")
        @Expose
        var unitAmount: Int? = null

        @SerializedName("decimal_places")
        @Expose
        var decimalPlaces: Int? = null
    }

    inner class DeliveryFeeMonetaryFields__1 {
        @SerializedName("currency")
        @Expose
        var currency: String? = null

        @SerializedName("display_string")
        @Expose
        var displayString: String? = null

        @SerializedName("decimal_places")
        @Expose
        var decimalPlaces: Int? = null

        @SerializedName("unit_amount")
        @Expose
        var unitAmount: Any? = null
    }

    data class ListofStores(
        @SerializedName("num_results")
        @Expose
        var numResults: Int? = null,

        @SerializedName("is_first_time_user")
        @Expose
        var isFirstTimeUser: Boolean? = null,

        @SerializedName("sort_order")
        @Expose
        var sortOrder: String? = null,

        @SerializedName("next_offset")
        @Expose
        var nextOffset: Int? = null,

        @SerializedName("show_list_as_pickup")
        @Expose
        var showListAsPickup: Boolean? = null,

        @SerializedName("stores")
        @Expose
        var stores: List<Store>? = null
    ) {
        fun copyfrom(proyecta: Stores.ListofStores) {
            numResults=proyecta.numResults
            isFirstTimeUser= proyecta.isFirstTimeUser
            sortOrder = proyecta.sortOrder
            nextOffset = proyecta.nextOffset
            showListAsPickup = proyecta.showListAsPickup
            stores = proyecta.stores
        }
    }


    inner class ExtraSosDeliveryFeeMonetaryFields {
        @SerializedName("currency")
        @Expose
        var currency: String? = null

        @SerializedName("display_string")
        @Expose
        var displayString: String? = null

        @SerializedName("unit_amount")
        @Expose
        var unitAmount: Int? = null

        @SerializedName("decimal_places")
        @Expose
        var decimalPlaces: Int? = null
    }

    inner class Location {
        @SerializedName("lat")
        @Expose
        var lat: Double? = null

        @SerializedName("lng")
        @Expose
        var lng: Double? = null
    }

    inner class Menu {
        @SerializedName("popular_items")
        @Expose
        var popularItems: List<PopularItem>? =
            null

        @SerializedName("subtitle")
        @Expose
        var subtitle: String? = null

        @SerializedName("id")
        @Expose
        var id: Int? = null

        @SerializedName("name")
        @Expose
        var name: String? = null

        @SerializedName("is_catering")
        @Expose
        var isCatering: Boolean? = null
    }

    inner class MerchantPromotion {
        @SerializedName("category_new_store_customers_only")
        @Expose
        var categoryNewStoreCustomersOnly: Boolean? = null

        @SerializedName("minimum_subtotal_monetary_fields")
        @Expose
        var minimumSubtotalMonetaryFields: MinimumSubtotalMonetaryFields? =
            null

        @SerializedName("daypart_constraints")
        @Expose
        var daypartConstraints: List<Any>? = null

        @SerializedName("delivery_fee")
        @Expose
        var deliveryFee: Any? = null

        @SerializedName("delivery_fee_monetary_fields")
        @Expose
        var deliveryFeeMonetaryFields: DeliveryFeeMonetaryFields__1? =
            null

        @SerializedName("minimum_subtotal")
        @Expose
        var minimumSubtotal: Any? = null

        @SerializedName("id")
        @Expose
        var id: Int? = null
    }

    inner class MinimumSubtotalMonetaryFields {
        @SerializedName("currency")
        @Expose
        var currency: String? = null

        @SerializedName("display_string")
        @Expose
        var displayString: String? = null

        @SerializedName("decimal_places")
        @Expose
        var decimalPlaces: Int? = null

        @SerializedName("unit_amount")
        @Expose
        var unitAmount: Any? = null
    }

    inner class PopularItem {
        @SerializedName("price")
        @Expose
        var price: Int? = null

        @SerializedName("img_url")
        @Expose
        var imgUrl: String? = null

        @SerializedName("description")
        @Expose
        var description: String? = null

        @SerializedName("name")
        @Expose
        var name: String? = null

        @SerializedName("id")
        @Expose
        var id: Int? = null
    }

    inner class Status {
        @SerializedName("unavailable_reason")
        @Expose
        var unavailableReason: Any? = null

        @SerializedName("pickup_available")
        @Expose
        var pickupAvailable: Boolean? = null

        @SerializedName("asap_available")
        @Expose
        var asapAvailable: Boolean? = null

        @SerializedName("scheduled_available")
        @Expose
        var scheduledAvailable: Boolean? = null

        @SerializedName("asap_minutes_range")
        @Expose
        var asapMinutesRange: List<Int>? = null
    }

    inner class Store {
        @SerializedName("is_consumer_subscription_eligible")
        @Expose
        var isConsumerSubscriptionEligible: Boolean? = null

        @SerializedName("promotion_delivery_fee")
        @Expose
        var promotionDeliveryFee: Int? = null

        @SerializedName("delivery_fee")
        @Expose
        var deliveryFee: Int? = null

        @SerializedName("delivery_fee_monetary_fields")
        @Expose
        var deliveryFeeMonetaryFields: DeliveryFeeMonetaryFields? =
            null

        @SerializedName("num_ratings")
        @Expose
        var numRatings: Int? = null

        @SerializedName("id")
        @Expose
        var id: Int? = null

        @SerializedName("extra_sos_delivery_fee_monetary_fields")
        @Expose
        var extraSosDeliveryFeeMonetaryFields: ExtraSosDeliveryFeeMonetaryFields? =
            null

        @SerializedName("menus")
        @Expose
        var menus: List<Menu>? = null

        @SerializedName("average_rating")
        @Expose
        var averageRating: Double? = null

        @SerializedName("location")
        @Expose
        var location: Location? = null

        @SerializedName("status")
        @Expose
        var status: Status? = null

        @SerializedName("display_delivery_fee")
        @Expose
        var displayDeliveryFee: String? = null

        @SerializedName("description")
        @Expose
        var description: String? = null

        @SerializedName("business_id")
        @Expose
        var businessId: Int? = null

        @SerializedName("extra_sos_delivery_fee")
        @Expose
        var extraSosDeliveryFee: Int? = null

        @SerializedName("cover_img_url")
        @Expose
        var coverImgUrl: String? = null

        @SerializedName("header_img_url")
        @Expose
        var headerImgUrl: String? = null

        @SerializedName("price_range")
        @Expose
        var priceRange: Int? = null

        @SerializedName("name")
        @Expose
        var name: String? = null

        @SerializedName("is_newly_added")
        @Expose
        var isNewlyAdded: Boolean? = null

        @SerializedName("url")
        @Expose
        var url: String? = null

        @SerializedName("next_close_time")
        @Expose
        var nextCloseTime: String? = null

        @SerializedName("next_open_time")
        @Expose
        var nextOpenTime: String? = null

        @SerializedName("service_rate")
        @Expose
        var serviceRate: Any? = null

        @SerializedName("distance_from_consumer")
        @Expose
        var distanceFromConsumer: Double? = null

        @SerializedName("merchant_promotions")
        @Expose
        var merchantPromotions: List<MerchantPromotion>? =
            null
    }
}