#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=19
    http://keyzero.wordpress.com/2010/02/08/project-euler-problem-19/
 *********************************************************************/

def (answer, cal)  = [ 0, new GregorianCalendar() ]

1901.upto(2000) { y ->
    12.times { m ->
        cal.set(y, m , 1)
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) answer++
    }
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
