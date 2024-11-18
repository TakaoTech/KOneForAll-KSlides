package presentation

import com.kslides.Presentation
import com.kslides.codeSnippet
import kotlinx.html.*

fun Presentation.Backend() {

    // Spring
    verticalSlides {

        // Spring Java
        dslSlide {
            content {
                img(src = "images/spring-logo.png")
            }
        }

        // Spring Kotlin
        // https://docs.spring.io/spring-boot/reference/features/kotlin.html
        dslSlide {
            content {
                div(classes = "r-stack r-stretch") {
                    a(
                        href = "https://spring.io/blog/2017/01/04/introducing-kotlin-support-in-spring-framework-5-0"
                    ) {
                        img(
                            src = "images/spring-kotlin.png"
                        )
                    }

                    a(
                        classes = "fragment",
                        href = "https://docs.spring.io/spring-boot/reference/features/kotlin.html"
                    ) {
                        img(
                            src = "images/spring-kotlin2.png"
                        )
                    }
                }

                notes {
                    +"""
                    Starter: https://start.spring.io/
                    """.trimIndent()
                }

            }
        }
    }

    // quarkus
    verticalSlides {

        // quarkus Java
        dslSlide {
            content {
                a(
                    href = "https://quarkus.io/"
                ) {
                    img(
                        src = "images/quarkus-logo.png"
                    ){
                        style = """
                        background-color: rgba(255, 255, 255, 0.5);
                        padding: 20px;
                        """.trimIndent()
                    }
                }
            }
        }

        // quarkus Kotlin
        // https://quarkus.io/guides/kotlin
        // https://github.com/u-ways/kotlin-quarkus-realworld-example-app
        dslSlide {
            content {
                iframe {
                    width = "90%"
                    height = "810px"
                    src = "https://quarkus.io/guides/kotlin"
                }
            }
        }
    }

    // Ktor
    // https://betterprogramming.pub/create-a-kotlin-native-web-server-with-ktor-and-sqldelight-postgressql-44485267c340
    verticalSlides {
        dslSlide {
            content {
                img(
                    src = "images/ktor-kmer.png"
                ) {
                    style = """
                    width: 581px;
                    height: 816px
                    """.trimIndent()
                }
            }
        }

        dslSlide {
            content {
                img(src = "images/ktor-logo.png") {
                    style = """
                    background-color: rgba(255, 255, 255, 0.5);
                    padding: 20px;
                    """.trimIndent()
                }

                notes {
                    +"""
                    Ktor è un framework completamente in Kotlin per creazione di backend,
                    ma Ktor è anche un client HTTP.
                    https://start.ktor.io/settings
                    
                    https://ktor.io/docs/welcome.html
                    
                   
                    """.trimIndent()
                }
            }
        }

        //TODO Ktor Google Deploy
        //https://github.com/GoogleCloudPlatform/kotlin-samples#readme

        dslSlide {
            content {
                img(src = "images/ktor-pipeline.png")

                notes {
                    +"""
                     Note negative:
                    Creazione di plugin custom
                    https://ktor.io/docs/server-custom-plugins.html
                    https://ximedes.com/blog/2020-09-17/role-based-authorization-in-ktor
                    """.trimIndent()

                    //TODO Aggiungere repo role base
                }
            }
        }
    }

    //Microservizi
    verticalSlides {

        // Hexagon https://github.com/hexagontk/hexagon
        dslSlide {
            content {
                iframe {
                    width = "90%"
                    height = "810px"
                    src = "https://hexagontk.com/stable/"
                }
            }
        }

        //TODO AWS Kotlin

        // Kotless https://github.com/JetBrains/kotless
        dslSlide {
            content {
                div("r-vstack") {
                    div {
                        style = """
                        display: flex;
                        align-items: center;
                        justify-content: center;
                        """.trimIndent()

                        img(src = "https://s3-eu-west-1.amazonaws.com/public.s3.ktls.aws.intellij.net/resources/favicon.apng")
                        h3 {
                            +"Kotless"
                        }
                    }
                    a(href = "https://github.com/JetBrains/kotless") {
                        img(src = "images/kotless-start.png")
                    }
                }
            }
        }


    }


    // Kotlin Script

    verticalSlides {
        dslSlide {
            content {
                img(src = "images/kotlin-script.png")
            }
        }

        //https://ajalt.github.io/clikt/
        dslSlide {
            content {
                div("r-vstack") {
                    img(src = "https://ajalt.github.io/clikt/img/wordmark.svg")
                    img(src = "https://ajalt.github.io/clikt/img/animation.png")
                }
            }
        }

        dslSlide {
            content {
                codeSnippet {
                    +"""
                    class Hello : CliktCommand() {
                        val count: Int by option().int().default(1).help("Number of greetings")
                        val name: String by option().prompt("Your name").help("The person to greet")

                        override fun run() {
                            repeat(count) {
                                echo("Hello ${"\$name"}!")
                            }
                        }
                    }

                    fun main(args: Array<String>) = Hello().main(args)
                    """.trimIndent()
                }
            }
        }

        //https://github.com/varabyte/kotter
        dslSlide {
            content {

            }
        }

        //https://github.com/kscripting/kscript

        //https://github.com/JakeWharton/mosaic
        //https://github.com/ajalt/mordant

    }
}