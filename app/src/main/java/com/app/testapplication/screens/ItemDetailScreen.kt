package com.app.testapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.testapplication.R
import com.app.testapplication.ui.theme.BlackColor
import com.app.testapplication.ui.theme.GrayColor
import com.app.testapplication.ui.theme.strawfordFamily

@Composable
fun ItemDetailScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(vertical = 12.dp)
            .padding(top = 20.dp),
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
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "back",
                modifier = Modifier
                    .clickable {
                        navController.popBackStack()
                    }
                    .size(44.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "logo",
                modifier = Modifier.size(44.dp)
            )
        }


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
            fontWeight = FontWeight.Normal,
            fontSize = 24.sp,
            maxLines = 4,
            modifier = Modifier
                .padding(horizontal = 12.dp),
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            TitleHeading(
                title = "Type",
                heading = "Article"
            )
            TitleHeading(
                title = "Category",
                heading = "Technology"
            )
            TitleHeading(
                title = "Date",
                heading = "26 Feb 2024"
            )

        }

        Box(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .clip(RoundedCornerShape(16.dp)),
        ) {

            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = painterResource(id = R.drawable.ic_car),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )

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
                painter = painterResource(id = R.drawable.ic_share),
                contentDescription = "bookmark",
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(60.dp)
                    .padding(12.dp)
                    .align(Alignment.TopEnd)
            )

        }


        val items =
            listOf("Intro", "Now: Simulating the enterprise", "Introduction #1")
        var seleceted by remember {
            mutableStateOf(items.first())
        }
        LazyRow(
            modifier = Modifier.padding(horizontal = 12.dp),
        ) {
            items(items) {
                Text(
                    text = it,
                    color = if (it == seleceted) BlackColor else GrayColor,
                    fontFamily = strawfordFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .clickable { seleceted = it }
                        .padding(4.dp)
                        .padding(horizontal = 8.dp)
                )
            }
        }

        HorizontalDivider()

        Column(
            modifier = Modifier.padding(horizontal = 12.dp),
        ) {
            Row {
                Text(
                    text = "A",
                    color = BlackColor,
                    fontFamily = strawfordFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 80.sp,
                )
                Text(
                    text = "s the industrial metaverse evolves into a critical enterprise , industrial applications. Leveraging the power of data and artificial intelligence, these technologies are adeptly replicating real-life processes, revolutionising the way industries operate and unlocking new dimensions of efficiency and innovation Frequently,",
                    color = BlackColor,
                    fontFamily = strawfordFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
                    maxLines = 4
                )
            }


            Text(
                text = "the power of data and artificial intelligence, these technologies are adeptly replicating real-life processes, revolutionising the way industries operate and unlocking new dimensions of efficiency and innovation.\n" +
                        "Frequently, innovative technologies generate excitement among early adopters and consumers, only to gradually fade from the public eye. However, these technologies often reemerge months or years later, having transformed into valuable and productive business tools.\n" +
                        "In the current year, we’ve witnessed the evolution of certain metaverse capabilities as they advance into new dimensions, specifically within the expansive realm of spatial computing. Transitioning from being consumer-centric novelties to essential enterprise tools, spatial technologies are gaining significant traction in industrial applications. Companies are increasingly prioritising digital twins, spatial simulation, augmented work instructions, and collaborative digital spaces. These applications not only enhance safety but also contribute to heightened efficiency in factories and businesses.\n" +
                        "Now: Simulating the enterprise\n" +
                        "In recent years, technological progress has laid the foundation for the industrial metaverse. Strategic investments in digital twins, the enabling power of 5G, cloud computing, edge technologies, and artificial intelligence have collectively delivered substantial value, effectively addressing persistent challenges and enhancing overall operational efficiency.\n" +
                        "Executives consistently emphasise process simulation and digital twins as the most prevalent use cases. In intricate industrial environments characterised by complexity, high costs, and precision requirements, robust simulations play a pivotal role. When seamlessly integrated with real-time data and models via the Internet of Things (IoT) and advanced networking, simulations significantly enhance the likelihood of successfully establishing a new operation or optimising an existing one. Notably, analysts project a substantial growth trajectory for the global digital twins market, foreseeing a leap from US\$6.5 billion in 2021 to an estimated US\$125.7 billion by the year 2030.\n" +
                        "Spatial operations are in their infancy, with ongoing advancements in enabling technologies. Imagine a scenario where robust satellite networks seamlessly integrate with IoT sensors in a distant factory, constantly processing real-time data on output and performance. As technology progresses, a forthcoming era of digital twins emerges, featuring photorealistic simulations grounded in physics and empowered by AI. Moreover, these simulations are intricately linked to company ecosystems, exemplified by platforms like BMW’s Omniverse. This transformative evolution is set to influence various facets of enterprise operations, ranging from space planning and design to overall operational processes.\n" +
                        "New: The spatial web is under construction",
                color = BlackColor,
                fontFamily = strawfordFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
            )
        }

        Text(
            "Related Articles",
            color = BlackColor,
            fontFamily = strawfordFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 22.sp,
            modifier = Modifier.padding(start = 12.dp),
        )

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 12.dp)
        ) {
            repeat(4) {
                item {
                    Box(
                        modifier = Modifier
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
                            painter = painterResource(id = R.drawable.ic_video),
                            contentDescription = "video",
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .padding(12.dp)
                                .align(Alignment.TopStart)
                        )
                    }
                }

            }
        }
    }
}

@Composable
private fun TitleHeading(title: String, heading: String) {
    Column {
        Text(
            title,
            color = GrayColor,
            fontFamily = strawfordFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
        )
        Text(
            heading,
            color = BlackColor,
            fontFamily = strawfordFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
        )
    }
}