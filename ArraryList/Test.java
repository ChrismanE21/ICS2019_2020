	/*Documentation for ArrayList Functions
      
       Instance Variables
     Data Type      Description
     int			size - Dictates how long the Arraylist is.
     int[]			list - Array of elements
     
       Constructior
     ArrayList()
     Defalts to size zero. Size changes when numbers are added on to it. Can olny use positive integers. Size can be chosen.
     
        Methods
     Data Type		Description
     void			add (int value) - adds an element to the end of the array.
     void			add (int index, int value) - adds an element to a specific spot to the array.
     int			indexOf (int value) - Shows the first index for an element. If the element is not present, returns -1.
     ICSlist 		subList(int fromIndex, int toIndex) - Creates a substring between two index points. Frist index number must be lesser than or equal to the second index.
     int			get (int index) - Returns the element located at the given index.
     void			clear () - Removes all elements from an array.
     boolean		contains (int value)- Returns ture or false depending on whether it's present or not.
     boolean 		isEmpty () - Returns ture if Array contains olny zeros
     int			delete (int index) - Removes an element from the table and decreases the size of array
     boolean		remove (int value) - Removes frist instant of a given element. Decreases the size of array and returns false if the value is not present.
     int			size () - Returns the size of the array.
     int[]			toArray () - Takes a Arraylist and coverts to a normal array.
     String			toString () - Converts Arraylist into a string
     int			set (int index, int value) - Replaces an element with another element.
     
