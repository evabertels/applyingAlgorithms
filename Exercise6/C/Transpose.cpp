#include <chrono>

#include "helper.h"

void fillRandom(size_t dim, Matrix A) {
  for(int i = 0; i < dim; ++i) {
    for(int j = 0; j < dim; ++j) {
      A[i][j] = rand() % 10;
    }
  }
}


void transpose(size_t dim, Matrix A, Matrix B) {
  for (int j = 0; j < dim; j++) {
    for (int i = 0; i < dim; i++) {
      B[i][j] = A[j][i];
    }
  }
}

void transpose_tiling(size_t dim, Matrix A, Matrix B, int s) {
  int l;
  for (int ii = 0; ii < dim; ii+=s) {
    l = ii+s;
    if (l > dim) {
      l = dim;
    }
    for (int j = 0; j < dim; j++) {
      for (int i = ii; i < l; i++) {
        B[i][j] = A[j][i];
      }
    }
  }
}

int main(int argc, char** argv) {
  size_t n = readDimensionality(argv[1]);
  //Matrix A = readFile(n, argv[2]);
  Matrix A = newMatrix(n);
  fillRandom(n, A);

  int block = std::stoi(argv[2]);
  int repetitions = 10;

  Matrix B = newMatrix(n);

  for (int i = 0; i < repetitions; i++) {
    auto start = std::chrono::system_clock::now();
    transpose(n, A, B);
    auto end = std::chrono::system_clock::now();
    auto elapsed = end - start;
    std::cout << "N" << " "
              << n << " "
              << elapsed.count() << '\n';
  }

  for (int i = 0; i < repetitions; i++) {
    auto start = std::chrono::system_clock::now();
    transpose_tiling(n, A, B, block);
    auto end = std::chrono::system_clock::now();
    auto elapsed = end - start;
    std::cout << "T" << " "
              << n << " "
              << elapsed.count() << " "
              << block << '\n';
  }

  deleteMatrix(n, B);

  deleteMatrix(n, A);
  return 0;
}
