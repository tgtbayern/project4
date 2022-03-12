/**
 * @author Li Yixaio
 * @version 1.0
 */
public class BinarySearchTree<T ,E extends Comparable<E>> extends BaseBinarySearchTree<T,E> {

    /**
     * Creates an empty  binary tree.
     */
    public BinarySearchTree() {
        super();
    }

    /**
     * Creates a one node binary tree.
     * @param root The root of this tree
     */
    public BinarySearchTree(TreeNode<T,E> root) {
        super(root);
    }

    /**
     * Creates a binary tree whose root contains rootItem and has left tree and right tree, respectively,
     * as its left and right subtrees.
     * @param root A reference to the root
     * @param leftTree A reference to the left subtree
     * @param rightTree A reference to the right subtree
     */
    public BinarySearchTree(TreeNode<T,E> root, BinarySearchTree<T,E> leftTree, BinarySearchTree<T,E> rightTree) {
        super(root);
        this.attachLeftSubtree(leftTree);
        this.attachRightSubtree(rightTree);
    }

    /**
     * Creates a binary tree with root.
     * @param rootNode A reference to a node

    protected BinarySearchTree(TreeNode<T> rootNode) {
    // subtree only
    this.root = rootNode;
    }*/

    /**
     * Replaces the data item in the root of a binary tree with new item, if the tree is not empty. If the
     * tree is empty, creates a root node whose data item is newItem and inserts the new node into the tree.
     * @param root A reference to a new root item
     */
    public void setRoot(TreeNode<T,E> root) {
        this.root=root;
    }

    /**
     * Attaches a left child containing a new item to the root of a binary tree. Throws TreeException if the binary
     * tree is empty (no root node to attach to) or a left subtree already exists (should explicitly detach it first).
     * @param root The item of a left child
     * @throws TreeException if this tree is empty or it has a left child
     */
    public void attachLeft(TreeNode<T,E> root) throws TreeException{
        if(!isEmpty() && this.root.getLeft() == null){
            this.root.setLeft(root);
        }else if(isEmpty()){
            throw new TreeException("The tree is empty, and can not be attached.");
        }else if(this.root.getLeft() != null){
            throw new TreeException("A left child is existed.");
        }
    }

    /**
     * Attaches a right child containing new item to the root of a binary tree. Throws TreeException if the binary
     * tree is empty (no root node to attach to) or a left subtree already exists (should explicitly detach it first).
     * @param root The item of the right child
     * @throws TreeException if this tree is empty or it has a right child
     */
    public void attachRight(TreeNode<T,E> root) throws TreeException{
        if(!isEmpty() && this.root.getRight() == null){
            this.root.setRight(root);
        }else if(isEmpty()){
            throw new TreeException("The tree is empty, and can not be attached.");
        }else if(this.root.getRight() != null){
            throw new TreeException("A right child is existed.");
        }
    }

    /**
     * Attaches left Tree as the left subtree of the root of a binary tree and makes left Tree empty
     * so that it cannot be used as a reference into this tree. Throws TreeException if the binary tree is empty
     * (no root node to attach to) or a left subtree already exists (should explicitly detach it first).
     * @param leftTree A reference to a left tree to be attached
     * @throws TreeException if this tree is empty or it has a left tree
     */
    public void attachLeftSubtree(BinarySearchTree<T,E> leftTree) throws TreeException {
        if (isEmpty()) {
            throw new TreeException("TreeException:  Empty tree");
        }else if (this.root.getLeft() != null) {
            // a left subtree already exists; it should have been deleted first
            throw new TreeException("TreeException: " +  "Cannot overwrite left subtree");
        }else {
            //attach the subtree
            this.root.setLeft(leftTree.root);
            //remove the external reference to the subtree
            leftTree.makeEmpty();
        }
    }

