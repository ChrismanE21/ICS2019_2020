import math
import sys
import turtle

print("This first program coverts fahrenheit to celsius")
def F_to_C (f):
	c =(f-32)*5/9
	print(c,"degrees celsius")

num = int(input("Enter an intger number of degrees fahrenheit: "))

F_to_C (num)


print("/////////////////////////////////////////////////////////////////////")
print("This program coverts arces to barns")

def A_to_B (a):
	b = a * 4.0468564224E+31 
	
	print(b,"barns")

num = float(input("Enter arces: "))

A_to_B (num)

print("/////////////////////////////////////////////////////////////////////\nThis program draws shapes")

def polygon (p):
	angleMax = 360
	angle = 360 / p
	shape = turtle.Turtle()
	while(angleMax>0):
		shape.forward(1)
		shape.left(angle)
		angleMax = angleMax - angle
	screen = shape.getscreen()
	screen.mainloop()


polygon(int(input("Enter Number of sides (big numbers take longer): ")))


