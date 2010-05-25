#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=230
    http://keyzero.wordpress.com/2010/01/09/project-euler-problem-230/
 *********************************************************************/

def (A, B) =
        ["14159265358979323846264338327950288419716939937510" + 
         "58209749445923078164062862089986280348253421170679",
         "82148086513282306647093844609550582231725359408128" +
         "48111745028410270193852110555964462294895493038196 "]

def phi = (Math.sqrt(5) + 1) / 2

def answer = (0..17).sum { Long n ->
    def p = (long)((127 + 19 * n) * (7 ** n)) - 1
    def k = (long)(p / 100)
    def m = (long)(k / (phi ** 2))
    def i = (int)(p % 100)
    (10 ** n) * (((long)Math.ceil(m * phi ** 2)) == k ? A[i] : B[i]).toLong()
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
