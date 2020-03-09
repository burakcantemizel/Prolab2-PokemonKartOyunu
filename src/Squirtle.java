import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Squirtle extends Pokemon{
  private int hasarPuani;
  private boolean kartKullanildiMi;
  private BufferedImage squirtle;
  
  public Squirtle(){
    super( 0, null, null);
  }
  
  public Squirtle(int pokemonID, String pokemonAdi, String pokemonTip){
    super(pokemonID, pokemonAdi, pokemonTip);
    this.hasarPuani = 30;
    this.kartKullanildiMi = false;
    try {
      squirtle = ImageIO.read(new File(Oyun.dosyayolu + "squirtle.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

    @Override
    public void hasarPuaniGoster(Graphics g){
        g.setColor(Color.cyan);
        g.setFont(Oyun.hasarPuaniFont);
        g.drawString(Integer.toString(hasarPuani),getX() + 50,getY() + 135);
        g.drawString(getPokemonTip(),getX() + 48,getY()+155);
    }

  @Override
   public void kartCiz(Graphics g, int x, int y){
    setX(x);
    setY(y);
    g.drawImage(squirtle,x,y,null);
  }

    public int getHasarPuani(){
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

    public BufferedImage getSquirtle() {
        return squirtle;
    }

    public void setSquirtle(BufferedImage squirtle) {
        this.squirtle = squirtle;
    }
}