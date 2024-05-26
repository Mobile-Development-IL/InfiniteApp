package com.infinitelearning.infiniteapp.data.local.dummy

import com.infinitelearning.infiniteapp.R
import com.infinitelearning.infiniteapp.domain.model.Course
import com.infinitelearning.infiniteapp.domain.model.Gallery
import com.infinitelearning.infiniteapp.domain.model.Mentor

object DummyData {
    val mobileMentors = listOf(
        Mentor(
            id = 1,
            name = "Reza Kurniawan",
            nickname = "Reza",
            role = "Technical Mobile",
            photo = R.drawable.reza
        ),
        Mentor(
            id = 2,
            name = "Reynaldi",
            nickname = "Rey",
            role = "Technical Mobile",
            photo = R.drawable.reynaldi
        ),
        Mentor(
            id = 3,
            name = "Raihan Zaky",
            nickname = "Han",
            role = "Technical Mobile",
            photo = R.drawable.raihan
        ),
        Mentor(
            id = 4,
            name = "Nabila Syafrina Bukka",
            nickname = "Nab",
            role = "Technical Mobile",
            photo = R.drawable.nabila
        ),
        Mentor(
            id = 5,
            name = "Rahmad Noor Ikhsan",
            nickname = "Mad",
            role = "Technical Mobile",
            photo = R.drawable.rahmad
        )
    )

//    val mobileMentees = listOf(
//        Mentee(
//            id = 1,
//            name = "Nama Mentee",
//            photo = R.drawable.no_profile,
//            batch = "Batch 6",
//            role = "Mentee Mobile",
//        ),
//        Mentee(
//            id = 2,
//            name = "Nama Mentee",
//            photo = R.drawable.no_profile,
//            batch = "Batch 6",
//            role = "Mentee Mobile",
//        ),
//        Mentee(
//            id = 3,
//            name = "Nama Mentee",
//            photo = R.drawable.no_profile,
//            batch = "Batch 6",
//            role = "Mentee Mobile",
//        ),
//        Mentee(
//            id = 4,
//            name = "Nama Mentee",
//            photo = R.drawable.no_profile,
//            batch = "Batch 6",
//            role = "Mentee Mobile",
//        ),
//        Mentee(
//            id = 5,
//            name = "Nama Mentee",
//            photo = R.drawable.no_profile,
//            batch = "Batch 6",
//            role = "Mentee Mobile",
//        ),
//        Mentee(
//            id = 6,
//            name = "Nama Mentee",
//            photo = R.drawable.no_profile,
//            batch = "Batch 6",
//            role = "Mentee Mobile",
//        ),
//        Mentee(
//            id = 7,
//            name = "Nama Mentee",
//            photo = R.drawable.no_profile,
//            batch = "Batch 6",
//            role = "Mentee Mobile",
//        ),
//        Mentee(
//            id = 8,
//            name = "Nama Mentee",
//            photo = R.drawable.no_profile,
//            batch = "Batch 6",
//            role = "Mentee Mobile",
//        ),
//        Mentee(
//            id = 9,
//            name = "Nama Mentee",
//            photo = R.drawable.no_profile,
//            batch = "Batch 6",
//            role = "Mentee Mobile",
//        ),
//        Mentee(
//            id = 10,
//            name = "Nama Mentee",
//            photo = R.drawable.no_profile,
//            batch = "Batch 6",
//            role = "Mentee Mobile",
//        ),
//        Mentee(
//            id = 11,
//            name = "Nama Mentee",
//            photo = R.drawable.no_profile,
//            batch = "Batch 6",
//            role = "Mentee Mobile",
//        )
//    )

    val mobileCourses = listOf(
        Course(
            id = 1,
            name = "Kotlin Introduction",
            level = "Beginner",
            photo = R.drawable.kotlin_introduction
        ),
        Course(
            id = 2,
            name = "Kotlin Fundamental",
            level = "Fundamental",
            photo = R.drawable.kotlin_fundamental
        ),
        Course(
            id = 3,
            name = "Kotlin Coroutines",
            level = "Intermediate",
            photo = R.drawable.kotlin_coroutines
        ),
        Course(
            id = 4,
            name = "Jetpack Compose Introduction",
            level = "Beginner",
            photo = R.drawable.compose_introduction
        ),
        Course(
            id = 5,
            name = "Jetpack Compose Fundamental",
            level = "Fundamental",
            photo = R.drawable.compose_fundamental
        ),
        Course(
            id = 6,
            name = "Jetpack Compose Navigation",
            level = "Intermediate",
            photo = R.drawable.compose_navigation
        ),
        Course(
            id = 7,
            name = "Jetpack Compose Retrofit",
            level = "Intermediate",
            photo = R.drawable.compose_retrofit
        ),
        Course(
            id = 8,
            name = "Jetpack Compose Injection",
            level = "Expert",
            photo = R.drawable.compose_injection
        )
    )

    val infiniteGalleries = listOf(
        Gallery(
            id = 1,
            name = "Digital Marketing",
            photo = R.drawable.digital_marketing
        ),
        Gallery(
            id = 2,
            name = "Menjadi Designer",
            photo = R.drawable.designer
        ),
        Gallery(
            id = 3,
            name = "Modern Android in 2024",
            photo = R.drawable.modern_android
        ),
        Gallery(
            id = 4,
            name = "Iftar Inners",
            photo = R.drawable.iftar
        ),
        Gallery(
            id = 5,
            name = "Container Technology",
            photo = R.drawable.container_technologi
        ),
        Gallery(
            id = 6,
            name = "Filosofi Ilo",
            photo = R.drawable.filosofi_ilo
        ),
        Gallery(
            id = 7,
            name = "Tips Lulus MSIB",
            photo = R.drawable.lulus_msib
        ),
        Gallery(
            id = 8,
            name = "Fresh Graduate jadi Manager",
            photo = R.drawable.manager
        ),
        Gallery(
            id = 9,
            name = "Kenapa IBM Academy?",
            photo = R.drawable.ibm_academy
        ),
        Gallery(
            id = 10,
            name = "Unreal Engine",
            photo = R.drawable.unreal_engine
        ),
        Gallery(
            id = 11,
            name = "Masih Stuck di Chat GPT?",
            photo = R.drawable.stuck_chatgpt
        ),
    )
}