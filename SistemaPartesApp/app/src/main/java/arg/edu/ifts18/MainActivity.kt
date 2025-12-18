package arg.edu.ifts18

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var myWebView: WebView // Declarar myWebView como propiedad de clase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        myWebView = findViewById(R.id.webview) // Inicializar la propiedad

        // Habilitar JavaScript si es necesario
        val webSettings: WebSettings = myWebView.settings
        webSettings.javaScriptEnabled = true

        myWebView.webViewClient = object : WebViewClient() {
            override fun onReceivedSslError(
                view: WebView,
                handler: android.webkit.SslErrorHandler,
                error: android.net.http.SslError
            ) {
                handler.proceed() // Ignorar error SSL
            }
        }
        myWebView.loadUrl("https://partes.colegiomilitar.mil.ar/Partes/Identity/Account/Login?ReturnUrl=%2FPartes")
    }

    override fun onBackPressed() {
        if (myWebView.canGoBack()) {
            myWebView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}

