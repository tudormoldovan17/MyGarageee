package com.example.mygaragee

class Repository {
    val carsList: MutableList<Car> = mutableListOf()

    fun addCar(car: Car) {
        carsList.add(car)
    }

    init {
        generateCars()
    }

    private fun generateCars() {
        carsList.add(Car(1, "Honda Civic", 150, "Red", 2020, "Japan"))
        carsList.add(Car(2, "Toyota Camry", 200, "Blue", 2022, "Japan"))
        carsList.add(Car(3, "Ford Mustang", 450, "Black", 2021, "USA"))
        carsList.add(Car(4, "Volkswagen Golf", 120, "White", 2019, "Germany"))
        carsList.add(Car(5, "Chevrolet Malibu", 180, "Silver", 2023, "USA"))
    }
}
