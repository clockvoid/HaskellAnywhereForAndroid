package com.lucciola.haskellanywhereforandroidkt.main

import android.app.Application
import android.util.Log
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.core.FlipperClient
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin;
import com.facebook.soloader.SoLoader
import com.lucciola.haskellanywhereforandroidkt.BuildConfig

class HaskellAnywhere : Application() {
    override fun onCreate() {
        super.onCreate()
        SoLoader.init(this, false)
        val client: FlipperClient? =
                when (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(this)) {
                    true -> AndroidFlipperClient.getInstance(this)
                    else -> null
                }

        client?.apply {
            addPlugin(InspectorFlipperPlugin(this@HaskellAnywhere, DescriptorMapping.withDefaults()))
            addPlugin(NetworkFlipperPlugin())
            start()
            Log.d("Application class: HaskellAnywhere", "initialized")
        }
    }
}