#include <stdio.h>

void replace(char *str) {
    int i = 0;
    char *q = str;
    while(*q) {
        if(*q == 'b') {
            q++;
        } else {
            if(*q == 'c' && (str[i-1] == 'a' && i > 0)) {
                q++;
                i--;
            } else {
                str[i] = *q;
                q++;
                i++;
            }
        }
    }
    str[i] = '\0';
}

void swap(char a, char b) {
    char temp;
    temp = a;
    a = b;
    b = temp;
}

void removeBAndAC(char *p, int size) {
    int i = 0;
    int j = 0;

    while(i < size) {
        if(p[i] == 'b') {
            i++;
        } else if((p[i] == 'a') && (i + 1 < size) && (p[i+1] == 'c')) {
            i += 2;
        } else {
            if(i != j) swap(p[i], p[j]);
            i++;
            j++;
        }
    }
    p[j] = '\0';
}

void remove2(char *a, int n) {
    int k = 0;
    int i;
    for(i=0;i<n;i++) {
        if(a[i] != 'b') {
            if(a[i] != 'a') {
                a[k++] = a[i];
            } else if((i+1) < n && a[i+1] == 'c') {
                i += 1;
            } else {
                a[k++] = a[i];
            }
        }
    }
    if(k < n) {
        a[k] = '\0';
    }
}

int main(int argc, const char *argv[])
{
    char str1[] = "abc";
    char str2[] = "aaac";
    //char str3[] = "c";

    /* eliminate(str1); */
    /* replace(str1); */
    /* removeBAndAC(str1, 3); */
    remove2(str1, 3);
    remove2(str2, 4);
    //replace(str2);
    //replace(str3);

    printf("%s\n", str1);
    printf("%s\n", str2);
    //printf("%s\n", str3);
    return 0;
}
