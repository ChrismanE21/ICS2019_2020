#2
import sklearn
import pandas
#3
import matplotlib.pyplot as plt
import seaborn as sns # visualization
#6
import numpy as np
#8
from sklearn.utils import shuffle
#10
from sklearn.neural_network import MLPClassifier


#3
data=pandas.read_csv("iris.data", header = None)
#print(data)


#4
#sns.pairplot( data=data,vars=(0,1,2,3), hue=4 )
#plt.show()

#Could you use this to predict the type of iris based on the lengths of different flower parts?  
#
#What iris can easily be identified?  
#Setosa
#What two are hard to tell apart?  Why?
#versicolor and virginica because their points are either extremely close or mixed together


#5
data=np.array(data)


#6
X=data[:,0:4] #This gets all the rows and only the first 4 columns.
y=data[:,4]
#print(X.shape) #(150,4)
#print(y.shape) #(150,5)


#8
X, y = shuffle(X,y,random_state=0)
#print(X)
#print(y)

#How did you verify this? 
#I printed the X array and the y array together
#What is random_state?
#I think it's a random function in where the user needs to put in a seed to get random numbers. In this case, it is zero.
#How could it be useful?
#To test to see if the program can orgainze data on it's own


#9
trainX = X[:75]
trainy = y[:75]
testX = X[75:]
testy = y[75:]

#10
clf = MLPClassifier(hidden_layer_sizes=[3,3,3,3],max_iter = 100000, random_state=0,)
clf.fit(trainX, trainy)


#11
#print(clf.coefs_)


#12
prediction=clf.predict(testX)


#13
#print(clf.score(trainX,trainy))
#print(clf.score(testX,testy))
#What do these numbers mean?
#The numbers printed is the result of the neural network. At first, I got a 82 and an 86. For the next trail, I added two more hidden layers and got 99 and 96.


#14
from sklearn.model_selection import cross_validate
cv_results = cross_validate(clf, X, y, cv=4)
print(cv_results)
#Do some research and figure out what this is actually doing.
#These lines of code are "normizing" the code. It takes the data and divides it down to make it more simple. The new numbers will fall within the range -1, 0, and 1. This makes the NN easier to follow and read. This produces the result 94%


#print(dir(clf)) Prints everything avl to clf
