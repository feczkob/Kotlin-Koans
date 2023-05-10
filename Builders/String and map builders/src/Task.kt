import java.util.HashMap
import javax.swing.UIManager.put

fun <K, V> buildMutableMap(build: HashMap<K, V>.() -> Unit): HashMap<K, V> {
    val m = HashMap<K, V>()
    m.build()
    return m
}
fun usage(): Map<Int, String> {
    return buildMutableMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}
