package arg.edu.ifts18

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var myWebView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        myWebView = findViewById(R.id.webview)

        // Habilitar JavaScript (permitido si el sitio es confiable)
        val webSettings: WebSettings = myWebView.settings
        webSettings.javaScriptEnabled = true

        // WebView seguro (SIN ignorar SSL)
        myWebView.webViewClient = WebViewClient()

        myWebView.loadUrl("https://partes.colegiomilitar.mil.ar/")
    }

    override fun onBackPressed() {
        if (myWebView.canGoBack()) {
            myWebView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}


