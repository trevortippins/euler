#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=98
    http://keyzero.wordpress.com/2010/04/10/project-euler-problem-98/
 *********************************************************************/

def getMapping(word, number) {
  def map = [:]
  for (i in 0..<word.size()) {
    def ( c, digit ) = [ word[i], number[i] ]
    if (!((map[c] == null) || (map[c] == digit))) return [:]
    map[c] = digit
  }
  if (map.groupBy { it.value }.any { it.value.size() > 1 }) map = [:]
  return map
}

def ( nums, answer ) = [ [:], 0 ]

(2..10).each {
  def min = Math.ceil(Math.sqrt(10 ** (it-1)))
  def max = Math.floor(Math.sqrt((10 ** it)-1))
  nums[it] = (min..max).collect { (it * it).toInteger() }
}

new URL("http://projecteuler.net/project/words.txt")
    .getText()
    .replace("\"","")
    .tokenize(",")
    .groupBy { it.toList().sort().join() }
    .findAll { it.value.size() > 1 }
    .each { key, words ->
       for (i in 0..<words.size()-1) {
         def len = words[i].size()
         for (n1 in nums[len]) {
           def map = getMapping(words[i], n1.toString())
           if (map.size() == 0) continue
           for (j in i+1..<words.size()) {
             if (words[i].reverse() == words[j]) continue
             def n2 = words[j].collect { map[it] }.join().toInteger()
             if (n2 in nums[len]) answer = [ n1, n2, answer ].max()
           }
         }
       }
     }

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
