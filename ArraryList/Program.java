import java.util.*;

public class Program
{
    public static int[] append(int[] list,int value)
    {
        int[] newList=new int[list.length+1];
        for(int i=0;i<list.length;i++) newList[i]=list[i];
        newList[newList.length-1]=value;
        return newList;
    }
    
    
    public static void main(String[] args)
    {
        setTest1();
        setTest2();
        //timeTestA();
        //timeTestD();
    }
    
    public static void timeTestA()
    {
        
        for(int i=0;i<29;i++)
        {
            int n = (int)Math.pow(2,i);
            double time = timeAdd(n);
            System.out.println(i+","+n+","+time);
        }   
    }
    
    public static void timeTestD()
    {
        
        for(int i=0;i<30;i++)
        {
            int n = (int)Math.pow(2,i);
            double time = timeDelete(n);
            System.out.println(i+","+n+","+time);
        }   
    }
    
    
    public static double timeAdd(int n)
    {
        ArrayList list = new ArrayList();
        long start = System.nanoTime();
        for(int i=0;i<n;i++)list.add(i);
        return (System.nanoTime()-start)/1e9;
    }    
    
    public static double timeDelete(int n)
    {
		ArrayList list = new ArrayList();
		for(int i = 0; i<n; i++)list.add(i);
		long start = System.nanoTime();
		for(int i=0;i<n;i++)list.remove(i);
		return (System.nanoTime()-start)/1e9;
	}
    
    public static void setTest1()
    {
        ArrayList list = new ArrayList();
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        
        list.add(2,2);
        list.add(3,2);
        if(list.size() == 6)System.out.println("SUCCESS: SET TEST 1 add part 2");
        else System.out.println("FAIL: SET TEST 1 add part 2");
        
        int v=list.set(1,14);
        int v2=list.get(1);
        if(v==6  && v2==14 )System.out.println("SUCCESS: SET TEST 1 set");
        else System.out.println("FAIL: SET TEST 1 set");
        
        if(list.indexOf(5) == 0)System.out.println("SUCCESS: SET TEST 1 index");
        else System.out.println("FAIL: SET TEST 1 index");
        
        list.clear();
        if(list.size == 0)System.out.println("SUCCESS: SET TEST 1 Clear");
        else System.out.println("FAIL: SET TEST 1 Clear");
        
        if(list.isEmpty() == true)System.out.println("SUCCESS: SET TEST 1 Empty");
        else System.out.println("FAIL: SET TEST 1 Empty");
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        
        if(list.contains(8) == true)System.out.println("SUCCESS: SET TEST 1 contains");
        else System.out.println("FAIL: SET TEST 1 contains");
        
        if(list.delete(3) == 8)System.out.println("SUCCESS: SET TEST 1 delete");
        else System.out.println("FAIL: SET TEST 1 delete");

		if(list.remove(5) == true)System.out.println("SUCCESS: SET TEST 1 remove");
        else System.out.println("FAIL: SET TEST 1 remove");

        if(list.size() == 2)System.out.println("SUCCESS: SET TEST 1 size");
        else System.out.println("FAIL: SET TEST 1 size");
        
        int[] test = new int[2];
        test[0] = 6;
        test[1] = 7;
        if(list.toArray()[0] == test[0] && list.toArray()[1] == test[1]){
			System.out.println("SUCCESS: SET TEST 1 toArray");
		}else{
			System.out.println("FAIL: SET TEST 1 toArray");
		}
		System.out.println("");
    }
    
    public static void setTest2()
    {
        ArrayList list=new ArrayList();
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        
        list.add(6,34);
        if(list.size() == 4)System.out.println("SUCCESS: SET TEST 2 add part 2");
        else System.out.println("FAIL: SET TEST 2 add part 2");
        
        try
        {
            list.set(4,234);
            System.out.println("FAIL: SET TEST 2 set");
            
        }
        catch(IndexOutOfBoundsException e)
        {
            System.out.println("SUCCESS: SET TEST 2 set");
        }
        catch(Exception e)
        {
            System.out.println("FAIL: SET TEST 2 set");
        }
        
        if(list.indexOf(10) == 0)System.out.println("FAIL: SET TEST 2 index");
        else System.out.println("SUCCESS: SET TEST 2 index");
        
        list.clear();
        list.clear();//This is part of the test
        if(list.size == 0)System.out.println("SUCCESS: SET TEST 2 clear");
        else System.out.println("FAIL: SET TEST 2 clear");
        
        list.add(5);
        if(list.isEmpty() == false)System.out.println("SUCCESS: SET TEST 2 empty");
        else System.out.println("FAIL: SET TEST 2 empty");
        list.add(6);
        list.add(7);
        list.add(8);
        
        if(list.contains(99) == false)System.out.println("SUCCESS: SET TEST 2 contatins");
        else System.out.println("FAIL: SET TEST 2 contains");
        
        try {
			list.delete(67);
			System.out.println("FAIL: SET TEST 2 delete");
		}catch(IndexOutOfBoundsException e){
			System.out.println("SUCCESS: SET TEST 2 delete");
		}

		if(list.remove(98) == false)System.out.println("SUCCESS: SET TEST 2 remove");
        else System.out.println("FAIL: SET TEST 2 remove");

        if(list.size() == 87)System.out.println("FAIL: SET TEST 2 Size");
        else System.out.println("SUCCESS: SET TEST 2 Size");
        
        int[] test = new int[2];
        test[0] = 6;
        test[1] = 8;
        if(list.toArray()[0] == test[0] && list.toArray()[1] == test[1]){System.out.println("FAIL: SET TEST 2 toArray");
		}else{ System.out.println("SUCCESS: SET TEST 2 toArray");}
    }
    
/*class Square
{
    //instance variables
    double length;
    
    //constructor
    public Square(double length)
    {
        this.length=length;
    }
    
    //methods/function
    public double area()
    {
        return length*length;
    }
    
    public void scale(double factor)
    {
        length*=factor;
    }
    
    public String toString()
    {
        return "I am a square with side length "+length+"!";
    }
    
    
    
    
}*/
}
