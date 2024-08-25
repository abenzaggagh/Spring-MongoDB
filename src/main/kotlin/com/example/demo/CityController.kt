package com.example.demo

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("cities")
class CityController(val cityRepository: CityRepository) {

    @PostMapping()
    fun create(@RequestBody city: CityDTO): City = cityRepository.save(
        City(
            id = null,
            name = city.name,
            country = city.country,
            population = city.population
        )
    )

    @GetMapping("{id}")
    fun findById(@PathVariable("id") id: String) = cityRepository.findById(id).orElseThrow{
        ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    @GetMapping()
    fun findByCountry(
        @RequestParam(required = false) country: String?,
        @RequestParam(required = false) population: Float?): Iterable<City> {
        return if (country != null) {
            cityRepository.findByCountry(country)

        } else if (population != null) {
            cityRepository.finByPopulationGreaterThan(population)
        } else {
            cityRepository.findAll()
        }
    }
}