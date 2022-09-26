#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

// Möbius function, μ(n)
// For any positive integer n, 
// define μ(n) as the sum of the primitive nth roots of unity. 
// It has values in {−1, 0, 1} depending on the factorization of n into prime factors:

// μ(n) = +1 if n is a square-free positive integer with an even number of prime factors.
// μ(n) = −1 if n is a square-free positive integer with an odd number of prime factors.
// μ(n) = 0 if n has a squared prime factor.

// Time complexity: O(n)
// Space complexity: O(n)
int mobius(int n) {
    bool is_prime[n+1];
    std::fill_n (is_prime, n+1, true);
    is_prime[1] = false;
    vector<int> prime;
    int mu[n+1];
    std::fill_n (mu, n+1, 0);
    mu[1] = 1;
    for (int i = 2; i <= n; ++i) {
        if (is_prime[i]){
            mu[i] = -1;
            prime.push_back(i);
        }
        // traverse the prime number list
        // sieve the target number: i*prime[j]
        for (int j = 0; j < prime.size() && i*prime[j] <= n; ++j) {
            is_prime[i * prime[j]] = false;
            if (i % prime[j] == 0) {
                // if i%prime[j] == 0, which means that the target has squared prime factor
                mu[i * prime[j]] = 0;
                break;
            } else {
                // if i%prime[j] != 0, which means that the target does not has squared prime factor
                // mu[target] = -mu[i] because now the number of prime factors ++
                mu[i * prime[j]] = -mu[i];
            }
        }
    }
    return mu[n];
}

int main() {
    for(int i=1;i<20;i++){
        int ans = mobius(i);
        cout << ans;
        cout << ",";
    }
    return 0;
}