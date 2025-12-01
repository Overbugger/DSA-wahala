package com.endpoint.DS.Trees;

public class BST<T extends Comparable<T>> {
    private TreeNode<T> root;

    public BST() {
        this.root = null;
    }

    private void insert(T value) {
        if (root == null) {
            root = new TreeNode<>(value);
            return;
        }

        TreeNode<T> node = root;

        while (true) {
            int comparison = value.compareTo(node.getValue());
            if (comparison <= 0) {
                if (node.getLeft() == null) {
                    node.setLeft(new TreeNode<>(value));
                    break;
                } else {
                    node = node.getLeft();
                }
            } else {
                if (node.getRight() == null) {
                    node.setRight(new TreeNode<>(value));
                    break;
                } else {
                    node = node.getRight();
                }
            }
        }

    }

    private void delete(T value) {
        if (root == null) {
            throw new IllegalStateException("Can't delete on an empty tree");
        }

        SearchResult<T> searchResult = search(value);
        var node = searchResult.node;
        var parent = searchResult.parent;

        if (node == null) {
            throw new IllegalStateException("Value not found");
        }

        // Case 1 & 2: Node has 0 or 1 child
        if (node.getLeft() == null || node.getRight() == null) {
            TreeNode<T> maybeChild = (node.getLeft() == null) ? node.getRight() : node.getLeft();

            if (parent == null) {
                // Node to delete is root
                root = maybeChild;
            } else if (value.compareTo(parent.getValue()) <= 0) {
                parent.setLeft(maybeChild);
            } else {
                parent.setRight(maybeChild);
            }
        }else {
            // Case 3: Node has two children
            SearchResult<T> maxResult = findMax(node.getLeft());
            TreeNode<T> maxNode = maxResult.node();
            TreeNode<T> maxParent = maxResult.parent();

            TreeNode<T> newNode;

            if (maxParent == null) {
                // The left child itself is the max node
                newNode = new TreeNode<>(maxNode.getValue(), null, node.getRight());
            } else {
                newNode = new TreeNode<>(maxNode.getValue(), node.getLeft(), node.getRight());
                maxParent.setRight(maxNode.getLeft());
            }

            if (parent == null) {
                root = newNode;
            } else if (value.compareTo(parent.getValue()) <= 0) {
                parent.setLeft(newNode);
            } else {
                parent.setRight(newNode);
            }

        }
    }

    private SearchResult<T> search(T value) {
        TreeNode<T> parent = null;
        TreeNode<T> node = root;

        while (node != null) {
            T nodeValue = node.getValue();

            int comparison = value.compareTo(nodeValue);
            if (comparison == 0) {
                return new SearchResult<>(node, parent);
            } else if (comparison < 0) {
                parent = node;
                node = node.getLeft();
            } else {
                parent = node;
                node = node.getRight();
            }
        }
        return new SearchResult<>(null, null);
    }

    private SearchResult<T> findMax(TreeNode<T> node) {
        TreeNode<T> parent = null;

        while (node.getRight() != null) {
            parent = node;
            node = node.getRight();
        }

        return new SearchResult<>(node, parent);
    }

    private SearchResult<T> findMin() {
        if (root == null) {
            return new SearchResult<>(null, null);
        }

        TreeNode<T> parent = null;
        TreeNode<T> node = root;

        while (node.getLeft() != null) {
            parent = node;
            node = node.getLeft();
        }

        return new SearchResult<>(node, parent);
    }

    public record SearchResult<T>(TreeNode<T> node, TreeNode<T> parent) {
    }
}
