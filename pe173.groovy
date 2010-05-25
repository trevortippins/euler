#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=173
    http://keyzero.wordpress.com/2010/04/11/project-euler-problem-173/
 *********************************************************************/

def LIMIT = 1000000
def (answer, MINW, MAXW) = [ 0, 3, LIMIT.intdiv(4)+1 ]

for (width in MINW..MAXW) {
  def tiles = (width - 1) * 4
  answer++
  def (inner, inside) = [ width - 2, tiles - 8 ]
  while ((tiles + inside <= LIMIT) && (inner >= MINW)) {
    tiles += inside
    answer++
    inner -= 2
    inside -= 8
  }
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
