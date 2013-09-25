
def remove_depulates(str)
    return str if str.length < 2

    tail = 1
    (1...str.length).to_a do |i|
        (0...tail).to_a do |j|
            if str[i] == str[j]
                break
            end
        end
        if j == tail
            str[tail] = str[i]
            ++tail
        end
    end
    if tail < str.length
        str[tail] = '0'
    end
    str
end

puts remove_depulates("aab")
