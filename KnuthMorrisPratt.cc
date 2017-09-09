#include <iostream>
#include <vector>

/*
Knuth-Morris-Pratt

Time complexity: O(m+n), m=length of text, n=length of pattern

Space complexity: O(n)
*/

using namespace std;

class KnuthMorrisPratt{
public:

    int search(string text, string pattern){

        vector<int>patternMatchArray = patternArray(pattern);

        int i = 0;
        int j = 0;

        while(i < text.length()){

            if(text[i] == pattern[j]){
                i++;
                j++;
            }else{
                if(j!=0) j = patternMatchArray[j-1];
                else i++;
            }
            if(j == pattern.length()) return i-j;
        }
        return -1;
    }

private:
    vector<int> patternArray(string pattern){

        vector<int>patternArray(pattern.size(), 0);

        int i = 1;
        int j = 0;

        while(i < pattern.size()){
            if(pattern[i]!=pattern[j]){
                if(j==0){
                    patternArray[i] = 0;
                    i++;
                }else{
                    j = patternArray[j-1];
                }
            }else{
                patternArray[i] = j+1;
                i++;
                j++;
            }
        }
        return patternArray;
    }
};