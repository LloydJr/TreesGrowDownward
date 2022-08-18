import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by kristofer on 7/13/20.
 */
public class TreeOneZero {
    Node root;

    private Node addRecursive(Node current, Integer value) {
        return null;
    }

    private Node add(Node current, Integer value) {
        if (current == null)
            return new Node(value);

        if (value < current.value)
            current.left = addRecursive(current.left, value);
        else if (value > current.value)
            current.right = addRecursive(current.right, value);
        else
            return current;

        return current;
    }

    public void add(Integer value) {
        root = addRecursive(root, value);
    }

    public TreeOneZero createTreeOneZero() {
        TreeOneZero bt = new TreeOneZero();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        return bt;
    }

    public Boolean containsNodeRecursive(Node current, Integer value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public Boolean containsNode(Integer value) {
        return containsNodeRecursive(root, value);
    }

    private Node deleteRecursive(Node current, Integer value) {
        if (current == null)
            return null;
        else if (current.right == null)
            return null;
//        else if (current.left == null && current.right == null)
//            return null;
        else
            return current;
    }

    private Integer findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
//        int smallestValue = findSmallestValue(current.right);
//        current.value = smallestValue;
//        current.right = deleteRecursive(current.right, smallestValue);
//        return current;
    }

    public void delete(Integer value) {
        root = deleteRecursive(root, value);
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.println(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    public void traverseInPreOrder(Node node) {
        if (node != null) {
            System.out.println(" " + node.value);
            traverseInPreOrder(node.left);
            traverseInPreOrder(node.right);
        }
    }

    public void traverseInPostOrder(Node node) {
        if (node != null) {
            traverseInPostOrder(node.left);
            traverseInPostOrder(node.right);
            System.out.println(" " + node.value);
        }
    }

    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {

            Node node = nodes.remove();

            System.out.print(" " + node.value);

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }
//    @Test
//    public void givenABinaryTree_WhenDeletingElements_ThenTreeDoesNotContainThoseElements() {
//        TreeOneZero bt = createTreeOneZero();
//
//        assertTrue(bt.containsNode(9));
//        bt.delete(9);
//        assertFalse(bt.containsNode(9));
//    }
//    @Test
//    public void givenABinaryTree_WhenAddingElements_ThenTreeContainsThoseElements() {
//        TreeOneZero bt = createTreeOneZero();
//
//        assertTrue(bt.containsNode(6));
//        assertTrue(bt.containsNode(4));
//
//        assertFalse(bt.containsNode(1));
//    }
}
