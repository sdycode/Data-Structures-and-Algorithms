#include <iostream>
using namespace std;

void print1ton(int a);
void printnto1(int a);
int factorial(int a);
void fibonacci(int a, int b, int n){
    int c;
   
    // base condiion
    if(n<=0){ return;}
    c= a+b;
    a=b;
    b=c;
    cout<<c<<" ";
    fibonacci(a,b,n-1);
    
    

}

int main()
{

    cout << "Enter program no " << endl;
    int n = 1, m=7;
    // cin >> m;
    switch (n)
    {
    case 1:
        print1ton(m);
        cout<<endl;
        printnto1(m);
        cout<<endl;
        int ans ;
        ans = factorial(m);
        cout<<ans<<endl;
        if(m==1){cout<<0<<" ";}
        else{cout<<0<<" "<<1<<" ";}
        fibonacci(0,1,m-2);

        break;
    case 2:
        break;
    default:
        break;
    }
    return 0;
}

void print1ton(int n)
{
    if (n < 1)
    {
        n *= -1;
    }
    if (n == 1)
    {
    }
    else
    {

        print1ton(n - 1);
    }
    cout << n << " ";
}

void printnto1(int n)
{
    if (n < 1)
    {
        n *= -1;
    }
    cout << n << " ";
    if (n == 1)
    {
    }
    else
    {

        print1ton(n - 1);
    }
}

int factorial(int n){
    
    if(n==1){
        return 1;
    }
    else{
        return  n*factorial(n-1);
        // return 1; 
        // return n*factorial(n-1);
    }
}

