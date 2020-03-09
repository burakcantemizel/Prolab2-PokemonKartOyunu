import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Snorlax extends Pokemon{
  private int hasarPuani;
  private boolean kartKullanildiMi;
  private BufferedImage snorlax;

  public Snorlax(){
    super(0, null, null);
  }
  
  public Snorlax(int pokemonID, String pokemonAdi, String pokemonTip){
    super(pokemonID, pokemonAdi, pokemonTip);
    this.hasarPuani = 30;
    this.kartKullanildiMi = false;
    try {
      snorlax = ImageIO.read(new File(Oyun.dosyayolu + "snorlax.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void hasarPuaniGoster(Graphics g){
    g.setColor(Color.black);
    g.setFont(Oyun.hasarPuaniFont);
    g.drawString(Integer.toString(hasarPuani),getX() + 50,getY() + 135);
    g.drawString(getPokemonTip(),getX() + 28,getY()+155);
  }

  @Override
  public void kartCiz(Graphics g, int x, int y){
    setX(x);
    setY(y);
    g.drawImage(snorlax,x,y,null);
  }

  public int getHasarPuani(){
    kartKullanildiMi = true;
    return hasarPuani;
  }

  public void setHasarPuani(int hasarPuani) {
    this.hasarPuani = hasarPuani;
  }

  public boolean isKartKullanildiMi() {
    return kartKullanildiMi;
  }

  public void setKartKullanildiMi(boolean kartKullanildiMi) {
    this.kartKullanildiMi = kartKullanildiMi;
  }

  public BufferedImage getSnorlax() {
    return snorlax;
  }

  public void setSnorlax(BufferedImage snorlax) {
    this.snorlax = snorlax;
  }
}