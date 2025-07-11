package com.example.happyplaces2

import android.content.Context
import org.osmdroid.config.Configuration
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.example.happyplaces2.ui.theme.HappyPlaces2Theme
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView

class MeineMap : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val prefs = applicationContext.getSharedPreferences("osmdroid", Context.MODE_PRIVATE)
        Configuration.getInstance().load(applicationContext, prefs)

        setContent {
            HappyPlaces2Theme {
                OpenStreetMapScreen()
            }

        }

//        setContent {
//            HappyPlaces2Theme {
//
//                Scaffold(
//                    modifier = Modifier.fillMaxSize(),
//                    floatingActionButton = {Fab()}
//                ) { innerPadding ->
//                    Box(modifier = Modifier.padding(innerPadding))
//
//                }
//
//            }
//        }

    }


    @Composable
    fun OpenStreetMapScreen() {
        val context = LocalContext.current

        AndroidView(
            factory = {
                MapView(it).apply {
                    setTileSource(TileSourceFactory.MAPNIK)
                    setMultiTouchControls(true)

                    // Position und Zoom setzen
                    val mapController = controller
                    mapController.setZoom(15.0)
                    val startPoint = GeoPoint(52.52, 13.405)
                    mapController.setCenter(startPoint)
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    }

}