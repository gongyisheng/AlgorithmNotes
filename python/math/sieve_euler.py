# Use sieve algorithms to calculate the value of Euler totient function, φ(n)
import time

# Euler function, φ(n)
# also known as Euler's totient function.
# It counts the positive integers up to a given integer n that are relatively prime to n.
# Relatively prime: two integers are coprime, relatively prime, or mutually prime if the only positive integer that is a divisor of them both is 1.

# Euler's theorem is a generalization of Fermat's little theorem: for any modulus n and any integer a coprime to n, one has
# a^φ(n) mod n = 1
# Fermat's little theorem is indeed a special case, because if n is a prime number, then φ(n) = n − 1.

def euler(n):
    cnt = 0
    is_prime = [True] * (n+1)
    is_prime[1] = False
    prime = []
    phi = [0] * (n+1) 
    phi[1] = 1
    for i in range(2, n+1):
        if is_prime[i]:
            cnt = cnt + 1
            prime.append(i)
            phi[i] = i - 1
        j = 0
        # traverse the prime number list
        # sieve the target number: i*prime[j]
        while j < cnt and i * prime[j] <= n:
            is_prime[i * prime[j]] = False
            if i % prime[j] == 0:
                # If i % prime[j] == 0, which means i contains all the factors of target
                # (target = i*prime[j], i%prime[j]==0)
                # φ(target) = prime[j] * φ(n)
                phi[i * prime[j]] = phi[i] * prime[j]
            else:
                # If i % prime[j] != 0, which means i is relatively prime to prime[j]
                # for p,q which is relatively prime to each other,
                # φ(p*q) = φ(p) * φ(q)
                # Thus, φ(target) = φ(prime[j]) * φ(n) = (j-1) * φ(n)
                phi[i * prime[j]] = phi[i] * phi[prime[j]]
                break
            j = j + 1
    return phi[n]

if __name__ == "__main__":
    import sys
    n = int(sys.argv[1]) if len(sys.argv)>1 else 100000

    start = time.perf_counter()
    ans = euler(n)
    print(f"n={n}, φ(n)={ans}")
    end = time.perf_counter() - start
    print(f"Program finished in {end:0.2f} seconds.")
