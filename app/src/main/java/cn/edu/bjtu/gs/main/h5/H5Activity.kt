package cn.edu.bjtu.gs.main.h5

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import cn.edu.bjtu.gs.databinding.ActivityH5Binding

class H5Activity : AppCompatActivity() {

    private var h5Url: String? = null
    private lateinit var binding: ActivityH5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityH5Binding.inflate(layoutInflater)
        setContentView(binding.root)
        intent.getStringExtra(H5_URL)?.let {
            h5Url = it
        }

        initView()
        initData()
    }

    private fun initView() {
        binding.ivBack.setOnClickListener { finish() }
        (binding.webView.settings).let { setting ->
            setting.supportMultipleWindows()
            setting.loadsImagesAutomatically = true
            setting.blockNetworkImage = true
            setting.javaScriptEnabled = true
            setting.allowContentAccess = true
//            setting.allowFileAccessFromFileURLs = true
//        setting.setAppCacheEnabled(true)
            setting.loadWithOverviewMode = true
            setting.useWideViewPort = true
//            setting.pluginState = WebSettings.PluginState.ON
//        setting.setDefaultTextEncodingName("utf-8")//设置网页默认编码
            setting.javaScriptCanOpenWindowsAutomatically = true//JS互调
            setting.useWideViewPort = true
            setting.displayZoomControls = false
            setting.builtInZoomControls = true
            setting.setSupportZoom(true)//缩放
            setting.domStorageEnabled = true // 开启 DOM storage API 功能
            setting.databaseEnabled = true   //开启 database storage API 功能
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                setting.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
            }
        }
        binding.webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

//        binding.webView.settings.useWideViewPort = true
//        binding.webView.settings.setSupportZoom(true)

        binding.webView.webChromeClient = object : WebChromeClient() {

            override fun onReceivedTitle(view: WebView?, title: String?) {
                super.onReceivedTitle(view, title)
                binding.tvTitle.text = title ?: "活动页"
            }


            override fun onProgressChanged(view: WebView?, progress: Int) {
                super.onProgressChanged(view, progress)
            }
        }

        binding.webView.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                url: String?
            ): Boolean {
                view?.loadUrl(url ?: "")
                return super.shouldOverrideUrlLoading(view, url)
            }

        }
    }

    private fun initData() {
        h5Url?.let {
            binding.webView.loadUrl(it)
        }
    }


    companion object {
        const val H5_URL = "h5_url"
    }
}