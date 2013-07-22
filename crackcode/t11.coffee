"""
Implement an algorithm to determine if a string has all unique characters What if you can not use additional data structures?
"""

main  = (str) ->
    str_length = str.length
    char_set = new Array(256)
    for i in [0..str_length - 1]
        if char_set[str.charCodeAt(i)]
            return false
        else
            char_set[str.charCodeAt(i)] = true

    return true

console.log main("aa")
console.log main("ab")

main2 = (str) ->
    checker = 0
    str_length = str.length
    for i in [0..str_length - 1]

        # 相对于'a'的偏移
        val = str.charCodeAt(i) - 'a'.charCodeAt(0)

        # 判断是不是自己
        if ((checker & (1 << val)) > 0)
            return false
        # 用二进制中某一位是1还是0来表示某个字母是否存在
        # |的时候会保存是1的那一位
        # &的时候会取到那一位，如果&后的结果大于0，则表示已经存在过了
        checker |= (1 << val)

    return true

console.log main2("aa")
console.log main2("ab")

main3 = (str) ->
    str_length = str.length
    for i in [0...str_length]
        for j in [i+1...str_length]
            if str[i] == str[j]
                return false

    return true

console.log main3("aa")
console.log main3("abab")
console.log main3("ab")
console.log main3("abcd")
