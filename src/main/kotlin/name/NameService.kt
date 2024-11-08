package name

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

interface NameService {
    fun getName(argb: Int): Result<String?>

    class Default(private val gson: Gson) : NameService {
        private val typeToken by lazy {
            object : TypeToken<Map<String, String>>() {}.type
        }

        private val colorNames by lazy {
            runCatching {
                javaClass.classLoader.getResource("color-names.json")?.readText()?.let { json ->
                    gson.fromJson(json, typeToken) as? Map<String, String>
                }
            }
        }

        override fun getName(argb: Int) = runCatching {
            String.format("#%06X", 0xFFFFFF and argb).let { hex ->
                colorNames.getOrNull()?.get(hex)
            }
        }
    }
}