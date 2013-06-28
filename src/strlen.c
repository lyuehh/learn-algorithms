#include <stdio.h>

int strlen2(char *s);
int strlen3(char *s);

int main(int argc, const char *argv[])
{
  char *s = "uname111";
  printf("%d\n", strlen2(s));
  printf("%d\n", strlen3(s));
  return 0;
}

int strlen2(char *s) {
  int n;

  for(n = 0; *s != '\0'; s++)
    n++;
  return n;
}

int strlen3(char *s) {
  char *p = s;
  while(*p != '\0')
    p++;
  return p - s;
}
