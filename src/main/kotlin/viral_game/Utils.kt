package viral_game

/** Returns the first element and a list of all other elements in a tuple. */
fun <T> Collection<T>.destructured(): Pair<T, Collection<T>?>
        = first() to if(size == 1) null else drop(1)
