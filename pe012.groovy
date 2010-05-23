#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=12
    http://keyzero.wordpress.com/2010/01/27/project-euler-problem-12/
 *********************************************************************/

cache = [:]

def divisors(num) {
  if (cache[num]) return cache[num]
  def count = 0
  def sqrt_num = (int)Math.sqrt(num)
  for (i in 1..sqrt_num) {
    if (num % i == 0) count += 2
  }
  if (sqrt_num ** 2 == num) count -= 1
  cache[num] = count
}

def (answer, i) = [ 0, 0 ]

while (answer == 0) {
  i++
  if ( ((i % 2 == 0) ? divisors(i.intdiv(2)) * divisors(i + 1)
                     : divisors(i) * divisors((i + 1).intdiv(2))) > 500)
    answer = (i * (i + 1)).intdiv(2)
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
