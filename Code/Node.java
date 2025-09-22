package AirlinesJava;

import java.io.Serializable;

public class Node implements Serializable {

	private Flight data ; 
	private Node next ; 
	public Node(Flight obj)
	{
	data = obj ; 
	next = null ; 
	}
	public void setNext(Node nextPtr)
	{
	next = nextPtr ; 
	}
	public Node getNext()
	{
	return next ; 
	}
	public void setData(Flight obj)
	{
	data = obj ; 
	}
	public Flight getData()
	{
	return data ; 
	}
}
