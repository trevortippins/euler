#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=21
    http://keyzero.wordpress.com/2010/02/09/project-euler-problem-21/
 *********************************************************************/

def sum_of_divisors = new int[30000]
Arrays.fill(sum_of_divisors, 1)

for (i in 2..<10000) {
  def sqrt = (int)Math.sqrt(i)
  for (j in 2..sqrt) {
    if (i % j == 0)
      sum_of_divisors[i] += j + i.intdiv(j)
  }
  if (sqrt * sqrt == i) sum_of_divisors[i] -= sqrt
}

def answer = 0

for (a in 1..<10000) {
  b = sum_of_divisors[a]
  if ((a != b) && (sum_of_divisors[b] == a))
    answer += a
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
