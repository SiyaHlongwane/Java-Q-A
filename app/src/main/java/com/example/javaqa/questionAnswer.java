package com.example.javaqa;

public class questionAnswer {

    public static String question[]={
            "What is the default value of a boolean variable in Java?",
            "Which is not a programming langauge",
            "What is the size of an int variable in Java?",
            "Which method is used to print something in Java?",
            "What is the correct way to declare an array in Java?",
            "Which of the following is NOT a wrapper class in Java?",
            "How do you create an object in Java?",
            "Which access modifier allows members to be accessible within the same package but not from outside the package?",
            "Which of the following is a valid declaration of a generic method in Java?",
            "What does the transient keyword mean in Java?",
            "Which of the following is not a feature of Java?",
            "What is the correct way to create a thread in Java?",
            "What is the correct syntax for a lambda expression in Java?",
            "In which case would the finally block not be executed in Java?",
            "Which of the following statements about garbage collection in Java is true?"




    };

    public static String options[][] = {
            {"true", "false", "1","null"},
            {"static", "null", "undefined","voidable"},
            {"8 bits", "16 bits","32 bits","64 bits"},
            {"print", "System.out.print()","console.print","output"},
            {"int[] arr = new int(10)", "int arr[] = new int[10]", "arr = new int[10]","array int arr[10]"},
            {"Integer", "Boolean", "String","Character"},
            {"Object obj = new Object()", "Object obj()", "new Object()","Object obj"},
            {"public", "protected", "private","default"},
            {"public <T> void method(T t)", "public T method<T>(T t)", "public void method(<T> t)","public void <T> method(T t)"},
            {"The variable is always null", "The variable will not be serialized", "The variable cannot be modified","The variable is volatile and thread-safe"},
            {"Object-oriented", "Platform-independent", "High performance","Pointer-based memory manipulation"},
            {"By implementing the Runnable interface","By extending the Thread class","By creating an object of the Thread class","All of the above"},
            {"(int x) -> x + 1","x -> return x + 1","x => x + 1","(x) -> { return x + 1; }"},
            {"When there is a return statement in the try block.","When System.exit() is called in the try block.","When an exception occurs in the catch block.","When there is a break statement in the try block."},
            {"Java provides an explicit method to deallocate memory.","Garbage collection can be forced by the programmer.","Objects with no references are eligible for garbage collection.","Memory is automatically allocated but not automatically deallocated."}
    };

    public static String correctAnswer[] = {
            "false",
            "static",
            "32 bits",
            "System.out.print()",
            "int arr[] = new int[10]",
            "String",
            "Object obj = new Object()",
            "default",
            "public <T> void method(T t)",
            "The variable will not be serialized",
            "Pointer-based memory manipulation",
            "(int x) -> x + 1",
            "When System.exit() is called in the try block.",
            "Objects with no references are eligible for garbage collection."






    };

}
