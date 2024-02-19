plugins {
    id(Plugins.pureKotlin)
    id(Plugins.kapt)
}

dependencies {
    implementation(Dependencies.Dagger.dagger)
    kapt(Dependencies.Dagger.annotationProcessorCompiler)
    testImplementation(Dependencies.Testing.junit)
}