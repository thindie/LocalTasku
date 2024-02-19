plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kapt)
}

android {
    namespace = "com.thindie.tasks_general"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.0"
    }
}

dependencies {
    //lifecycle
    implementation(Dependencies.Lifecycle.core)
    implementation(Dependencies.Lifecycle.lifecycleRuntime)
    implementation(Dependencies.Lifecycle.activityCompose)
    implementation(Dependencies.Lifecycle.сomposeLifecycle)


    // Compose
    implementation(platform(Dependencies.Compose.bom))
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.uiGraphics)
    implementation(Dependencies.Compose.toolingPreview)
    implementation(Dependencies.Compose.material3)
    implementation(Dependencies.Compose.navigation)
    implementation(Dependencies.Compose.hiltNavigation)

    // Dagger
    implementation(Dependencies.Dagger.dagger)
    implementation(project(mapOf("path" to ":core:design-system")))

    kapt(Dependencies.Dagger.annotationProcessorCompiler)

    //Network

    implementation(Dependencies.Network.retrofit)

    // Testing
    testImplementation(Dependencies.Testing.junit)
    androidTestImplementation(Dependencies.Testing.androidJunit)
    androidTestImplementation(Dependencies.Testing.espresso)
    androidTestImplementation(platform(Dependencies.Compose.bom))
    androidTestImplementation(Dependencies.Testing.composeJunit)
    debugImplementation(Dependencies.Compose.tooling)
    debugImplementation(Dependencies.Compose.manifest)

    implementation(project(Modules.common))
    implementation(project(Modules.domain))
    implementation(project(Modules.database))
}