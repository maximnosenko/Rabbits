package com.company;
import java.lang.Thread;
/*1)	создать абстрактный класс BaseAI, описывающий «интеллектуальное поведение» объектов.
 Класс должен создавать поток, обеспечивающий движения объектов коллекции;*/
public abstract class AbstractBaceAI implements Runnable {//создание потоков
    boolean going=true;
    Habitat parent;
    AbstractBaceAI(){ }
    abstract public void run();

    //Thread myThread=new Thread(runnable); в мейне классе, где хочешь(такая активация)
    //myThread.start();
    public abstract void stopped();
}
