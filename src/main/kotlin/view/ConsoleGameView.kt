package view

import dto.ColorDTO
import dto.PointDTO
import dto.StoneDTO

class ConsoleGameView(override val renderBoard: RenderBoard = ConsoleRenderBoard()) : GameView {
    override fun startGame() {
        println(GAME_START)
    }

    override fun renderBoard(stones: List<StoneDTO>, size: PointDTO) {
        renderBoard.render(stones, size)
    }

    override fun readStone(color: ColorDTO, lastStone: PointDTO?): PointDTO? {
        print(USER_TURN.format(colorToString(color)))
        println(
            lastStone?.let {
                LAST_STONE_POSITION.format(coordinateToString(lastStone))
            } ?: ""
        )
        val input = readln().trim()
        if (input.length != 2) {
            return null
        }
        if (input[0] < 'A' || input[0] > 'Z') {
            return null
        }
        if (!input[1].isDigit()) {
            return null
        }
        return PointDTO(input[0] - 'A', input[1].digitToInt() - 1)
    }

    private fun colorToString(color: ColorDTO): String {
        return when (color) {
            ColorDTO.BLACK -> "흑"
            ColorDTO.WHITE -> "백"
        }
    }

    private fun coordinateToString(coordinate: PointDTO): String {
        return ("%c%d".format(('A'.code + coordinate.x).toChar(), coordinate.y))
    }

    companion object {
        private const val GAME_START = "오목 게임을 시작합니다."
        private const val USER_TURN = "%s의 차례입니다."
        private const val LAST_STONE_POSITION = " (마지막 돌의 위치 : %s) "
    }
}