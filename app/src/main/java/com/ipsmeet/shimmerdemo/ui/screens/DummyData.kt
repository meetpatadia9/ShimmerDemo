package com.ipsmeet.shimmerdemo.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.ipsmeet.shimmerdemo.api.RetrofitViewModel
import com.ipsmeet.shimmerdemo.composeutils.ShimmerImage
import com.ipsmeet.shimmerdemo.composeutils.ShimmerText
import com.ipsmeet.shimmerdemo.model.PostsItem

@Composable
fun DummyData(
    modifier: Modifier = Modifier,
    retrofitViewModel: RetrofitViewModel = viewModel()
) {
    val data by retrofitViewModel.allPosts.observeAsState()
    val showShimmer by rememberSaveable { mutableStateOf(data!!.isEmpty()) }

    Column {
        ShimmerText(
            text = "Breaking News",
            showShimmer = showShimmer,
            modifier = Modifier.padding(10.dp)
        )
        Box {
            if (showShimmer) {
                LazyColumn(
                    modifier = modifier,
                    userScrollEnabled = false
                ) {
                    items(9) { ShimmerPostItem() }
                }   // LazyColumn
            } else {
                LazyColumn(modifier = modifier) {
                    items(data!!, key = { it.id }) {
                        PostItem(postsItem = it)
                    }
                }   // LazyColumn
            }
        }
    }


}


@Composable
fun ShimmerPostItem(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            .shadow(
                shape = MaterialTheme.shapes.small,
                spotColor = Color.DarkGray,
                elevation = 5.dp
            )
            .clip(shape = MaterialTheme.shapes.small),
    ) {
        Row {
            ShimmerImage(
                model = "",
                contentDescription = "",
                modifier = Modifier.size(100.dp)
            )
            ShimmerText(
                text = "",
                modifier = Modifier.padding(5.dp),
            )
        }   // Row
    } // Card
}


@Composable
fun PostItem(
    modifier: Modifier = Modifier,
    postsItem: PostsItem
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            .shadow(
                shape = MaterialTheme.shapes.small,
                spotColor = Color.DarkGray,
                elevation = 5.dp
            )
            .clip(shape = MaterialTheme.shapes.small),
    ) {
        Row {
            AsyncImage(
                model = postsItem.thumbnailUrl,
                contentDescription = "",
                modifier = Modifier.size(100.dp)
            )
            Text(
                text = postsItem.title,
                modifier = Modifier.padding(5.dp),
            )
        }   // Row
    } // Card
}