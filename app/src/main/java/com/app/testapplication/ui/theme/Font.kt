package com.app.testapplication.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.app.testapplication.R

val northwellFamily = FontFamily(
    Font(R.font.northwell, FontWeight.Normal),
    Font(R.font.northwell_alt, FontWeight.Thin),

)

val scillaFamily = FontFamily(
    Font(R.font.scilla_regular, FontWeight.Normal),
    Font(R.font.scilla_regular_italic, FontWeight.Normal,FontStyle.Italic),
    Font(R.font.scillanarrow_regular, FontWeight.Light),
    Font(R.font.scilla_narrow_regular_italic, FontWeight.Light, FontStyle.Italic),
)

val strawfordFamily = FontFamily(
    Font(R.font.strawford_bold, FontWeight.Bold),
    Font(R.font.strawford_thin, FontWeight.Thin),
    Font(R.font.strawford_black, FontWeight.Black),
    Font(R.font.strawford_light, FontWeight.Light),
    Font(R.font.strawford_medium, FontWeight.Medium),
    Font(R.font.strawford_regular, FontWeight.Normal),
    Font(R.font.strawford_extralight, FontWeight.ExtraLight),
)

