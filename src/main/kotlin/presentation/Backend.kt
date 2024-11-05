package presentation

import com.kslides.Presentation
import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.img

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
                    """
                    Starter: https://start.spring.io/
                    """.trimIndent()
                }

            }
        }
    }

    // quarkus
    verticalSlides {

        // quarkus Java
        markdownSlide {
            content {
                """
                    
                """.trimIndent()
            }
        }

        // quarkus Kotlin
        markdownSlide {
            content {
                """
                    
                """.trimIndent()
            }
        }
    }

    // Ktor
    verticalSlides {
        markdownSlide {
            content {
                """
                    
                """.trimIndent()
            }
        }

        // Startup Time Spring VS Ktor (graalVM inclusa)
        markdownSlide {
            content {
                """
                    
                """.trimIndent()
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