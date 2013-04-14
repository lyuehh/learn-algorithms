#include <stdio.h>

int sum_iter(int arr[], int n);
int sum_recursive(int arr[], int n);

int main(int argc, const char *argv[])
{
  int arr[] = {1,2,3,4,5};
  printf("iter: %d\n", sum_iter(arr, 5));
  printf("recursive: %d\n", sum_recursive(arr, 5));
  return 0;
}

int sum_iter(int arr[], int n) {
  int i;
  int sum = 0;
  for(i=0;i<n;i++) {
    sum += arr[i];
  }
  return sum;
}

int sum_recursive(int arr[], int n) {
  int i;
  int sum = 0;
  if(n == 0) {
    return 0;
  } else {
    return (sum_recursive(arr, n-1) + arr[n-1]);
  }
}

