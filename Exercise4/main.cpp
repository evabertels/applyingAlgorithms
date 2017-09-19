#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
#include<stdlib.h>

int sortRandInt(int size, int range, bool random) {
  std::vector<int> myVector;
  if (random) {
    for(int x = 0; x < size; ++x) {
      myVector.push_back(rand() % range);
    }
  }
  else {
    for(int x = 0; x < size; ++x) {
      myVector.push_back(x);
    }
  }
  std::sort(myVector.begin(), myVector.end());
  return 0;
}

int sortPQ(int size, int range, bool random) {
  std::priority_queue<int,std::vector<int>,std::greater<int> > myPQ;
  if (random) {
    for (int x = 0; x < size; ++x){
      myPQ.push(rand() % range);
    }
  }
  else {
    for (int x = 0; x < size; ++x){
      myPQ.push(x);
    }
  }
  for (int x = 0; x < size; ++x) {
    std::cout << myPQ.top() << std::endl;
    myPQ.pop();
  }
}

int main(int argc, char **argv) {
  srand(0);
  /*

  // using priority queue:
  std::priority_queue<int,std::vector<int>,std::greater<int> > myPQ;
  for (int x = 0; x < 10; ++x){
    myPQ.push(rand() % 100);
  }

  for (int x = 0; x < 10; ++x) {
    std::cout << myPQ.top() << std::endl;
    myPQ.pop();
  }

  //using sorting:
  std::vector<int> myVector;
  for(int x = 0; x < 10; ++x) {
    myVector.push_back(rand() % 100);
  }
  std::sort(myVector.begin(), myVector.end());

  for(int x = 0; x < 10; ++x){
    std::cout << myVector[x] << std::endl;
  }
  */
  return 0;
}
