package viral_game.grid

import kotlin.math.floor

object Grid {
    fun createGridWithCoordinates(width: Int, height: Int): Collection<Coordinates> {
        return List((width * height)) { cellNumber ->
            (cellNumber % width) to floor(cellNumber / width.toDouble()).toInt()
        }
    }

    class RectGrid<T>(val width: Int, val height: Int, init: (Coordinates) -> T): Collection<Cell<T>> {
        private val cells: Collection<Cell<T>> = createGridWithCoordinates(width, height).map {
            Cell(init(it), it, this)
        }

        val upperLeft: Cell<T>
            get() = get(0 to 0) as Cell<T>

        val upperRight: Cell<T>
            get() = get(width - 1 to 0) as Cell<T>

        val lowerLeft: Cell<T>
            get() = get(0 to height - 1) as Cell<T>

        val lowerRight: Cell<T>
            get() = get(width - 1 to height - 1) as Cell<T>

        operator fun get(coordinates: Coordinates) = cells.find { it.coordinates == coordinates }

        override val size: Int
            get() = cells.size

        override fun contains(element: Cell<T>) = cells.contains(element)

        override fun containsAll(elements: Collection<Cell<T>>) = cells.containsAll(elements)

        override fun isEmpty() = cells.isEmpty()

        override fun iterator() = cells.iterator()

    }

    fun <T> createSquareGrid(capacity: Int, init: (Coordinates) -> T) = RectGrid(capacity, capacity, init)

    data class Cell<T> internal constructor(var value: T, val coordinates: Coordinates, private val grid: RectGrid<T>) {
        val left: Cell<T>?
            get() = grid[coordinates.x - 1 to coordinates.y]

        val top: Cell<T>?
            get() = grid[coordinates.x to coordinates.y - 1]

        val right: Cell<T>?
            get() = grid[coordinates.x + 1 to coordinates.y]

        val bottom: Cell<T>?
            get() = grid[coordinates.x to coordinates.y + 1]

        val surroundingCells: Collection<Cell<T>>
            get() = arrayOf(left, top, right, bottom).filterNotNull()

        override fun toString() = "$coordinates = $value"
    }
}
