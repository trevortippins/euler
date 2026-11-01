#!/usr/bin/env groovy

import groovy.transform.CompileStatic
import groovy.transform.Field

def _ticks = System.nanoTime()

/**********************************************************************
 https://projecteuler.net/problem=118
 https://keyzero.wordpress.com/2010/05/20/project-euler-problem-118/
 *********************************************************************/

@Field
Set<List> _results = new HashSet<List>()

@CompileStatic
static boolean isPrime(int num) {

    if (num <= 1) return false
    if (num <= 3) return true
    if ((num % 2 == 0) || (num % 3 == 0)) return false

    int r = (int)Math.sqrt(num)
    int f = 5

    while (f <= r) {
        if (num % f == 0) return false
        if (num % (f + 2) == 0) return false
        f += 6
    }

    return true
}

@CompileStatic
void splitPrimes(String s, Stack<Integer> stack) {

    for (int len = 0; len < s.length(); len++) {

        int i = Integer.valueOf(s.substring(0, len+1))
        if (!isPrime(i)) continue

        stack.push(i)

        if (len == s.length()-1) {
            List<Integer> r = new ArrayList<Integer>(stack)
            Collections.sort(r)
            _results.add(r)
        }
        else {
            splitPrimes(s.substring(len+1), stack)
        }

        stack.pop()
    }
}

"123456789".split("").toList().eachPermutation {
    splitPrimes( it.join(), new Stack<Integer>() )
}

def answer = _results.size()

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"












