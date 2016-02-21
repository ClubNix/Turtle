#!/usr/bin/luajit

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
sendrecv(id.." turtle up")

id2 = sendrecv("hello")
sendrecv(id2.." turtle right")
direction = {'N', 'S', 'E', 'W', 'NE', 'NW', 'SE', 'SW'}
for i,v in pairs(direction) do
	sendrecv(v)
end
sendrecv("ES")
sendrecv("F")
sendrecv("WN")

sendrecv("42 quit")

