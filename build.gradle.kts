

plugins {
    kotlin("jvm") version "1.5.31"
    id("org.jetbrains.intellij") version "1.2.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


dependencies {
    implementation(kotlin("stdlib"))
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version.set("2021.2.2")

}



tasks {
    patchPluginXml {
        changeNotes.set("""
            Add change notes here.<br>
            <em>most HTML tags may be used</em>""".trimIndent())
    }
    signPlugin {
        certificateChain.set(File("chain.crt").readText())
        privateKey.set(File("private.pem").readText())
        password.set("gtkgjs")
    }
    publishPlugin {
        token.set( "perm:ZXRpZW5uZXB0.OTItNDg0Ng==.edZ8ADIwGTdGTsNWYjvntdO53F0xbO" )
    }
}

