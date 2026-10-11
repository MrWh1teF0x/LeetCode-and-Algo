#include <iostream>

#include "AVLTree.hpp"
#include "Node.hpp"

int main() {
    AVLTree<int> avl_tree;

    avl_tree.Add(1);
    avl_tree.Add(2);
    avl_tree.Add(3);
    avl_tree.Add(4);
    avl_tree.Add(5);
    avl_tree.Add(6);
    avl_tree.Add(7);
    avl_tree.Add(8);

    avl_tree.Delete(4);

    avl_tree.PrintTree();

    std::cout << avl_tree.Contains(4);
    std::cout << avl_tree.Contains(5);
}