    /**
     * Attaches right Tree as the right subtree of the root of a binary tree and makes rightTree empty
     * so that it cannot be used as a reference into this tree. Throws TreeException if the binary tree is empty
     * (no root node to attach to) or a right subtree already exists (should explicitly detach it first).
     * @param rightTree A reference to a right tree to be attached
     * @throws TreeException if this tree is empty or it has a right tree
     */
    public void attachRightSubtree(BinarySearchTree<T,E> rightTree) throws TreeException {
        if (isEmpty()) {
            throw new TreeException("TreeException:  Empty tree");
        }else if (this.root.getRight() != null) {
            // a right subtree already exists; it should have been deleted first
            throw new TreeException("TreeException: " +  "Cannot overwrite right subtree");
        }else {
            this.root.setRight(rightTree.root);
            rightTree.makeEmpty();
        }
    }


    /**
     * Detaches and returns the left subtree of a binary tree's root. Throws TreeException if this tree is empty
     * (no root node to detach from).
     * @return A reference to the left tree of this tree
     * @throws TreeException if this tree is empty
     */
    public BinarySearchTree<T,E> detachLeftSubtree() throws TreeException {
        if (isEmpty()) {
            throw new TreeException("TreeException:  Empty tree");
        }else if(this.root.getLeft() == null){
            throw new TreeException("TreeException:  No left subtree");
        }else {
            // create a new binary tree that has root's left node as its root
            BinarySearchTree<T,E> leftTree = new BinarySearchTree<>(this.root.getLeft());
            this.root.setLeft(null);
            return leftTree;
        }
    }

    /**
     * Detaches and returns the right subtree of a binary tree's root. Throws TreeException if the binary tree is empty
     * (no root node to detach from).
     * @return A reference to the right tree of this tree
     * @throws TreeException if the tree is empty
     */
    public BinarySearchTree<T,E> detachRightSubtree() throws TreeException {
        if (isEmpty()) {
            throw new TreeException("TreeException:  Empty tree");
        }else if(this.root.getRight() == null){
            throw new TreeException("TreeException:  No right subtree");
        }else {
            BinarySearchTree<T,E> rightTree = new BinarySearchTree<>(this.root.getRight());
            this.root.setRight(null);
            return rightTree;
        }
    }

    /**
     * Insert a node to the tree
     * @param node The node that needed to be inserted
     * @throws TreeException If the tree has already had a node which has the same key
     */
    public void insert(TreeNode<T,E> node)throws TreeException{
        TreeNode<T,E> temp1=this.root;
        TreeNode<T,E> temp2=temp1;
        while(temp1!=null) {
            if (temp1.compareTo(node) < 0) {
                temp2 = temp1;
                temp1 = temp1.getLeft();
            } else if(temp1.compareTo(node) > 0) {
                temp2 = temp1;
                temp1 = temp1.getRight();
            }
            else
                throw new TreeException("TreeException:  Insert same node");
        }
        if(this.root==null)
            this.root=node;
        else
            temp2.decideDirectionAndChange(node,node);
    }

    /**
     * Search a node in the tree
     * @param searching the key of the node that needed to be searched
     * @return The node that need to be searched
     */
    public TreeNode<T,E> search (E searching){
        TreeNode<T,E> search=this.root;
        while(search!=null&&search.getKey().compareTo(searching)!=0){
            if (search.getKey().compareTo(searching) > 0) {
                search = search.getRight();
            } else
                search =search.getLeft();
        }
        if(search!=null&&search.getKey().compareTo(searching) == 0)
            return search;
        else {
            System.out.println("No such node");
            return new TreeNode<>();
        }
    }

    /**
     * Delete the node in the tree
     * @param deleting The node that needed to be deleted
     * @throws TreeException If the node isn't in the tree
     */
    public void delete (E deleting)throws TreeException{
        TreeNode<T,E> preNode=this.root;
        TreeNode<T,E> delete=this.root;
        while(delete!=null&&delete.getKey().compareTo(deleting) != 0) {
            if (delete.getKey().compareTo(deleting) > 0) {
                preNode=delete;
                delete = delete.getRight();
            } else{
                preNode=delete;
                delete = delete.getLeft();
            }
        }
        if(delete!=null)
            this.changeRoot(preNode,delete);
        else
            throw new TreeException("TreeException:  No such node");
    }
}