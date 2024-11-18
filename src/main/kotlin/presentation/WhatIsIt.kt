package presentation

import com.kslides.Presentation
import kotlinx.html.*

fun Presentation.WhatIsIt() {
    markdownSlide {
        content {
            """
            ![KotlinLogo](images/kotlin_logo.png)
            
            Notes:
            Spingere sulla domanda "Uno strumento quando è definito enterprise?"
            
            """.trimIndent()
        }
    }

    // What is Kotlin

    verticalSlides {
        // https://kotlinlang.org/assets/kotlin-media-kit.pdf
        // https://youtu.be/E8CtE7qTb-Q?si=PfDkxYOujMrkYB_K&t=4174

        dslSlide {
            content {
                h2 {
                    +"Dove inizio a studiare?"
                }
            }
        }

        //TODO Isola Java
        //TODO Isola Kotlin

        dslSlide {
            content {
                div("r-vstack") {
                    a(href = "") {
                        img(src = "images/kotlin-home.png")
                    }

                    a(href = "https://kotlinlang.org/docs/getting-started.html") {
                        +"Get Started"
                    }
                }
            }
        }

        dslSlide {
            content {
                script {
                    src = "https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"
                }

                div("r-vstack") {

                    h3 {
                        s { +"cross-platform" }
                    }

                    h3 {
                        + "multi-platform"
                    }

                    h3 {
                        +"multi-purpose"
                    }

                    unsafe {
                        raw(
                            """
                            <lottie-player src="mascot.json"  speed="1" style="width: 1000px; height: 800px;" loop="" autoplay=""></lottie-player>
                            """.trimIndent()
                        )
                    }
                }



                notes {
                    +"""
                    Kotlin è un linguaggio multi-paradigma multi-piattaforma inizialmente basato su JVM.
                    
                    Chiedere a pubblico "Differenza tra cross e multi".
                    Altrimenti spiegare la differenza, secondo me.
                    """.trimIndent()
                }
            }
        }

        dslSlide {
            id = "youtube"
            content {
                iframe {
                    width = "720"
                    height = "480"
                    src = "https://www.youtube-nocookie.com/embed/E8CtE7qTb-Q?si=iy6DvABycCwi-cY2"
                    title = "Beyond The Success Of Kotlin"
                    attributes["frameborder"] = "0"
                    attributes["allow"] = "accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope"
                    attributes["allowfullscreen"] = "true"
                }

                notes {
                    +"""
                    Consiglio di guardarlo perchè ci sono tante chicche interessanti, del tipo:
                    Sapevate che il compilatore fino alla 2.0 non era mai stato dichiarato stabile?
                    O altre varie chicche con Google.
                    """.trimIndent()
                }
            }
        }

        dslSlide {
            content {
                h1 {
                    +"A quali linguaggi si è ispirato?"
                }

                notes {
                    +"""
                    - Java
                    - C#
                    - Scala
                    - Groovy
                    - Python
                    - Gosu https://gosu-lang.github.io/docs.html
                    """.trimIndent()
                }
            }
        }

        markdownSlide {
            content {
                """
                ![Kotlin Inspiration](images/kotlin-languages.png)    
                """.trimIndent()
            }
        }

        //Dove ho usato per la prima volta Kotlin
        //https://github.com/samuele794/TakaoBot

        //Primo commit Kotlin https://github.com/samuele794/TakaoBot/commit/24674f491b2c24b7b6919b327de495bef06501da
        dslSlide {
            content {
                div(classes = "r-stack") {
                    a(href = "https://github.com/samuele794/TakaoBot") {
                        img(src = "images/takaobot1.png") {

                        }
                    }

                    a(
                        classes = "fragment",
                        href = "https://github.com/samuele794/TakaoBot/commit/24674f491b2c24b7b6919b327de495bef06501da"
                    ) {
                        img(src = "images/takaobot2.png") {

                        }
                    }
                }

            }
        }

        //https://www.reddit.com/r/Bitwarden/comments/1b32bbz/going_native_the_future_of_the_bitwarden_mobile/
        dslSlide {
            content {
                div(
                    classes = "r-stack r-stretch"
                ) {

                    a(
                        href = "https://medium.com/insiden26/5-reasons-why-n26-is-moving-to-kotlin-f920b184ab58"
                    ) {
                        img(
                            classes = "r-stretch",
                            src = "images/n26-kotlin.png"
                        )
                    }

                    a(
                        classes = "fragment",
                        href = "https://vinted.engineering/2017/05/29/kotlin/"
                    ) {
                        img(src = "images/vinted-kotlin.png")
                    }

                    a(
                        classes = "fragment",
                        href = "https://github.com/navikt?q=&type=all&language=kotlin&sort="
                    ) {
                        img(src = "images/norvegia-kotlin.png")
                    }

                    div(
                        classes = "fragment"
                    ) {
                        img(
                            src = "images/pagopa-kotlin.png"
                        )
                    }

                    a(
                        classes = "fragment",
                        href = "https://medium.com/mcdonalds-technical-blog/mobile-multiplatform-development-at-mcdonalds-3b72c8d44ebc"
                    ) {
                        img(
                            src = "images/mc-kotlin.png"
                        )
                    }

                    a(
                        classes = "fragment",
                        href = "https://netflixtechblog.com/netflix-android-and-ios-studio-apps-kotlin-multiplatform-d6d4d8d25d23"
                    ) {
                        img(
                            src = "images/netflix-kotlin.png"
                        )
                    }

                    a(
                        classes = "fragment",
                        href = "https://github.com/Netflix/dgs-framework"
                    ) {
                        img(
                            src = "images/netflixdgs-kotlin.png"
                        )
                    }

                    a(
                        classes = "fragment",
                        href = "https://www.reddit.com/r/Bitwarden/comments/1b32bbz/going_native_the_future_of_the_bitwarden_mobile/"
                    ) {
                        img(
                            src = "images/bitwarden-kotlin.png"
                        )
                    }

                    notes {
                        + """
                        - Welfare Norvegia.
                        
                        DGS (Domain Graph Service) Netflix: Backend custom GraphQL
                        """.trimIndent()
                    }
                }
            }
        }
    }

    //TODO Bytecode decompiler

    //TODO KSP-KAPT-ANNOTATOR PROCESSOR?
}