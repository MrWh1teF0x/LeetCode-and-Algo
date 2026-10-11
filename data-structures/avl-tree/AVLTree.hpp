#pragma once

#include <initializer_list>
#include <iostream>

#include "Node.hpp"

template <typename T>
class AVLTree {
public:
    AVLTree() = default;

    AVLTree(std::initializer_list<T> values) {
        for (const T& value : values) {
            Add(value);
        }
    }

    ~AVLTree() { delete root; }

    void Add(const T& value) { root = Insert(root, value); }

    void Delete(const T& value) {
        bool found = false;
        root = DeleteNode(root, value, found);
    }

    bool Contains(const T& value) {
        if (root == nullptr) return false;

        Node<T>* curr = root;

        while (curr != nullptr) {
            T curr_value = curr->GetValue();

            if (value == curr_value) return true;

            if (value > curr_value)
                curr = curr->GetRight();
            else
                curr = curr->GetLeft();
        }

        return false;
    }

    void Clear() {
        delete root;
        root = nullptr;
    }

    void PrintTree() {
        std::cout << '[';
        if (root != nullptr) root->PrintNode();
        std::cout << "]\n";
    }

    T Min() {
        Node<T>* min_node = GetMinNodeFromSubtree(root);

        if (min_node == nullptr) throw std::runtime_error("AVLTree is empty");

        return min_node->GetValue();
    }

    T Max() {
        if (root == nullptr) throw std::runtime_error("AVLTree is empty");

        Node<T>* curr = root;

        while (curr->GetRight() != nullptr) curr = curr->GetRight();

        return curr->GetValue();
    }

    bool IsEmpty() { return root == nullptr; }

private:
    Node<T>* root = nullptr;

    Node<T>* BalanceNode(Node<T>* curr) {
        int balance = curr->GetBalanceFactor();

        if (balance > 1) {
            Node<T>* left = curr->GetLeft();
            if (left->GetBalanceFactor() < 0) curr->UpdateLeft(LeftRotate(left));

            return RightRotate(curr);
        }

        if (balance < -1) {
            Node<T>* right = curr->GetRight();
            if (right->GetBalanceFactor() > 0) curr->UpdateRight(RightRotate(right));

            return LeftRotate(curr);
        }

        return curr;
    }

    Node<T>* RightRotate(Node<T>* curr) {
        Node<T>* new_root = curr->GetLeft();

        curr->UpdateLeft(new_root->GetRight());
        new_root->UpdateRight(curr);

        return new_root;
    }

    Node<T>* LeftRotate(Node<T>* curr) {
        Node<T>* new_root = curr->GetRight();

        curr->UpdateRight(new_root->GetLeft());
        new_root->UpdateLeft(curr);

        return new_root;
    }

    Node<T>* Insert(Node<T>* curr, const T& value) {
        if (curr == nullptr) return new Node<T>(value);

        if (value < curr->GetValue())
            curr->UpdateLeft(Insert(curr->GetLeft(), value));
        else
            curr->UpdateRight(Insert(curr->GetRight(), value));

        return BalanceNode(curr);
    }

    Node<T>* DeleteNode(Node<T>* curr, const T& value, bool& found) {
        if (curr == nullptr) {
            found = false;
            return nullptr;
        }

        if (value < curr->GetValue()) {
            curr->UpdateLeft(DeleteNode(curr->GetLeft(), value, found));
        } else if (value > curr->GetValue()) {
            curr->UpdateRight(DeleteNode(curr->GetRight(), value, found));
        } else {
            found = true;

            if (curr->GetLeft() == nullptr || curr->GetRight() == nullptr) {
                Node<T>* child = curr->GetLeft() != nullptr ? curr->GetLeft() : curr->GetRight();
                curr->UpdateLeft(nullptr);
                curr->UpdateRight(nullptr);
                delete curr;
                return child;
            }

            Node<T>* succ = GetMinNodeFromSubtree(curr->GetRight());
            curr->UpdateValue(succ->GetValue());
            curr->UpdateRight(DeleteNode(curr->GetRight(), succ->GetValue(), found));
        }

        return BalanceNode(curr);
    }

    Node<T>* GetMinNodeFromSubtree(Node<T>* node) {
        if (node == nullptr) return nullptr;

        Node<T>* curr = node;

        while (curr->GetLeft() != nullptr) curr = curr->GetLeft();

        return curr;
    }
};