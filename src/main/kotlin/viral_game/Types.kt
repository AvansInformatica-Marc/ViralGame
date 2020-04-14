package viral_game

import arrow.core.Either
import viral_game.data.Paradigm
import viral_game.data.Player

typealias ParadigmOrPlayer = Either<Paradigm, Player>

typealias PlayerFunction = (surroundingParadigms: () -> Collection<Paradigm>) -> Paradigm

typealias Players = Collection<Pair<String, PlayerFunction>>
