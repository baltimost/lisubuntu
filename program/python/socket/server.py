import socket
import cPickle
from playground.network.common import Packet

sock = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
sock.setsockopt(socket.SOL_SOCKET,socket.SO_REUSEADDR,1)
sock.bind(('localhost',7034))
sock.listen(5)
while True:
    connection,address = sock.accept()
    try:
#connection.settimeout(5)
        buf = connection.recv(1024)
        print buf
        msg = cPickle.loads(buf)
#print buf
    except socket.timeout:
        print 'time out'
    connection.close()
