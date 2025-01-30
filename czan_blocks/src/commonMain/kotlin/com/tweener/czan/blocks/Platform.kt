package com.tweener.czan.blocks

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform