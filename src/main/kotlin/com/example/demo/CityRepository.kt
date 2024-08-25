package com.example.demo

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface CityRepository: MongoRepository<City, String> {

    fun findByCountry(country: String): Iterable<City>

    @Query("{population:  {'\$gt':  ?0 }}")
    fun finByPopulationGreaterThan(population: Float): Iterable<City>

}