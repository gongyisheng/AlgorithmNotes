# Use sieve algorithms to anwser the question: 
# How many prime numbers are there under an arbitary number n
import math
import time

# Time complexity: O(n*loglogn)
# Space complexity: O(n)
# Optimization: 
# 1. filter even number
# 2. iterate to sqrt(n)
# 3. divide by block
def Eratosthenes(n):
    p = 0
    prime = []
    is_prime = [True] * (n+1)
    is_prime[0] = is_prime[1] = False

    for i in range(2, n + 1):
        if is_prime[i]:
            prime.append(i)
            p += 1
            if i * i <= n:
                j = i * i
                while j <= n:
                    is_prime[j] = False
                    j = j + i
    # print(f"prime number list: {prime}")
    return p

# Time complexity: O(n*loglog(sqrt(n)))
# Space complexity: O(sqrt(n)+block_size)
# Scan prime from (0,sqrt(n)), cut the is_prime by block size, check numbers in each block.
# It can both save memory usage and avoid unnecessary labeling.
def Eratosthenes_optimized(n, block_size=100000):
    p = 0
    prime = []
    limit = int(math.sqrt(n)) + 1
    is_prime = [True] * limit
    is_prime[0] = is_prime[1] = False

    for i in range(2, limit):
        if is_prime[i]:
            prime.append(i)
            j = i * i
            while j < limit:
                is_prime[j] = False
                j = j + i
    
    k = 0
    while k*block_size <= n:
        is_prime = [True] * block_size
        start = k*block_size
        for pr in prime:
            start_index = int((start + pr - 1)/pr)
            j = max(start_index, pr) * pr - start
            while j < block_size:
                is_prime[j] = False
                j += pr
        if k == 0:
            is_prime[0] = is_prime[1] = False
        for idx in range(min(block_size, n-start+1)):
            if is_prime[idx]:
                p += 1
        k += 1

    return p

# Time complexity: O(n)
# Space complexity: O(n)
def Euler(n):
    p = 0
    prime = []
    is_prime = [True] * (n+1)
    for i in range(2, n+1):
        if is_prime[i] == True:
                prime.append(i)
                p += 1
        for pr in prime:
            if i * pr > n:
                break
            is_prime[i * pr] = False
            if i % pr == 0:
                # the numbers in prime list are ordered from small to big.
                # if i % pr == 0, which means that the number has been sieved before.
                # every time we allow the number to check by multiplying one more time the smallest prime factor they have.
                # every combined number can be written as a list of prime factors multiplied together, from big to small.
                break
    return p


if __name__ == "__main__":
    import sys
    n = int(sys.argv[1]) if len(sys.argv)>1 else 100000

    start = time.perf_counter()
    print(Eratosthenes(n))
    end = time.perf_counter() - start
    print(f"Program finished in {end:0.2f} seconds.")

    start = time.perf_counter()
    print(Eratosthenes_optimized(n, max(10000,int(n/1000))))
    end = time.perf_counter() - start
    print(f"Program finished in {end:0.2f} seconds.")

    start = time.perf_counter()
    print(Euler(n))
    end = time.perf_counter() - start
    print(f"Program finished in {end:0.2f} seconds.")