#include<stdio.h>
#include<math.h>
 
int gcd(int a, int h)
{
    int temp;
    while(1)
    {
        temp = a%h;
        if(temp==0)
        return h;
        a = h;
        h = temp;
    }
}
 
int main()
{
    double p = 5;
    double q = 7;
    double n=p*q;
    double count;
    double totient = (p-1)*(q-1);
 
    double e=2;
 
    while(e<totient){
    count = gcd(e,totient);
    if(count==1)
        break;
    else
        e++;
    }
 
    double d;
 
    double k = 2;
 
    d = (1 + (k*totient))/e;
    double msg = 12;
    double c = pow(msg,e);
    double m = pow(c,d);
    c=fmod(c,n);
    m=fmod(m,n);
 
    printf("Message data = %.0lf\n",msg);
    printf("\np = %.0lf",p);
    printf("\nq = %.0lf\n",q);
    printf("\nn = pq = %.0lf",n);
    printf("\nQuotient = %.0lf\n",totient);
    printf("\ne = %.0lf",e);
    printf("\nd = %.0lf\n",d);
    printf("\nEncrypted data = %.0lf",c);
    printf("\nOriginal Message Sent = %.0lf",m);
 
    return 0;
}