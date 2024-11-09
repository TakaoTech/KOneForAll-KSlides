package presentation

import com.kslides.Presentation
import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.img
import kotlinx.html.style

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
                    )
                }
            }
        }

        // quarkus Kotlin
        // https://quarkus.io/guides/kotlin
        // https://github.com/u-ways/kotlin-quarkus-realworld-example-app
        markdownSlide {
            content {
                """
                    
                """.trimIndent()
            }
        }
    }

    // Ktor
    // https://betterprogramming.pub/create-a-kotlin-native-web-server-with-ktor-and-sqldelight-postgressql-44485267c340
    verticalSlides {
        dslSlide {
            content {
                img(
                    classes = "r-stretch",
                    src = "images/ktor-kmer.png"
                ) {
                    style = """
                        width = "615px"
                        height = "720px"
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
                    + """
                    Ktor è un framework completamente in Kotlin per creazione di backend,
                    ma Ktor è anche un client HTTP.
                    https://start.ktor.io/settings
                    
                    https://ktor.io/docs/welcome.html
                    
                   
                    """.trimIndent()
                }
            }
        }

        dslSlide {
            content {
                img(src = "images/ktor-pipeline.png")

                notes {
                    + """
                     Note negative:
                    Creazione di plugin custom
                    https://ktor.io/docs/server-custom-plugins.html
                    https://ximedes.com/blog/2020-09-17/role-based-authorization-in-ktor
                    """.trimIndent()
                }
            }
        }
    }

    //Microservizi
    verticalSlides {

        // Hexagon https://github.com/hexagontk/hexagon
        markdownSlide {
            content {
                """
                    
                """.trimIndent()
            }
        }

        // Kotless https://github.com/JetBrains/kotless
        markdownSlide {
            content {
                """
                    
                """.trimIndent()
            }
        }
    }


    // Kotlin Script
}