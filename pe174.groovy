#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=174
    http://keyzero.wordpress.com/2010/04/12/project-euler-problem-174/
 *********************************************************************/

def LIMIT = 1000000
def MAX = LIMIT.intdiv(4)+1
def (MINW, MAXW) = [ 3, LIMIT.intdiv(4)+1 ]

def L = new int[LIMIT+1]
Arrays.fill(L,0)

for (width in MINW..MAXW) {
  def tiles = (width - 1) * 4
  L[tiles]++
  def (inner, inside) = [ width - 2, tiles - 8 ]
  while ((tiles + inside <= LIMIT) && (inner >= MINW)) {
    tiles += inside
    L[tiles]++
    inner -= 2
    inside -= 8
  }
}

def answer =
    L.toList().findAll { it > 0 && it < 11 }.size()

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
