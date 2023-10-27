package com.bup.to_docompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val md_theme_light_primary = Color(0xFF6C1DFF)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_primaryContainer = Color(0xFFE8DDFF)
val md_theme_light_onPrimaryContainer = Color(0xFF21005E)
val md_theme_light_secondary = Color(0xFF345CA8)
val md_theme_light_onSecondary = Color(0xFFFFFFFF)
val md_theme_light_secondaryContainer = Color(0xFFD8E2FF)
val md_theme_light_onSecondaryContainer = Color(0xFF001A43)
val md_theme_light_tertiary = Color(0xFF984062)
val md_theme_light_onTertiary = Color(0xFFFFFFFF)
val md_theme_light_tertiaryContainer = Color(0xFFFFD9E3)
val md_theme_light_onTertiaryContainer = Color(0xFF3E001E)
val md_theme_light_error = Color(0xFFBA1A1A)
val md_theme_light_errorContainer = Color(0xFFFFDAD6)
val md_theme_light_onError = Color(0xFFFFFFFF)
val md_theme_light_onErrorContainer = Color(0xFF410002)
val md_theme_light_background = Color(0xFFFFFBFF)
val md_theme_light_onBackground = Color(0xFF3E0021)
val md_theme_light_surface = Color(0xFFFFFBFF)
val md_theme_light_onSurface = Color(0xFF3E0021)
val md_theme_light_surfaceVariant = Color(0xFFE6E0EC)
val md_theme_light_onSurfaceVariant = Color(0xFF48454E)
val md_theme_light_outline = Color(0xFF79757F)
val md_theme_light_inverseOnSurface = Color(0xFFFFECF0)
val md_theme_light_inverseSurface = Color(0xFF5D1137)
val md_theme_light_inversePrimary = Color(0xFFCEBDFF)
val md_theme_light_shadow = Color(0xFF000000)
val md_theme_light_surfaceTint = Color(0xFF6C1DFF)
val md_theme_light_outlineVariant = Color(0xFFCAC4CF)
val md_theme_light_scrim = Color(0xFF000000)

val md_theme_dark_primary = Color(0xFFCEBDFF)
val md_theme_dark_onPrimary = Color(0xFF390094)
val md_theme_dark_primaryContainer = Color(0xFF5200CE)
val md_theme_dark_onPrimaryContainer = Color(0xFFE8DDFF)
val md_theme_dark_secondary = Color(0xFFAEC6FF)
val md_theme_dark_onSecondary = Color(0xFF002E6B)
val md_theme_dark_secondaryContainer = Color(0xFF14448F)
val md_theme_dark_onSecondaryContainer = Color(0xFFD8E2FF)
val md_theme_dark_tertiary = Color(0xFFFFB0C9)
val md_theme_dark_onTertiary = Color(0xFF5E1134)
val md_theme_dark_tertiaryContainer = Color(0xFF7A294B)
val md_theme_dark_onTertiaryContainer = Color(0xFFFFD9E3)
val md_theme_dark_error = Color(0xFFFFB4AB)
val md_theme_dark_errorContainer = Color(0xFF93000A)
val md_theme_dark_onError = Color(0xFF690005)
val md_theme_dark_onErrorContainer = Color(0xFFFFDAD6)
val md_theme_dark_background = Color(0xFF3E0021)
val md_theme_dark_onBackground = Color(0xFFFFD9E4)
val md_theme_dark_surface = Color(0xFF3E0021)
val md_theme_dark_onSurface = Color(0xFFFFD9E4)
val md_theme_dark_surfaceVariant = Color(0xFF48454E)
val md_theme_dark_onSurfaceVariant = Color(0xFFCAC4CF)
val md_theme_dark_outline = Color(0xFF938F99)
val md_theme_dark_inverseOnSurface = Color(0xFF3E0021)
val md_theme_dark_inverseSurface = Color(0xFFFFD9E4)
val md_theme_dark_inversePrimary = Color(0xFF6C1DFF)
val md_theme_dark_shadow = Color(0xFF000000)
val md_theme_dark_surfaceTint = Color(0xFFCEBDFF)
val md_theme_dark_outlineVariant = Color(0xFF48454E)
val md_theme_dark_scrim = Color(0xFF000000)


val seed = Color(0xFF6C1DFF)
val CustomColor1 = Color(0xFF477B73)
val light_CustomColor1 = Color(0xFF006A60)
val light_onCustomColor1 = Color(0xFFFFFFFF)
val light_CustomColor1Container = Color(0xFF74F8E6)
val light_onCustomColor1Container = Color(0xFF00201C)
val dark_CustomColor1 = Color(0xFF53DBCA)
val dark_onCustomColor1 = Color(0xFF003731)
val dark_CustomColor1Container = Color(0xFF005048)
val dark_onCustomColor1Container = Color(0xFF74F8E6)


val LightGray = Color(0xFFFCFCFC)
val MediumGray = Color(0xFF9C9C9C)
val DarkGray = Color(0xFF141414)

val HighPriorityColor = Color(0xFFFF4646)
val MediumPriorityColor = Color(0xFFFFC114)
val LowPriorityColor = Color(0xFF00C980)
val NonePriorityColor = MediumGray

val ColorScheme.splashScreenBackground: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) md_theme_light_onPrimaryContainer else Color.Black
val ColorScheme.taskItemTextColor: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Color.DarkGray else Color.LightGray
val ColorScheme.taskItemBackgroundColor: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Color.White else DarkGray
val ColorScheme.fabBackgroundColor: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) md_theme_light_primary else md_theme_dark_primary

val ColorScheme.topAppBarContentColor: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Color.Black else Color.LightGray

val ColorScheme.topAppBarBackgroundColor: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) md_theme_light_primary else md_theme_dark_inversePrimary