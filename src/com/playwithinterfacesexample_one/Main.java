package com.playwithinterfacesexample_one;

public class Main {

    @SuppressWarnings("removal")
    public static void main(String... args) {
    Evaluate eval = new Evaluate();
    Integer a = new Integer(5);// I know this is deprecated
    EvaluateAdd eval_add = new EvaluateAdd();
    eval_add.display(new InterfaceContainer.Add() {
        @Override
        public int add(int a, int b) {
            System.out.println("Anon class");
            return a+b;
        }
    });
    eval.add(3,4);
    }
}
