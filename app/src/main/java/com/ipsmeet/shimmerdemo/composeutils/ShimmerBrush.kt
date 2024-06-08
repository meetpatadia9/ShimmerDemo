package com.ipsmeet.shimmerdemo.composeutils

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ShimmerImage(
    modifier: Modifier = Modifier,
    model: Any?,
    contentDescription: String? = null,
    showShimmer: Boolean = true
) {
    if (showShimmer) {
        Box(
            modifier = modifier
                .background(
                    brush = shimmerBrush(),
                    shape = RoundedCornerShape(4.dp)
                )
        )
    } else {
        AsyncImage(
            model = model,
            contentDescription = contentDescription,
            modifier = modifier,
            contentScale = ContentScale.Crop
        )
    }
}


@Composable
fun ShimmerButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    showShimmer: Boolean = true
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .shimmer(showShimmer = showShimmer)
            .height(48.dp)
            .background(shimmerBrush(showShimmer), shape = ButtonDefaults.shape),
        enabled = !showShimmer,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (showShimmer) Color.LightGray else MaterialTheme.colorScheme.primary
        )
    ) {
        Text(text = text)
    }
}

@Composable
private fun Modifier.shimmer(showShimmer: Boolean): Modifier {
    return if (showShimmer) {
        this.graphicsLayer {
            alpha = 0.75f
        }
    } else {
        Modifier
    }
}


@Composable
fun ShimmerText(modifier: Modifier = Modifier, text: String? = null, showShimmer: Boolean = true) {
    if (showShimmer) {
        Box(
            modifier = modifier
                .background(brush = shimmerBrush(), shape = MaterialTheme.shapes.small)
                .height(20.dp)
                .fillMaxWidth()
        )
    } else {
        Text(
            text = text ?: "",
            modifier = modifier
        )
    }
}


@Composable
fun shimmerBrush(showShimmer: Boolean = true): Brush {
    return if (showShimmer) {
        val shimmerColors = listOf(
            Color.LightGray.copy(alpha = 0.9f),
            Color.LightGray.copy(alpha = 0.5f),
            Color.LightGray.copy(alpha = 0.9f),
        )

        val transition = rememberInfiniteTransition(label = "")
        val translateAnimation = transition.animateFloat(
            initialValue = 100f,
            targetValue = 2000f,
            animationSpec = infiniteRepeatable(
                animation = tween(900),
                repeatMode = RepeatMode.Restart
            ),
            label = ""
        )
        Brush.linearGradient(
            colors = shimmerColors,
            start = Offset.Zero,
            end = Offset(
                x = translateAnimation.value,
                y = translateAnimation.value
            )
        )
    } else {
        Brush.linearGradient(
            colors = listOf(Color.Transparent, Color.Transparent),
            start = Offset.Zero,
            end = Offset.Zero
        )
    }
}
