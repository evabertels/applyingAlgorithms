#ifndef _helper_h_
#define _helper_h_

#include <cstring>
#include <string>
#include <sstream>
#include <fstream>
#include <iostream>

typedef int ** const Matrix;

inline
Matrix newMatrix(const size_t dim) {
    int ** array = new int *[dim];
    for(size_t i = 0; i < dim; ++i) {
        array[i] = new int[dim];
    }
    return array;
}

inline
Matrix newZeroFilledMatrix(const size_t dim) {
    int ** array = new int *[dim];
    for(size_t i = 0; i < dim; ++i) {
        array[i] = new int[dim];
        memset(array[i], 0x00, dim*sizeof(int));
    }
    return array;
}

inline
void deleteMatrix(const size_t dim, Matrix array) {
    for(size_t i = 0; i < dim; ++i) {
        delete array[i];
    }
    delete array;
}

inline
void printMatrix(const size_t dim, Matrix array) {
    for(size_t i = 0; i < dim; ++i) {
        for(size_t j = 0; j < dim; ++j) {
            std::cout << array[i][j] << ((i+1)*(j+1) == dim*dim ? "" : " ");
        }
        std::cout << std::endl;
    }
    std::cout << std::endl;
}


inline
unsigned int readDimensionality(const char * const arg) {
    return std::stoi(arg);
}

inline
Matrix readFile(const unsigned int dim, const char * const fileName) {
    Matrix array = newMatrix(dim);

    std::ifstream file(fileName);
    std::string line;

    unsigned int row, col;
    int value;

    while(!file.eof()){
        file >> line;
        if(line[0] == '#' || line.find(",") == std::string::npos) continue;


        std::stringstream ss(line);
        ss >> row;
        ss.ignore();
        ss >> col;
        ss.ignore();
        ss >> value;

        array[row][col] = value;
    }

    file.close();

    return array;
}

#endif
