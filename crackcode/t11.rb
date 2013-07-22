=begin
Implement an algorithm to determine if a string has all unique characters What if you can not use additional data structures?
=end

def main(str)
    str_length = str.length
    char_set = Array.new(256)
    (0..str_length - 1).to_a.each do |i|
        if char_set[str[i].ord]
            return false
        else
            char_set[str[i].ord] = true
        end
    end
    return true
end

puts main("aa")
puts main("as")
