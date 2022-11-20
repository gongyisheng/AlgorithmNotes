#include "treenode.h"
#include <iostream>

void traverse(binarytree::TreeNode* root, int traverse_type=0) {
    if (root) {
        return;
    }
    // per_order: do something here
    if (traverse_type == 0) {
        std::cout << root->val << ",";
    }
    traverse(root->left, traverse_type);
    // in_order: do something here
    if (traverse_type == 1) {
        std::cout << root->val << ",";
    }
    traverse(root->right, traverse_type);
    // post_order: do something here
    if (traverse_type == 2) {
        std::cout << root->val << ",";
    }
}

int main() {
    binarytree::TreeNode* root = new binarytree::TreeNode(1);
    root->left = new binarytree::TreeNode(2);
    root->right = new binarytree::TreeNode(3);
    root->left->left = new binarytree::TreeNode(4);
    root->left->right = new binarytree::TreeNode(5);
    root->right->left = new binarytree::TreeNode(6);
    root->right->right = new binarytree::TreeNode(7);
    std::cout << "per_order: ";
    traverse(root, 0);
    std::cout << std::endl;

    std::cout << "in_order: ";
    traverse(root, 1);
    std::cout << std::endl;

    std::cout << "post_order: ";
    traverse(root, 2);
    std::cout << std::endl;
}