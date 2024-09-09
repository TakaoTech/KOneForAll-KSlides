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
    }

    verticalSlides {


    }

    //TODO Cos'è Kotlin
    // https://kotlinlang.org/assets/kotlin-media-kit.pdf

    //TODO Chi lo utilizza
    //https://www.reddit.com/r/Bitwarden/comments/1b32bbz/going_native_the_future_of_the_bitwarden_mobile/

    //TODO KSP-KAPT-ANNOTATOR PROCESSOR?
}