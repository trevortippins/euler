#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=51
    http://keyzero.wordpress.com/2010/01/19/project-euler-51/
 *********************************************************************/

def isPrime = new boolean[1000000]
Arrays.fill(isPrime, true)
(0..1).each { isPrime[it] = false }

for (i in 2..isPrime.size()**0.5) {
  if (isPrime[i]) {
      def j = i + i
      while(j < isPrime.size()) {
          isPrime[j] = false
          j += i
      }
  }
}

def (answer, i) = [ 0, 100001 ]

while ((i < isPrime.size()) && (answer == 0)) {
  if (isPrime[i]) {
    def s = i.toString()
    def s1 = s[0..-2]
    for (n in "0".."2") {
      if (s1.findAll { it == n }.size() == 3) {
        def c = 0
        for (j in n.."9") {
          def pp = (s1.replace(n, j) + s[-1]).toInteger()
          if ((pp > 99999) && isPrime[pp]) c++
        }
        if ( c == 8 ) answer = i
        break
      }
    }
  }
  i++
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
