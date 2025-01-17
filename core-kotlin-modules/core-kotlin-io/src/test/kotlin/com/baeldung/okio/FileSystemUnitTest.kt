package com.baeldung.okio

import okio.FileSystem
import okio.Path.Companion.toPath
import okio.buffer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class FileSystemUnitTest {
    @Test
    fun test() {
        val files = FileSystem.SYSTEM.list(".".toPath())
        assertTrue(files.contains("README.md".toPath()))
    }

    @Test
    fun readFile() {
        val line = FileSystem.SYSTEM.source("README.md".toPath()).buffer().readUtf8()
        assertEquals("## Core Kotlin I/O", line.lines().first())
    }
}