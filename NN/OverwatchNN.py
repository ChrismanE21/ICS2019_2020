import sklearn
import pandas
import matplotlib.pyplot as plt
import seaborn as sns 
import numpy as np
from sklearn.utils import shuffle
from sklearn.neural_network import MLPClassifier
from sklearn.model_selection import cross_validate

data=pandas.read_csv("OverwatchDataNormalizePer.data", header = None) #Reads from the file

import matplotlib.pyplot as plt

import seaborn as sns # visualization
#sns.pairplot( data=data,vars=(0,1,2,3), hue=4 )
#plt.show()

data=np.array(data) #Puts data in a readable array

X=data[:,0:4] #This gets all the rows and only the first 4 columns.
y=data[:,4] #This gets the rank's name

X, y = shuffle(X,y,random_state=1) #First step in testing NN

# ~ trainX = X[:75] #These four lines gather data and then test it
# ~ trainy = y[:75]
# ~ testX = X[75:]
# ~ testy = y[75:]

clf = MLPClassifier(hidden_layer_sizes=[1],max_iter = 100000, random_state=0,) #This is the NN 
# ~ clf.fit(trainX, trainy)1
# ~ prediction=clf.predict(testX) #This test the NN with it's own data

cv_results = cross_validate(clf, X, y, cv=3) #Normalizes code
print(cv_results) #Shows a percent of how well it did///Highest = 41% no normalize. Highest = 83% divide normalize. Highest = 86% fercercy diagram
