package basecode;
import java.io.*;
import java.sql.Time;
import java.util.*;
import basecode.Owner;

class Genesis{
	protected Time timestamp;
	protected String data = "";
	protected static int nodeNumb=0;
	protected String nodeId = "";
	protected String childRefId = "";
	protected String refNodeId = null;
	protected String hashVal = "";
	protected String genRefId="";
	
	void setTime(String time) {
		this.timestamp = Time.valueOf(time);
	}
	void getTime(){
		System.out.println(this.timestamp);
	}
	
	void setData(float data) {
		
		String newVal = Owner.ownerId+Owner.ownerName;
		float floatVal = Float.hashCode(newVal.length());
		String newFloat = String.valueOf(floatVal);
		this.data = newVal.substring(0, newVal.length()-3).concat(newFloat);
	}
	void getData(){
		System.out.println(this.data);
	}
	void setId(String id){
		this.nodeId = id;
	}
	void getId(){
		System.out.println(this.nodeId);
	}
	
	void setHash() {
		String hashA = data.concat(nodeId);
		hashA = hashA.concat(refNodeId);
		hashA = hashA.concat(childRefId);
		hashA = hashA.concat(nodeId);
		hashA = hashA.concat(String.valueOf(nodeNumb));
		int x = Integer.getInteger(hashA);
		this.hashVal = String.valueOf(x);
	}
	
	void setGenesisRef() {
		genRefId = nodeId;
	}
}

class ChildNode extends Genesis{
	
	void setNodeNumb() {
		nodeNumb+=1;
	}
	 void setTime(String time) {
		this.timestamp = Time.valueOf(time);
	}
	void getTime(){
		System.out.println(this.timestamp);
	}
	
	void setData(float data) {
		
		String newVal = Owner.ownerId+Owner.ownerName;
		float floatVal = Float.hashCode(newVal.length());
		String newFloat = String.valueOf(floatVal);
		this.data = newVal.substring(0, newVal.length()-3).concat(newFloat);
	}
	void getData(){
		System.out.println(this.data);
	}
	
	void setId(String id){
		this.nodeId = id;
	}
	void getId(){
		System.out.println(this.nodeId);
	}
}


public class Main {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		TreeMap<Float,String> map = new TreeMap<>(); 
		while(true) {
			System.out.println("Enter owner's name:");
			String ownerName = s.nextLine();
			System.out.println("Enter owner id:");
			String ownerId = s.nextLine();
			Owner owner = new Owner(ownerId,ownerName);
			System.out.println("Enter owner data:");
			float data = s.nextFloat();
			
			if(map.containsKey(data)) {
				Genesis obj = new ChildNode();
				obj.getId();
			}
			else {
				map.put(data, ownerId);
			}
			System.out.println("More entries to give?: Y/N");
			String op = s.nextLine();
			if(op.equals("N") || op.equals("n")) {
				break;
			}
		}
	}
}
