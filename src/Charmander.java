import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Charmander extends Pokemon{
  private int hasarPuani;
  private boolean kartKullanildiMi;
  private BufferedImage charmander;

  public Charmander(){
    super(0, null, null);
  }
  
  public Charmander(int pokemonID, String pokemonAdi, String pokemonTip){
    super(pokemonID, pokemonAdi, pokemonTip);
    this.hasarPuani = 60;
    this.kartKullanildiMi = false;
    try {
      charmander = ImageIO.read(new File(Oyun.dosyayolu + "charmander.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void hasarPuaniGoster(Graphics g){
    g.setColor(Color.RED);
    g.setFont(Oyun.hasarPuaniFont);
    g.drawString(Integer.toString(hasarPuani),getX() + 50,getY() + 135);
    g.drawString(getPokemonTip(),getX() + 37,getY()+155);
  }

  @Override
  public void kartCiz(Graphics g,int x, int y){
    setX(x);
    setY(y);
    g.drawImage(charmander,x,y,null);
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

  public BufferedImage getCharmander() {
    return charmander;
  }

  public void setCharmander(BufferedImage charmander) {
    this.charmander = charmander;
  }
}