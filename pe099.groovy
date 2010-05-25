#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=99
    http://keyzero.wordpress.com/2009/11/18/project-euler-problem-99/
 *********************************************************************/

def ( i, answer, max ) = [ 1, -1, 0.0 ]

new URL("http://projecteuler.net/project/base_exp.txt")
        .getText()
        .eachLine {

    def ( base, exp ) = it.split(",")*.toDouble()
    def log = Math.log10(base) * exp
    if (log > max) ( answer, max ) = [ i, log ]
    i++
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
