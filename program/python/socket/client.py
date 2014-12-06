import socket
import time
import random
import time
from playground.network.message.StandardMessageSpecifiers import *
from playground.network.message.ProtoBuilder import MessageDefinition
from playground.network.message import MessageData
from playground.network.common import Packet
import cPickle

class PCPMessage(MessageDefinition):

    PLAYGROUND_IDENTIFIER = "PCPMessageID"

    MESSAGE_VERSION = "1.0"

    BODY = [
            ("Packet_Type", STRING),
            ("Sequence_Number", UINT8),
            ("Data", STRING),
            ("Segment_END", BOOL1),
            ("Checksum", UINT8),
            ("Timestamp",UINT8)
            ]

def YunKeWrap(msg):#just for test
    return '000004'+msg+'test'

def SeqNoGen():
    return (int)(random.random()*10000)

class Sender:
    def __init__(self):
        self.seq = SeqNoGen()
        self.sessionisOpen = False
    def packMaker(self):
        package = MessageData.GetMessageBuilder("PCPMessageID")
        package["Packet_Type"].setData("")
        package["Sequence_Number"].setData(0)
        package["Data"].setData("")
        package["Segment_END"].setData(False)
        package["Checksum"].setData(0)
        package["Timestamp"].setData(0)
        return package
    def sendPackage(self, packageType):
        package = self.packMaker()
        package["Packet_Type"].setData(packageType)
        package["Sequence_Number"].setData(self.seq)
        return package
        
        

if __name__ == "__main__":
    sender = Sender() 
    
    while True:
        sock = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
        sock.connect(('localhost',7034))
        time.sleep(0)
        msg = raw_input("msg to be sent")
        msg = YunKeWrap(msg)

        package = sender.sendPackage("SYNC")
        print package.data().Packet_Type
        print package.data().Sequence_Number
#package = Packet.SerializeMessage(package)
        package = cPickle.dumps(package)
        

        sock.send(package)
        print sock.recv(1024)
        sock.close()
