#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=68
    http://keyzero.wordpress.com/2010/05/21/project-euler-problem-68/
 *********************************************************************/

// NOTE: Requires Groovy 1.7+ for the eachPermutation() method

def SEQ = [ 0, 6, 7, 1, 7, 8, 2, 8, 9, 3, 9, 5, 4, 5, 6 ]
def answer = ""

(1..10).eachPermutation { nums ->

  if (nums[0] > 6) return

  for (i in 1..<5) {
    if (nums[0] > nums[i]) return
  }

  for (i in 5..<10) {
    if (nums[i] == 10) return
  }

  def sum = nums[0] + nums[6] + nums[7]

  def p = 3
  while (p < 15) {
    if (sum != nums[SEQ[p]] + nums[SEQ[p+1]] + nums[SEQ[p+2]]) return
    p += 3
  }

  def sb = new StringBuilder()
  for (i in 0..<15) {
    sb.append(nums[SEQ[i]])
  }

  answer = [ sb.toString(), answer ].max()
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
