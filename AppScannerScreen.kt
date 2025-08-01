package com.example.appscanner

import android.content.pm.PackageManager
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppScannerScreen(targetApps: List<AppInfo>, packageManager: PackageManager) {
    var scanResults by remember { mutableStateOf<List<Pair<String, Boolean>>?>(null) }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("App Scanner") })
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    scanResults = targetApps.map { app ->
                        val isInstalled = try {
                            packageManager.getPackageInfo(app.packageName, 0)
                            true
                        } catch (e: PackageManager.NameNotFoundException) {
                            false
                        }
                        app.name to isInstalled
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Scan for Apps")
            }
            Spacer(modifier = Modifier.height(24.dp))
            scanResults?.let { results ->
                LazyColumn {
                    items(results.size) { index ->
                        val (name, installed) = results[index]
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(name)
                            if (installed) {
                                Text("✓", color = MaterialTheme.colors.primary)
                            } else {
                                Text("✗", color = MaterialTheme.colors.error)
                            }
                        }
                    }
                }
            }
        }
    }
}