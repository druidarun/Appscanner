package com.example.appscanner

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

@Composable
fun AppScannerTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = darkColors(),
        content = content
    )
}