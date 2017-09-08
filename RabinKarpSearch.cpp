#include <iostream>
#include <math.h>

#define PRIME 11

/*
RabinKarpSearch

 Time complexity: O(m*n), m=length of text, n=length of pattern
 Space complexity: O(1)

 */

using namespace std;

class RabinKarpSearch
{
public:
    int search(string text, string pattern){

        long patternHash = createHash(pattern);
        long textHash = createHash(text.substr(0, pattern.length()));

        for(int i=0; i < text.length() - pattern.length(); i++){

            if(i!=0){
                textHash = (textHash - text[i-1])/PRIME;
                textHash += text[i+pattern.length()-1] * pow(PRIME, pattern.length() - 1);
            }
            if(patternHash==textHash) return i;
        }
        return -1;

    }

    long createHash(string text){

        long hash = 0;
        for(int i=0; i < text.length(); ++i){
            hash += text[i] * pow(PRIME, i);
        }
        return hash;
    }

};
