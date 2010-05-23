#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=43
    http://keyzero.wordpress.com/2010/04/28/project-euler-problem-43/
 *********************************************************************/

def uniqueDigits(s) {
  (s.toList() as Set).size()
}

def getCandidates(lvl) {
  def primes = [17, 13, 11, 7, 5, 3, 2]
  def result = []
  for (i in 1..<1000) {
    def s = ("000" + i.toString())[-3..-1]
    if ((i % primes[lvl] == 0) && (uniqueDigits(s) == 3)) result << s
  }
  return result
}

def matchSets(p1, p2) {
  def res = []
  for (s1 in p1) {
    p2.findAll { s2 -> (s1[-2..-1] == s2[0..1]) && (!s2.contains(s1[0])) }
      .each { res << (s1[0] + it) }
  }
  return res
}

def matching(lvl) {
  if (lvl == 0) return getCandidates(lvl)
  return matchSets(getCandidates(lvl), matching(lvl-1))
}

def pandigitals = matching(6).collect {
  for (n in "0".."9") {
    if (!it.contains(n)) return n + it
  }
}

def answer = pandigitals.sum { it.toLong() }

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
