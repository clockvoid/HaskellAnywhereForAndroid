package com.lucciola.haskellanywhereforandroidkt.prelude

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.lucciola.haskellanywhereforandroidkt.data.source.HaskellRepository

class PreludeViewModel(
        context: Application,
        private val haskellRepository: HaskellRepository
): AndroidViewModel(context) {

}
