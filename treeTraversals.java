package TREE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class treeTraversals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTree a= new BinaryTree();
		BinaryTree b= new BinaryTree();
		BinaryTree c= new BinaryTree();
		BinaryTree d= new BinaryTree();
		BinaryTree e= new BinaryTree();
		BinaryTree f= new BinaryTree();
		BinaryTree g= new BinaryTree();
		BinaryTree h= new BinaryTree();
		BinaryTree i= new BinaryTree();
		BinaryTree j= new BinaryTree();
		BinaryTree k= new BinaryTree();
		a.data=1;
		b.data=2;
		c.data=3;
		d.data=4;
		e.data=5;
		f.data=6;
		g.data=7;
		h.data=8;
		i.data=9;
		j.data=10;
		k.data=11;
		a.setLeft(b);
		a.setRight(c);
		b.setLeft(d);
		b.setRight(e);
		c.setLeft(f);
		c.setRight(g);
		g.setLeft(h);
		g.setRight(i);
		i.left=j;
		i.right=k;
    //level order traversal
	//postorder_traversal(a);
	//Queue<BinaryTree> q= new LinkedList<BinaryTree>();
	//q.offer(a);
	//levelorder_traversal(a,q);
	//while(!q.isEmpty()) 
	//System.out.println(q.remove().data);
	//find max element in tree 
	//ArrayList<Integer> l= new ArrayList<Integer>();
	//maxElement(a,l);
	//Collections.sort(l);
	//System.out.println(l.get((l.size()-1)));
		int maxleft=Integer.MIN_VALUE;
		int maxRight=Integer.MIN_VALUE;
		int max=Integer.MIN_VALUE;
	//System.out.println(maxElementRecursion(a,maxleft,maxRight,max));
	//System.out.println(findElement(a, 11));
	//	print_in_reverse(a);
		
		
		System.out.println(findMinDepth(a));
	}
	 
	public static int findMinDepth(BinaryTree root){
		if(root==null)
			return 0;
		if(root.left==null && root.right==null)
			return 1;
		int lefttlength=root.left!=null?findMinDepth(root.left):0;
		int rightlength=root.right!=null?findMinDepth(root.right):0;
		return 1+Math.min(lefttlength, rightlength);
		//for max->return{ 1+Math.max(lefttlength, rightlength); }
	}
	
	//printing level-order-in_reverse.
	public static void print_in_reverse(BinaryTree a){
		Queue<BinaryTree> q= new LinkedList<BinaryTree>();
		Stack<BinaryTree> s= new Stack<>();
		q.offer(a);
		while(!q.isEmpty()){
			BinaryTree b=q.poll();
			if(b.left!=null)
				q.offer(b.left);
			if(b.right!=null)
				q.offer(b.right);
			s.push(b);
		}
			while(!s.empty()){
				System.out.println(s.pop().data);
			}
	}


	private static boolean findElement(BinaryTree a, int data) {
		if(a!=null){
		if(data==a.data){
			return true;
		}
	
		 findElement(a.right, data);
		 findElement(a.left, data);
		}
		else{
		return false;
		}
		return false;
	}

	private static void maxElement(BinaryTree a, ArrayList<Integer> l) {
		if(a!=null){
		l.add(a.data);
		maxElement(a.left,l);
		maxElement(a.right,l);
		}
	}
	
	private static int maxElementRecursion(BinaryTree a, int maxleft, int maxRight, int max){
		if(a!=null){
			maxleft=maxElementRecursion(a.getLeft(), maxleft, maxRight,max);
			maxRight=maxElementRecursion(a.getRight(), maxleft, maxRight, max);
			System.out.println(maxleft);
			System.out.println(maxRight);
			if(maxleft>maxRight){
				max=maxleft;
			}
			else if(maxleft<maxRight){
				max=maxRight;
			}
			if(a.data>max){
				max=a.data;
			}
		}
		return max;
	}

	private static void levelorder_traversal(BinaryTree a, Queue<BinaryTree> q) {

		if(a!=null){
			if(a.left!=null)
			q.offer(a.left);
			if(a.right!=null)
			q.offer(a.right);
			levelorder_traversal(a.left,q);
			levelorder_traversal(a.right,q);
	}
		
	}

	private static void postorder_traversal(BinaryTree a) {
		// TODO Auto-generated method stub
			if(a!=null){		 
			postorder_traversal(a.left);
			postorder_traversal(a.right);
			System.out.println(a.data);
			}
		
	}

}
