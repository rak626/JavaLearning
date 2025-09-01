
# Lecture 1: Introduction to Multithreading

## What is a Thread?
A thread is the smallest unit of execution within a process.  
In Java, threads allow concurrent execution of tasks.

## Why Multithreading?
- Improves responsiveness  
- Utilizes multi-core CPUs  
- Helps build scalable applications  

## Processes vs Threads
- **Process** → independent execution with separate memory.  
- **Thread** → lightweight, shares memory with other threads of the same process.  

## How to create Threads in Java?

### 1. Extending Thread class
```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Hello from Thread!");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start(); // starts new thread
    }
}
```

### 2. Implementing Runnable interface
```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Hello from Runnable!");
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t2 = new Thread(new MyRunnable());
        t2.start(); // starts new thread
    }
}
```

## Key Points
- Always use **start()** to begin a thread, not **run()**.  
- **run()** just executes like a normal method in the current thread.  
- **start()** creates a new thread and executes **run()** inside it.  
