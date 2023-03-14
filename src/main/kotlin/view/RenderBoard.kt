package view

class RenderBoard {
    fun renderBoard(stones: List<Pair<Int, Pair<Int, Int>>>) {

        for (i in 0 until (15 * 15)) {
            val x = i % 15
            val y = i / 15

            val stone = stones.find {
                it.second.first == x && it.second.second == y
            }
            if (stone != null) {
                if (stone.second.first == 0 && stone.first == 0)
                    print(BLACK_LEFT_STONE)
                else if (stone.second.first == 14 && stone.first == 0)
                    print(BLACK_RIGHT_STONE)
                else if (stone.first == 0)
                    print(BLACK_INNER_STONE)

                if (stone.second.first == 0 && stone.first == 1)
                    print(WHITE_LEFT_STONE)
                else if (stone.second.first == 14 && stone.first == 1)
                    print(WHITE_RIGHT_STONE)
                else if (stone.first == 1)
                    print(WHITE_INNER_STONE)

                if (i > 0 && i % 14 == 0)
                    println()
                continue
            }

            if (x == 0 && y == 0) print(EMPTY_LEFT_TOP_SLOT)
            else if (x == 14 && y == 0) print(EMPTY_RIGHT_TOP_SLOT)
            else if (y == 0) print(EMPTY_TOP_SLOT)
            else if (x == 0 && y == 14) print(EMPTY_LEFT_BOTTOM_SLOT)
            else if (x == 14 && y == 14) print(EMPTY_RIGHT_BOTTOM_SLOT)
            else if (y == 14) print(EMPTY_BOTTOM_SLOT)
            else if (x == 0) print(EMPTY_LEFT_SLOT)
            else if (x == 14) print(EMPTY_RIGHT_SLOT)
            else print(EMPTY_INNER_SLOT)

            if (i > 0 && i % 14 == 0)
                println()
        }
    }

    companion object {
        private const val EMPTY_INNER_SLOT = "─┼─"
        private const val EMPTY_LEFT_SLOT = "├─"
        private const val EMPTY_TOP_SLOT = "─┬─"
        private const val EMPTY_RIGHT_SLOT = "─┤"
        private const val EMPTY_BOTTOM_SLOT = "─┴─"
        private const val EMPTY_LEFT_TOP_SLOT = "┌─"
        private const val EMPTY_RIGHT_TOP_SLOT = "─┐"
        private const val EMPTY_LEFT_BOTTOM_SLOT = "└─"
        private const val EMPTY_RIGHT_BOTTOM_SLOT = "─┘"

        private const val BLACK_INNER_STONE = "─●─"
        private const val BLACK_LEFT_STONE = "●─"
        private const val BLACK_RIGHT_STONE = "─●"

        private const val WHITE_INNER_STONE = "─○─"
        private const val WHITE_LEFT_STONE = "○─"
        private const val WHITE_RIGHT_STONE = "─○"
    }
}
