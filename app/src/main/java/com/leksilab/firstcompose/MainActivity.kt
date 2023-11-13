package com.leksilab.firstcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
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
//                    MyBox()
//                    MyColumn()
//                    MyRow()
//                    MyComplexLayout()
//                    MyStateExample()
                    MyEditText()
                }
            }
        }
    }
}

@Composable
fun MyEditText() {
    // BASICO
    /*var myText by remember {
        mutableStateOf("")
    }
    TextField(value = myText, onValueChange = {myText = it})*/

    // AVANZADO
    /*var myText by remember {
        mutableStateOf("")
    }
    TextField(value = myText, onValueChange = {
        myText = if (it.contains("a")) {
            it.replace("a", "")
        } else {
            it
        }
    },
    label = { Text(text = "Ingresa tu nombre:")}
    )*/

    Column() {
        var myText by remember {
            mutableStateOf("")
        }
        OutlinedTextField(value = myText, onValueChange = {myText = it},
            modifier = Modifier.padding(25.dp),
        label = { Text(text = "HOLIS")},
        colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = Color.Blue, unfocusedBorderColor = Color.Magenta))
    }
}

@Composable
fun MyStateExample() {
    /*var counter = remember {
        mutableStateOf(0)
    }*/

    // Mantiene el estado aunque la vista se destruya
    /*var counter = rememberSaveable {
        mutableStateOf(0)
    }*/
    // Para usar by se importa getValue y setValue
    var counter by rememberSaveable {
        mutableStateOf(0)
    }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter += 1 }) {
            Text(text = "Pulsar")
        }
        Text(text = "He sido pulsado $counter veces")
    }
}

@Composable
fun MyComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan)){

        }
        MySpacer(size = 30)
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)){
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Red))
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Green), Alignment.Center) {
                Text(text = "HOLA MUNDO")
            }
        }
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta)){

        }
    }
}

@Composable
fun MySpacer(size: Int) {
    Spacer(modifier = Modifier.height(size.dp))
}

@Composable
fun MyRow() {
    Row(Modifier.fillMaxSize()) {
        Text(text = "TextRow 1")
        Text(text = "TextRow 2")
        Text(text = "TextRow 3")
        Text(text = "TextRow 3", color = Color.Blue)
        Text(text = "TextRow 3", fontWeight = FontWeight.ExtraBold)
        Text(text = "TextRow 3", fontWeight = FontWeight.Light)
        Text(text = "TextRow 3", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(text = "TextRow 3", style = TextStyle(textDecoration = TextDecoration.LineThrough))
        Text(text = "TextRow 3", style = TextStyle(textDecoration = TextDecoration.Underline))
        Text(text = "TextRow 3", style = TextStyle(textDecoration = TextDecoration.combine(
            listOf(TextDecoration.LineThrough, TextDecoration.Underline)
        )))

        Text(text = "TextRow 3", textDecoration = TextDecoration.Underline)
    }
}
@Composable
fun MyColumn() {
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween) {
        Text("Texto 1", modifier = Modifier
            .background(Color.Red)
            .fillMaxSize()
            .height(50.dp)) // .weight(1f)
        Text("Texto 2", modifier = Modifier.background(Color.Black))
        Text("Texto 3", modifier = Modifier.background(Color.Cyan))
        Text("Texto 4", modifier = Modifier.background(Color.Blue))
        Text("Texto 4", modifier = Modifier.background(Color.Blue))
        Text("Texto 4", modifier = Modifier.background(Color.Blue))
        Text("Texto 4", modifier = Modifier.background(Color.Blue))
        Text("Texto 4", modifier = Modifier.background(Color.Blue))
    }
}

@Composable
fun MyBox() {
    Box(modifier =  Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(modifier = Modifier
            .width(200.dp)
            .height(200.dp)
            .background(Color.Cyan)
            .verticalScroll(
                rememberScrollState()
            ),
            contentAlignment = Alignment.Center
        ) {
            Text("Esto es una caja")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FirstComposeTheme {
//        MyBox()
//        MyColumn()
//        MyRow()
//        MyComplexLayout()
//        MyStateExample()
        MyEditText()
    }
}