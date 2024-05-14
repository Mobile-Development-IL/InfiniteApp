package com.infinitelearning.infiniteapp.data

import com.infinitelearning.infiniteapp.R
import com.infinitelearning.infiniteapp.model.OnBoardingItem

object OnBoardingData {

    val onBoardingItems = listOf(
        OnBoardingItem(
            resId = R.raw.welcome,
            title = "Selamat Datang di Infinite App",
            description = "Tingkatkan Skill Android Development kamu, dengan belajar di platform yang seru."
        ),
        OnBoardingItem(
            resId = R.raw.android,
            title = "Materi selalu Up to Date",
            description = "Materi yang disajikan selalu up to date, mengikuti perkembangan teknologi."
        ),
        OnBoardingItem(
            resId = R.raw.developer,
            title = "Wujudkan Impianmu",
            description = "Dengan belajar secara konsisten. Kamu akan menjadi Developer yang hebat di masa depan"
        ),
    )
}