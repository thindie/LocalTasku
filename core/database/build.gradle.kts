plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kapt)
}

android {
    namespace = "com.thindie.database"
    compileSdk = Config.compileSdk

    defaultConfig {

        minSdk = Config.minSdk


        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        multiDexEnabled = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
    kotlin {
        jvmToolchain(Config.toolChain)
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Dependencies.ReleaseBuild.multiDex)


    // Dagger
    implementation(Dependencies.Dagger.dagger)

    kapt(Dependencies.Dagger.annotationProcessorCompiler)

    // Testing
    testImplementation(Dependencies.Testing.junit)
    androidTestImplementation(Dependencies.Testing.androidJunit)
    androidTestImplementation(Dependencies.Testing.espresso)
    androidTestImplementation(platform(Dependencies.Compose.bom))
    androidTestImplementation(Dependencies.Testing.composeJunit)
    debugImplementation(Dependencies.Compose.tooling)
    debugImplementation(Dependencies.Compose.manifest)

    // Room
    implementation(Dependencies.Room.roomRuntime)
    kapt(Dependencies.Room.roomCompiler)
    implementation(Dependencies.Room.roomPaging)
    implementation(Dependencies.Room.roomCoroutines)


    // Gson
    implementation(Dependencies.Gson.gson)
    implementation(project(Modules.domain))

}