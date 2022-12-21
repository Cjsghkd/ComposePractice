package com.example.composepractice.LayoutPractive

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composepractice.R
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SearchBar (
    modifier: Modifier = Modifier
) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        placeholder = {
            Text(text = "Search")              
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}

@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.paddingFromBaseline(
                top = 24.dp, bottom = 8.dp
            )
        )
    }
}

@Preview
@Composable
fun AlignYourBodyElementPreview() {
    AlignYourBodyElement(
        drawable = com.example.composepractice.R.drawable.ggae_dal_umm,
        text = "Inversions",
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawable: Int,
    text: String,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(192.dp)
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(56.dp)
            )
            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun FavoriteCollectionCardPreview() {
    FavoriteCollectionCard(
        drawable = com.example.composepractice.R.drawable.background,
        text = "Nature meditations",
        modifier = Modifier.padding(8.dp)
    )
}


@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier,
    alignYourBodyData: List<alignYourBodyDataType>
) {
    LazyRow(
        modifier = modifier
    ) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(drawable = item.drawable, text = item.text)
        }
    }
}

@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier,
    favoriteCollectionData: List<alignYourBodyDataType>
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.height(120.dp)
    ) {
        items(favoriteCollectionData) { item ->
            FavoriteCollectionCard(drawable = item.drawable, text = item.text, modifier = Modifier.height(56.dp))
        }
    }
}

@Composable
fun HomeSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            text = title.uppercase(Locale.getDefault()),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun HomeSectionPreview() {
    val list: List<alignYourBodyDataType> = listOf(alignYourBodyDataType(com.example.composepractice.R.drawable.ggae_dal_umm, "GG"), alignYourBodyDataType(R.drawable.background, "PP"),alignYourBodyDataType(R.drawable.ggae_dal_umm, "GG"), alignYourBodyDataType(R.drawable.background, "PP"),alignYourBodyDataType(R.drawable.ggae_dal_umm, "GG"), alignYourBodyDataType(R.drawable.background, "PP"),alignYourBodyDataType(R.drawable.ggae_dal_umm, "GG"), alignYourBodyDataType(R.drawable.background, "PP"))
    HomeSection(title = "Align your body") {
        AlignYourBodyRow(alignYourBodyData = list)
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val list: List<alignYourBodyDataType> = listOf(alignYourBodyDataType(com.example.composepractice.R.drawable.ggae_dal_umm, "GG"), alignYourBodyDataType(R.drawable.background, "PP"),alignYourBodyDataType(R.drawable.ggae_dal_umm, "GG"), alignYourBodyDataType(R.drawable.background, "PP"),alignYourBodyDataType(R.drawable.ggae_dal_umm, "GG"), alignYourBodyDataType(R.drawable.background, "PP"),alignYourBodyDataType(R.drawable.ggae_dal_umm, "GG"), alignYourBodyDataType(R.drawable.background, "PP"))
    Column(
        modifier
            .verticalScroll(rememberScrollState())
            .padding(vertical = 16.dp)
    ) {
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = "Align your body") {
            AlignYourBodyRow(alignYourBodyData = list)
        }
        HomeSection(title = "Favorite collections") {
            FavoriteCollectionsGrid(favoriteCollectionData = list)
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2, heightDp = 180)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}