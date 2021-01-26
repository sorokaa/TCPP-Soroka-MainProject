class List<E> {

	private Node<E> head;
	private int length;

	public List() {}
	public List(E[] array) {
		for(E element : array) {
			add(element);
		}
	}

	public void add(E value) {
		if(head == null) {
        	    head = new Node<>(value, null);
	            length++;
         	    return;
   	 	 }

	        Node<E> node = head;
	        while (node.getNext() != null) {
        	    node = node.getNext();
        	}
        	node.setNext(new Node<>(value, null));
        	length++;
	}

	public void remove(E value) {
		if(head == null) {
			return;
		}
		Node<E> node = head;
		while(node.getNext() != null) {
			if(node.getNext().getValue() == value) {
				Node<E> toDelete = node.getNext();
				node.setNext(toDelete.getNext());
				length--;
			}
		}
	}

	public int size() {
		return length;
	}

	public void reverseList() {
		Node<E> current = head;
		Node<E> next = null;
		Node<E> prev = null;

		while(current != null) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}

		head = prev;

	}

	class Node<E> {
		private E value;
		private Node<E> next;

		public Node(E value, Node<E> next) {
			this.value = value;
			this.next = next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}

		public E getValue() {
			return value;
		}

		public Node<E> getNext() {
			return next;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<E> node = head;
		sb.append("[");
		while (node != null) {
			sb.append(node.getValue()).append(" ");
			node = node.getNext();
		}
		sb.append("]");
		return sb.toString();
	}
	@Override
	public int hashCode() {
		return 1;
	}
}



public class LinkedList {
	public static void main(String[] args) {
		List<String> list1 = new List<>(new String[]{"First", "Second", "Third"});
		List<String> list2 = new List<>();
		list2.add("First");
		list2.add("Second");
		list2.add("Third");

		System.out.println(list1);
		System.out.println(list2);

		list1.reverseList();
		System.out.println(list1);	

	}
}
