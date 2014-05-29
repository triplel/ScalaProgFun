ScalaProgFun
============

Problem:
You are given a prefix expression. Write a program to evaluate it. Your program should accept as its first argument a path to a filename. The file contains one prefix expression per line. 

INPUT SAMPLE:

1
* + 2 3 4

Your program has to read this and insert it into any data structure you like. Traverse that data structure and evaluate the prefix expression. Each token is delimited by a whitespace. You may assume that the only valid operators appearing in test data are '+','*' and '/'(floating-point division).

OUTPUT SAMPLE:

Print to stdout, the output of the prefix expression, one per line. E.g.

1
20

Constraints: 
The evaluation result will always be an integer >= 0. 
The number of the test cases is <= 40.
