package com.leksilab.firstcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leksilab.firstcompose.ui.theme.FirstComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyButtonExample()
                }
            }
        }
    }
}

@Composable
fun MyButtonExample() {
    // Al momento de dar click el componente se vuelve a recrear
    // al momento de rotar la pantalla el componente se vuelve a recrear
    var enable by rememberSaveable {
        mutableStateOf(true)
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)) {
        Button(onClick = {
//            Log.i("Alex-Button", "Esto es un ejemplo")
              enable = false
        },
            enabled = enable,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Magenta, contentColor = Color.Blue),
            border = BorderStroke(5.dp, Color.Green)
        ) {
            Text(text = "HOLA")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FirstComposeTheme {
        MyButtonExample()
    }
}