#pragma once

#include <algorithm>
#include <iostream>

template <typename T>
class Node {
public:
    Node(Node<T>* left, Node<T>* right, const T& value) : left(left), right(right), value(value) {}

    Node(const T& value) : value(value) {}

    ~Node() {
        delete left;
        delete right;
    }

    Node(const Node&) = delete;

    Node& operator=(const Node&) = delete;

    Node<T>* GetLeft() { return left; }

    Node<T>* GetRight() { return right; }

    int GetHeight() { return height; }

    T GetValue() { return value; }

    int GetBalanceFactor() {
        int left_height = left == nullptr ? -1 : left->GetHeight();
        int right_height = right == nullptr ? -1 : right->GetHeight();

        return left_height - right_height;
    }

    void UpdateLeft(Node<T>* new_left) {
        left = new_left;
        UpdateHeight();
    }

    void UpdateRight(Node<T>* new_right) {
        right = new_right;
        UpdateHeight();
    }

    void UpdateValue(T new_value) { value = new_value; }

    void PrintNode() {
        if (left != nullptr) left->PrintNode();
        std::cout << ' ' << value << ' ';
        if (right != nullptr) right->PrintNode();
    }

private:
    Node<T>* left = nullptr;
    Node<T>* right = nullptr;
    int height = 0;
    T value;

    void UpdateHeight() {
        int left_height = left == nullptr ? -1 : left->GetHeight();
        int right_height = right == nullptr ? -1 : right->GetHeight();

        height = std::max(left_height, right_height) + 1;
    }
};