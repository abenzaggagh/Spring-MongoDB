package com.example.demo

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class City(
    @Id
    val id: String?,
    val name: String,
    val country: String,
    val population: Float
)
