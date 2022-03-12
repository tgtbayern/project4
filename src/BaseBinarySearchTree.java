/**
 * @author Li Yixiao
 * @version 1.0
 */
public abstract class BaseBinarySearchTree<T,E extends Comparable<E>> {
    /**
     * The root of this tree
     */
    protected TreeNode<T,E> root;

    /**
     * Creates an empty binary tree.
     */
    public BaseBinarySearchTree() {
        this(null);
        //this.root = null;
    }

    /**
     * Creates a one-node binary tree whose root contains a root item.
     * @param root The item of the root
     */
    public BaseBinarySearchTree(TreeNode<T,E> root) {
        this.root = root;
    }


    /**
     * Returns true if the tree is empty, else returns false.
     * @return A value specifying if the tree is empty
     */
    public boolean isEmpty() {
        return this.root == null;
    }

    /**
     * Removes all nodes from the tree.
     */
    public void makeEmpty() {
        this.root = null;
    }

    /**
     * Returns the element in the tree's root.
     * @return A reference to the item of the root
     * @throws TreeException if the tree is empty
     */
    public T getRoot() throws TreeException {
        if (this.root == null) {
            throw new TreeException("TreeException: Empty tree");
        }else {
            return this.root.getElement();
        }
    }

    /**
     * Change the root of the tree
     * @param preNodeOfOldRoot Previous node of the old node
     * @param oldRoot Old root of the tree
     */
    public void changeRoot(TreeNode<T,E> preNodeOfOldRoot,TreeNode<T,E> oldRoot){
        if (oldRoot.getLeft() == null && oldRoot.getRight() == null) {
            preNodeOfOldRoot.decideDirectionAndChange(null,oldRoot);
        }else if(oldRoot.getLeft() == null && oldRoot.getRight() != null||oldRoot.getRight() == null && oldRoot.getLeft() != null){
            TreeNode<T,E> newRoot=oldRoot.getLeft() != null ? oldRoot.getLeft() : oldRoot.getRight();
            preNodeOfOldRoot.decideDirectionAndChange(newRoot,oldRoot);
            oldRoot.decideDirectionAndChange(null,newRoot);
        }else{
            TreeNode<T,E> newRoot;
            if(oldRoot.getRight()!=null){
                newRoot=oldRoot.closestRootToSmallNode().getLeft();
                oldRoot.closestRootToSmallNode().setLeft(null);
            }
            else {
                newRoot=oldRoot.closestRootToBigNode().getRight();
                oldRoot.closestRootToBigNode().setRight(null);
            }
            newRoot.setLeft(oldRoot.getLeft());
            newRoot.setRight(oldRoot.getRight());
            oldRoot.setRight(null);
            oldRoot.setLeft(null);
            preNodeOfOldRoot.decideDirectionAndChange(newRoot,oldRoot);
        }
    }
}
