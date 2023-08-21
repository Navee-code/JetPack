package com.example.jetpack

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.jetpack.ui.theme.JetPackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            loginView()


        }
    }

}

        @Composable
        private fun loginView() {
            val constraint = ConstraintSet {
                val greenBox =createRefFor("greeen")
                val redBox = createRefFor("red")
                constrain(greenBox){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    width= Dimension.value(100.dp)
                    height= Dimension.value(100.dp)
                }
                constrain(redBox){
                    top.linkTo(parent.top)
                    start.linkTo(greenBox.end, margin = 15.dp)

                    width= Dimension.value(100.dp)
                    height= Dimension.value(100.dp)
                }

            }
            ConstraintLayout(constraint, modifier = Modifier.fillMaxSize()) {
                Box(modifier = Modifier
                    .background(Color.Blue)
                    .layoutId("greeen"))
                Box(modifier = Modifier
                    .background(Color.Red)
                    .layoutId("red"))


            }

         }

@Composable
fun ConstraintLayoutWithButtonAndEditText(user:(status:String)->Unit) {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (button, editText) = createRefs()

        Button(
            onClick = { user("") },
            modifier = Modifier.constrainAs(button) {

                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(parent.start, margin = 16.dp)
                end.linkTo(parent.end, margin = 16.dp)
            }
        ) {
            
        }

        val editTextValue = TextFieldValue("")

        Text(
            text = "naven"
,
            modifier = Modifier.constrainAs(editText) {
                top.linkTo(button.bottom, margin = 16.dp)
                start.linkTo(parent.start, margin = 16.dp)
                end.linkTo(parent.end, margin = 16.dp)
            }
        )
    }
}

@Composable
fun ButtonField(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
       Button(onClick = {  }, enabled = true

       ) {

           
       }

    }
}

@Composable
fun LazyColum() {
    LazyColumn {
        repeat(10000) { index ->
            item {
                Box( modifier = Modifier
                    .fillMaxSize(),
                    contentAlignment = Alignment.Center) {
                    Text(
                        text = "Value $index",
                        fontSize = 30.sp,
                        color = Color.Blue,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)

                    )
                }

            }
        }
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier,
            textAlign = TextAlign.Center
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditableTextField( modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf(TextFieldValue()) }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center.also {
        }
    ) {
        TextField(
            value = text,
            onValueChange = { newValue -> text = newValue },
            label = { Text(text = "Enter your name") },
            modifier = Modifier
                .width(200.dp)
                .height(50.dp)

        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackTheme {

        ConstraintLayoutWithButtonAndEditText{}
    }
}