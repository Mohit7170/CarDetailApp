package com.app.testapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.app.testapplication.MainRoutes
import com.app.testapplication.R
import com.app.testapplication.ui.theme.BlackColor
import com.app.testapplication.ui.theme.GrayColor
import com.app.testapplication.ui.theme.strawfordFamily

@Composable
fun MainScreen(navController: NavHostController) {
    Box {

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(top = 40.dp, bottom = 60.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_logo),
                    contentDescription = "logo",
                    modifier = Modifier.size(44.dp)
                )

                var searchText by remember {
                    mutableStateOf("")
                }
                val style = TextStyle(
                    fontFamily = strawfordFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    lineHeight = 0.sp,
                )

                OutlinedTextField(
                    modifier = Modifier
                        .width(150.dp)
                        .height(50.dp),
                    shape = CircleShape,
                    colors = OutlinedTextFieldDefaults.colors().copy(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                    ),
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "search",
                            tint = GrayColor,
                        )
                    },
                    placeholder = {
                        if (searchText.isEmpty()) {
                            Text(
                                text = "Search...",
                                style = style,
                                color = GrayColor
                            )
                        }
                    },
                    textStyle = style.copy(color = BlackColor),
                    value = searchText,
                    onValueChange = {
                        searchText = it
                    })
            }
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 12.dp)
            ) {
                repeat(4) {
                    item {
                        Box(
                            modifier = Modifier
                                .clickable {
                                    navController.navigate(MainRoutes.ItemScreen)
                                }
                                .width(278.dp)
                                .padding(8.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color.White)
                        ) {
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                            ) {
                                Image(
                                    modifier = Modifier.fillMaxWidth(),
                                    painter = painterResource(id = R.drawable.ic_car),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop
                                )

                                Column(
                                    verticalArrangement = Arrangement.spacedBy(12.dp),
                                    modifier = Modifier.padding(
                                        vertical = 16.dp,
                                        horizontal = 12.dp
                                    )
                                ) {


                                    Text(
                                        "technology",
                                        color = BlackColor,
                                        fontFamily = strawfordFamily,
                                        fontWeight = FontWeight.Medium,
                                        fontSize = 14.sp
                                    )

                                    val annotatedString = buildAnnotatedString {
                                        withStyle(
                                            style = SpanStyle(
                                                fontWeight = FontWeight.Bold,
                                                color = BlackColor
                                            )
                                        ) {
                                            append("Step Into Tomorrow:")
                                        }
                                        append("\n")
                                        withStyle(style = SpanStyle(color = BlackColor)) {
                                            append("Exploring Spatial Computing’s Impact On Industries And The Metaverse!")
                                        }
                                    }

                                    Text(
                                        annotatedString,
                                        color = BlackColor,
                                        fontFamily = strawfordFamily,
                                        fontWeight = FontWeight.Medium,
                                        fontSize = 16.sp,
                                        maxLines = 3
                                    )

                                    Text(
                                        text = "26 Feb 2024",
                                        color = GrayColor,
                                        fontFamily = strawfordFamily,
                                        fontWeight = FontWeight.Medium,
                                        fontSize = 12.sp,
                                    )
                                }
                            }

                            Icon(
                                painter = painterResource(id = R.drawable.ic_bookmark),
                                contentDescription = "bookmark",
                                tint = Color.Unspecified,
                                modifier = Modifier
                                    .size(60.dp)
                                    .padding(12.dp)
                                    .align(Alignment.TopStart)
                            )

                            Icon(
                                painter = painterResource(id = R.drawable.ic_star),
                                contentDescription = "star",
                                tint = Color.Unspecified,
                                modifier = Modifier
                                    .size(60.dp)
                                    .padding(12.dp)
                                    .align(Alignment.TopEnd)
                            )
                        }
                    }

                }
            }

            Text(
                "Recent Articles",
                color = BlackColor,
                fontFamily = strawfordFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 12.dp),
                fontSize = 22.sp
            )
            Column(
                modifier = Modifier.padding(start = 12.dp),
//                contentPadding = PaddingValues(bottom = 12.dp)
            ) {
                repeat(4) {
                    Row(
                        modifier = Modifier
                            .clickable {
                                navController.navigate(MainRoutes.ItemScreen)
                            }
                            .padding(8.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color.White)
                            .height(320.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)

                    ) {
                        Image(
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(150.dp),
                            painter = painterResource(id = R.drawable.ic_car),
                            contentDescription = null,
                            contentScale = ContentScale.FillHeight
                        )

                        Column(
                            verticalArrangement = Arrangement.spacedBy(12.dp),
                            modifier = Modifier.padding(
                                vertical = 16.dp,
                                horizontal = 12.dp
                            )
                        ) {

                            Icon(
                                painter = painterResource(id = R.drawable.ic_video),
                                contentDescription = "video",
                                tint = Color.Unspecified
                            )

                            Text(
                                "technology",
                                color = BlackColor,
                                fontFamily = strawfordFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp
                            )

                            val annotatedString = buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        fontWeight = FontWeight.Bold,
                                        color = BlackColor
                                    )
                                ) {
                                    append("Step Into Tomorrow:")
                                }
                                append("\n")
                                withStyle(style = SpanStyle(color = BlackColor)) {
                                    append("Exploring Spatial Computing’s Impact On Industries And The Metaverse!")
                                }
                            }

                            Text(
                                annotatedString,
                                color = BlackColor,
                                fontFamily = strawfordFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 16.sp,
                                maxLines = 4
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Text(
                                text = "26 Feb 2024",
                                color = GrayColor,
                                fontFamily = strawfordFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 12.sp,
                            )
                        }
                    }
                }
            }
        }

        BottomNavBar(
            modifier = Modifier.align(Alignment.BottomCenter).padding(horizontal = 16.dp)
        )

    }
}