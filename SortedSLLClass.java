// implementing SortedSLLClass
public class SortedSLLClass {
	// fill in different fields
	//SortedSLLClass otherSSLL;
	class Node{
		int value;
		Node next;
	}
	Node currentSSLL=null;
	
	// constructor
	public SortedSLLClass(){
		// fill in
		//otherSSLL=new SortedSLLClass();
		currentSSLL=new Node();
	}

	// copy constructor: copy the content of otherSSLL into this one
	// you need this constructor
	public SortedSLLClass(SortedSLLClass otherSSLL){
		// fill in
		this.currentSSLL=otherSSLL.currentSSLL;
	}
	
	// insert an integer value into the list
	public boolean insert(int val){
		Node temp=new Node();
		temp.value=val;
		temp.next=null;
		
				if(currentSSLL==null){
					currentSSLL=temp;
				}else{
							Node currentNode=currentSSLL;
							Node prevNode=null;
							Node pos=null;
							while(currentNode!=null){
									if(temp.value==currentNode.value)
											return false;
									else if(temp.value<currentNode.value){
													pos=currentNode;
									}
									prevNode=currentNode;
									currentNode=currentNode.next;
							}
							if(prevNode==pos){
								 temp.next=currentSSLL;
								 currentSSLL=temp;
							}else if(pos==null){
								prevNode.next=temp;
							}else{
								prevNode.next=temp;
								temp.next=pos;
							}
								
								
				}
		return true;
	}

	// merge otherSSLL into the current list (naive)
	// read and insert elements from otherSSLL one-by-one into this list
	public void merge_naive(SortedSLLClass otherSSLL){
		// fill in
		Node otherListNode=otherSSLL.currentSSLL;
		while(otherListNode!=null){
			insert(otherListNode.value);
		}
					
	}

	// merge other SSLL into the current list (smart)
	// use two synchronized pointers to merge
	// it is easier if you start a new list of nodes
	// after merging, you can use this list of nodes 
	// to replace the content of the current one
	public void merge_smart(SortedSLLClass otherSSLL){
		Node pointer1=currentSSLL;
		Node pointer2=otherSSLL.currentSSLL;
		Node pointer3=null;
		while(pointer1!=null && pointer2!=null){
				if(pointer1.value<pointer2.value){
							if(pointer3==null){
									Node temp=pointer1;
										temp.next=null;
										pointer3=temp;
							}
									
							else{
									Node temp=pointer3;
											while(temp.next!=null){
														temp=temp.next;	
											}
											temp.next=pointer1;
											temp.next.next=null;
								
							}
							pointer1=pointer1.next;
				}else {
						if(pointer3==null){
								Node temp=pointer2;
									temp.next=null;
									pointer3=temp;
						}
								
						else{
								Node temp=pointer3;
										while(temp.next!=null){
													temp=temp.next;	
										}
										temp.next=pointer2;
										temp.next.next=null;
							
						}
						pointer2=pointer2.next;
			
				}
			
		}
		if(pointer1!=null){
			Node temp=pointer3;
			while(temp.next!=null){
						temp=temp.next;	
			}
			temp.next=pointer1;
		}
		
		if(pointer2!=null){
			Node temp=pointer3;
			while(temp.next!=null){
						temp=temp.next;	
			}
			temp.next=pointer2;
		}
		currentSSLL=pointer3;
				
	}
	
	// get all elements of the list, store them in an array
	public int[] getAllElements(){
		// dummy code, replace it for your own program
		Node temp=currentSSLL;
		int k=0;
		while(temp!=null){
			          k++;
					temp=temp.next;	
					
		}
		temp=currentSSLL;
		int[] a = new int[k];
		int i=0;
		while(temp!=null){
				a[i++]=temp.value;
			temp=temp.next;		
      }
		return a;
	}
}
