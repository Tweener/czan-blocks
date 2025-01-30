package com.tweener.czan.blocks

class WasmJsPlatform : Platform {
    override val name: String = "WasmJS"
}

actual fun getPlatform(): Platform = WasmJsPlatform()
