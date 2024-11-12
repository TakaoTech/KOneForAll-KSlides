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

/*    //STACKS tecnologici attuali, tipo su base typescript, dart
    verticalSlides {
        markdownSlide {
            content {
                """
                    ![JSStack](images/js-stack.png)

                    Notes:
                    TypeScript è un superset tipizzato di JavaScript.

                    Usi principali:
                    - Frontend: React/ReactNative, Angular, Vue.js, Svelte, Next.js
                    - Backend: NodeJS

                    Quando uno strumento è enterprise?
                    Ricordiamo che JS è stato scritto in 10 giorni
                """.trimIndent()
            }
        }

        markdownSlide {
            // Android Native Module in Kotlin per React Native - Oggetto Complesso
            content {
                """
        ```kotlin
        // MyNativeModule.kt
        package com.example

        import com.facebook.react.bridge.ReactApplicationContext
        import com.facebook.react.bridge.ReactContextBaseJavaModule
        import com.facebook.react.bridge.ReactMethod
        import com.facebook.react.bridge.Promise
        import com.facebook.react.bridge.ReadableMap

        data class Person(val name: String, val surname: String)

        class MyNativeModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

            override fun getName(): String {
                return "MyNativeModule"
            }

            @ReactMethod
            fun createPerson(personMap: ReadableMap, promise: Promise) {
                try {
                    // Estrai i dati dalla mappa
                    val name = personMap.getString("name") ?: ""
                    val surname = personMap.getString("surname") ?: ""

                    // Crea un oggetto Person
                    val person = Person(name, surname)

                    // Converti l'oggetto in una mappa da restituire a JavaScript
                    val personMap = mapOf("name" to person.name, "surname" to person.surname)

                    promise.resolve(personMap)
                } catch (e: Exception) {
                    promise.reject("ERROR", e)
                }
            }
        }
        ```

        Notes:
        In questo esempio, un oggetto complesso di tipo `Person` viene creato da un oggetto `ReadableMap` passato dal lato JavaScript.
        La classe `Person` contiene due campi: `name` e `surname`.
        Dopo aver creato l'oggetto, viene convertito in una mappa e restituito al codice JavaScript attraverso una Promise.
        """.trimIndent()
            }
        }


    }

    // STACK tecnologico basato su Dart
    verticalSlides {

        markdownSlide {
            content {
                """
            ![DartStack](images/dart-stack.png)

            Notes:
            Dart è un linguaggio di programmazione sviluppato da Google.
            Presentato nell'ottobre 2011, come teorico sostituto di JS, per poi riprogettarlo per uso con Flutter rilasciato nel 2017.

            Con la versione di dart 2.12 uscita il 3 marzo 2021, ma resa stabile dalla 3.0 del 10 maggio 2023.
            Flutter, utilizzato per creare app mobile e web cross-platform.

            Quando uno strumento è enterprise?
            Google ha tirato su flutter nel 2015 e "nella pratica" salvato dart dal suo declino infilandocelo a "forza".
        """.trimIndent()
            }
        }

        markdownSlide {
            content {
                """
        **Android (Kotlin):**

        ```kotlin
        import io.flutter.embedding.android.FlutterActivity
        import io.flutter.plugin.common.MethodCall
        import io.flutter.plugin.common.MethodChannel

        class MainActivity : FlutterActivity() {
            private val CHANNEL = "com.example.myapp/data"

            override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
                // ...
                val methodChannel = MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL)
                methodChannel.setMethodCallHandler { call, result ->
                    if (call.method == "getData") {
                        val data = getDataFromAndroid() // Funzione per ottenere i dati da Android
                        result.success(data)
                    } else {
                        result.notImplemented()
                    }
                }
            }
        }
        ```
        """
            }
        }

        markdownSlide {
            content {
                """
                    **Flutter (Dart):**

        ```dart
        import 'package:flutter/services.dart';

        const platform = MethodChannel('com.example.myapp/data');

        Future&lt;dynamic&gt; getDataFromAndroid() async {
          try {
            final dynamic result = await platform.invokeMethod('getData');
            return result; // Utilizzare i dati ricevuti
          } on PlatformException catch (e) {
            // Gestione degli errori
          }
        }
        ```
                """.trimIndent()
            }
        }

        markdownSlide {
            // Flutter Platform Channel con Kotlin - Oggetto Complesso
            content {
                """
        ```dart
        // Dart: Definizione della classe Person e utilizzo di MethodChannel

        import 'package:flutter/services.dart';

        class Person {
          final String name;
          final String surname;

          Person(this.name, this.surname);

          Map&lt;String, String&gt; toMap() {
            return {
              'name': name,
              'surname': surname,
            };
          }
        }

        class NativeModule {
          static const platform = MethodChannel('com.example/native');

          Future&lt;Map&lt;String, String&gt;?&gt; createPerson(Person person) async {
            try {
              final result = await platform.invokeMethod('createPerson', person.toMap());
              return Map&lt;String, String&gt;.from(result);
            } catch (e) {
              print("Failed to create person: '${"\${e.message}"}'.");
              return null;
            }
          }
        }
        ```

        Notes:
        In questo esempio, utilizziamo un `MethodChannel` per comunicare tra Flutter (Dart) e Kotlin (Android). Un oggetto `Person` viene creato in Dart e inviato al codice nativo tramite una mappa. Kotlin riceve la mappa, crea un'istanza della classe `Person`, e restituisce i dati al codice Dart.
        """.trimIndent()
            }
        }

        markdownSlide {
            content {
                """
                    ```kotlin
        // Kotlin: Implementazione del Platform Channel in Android

        package com.example

        import androidx.annotation.NonNull
        import io.flutter.embedding.engine.plugins.FlutterPlugin
        import io.flutter.plugin.common.MethodCall
        import io.flutter.plugin.common.MethodChannel

        data class Person(val name: String, val surname: String)

        class NativeModulePlugin : FlutterPlugin, MethodChannel.MethodCallHandler {

            private lateinit var channel: MethodChannel

            override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
                channel = MethodChannel(flutterPluginBinding.binaryMessenger, "com.example/native")
                channel.setMethodCallHandler(this)
            }

            override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: MethodChannel.Result) {
                when (call.method) {
                    "createPerson" -> {
                        val name = call.argument&lt;String&gt;(&quot;name&quot;) ?: ""
                        val surname = call.argument&lt;String&gt;(&quot;surname&quot;) ?: ""

                        val person = Person(name, surname)
                        val personMap = mapOf("name" to person.name, "surname" to person.surname)

                        result.success(personMap)
                    }
                    else -> result.notImplemented()
                }
            }

            override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
                channel.setMethodCallHandler(null)
            }
        }
        ```
                """.trimIndent()
            }
        }
    }*/

    // Cos'è Kotlin
