#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=96
    http://keyzero.wordpress.com/2010/06/14/project-euler-problem-96/
 *********************************************************************/

def recurse(grid, r, c) {
  if (grid[r][c][0] != 0) {
    if (( r == 8 ) && ( c == 8 )) return true
    def (r1, c1) = ( c == 8 ) ? [ r + 1, 0 ] : [ r, c + 1 ]
    return recurse(grid, r1, c1)
  }

  def unavail = used_numbers(grid, r, c)

  for (i in 1..9) {
    if (unavail.contains(i)) continue
    grid[r][c][0] = i
    if (recurse(grid, r, c)) return true
  }

  grid[r][c][0] = 0
  return false
}

def used_numbers(grid, r, c) {
  def used = [] as Set
  for (i in 0..8) {
    used << grid[r][i][0]
    used << grid[i][c][0]
  }
  def (gr, gc) = [ 3 * r.intdiv(3), 3 * c.intdiv(3) ]
  for (y in gr..gr+2) {
    for (x in gc..gc+2) {
      used << grid[y][x][0]
    }
  }
  used
}

def reduce(grid) {
  def updated = true
  def count = 0
  while (updated) {
    updated = false
    grid.eachWithIndex { row, y ->
      row.eachWithIndex { cell, x ->
        if (cell[0] == 0) {
          cell[1] -= used_numbers(grid, y, x)
          if (cell[1].size() == 1) {
            cell[0] = cell[1][0]
            ( updated, count ) = [ true, count + 1 ]
          }
        }
      }
    }
  }
  count
}

def uniques(grid) {
  def count = 0
  grid.each { row ->
    def uniq =
        row.findAll { it[0] == 0 }
           .collect { it[1] }
           .flatten()
           .groupBy { it }
           .findAll { it.value.size() == 1 }
           .keySet()

    uniq.each { v ->
      def cell = row.find { it[1].contains(v) }
      cell[0] = v
      cell[1] = [v]
      count++
    }
  }
  count
}

def solve(lines) {
  def grid =
      lines.collect { line ->
        line.collect {
          def v = it.toInteger()
          [ v, v == 0 ? (1..9).toList() : [v] ] }
      }

  def updates = -1
  while (updates != 0) {
    updates = 0
    updates += reduce(grid)
    updates += uniques(grid)
  }

  if ((0..2).any { grid[0][it][0] == 0 }) recurse(grid, 0, 0)

  grid[0][0..2].inject(0) { p, v -> p * 10 + v[0] }
}

def answer = 0

def sudoku_text =
    new URL("http://projecteuler.net/project/sudoku.txt").getText().split("\r\n")

sudoku_text.eachWithIndex { line, idx ->
  if (line.startsWith("Grid")) {
    answer += solve(sudoku_text[idx+1..idx+9])
  }
}

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed time: ${_ticks / 1e6} ms"
