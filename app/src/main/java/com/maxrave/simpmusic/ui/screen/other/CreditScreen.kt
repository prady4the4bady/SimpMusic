package com.maxrave.simpmusic.ui.screen.other

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.maxrave.simpmusic.R
import com.maxrave.simpmusic.extension.navigateSafe
import com.maxrave.simpmusic.ui.component.RippleIconButton
import com.maxrave.simpmusic.ui.theme.typo
import dev.chrisbanes.haze.HazeMaterials
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.hazeEffect

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun CreditScreen(
    navController: NavController,
    hazeState: HazeState,
) {
    val uriHandler = LocalUriHandler.current
    val scrollState = remember { rememberScrollState() }

    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(horizontal = 20.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // App title and description
        Text(
            text = "free music by prady",
            style = typo.headlineMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(vertical = 10.dp),
            textAlign = TextAlign.Center,
        )
        
        Text(
            text = "A free music streaming app that lets you enjoy unlimited music without any cost. Built with love for music enthusiasts.",
            style = typo.bodyMedium,
            modifier = Modifier.padding(horizontal = 10.dp),
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Developer credit card
        Card(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = colorScheme.surfaceVariant),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Developer",
                    style = typo.titleMedium.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(bottom = 8.dp),
                )
                Text(
                    text = "prady4the4bady",
                    style = typo.bodyLarge,
                    modifier = Modifier.padding(bottom = 4.dp),
                )
                Text(
                    text = "Creator of free music by prady",
                    style = typo.bodyMedium,
                    textAlign = TextAlign.Center,
                )
            }
        }

        // Original app credit card
        Card(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = colorScheme.surfaceVariant),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Original SimpMusic",
                    style = typo.titleMedium.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(bottom = 8.dp),
                )
                Text(
                    text = "maxrave-dev",
                    style = typo.bodyLarge,
                    modifier = Modifier.padding(bottom = 4.dp),
                )
                Text(
                    text = "Original creator of SimpMusic, adapted for free music by prady",
                    style = typo.bodyMedium,
                    textAlign = TextAlign.Center,
                )
            }
        }

        // Libraries and dependencies
        Text(
            text = "Built with",
            style = typo.titleMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top = 10.dp, bottom = 5.dp),
        )

        val libraries = listOf(
            "Jetpack Compose" to "Modern Android UI toolkit",
            "Material Design 3" to "Google's design system",
            "YouTube Music API" to "Music streaming backend",
            "ExoPlayer" to "Media playback framework",
            "Room Database" to "Local data persistence",
            "Hilt" to "Dependency injection",
            "Retrofit" to "HTTP client library",
            "Coil" to "Image loading library"
        )

        libraries.forEach { (name, description) ->
            Card(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 2.dp),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = colorScheme.surface),
            ) {
                Column(
                    modifier = Modifier.padding(12.dp),
                ) {
                    Text(
                        text = name,
                        style = typo.bodyLarge.copy(fontWeight = FontWeight.Medium),
                    )
                    Text(
                        text = description,
                        style = typo.bodySmall,
                        color = colorScheme.onSurfaceVariant,
                    )
                }
            }
        }

        // Support section
        Card(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 10.dp)
                    .clickable {
                        uriHandler.openUri("https://www.buymeacoffee.com/prady4the4bady")
                    },
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = colorScheme.primaryContainer),
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_coffee),
                    contentDescription = null,
                    modifier = Modifier.size(32.dp),
                )
                Column {
                    Text(
                        text = "Support Development",
                        style = typo.bodyLarge.copy(fontWeight = FontWeight.Medium),
                        color = colorScheme.onPrimaryContainer,
                    )
                    Text(
                        text = "Buy me a coffee to support free music by prady",
                        style = typo.bodySmall,
                        color = colorScheme.onPrimaryContainer,
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        
        // Copyright text
        Text(
            text = "© 2024 free music by prady. All rights reserved.",
            style = typo.bodySmall,
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp, vertical = 5.dp),
            textAlign = TextAlign.Center,
        )
        
        // Bottom spacing
        Spacer(modifier = Modifier.height(200.dp))
    }
    TopAppBar(
        modifier =
            Modifier
                .hazeEffect(state = hazeState, style = HazeMaterials.ultraThin()) {
                    blurEnabled = true
                },
        title = {
            Text(
                text = "free music by prady",
                style = typo.titleMedium,
                maxLines = 1,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(
                            align = Alignment.CenterVertically,
                        ).basicMarquee(
                            iterations = Int.MAX_VALUE,
                            animationMode = MarqueeAnimationMode.Immediately,
                        ).focusable(),
            )
        },
        navigationIcon = {
            Box(Modifier.padding(horizontal = 5.dp)) {
                RippleIconButton(
                    R.drawable.baseline_arrow_back_ios_new_24,
                    Modifier
                        .size(32.dp),
                    true,
                ) {
                    navController.navigateUp()
                }
            }
        },
        colors =
            TopAppBarDefaults.largeTopAppBarColors(Color.Transparent),
    )
}
