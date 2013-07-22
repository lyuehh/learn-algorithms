"""
Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer NOTE: One or two additional variables are fine An extra copy of the array is not
"""

main = (str) ->
    len = str.length
    o = {}
    for i in [0...len]
        o[str[i]] = true
    ret = ""
    for i of o
        ret += i
    ret

main2 = (str) ->
    len = str.length
    arr = []
    for i in [0...len]
        if arr.indexOf(str[i]) isnt -1
            continue
        arr.push(str[i])

    arr.join('')

main3 = (str) ->
    len = str.length
    ret = ""
    for i in [0...len]
        for j in [i+1...len]
            console.log "i: #{str[i]}"
            console.log "j: #{str[j]}"
            if str[i] isnt str[j] and i isnt j
                ret += str[i]
    ret

console.log main3('abab')

"""
console.log main('abab')
console.log main('aa')
console.log main('aabb')
console.log main('abc')


console.log main2('abab')
console.log main2('aa')
console.log main2('aabb')
console.log main2('abc')
"""

