package com.ipsmeet.shimmerdemo.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ipsmeet.shimmerdemo.composeutils.ShimmerButton
import com.ipsmeet.shimmerdemo.composeutils.ShimmerImage
import com.ipsmeet.shimmerdemo.composeutils.ShimmerText
import com.ipsmeet.shimmerdemo.composeutils.shimmerBrush

@Composable
fun ProductDetailPage(modifier: Modifier = Modifier) {

    val context = LocalContext.current
    val showShimmer = remember { mutableStateOf(true) }

    Column (
        modifier = modifier.fillMaxSize()
    ){
        /*AsyncImage(
            model = "https://images.ctfassets.net/lzny33ho1g45/4gdjyG2SF19KQfXbcRBz04/105b83c584c0167893c4b35ed0e67bb1/app-tips-dropbox-00-hero.png",
            contentDescription = "Dropbox",
            modifier = modifier
                .background(shimmerBrush(showShimmer = showShimmer.value))
                .fillMaxWidth()
                .height(200.dp),
            onSuccess = { showShimmer.value = false },
            contentScale = ContentScale.Crop
        )*/

        ShimmerText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            text = "Dropbox",
            showShimmer = showShimmer.value // Change to false to show actual text
        )

        ShimmerImage(
            model = "https://images.ctfassets.net/lzny33ho1g45/4gdjyG2SF19KQfXbcRBz04/105b83c584c0167893c4b35ed0e67bb1/app-tips-dropbox-00-hero.png",
            showShimmer = showShimmer.value,
            modifier = Modifier
                .height (200.dp)
                .fillMaxWidth()
        )
        
        ShimmerButton(
            text = "Button",
            showShimmer = showShimmer.value,
            modifier = modifier,
            onClick = {
                Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show()
            }
        )

    }
}