#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=59
    http://keyzero.wordpress.com/2009/11/07/project-euler-problem-59/
 *********************************************************************/

def seqs = [ [], [], [] ]

new URL("http://projecteuler.net/project/cipher1.txt")
        .getText()
        .split(",")
	.eachWithIndex { val, idx ->
          seqs[idx % seqs.size()] << val.toInteger()
        }

def answer = 0
def ASCII_SPACE = 32

seqs.each { vals ->

  def freqs = new int[256]
  vals.each { freqs[it]++ }

  def ( pkey, max ) = [ 0, 0 ]
  freqs.eachWithIndex { freq, chr ->
    if (freq > max) ( pkey, max ) = [ chr ^ ASCII_SPACE, freq ]
  }

  answer += vals.sum { it ^ pkey }
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
