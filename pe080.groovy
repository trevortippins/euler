#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=80
    http://keyzero.wordpress.com/2010/01/21/project-euler-problem-80/
 *********************************************************************/

BigDecimal.metaClass.sqrt() { scale ->
    def (x0, x1) = [ 0.0G, delegate ** 0.5 ]
    while (!x0.equals(x1)) {
        x0 = x1
        x1 = delegate.divide(x0, scale, BigDecimal.ROUND_HALF_UP)
                     .add(x0)
                     .divide(2.0G, scale, BigDecimal.ROUND_HALF_UP)
    }
    return x1
}

def answer = (1..100).sum {
    [1, 4, 9, 16, 25, 36, 49, 64, 81, 100].contains(it) ? 0 :
            new BigDecimal(it).sqrt(101).toString()[0,2..-3].toList()*.toInteger().sum()
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
