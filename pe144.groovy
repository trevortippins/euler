#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
 http://projecteuler.net/index.php?section=problems&id=2144
 http://keyzero.wordpress.com/2013/04/01/project-euler-problem-144/
 *********************************************************************/

def ( answer, epsilon ) = [ 0, 0.01d ]

def p0 = [ x:0.0d, y:10.1d ]
def p1 = [ x:1.4d, y:-9.6d ]

while ((answer < 1) ||
        !((Math.abs(p1.x) <= epsilon && (p1.y > 0.0)))) {

    answer++

    def a = [ x:p0.x - p1.x, y:p0.y - p1.y ]
    def b = [ x:-4.0 * p1.x, y:-p1.y]

    def ( dotp, crossp ) = [  a.x * b.x + a.y * b.y,
                              a.x * b.y - b.x * a.y ]

    def c = [ x: dotp * b.x - crossp * b.y,
              y: crossp * b.x + dotp * b.y ]
    def s = (-2.0 * (4.0 * c.x * p1.x + c.y * p1.y)) /
            (4.0 * (c.x * c.x) + (c.y * c.y))
    def p2 = [ x:s * c.x + p1.x, y:s * c.y + p1.y ]

    ( p0, p1 ) = [ p1, p2 ]
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed time: ${_ticks / 1e6} ms"
