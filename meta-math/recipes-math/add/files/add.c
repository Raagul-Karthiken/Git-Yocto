#include <stdio.h>

extern int add(int a,int b);

int main()
{
	int x,y;
	printf("Enter a number : ");
	scanf("%d",&x);
	printf("Enter a number : ");
	scanf("%d",&y);
	printf("SUM = %d\n\n",add(x,y));
	printf("\n\n---HAVE A GOOD DAY---\n\n");
	
	return 0;
}


