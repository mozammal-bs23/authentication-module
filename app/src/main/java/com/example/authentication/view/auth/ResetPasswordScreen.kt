package com.example.authentication.view.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.authentication.ui.theme.components.InputFieldWithLabel
import com.example.authentication.ui.theme.components.PageName

@Composable
fun ResetPasswordScreen() {
    val password = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(all = 24.dp)
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        PageName(
            pageTitle = "Reset Password",
            pageSubTitle = "Please enter a new password. Don’t enter your old password.",
        )
        Spacer(modifier = Modifier.height(70.dp))

        InputFieldWithLabel(
            label = "Password",
            hintText = "",
            textFieldValue = password,
        )

        Spacer(modifier = Modifier.height(30.dp))

        InputFieldWithLabel(
            label = "Confirm Password",
            hintText = "",
            textFieldValue = confirmPassword,
        )

        Spacer(Modifier.weight(1f))

        Column {
            Button(
                onClick = {  },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(
                    topStart = 16.dp,
                    topEnd = 16.dp,
                    bottomStart = 16.dp,
                    bottomEnd = 16.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF24786D)
                ),
            ) {
                Text(
                    text = "Reset Password",
                )
            }
        }

    }
}