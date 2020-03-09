import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Jigglypuff extends Pokemon{
  private int hasarPuani;
  private boolean kartKullanildiMi;
  private BufferedImage jigglypuff;

  public Jigglypuff(){
    super(0, null, null);
  }
  
  public Jigglypuff(int pokemonID, String pokemonAdi, String pokemonTip){
    super(pokemonID, pokemonAdi, pokemonTip);
    this.hasarPuani = 70;
    this.kartKullanildiMi = false;
    try {
      jigglypuff = ImageIO.read(new File(Oyun.dosyayolu + "jigglypuff.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

    @Override
    public void hasarPuaniGoster(Graphics g){
      g.setColor(Color.PINK);
      g.setFont(Oyun.hasarPuaniFont);
      g.drawString(Integer.toString(hasarPuani),getX() + 50,getY() + 135);
      g.drawString(getPokemonTip(),getX() + 43,getY()+155);
    }

    @Override
  public void kartCiz(Graphics g, int x, int y){
    setX(x);
    setY(y);
    g.drawImage(jigglypuff,x,y,null);
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

  public BufferedImage getJigglypuff() {
    return jigglypuff;
  }

  public void setJigglypuff(BufferedImage jigglypuff) {
    this.jigglypuff = jigglypuff;
  }
}