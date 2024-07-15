# MultiThreading
### Thread Vs Process

1. Two thread share same address space.
2. Context switching between thread is less expensive
3. Cost of communication between thread is very low

### Thread
A thread is an independent sequential path of execution within a program

### User Thread vs Daemon Thread
- There is two types of thread, User thread and Daemon thread
- if there is no user thread running irrespective of daemon thread running or not, programme will terminate.

### Thread Creation

There is 2-way to create Thread.
1. Extending the Thread class.
2. Implementing the Runnable interface.

## Synchronized
if I use Synchronized in method way then lock will be 'this', which means instance of current class , or reference of the current object. otherwise we have to pass any object into the synchronized block to work as lock.

- when we are in static block that time there noting called this. because there is no instance of that class. that time we pass 'ClassName.class' as lock. this is called passing class as a lock.