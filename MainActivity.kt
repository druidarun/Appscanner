package com.example.appscanner

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    private val targetApps = listOf(
        AppInfo("WhatsApp", "com.whatsapp"),
        AppInfo("Instagram", "com.instagram.android"),
        AppInfo("Facebook", "com.facebook.katana"),
        AppInfo("Twitter", "com.twitter.android")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppScannerScreen(targetApps, packageManager)
        }
    }
}

data class AppInfo(val name: String, val packageName: String)