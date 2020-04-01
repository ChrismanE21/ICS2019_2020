public class ArrayList implements ICSList
{
    //instance variable
    int size;
    int[] list;
    
    //constructor
    public ArrayList()
    {
        size=0;
        list=new int[10];
    }
    
    public ArrayList(int capacity)
    {
        size=0;
        list=new int[capacity];
    }
    
    
    //methods/functions
    //add
    //delete
    //get  
    
    private void ensureCapacity()
    {
        if(size>=list.length)
        {
            int[] newList=new int[list.length*2];
            for(int i=0;i<size;i++) newList[i]=list[i];
            list=newList;
            
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void add(int value)//////////////////////
    {
        ensureCapacity();
        list[size] = value;
        size++;
    }
    
    public void add(int index, int value)////////////////////
    {
	if(index >= size + 2){
	}else{
		ensureCapacity();
		size++;
		for(int i = size; i >= index; i--){
			list[i] = list[i-1];
		}
		list[index] = value;
		if (index > size){
			size = index;
		}
	}
}

	public int indexOf(int value){/////////////////
		for(int i=0;i<size;i++){
			if(list[i] == value){
				return i;
			}
		}
		return -1;
	}
	
/*	public ICSList subList(int fromIndex, int toIndex){/////////////////
		if(fromIndex <= toIndex){
			ArrayList newList = new ArrayList();
			for(int i = fromIndex; i <= toIndex; i++){
				newList[i] = list[i];
			}
			return newList;
		}
		System.out.println("Error: first index number is greater than second index number");
		return list;
	}*/
	    
    public int get(int index)/////////////
    {
        if(index>=size)throw new ArrayIndexOutOfBoundsException();
        return list[index];
    }
    
     public void clear()/////////////
    {
        size=0;
        list[0] = 0;
    }
    
    public boolean contains(int value){///////////
		for(int i = 0; i <= size; i++){
			if(list[i] == value){
				return true;
			}
		}
		return false;
	}
	
	public boolean isEmpty()//////////////
	{
		for(int i = 0; i <= size; i++){
			if(list[i] != 0){
				return false;
			}
		}
		return true;
	}
    
    public int delete(int index){///////////////
		int value = list[index];
		
		for(int i = index; i <= size; i++){
			list[i] = list[i+1];
		}
		size--;
		ensureCapacity();
		return value;
	}
    
    public boolean remove(int value){////////////////
		for(int i = 0; i <= size; i++){
			if(list[i] == value){
				for(int t = i; t <= size; t++){
					list[t] = list[t+1];
					ensureCapacity();
				}
				size--;
				return true;
			}
		}
		return false;
	}
    
    public int size()///////////////
    {
        return size;
    }
    
    public int[] toArray(){//////////////////
		int[] newList = new int[size];
		for(int i = 0; i<size; i++){
			newList[i] = list[i];
		}
		return newList;
	}
    
    public String toString()
    {
        String s="";
        for(int i=0;i<size;i++)
        {
            s+=list[i];
            if(i<size-1)s+=", ";
        }
        return "["+s+"]";
    }
    
   
    
    /**
     * Changes value at specified index. 
     * 
     * @param index the index of the element to be changed
     * @param value the new element value
     * @return the old value that got replaced
     * @throws IndexOutOfBoundsException if index<0 || index>=size
     */
    public int set(int index, int value)
    {
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
        int prev=list[index];
        list[index]=value;
        return prev;
        
    }
    public ICSList subList(int fromIndex, int toIndex){throw new UnsupportedOperationException();}
    public boolean	equals(ICSList list){throw new UnsupportedOperationException();}
    
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
     */
}
