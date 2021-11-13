package com.stacydevino.b_daycard

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stacydevino.b_daycard.ui.theme.BDayCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BDayCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    BirthdayCard()
                }
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun Greeting(toggle: Boolean, onNameChange: (Boolean) -> Unit) {
    Crossfade(targetState = toggle, animationSpec = tween(500)) {
        Image(
            painter = if (it) painterResource(id = R.drawable.sam_image)
            else painterResource(id = R.drawable.tabby_image),
            contentDescription = "Sam's Image",
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(1f)
        )
    }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(1f)
            .padding(8.dp),
            ) {
        Text(
            text = if (toggle) "Happy Birthday Sam" else "Happy Birthday Tabby",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .border(2.dp, Color.White)
                .padding(4.dp),
            textAlign = TextAlign.Center,
            fontSize = 48.sp,
            color = Color.White
        )
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(16.dp)
    ) {
        Button(
            onClick = {
                onNameChange(!toggle)
            }
        ) {
            Text("Change")
            PaddingValues(16.dp)
        }
    }
}

@Composable
fun BirthdayCard (){
    var toggle by remember { mutableStateOf(false) }
    Greeting(toggle = toggle, onNameChange = { toggle = it })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BDayCardTheme {
        BirthdayCard()
    }
}