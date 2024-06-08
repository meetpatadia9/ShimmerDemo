package com.ipsmeet.shimmerdemo.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ipsmeet.shimmerdemo.ui.screens.DummyData
import com.ipsmeet.shimmerdemo.ui.screens.ProductDetailPage
import com.ipsmeet.shimmerdemo.ui.theme.ShimmerDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShimmerDemoTheme {
                DummyData()
            }
        }
    }
}