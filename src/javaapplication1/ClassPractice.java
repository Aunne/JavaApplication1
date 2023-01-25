package javaapplication1;

import java.awt.*;
import java.util.Stack;
import java.lang.Byte;

import javaapplication1.student.*;
import javaapplication1.Node.*;
import javaapplication1.tw.edu.nkust.ic.lin.*;

public class ClassPractice {
    public static void main(String[] args) {
        /*
        student1 handsome = new student1("lin", 20f, "C109156251");

        System.out.println(handsome.age);
        handsome.get();

        // Creating a Stack

        Stack<student> student_score = new Stack<student>();

        // Pushing the scores of student to the Stack
        student_score.push(new student(20, "me"));
        student_score.push(new student(22, "her"));


        System.out.println("Score_Stack -> " + student_score);
        System.out.println("-----------------------------------");

        // Popping scores from the Stack
        student pop_test = student_score.pop();
        System.out.println("Pop -> " + pop_test);
        System.out.println("Pop toString -> " + pop_test.toString());
        System.out.println("Current Score_Stack -> " + student_score); */

        Node test = new Node(5);
        test.pref = test;
        test.next = new Node(10);
        test.next.pref = test;
        test.next.next = new Node(15);
        test.next.next.pref = test.next;
        System.out.println(test.value);
        System.out.println(test.next.value);
        System.out.println(test.next.next.value);
        System.out.println(test.next.pref.value);

    }
}
