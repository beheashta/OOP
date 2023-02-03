package cp213;

/**
 * Implements an AVL (Adelson-Velsky Landis) tree. Extends BST.
 *
 * @author Beheashta Atchekzai
 * @version 2021-11-01
 */
public class AVL<T extends Comparable<T>> extends BST<T> {

    /**
     * Returns the balance item of node. If greater than 1, then left heavy, if
     * less than -1, then right heavy. If in the range -1 to 1 inclusive, the node
     * is balanced. Used to determine whether to rotate a node upon insertion.
     *
     * @param node The TreeNode to analyze for balance.
     * @return A balance number.
     */
    private int balance(final TreeNode<T> node) {

	// your code here
    	if(node == null) {
    		return 0;
    	}
    	
    	else {
    		return nodeHeight(node.getLeft())-nodeHeight(node.getRight());
    	}
    }

    /**
     * Performs a left rotation around node.
     *
     * @param node The subtree to rotate.
     * @return The new root of the subtree.
     */
    private TreeNode<T> rotateLeft(final TreeNode<T> node) {

	// your code here
    	
    	TreeNode<T> right = node.getRight();
        TreeNode<T> rightLeft = right.getLeft();
        
        right.setLeft(node);
        node.setRight(rightLeft);
            
        node.updateHeight();
        right.updateHeight();

        return right;
  

    	/*
    	final TreeNode <T> temp = node.getRight();
    	
    	node.setRight(temp.getLeft());
    	temp.setLeft(node);
    	node.updateHeight();
    	
    	return temp;
    	*/
 
    }

    /**
     * Performs a right rotation around {@code node}.
     *
     * @param node The subtree to rotate.
     * @return The new root of the subtree.
     */
    private TreeNode<T> rotateRight(final TreeNode<T> node) {

	// your code here
    	/*
    	final TreeNode <T> temp = node.getLeft();
    	node.setLeft(temp.getRight());
    	temp.setRight(node);
    	node.updateHeight();
    	return temp;
	*/
    	TreeNode<T> left = node.getLeft();
        TreeNode<T> leftRight = left.getRight();
        
        left.setRight(node);
        node.setLeft(leftRight);
            
        node.updateHeight();
        left.updateHeight();

        return left;
        
        }




    /**
     * Auxiliary method for {@code insert}. Inserts data into this AVL.
     *
     * @param node the current node (TreeNode)
     * @param data Data to be inserted into the node
     * @return The inserted node.
     */
    @Override
    protected TreeNode<T> insertAux(TreeNode<T> node, final CountedItem<T> data) {

	// your code here
    	int balance = 0;

		if (node == null) {
			// Base case - add a new node containing the data.
			node = new TreeNode <T>(data);	
			
			node.getItem().incrementCount();
			this.size++; //adds size to itself
			
			
		} else {
			// Compare the node data against the insert data.
			final int result = node.getItem().compareTo(data);

			if (result > 0) {
				// General case - check the left subtree.
				node.setLeft(this.insertAux(node.getLeft(), data));
				node.updateHeight();
				// As a left insertion, can only be unbalanced on the left.
				balance = this.balance(node);

				if (balance > 1 && this.balance(node.getLeft()) >= 0) {
					// Left Left Case - single rotation
					node = this.rotateRight(node);
				} else if (balance > 1 && this.balance(node.getLeft()) < 0) {
					// Left Right Case - double rotation
					node.setLeft(this.rotateLeft(node.getLeft()));
					node = this.rotateRight(node);
				}
			} else if (result < 0) {
				// General case - check the right subtree.
				node.setRight(this.insertAux(node.getRight(), data));
				node.updateHeight();
				// As a right insertion, can only be unbalanced on the right.
				balance = this.balance(node);

				if (balance < -1 && this.balance(node.getRight()) <= 0) {
					// Right Right Case - single rotation
					node = this.rotateLeft(node);
				} else if (balance < -1 && this.balance(node.getRight()) > 0) {
					// Right Left Case - double rotation
					node.setRight(this.rotateRight(node.getRight()));
					node = this.rotateLeft(node);
				}
			} else {
				// Base case - data is already in the tree, increment its count
				
				node.getItem().incrementCount(); // increments count of node
				
			}
		}
		return node;
    }

    /**
     * Auxiliary method for {@code valid}. Determines if a subtree based on node is
     * a valid subtree. An AVL must meet the BST validation conditions, and
     * additionally be balanced in all its subtrees - i.e. the difference in height
     * between any two children must be no greater than 1.
     *
     * @param node The root of the subtree to test for validity.
     * @return true if the subtree base on node is valid, false otherwise.
     */
    @Override
    protected boolean isValidAux(final TreeNode<T> node, TreeNode<T> minNode, TreeNode<T> maxNode) {

	// your code here
    	boolean valid = false;

		if (node == null) {
			// Base Case: bottom of tree
			valid = true;
		} else if (Math.max(this.nodeHeight(node.getLeft()), this.nodeHeight(node.getRight())) != node.getHeight()
				- 1) {
			// Base Case - height fault: current node height is not valid
			valid = false;
		} else if (node.getLeft() != null && node.getLeft().getItem().compareTo(node.getItem()) >= 0
				|| node.getRight() != null && node.getRight().getItem().compareTo(node.getItem()) <= 0) {
			// Base Case - data fault: current data not valid compared to
			// children's data
			valid = false;
		} else if (Math.abs(this.nodeHeight(node.getLeft()) - this.nodeHeight(node.getRight())) > 1) {
			// Base Case - AVL fault: child node heights are not correct
			valid = false;
		} else {
			valid = this.isValidAux(node.getLeft(), minNode, maxNode) && this.isValidAux(node.getRight(),minNode,maxNode);
		}
		return valid;
    }

    /**
     * Determines whether two AVLs are identical.
     *
     * @param target The AVL to compare this AVL against.
     * @return true if this AVL and target contain nodes that match in position,
     *         item, count, and height, false otherwise.
     */
    public boolean equals(final AVL<T> target) {
	return super.equals(target);
    }

}
