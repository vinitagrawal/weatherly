package me.vinitagrawal.weatherly

import com.google.gson.Gson
import java.io.File

fun getFileFromPath(filePath: String): File {
    val basePath = "src/test/resources/"
    return File(basePath, filePath)
}

fun <T> File.read(clazz: Class<T>): T {
    val str = this.reader().readText()
    return Gson().fromJson(str, clazz)
}