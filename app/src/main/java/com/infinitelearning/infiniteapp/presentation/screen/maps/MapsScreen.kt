package com.infinitelearning.infiniteapp.presentation.screen.maps

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Circle
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerInfoWindow
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.infinitelearning.infiniteapp.R
import com.infinitelearning.infiniteapp.utils.getResizedBitmap


@Composable
fun MapsScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    MapsContent(navController = navController, modifier = modifier)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapsContent(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    var properties by remember { mutableStateOf(MapProperties(mapType = MapType.NORMAL, isMyLocationEnabled = false)) }
    var selectedMapTypeOption by remember { mutableStateOf(MapTypeOption.NORMAL) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Maps") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "icon back"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { expanded = true }) {
                        Icon(
                            imageVector = Icons.Filled.MoreVert,
                            contentDescription = "Options"
                        )
                    }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                    ) {
                        MapTypeOption.entries.forEach { option ->
                            DropdownMenuItem(
                                onClick = {
                                    selectedMapTypeOption = option
                                    expanded = false
                                    properties = when (selectedMapTypeOption) {
                                        MapTypeOption.NORMAL -> MapProperties(mapType = MapType.NORMAL)
                                        MapTypeOption.TERRAIN -> MapProperties(mapType = MapType.TERRAIN)
                                        MapTypeOption.SATELLITE -> MapProperties(mapType = MapType.SATELLITE)
                                        MapTypeOption.HYBRID -> MapProperties(mapType = MapType.HYBRID)
                                    }
                                },
                                text = {
                                    Text(text = option.name)
                                }
                            )
                        }
                    }
                }
            )
        },
        modifier = modifier
    ) { paddingValues ->
        Box(
            modifier = Modifier.padding(paddingValues)
        ) {
            val context = LocalContext.current
            val infiniteLearning = LatLng(1.185234585525002, 104.10199759994163)
            val glints = LatLng(1.1856814467765218, 104.10192439711824)
            val cameraPositionState = rememberCameraPositionState {
                position = CameraPosition.fromLatLngZoom(infiniteLearning, 18f)
            }
            val uiSettings by remember { mutableStateOf(MapUiSettings(zoomControlsEnabled = true, myLocationButtonEnabled = true)) }
            val iconBitmap = getResizedBitmap(context, R.drawable.computer_worker, 32, 32)
            val routeCoordinates = listOf(
                LatLng(1.1871266771394677, 104.10824288764569),
                LatLng(1.1841681473109857, 104.10420110353128),
                LatLng(1.184988959257092, 104.10159830282369),
                LatLng(1.1852279868659894, 104.10200203014317)
            )
            val requestPermissionLauncher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.RequestPermission()
            ) { isGranted: Boolean ->
                if (isGranted) {
                    properties = properties.copy(isMyLocationEnabled = true)
                }
            }

            fun checkLocationPermission() {
                if (ContextCompat.checkSelfPermission(
                        context,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    properties = properties.copy(isMyLocationEnabled = true)
                } else {
                    requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
                }
            }

            LaunchedEffect(Unit) {
                checkLocationPermission()
            }

            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState,
                properties = properties,
                uiSettings = uiSettings
            ) {
                MarkerInfoWindow(
                    state = MarkerState(infiniteLearning),
                    icon = BitmapDescriptorFactory.fromBitmap(iconBitmap)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .clip(RoundedCornerShape(24.dp))
                            .background(Color.LightGray)
                            .padding(24.dp)
                    ) {
                        Text("Infinite Learning", fontWeight = FontWeight.Bold, color = Color.White)
                        Text(
                            "Tempat belajar seputar teknologi",
                            fontWeight = FontWeight.Medium,
                            color = Color.White
                        )
                    }
                }
//                Polyline(
//                    points = routeCoordinates,
//                    clickable = true,
//                    color = Color.Blue,
//                    width = 10f,
//                )
                Circle(
                    center = infiniteLearning,
                    clickable = true,
                    fillColor = Color.Blue.copy(0.3f),
                    radius = 100.0,
                    strokeColor = Color.Black,
                    strokeWidth = 2f,
                )
                Marker(
                    state = MarkerState(glints),
                    title = "Glints Batam"
                )
            }
        }
    }
}