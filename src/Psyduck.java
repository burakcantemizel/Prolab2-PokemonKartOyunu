import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Psyduck extends Pokemon{
  private int hasarPuani;
  private boolean kartKullanildiMi;
  private BufferedImage psyduck;

  public Psyduck(){
    super(0, null, null);
  }
  
  public Psyduck(int pokemonID, String pokemonAdi, String pokemonTip){
    super( pokemonID, pokemonAdi, pokemonTip);
    try {
      psyduck = ImageIO.read(new File(Oyun.dosyayolu + "psyduck.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    this.kartKullanildiMi = false;
    this.hasarPuani = 20;
  }

    @Override
    public void hasarPuaniGoster(Graphics g){
        g.setColor(Color.yellow);
        g.setFont(Oyun.hasarPuaniFont);
        g.drawString(Integer.toString(hasarPuani),getX() + 50,getY() + 135);
      g.drawString(getPokemonTip(),getX() + 48,getY()+155);
    }

  @Override
  public void kartCiz(Graphics g, int x, int y){
    setX(x);
    setY(y);
    g.drawImage(psyduck,x,y,null);
  }

  public int getHasarPuani(){
    //Hasar puanı savaş yapılırken alınıyor burada kart kullanılmış duruma geçiyor
    kartKullanildiMi = true;
    return hasarPuani;
  }
  
  
}