//    verticalSlides {
//        markdownSlide {
//            // Stack tecnologico attuale basato su Kotlin
//            // Framework Backend
//            // Mobile
//            // Desktop
//            content {
//                """
//                ![KotlinLogo](images/kotlin_logo.png)
//
//                """.trimIndent()
//            }
//        }

//        markdownSlide {
//            // Collegamento di Kotlin a Swift con una classe Person
//
//            // https://github.com/kotlin-hands-on/kotlin-swift-interopedia?tab=readme-ov-file
//            content {
//                """
//                ```kotlin
//                // Definizione della classe Person in Kotlin
//                data class Person(
//                    val name: String,
//                    val surname: String
//                )
//
//                // Funzione Kotlin per convertire una persona in un formato Swift compatibile
//                object PersonMock {
//                    fun getPerson(): Person {
//                        return Person(name = "John", surname = "Doe")
//                    }
//                }
//                ```
//                Notes:
//                In questo esempio, Kotlin Multiplatform Mobile (KMM) permette di condividere la logica tra Kotlin e Swift. La classe `Person` viene definita in Kotlin e utilizzata in Swift. Il framework KMM genera automaticamente i binding necessari affinché Swift possa interagire con il codice Kotlin.
//                """.trimIndent()
//            }
//        }

//        markdownSlide {
//            content {
//                """
//                    ```swift
//        // Uso della classe Person in Swift tramite Kotlin Multiplatform Mobile (KMM)
//
//        import shared
//
//        func displayPerson() {
//            let person = PersonMock.shared.getPerson()
//            print("Person's name: \(person.name), surname: \(person.surname)")
//        }
//        ```
//                """.trimIndent()
//            }
//        }

//        markdownSlide {
//            // Collegamento di Kotlin a TypeScript con un metodo di Kotlin (PersonMock)
//            content {
//                """
//        ```kotlin
//        // Kotlin: Definizione di un oggetto con un metodo che ritorna un'istanza di Person
//
//        @JsExport
//        object PersonMock {
//            fun getPerson(): Person {
//                return Person(name = "John", surname = "Doe")
//            }
//        }
//
//        // Definizione della classe Person
//        data class Person(
//            val name: String,
//            val surname: String
//        )
//        ```
//
//        ```typescript
//        // TypeScript: Chiamata del metodo Kotlin dalla parte TypeScript tramite Kotlin/JS
//
//        import { PersonMock } from 'shared' // Importa il modulo Kotlin compilato in JS
//
//        function displayPerson() {
//            const person = PersonMock.getPerson() // Chiamata al metodo Kotlin
//            console.log(`Person's name: ${"\${person.name}"}, surname: ${"\${person.surname}"}`);
//        }
//
//        displayPerson();
//        ```
//
//        Notes:
//        In questo esempio, l'oggetto `PersonMock` in Kotlin contiene il metodo `getPerson()` che restituisce un'istanza della classe `Person`. Grazie a **Kotlin/JS**, il codice Kotlin viene compilato in JavaScript e può essere utilizzato in TypeScript come un modulo importato.
//        """.trimIndent()
//            }
//        }
//    }

    //TODO Dove imparare

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
//                    style = """
//                        position: absolute;
//                        bottom: 0px;
//                        right: 100px;
//                        width: 100px;
//                        height: 100px;
//                        margin-right: 250px;
//                    """.trimIndent()

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
                        // <lottie-player src="mascot.json"  speed="1" style="width: 300px; height: 300px;" loop="" autoplay=""></lottie-player>
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
                    
                    17 maggio 2017 Google I/O, annuncio del supporto Kotlin allo sviluppo Android
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


                }
            }
        }
    }

    //TODO Bytecode decompiler

    //TODO KSP-KAPT-ANNOTATOR PROCESSOR?
}