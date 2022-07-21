#include<bits/stdc++.h>
using namespace std;

vector<int> NGL(int n, int a[]);
void main(){
    int n;
    int a[n];

    cin>> n;
    for(int i=0;i<n;i++){
        cin>>a[i];
    }
    NGL(n,a);
}

vector<int> NGL(int n, int a[])
{
    stack<int> s;
    vector<int> v;
    for(int i=0;i<n;i++){
        if(s.size()==0){ v.push_back(-1);}
        else if(s.size()>0 && a[i]<s.top()){
            s.pop();
            while (s.size()>0 && a[i]<s.top())
            {
                s.push(a[i]);
            }
        }
        if(s.size()==0){ v.push_back(-1);}
        if(s.size()>0 && ){ v.push_back(-1);}


    }

}

