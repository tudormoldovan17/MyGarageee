package com.example.mygaragee

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AddCarScreen(
    navController: NavController,
    repository: Repository,
    onCarAdded: () -> Unit
) {
    var carName by remember { mutableStateOf("") }
    var carHorsepower by remember { mutableStateOf("") }
    var carYear by remember { mutableStateOf("") }
    var carColor by remember { mutableStateOf("") }
    var carCountry by remember { mutableStateOf("") }

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
                // Validate input and add the car to the repository
                if (carName.isNotEmpty() && carHorsepower.isNotEmpty() && carYear.isNotEmpty() && carColor.isNotEmpty() && carCountry.isNotEmpty()) {
                    val newCar = Car(
                        id = 10,
                        name = carName,
                        horsepower = carHorsepower.toInt(),
                        year = carYear.toInt(),
                        color = carColor,
                        country = carCountry
                    )
                    repository.addCar(newCar)
                    onCarAdded()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text("Add Car")
        }
    }
}
