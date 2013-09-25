
randomInt = (n) ->
    return parseInt(Math.random() * n)

randomIntInRange = (min, max) ->
    return randomInt(max + 1 - min) + min;

randomMatrix = (m, n, min, max) ->
    matrix = []
    for i in [0...m]
        matrix[i] = []
        for j in [0...n]
            matrix[i][j] = randomIntInRange(min, max)
    matrix

randomArray = (n, min, max) ->
    array = []
    for i in [0...n]
        array[i] = randomIntInRange(min, max)
    array

log = (str) ->
    process.stdout.write(str)

printMatrix = (matrix) ->
    for i in [0...matrix.length]
        for j in [0...matrix[i].length]
            if matrix[i][j] < 10 and matrix[i][j] > -10
                log(' ')
            if matrix[i][j] < 100 and matrix[i][j] > -100
                log(' ')
            if matrix[i][j] >= 0
                log(' ')
            log(' ' + matrix[i][j])
        console.log ""
    console.log ""

exports.randomMatrix = randomMatrix
exports.randomInt = randomInt
exports.randomArray = randomArray
exports.printMatrix = printMatrix
exports.randomIntInRange = randomIntInRange