package domain

class Board(val stones: Stones) {
    fun repeatTurn(coordinateReader: CoordinateReader): Color {
        var currentColor = Color.BLACK
        while (true) {
            val stone = makeStone(currentColor, coordinateReader)
            if (!processTurn(stone)) continue
            if (stones.isWinPlace()) return stones.getLastStone().color
            currentColor = currentColor.turnColor()
        }
    }

    private fun makeStone(color: Color, coordinateReader: CoordinateReader): Stone {
        val coordinate = coordinateReader.read(color)
        return Stone(color, coordinate)
    }

    fun processTurn(stone: Stone): Boolean {
        if (stones.validateRenju(stone) != PlaceResult.SUCCESS) {
            return false
        }
        if (stones.place(stone) != PlaceResult.SUCCESS) {
            return false
        }
        return true
    }

    fun isWinPlace(): Boolean {
        return stones.isWinPlace()
    }

    companion object {
        val BOARD_END_POINT = Point(15, 15)
        val BOARD_START_POINT = Point(0, 0)
    }
}
