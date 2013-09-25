public class T11 {

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
        if(str == null) {return;}
        if(str.length < 2) {return;}

        int tail = 1;
        int len = str.length;
        for(int i=1;i<len;i++) {
            int j;
            for(j=0;j<tail;j++) {
                if(str[i] == str[j]) {
                    break;
                }
            }
            if(j == tail) {
                str[tail] = str[i];
                ++tail;
            }
        }
        if(tail < len) {
            str[tail] = 0;
        }
    }

    public static void main (String[] args) {

        // 1.1
        System.out.printf("==1.1==\n");
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.printf(word + ": " + isUniqueChars(word) + " " + isUniqueChars2(word) + "\n");
        }

        // 1.3
        System.out.printf("==1.3==\n");
        //String[] words3 = {"helloiloveyou", "abb", "abcdee", "aabbccdd"};
        String[] words3 = {"helloiloveyou"};
        for (String word : words3) {
            System.out.print(word + ": ");
            char[] arr = word.toCharArray();
            removeDuplicates(arr);
            System.out.printf(charArrayToString(arr) + "\n");
        }

        // 1.3 test
        char[] carr1 = { 'a', 'b', 'c', 'd' };
        carr1[2] = 0;
        System.out.printf(charArrayToString(carr1) + "\n");

    }
}
