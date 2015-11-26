#!/usr/bin/lua

local zmq = require "lzmq"
local context = zmq.context()

print "Connecting to hello world server…"

local requester = context:socket(zmq.REQ)
requester:connect("tcp://localhost:5555")

function sendrecv(message)
	requester:send(message)
	reply = requester:recv()
	print(message.." -> "..reply)
end

sendrecv("position")
sendrecv("up")
sendrecv("position")

sendrecv("quit")

