import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
public class HammingServer {
	
public static void main(String args[])
{
	Socket          socket   = null; 
	  ServerSocket    server   = null; 
	   DataInputStream in       =  null; 
	   int d[]=new int[50];
	   int p=1,n=0;
	   try
	   { 
	       server = new ServerSocket(5000); 
	       System.out.println("Server started"); 

	       System.out.println("Waiting for a client ..."); 

	       socket = server.accept(); 
	       System.out.println("Client accepted"); 

	       in = new DataInputStream( 
	           new BufferedInputStream(socket.getInputStream())); 

	String line1="";
	       while (!(line1= in.readUTF()).equals(Integer.toString(9))) 
	       { 
	           try
	           { 
                   //System.out.println(Integer.parseInt(line1));
	              d[p]=Integer.parseInt(line1);
	              p++;
	             // System.out.println(d[p-1]+" "+line1);
	               
	           } 
	           catch(Exception ex) 
	           { 
	               System.out.println(ex); 
	           } 
	    
	       } 
	       System.out.println("Closing connection"); 

	       socket.close(); 
	       in.close(); 
	   } 
	   catch(IOException i) 
	   { 
	       System.out.println(i); 
	   } 
	   
	   Scanner sc=new Scanner(System.in);
n=p-1;
int[][] bn=new int[n+1][6];
int i=1,j=1,k=1,l=1,index=0;
for(i=1;i<=n;i++)
{ try
{
	String s=Integer.toBinaryString(i);
	int n1=6-s.length();
	index=0;
	for(j=n1;j<=5;j++)
	{
	bn[i][j]=(int)s.charAt(index++)-48;
	//System.out.println(bn[i][j]);
}
}
catch(Exception e)
{
}
}
int r=0;
for(i=3;i<=5;i++)
{
	while(n>(int)Math.pow(2, i))
	{
		r=i;
		break;
	}
}
r=r+1;
int new1=0;
int ni=1,nk=0;
int[][] rp=new int[r+1][20];
int[] e=new int[r+1];
for(i=5;i>0;i--)
{
	
for(j=1;j<=n;j++)
{
	try {
	if(bn[j][i]==1)
		rp[ni][nk++]=j;
}
	catch(Exception eee)
	{
}
}
ni++;
}
for(i=1;i<=r;i++)
{
	int sum=0;
	for(j=0;j<20;j++)
	{
		sum+=d[rp[i][j]];
	}
	if(sum%2==0)
		e[i]=0;
	else
		e[i]=1;
	//System.out.println(e[i]);
	//System.out.println(sum);

}


int k9=0;
String ee="";
int pos=0;
for(i=1;i<=r;i++)
{
	if(e[i]==1)
	{
		k9=1;
		for(j=r;j>=1;j--)
			ee+=Integer.toString(e[j]);
		System.out.println(ee);
		pos=Integer.parseInt(ee,2);
		System.out.println("Error Detected & Corrected at"+pos);
		if(d[pos]==0)
			d[pos]=1;
		else
			d[pos]=0;
		System.out.println("The Correct Hamming Code is:");
		for(i=1;i<=n;i++)
			System.out.print(d[i]);
		break;
		
	}
}
if(k9==0)
	System.out.println("No Error in Hamming Code");

}
}
