## 1.我们为什么要多线程编程?

原因是
 
1.我们一般编写的代码不是纯粹的只用CPU进行计算,我们常常会涉及到IO操作.
2.计算机内部不止CPU一个部件在工作,事实上CPU可以将某些任务分派给其他部件帮它完成.但是会等待其返回的结果,造成阻塞.
3.当非CPU阻塞时,我们可以当CPU去做其他事情,充分利用CPU.


## 2.怎么考虑多线程编程?

1.注意线程的上下文切换是需要消耗性能的,因此线程数和CPU的核心数有一定关系。
2.纯粹的计算密集型任务同时进行的数量应当等于CPU的核心数.
3.常见的大部分任务都是IO密集型任务，比如Web应用.涉及到网络、磁盘IO的任务都是IO密集型任务，这类任务的特点是CPU消耗很少，任务的大部分时间都在等待IO操作完成.(此时的线程数大于CPU的核心数,方便在阻塞时进行上下文的切换)
4.在使用线程时,需要考虑线程的创建和销毁,应采用线程池.



## 3.Java 同步与异步-阻塞与非阻塞理解

Java 中同步与异步，阻塞与非阻塞都是用来形容交互方式，区别在于它们描述的是交互的两个不同层面。

同步与异步
同步和异步更多的指的是消息的通知机制.同步与异步更关注交互双方是否可以同时工作。以同步的方式完成任务意味着多个任务的完成次序是串行的，假设任务 A 依赖于任务 B，那么任务 A 必须等到任务 B 完成之后才能继续，执行流程为 A->B；以异步的方式完成任务意味着多个任务的完成可以是并行的，这种情况多适用于任务之间没有因果关系，假如任务 A 中需要执行任务 B，而任务 A 的完成不依赖于任务 B 的结果，那么任务 A 调用任务 B 后可以继续执行后续步骤而不需要等待任务 B 完成，也不关心任务 B 是否执行完毕，此时任务 A 和任务 B 是并行的。

为了加深对同步和异步的理解，可以使用打电话和发短信的类别同步和异步的交互方式。打电话时，一方的后续操作必须等到另一方说完才能进行，这种交互方式就是同步的。发短信则意味着我们不关心对方看到短信后的结果，我们关心自己是否发了短信，发完短信后，我们可以接着手头上的工作，这种交互方式就是异步的。

阻塞与非阻塞
阻塞与非阻塞关注的是交互双方是否可以弹性工作。假设对象 A 和对象 B 进行交互，而对象 B 对一个问题需要思考一段时间才能回复 A，那么对象 A 可以选择等待对象 B 回复，这种方式就是一种阻塞式交互，与此同时，对象 A 可以选择在对象 B 进行思考的时间去完成别的工作，等到对象 B 完成思考后再进行后续交互，这种方式就是一种非阻塞式的交互。

一般来说，阻塞与非阻塞式用来形容 CPU 消耗的。我们把 CPU 停下来等待慢操作完成以后再接着工作称为阻塞；把 CPU 在慢操作完成之前去完成其他工作，等慢操作完成后再接着工作称为非阻塞。


## 4.操作系统的IO模式

[阻塞IO、非阻塞IO、信号驱动IO、IO多路转接、异步IO](https://blog.csdn.net/ZWE7616175/article/details/80591587)





## 5.Java中的IO和NIO?


| IO | NIO |
|--|--|
|面向流|面向缓冲|
|阻塞IO|非阻塞IO|
|无|选择器|
                

从代码层面看Java的IO操作和Java的NIO操作

`Java IO操作`
```java

```

`Java NIO操作`

```java

```

在上述代码中需要注意的是 在调用read() 或 write()时，该线程被阻塞，直到有一些数据被读取，或数据完全写入。该线程在此期间不能再干任何事情了

所以IO和NIO的代码解决了同一个问题就是读取数据的问题,但是在判断是否读取成功的方式是利用read();阻塞 or 返回值结果判断的方式 然后轮询.

此种方式下，用户进程发起一个IO操作以后边可返回做其它事情，但是用户进程需要时不时的询问IO操作是否就绪，这就要求用户进程不停的去询问，从而引入不必要的CPU资源浪费。


1.面向流与面向缓冲?

&emsp;&emsp;Java NIO和IO之间第一个最大的区别是，IO是面向流的，NIO是面向缓冲区的。 Java IO面向流意味着每次从流中读一个或多个字节，直至读取所有字节，它们没有被缓存在任何地方。此外，它不能前后移动流中的数据。如果需要前后移动从流中读取的数据，需要先将它缓存到一个缓冲区。 Java NIO的缓冲导向方法略有不同。数据读取到一个它稍后处理的缓冲区，需要时可在缓冲区中前后移动。这就增加了处理过程中的灵活性。但是，还需要检查是否该缓冲区中包含所有您需要处理的数据。而且，需确保当更多的数据读入缓冲区时，不要覆盖缓冲区里尚未处理的数据。

2.阻塞与非阻塞IO
&emsp;&emsp;Java IO的各种流是阻塞的。这意味着，当一个线程调用read() 或 write()时，该线程被阻塞，直到有一些数据被读取，或数据完全写入。该线程在此期间不能再干任何事情了。 Java NIO的非阻塞模式，使一个线程从某通道发送请求读取数据，但是它仅能得到目前可用的数据，如果目前没有数据可用时，就什么都不会获取。而不是保持线程阻塞，所以直至数据变的可以读取之前，该线程可以继续做其他的事情。 非阻塞写也是如此。一个线程请求写入一些数据到某通道，但不需要等待它完全写入，这个线程同时可以去做别的事情。 线程通常将非阻塞IO的空闲时间用于在其它通道上执行IO操作，所以一个单独的线程现在可以管理多个输入和输出通道（channel）。



### JavaNIO中的新东西:

NIO的核心组件是:Channels,Buffers,Selectors.

Channel
通常来说NIO中的所有IO都是从 Channel（通道） 开始的

ByteBuffer(缓冲区)

Java NIO Buffers用于和NIO Channel交互. 我们从Channel中读取数据到buffers里,从Buffer把数据写入到Channels;
Buffer本质上就是一块内存区;
一个Buffer有三个属性是必须掌握的，分别是：capacity容量、position位置、limit限制.

选择器（Selectors）
Selector 一般称 为选择器,当然你也可以翻译为 多路复用器.它是Java NIO核心组件中的一个，用于检查一个或多个NIO Channel（通道）的状态是否处于可读、可写。如此可以实现单线程管理多个channels,也就是可以管理多个网络链接.
使用Selector的好处在于: 使用更少的线程来就可以来处理通道了, 相比使用多个线程，避免了线程上下文切换带来的开销。

Java NIO的选择器允许一个单独的线程来监视多个输入通道,你可以注册多个通道使用一个选择器,然后使用一个单独的线程来"选择"通道：这些通道里已经有可以处理的输入,或者选择已准备写入的通道.这种选择机制,使得一个单独的线程很容易来管理多个通道.



    
