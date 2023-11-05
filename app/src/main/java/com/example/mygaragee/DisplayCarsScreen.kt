package com.example.mygaragee


import androidx.compose.material3.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun DisplayCarsScreen(navController: NavController, repository: Repository) {

    val carsList = repository.carsList

    LazyColumn {
        items(carsList) { car ->
            CarItem(car, navController)
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
fun CarItem(car: Car, navController : NavController) {
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

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = {
                        navController.navigate(Screen.UpdateCarScreen.route)
                    },
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit"
                    )
                }

                Button(
                    onClick = {
                        navController.navigate("deleteCar/${car.id}")
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete"
                    )
                }
            }
        }
    }
}
