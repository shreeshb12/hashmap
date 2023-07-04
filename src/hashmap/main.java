package hashmap;

import java.util.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,Integer> map=new Map<>();
		Scanner s=new Scanner(System.in);
		while(1==1)
		{
			String key;
			int value;
			System.out.println("Enter 1 to insert");
			System.out.println("Enter 2 to getValue");
			System.out.println("Enter 3 to remove");
			System.out.println("Enter 4 to getSize");
			System.out.println("Enter any other key to exit");
			int ch=s.nextInt();
			switch(ch)
			{
			case 1:	System.out.println("Enter the Key");
					key=s.next();
					System.out.println("enter the Value");
					value=s.nextInt();
					map.insert(key,value);
					break;
			case 2: System.out.println("Enter the key");
					key=s.next();
						if(map.getValue(key) != null)
						{
							System.out.println("Key:"+key+"    Value:"+map.getValue(key));
						}
						else
						{
							System.out.println("Key not found");
						}
					break;
			case 3: System.out.println("Enter the key to be removed");
					key=s.next();
					if(map.remove(key) != null)
					{
						System.out.println(map.remove(key));
					}
					else
					{
						System.out.println("Key not found");
					}
					break;
			case 4: System.out.println(map.size());
					break;
			default: return; 
			}
		}
	}
}
