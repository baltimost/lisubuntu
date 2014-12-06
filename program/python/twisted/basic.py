from twisted.internet import reactor

import time
def printTime():
    print 'Current time is', time.strftime("%H:%M:%S")

def stopReactor():
    print "Stopping reactor"
    reactor.stop()

reactor.callLater(1,printTime)
reactor.callLater(1,printTime)
reactor.callLater(1,printTime)
reactor.callLater(1,printTime)
reactor.callLater(5,stopReactor)

print 'Runing the reactor...'
reactor.run()
print 'Reactor stopped.'

