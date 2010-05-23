#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=18
    http://keyzero.wordpress.com/2010/02/08/project-euler-problem-18/
 *********************************************************************/

def tiers = []
new File("pe018_triangle.txt").eachLine { line ->
    tiers << line.trim().split(" ")*.toInteger()
}

(tiers.size()-2).downto(0) { row ->
    for (i in 0..<tiers[row].size()) {
        tiers[row][i] += [tiers[row+1][i], tiers[row+1][i+1]].max()
    }
}

def answer = tiers[0][0]

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
