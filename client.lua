#!/usr/bin/lua

local zmq = require "lzmq"
local context = zmq.context()

local requester = context:socket(zmq.REQ)
requester:connect("tcp://localhost:5555")

function sendrecv(message)
	requester:send(message)
	reply = requester:recv()
	print(message.." -> "..reply)
	return reply
end

sendrecv("position")
sendrecv("miaou")
sendrecv("up")
sendrecv("position")
id = sendrecv("hello")
sendrecv(id.." turtle up")

sendrecv("quit")

