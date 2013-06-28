#include <stdio.h>

int max(int arr[], int n);
void max_min_devide(int arr[], int l, int r, int max, int min);

int min(int arr[], int n);

int main(int argc, const char *argv[])
{
  int arr[] = {1,6,7,8,9,4,3,2,5,0};
  printf("max: %d\n", max(arr, 10));
  printf("min: %d\n", min(arr, 10));
  return 0;
}

int max(int arr[], int n) {
  int max = arr[0];
  int i;
  for(i=1;i<n;i++) {
    if(arr[i] > max) {
      max = arr[i];
    }
  }
  return max;
}
int min(int arr[], int n) {
  int min = arr[0];
  int i;
  for(i=1;i<n;i++) {
    if(arr[i] < min) {
      min = arr[i];
    }
  }
  return min;
}
