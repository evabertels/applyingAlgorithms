import numpy

def build(n, x=10):
    matrix = numpy.empty([n,n])

    for i in range(n):
        for j in range(n):
            matrix[i,j] = numpy.random.randint(x)

    return matrix

def print_matrix(matrix):
    for i in range(matrix.shape[0]):
        for j in range(matrix.shape[1]):
            print("%i,%i,%i" % (i, j, matrix[i,j]))

if __name__ == "__main__":
    import sys
    n = int(sys.argv[1])
    print_matrix(build(n))
