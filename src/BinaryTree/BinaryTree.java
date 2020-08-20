import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

  enum SearchType {
    IN_ORDER,
    PRE_ORDER,
    POST_ORDER
  }

  private BinaryTreeNode root;

  public BinaryTree() {
    root = null;
  }

  public void insert(int value) {
    if(root == null) {
      root = new BinaryTreeNode(value);
      return;
    }

    BinaryTreeNode currentNode = root;

    while (true) {
      if (currentNode.getValue() > value) {
        if(currentNode.getLeft() == null) {
          currentNode.setLeft(new BinaryTreeNode(value));
          return;
        }

        currentNode = currentNode.getLeft();

      } else {
        if(currentNode.getRight() == null) {
          currentNode.setRight(new BinaryTreeNode(value));
          return;
        }

        currentNode = currentNode.getRight();
      }
    }
  }

  public BinaryTreeNode lookup(int value) {
    if(root == null) {
      return null;
    }

    BinaryTreeNode currentNode = root;
    
    while (currentNode != null) {
      if(value < currentNode.getValue()) {
        currentNode = currentNode.getLeft();
      } else if(value > currentNode.getValue()) {
        currentNode = currentNode.getRight();
      } else {
        return currentNode;
      }
    }
    return null;
  }

   public void remove(int value) {
    if (root == null) {
      return;
    }

    BinaryTreeNode nodeToRemove = root;
    BinaryTreeNode parentNode = null;
    
    while (nodeToRemove.getValue() != value) { //Searching for the node to remove and it's parent
      parentNode = nodeToRemove;
      if (value < nodeToRemove.getValue()) {
        nodeToRemove = nodeToRemove.getLeft();
      } else if (value > nodeToRemove.getValue()) {
        nodeToRemove = nodeToRemove.getRight();
      }
    }

    BinaryTreeNode replacementNode = null;
    if (nodeToRemove.getRight() != null) { //right node
      replacementNode = nodeToRemove.getRight();
      if(replacementNode.getLeft() == null) { //no left node
        replacementNode.setLeft(nodeToRemove.getLeft());
      } else { //left node
        BinaryTreeNode replacementParentNode = nodeToRemove;
        while (replacementNode.getLeft() != null) {
          replacementParentNode = replacementNode;
          replacementNode = replacementNode.getLeft();
        }
        replacementParentNode.setLeft(null);
        replacementNode.setLeft(nodeToRemove.getLeft());
        replacementNode.setRight(nodeToRemove.getRight());
      }
    } else if(nodeToRemove.getLeft() != null) { //only left node
      replacementNode = nodeToRemove.getLeft();
    }

    if(parentNode == null) {
      root = replacementNode;
    } else if(parentNode.getLeft() == nodeToRemove) { //left child
      parentNode.setLeft(replacementNode);
    } else { //right child
      parentNode.setRight(replacementNode);
    }
  }

  public List<Integer> breathFirstSearchIteratively() {
    BinaryTreeNode currentNode = root;
    List<Integer> list = new ArrayList<>();
    Queue<BinaryTreeNode> queue = new LinkedList<>();
    queue.add(currentNode);

    while (!queue.isEmpty()) {
      currentNode = queue.poll();
      list.add(currentNode.getValue());
      if(currentNode.getLeft() != null) {
        queue.add(currentNode.getLeft());
      }

      if(currentNode.getRight() != null) {
        queue.add(currentNode.getRight());
      }
    }
    return list;
  }

  public List<Integer> breathFirstSearchRecursively() {
    Queue<BinaryTreeNode> queue = new LinkedList<>();
    queue.add(root);
    return breathFirstSearchRecursively(queue, new ArrayList<>());
  }

  public List<Integer> depthFirstSearchInOder(SearchType searchType) {
    return depthFirstSearchInOder(root, new ArrayList<>(), searchType);
  }

  private List<Integer> depthFirstSearchInOder(BinaryTreeNode node, ArrayList<Integer> list, SearchType searchType) {
    if(searchType == SearchType.PRE_ORDER)
      list.add(node.getValue());
    if(node.getLeft() != null) {
      depthFirstSearchInOder(node.getLeft(), list, searchType);
    }
    if(searchType == SearchType.IN_ORDER)
      list.add(node.getValue());
    if(node.getRight() != null) {
      depthFirstSearchInOder(node.getRight(), list, searchType);
    }
    if(searchType == SearchType.POST_ORDER)
      list.add(node.getValue());
      return list;
  }

  private List<Integer> breathFirstSearchRecursively(Queue<BinaryTreeNode> queue, List<Integer> list) {
    if (queue.isEmpty()) {
      return list;
    }
    BinaryTreeNode currentNode = queue.poll();
    list.add(currentNode.getValue());
    if (currentNode.getLeft() != null) {
      queue.add(currentNode.getLeft());
    }

    if (currentNode.getRight() != null) {
      queue.add(currentNode.getRight());
    }
    return breathFirstSearchRecursively(queue, list);
  }


  int count = 0;
  public void printTree() {
    count = 0;
    printTree(root);
  }

  private void printTree(BinaryTreeNode node) {
    System.out.print(node.getValue());
    System.out.println();
    count++;
    if(node.getLeft() != null) {
      System.out.print("\t".repeat(Math.max(0, count)) + "Left: ");
      printTree(node.getLeft());
    }
    if(node.getRight() != null) {
      System.out.print("\t".repeat(Math.max(0, count)) +"Right: ");
      printTree(node.getRight());
    }
    count--;
  }

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.insert(9);
    tree.insert(4);
    tree.insert(20);
    tree.insert(1);
    tree.insert(6);
    tree.insert(15);
    tree.insert(170);
    tree.printTree();
    tree.remove(20);
    tree.remove(4);
    tree.printTree();
    tree.insert(20);
    tree.insert(18);
    tree.insert(10);
    tree.printTree();
    tree.remove(170);
    tree.printTree();
    System.out.println("Breath first search " + tree.breathFirstSearchIteratively());
    System.out.println("Depth first search - in order " + tree.depthFirstSearchInOder(SearchType.IN_ORDER));
    System.out.println("Depth first search - pre order " + tree.depthFirstSearchInOder(SearchType.PRE_ORDER));
    System.out.println("Depth first search - post order " + tree.depthFirstSearchInOder(SearchType.POST_ORDER));
  }
}