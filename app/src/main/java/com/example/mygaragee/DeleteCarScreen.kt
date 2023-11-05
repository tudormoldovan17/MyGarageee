package com.example.mygaragee

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DeleteCarScreen(
    repository: Repository,
    carId: Int?,
    onDeleteConfirmed: () -> Unit,
    onDeleteCanceled: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        if(carId != null) {
            val car = repository.getCarById(carId)
            if(car != null)
                CarItemWithoutButtons(car = car)
        }
        else {
            Log.i("mytag", "carid is null")
        }

        Text(
            text = "Are you sure to delete this car?",
            fontSize = 18.sp,
            modifier = Modifier.padding(8.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    if(carId != null) {
                        val carWasDeleted: Boolean = repository.deleteCarById(carId)
                        if(carWasDeleted == true) {
                            onDeleteConfirmed()
                        }
                        else {
                            onDeleteCanceled()
                        }
                    }
                }
            ) {
                Text("Yes")
            }

            Button(
                onClick = { onDeleteCanceled() },
            ) {
                Text("No")
            }
        }
    }
}

@Composable
fun CarItemWithoutButtons(car: Car) {
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
