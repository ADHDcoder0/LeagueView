package com.example.leagueview.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.leagueview.R


val BebasNeue = FontFamily(
    Font(R.font.bebasneue) // filename without extension
)

// Set of Material typography styles to start with
val Typography = Typography(

    // Big headers (STANDINGS, LALIGA)
    headlineLarge = TextStyle(
        fontFamily = BebasNeue,
        fontSize = 28.sp,
        letterSpacing = 1.5.sp
    ),

    // Card titles (FC BARCELONA)
    headlineMedium = TextStyle(
        fontFamily = BebasNeue,
        fontSize = 22.sp,
        letterSpacing = 1.2.sp
    ),

    // Labels (PTS, RANK)
    titleMedium = TextStyle(
        fontFamily = BebasNeue,
        fontSize = 16.sp,
        letterSpacing = 1.sp
    ),

    // Numbers (88 pts)
    bodyLarge = TextStyle(
        fontFamily = BebasNeue,
        fontSize = 18.sp,
        letterSpacing = 0.8.sp
    ),

    // Small captions
    labelSmall = TextStyle(
        fontFamily = BebasNeue,
        fontSize = 12.sp,
        letterSpacing = 1.sp
    )
)