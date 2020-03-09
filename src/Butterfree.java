import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Butterfree extends Pokemon{
  private int hasarPuani;
  private boolean kartKullanildiMi;
  private BufferedImage butterfree;

  public Butterfree(){
      super(0, null, null);
      this.hasarPuani = 0;
      this.kartKullanildiMi = false;
  }
  
  public Butterfree(int pokemonID, String pokemonAdi, String pokemonTip){
    super(pokemonID, pokemonAdi, pokemonTip);
    this.hasarPuani = 10;
    this.kartKullanildiMi = false;
    try {
     butterfree = ImageIO.read(new File(Oyun.dosyayolu + "butterfree.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void hasarPuaniGoster(Graphics g){
    g.setColor(Color.white);
    g.setFont(Oyun.hasarPuaniFont);
    g.drawString(Integer.toString(hasarPuani),getX() + 50,getY() + 135);
    g.drawString(getPokemonTip(),getX() + 38,getY()+155);
  }

  @Override
  public void kartCiz(Graphics g, int x, int y){
    setX(x);
    setY(y);
    g.drawImage(butterfree,x,y,null);
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

  public BufferedImage getButterfree() {
    return butterfree;
  }

  public void setButterfree(BufferedImage butterfree) {
    this.butterfree = butterfree;
  }

}