#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=17
    http://keyzero.wordpress.com/2010/02/03/project-euler-problem-17/
 *********************************************************************/

def words = [
    0:"", 1:"one", 2:"two", 3:"three", 4:"four", 5:"five",
    6:"six", 7:"seven", 8:"eight", 9:"nine", 10:"ten",
    11:"eleven", 12:"twelve", 13:"thirteen", 14:"fourteen",
    15:"fifteen", 16:"sixteen", 17:"seventeen", 18:"eighteen",
    19:"nineteen", 20:"twenty", 30:"thirty", 40:"forty",
    50:"fifty", 60:"sixty", 70:"seventy", 80:"eighty",
    90:"ninety", 1000:"onethousand" ]

1.upto(999) {
  if (!words[it]) {
    if (it < 100) {
      words[it] = words[it.intdiv(10) * 10] + words[it % 10]
    }
    else {
      words[it] = "${words[it.intdiv(100)]}hundred"
      def r = it % 100
      if (r > 0) words[it] += "and${words[r]}"
    }
  }
}

def answer = words.values()*.size().sum()

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
