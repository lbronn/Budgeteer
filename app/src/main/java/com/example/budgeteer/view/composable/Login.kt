package com.example.budgeteer.view.composable

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.budgeteer.ui.theme.SteelBlue
import com.example.budgeteer.viewmodel.LoginViewModel

@Composable
fun Login(loginSuccess: () -> Unit, loginViewModel: LoginViewModel = viewModel()) {
    val context = LocalContext.current.applicationContext

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedTextField(
            value = loginViewModel.username,
            onValueChange = {
                loginViewModel.username = it
            },
            label = {
                Text(text = "Username")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "username icon"
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedBorderColor = SteelBlue,
                unfocusedBorderColor = SteelBlue,
                focusedLeadingIconColor = SteelBlue,
                unfocusedLeadingIconColor = SteelBlue,
                focusedLabelColor = SteelBlue,
                unfocusedLabelColor = SteelBlue,
                unfocusedPlaceholderColor = Color.Gray,
                focusedTextColor = Color.Black
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, bottom = 10.dp)
        )

        OutlinedTextField(
            value = loginViewModel.password,
            onValueChange = {
                loginViewModel.password = it
                loginViewModel.passwordEntered = true
            },
            label = {
                Text(text = "Password")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "password icon"
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedBorderColor = SteelBlue,
                unfocusedBorderColor = SteelBlue,
                focusedLeadingIconColor = SteelBlue,
                unfocusedLeadingIconColor = SteelBlue,
                focusedLabelColor = SteelBlue,
                unfocusedLabelColor = SteelBlue,
                unfocusedPlaceholderColor = Color.Gray,
                focusedTextColor = Color.Black
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, bottom = 10.dp),
            visualTransformation = if(!loginViewModel.passwordEntered) VisualTransformation.None else PasswordVisualTransformation()
        )

        Button(
            onClick = {
                if(loginViewModel.userAuthentication(loginViewModel.username, loginViewModel.password)) {
                    loginSuccess()
                    Toast.makeText(
                        context,
                        "Login successful!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        context,
                        "Invalid Credentials!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            },
            colors = ButtonDefaults.buttonColors(SteelBlue),
            contentPadding = PaddingValues(18.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 80.dp, end = 80.dp, top = 12.dp, bottom = 20.dp)
        ) {
            Text(
                text = "Login",
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}