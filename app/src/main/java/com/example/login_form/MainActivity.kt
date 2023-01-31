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
import androidx.compose.runtime.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation



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
    var userNameInput: String by remember { mutableStateOf("")}
    var userPasswordInput: String by remember { mutableStateOf("")}
    var showPassword by remember { mutableStateOf(false) }

    Column(){
        Text(
            modifier = Modifier.fillMaxWidth().padding(15.dp),
            text = "Login",
            fontSize = 24.sp,
            color = MaterialTheme.colors.primary,
            textAlign = TextAlign.Left,
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            value = userNameInput,
            onValueChange = {userNameInput = it},
            label = { Text(text = "Username")},
            placeholder = { Text(text = "Enter user name")},
            singleLine = true,
            trailingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Email Icon") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            value = userPasswordInput,
            onValueChange = {userPasswordInput = it},
            label = { Text(text = "Password")},
            placeholder = { Text(text = "Enter password")},
            singleLine = true,
            trailingIcon = { IconButton(onClick = { showPassword = !showPassword }) {
                Icon(imageVector = Icons.Outlined.Lock, contentDescription = "Lock Icon") }
            },
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
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