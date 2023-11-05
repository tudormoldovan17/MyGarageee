package com.example.mygaragee


import androidx.compose.material3.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun DisplayCarsScreen(navController: NavController, repository: Repository) {

    val carsList = repository.carsList

    LazyColumn {
        items(carsList) { car ->
            CarItem(car = car)
        }
    }

    // Add car button
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.BottomEnd
    )
    {
        FloatingActionButton(
            onClick = {
                navController.navigate(Screen.AddCarScreen.route)
            },
            modifier = Modifier
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add Car"
            )
        }
    }


}

@Composable
fun CarItem(car: Car) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White)
            .padding(8.dp)
    ) {
        Text(
            text = "Name: ${car.name}",
            fontSize = 20.sp,
            modifier = Modifier.padding(8.dp)
        )

        Column {
            Text(
                text = "Horsepower: ${car.horsepower}",
                fontSize = 16.sp,
                modifier = Modifier.padding(8.dp)
            )

            Text(
                text = "Year: ${car.year}",
                fontSize = 16.sp,
                modifier = Modifier.padding(8.dp)
            )

            Text(
                text = "Color: ${car.color}",
                fontSize = 16.sp,
                modifier = Modifier.padding(8.dp)
            )

            Text(
                text = "Country: ${car.country}",
                fontSize = 16.sp,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}




@Composable
@Preview
fun CarItemPreview() {
    val sampleCar = Car(1, "Honda Civic", 150, "Red", 2020, "Japan")
    CarItem(car = sampleCar)
}