import com.kslides.PresentationTheme
import com.kslides.Speed
import com.kslides.Transition
import com.kslides.kslides
import com.pambrose.srcref.Api.srcrefUrl
import presentation.Backend
import presentation.Kmp
import presentation.WhatIsIt

fun main() {

    val slides = "src/main/kotlin/Slides.kt"

    fun srcrefLink(token: String, escapeHtml4: Boolean = false) =
        srcrefUrl(
            account = "kslides",
            repo = "kslides-template",
            path = slides,
            beginRegex = "\\s+// $token begin",
            beginOffset = 1,
            endRegex = "\\s+// $token end",
            endOffset = -1,
            escapeHtml4 = escapeHtml4,
        )

    kslides {

        output {
            // Write the presentation's html files to /docs for GitHub Pages or netlify.com
            enableFileSystem = true

            // Run locally or on Heroku
            enableHttp = true
            httpPort = 8090
        }

        // CSS values assigned here are applied to all the presentations
        css +=
            """
      #githubCorner path { 
        fill: #258BD2; 
      }
      """

        presentationConfig {
            history = true
            transition = Transition.SLIDE
            transitionSpeed = Speed.SLOW
            topRightHref = "/"  // Assign to "" to turn this off
            topRightTitle = ""

            enableMenu = true
            theme = PresentationTheme.DRACULA
            enableSpeakerNotes = true
            slideNumber = "c/t"

            menuConfig {
                numbers = true
            }

            slideConfig {
                // Assign slide config defaults for all presentations
                // backgroundColor = "blue"
                backgroundColor = "#27282c"
            }
        }

        presentation {

            css +=
                """
        #ghsrc {
          font-size: 30px;
          text-decoration: underline;
        }  
        img[alt=revealjs-image] { 
          width: 1000px; 
        }
        """

            WhatIsIt()
            Kmp()
            Backend()
        }
    }
}
