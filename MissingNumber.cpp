#include <iostream>
using namespace std;

int main() {
	int t; 
	cin>> t;
	for(int ii =0; ii<t;ii++)
	{
	    int n; cin>> n;
	    long long sum = 0;
	    for(int i=0;i< n-1; i++) 
	    {
	        int a; cin>>a;
	        sum += a;
	    }
	    cout<< (n*(n+1))/2 - sum<<endl;
	}
	return 0;
}
