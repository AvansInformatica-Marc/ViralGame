package viral_game.grid

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import viral_game.ParadigmOrPlayer
import viral_game.data.Paradigm
import viral_game.data.Player

typealias ViralGameCell = Grid.Cell<ParadigmOrPlayer>

var ViralGameCell.paradigm: Paradigm?
    get() = (this.value as? Either.Left)?.a
    set(newValue) {
        if(newValue != null)
            value = newValue.left()
    }

var ViralGameCell.player: Player?
    get() = (value as? Either.Right)?.b
    set(newValue) {
        if(newValue != null)
            value = newValue.right()
    }