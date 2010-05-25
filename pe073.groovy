#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=73
    http://keyzero.wordpress.com/2010/04/09/project-euler-problem-73/
 *********************************************************************/

def ( stack, top ) = [ new int[12000], 0 ]
def ( c, d ) = [ 3, 2 ]
def answer = 0

while (true) {
    def m = c + d
    if (m > 12000) {
        if (top == 0) break
        c = d
        d = stack[--top]
    }
    else {
        answer++
        stack[top++] = d
        d = m
    }
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
