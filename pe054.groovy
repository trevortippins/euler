#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    https://projecteuler.net/problem=54
    https://keyzero.wordpress.com/2016/11/18/project-euler-problem-54/
 *********************************************************************/

class Hand {

    private final _cards
    private final _isStraight
    private final _isFlush

    Hand(cardList) {
        def vals = cardList.collect {
            ['face': '23456789TJQKA'.indexOf(it[0]), 'suit': 'CDHS'.indexOf(it[1])]
        }

        _isFlush = (vals.groupBy { it.suit }.size() == 1 )
        _cards   = vals.groupBy { it.face }
                       .collect { [ (it.value.size()), it.key ] }
                       .sort { -(it[0] * 13 + it[1]) }
        _isStraight = (_cards.size() == 5) && (_cards[0][1] - _cards[-1][1] == 4)
    }

    def score() {
        rank() * 169 + _cards[0][1] * 13 + _cards[1][1]
    }

    def rank() {
        if (_isStraight && _isFlush && _cards[0][1] == 12) return 9
        if (_isStraight && _isFlush)                       return 8
        if (_cards[0][0] == 4 )                            return 7
        if (_cards[0][0] == 3 && _cards[1][0] == 2 )       return 6
        if (_isFlush)                                      return 5
        if (_isStraight)                                   return 4
        if (_cards[0][0] == 3 )                            return 3
        if (_cards[0][0] == 2 && _cards[1][0] == 2 )       return 2
        if (_cards[0][0] == 2)                             return 1
        0
    }

    def beats(opponent) {
        def (s1, s2) = [ this.score(), opponent.score() ]
        if (s1 > s2) return true
        assert (s1 != s2)
    }
}

def answer = new File('pe054_poker.txt').readLines().count {
    def cards = it.split(" ")
    new Hand(cards[0..4]).beats(new Hand(cards[5..-1]))
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
