# 3.1
class T3
    constructor: (@stackSize) ->
        @buffer = []
        @stackPointer = [0, 0, 0]
    push: (n, value) ->
        index = @stackSize * n + @stackPointer[n] + 1
        @stackPointer[n]++
        @buffer[index] = value

    pop: (n) ->
        index = @stackSize * n + @stackPointer[n]
        @stackPointer[n]--
        value = @buffer[index]
        @buffer[index] = 0
        return value

    peek: (n) ->
        index = @stackSize * n + @stackPointer[n]
        return @buffer[index]

t3 = new T3(10)

t3.push(0, 1)
t3.push(0, 2)
t3.push(0, 3)
console.log "buffer: #{t3.buffer}"
t3.pop(0)
console.log "t3.peek: #{t3.peek(0)}"

t3.push(1, 11)
t3.push(1, 12)
t3.push(1, 13)
console.log t3.buffer