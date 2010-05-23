#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=44
    http://keyzero.wordpress.com/2010/04/28/project-euler-problem-44/
 *********************************************************************/

def ( LIMIT, answer ) = [ 2500, Integer.MAX_VALUE ]
def penta = new int[LIMIT+1]

for (n in 1..LIMIT) {
  penta[n] = (n * (3 * n - 1)).intdiv(2)
}

for (i in 1..<LIMIT) {
  def pi = penta[i]
  for (j in i+1..LIMIT) {
    def pj = penta[j]
    def diff = pj - pi
    if (   (diff < answer)
        && (Arrays.binarySearch(penta, diff) > 0)
        && (Arrays.binarySearch(penta, pi + pj) > 0))
    {
        answer = diff
    }
  }
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
