package com.example.jetpack

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun loginScreen(navController: NavHostController) {

    var user by remember{
        mutableStateOf("")
    }

    var passw by remember{
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Pantalla de Login", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(50.dp))

        Image(painter = painterResource(R.drawable.login), contentDescription ="Login image")

        Spacer(modifier = Modifier.height(50.dp))

        OutlinedTextField(value = user, onValueChange = {
            user = it
        }, label = {
            Text( text = "Usuario")
        })

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value = passw, onValueChange = {
            passw = it
        }, label = {
            Text( text = "Contraseña")
        }, visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            Log.i("Credential", "User: $user, Password : $passw")
            navController.navigate("contacts")
        }) {
            Text(text = "Entrar")
        }

        Spacer(modifier = Modifier.height(32.dp))


        Text(text = "¿Ha olvidado su contraseña?", modifier = Modifier.clickable {

        })
    }
}