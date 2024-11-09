package presentation

import com.kslides.Presentation
import com.kslides.include
import kotlinx.html.*

fun Presentation.Kmp() {
    verticalSlides {

        // Domanda per pubblico, come lo definisci il nativo?
        // Flutter è nativo
        // Mettere codice di differenza Kotlin-Java
        // Mettere differenza pacchetto con flutter
        //https://youtu.be/E8CtE7qTb-Q?si=d0QkMOSLqfqERQ6r&t=5182
        dslSlide {
            content {
                h2 {
                    +"Per voi lo sviluppo Flutter, è nativo?"
                }
            }
        }

        //Meme AndroidX ma su iOS/Web

        //https://developer.android.com/kotlin/multiplatform
        //https://developer.android.com/jetpack/androidx/releases/paging
        //https://android.googlesource.com/platform/frameworks/support/+/90c97683b9811e57c63ddb93d87b6fa21f02bcde/paging/paging-common/build.gradle
        dslSlide {
            content {
                img(src = "images/kmp-androidx.png")
                notes {
                    +"""
                    Specificare gli attuali livelli di supporto:
                    - Tier 1: Test con CI sia Host che device. Sorgente e Binary con compatibilità tracciata
                    - Tier 2: Test parziali CI su Host
                    - Tier 3: No test CI
                    """.trimIndent()
                }
            }
        }

        dslSlide {
            content {
                a(
                    href = "https://developer.android.com/jetpack/androidx/releases/paging"
                ) {
                    img(src = "images/paging-kmp1.png")
                }
            }
        }

        dslSlide {
            content {
                a(
                    href = "https://developer.android.com/jetpack/androidx/releases/paging"
                ) {
                    img(src = "images/paging-kmp2.png")
                }
            }
        }

        // Meme 2 - React Native Kotlin Bridge
        // https://github.com/voize-gmbh/reakt-native-toolkit

        dslSlide {
            content {
                a(href = "https://github.com/voize-gmbh/reakt-native-toolkit") {
                    img(src = "images/react-bridge-kotlin.png")
                }

                notes {
                    +"""
                    reakt-native-toolkit, un tool per creare automaticamente 
                    il bridge del codice Kotlin con React Native
                    """.trimIndent()
                }
            }
        }

        //Progetto ispirativo, obbiettivo di tirare fuori la risposta di aggiungere un backend
        // https://github.com/Abdelrahman-SW/Coffee-Store-App
        markdownSlide {
            content {
                """
                    
                """.trimIndent()
            }
        }

        // Compose - Multiplatform

        // https://github.com/Kotlin/Storytale
        dslSlide {
            content {
                div {
                    style = """
                    display: flex;
                    gap: 10px;
                    """.trimIndent()
                    img(src = "images/storytale1.png") {
                        style = """
                        width: 50%;
                        height: auto;
                        object-fit: contain;
                        """.trimIndent()
                    }
                    img(src = "images/storytale2.png") {
                        style = """
                        width: 50%;
                        height: auto;
                        object-fit: contain;
                        """.trimIndent()
                    }
                }

                a(href = "https://github.com/Kotlin/Storytale") {
                    +"Storytale"
                }
            }
        }
        // https://github.com/popovanton0/Blueprint
        dslSlide {
            content {

                div {
                    style = """
                    display: flex;
                    gap: 10px;
                    """.trimIndent()

                    video {
                        autoPlay = true
//                        controls = true
                        loop = true
                        style = """
                        width: 50%;
                        height: auto;
                        object-fit: contain;
                        """.trimIndent()

                        source {
                            src = "videos/arrow-angle-anim.mp4"
                            type = "video/mp4"
                        }
                    }

                    img(src = "images/blueprint-kmp.png") {
                        style = """
                        width: 50%;
                        height: auto;
                        object-fit: contain;
                        """.trimIndent()
                    }
                }

                a(href = "https://github.com/popovanton0/Blueprint") {
                    +"Blueprint"
                }
            }
        }
        // https://github.com/ozontech/kelp
        dslSlide {
            content {

                div {
                    style = """
                    gap: 10px;
                    """.trimIndent()

                    img(src = "images/kelp.svg") {

                    }
                }

                a(href = "https://github.com/ozontech/kelp") {
                    +"kelp"
                }

                notes {
                    +"""
                    Kelp è un plugin per Android Studio per supportare lo sviluppo di un design system custom    
                    """.trimIndent()
                }
            }
        }

        dslSlide {
            content {
                div {
                    style = """
                    overflow: auto; /* Rende scrollabile il div */
                    max-height: 710px; /* Imposta un'altezza massima per limitare lo scroll */
                    margin: 20px; /* Aggiunge un margine attorno al div */
                    padding: 10px; /* Opzionale: aggiunge uno spazio interno */
                    border: 1px solid #ccc; /* Opzionale: bordo per visibilità */
                    """.trimIndent()
                    table {
                        thead {
                            tr {
                                th { +"Feature" }
                                th { +"Screenshot" }
                            }
                        }
                        tbody {
                            tr {
                                tdWeightCenter(40) {
                                    +"🔧 Customizable icon for design system "
                                    strong { +"component functions" }
                                }
                                tdWeightCenter(60) {
                                    img(src = "https://github.com/ozontech/kelp/raw/main/images/componentFunHighlighting-dark.png#gh-dark-mode-only") {
                                        width = "600"
                                    }
                                }
                            }
                            tr {
                                tdWeightCenter(40) {
                                    +"🎨 DS "
                                    strong { +"icons" }
                                    +" in the code completion and gutter (where breakpoints are), like with "
                                    code { +"R.drawable" }
                                }
                                tdWeightCenter(60) {
                                    img(src = "https://github.com/ozontech/kelp/raw/main/images/iconsRendering-dark.png#gh-dark-mode-only") {
                                        width = "600"
                                    }
                                }
                            }
                            tr {
                                tdWeightCenter(40) {
                                    +"🌈 "
                                    strong { +"Colors" }
                                    +" from DS palette in the code completion and gutter (where breakpoints are), like with "
                                    code { +"R.color" }
                                }
                                tdWeightCenter(60) {
                                    img(src = "https://github.com/ozontech/kelp/raw/main/images/colorPreview-dark.png#gh-dark-mode-only") {
                                        width = "600"
                                    }
                                }
                            }
                            tr {
                                tdWeightCenter(40) {
                                    +"📱 Installing the apk file of the "
                                    strong { +"demo app" }
                                    +" (showcase app) on an Android device, as well as navigating to the component page in it via an Intention Action"
                                }
                                tdWeightCenter(60) {
                                    img(src = "https://github.com/ozontech/kelp/raw/main/images/demoApkInstalling-dark.png#gh-dark-mode-only") {
                                        width = "600"
                                    }
                                }
                            }
                            tr {
                                tdWeightCenter(40) {
                                    +"📱 The same via the gutter icons near "
                                    strong { +"function declarations" }
                                }
                                tdWeightCenter(60) {
                                    img(src = "https://github.com/ozontech/kelp/raw/main/images/demoApkGutter-dark.png#gh-dark-mode-only") {
                                        width = "600"
                                    }
                                }
                            }
                            tr {
                                tdWeightCenter(40) {
                                    +"🖼 "
                                    strong { +"KDoc Images" }
                                    +" Rendering"
                                }
                                tdWeightCenter(60) {
                                    img(src = "https://github.com/ozontech/kelp/raw/main/images/kdocImagesRendering-dark.png#gh-dark-mode-only") {
                                        width = "600"
                                    }
                                }
                            }
                            tr {
                                tdWeightCenter(40) {
                                    +"⌨️ Handy "
                                    strong { +"live templates" }
                                    +"(customizable; after applying, automatically opens code completion popup)"
                                }
                                tdWeightCenter(60) {
                                    img(src = "https://github.com/ozontech/kelp/raw/main/images/live-templates-dark.png#gh-dark-mode-only") {
                                        width = "600"
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }

        // https://github.com/alexzhirkevich/compose-cupertino
        dslSlide {
            content {
                video {
                    autoPlay = true
                    controls = true
                    loop = true
                    style = """
                    width: 20%;
                    """.trimIndent()
                    src =
                        "https://github.com/alexzhirkevich/compose-cupertino/assets/63979218/982485e8-c581-4c0e-8302-0cb257acd892"
                }
            }
        }

        dslSlide {
            content {
                img(src = "images/compose-cupertino.png")
            }
        }

        // https://github.com/alexzhirkevich/compottie

        // Meme 3 - Il WEB

        // https://github.com/JetBrains/kotlin-wrappers
        dslSlide {
            content {
                img(src = "images/kotlin-wrappers.png")

                notes {
                    """
                    Wrapper Kotlin di librerie JavaScript famose.
                    Nella prossima c'è la lista librerie
                    """.trimIndent()
                }
            }
        }

        htmlSlide {
            content {
                val file = "src/main/resources/public/kotlin-wrappers.html"
                include(file, escapeHtml = false)
            }
        }

        // https://github.com/aerialist7/kotlin-mui-showcase
        dslSlide {
            content {
                a(href = "https://aerialist7.github.io/kotlin-mui-showcase/") {
                    +"MUI"
                }

                notes {
                    """
                    Showcase Material-UI Web in Kotlin   
                    """.trimIndent()
                }
            }
        }

        // https://github.com/varabyte/kobweb
        // https://github.com/stevdza-san/KotlinBootstrap
        dslSlide {
            content {
                div {
                    style = """
                    display: flex;
                    gap: 10px;
                    """.trimIndent()

                    video {
                        attributes["onloadstart"] = "this.playbackRate = 2.5;"
                        autoPlay = true
//                        controls = true
                        loop = true
                        style = """
                        width: 50%;
                        height: auto;
                        object-fit: contain;
                        """.trimIndent()

                        source {
                            src = "videos/kobweb-demo.mp4"
                            type = "video/mp4"
                        }
                    }

                    div {
                        style = """
                        display: flex;
                        flex-direction: column;
                        align-items: center; /* Centra verticalmente */
                        justify-content: center; /* Centra orizzontalmente */
                        width: 50%;
                        """.trimIndent()

                        h2 {
                            +"""
                            K🕸️bweb
                            """.trimIndent()
                        }

                        a("https://github.com/stevdza-san/KotlinBootstrap") {
                            img(src = "https://github.com/stevdza-san/KotlinBootstrap/raw/master/ASSETS/logo.svg")
                        }
                    }
                }
            }
        }

        // Meme 3.1 Dukat
        // https://github.com/Kotlin/dukat
        // https://github.com/karakum-team/karakum

        // Desktop

        //https://github.com/kdroidFilter/ComposeNativeTray
    }
}

@HtmlTagMarker
inline fun TR.tdWeightCenter(
    percentage: Int,
    classes: String? = null,
    crossinline block: TD.() -> Unit = {}
) =
    td(classes) {
        style = """
        width: $percentage%;
        text-align: center;
        vertical-align: middle;
        """.trimIndent()
        block()
    }

