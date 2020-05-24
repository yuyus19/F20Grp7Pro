import socket
import time

host = 'xxx'
port = xxxx

def setupServer():
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    print("Socket created.")
    try:
        s.bind((host, port))
    except socket.error as msg:
        print(msg)
    print("Socket creation complete")
    return s

def setupConnection():
    s.listen(1) # Allows ONLY one connection at a time!
    con, address = s.accept()
    print("Connected to: " + address[0] + ":" + str(address[1]))
    return con

def dataTransfer(con):
    while True:
        data = con.recv(1024) #recieve the data
        data = data.decode('utf-8') #use utf-8 decoding
        if data == 'kill':
            print("Server is shutting down.")
            s.close()
            break
        elif data == 'test':
            reply = "1"
        else:
            reply = 'Unknown Command'
        con.sendall(reply)
    con.close()

s = setupServer()

while True:
    try:
        con = setupConnection()
        dataTransfer(con)
    except:
        break