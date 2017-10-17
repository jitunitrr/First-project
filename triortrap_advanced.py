import math
count=3
while True:
  try:
    print("Enter 'y' for exit.")
    side1 = input("Enter dimension of first side: ")
    side2 = input("Enter dimension of second side: ")
    side3 = input("Enter dimension of third side: ")
    if side1=='y':
     break
    a = float(side1)
    b = float(side2)
    c = float(side3)
    # calculate the semi-perimeter
    s = (a + b + c)/2
    # calculate the area
    area = (s*(s-a)*(s-b)*(s-c)) ** 0.5
    print("Area of Triangle = %0.2f" %area)
  except:
     print("could not convert string to float:",side1)
     print(count," attempt left")
     count=count-1
     continue

    
  
