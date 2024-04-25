package com.infinitelearning.infiniteapp.presentation.component

import android.content.Context
import android.content.Intent
import com.infinitelearning.infiniteapp.R

fun shareItem(context: Context){
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, context.getString(R.string.infinite_share))
        putExtra(Intent.EXTRA_TEXT, context.getString(R.string.share_message))
    }

    context.startActivity(
        Intent.createChooser(
            intent,
            context.getString(R.string.infinite_share)
        )
    )
}