public class BST<T>{

    Node root;

    class Node<T>{
        Comparable data;
        Node left;
        Node right;

        Node(Comparable item) {
            data = item;
        }
    }

    //FIND: Returns true if item is found in the BST; false otherwise.
    public boolean find(Comparable item) {
        return(find(item, root));
    }

    public boolean find(Comparable item, Node r_node) {
        if(r_node == null) {
            return false;
        } else if(r_node.data == item) {
            return true;
        } else if(r_node.data.compareTo(item) < 0) {
            return find(item, r_node.right);
        } else {
            return find(item, r_node.left);
        }
    }

    //INSERT: Inserts item into BST, keeping duplicates in their own nodes.
    public void insert(Comparable item) {
        root = insert(item, root);
    }

    public Node insert(Comparable item, Node r_node) {
        if(r_node == null) {
            return new Node(item);
        } else if(r_node.data.compareTo(item) < 0) {
            r_node.right = insert(item, r_node.right);
        } else if(r_node.data.compareTo(item) > 0) {
            r_node.left = insert(item, r_node.left);
        } else {
            return r_node;
        }
        return r_node;
    }

    //PRINT: Using println, output each item in the BST, ​in order​.
    public void print() {
        print(root);
    }

    public void print(Node r_node) {
        if(r_node != null) {
            print(r_node.left);
            System.out.println(r_node.data);
            print(r_node.right);
        }
    }

    //DELETE: Deletes first instance of item from the BST.
    public void delete(Comparable item) {
        root = delete(item, root);
    }

    public Node delete(Comparable item, Node r_node) {
        if(r_node == null) {
            return null;
        }

        if(r_node.data == item) {
            if(r_node.left == null) {
                return r_node.right;
            } else if(r_node.right == null) {
                return r_node.left;
            } else if(r_node.right.left == null) {
                r_node.data = r_node.right.data;
                r_node.right = r_node.right.right;
                return r_node;
            } else {
                r_node.data = removeMin(r_node.right);
                return r_node;
            }
        } else if(r_node.data.compareTo(item) > 0) {
            r_node.left = delete(item, r_node.left);
        } else {
            r_node.right = delete(item, r_node.right);
        }

        return r_node;
    }

    public Comparable removeMin(Node r_node) {
        Comparable min = r_node.data;
        while(r_node.left!= null) {
            min = r_node.left.data;
            r_node = r_node.left;
        }
        return min;
    }
}