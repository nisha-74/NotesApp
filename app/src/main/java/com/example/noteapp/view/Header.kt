package com.example.noteapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showSystemUi = true)
@Composable
fun Header(){
    Row(modifier = Modifier.fillMaxWidth().background(Color.Blue).size(80.dp)){
        Text(text ="My Notes App", fontWeight = FontWeight.Bold, fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier.padding(top = 30.dp, start = 10.dp)
        )
    }

}