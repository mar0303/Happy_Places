package com.example.happyplaces2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.happyplaces2.ui.theme.HappyPlaces2Theme
import com.example.happyplaces2.ui.theme.green2

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyPlaces2Theme {

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    floatingActionButton = {Fab()}
                    ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding))

                }

            }
        }
    }
}

@Composable
fun Fab(){
    val context = LocalContext.current
    FloatingActionButton(
        onClick = {
            val intent = Intent(context, MeineMap::class.java)
            context.startActivity(intent)
        },
        containerColor = green2
    ) {
        Icon(Icons.Filled.Add, "Floating action button.")
    }
}







//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    HappyPlaces2Theme {
//        Greeting("Android")
//    }
//}