public class T1 {

    public static String charArrayToString(char[] array) {
        StringBuilder buffer = new StringBuilder(array.length);
        for (char c : array) {
            if (c == 0) {
                break;
            }
            buffer.append(c);
        }
        return buffer.toString();
    }
    // 1.1
    public static boolean isUniqueChars(String str) {
        int checker = 0;
        for (int i=0; i< str.length(); ++i) {
            int val = str.charAt(i) - 'a';
            if((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }

    public static boolean isUniqueChars2(String str) {
        boolean[] char_set = new boolean[256];
        for (int i=0; i < str.length(); i++) {
            int val = str.charAt(i);
            if(char_set[val]) return false;
            char_set[val] = true;
        }
        return true;
    }

    // 1.3
    public static void  removeDuplicates(char[] str) {
        if(str == null) {
            return;
        }
        int len = str.length;
        if(len < 2) {
            return;
        }

        int tail = 1;// tail saved the unique char's last index + 1
        for(int i = 1; i < len; ++i) {
            System.out.printf("\nOuter: i: " + i);
            System.out.printf("\n");
            int j;
            for(j = 0;j < tail; ++j) {
                System.out.printf("Inner: i" + i + ", str[i]: " + str[i]);
                System.out.printf("\n");
                System.out.printf("Inner: j" + j + ", str[j]: " + str[j]);
                System.out.printf("\n");
                if(str[i] == str[j]) {
                    break;
                }
            }
            System.out.printf("Inner2: j: " + j);
            System.out.printf("\n");
            System.out.printf("Inner2: tail: " + tail);
            System.out.printf("\n");
            if(j == tail) {
                str[tail] = str[i];
                ++tail;
            }
            System.out.printf("str: " + charArrayToString(str) + "\n");
        }
        if(tail < len) {
            str[tail] = 0;
        }
        System.out.printf("str2: " + charArrayToString(str) + "\n");
    }

    public static void removeDuplicates1(char[] str) {
        if(str == null) {return;}
        int len = str.length;
        if(len < 2) {return;}

        boolean[] hit = new boolean[256];
        for(int i=0;i<256;i++) {
            hit[i] = false;
        }
        hit[str[0]] = true;
        int tail = 1;
        for(int i=1;i<len;i++) {
            if(!hit[str[i]]) {
                str[tail] = str[i];
                ++tail;
                hit[str[i]] = true;
            }
        }
        if(tail < len) {
            str[tail] = 0;
        }
    }

    // 1.4
    public static boolean anagram(String s, String t) {
        if(s.length() != t.length()) {return false;}
        int[] letters = new int[256];
        int num_unique_chars = 0;
        int num_completed_t = 0;
        char[] s_array = s.toCharArray();
        for(char c : s_array) {
            if(letters[c] == 0) {++num_unique_chars;}
            ++letters[c];
        }

        for(int i=0;i<t.length();i++) {
            int c = (int) t.charAt(i);
            if(letters[c] == 0) {
                return false;
            }
            --letters[c];
            if(letters[c] == 0) {
                ++num_completed_t;
                if(num_completed_t == num_unique_chars) {
                    return i == t.length() - 1;
                }
            }
        }
        return false;
    }

    public static void main (String[] args) {

        // 1.1
        System.out.printf("\n==1.1==\n");
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.printf(word + ": " + isUniqueChars(word) + " " + isUniqueChars2(word) + "\n");
        }

        // 1.3
        System.out.printf("\n==1.3== 1==\n");
        String[] words3 = {"helloiloveyou"};
        /* String[] words3 = {"abcd", "aaaa", "", "aaabbb", "abababa"}; */
        for (String word : words3) {
            System.out.print(word + ": ");
            char[] arr = word.toCharArray();
            removeDuplicates(arr);
            System.out.printf(charArrayToString(arr) + "\n");
        }
        // 1.3 2
        System.out.printf("\n==1.3== 2==\n");
        //String[] words3 = {"helloiloveyou", "abb", "abcdee", "aabbccdd"};
        String[] words4 = {"abcd", "aaaa", "", "aaabbb", "abababa"};
        for (String word : words4) {
            System.out.print(word + ": ");
            char[] arr = word.toCharArray();
            removeDuplicates1(arr);
            System.out.printf(charArrayToString(arr) + "\n");
        }

        // 1.3 charArrayToString
        System.out.printf("\n==charArrayToString==\n");
        char[] carr1 = { 'a', 'b', 'c', 'd' };
        carr1[2] = 0;
        System.out.printf(charArrayToString(carr1) + "\n");

        // 1.4
        System.out.printf("\n==1.4==\n");
        System.out.printf("abcde _ cdeba: " + anagram("abcde", "cdeba") + "\n");
        System.out.printf("aabcde _ cdeba: " + anagram("aabcde", "cdeba") + "\n");
    }
}
