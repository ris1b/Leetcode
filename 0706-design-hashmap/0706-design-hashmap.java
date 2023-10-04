class MyHashMap {

    ArrayList<Node> bucket;		        // this is my bucket
	int count;							// count of elements in bucket
	int numBuckets;

    public MyHashMap() {
        bucket = new ArrayList<>();		// initialize bucket of 20 size
		numBuckets = 20;
		count = 0;
		for (int i = 0; i < numBuckets; i++) {
			bucket.add(null);			// add null
		}
    }
    
    public void put(int key, int value) {
        int bucketIndex = getBucketIndex(key);		// get the bucket index
		Node head = bucket.get(bucketIndex);	    // go to the head
		while (head != null) {
			if (head.key == (key)) {
				// if element is already present, then update it's value
				head.value = value;
				return;
			}
			head = head.next;
		}
		// here, the element is not present
		head = bucket.get(getBucketIndex(key));
		Node newNode = new Node(key, value);
		newNode.next = head;
		bucket.set(bucketIndex, newNode);
		count++;									// created a new node and inserted
		
        // rehash if load factor exceeds
		double loadFactor = (1.0 * count) / numBuckets;
		if (loadFactor > 0.7) {
			rehash();
		}
		return;
    }
    
    public int get(int key) {
        int bucketIndex = getBucketIndex(key);
		Node head = bucket.get(bucketIndex);

		while (head != null) {
			if (head.key == (key)) {
				return head.value;
			}

			head = head.next;
		}
		return -1;
    }
    
    public void remove(int key) {
        Node head = bucket.get(getBucketIndex(key));
		Node prev = null;
		while (head != null) {
			if  (head.key == (key)) {
				if (prev != null) {
					prev.next = head.next;
				} else {
					bucket.set(getBucketIndex(key), head.next);
				}
				count--;
				// return head.value;
                return;
			}
			prev = head;
			head = head.next;
		}
		return;

    }

    private void rehash() {
		ArrayList<Node> temp = bucket;		// make a temp list

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
				int value = head.value;
				put(key, value);
				head = head.next;
			}
		}
	}

    private int getBucketIndex(int key) {
		/* give me a valid index */
		int hc = getHashCode(key);

		int index = hc % numBuckets;
		return index;
	}

    public double loadFactor() {
		return (1.0 * count) / numBuckets;
	}

	public int size() {
		return count;
	}

    private int getHashCode(int key) {
        return key ^ (key >>> 16);
    }
}

class Node {
	int key;
	int value;
	Node next;

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */