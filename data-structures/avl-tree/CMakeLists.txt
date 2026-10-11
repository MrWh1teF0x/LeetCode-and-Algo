cmake_minimum_required(VERSION 3.16)

project(avl_tree LANGUAGES CXX)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_CXX_EXTENSIONS OFF)

add_executable(avl_tree main.cpp)

target_include_directories(avl_tree PRIVATE ${CMAKE_CURRENT_SOURCE_DIR})
