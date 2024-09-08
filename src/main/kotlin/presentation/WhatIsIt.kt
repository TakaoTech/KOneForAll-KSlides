package presentation

import com.kslides.Presentation

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

    //STACKS tecnologici attuali, tipo su base typescript, dart


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
        In questo esempio, un oggetto complesso di tipo `Person` viene creato da un oggetto `ReadableMap` passato dal lato JavaScript. La classe `Person` contiene due campi: `name` e `surname`. Dopo aver creato l'oggetto, viene convertito in una mappa e restituito al codice JavaScript attraverso una Promise.
        """.trimIndent()
            }
        }


    }

    verticalSlides {

        markdownSlide {
            // STACK tecnologico basato su Dart
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
            // Trasferimento di dati da Android a Flutter tramite MethodChannel

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
        """
            }
        }
    }

    verticalSlides {
        markdownSlide {
            """
                
            """.trimIndent()
        }
    }

    //TODO Cos'è Kotlin
    // https://kotlinlang.org/assets/kotlin-media-kit.pdf

    //TODO Chi lo utilizza
    //https://www.reddit.com/r/Bitwarden/comments/1b32bbz/going_native_the_future_of_the_bitwarden_mobile/

    //TODO KSP-KAPT-ANNOTATOR PROCESSOR?
}