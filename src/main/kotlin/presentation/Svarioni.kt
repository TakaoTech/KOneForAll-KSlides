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
                div(classes = "r-vstack") {
                    img(src = "https://github.com/cmdjulian/kirc/raw/main/logo.png")

                    a(href = "https://github.com/cmdjulian/kirc") {
                        +"kirc"
                    }
                }


                notes {
                    +"""
                    Container Registry Client in Kotlin
                    
                    https://github.com/VirtuslabRnD/pulumi-kotlin
                    """.trimIndent()
                }
            }
        }
        //https://github.com/VirtuslabRnD/pulumi-kotlin

        //https://github.com/code42/pipelinekt
        dslSlide {
            content {
                div(classes = "r-vstack") {
                    img(src = "images/kotlin-jenkins.png")

                    a(href = "https://github.com/code42/pipelinekt") {
                        +"pipelinekt"
                    }
                }
            }
        }

        dslSlide {
            content {
                codeSnippet {
                    +"""
                        val gradleArgs = "-DmyArg=myArgValue"
    
                        val gradle = GradleBuildDsl()
                        /**
                         * Pipeline
                         */
                        fun PipelineDsl.gradleBuildPipeline() =
                                gradle.run {
                                    pipeline {
                                        stages {
                                            stage("Build") {
                                                steps {
                                                    gradleCommand("build ${"\$gradleArgs"}")
                                                }
                                            }
                                            stage("Validate") {
                                                parallel {
                                                    listOf("api", "ext", "shared", "mod1").forEach { subProject ->
                                                        stage("${"\$subProject"} Test") {
                                                            agent(defaultAgent)
                                                            steps {
                                                                gradleCommand(":${"\$subProject"}:systemTest ${"\$gradleArgs"}")
                                                            }
                                                            post {
                                                                always {
                                                                    archiveArtifacts("${"\$subProject"}/build/test-reports/", true)
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            stage("Publish") {
                                                agent(defaultAgent)
                                                steps {
                                                    gradleCommand("publish ${"\$gradleArgs"}")
                                                }
                                            }
                                        }
                                    }
                                }    
                    """.trimIndent()
                }

                notes {
                    +"Esempio di lancio build gradle con lancio parallelo"
                }
            }
        }

        dslSlide {
            content {
                codeSnippet {
                    +"""
                        val uid = "uid".groovyVariable()
                        val dockerDsl = DockerDsl(
                                defaultDockerBuildArgs = "-u "${"\$uid"}",
                                beforeContainer = { def(uid.name) { sh("id -u", true) } })

                        val sideCars = listOf(SideCar.Image(
                                containerVariable = "postgres".groovyVariable(),
                                containerLinkName = "db",
                                image = "postgres:11".strDouble(),
                                runArgs = "--env DB=app --expose 5432".strDouble()),
                                SideCar.Image(
                                        containerVariable = "rabbitmq".groovyVariable(),
                                        containerLinkName = "rabbit",
                                        image = "rabbitmq:11".strDouble(),
                                        runArgs = "--expose 5672".strDouble()))

                        fun PipelineDsl.dockerPipeline() = pipeline {
                            stages {
                                stage("build in container") {
                                    steps {
                                        dockerDsl.run {
                                            insideContainer(
                                                    dockerAgent = { dockerFile(
                                                            filename = "build.Dockerfile",
                                                            additionalBuildArgs = "--arg1 y",
                                                            registryUrl = "my.custom.registry",
                                                            registryCredentialsId = "registry-creds-id")
                                                    },
                                                    sideCars = sideCars
                                            ) {
                                                echo("Inside a container!")
                                                sh("psql -h db -p 5432 app")
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        """.trimIndent()


                }

                notes {
                    +"Build in docker"
                }
            }
        }

        //https://github.com/typesafegithub/github-workflows-kt
        dslSlide {
            content {
                div {
                    style = """
                    display: flex;
                    gap: 10px;
                    """.trimIndent()

                    a(href = "https://github.com/typesafegithub/github-workflows-kt"){
                        style = """
                        width: 25%;
                        height: auto;
                        object-fit: contain;
                        """.trimIndent()
                        img(src = "https://github.com/typesafegithub/github-workflows-kt/raw/main/images/Logo-White.svg#gh-dark-mode-only")
                    }
                    img(src = "https://github.com/typesafegithub/github-workflows-kt/raw/gh-pages/teaser-with-newest-version.svg"){
                        style = """
                        width: 75%;
                        height: auto;
                        object-fit: contain;
                        """.trimIndent()
                    }
                }
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
    dslSlide {
        content {
            img(src = "https://github.com/dotlin-org/dotlin/raw/main/docs/assets/dotlin.png")

            a("https://github.com/dotlin-org/dotlin") {
                +"Kotlin/Dart"
            }

            notes {
                +"""
                Compilatore Kotlin/Dart
                """.trimIndent()
            }
        }
    }

    verticalSlides {
        dslSlide {
            content {
                h1 {
                    +"Source Code generation"
                }
            }
        }

        dslSlide {
            content {
                img(src = "images/java-poet.png")
            }
        }

        //https://github.com/square/kotlinpoet
        dslSlide {
            content {
                iframe {
                    src = "https://square.github.io/kotlinpoet/"
                    width = "1200"
                    height = "720"
                }

                notes {
                    +"""
                    Fare riferimento al KSP.
                    Generatore di Sorgente Kotlin e Java   
                    """.trimIndent()
                }
            }
        }

        //https://github.com/outfoxx/swiftpoet
        dslSlide {
            content {
                div("r-vstack") {
                    a(href = "https://github.com/outfoxx/swiftpoet") {
                        +"swiftpoet"
                    }

                    codeSnippet {
                        +"""
                        val observableTypeName = DeclaredTypeName.typeName("RxSwift.Observable")
    
                        val testClass = TypeSpec.classBuilder("Greeter")
                           .addProperty("name", STRING, Modifier.PRIVATE)
                           .addFunction(
                              FunctionSpec.constructorBuilder()
                                 .addParameter("name", STRING)
                                 .addCode("self.name = name\n")
                                 .build()
                           )
                           .addFunction(
                              FunctionSpec.builder("greet")
                                 .returns(observableTypeName.parameterizedBy(STRING))
                                 .addCode("return %T.from(\"Hello \\(name)\")\n", observableTypeName)
                                 .build()
                           )
                           .build()
                        
                        val file = FileSpec.builder("Greeter")
                           .addType(testClass)
                           .build()
                        
                        val out = StringWriter()
                        file.writeTo(out)    
                        """.trimIndent()
                    }
                }


            }
        }

        dslSlide {
            content {
                codeSnippet {
                    +"""
                    import RxSwift

                    class Greeter {

                      private let name: String

                      init(name: String) {
                        self.name = name
                      }

                      func greet() -> Observable<String> {
                        return Observable.from("Hello \(name)")
                      }

                    }
                    """.trimIndent()
                }
            }
        }

        //https://github.com/smithy-lang/smithy-kotlin
        dslSlide {
            content {
                div("r-vstack") {
                    iframe {
                        width = "90%"
                        height = "810px"
                        src = "https://smithy.io/2.0/index.html"
                    }
                }
            }
        }

        //https://github.com/shalaga44/missing-annotations-therapist
//        dslSlide {
//            content {
//                div("r-vstack") {
//                    img(src = "img/missing-annotation-kotlin.png")
//                    a(href = "https://github.com/shalaga44/missing-annotations-therapist"){
//                        + "missing-annotations-therapist"
//                    }
//                }
//
//                notes {
//                    + """
//                    Hai dimenticato un annotazione in certi tipi di classi?
//                    """.trimIndent()
//                }
//            }
//        }

        //https://github.com/JavierSegoviaCordoba/kopy
        dslSlide {
            content {
                div {
                    img(src = "https://github.com/JavierSegoviaCordoba/kopy/raw/main/.docs/docs/assets/images/example.gif")
                    a(href = "https://github.com/JavierSegoviaCordoba/kopy") {
                        +"Kopy"
                    }
                }

                notes {
                    +"""
                    https://kotlinlang.org/docs/data-classes.html
                    Plugin di supporto per il copy innestato o strutturato
                    
                    Attenzione: leggera attentamente la doc sul funzionamento
                    """.trimIndent()
                }
            }
        }
    }

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


        //https://github.com/saveourtool/diktat
        dslSlide {
            content {
                div {
                    iframe {
                        src = "https://diktat.saveourtool.com/"
                        width = "90%"
                        height = "810px"
                    }

                    notes {
                        +"diktat"
                    }
                }
            }
        }

        //https://github.com/detekt/detekt
        dslSlide {
            content {
                div {
                    iframe {
                        src = "https://detekt.dev/"
                        width = "90%"
                        height = "810px"
                    }
                }

                notes {
                    +"detekt"
                }
            }
        }

        //https://pinterest.github.io/ktlint/latest/
        dslSlide {
            content {
                div {
                    iframe {
                        src = "https://pinterest.github.io/ktlint/latest/"
                        width = "90%"
                        height = "810px"
                    }
                }

                notes {
                    +"ktlint"
                }
            }
        }

        //https://github.com/LemonAppDev/konsist
        dslSlide {
            content {
                img(src = "https://github.com/LemonAppDev/konsist/raw/main/misc/konsist-logo/logo.png")
            }
        }
    }

    verticalSlides {

        //https://github.com/smyrgeorge/sqlx4k
        dslSlide {
            content {
                div("r-vstack") {
                    img(src = "images/sqlx4k-kotlin.png")
                    a(href = "https://github.com/smyrgeorge/sqlx4k") {
                        +"sqlx4k"
                    }
                }

                notes {
                    +"""
                    Driver per  PostgreSQL, MySQL, and SQLite scritto in Kotlin Native.
                    Anche se penso che un pochino ci abbia mentito.
                    """.trimIndent()
                }
            }
        }

        //https://github.com/arrow-kt/arrow
        dslSlide {
            content {
                div("r-vstack") {
                    img(src = "images/arrow-kotlin.png")

                    a(href = "https://github.com/arrow-kt/arrow") {
                        +"arrow"
                    }
                }
            }
        }

        //https://github.com/touchlab/SKIE
        dslSlide {
            content {
                iframe {
                    style = """
                    background-color: rgba(255, 255, 255);
                    """.trimIndent()
                    src = "https://skie.touchlab.co/intro#getting-started"
                    width = "90%"
                    height = "810px"

                }
            }
        }

        //https://github.com/JetBrains/skiko
        dslSlide {
            content {
                div("r-vstack") {
                    img(src = "images/skiko-kotlin.png")
                    a(href = "https://github.com/JetBrains/skiko") {
                        +"skiko"
                    }
                }
            }
        }

        //https://github.com/korlibs/ktcc
    }

    verticalSlides {
        dslSlide {
            content {
                iframe {
                    src = "https://korge.org/"
                    width = "90%"
                    height = "810px"
                }
            }
        }

        //https://github.com/korlibs/korge
        dslSlide {
            content {
                div("r-hstack") {
                    img(src = "https://github.com/utopia-rise/godot-kotlin-jvm/raw/master/.README/logo.png"){
                        width = "10%"
                    }

                    iframe {
                        src = "https://godot-kotl.in/en/stable/"
                        width = "90%"
                        height = "810px"
                    }
                }

                notes {
                    + """
                    https://github.com/korlibs/korge
                    """.trimIndent()
                }
            }
        }

        //https://github.com/kool-engine/kool
        dslSlide {
            content {
                iframe {
                    src = "https://fabmax.github.io/kool/kool-js/"
                    width = "90%"
                    height = "810px"
                }

                notes { + "https://github.com/kool-engine/kool" }
            }
        }

        //https://github.com/kotlin-graphics/vkk
        dslSlide {
            content {
                img(src = "images/vkk-kotlin.png")

                notes {
                    + "https://github.com/kotlin-graphics/vkk"
                }
            }
        }
    }

    //https://github.com/gabryon99/postcat-kodee

}
