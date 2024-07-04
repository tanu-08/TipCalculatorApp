package com.example.tipcalcapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tipcalcapp.ui.theme.TipCalcAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp {
                TopHeader()
            }

        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    TipCalcAppTheme {
        Surface(color = colorResource(id = R.color.white)) {
            content()
        }
    }
}

@Composable
fun TopHeader(totalPerPerson:Double = 0.0) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(shape = CircleShape.copy(all = CornerSize(12.dp))), color = Color(0xFFE9D7F7)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(12.dp)) {
            Text(text = "Total Per Person",
                style = MaterialTheme.typography.headlineSmall)
            val total = "%.2f".format(totalPerPerson)
            Text(text = "$$total",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold)
        }
    }
}

@Preview
@Composable
fun MainContent() {
    Surface(modifier = Modifier
        .padding(2.dp)
        .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        border = BorderStroke(1.dp,Color.LightGray)
    ) {
        Column(){

        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TipCalcAppTheme {
        MyApp {
            TopHeader()
        }
    }
}