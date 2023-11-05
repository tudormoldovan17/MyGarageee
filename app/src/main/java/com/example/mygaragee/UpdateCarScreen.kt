package com.example.mygaragee

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun UpdateCarScreen(navController: NavController, repository: Repository, carId: Int?) {
    if(carId != null) {
        val car = repository.getCarById(carId)
        var carName by remember { mutableStateOf(car?.name ?: "") }
        var carHorsepower by remember { mutableStateOf(car?.horsepower.toString()) }
        var carYear by remember { mutableStateOf(car?.year.toString()) }
        var carColor by remember { mutableStateOf(car?.color ?: "") }
        var carCountry by remember { mutableStateOf(car?.country ?: "") }

        Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                ) {
            OutlinedTextField(
                value = carName,
                onValueChange = { carName = it },
                label = { Text("Car Name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            OutlinedTextField(
                value = carHorsepower,
                onValueChange = { carHorsepower = it },
                label = { Text("Horsepower") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            OutlinedTextField(
                value = carYear,
                onValueChange = { carYear = it },
                label = { Text("Year") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            OutlinedTextField(
                value = carColor,
                onValueChange = { carColor = it },
                label = { Text("Color") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            OutlinedTextField(
                value = carCountry,
                onValueChange = { carCountry = it },
                label = { Text("Country") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            Button(
                onClick = {
                    // Validate input and update the car in the repository
                    if (car != null) {
                        val updatedCar = Car(
                            id = car.id,
                            name = carName,
                            horsepower = carHorsepower.toInt(),
                            year = carYear.toInt(),
                            color = carColor,
                            country = carCountry
                        )
                        repository.updateCar(updatedCar)
                        navController.popBackStack()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text("Update Car")
            }
        }
    }
    else {
        Text("Car not found.")
    }
}
