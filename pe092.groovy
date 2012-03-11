#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=92
    http://keyzero.wordpress.com/2010/09/11/project-euler-problem-92/
 *********************************************************************/

def sumOfSquares(n) {
  def sum = 0
  for (c in n.toString()) {
    def v = c.toInteger()
    sum += v * v
  }
  return sum
}

def permutations(n) {
  def factorials = [ 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 ]                     
  def s = 1
  for (i in n) {
    s *= factorials[i]
  }
  return factorials[7].intdiv(s)
}

def gen_digits(range, maxlen, yield) {
  gen_digits(range, maxlen, [], yield)
}

def gen_digits(range, maxlen, digits, yield) {
  if (digits.size() == maxlen)
    yield(digits)
  else if (digits.size() == 0)
    range.each { gen_digits(range, maxlen, [it], yield) }
  else
    range.findAll { it >= digits[0] }
         .each { gen_digits(range, maxlen, [it]+digits, yield) }
}

def MAX = 9 * 9 * 7
def sumsOfSquares = new int[MAX+1]

Arrays.fill(sumsOfSquares,0)
sumsOfSquares[1] = 1
sumsOfSquares[89] = 89

for (i in 2..MAX) {
  def sum = i
  while ((sum != 1) && (sum != 89)) {
    sum = sumOfSquares(sum)
    if (sumsOfSquares[sum] != 0) sum = sumsOfSquares[sum]
  }
  sumsOfSquares[i] = sum
}

def answer = 0

gen_digits((0..9), 7) { digits ->
  def sum = sumsOfSquares[sumOfSquares(digits.join().toInteger())]
  if (sum == 89) {
    def nn = new int[10]
    digits.each { nn[it]++ }
    answer += permutations(nn)
  }
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed time: ${_ticks / 1e6} ms"
