import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PokeTopu {
    private float x;
    private float y;
    private float hiz;
    private BufferedImage resim;

    public PokeTopu(float x, float y, float hiz){
        this.x = x;
        this.y = y;
        this.hiz = hiz;
        try {
            resim = ImageIO.read(new File(Oyun.dosyayolu + "poketop.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void cizdir(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        //g2d.rotate(aci);
        g2d.drawImage(resim, (int)this.x, (int)this.y, null);

        this.y += hiz;

        if(y > 740){
            y = -20;
        }
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getHiz() {
        return hiz;
    }

    public void setHiz(float hiz) {
        this.hiz = hiz;
    }
}
