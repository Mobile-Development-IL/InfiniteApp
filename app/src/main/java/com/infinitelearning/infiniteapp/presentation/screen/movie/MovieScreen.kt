package com.infinitelearning.infiniteapp.presentation.screen.movie

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

@Composable
fun MovieScreen(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val exoPlayer = ExoPlayer.Builder(context).build()
    val mediaSource =
        remember { MediaItem.fromUri("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4") }

    MovieContent(
        exoPlayer = exoPlayer,
        mediaSource = mediaSource,
        modifier = modifier
    )
}

@Composable
fun MovieContent(
    exoPlayer: ExoPlayer,
    mediaSource: MediaItem,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(mediaSource) {
        exoPlayer.setMediaItem(mediaSource)
        exoPlayer.prepare()
    }

    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        AndroidView(
            factory = { ctx ->
                PlayerView(ctx).apply {
                    player = exoPlayer
                }
            },
            modifier = modifier
                .fillMaxWidth()
                .height(200.dp)
        )
    }
}
