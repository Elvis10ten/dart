object Dependencies {

    const val ANDROID_BUILD_TOOLS = "com.android.tools.build:gradle:4.0.0"

    // Kotlin
    private const val KOTLIN_VERSION = "1.3.61"
    const val KOTLIN_STANDARD_LIBRARY = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$KOTLIN_VERSION"
    const val KOTLIN_ANDROID_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:$KOTLIN_VERSION"

    // Google services & Firebase
    const val FIREBASE_BUILDSCRIPT = "com.google.gms:google-services:4.2.0"
    const val FIREBASE_AUTH = "com.google.firebase:firebase-auth:19.2.0"
    const val FIREBASE_ANALYTICS = "com.google.firebase:firebase-analytics:17.2.2"
    const val FIREBASE_MESSAGING = "com.google.firebase:firebase-messaging:20.1.0"
    const val FIREBASE_CRASHLYTICS = "com.google.firebase:firebase-crashlytics:17.0.0-beta01"
    const val FIREBASE_CRASHLYTICS_NDK = "com.crashlytics.sdk.android:crashlytics-ndk:2.1.1"
    const val FIREBASE_REMOTE_CONFIG = "com.google.firebase:firebase-config-ktx:19.1.1"

    // General AndroidX
    const val ANDROIDX_APPCOMPAT = "androidx.appcompat:appcompat:1.1.0"
    const val ANDROIDX_KTX = "androidx.core:core-ktx:1.1.0"
    const val ANDROIDX_CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:1.1.3"
    const val ANDROIDX_ANNOTATIONS = "androidx.annotation:annotation:1.1.0"
    const val ANDROIDX_CORE = "androidx.core:core-ktx:1.2.0"

    // Google tools
    const val ANDROID_MATERIAL_COMPONENTS = "com.google.android.material:material:1.2.0-alpha03"
    const val GSON = "com.google.code.gson:gson:2.8.6"

    // Logging
    const val JAKE_TIMBER = "com.jakewharton.timber:timber:4.7.1"

    // Java
    const val JAVAX_ANNOTATION = "javax.annotation:javax.annotation-api:1.2"

    // GRPC
    const val GRPC_VERSION = "1.26.0"
    const val GRPC_OKHTTP = "io.grpc:grpc-okhttp:$GRPC_VERSION"
    const val GRPC_ANDROID = "io.grpc:grpc-android:$GRPC_VERSION"
    const val GRPC_PROTOBUF_LITE = "io.grpc:grpc-protobuf-lite:$GRPC_VERSION"
    const val GRPC_STUB = "io.grpc:grpc-stub:$GRPC_VERSION"
    const val PROTOBUF_LITE = "com.google.protobuf:protobuf-lite:3.0.1"

    // Tests
    const val JUNIT = "junit:junit:4.12"
    const val ANDROIDX_JUNITX = "androidx.test.ext:junit:1.1.0"
    const val ANDROIDX_TEST_RUNNER = "androidx.test:runner:1.2.0"
    const val ANDROIDX_EXPRESSO_CORE = "androidx.test.espresso:espresso-core:3.1.1"
    const val ANDROIDX_ORCHESTRATOR = "androidx.test:orchestrator:1.2.0"
    const val ANDROIDX_UI_AUTOMATOR = "androidx.test.uiautomator:uiautomator:2.2.0"
    const val ANDROIDX_TEST_CORE_KTX = "androidx.test:core-ktx:1.2.0"
    const val ANDROIDX_JUNIT_EXT_KTX = "androidx.test.ext:junit-ktx:1.1.2-alpha04"
}
