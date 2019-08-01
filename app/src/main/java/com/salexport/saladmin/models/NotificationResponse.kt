package com.salexport.saladmin.models

data class NotificationResponse(
    val `data`: List<Data>,
    val current_page: Int,
    val first_page_url: String,
    val from: Int,
    val last_page: Int,
    val last_page_url: String,
    val next_page_url: String,
    val path: String,
    val per_page: Int,
    val prev_page_url: Any,
    val to: Int,
    val total: Int
)

data class Data(
    val `data`: DataX,
    val created_at: String,
    val id: String,
    val notifiable_id: Int,
    val notifiable_type: String,
    val read_at: Any,
    val type: String,
    val updated_at: String
)

data class DataX(
    val description: String,
    val icon: String,
    val level: String,
    val title: String
)

