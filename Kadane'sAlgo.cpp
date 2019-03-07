#include <iostream>
using namespace std;
int solve(int n, int a[])
{
    int ans = 0,maxelement = int(-1e8);
    int currSum = 0,maxsum =0;
    for(int i=0; i<n; i++)
    {
        if(currSum+a[i]> 0)  currSum+= a[i];
        else currSum = 0;
        maxsum = max(maxsum,currSum);
        maxelement =  max(maxelement, a[i]);
    }
    ans = maxelement < 0? maxelement: maxsum;
    return ans;
}
int main() {
	int t; 
	cin>> t;
	for(int ii = 1; ii<= t;ii++)
	{
	    int n; cin>> n;
	    int a[n+1];
	    for(int i=0; i<n; i++)
	    cin>> a[i];
	    int ans = solve(n,a);
	    cout<<ans<<endl;
	}
	return 0;
}
