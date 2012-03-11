#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=112
    http://keyzero.wordpress.com/2010/09/05/project-euler-problem-112/
 *********************************************************************/

def (answer, b) = [ 100, 0 ]

def isBouncy(n) {
  def s = n.toString()
  def direction = 0
  def len = s.length()
  for (i in 1..<len) {
    if (direction == 1 && (s[i] < s[i-1])) return true
    if (direction == -1 && (s[i] > s[i-1])) return true
    if (direction == 0) {
      if (s[i] > s[i-1]) {
        direction = 1
      }
      else if (s[i] < s[i-1]) {
        direction = -1
      }
    }
  }
  return false
}
 
while (true) {
  if (isBouncy(answer)) b++
  if (answer * 0.99 == b) break
  answer++
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed time: ${_ticks / 1e6} ms"
