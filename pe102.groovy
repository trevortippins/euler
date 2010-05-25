#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=102
    http://keyzero.wordpress.com/2009/11/20/project-euler-problem-102/
 *********************************************************************/

def answer = 0

new URL("http://projecteuler.net/project/triangles.txt")
        .getText()
        .eachLine {

    def (x0, y0, x1, y1, x2, y2) = it.split(",")*.toInteger()
    def ( a, b, c ) = [ [ x0, y0 ], [ x1, y1 ], [ x2, y2 ] ]
    def theta = 0.0

    [ [ a, b ], [ a, c ], [ b, c ] ].each {
        def ( u, v ) = it
        def dot = u[0] * v[0] + u[1] * v[1]
        def ul =  Math.sqrt(u[0] * u[0] + u[1] * u[1])
        def vl =  Math.sqrt(v[0] * v[0] + v[1] * v[1])
        theta += Math.acos(dot / (ul * vl))
    }

    if (Math.abs(theta - 2 * Math.PI) < 1E-7) answer++
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
