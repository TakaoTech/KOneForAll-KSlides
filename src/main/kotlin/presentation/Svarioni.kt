package presentation

import com.kslides.PlaygroundTheme
import com.kslides.Presentation
import com.kslides.codeSnippet
import com.kslides.playground
import kotlinx.css.LinearDimension
import kotlinx.css.fontSize
import kotlinx.css.lineHeight
import kotlinx.css.properties.LineHeight
import kotlinx.html.*

fun Presentation.Svarioni() {
    //https://github.com/skrapeit/skrape.it

    //https://github.com/divyanshupundir/mavlink-kotlin
    verticalSlides {
        dslSlide {
            content {
                a(href = "https://github.com/divyanshupundir/mavlink-kotlin") {
                    img(src = "images/mavlink-kotlin.png")
                }

                notes {
                    +"""
                    Protocollo per la comunicazione con i droni  
                    """.trimIndent()
                }
            }
        }

        dslSlide {
            content {
                codeSnippet {
                    +"""
                    jvm()
                    js {
                        browser()
                        nodejs()
                    }
                    iosX64()
                    iosArm64()
                    iosSimulatorArm64()
                    macosX64()
                    macosArm64()
                    watchosArm32()
                    watchosArm64()
                    watchosX64()
                    watchosSimulatorArm64()
                    linuxX64()
                    linuxArm64()
                    mingwX64()    
                    """.trimIndent()
                }
            }
        }
    }
    //https://github.com/romainguy/kotlin-explorer
    dslSlide {
        content {
            a(href = "https://github.com/romainguy/kotlin-explorer") {
                img(src = "https://raw.githubusercontent.com/romainguy/kotlin-explorer/refs/heads/main/art/kotlin-explorer.png")
            }

            notes {
                +"""
                Kotlin Explorer, tool desktop per disassemblare il codice Kotlin in:
                Bytecode java, 
                Bytecode Android DEX
                Android OAT assembly
                """.trimIndent()
            }
        }
    }

    //https://github.com/cashapp/zipline
    dslSlide {
        content {
            a(href = "https://github.com/cashapp/zipline") {
                img(src = "images/kotlin-zipline.png")
            }

            notes {
                +"""
                Libreria per semplificare l'uso di librerie Kotlin/JS su software Kotlin/JVM e Kotlin/Native   
                """.trimIndent()
            }
        }
    }

    verticalSlides {
        //https://github.com/cmdjulian/kirc
        dslSlide {
            content {
                a(href = "https://github.com/cmdjulian/kirc") {
                    img(src = "https://github.com/cmdjulian/kirc/raw/main/logo.png")
                }

                notes {
                    +"""
                    Container Registry Client in Kotlin
                    """.trimIndent()
                }
            }
        }
        //https://github.com/VirtuslabRnD/pulumi-kotlin
        dslSlide {
            content {

            }
        }
    }

    //https://github.com/Pi4J/pi4j-kotlin
    dslSlide {
        content {
            div {
                a(href = "https://github.com/Pi4J/pi4j-kotlin") { +"pi4j-kotlin" }
                codeSnippet {
                    +"""
                    const val PIN_BUTTON = 24 // PIN 18 = BCM 24
                    const val PIN_LED = 22 // PIN 15 = BCM 22
                    var pressCount = 0

                    console {
                      title("<-- The Pi4J Project -->", "Minimal Example project")
                      pi4j {
                        digitalInput(PIN_BUTTON) {
                            id("button")
                            name("Press button")
                            pull(PullResistance.PULL_DOWN)
                            debounce(3000L)
                            piGpioProvider()
                          }.onLow {
                            pressCount++
                            +"Button was pressed for the ${"\${pressCount}"}th time"
                          }
                        }
                        
                        digitalOutput(PIN_LED) {
                            id("led")
                            name("LED Flasher")
                            shutdown(DigitalState.LOW)
                            initial(DigitalState.LOW)
                            piGpioProvider()
                          }.run {
                            while (pressCount < 5) {
                              +"LED ${"\${state()}"}"
                              toggle()
                              sleep(500L / (pressCount + 1))
                            }
                          }
                        }
                      }
                    }
                    """.trimIndent()
                }
            }
        }
    }
    //https://github.com/InsanusMokrassar/ktgbotapi
    dslSlide {
        content {
            div(classes = "r-hstack") {
                p {
                    a(href = "https://github.com/InsanusMokrassar/ktgbotapi") {
                        img(src = "https://github.com/InsanusMokrassar/ktgbotapi/raw/master/resources/tg_channel_qr.jpg")
                    }
                }

                p {
                    codeSnippet {
                        +"""
                        suspend fun main(vararg args: String) {
                            val botToken = args.first()
                            val isDebug = args.getOrNull(1) == "debug"
    
                            if (isDebug) {
                                setDefaultKSLog(
                                    KSLog { level: LogLevel, tag: String?, message: Any, throwable: Throwable? ->
                                        println(defaultMessageFormatter(level, tag, message, throwable))
                                    }
                                )
                            }
    
                            val bot = telegramBot(botToken)
    
                            bot.buildBehaviourWithLongPolling {
                                onContentMessage { contentMessage ->
                                    val url = contentMessage.withContentOrNull<TextedContent>() ?.let { message ->
                                        message.content.textSources.firstNotNullOfOrNull {
                                            it.textLinkTextSourceOrNull() ?.url ?: it.uRLTextSourceOrNull() ?.source
                                        }
                                    } ?: null.apply {
                                        reply(contentMessage) {
                                            regular("I am support only content with text contains url only")
                                        }
                                    } ?: return@onContentMessage
                                    contentMessage.withContentOrNull<TextedContent>() ?.let {
                                        send(
                                            it.chat,
                                            it.content.textSources,
                                            linkPreviewOptions = LinkPreviewOptions.Disabled
                                        )
                                        send(
                                            it.chat,
                                            it.content.textSources,
                                            linkPreviewOptions = LinkPreviewOptions.Large(url, showAboveText = true)
                                        )
                                        send(
                                            it.chat,
                                            it.content.textSources,
                                            linkPreviewOptions = LinkPreviewOptions.Large(url, showAboveText = false)
                                        )
                                        send(
                                            it.chat,
                                            it.content.textSources,
                                            linkPreviewOptions = LinkPreviewOptions.Small(url, showAboveText = true)
                                        )
                                        send(
                                            it.chat,
                                            it.content.textSources,
                                            linkPreviewOptions = LinkPreviewOptions.Small(url, showAboveText = false)
                                        )
                                        send(
                                            it.chat,
                                            it.content.textSources,
                                            linkPreviewOptions = LinkPreviewOptions.Default(url, showAboveText = true)
                                        )
                                        send(
                                            it.chat,
                                            it.content.textSources,
                                            linkPreviewOptions = LinkPreviewOptions.Default(url, showAboveText = false)
                                        )
                                    }
                                }
                            }.join()
                        }
                        """.trimIndent()
                    }
                }
            }
        }
    }

    //https://github.com/hexagontk/codecv
    dslSlide {
        content {
            div {
                style = """
                display: flex;
                gap: 10px;
                """.trimIndent()
                a(href = "https://github.com/hexagontk/codecv") {
                    style = """
                    width: 25%;
                    height: auto;
                    object-fit: contain;
                    """.trimIndent()

                    img(src = "https://github.com/hexagontk/codecv/raw/main/logo.png")
                }


                playground("https://raw.githubusercontent.com/hexagontk/codecv/refs/heads/main/cv.schema.json") {
                    style = """
                    width: 75%;
                    height: 575px;
                    object-fit: contain;
                    """.trimIndent()
                    theme = PlaygroundTheme.DARCULA
                    css {
                        rule(".CodeMirror pre") {
                            lineHeight = LineHeight("20px")
                        }

                        rule(".CodeMirror") {
                            fontSize = LinearDimension("15px")
                        }

                        rule(".code-output") {
                            lineHeight = LineHeight("20px")
                            fontSize = LinearDimension("15px")
                        }
                    }
                }
            }
        }
    }

    //https://github.com/dotlin-org/dotlin

    //https://github.com/square/kotlinpoet
    //https://github.com/outfoxx/swiftpoet
    //https://github.com/smithy-lang/smithy-kotlin

    //https://github.com/shalaga44/missing-annotations-therapist
    //https://github.com/JavierSegoviaCordoba/kopy

    verticalSlides {
        dslSlide {
            content {
                img(src = "images/kotlin-analysis.png") {
                    style = """
                    border-radius: 8px;
                    """.trimIndent()
                    width = "90%"
                    height = "810px"
                }
            }
        }
    }

    //https://github.com/saveourtool/diktat
    //https://pinterest.github.io/ktlint/latest/
    //https://github.com/LemonAppDev/konsist
    //https://github.com/detekt/detekt

    //https://github.com/smyrgeorge/sqlx4k

    //https://github.com/cdsap/ProjectGenerator


    //https://github.com/arrow-kt/arrow
    //https://github.com/touchlab/SKIE
    //https://github.com/JetBrains/skiko
    //https://github.com/korlibs/ktcc

    //https://github.com/gabryon99/postcat-kodee
    //https://github.com/korlibs/korge

    //TODO Kotlin script

    //https://github.com/code42/pipelinekt
    //https://github.com/typesafegithub/github-workflows-kt


    //https://github.com/joreilly/Confetti
}
