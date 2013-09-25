#include <stdio.h>

int main(int argc, const char *argv[])
{
    printf("%zu\n", sizeof(char));
    printf("%zu\n", sizeof('a'));


    char *str = "abcde";
    //*str = 'f'; // wrong..

    // wrong
    char header2[2];
    header2 = "Media Player";

    printf("%s\n", str);
    return 0;
}
