package com.company;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Rabbits extends AbstractRabbit{

    private BufferedImage image;
    //int BirthTime;

    Rabbits(int x, int y,long Birth,int ID) {
        this.x=x;
        this.y=y;
        this.BirthTime=Birth;
        this.ID=ID;
    }

    @Override
    void setCoordinates(int x,int y) {
        this.x=x;
        this.y=y;
    }

    @Override
    long getTimeBirth() {
        return BirthTime;
    }

    @Override
    int getID() {
        return ID;
    }

    void run()
    {

    }

    @Override
    public BufferedImage getImage()  {
        try {
            image= ImageIO.read(new File("rabbi.png") );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    @Override
    public synchronized int getX() {
        return x;
    }

    @Override
    public synchronized int getY() {
        return y;
    }
}
