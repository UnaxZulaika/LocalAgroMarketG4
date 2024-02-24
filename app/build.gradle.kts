plugins {
    id("com.android.application")

    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.localagromarket"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.localagromarket"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    // mapa
    implementation("org.osmdroid:osmdroid-android:6.1.17")

    // Lokalizazioa
    implementation("com.google.android.gms:play-services-location:21.0.1")

    //  Bom erabiltzean firebaseko dependentzia guztiek bom-aren bertsioa artuko dute.
    implementation(platform("com.google.firebase:firebase-bom:32.7.2"))

    // Firebase Authentication
    implementation("com.google.firebase:firebase-auth")

    // Firebase Database
    implementation("com.google.firebase:firebase-database")

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}