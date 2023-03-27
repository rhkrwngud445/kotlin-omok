package domain

class Board(val stones: Stones) {
    var currentColor = Color.BLACK
    fun repeatTurn(coordinateReader: CoordinateReader): Color {
        while (true) {
            val stone = makeStone(currentColor, coordinateReader)
            if (processTurn(stone) != PlaceResult.SUCCESS) continue
            if (stones.isWinPlace()) return stones.getLastStone().color
        }
    }

    private fun makeStone(color: Color, coordinateReader: CoordinateReader): Stone {
        val coordinate = coordinateReader.read(color)
        return Stone(color, coordinate)
    }

    fun processTurn(stone: Stone): PlaceResult {
        if (stones.validateRenju(stone) == PlaceResult.ERROR_RENJU_RULE) {
            return PlaceResult.ERROR_RENJU_RULE
        }
        if (stones.place(stone) == PlaceResult.ERROR_ALREADY_PLACE) {
            return PlaceResult.ERROR_ALREADY_PLACE
        }
        currentColor = currentColor.turnColor()
        return PlaceResult.SUCCESS
    }

    fun isWinPlace(): Boolean {
        return stones.isWinPlace()
    }

    fun restartGame() {
        stones.clearStones()
    }

    companion object {
        val BOARD_END_POINT = Point(15, 15)
        val BOARD_START_POINT = Point(0, 0)
    }
}
