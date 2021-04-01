#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(vector<string> participant, vector<string> completion) 
{
    string answer = "";
    vector <string> p(participant);
    for(auto i = p.begin(); i != p.end(); ++i)
    {
        for(auto j = completion.begin(); j != completion.end(); ++j)
        {
            if(p[i] == completion[j])
            {
                p.erase(i);
            }
        }
    }

    for(string answer : p)
        cout << answer;
        
    return answer;
}

int main()
{


    return 0;
}