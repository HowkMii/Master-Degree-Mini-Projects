x = [2,0,8,3,9,4,5,4,5,5,5,7,4,8,5,2,1]

def f(start):
    next = start+1
    if next == len(x):
        return print("end")
    else:
        if x[start] > x[next] :
            mid = x[start]
            x[start] = x[next]
            x[next]= mid
            if start != 0:
                f(start-1)
            else:
                f(next)
        else:
            f(next)

f(0)
print (x)
