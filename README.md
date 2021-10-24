# Combinations

A utility to determine all possible (unordered) [combinations](https://en.wikipedia.org/wiki/Combination) of a given quantity for a given set.

To run with the given main method, the first arg should be the amount to choose, and every arg after that is treated as a string element in an arbitrarily long list from which to select.
```
javac Combinations.java
java Combinations 3 a b c d e
```
Output:
```
10
a,b,c
a,b,d
a,b,e
a,c,d
a,c,e
a,d,e
b,c,d
b,c,e
b,d,e
c,d,e
```
