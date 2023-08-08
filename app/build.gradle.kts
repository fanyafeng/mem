plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    namespace = "cn.edu.bjtu.gs"
    compileSdk = 33

    defaultConfig {
        applicationId = "cn.edu.bjtu.gs"
        minSdk = 24
        targetSdk = 32
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        named("release") {
            isMinifyEnabled = false
            setProguardFiles(
                listOf(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    viewBinding.isEnabled = true
    dataBinding.isEnabled = true

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    implementation("androidx.navigation:navigation-fragment-ktx:2.4.1")
    implementation("androidx.navigation:navigation-ui-ktx:2.4.1")

    implementation("com.github.fanyafeng:ripple-log:0.0.1")
    implementation("com.github.fanyafeng:ripple-tool:0.0.2")
    implementation("com.github.fanyafeng:ripple-task:0.0.4")
    implementation("com.github.fanyafeng:ripple-http:0.0.3")
//    implementation(project(":ripple_http"))
    implementation("com.github.fanyafeng:ripple-dialog:0.0.2")
    implementation("com.google.protobuf:protobuf-java-util:4.0.0-rc-2")
    implementation("com.google.protobuf:protobuf-kotlin:3.21.6")
    implementation("com.google.protobuf.nano:protobuf-javanano:3.1.0")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    testImplementation("junit:junit:4.13.2")

    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")

    //协程
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1")
    //okhttp
    implementation("com.squareup.okhttp3:okhttp:4.9.3")
    implementation("com.alibaba:fastjson:2.0.10.android")
    implementation("com.google.code.gson:gson:2.10.1")

    //coil
//    implementation("io.coil-kt:coil:1.0.0")
//    implementation("io.coil-kt:coil-gif:1.0.0")
//    implementation("io.coil-kt:coil-svg:1.0.0")
//    implementation("io.coil-kt:coil-video:1.0.0")

    //glide
    implementation("com.github.bumptech.glide:glide:4.13.0")
    implementation("com.github.bumptech.glide:annotations:4.13.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.13.0")
    kapt("com.github.bumptech.glide:compiler:4.13.0")
    implementation("com.github.bumptech.glide:okhttp3-integration:4.13.0") {
        exclude("glide-parent")
    }

    //datastore
    implementation("androidx.datastore:datastore:1.0.0")
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    implementation("com.timehop.stickyheadersrecyclerview:library:0.4.3@aar")


    //android room
//    val room_version = "2.4.2"
    implementation("androidx.room:room-runtime:2.5.0")
    implementation("androidx.room:room-ktx:2.5.0")
    annotationProcessor("androidx.room:room-compiler:2.5.0")
    kapt("androidx.room:room-compiler:2.5.0")

    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

}