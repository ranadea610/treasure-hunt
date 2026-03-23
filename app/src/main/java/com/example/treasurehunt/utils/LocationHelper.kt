package com.example.treasurehunt.utils

import android.annotation.SuppressLint
import android.content.Context
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.location.CurrentLocationRequest

@SuppressLint("MissingPermission")
fun getCurrentLocation(
    context: Context,
    onLocationResult: (Double, Double) -> Unit
) {

    val fusedLocationClient =
        LocationServices.getFusedLocationProviderClient(context)

    val request = CurrentLocationRequest.Builder()
        .setPriority(Priority.PRIORITY_HIGH_ACCURACY)
        .build()

    fusedLocationClient
        .getCurrentLocation(request, null)
        .addOnSuccessListener { location ->

            location?.let {
                onLocationResult(it.latitude, it.longitude)
            }

        }
}
