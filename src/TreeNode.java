/**
 * Represents a node in a binary tree. Each tree node contains a data portion - a name
 * and two references, one for each of the node's children.
 * @author Li Yixiao
 * @version 1.0
 */
public class TreeNode<T,E extends Comparable<E>> implements Comparable<TreeNode<T,E>>{
    /**
     * The key of the node
     */
    private E key;
    /**
     * The data portion of this node
     */
    private T element;
    /**
     * The reference to left child of this node
     */
    private TreeNode<T,E> left;

    /**
     */
    private TreeNode<T,E> right;

    /**
     * Constructs a default node.
     */
    public TreeNode() {
        this(null,null, null, null);
    }

    /**
     * Constructs a node with a specific element.
     * @param element A reference to the item of this node
     */
    public TreeNode(T element,E key) {
        this(element,key, null, null);
    }

    /**
     * Constructs a node with an element and two descendant nodes.
     * @param element A reference to the data of this node
     * @param left Reference to the left child of this node
     * @param right Reference to the right child of this node
     */
    public TreeNode(T element,E key, TreeNode<T,E> left, TreeNode<T,E> right) {
        this.key=key;
        this.element = element;
        this.left = left;
        this.right = right;
    }

    /**
     * Returns the element of this node.
     * @return A reference to the element of this node
     */
    public T getElement() {
        return this.element;
    }

    /**
     * Returns the key of the node
     * @return A reference to the key of this node
     */
    public E getKey(){
        return this.key;
    }

    /**
     * Changes the element of this node.
     * @param element The element of this node
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * Returns the left child of this node.
     * @return A reference to the left child of this node
     */
    public TreeNode<T,E> getLeft() {
        return this.left;
    }

    /**
     * Changes the left child of this node.
     * @param left A reference to the left child of this node
     */
    public void setLeft(TreeNode<T,E> left) {
        this.left = left;
    }

    /**
     * Returns the right child of this node.
     * @return A reference to the tight child of this node
     */
    public TreeNode<T,E> getRight() {
        return this.right;
    }

    /**
     * Changes the right child of this node.
     * @param right A reference to the right child of this node
     */
    public void setRight(TreeNode<T,E> right) {
        this.right = right;
    }

    /**
     * Compare two nodes
     * @param compare The node that need to be compare
     * @return 1 if greater,-1 if less,0 if same
     */
    public int compareTo(TreeNode<T,E> compare){
        return this.key.compareTo(compare.key);
    }

    /**
     * Print the information of the node
     * @return A string of the information of the node
     * @throws TreeException If the tree is empty
     */
    public String toString()throws TreeException{
        if(this.element==null)
            throw new TreeException("TreeException:  No element");
        else
            return this.element.toString();
    }

    /**
     * Place one node on the correct child of another node
     * @param newNode The node that need to be placed
     * @param compare The father node of the new node
     */
    public void decideDirectionAndChange(TreeNode<T,E> newNode,TreeNode<T,E> compare){
        if (this.compareTo(compare) > 0){
            this.setRight(newNode);
        }else if(this.compareTo(compare) < 0){
            this.setLeft(newNode);
        }
    }

    /**
     * Find a node among the tree's children that is the father node of
     * the closest to the root node of the tree and bigger than the root node
     * @return The node that is the father node of the closest to the root node of the tree
     */
    public TreeNode<T,E> closestRootToBigNode(){
        TreeNode<T,E> closestRootToBigNode=this.getLeft();
        if(closestRootToBigNode.getRight()!=null){
        while (closestRootToBigNode.getRight().getRight()!= null) {
            closestRootToBigNode = closestRootToBigNode.getRight();
            }
        }
        return closestRootToBigNode;
    }

    /**
     * Find a node among the tree's children that is the father node of
     * closest to the root node of the tree and smaller than the root node
     * @return The node that is the father node of the closest to the root node of the tree
     */
    public TreeNode<T,E> closestRootToSmallNode(){
        TreeNode<T,E> closestRootToSmallNode=this.getRight();
        if(closestRootToSmallNode.getLeft()!=null) {
            while (closestRootToSmallNode.getLeft().getLeft() != null) {
                closestRootToSmallNode = closestRootToSmallNode.getLeft();
            }
        }
        return closestRootToSmallNode;
    }
}
