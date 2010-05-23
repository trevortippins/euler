#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=67
    http://keyzero.wordpress.com/2010/01/03/project-euler-problem-61/
 *********************************************************************/

def polyfuncs = [
    3 : { (it * (it + 1)) / 2 },   4 : { it * it },
    5 : { it * (3 * it - 1) / 2 }, 6 : { it * (2 * it - 1) },
    7 : { it * (5 * it - 3) / 2 }, 8 : { it * (3 * it - 2) } ]

def buildCycle(numbers) {
  def cycle = []
  buildCycle(cycle, numbers)
  return cycle
}

def buildCycle(cycle, numbers) {
  if (cycle.size() == numbers.size()) return true
  def keys = numbers.keySet()
                    .findAll { p -> !cycle.any { it[0] == p } }
                    .sort()
                    .reverse()
  for (poly in keys) {
    def nums = numbers[poly].findAll { n ->
        (!cycle.any { it[1] == n }) &&
        ((cycle.size() == 0) || (n.intdiv(100) == cycle[-1][1] % 100)) &&
        ((cycle.size() < numbers.size()-1) || (n % 100 == cycle[0][1].intdiv(100)))
    }
    for (n in nums) {
        cycle.push([ poly, n ])
        if (buildCycle(cycle, numbers)) return true
        cycle.pop()
     }
  }
  return false
}

def numbers = [:]

for (p in polyfuncs.keySet()) {
  numbers[p] = []
  def i = 1
  while (true) {
    Integer n = polyfuncs[p](i)
    if (n > 9999) break
    if ((n > 999) && (n % 100 > 9)) numbers[p] << n
    i++
  }
}

def answer = buildCycle(numbers).sum { it[1] }

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
