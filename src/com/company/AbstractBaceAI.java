package com.company;
import java.lang.Thread;
/*1)	создать абстрактный класс BaseAI, описывающий «интеллектуальное поведение» объектов.
 Класс должен создавать поток, обеспечивающий движения объектов коллекции;*/
public abstract class AbstractBaceAI extends Thread {//создание потоков
    boolean going=true;
    AbstractRabbit rabbit;
    Habitat parent;
    Thread myThread=new Thread();
    AbstractBaceAI(Habitat parentObj){
        parent=parentObj;
    }
    public void run()
    {

    }
    //Thread myThread=new Thread(runnable); в мейне классе, где хочешь(такая активация)
    //myThread.start();
    public abstract void stopped();
}
