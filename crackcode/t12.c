#include <stdio.h>

void reverse(char *str) {
    char *end = str;
    char tmp;

    if(str) {
        while(*end) {
            ++end;
        }
        --end;
        while(str < end) {
            tmp = *str;
            *str++ = *end;
            *end-- = tmp;
        }
    }
}

int main(int argc, const char *argv[])
{
    char str[] = "asdf";
    reverse(str);
    printf("%s\n", str);
    return 0;
}
