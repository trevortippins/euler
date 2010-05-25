#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=89
    http://keyzero.wordpress.com/2010/05/14/project-euler-problem-89/
 *********************************************************************/

def fromRoman(s) {

    def romans = [ I:1, V:5, X:10, L:50, C:100, D:500, M:1000 ]
    def ( lastChar, grpValue, sum ) = [ null, 0, 0 ]

    s.toList().eachWithIndex { v, i ->

      if (i == 0) {
        lastChar = v
        grpValue = romans[v]
      }
      else if (v == lastChar) {
        grpValue += romans[v]
      }
      else {
        if (romans[lastChar] < romans[v]) grpValue *= -1
        sum += grpValue
        grpValue = romans[v]
        lastChar = v
      }

      if (i == s.size()-1) {
        if (romans[lastChar] < romans[v]) grpValue *= -1
        sum += grpValue
      }
    }

    return sum
}

def toRoman(n) {

    def s = ""

    [ 1000:"M", 900:"CM", 500:"D", 400:"CD", 100:"C", 90:"XC",
        50:"L",  40:"XL",  10:"X",   9:"IX",   5:"V",  4:"IV",
         1:"I" ].each { k, v ->
      def m = n.intdiv(k)
      if (m > 0) {
        s += v * m
        n -= k * m
      }
    }
    return s
}

def answer = 0

new URL("http://projecteuler.net/project/roman.txt")
        .getText()
        .eachLine {
    answer += it.size() - toRoman(fromRoman(it)).size()
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
