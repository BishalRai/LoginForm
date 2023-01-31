package com.example.login_form

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login_form.ui.theme.Login_FormTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Login_FormTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyLoginForm()
                }
            }
        }
    }
}


@Composable
fun MyLoginForm() {

    Column(){
        Text(
            modifier = Modifier.fillMaxWidth().padding(15.dp),
            text = "Login",
            fontSize = 24.sp,
            color = MaterialTheme.colors.primary,
            textAlign = TextAlign.Left,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Login_FormTheme {
        MyLoginForm()
    }
}