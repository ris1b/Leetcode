class Node {
	Integer key;
	Node next;

	public Node(Integer key) {
		this.key = key;
	}
}

class MyHashSet {
	ArrayList<Node> bucket;
	int count;
	int numBuckets;

	public MyHashSet() {
		bucket = new ArrayList<>();
		numBuckets = 20;
		count = 0;
		for (int i = 0; i < numBuckets; i++) {
			bucket.add(null);
		}
	}

	public void add(int key) {
		if (this.contains(key))
			return;

		int bucketIndex = getBucketIndex(key);

		Node head = bucket.get(bucketIndex);

		head = bucket.get(getBucketIndex(key));
		Node newNode = new Node(key);
		newNode.next = head;

		bucket.set(bucketIndex, newNode);
		count++;

		double loadFactor = (1.0 * count) / numBuckets;

		if (loadFactor > 0.7) {
			rehash();
		}

	}

	private int getBucketIndex(int key) {
		/* give me a valid index */
		Integer hc = Integer.valueOf(key); // Convert int to Integer
		int index = hc.hashCode() % numBuckets;

		return index;
	}

	private void rehash() {
		ArrayList<Node> temp = bucket; // make a temp list

		bucket = new ArrayList<>();
		for (int i = 0; i < 2 * numBuckets; i++) {
			bucket.add(null);
		}
		count = 0;
		numBuckets *= 2;
		for (int i = 0; i < temp.size(); i++) {
			Node head = temp.get(i);
			while (head != null) {
				int key = head.key;
				// V value = head.value;
				add(key);
				head = head.next;
			}
		}
	}

	public void remove(int key) {
		Node head = bucket.get(getBucketIndex(key));
		Node prev = null;

		while (head != null) {
			if (head.key.equals(key)) {
				if (prev != null) {
					prev.next = head.next;
				} else {
					bucket.set(getBucketIndex(key), head.next);
				}
				count--;
				return;
			}
			prev = head;
			head = head.next;
		}

	}

	public double loadFactor() {
		return (1.0 * count) / numBuckets;

	}

	public boolean contains(int key) {
		int bucketIndex = getBucketIndex(key);
		Node head = bucket.get(bucketIndex);
		while (head != null) {
			if (head.key.equals(key)) {
				return true;
			}
			head = head.next;
		}
		return false;
	}
}

/**
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj
 * = new MyHashSet(); obj.add(key); obj.remove(key); boolean param_3 =
 * obj.contains(key);
 */