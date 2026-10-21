#!/usr/bin/env groovy

import java.util.concurrent.atomic.AtomicIntegerArray

def _ticks = System.nanoTime()

/**********************************************************************
 http://projecteuler.net/index.php?section=problems&id=14
 http://keyzero.wordpress.com/2010/01/29/project-euler-problem-14/

 Made a few updates from what's shown in the blog post to make it more
 thread-friendly and remove some of the casting that was needed before.
 *********************************************************************/

def solve14 = { int start, int end, AtomicIntegerArray cache ->

    def (int maxlen, int answer, int cache_size) = [ 0, 0, cache.length() ]

    for (int i = start; i < end; i++) {
        long n = i
        int len = 1

        while (n > 1) {
            if (n < cache_size) {
                int cached = cache.get((int)n)
                if (cached != 0) {
                    len += cached - 1
                    break
                }
            }

            if ((n & 1) == 0) {
                n >>= 1
                len++
            } else {
                n = (n + n +n + 1) >> 1
                len += 2
            }
        }

        cache.set(i, len)

        if (len > maxlen) ( maxlen, answer ) = [ len, i ]
    }

    return [maxlen: maxlen, answer: answer]
}

int CACHE_SIZE = 1_000_000
def cache = new AtomicIntegerArray(CACHE_SIZE)
def partialResults = new Object[2]

def threads = [
        new Thread({
            partialResults[0] = solve14.call(670000, 1000000, cache)
        }),
        new Thread({
            partialResults[1] = solve14.call(0, 670000, cache)
        })
]

threads.each { it.start() }
threads.each { it.join() }

def best_result = partialResults[0].maxlen > partialResults[1].maxlen ?
        partialResults[0] : partialResults[1]

def answer = best_result.answer

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
