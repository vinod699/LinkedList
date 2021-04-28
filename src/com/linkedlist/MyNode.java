package com.linkedlist;
public class MyLinkedList {

    public INode head;
    public INode tail;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    //adding node in a linked list
    public void add(INode myNode) {
        if (this.tail == null) {
            this.tail = myNode;
        }
        if (this.head == null) {
            this.head = myNode;
        } else {
            INode tempNode = this.head;
            this.head = myNode;
            this.head.setNext(tempNode);
        }
    }

    //appending elements
    public void append(INode myNode) {
        if (this.tail == null) {
            this.tail = myNode;
        }
        if (this.head == null) {
            this.head = myNode;
        } else {
            this.tail.setNext(myNode);
            this.tail = myNode;
        }
    }

    //inserting node between two elements
    public void insert(INode myNode, INode newNode) {
        INode tempNode = myNode.getNext();
        myNode.setNext(newNode);
        newNode.setNext(tempNode);
    }

    //deleting first element
    public INode pop() {
        INode tempNode = this.head;
        this.head = head.getNext();
        return tempNode;
    }

    //deleting last element
    public INode popLast() {
        INode tempNode = head;
        while (!tempNode.getNext().equals((tail))){
            tempNode = tempNode.getNext();
        }
        this.tail = tempNode;
        tempNode = tempNode.getNext();
        return tempNode;
    }

    //to search node
    public boolean searchElement(INode serchNode){
        INode tempNode = this.head;
        while (tempNode != null){
            if (tempNode.getKey().equals(serchNode.getKey())){
                return true;
            }
            tempNode = tempNode.getNext();
        }
        return false;
    }

    //to get size
    public Integer size(){
        Integer size = 0;
        INode tempNode = this.head;
        while(tempNode != null){
            size++;
            tempNode = tempNode.getNext();
        }
        return size;
    }


    //printing nodes
    public void printMyNodes() {
        StringBuffer myNodes = new StringBuffer("My Nodes: ");
        INode tempNode = head;
        while (tempNode.getNext() != null) {
            myNodes.append(tempNode.getKey());
            if (!tempNode.equals(tail)) myNodes.append("->");
            tempNode = tempNode.getNext();
        }
        myNodes.append(tempNode.getKey());
        System.out.println(myNodes);
    }
