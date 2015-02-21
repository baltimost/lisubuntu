System.out.println() somehow let system to update variable, acting like volatile

interrupt() is not stop, just wake up blocked thread which is sleeping, waiting

three tiers of synchronize:
1.synchronized(this)

2.public static Object obj = new Object();
synchronized(obj)
or
synchronized(Example.class)

3.synchronized(Object.class)

if there were multiple synchronized functions in one object/class, once one
of the function is entered by a thread, doors of all the synchronized functions are closed


now I know why there should be try out of sleep and wait,
cause, interrupt or notifyAll will make sleep/wait throw an "InterruptedException", so that the thread can jump out of sleep/wait
