x=int(input())
def factors(x):
 a=[]
 if(x>0):
  for i in range(1,x+1):
    if(x%i==0):
       a.append(i)
 elif(x<0):
   y=x*(-1)+1
   for i in range(x,y):
     try:
      if(x%i==0):
        a.append(i)
     except ZeroDivisionError:
        pass
 else:
     a.append(0)
     
 print(a)

factors(x)
