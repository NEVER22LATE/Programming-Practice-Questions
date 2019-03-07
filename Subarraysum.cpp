#include<bits/stdc++.h>
using namespace std;

void solveBySlidingWindow(int a[],int n,int result)
{
	int i=0;
	int j=0;
	int currentSum =0;
	while(i<n)
	{
		if(currentSum == result) break;
		else if(currentSum> result )
			currentSum -= a[i++];
		else 
			currentSum += a[j++];
	}
	if(i<n) cout<<i+1<<" "<<j<<endl; //for(int ii = i; ii< j; ii++) cout<<a[ii]<<" ";
	else cout<<"-1"<<endl;
}
int main()
{
	int t;
	cin>> t;
	for(int tt = 1; tt<=t;tt++)
	{
		int n,sum;
		cin>>n>>sum;
		int a[n+1];
		for(int i= 0;i<n;i++)
		{
			cin>> a[i];
		}
		solveBySlidingWindow(a,n,sum);//printf("\n");
	}
}
