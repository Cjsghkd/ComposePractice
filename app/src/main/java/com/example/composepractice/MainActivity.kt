package com.example.composepractice

import android.annotation.SuppressLint

import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.*
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composepractice.JetpackComposeBasics.DefaultPreview
import com.example.composepractice.JetpackComposeBasics.Greeting
import com.example.composepractice.JetpackComposeBasics.MyApp
import com.example.composepractice.LayoutPractive.AlignYourBodyRow
import com.example.composepractice.LayoutPractive.SearchBar
import com.example.composepractice.LayoutPractive.alignYourBodyDataType
import com.example.composepractice.instagram.ProfileScreen
import kotlinx.coroutines.delay
import java.sql.Time
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val list: List<alignYourBodyDataType> = listOf(alignYourBodyDataType(R.drawable.ggae_dal_umm, "GG"), alignYourBodyDataType(R.drawable.background, "PP"),alignYourBodyDataType(R.drawable.ggae_dal_umm, "GG"), alignYourBodyDataType(R.drawable.background, "PP"),alignYourBodyDataType(R.drawable.ggae_dal_umm, "GG"), alignYourBodyDataType(R.drawable.background, "PP"),alignYourBodyDataType(R.drawable.ggae_dal_umm, "GG"), alignYourBodyDataType(R.drawable.background, "PP"))
            AlignYourBodyRow(alignYourBodyData = list)
        }
    }
}










