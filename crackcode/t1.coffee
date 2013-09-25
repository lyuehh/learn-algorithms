# t14

f = require('./func')

check14  = (str1, str2) ->
    if str1.length isnt str2.length
        return false
    obj1 = {}
    obj2 = {}

    for c in str1
        if obj1[c]
            obj1[c] = obj1[c] + 1
        else
            obj1[c] = 1

    for c in str2
        if obj2[c]
            obj2[c] = obj2[c] + 1
        else
            obj2[c] = 1
    for k, v of obj1
        if obj2[k] and obj2[k] is v
            return true
        else
            return false

console.log "\n===1.4==="
console.log check14("asdasd", "aassdd")
console.log check14("asdasd", "aassd222d")
console.log ""

# t15

check15 = (str) ->
    sArray = str.split('')
    spaceCount = 0
    for c in sArray
        if c is ' '
            spaceCount++
    newLength = sArray.length + spaceCount * 2
    for i in [sArray.length-1..0]
        if sArray[i] is ' '
            sArray[newLength - 1] = '0'
            sArray[newLength - 2] = '2'
            sArray[newLength - 3] = '%'
            newLength = newLength - 3
        else
            sArray[newLength - 1] = str[i]
            newLength = newLength - 1
    return sArray.join('')

console.log "\n===1.5==="
console.log(check15('a b c'))
console.log ""

# t16

check16 = (matrix, n) ->
    for layer in [0...parseInt(n/2)]
        first = layer
        last = n - 1 - layer
        for i in [first...last]
            offset = i - first
            top = matrix[first][i] # save top
            matrix[first][i] = matrix[last - offset][first] # left -> top
            matrix[last - offset][first] = matrix[last][last - offset] # bottom -> left
            matrix[last][last - offset] = matrix[i][last] # right -> bottom
            matrix[i][last] = top # right <- saved top
    return matrix

console.log "\n===1.6==="
m = f.randomMatrix(10, 10, 0, 9)
f.printMatrix(m)
console.log ""
check16(m, 10)
f.printMatrix(m)

# t17

check17 = (matrix) ->
    row = new Array(matrix.length)
    column = new Array(matrix[0].length)

    for i in [0...matrix.length]
        for j in [0...matrix[0].length]
            if matrix[i][j] is 0
                row[i] = 1
                column[j] = 1
    for i in[0...matrix.length]
        for j in [0...matrix[0].length]
            if row[i] is 1 or column[j] is 1
                matrix[i][j] = 0
    matrix

console.log "\n===1.7==="
m = f.randomMatrix(10, 10, 0, 9)
f.printMatrix(m)
console.log ""
check17(m, 10)
f.printMatrix(m)
console.log ""

# t18

isRotation = (str1, str2) ->
    len = str1.length
    if len is str2.length and len > 0
        s1s1 = str1 + str1
        return s1s1.isSubstring(str2)
    return false
