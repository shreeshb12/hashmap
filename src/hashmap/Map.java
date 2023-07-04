package hashmap;

import java.util.*;
public class Map<K,V> {
	private ArrayList<MapNode<K,V>> buckets;
	private int count;
	private int bucketSize;
	public Map()
	{
		buckets =new ArrayList<>();
		bucketSize=5;
		for(int i=0;i<bucketSize;i++)
		{
			buckets.add(null);
		}
	}
//	get the no. of keys
	public int size()
	{
		return count;
	}
//Rehashing if the loadFactor is greater than or equal to 0.7
	private void rehash()
	{
		ArrayList<MapNode<K,V>> temp=buckets;
		bucketSize=2*bucketSize;
		for(int i=temp.size();i<bucketSize;i++)
		{
			buckets.add(null);
		}
		count=0;
		for(int i=0;i<temp.size();i++)
		{
			MapNode<K,V> head=temp.get(i);
			while(head!=null)
			{
				insert(head.key,head.value);
				head=head.next;
			}
		}
	}
	
	public double loadFactor()
	{
		return (1.0*count/bucketSize);
	}
	
//get the bucket index from key
	private int getIndex(K Key)
	{
		int hashcode=Key.hashCode();
		int index=Math.abs(hashcode % bucketSize);
		return index;
	}
	
//	insert a key and value
	public void insert(K Key,V Value)
	{
		int index=getIndex(Key);
		MapNode<K,V> head=buckets.get(index);
		while(head!=null)
		{
			if(head.key==Key)
			{
				head.value=Value;
				return;
			}
			head=head.next;
		}
		MapNode<K,V> newNode=new MapNode<K,V>(Key,Value);
		head=buckets.get(index);
		newNode.next=head;
		head=newNode;
		buckets.set(index, head);
		count++;
		if(loadFactor()>=0.7)
		{
			rehash();
		}
	}
	
//	get the value of the key
	public V getValue(K Key)
	{
		int index=getIndex(Key);
		MapNode<K,V> head=buckets.get(index);
		while(head!=null)
		{
			if((head.key).equals(Key))
			{
				return head.value;
			}
			head=head.next;
		}
		return null;
	}
	
//	remove the key
	public V remove(K Key) {
		int index=getIndex(Key);
		MapNode<K,V> head=buckets.get(index);
		MapNode<K,V> prev=null;
		while(head!=null)
		{
			if((head.key).equals(Key))
			{
				if(prev==null)
				{
					buckets.set(index,head.next);
				}
				else
				{
					prev.next=head.next;
				}
				count--;
				System.out.println("item deleted");
				return head.value ;
			}
			prev=head;
			head=head.next;
		}
		return null;
	}
}
