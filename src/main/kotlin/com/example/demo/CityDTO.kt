package com.example.demo

data class CityDTO(
    val name: String,
    val country: String,
    val population: Float
) {
    init {
        require(population > 0) { "population must be positive" }
    }
}
