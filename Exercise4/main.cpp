#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
#include<stdlib.h>
#include<chrono>

int sortInt(int size, int range, bool random) {
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
  List<Int> runtimes = new List<Int>;
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
  for (int i = 0; i < 20; i++) {
    high_resolution_clock::time_point t1 = high_resolution_clock::now();
    for (int x = 0; x < size; ++x) {
      std::cout << myPQ.top() << std::endl;
      myPQ.pop();
    }
    high_resolution_clock::time_point t2 = high_resolution_clock::now();
    runtimes.Add(t2-t1);
  }
  return std::max(runtimes);
}

int main(int argc, char **argv) {
  std::cout << sortPQ(100, 100, true) << std::endl;
  return 0;
}
