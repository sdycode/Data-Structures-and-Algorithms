
// Nearest Right Greatest Number using stack

#include <bits/stdc++.h>
using namespace std;

int main()
{
    // int n = 1000;
    int t;
    vector<int> vInput;
    vector<int> vOut;
    cout << "Enter -1 to stop vector ";
    for (;;)
    {
        if (vInput.size() > 1)
        {
            if (vInput[vInput.size() - 1] == -1)
            {
                break;
            }
        }

        cin >> t;
        vInput.push_back(t);
    }
    vInput.pop_back();
    int arr[vInput.size()];
    for (int i = 0; i < vInput.size(); i++)
    {
        cout << vInput[i] << " ";
        arr[i] = vInput[i];
    }

    stack<int> S;

    // To find gratest no to right , we will traverese from right to left
    int n = sizeof(arr) / sizeof(arr[0]);
    for (int i = n - 1; i >= 0; i--)
    {
        if (S.size() == 0)
        {
            vOut.push_back(-1);
        }
        else if (arr[i] < S.top() && S.size() > 0)
        {
            vOut.push_back(S.top());
        }
        else if (arr[i] > S.top() && S.size() > 0)
        {
            while (arr[i] > S.top() && S.size() > 0)
            {
                cout << "you are in while \n";
                S.pop();
            }
            cout << "out of wile";
            if (S.size() == 0)
            {
                cout << "you are in S emty \n";
                vOut.push_back(-1);
            }
            else
            {
                vOut.push_back(S.top());
            }
        }
        S.push(arr[i]);
    }

    reverse(vOut.begin(), vOut.end());
    for (int i = 0; i < vOut.size(); i++)
    {
        cout << vOut[i] << " ";
    }

    return 0;
}