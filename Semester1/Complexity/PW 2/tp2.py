x = [2,0,8,3,9,4]

def f(start,end):
    next = start+1
    if next == len(x):
        return print("end")
    else:
        if x[start] >= x[next] :
            mid = x[start]
            x[start] = x[next]
            x[next]= mid
            try:
                f(start-1,end)
            except :
                pass
        else:
            f(next,end)

f(0,len(x))
print (x)

"""
def f(start,end):
    if start == end :
        return print("end")
    else:
        
        n=2
        f(start,end/2)
        
        if len(x[start,end]) == n :
            
            if x[end-n] >= x[end]:
                mid = x[end-n]
                x[end-n] = x[end]
                x[end] = mid

            n=n+2
        f(end/2,end)
        if len(x[start,end]) == n :
            
            if x[end-n] >= x[end]:
                mid = x[end-n]
                x[end-n] = x[end]
                x[end] = mid

            n=n+2



f(0,len(x))
print (x)"""