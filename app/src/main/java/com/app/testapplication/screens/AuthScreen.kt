package com.app.testapplication.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.testapplication.MainRoutes
import com.app.testapplication.R
import com.app.testapplication.ui.theme.BgColor
import com.app.testapplication.ui.theme.BlackColor
import com.app.testapplication.ui.theme.GrayColor
import com.app.testapplication.ui.theme.scillaFamily
import com.app.testapplication.ui.theme.strawfordFamily

@Composable
fun AuthScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .background(BgColor)
            .padding(12.dp)
            .padding(top = 80.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "logo",
            modifier = Modifier.size(42.dp)
        )
        Text(
            "Welcome",
            color = BlackColor,
            fontFamily = strawfordFamily,
            fontWeight = FontWeight.Black,
            fontSize = 24.sp
        )

        Text(
            "In a world of finite resources, the true measure of innovation lies not in its complexity, but in its capacity to simplify and empower the human mind.",
            color = BlackColor,
            fontFamily = scillaFamily,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Italic,
            fontSize = 28.sp,
            modifier = Modifier.padding(top = 16.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Button(
                onClick = {
                    navController.navigate(MainRoutes.MainScreen)
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors().copy(
                    containerColor = BlackColor
                ),
                contentPadding = PaddingValues(18.dp),
            ) {
                Text(
                    "Sign-up",
                    color = Color.White,
                    fontFamily = strawfordFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp
                )
            }

            Button(
                onClick = {
                    navController.navigate(MainRoutes.MainScreen)
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors().copy(
                    containerColor = Color.White
                ),
                border = BorderStroke(1.dp, BlackColor),
                contentPadding = PaddingValues(18.dp),
            ) {
                Text(
                    "Sign-in",
                    color = BlackColor,
                    fontFamily = strawfordFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp
                )
            }

            Text(
                "Terms",
                color = GrayColor,
                fontFamily = strawfordFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                modifier = Modifier
                    .drawBehind {
                        val strokeWidthPx = 1.dp.toPx()
                        val verticalOffset = size.height - 2.sp.toPx()
                        drawLine(
                            color = GrayColor,
                            strokeWidth = strokeWidthPx,
                            start = Offset(0f, verticalOffset),
                            end = Offset(size.width, verticalOffset)
                        )
                    }
                    .padding(top = 20.dp)
            )

        }

    }
}