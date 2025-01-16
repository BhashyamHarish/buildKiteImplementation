import com.google.gson.Gson
import java.io.InputStreamReader

object JsonUtils {

    /**
     * Reads a JSON file from the `testdata` folder and converts it into the specified data class.
     *
     * @param T - The type of the data class to deserialize into
     * @param fileName - The name of the JSON file (e.g., "product_data.json")
     * @param clazz - The class type to convert the JSON into
     * @return An instance of the specified data class
     */
    fun <T> getData(fileName: String, clazz: Class<T>): T {
        val inputStream = this::class.java.classLoader?.getResourceAsStream("testdata/$fileName")
            ?: throw IllegalArgumentException("File not found: $fileName")
        val jsonString = InputStreamReader(inputStream).use { it.readText() }

        return Gson().fromJson(jsonString, clazz)
    }
}
