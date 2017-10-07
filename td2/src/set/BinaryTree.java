package set;

public class BinaryTree {
	
	private Object data;
	private BinaryTree leftChild;
	private BinaryTree rightChild;
	private int height;
	private int numberNodes;
	
	BinaryTree(Object data, BinaryTree leftChild, BinaryTree rightChild){
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	BinaryTree(Object data){
		this.data = data;
	}
	
	public String toString() {
		if(this != null) {
			if(this.leftChild != null) {
				if(this.rightChild != null)
					return (this.leftChild + "\t<<\t" + this + "\t>>\t" + this.rightChild + "\n");
				return (this.leftChild + "\t<<\t" + this + "\t>>\n");
			}
			if(this.rightChild != null)
				return ("\t<<\t" + this + "\t>>\t" + this.rightChild + "\n");
			return ("\t<<\t" + this + "\t>>\t");
		}
		return null;
	}
	
	Object getData() {
		return this.data;
	}
	
	void setData(Object data) {
		this.data = data;
	}
	
	BinaryTree getLeftChild() {
		return this.leftChild;
	}
	
	BinaryTree getRightChild() {
		return this.rightChild;
	}
	
	void setLeftChild(BinaryTree leftChild) {
		this.leftChild = leftChild;
	}
	
	void setRightChild(BinaryTree rightChild) {
		this.rightChild = rightChild;
	}
	
	public boolean isLeaf() {
		return (Boolean) null;
	}
	
	int getHeight() {
		return this.height;
	}
	
	int getNumberNodes() {
		return this.numberNodes;
	}

}
