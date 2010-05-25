#!/usr/bin/env groovy

def _ticks = System.nanoTime()

/**********************************************************************
    http://projecteuler.net/index.php?section=problems&id=84
    http://keyzero.wordpress.com/2010/04/09/project-euler-problem-84/
 *********************************************************************/

def ( GO, G2J, JAIL ) = [  0, 30, 10 ]
def ( R1, R2, R3 )    = [  5, 15, 25 ]
def ( U1, U2 )        = [ 12, 28 ]
def ( CC1, CC2, CC3 ) = [  2, 17, 33 ]
def ( CH1, CH2, CH3 ) = [  7, 22, 36 ]
def ( C1, E3, H2 )    = [ 11, 24, 39 ]

def counts = new int[40]
def ( location, cci, chi, dbls ) = [ GO, 0, 0, 0 ]

for (i in 1..1000000) {

    def r1 = (int)(Math.random() * 4) + 1
    def r2 = (int)(Math.random() * 4) + 1

    dbls = (r1 == r2) ? dbls+1 : 0
    location = (location + r1 + r2) % 40

    if ((dbls == 3) || (location == G2J)) {
        location = JAIL
        dbls = 0
    }

    if (location in [ CH1, CH2, CH3 ]) {
        switch (chi) {
            case 0: location = GO; break
            case 1:
                location = JAIL
                dbls = 0
                break
            case 2: location = C1; break
            case 3: location = E3; break
            case 4: location = H2; break
            case 5: location = R1; break
            case 6..7:
                location = [(CH1):R2,(CH2):R3,(CH3):R1][location]
                break
            case 8:
                location = [(CH1):U1,(CH2):U2,(CH3):U1][location]
                break
            case 9: location -= 3; break
        }
        chi = ++chi % 16
    }

    if (location in [ CC1, CC2, CC3 ]) {
        switch (cci) {
            case 0: location = GO; break
            case 1:
                location = JAIL
                dbls = 0
                break
        }
        cci = ++cci % 16
    }

    counts[location]++
}

def odds = []
counts.eachWithIndex { v, i -> odds << [ i, v/10000 ] }

def answer =
  odds.sort { -it[1] }[0..2].collect {
      sprintf("%02d",it[0])
  }.join()

/********************************************************************/

_ticks = System.nanoTime() - _ticks

println "Answer: $answer"
println "Elapsed: ${_ticks / 1e6} ms"
