import java.util.*

fun <K, C : MutableCollection<K>> Collection<K>.partitionTo(
    one: C,
    two: C,
    pred: Collection<K>.(K) -> Boolean,
): Pair<MutableCollection<K>, MutableCollection<K>> {
    // * solution 1
//    this.forEach {
//        if (pred(it)) {
//            one += it
//        } else {
//            two += it
//        }
//    }

    // * solution 2
    val (a, b) = this.partition { pred(it) }
    one.addAll(a)
    two.addAll(b)

    return Pair(one, two)
}


fun partitionWordsAndLines() {
    val (words, lines) = listOf("a", "a b", "c", "d e")
        .partitionTo(ArrayList(), ArrayList()) { s -> !s.contains(" ") }
    check(words == listOf("a", "c"))
    check(lines == listOf("a b", "d e"))
}

fun partitionLettersAndOtherSymbols() {
    val (letters, other) = setOf('a', '%', 'r', '}')
        .partitionTo(HashSet(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z' }
    check(letters == setOf('a', 'r'))
    check(other == setOf('%', '}'))
}
