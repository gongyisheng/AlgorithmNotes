# Use sieve algorithms to calculate the value of Möbius function, μ(n)
import time

# Möbius function, μ(n)
# For any positive integer n, 
# define μ(n) as the sum of the primitive nth roots of unity. 
# It has values in {−1, 0, 1} depending on the factorization of n into prime factors:

# μ(n) = +1 if n is a square-free positive integer with an even number of prime factors.
# μ(n) = −1 if n is a square-free positive integer with an odd number of prime factors.
# μ(n) = 0 if n has a squared prime factor.

def mobius(n):
    is_prime = [True] * (n+1)
    is_prime[1] = False
    prime = []
    mu = [0] * (n+1)
    mu[1] = 1
    for i in range(2, n+1):
        if is_prime[i]:
            mu[i] = -1
            prime.append(i)
        j = 0
        # traverse the prime number list
        # sieve the target number: i*prime[j]
        while j < len(prime) and i * prime[j] <= n:
            is_prime[i * prime[j]] = False
            # if i%prime[j] == 0, which means that the target has squared prime factor
            if i % prime[j] == 0:
                mu[i * prime[j]] = 0
                break
            # if i%prime[j] != 0, which means that the target does not has squared prime factor
            # mu[target] = -mu[i] because now the number of prime factors ++
            else:
                mu[i * prime[j]] = -mu[i]
            j = j + 1
    return mu[n]

if __name__ == "__main__":
    import sys
    n = int(sys.argv[1]) if len(sys.argv)>1 else 100000

    start = time.perf_counter()
    ans = mobius(n)
    print(f"n={n}, μ(n)={ans}")
    end = time.perf_counter() - start
    print(f"Program finished in {end:0.2f} seconds.")