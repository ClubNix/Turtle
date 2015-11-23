#!/usr/bin/lua

local zmq = require "lzmq"
local context = zmq.context()

print "Connecting to hello world server…"

local requester = context:socket(zmq.REQ)
requester:connect("tcp://localhost:5555")

for requestNbr=0,9 do
	local request = "Hello"
	print("Sending Hello "..requestNbr)
	requester:send(request)

	local reply = requester:recv()
	print(reply)
end
requester:send("quit")
