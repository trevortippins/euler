#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=90
    http://keyzero.wordpress.com/2010/04/12/project-euler-problem-90/
 *********************************************************************/

def combinations(n, k, yield) {
  def selected = new int[k]
  for (i in 0..<k) { selected[i] = i }
  while (true) {
    yield(selected)
    def i = k - 1
    while ((i >= 0) && (selected[i] == ( n - k + i ))) { i-- }
    if (i < 0) break
    selected[i]++
    for (j in (i + 1)..<k) { selected[j] = selected[i] + j - i }
  }
}

def squares = []
(1..9).each {
  def n = it * it
  def sqr = [ n.intdiv(10), n % 10 ]
  [6,9].each { d -> Collections.replaceAll(sqr, d, -1) }
  squares << sqr
}

def c = []
combinations(10, 6) {
  def digits = it.toList()
  [6,9].each { d -> Collections.replaceAll(digits, d, -1) }
  c << digits
}

def answer = 0

c[0..-2].eachWithIndex { d1, i ->

  c[(i+1)..-1].each { d2 ->

    if (squares.every {
            d1.contains(it[0]) && d2.contains(it[1]) ||
            d1.contains(it[1]) && d2.contains(it[0])
        }) answer++
  }
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
