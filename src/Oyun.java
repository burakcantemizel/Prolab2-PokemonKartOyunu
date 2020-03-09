import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;


public class Oyun extends JPanel implements MouseListener{

	//!!!!!!!!!!!!!!!!!!! �NEML� !!!!!!!!!!!!!!!!!!!!!
	// Proje farkl� g�rsel dosyalar�n� kaynaklar klas�r�nden y�klemektedir.
	// A�a��da bulunan dosya yolu otomatik olarak src klas�r�n�n yan�ndaki kaynaklar klas�r�nden �geleri y�kler.
	final static String dosyayolu = "kaynaklar//";

	//E�ER JAR DOSYASI OLU�TURULACAKSA VS.
	//DOSYA YOLU -- TUM KAYNAKLAR BU DOSYA YOLU ALTINDA OLMALIDIR
	//Proje farkl� bir ortamda �al��t�r�lmak veya derlenmek isteniyorsa dosyayolu de�i�kenine klas�r�n direkt adresi verilmelidir.
	//�rnek dosya yolu DiskHarfi\\PROJEKLASORU\\kaynaklar\\
	// \\kaynaklar\\ klas�r� proje klas�r yap�s�n�n i�erisinde bulunmaktad�r projenin ana dizini onun �n�ne eklenmelidir.
	//final static String dosyayolu = "E:\\Prolab2Son\\kaynaklar\\";

	//PENCERE SAB�TLER� VE D��ER SAB�TLER
	private final static int PENCERE_GENISLIK = 1280;
	private final static int PENCERE_YUKSEKLIK = 720;
	private final static int KART_GENISLIK = 120; // px cinsinden
	private final static int KART_YUKSEKLIK = 180; // px cinsinden

	//MOUSE POZ�SYONU -- OYUN DONGUSU ICERISINDE GUNCELLENIYOR
	private static int mouseX;
	private static int mouseY;

	//FLAGLAR
	private static boolean baslangicKartDagitildiMi;
	private static boolean turSonuKartCek;
	private static String sahne;
	private static boolean sunumModu = false;
	private static boolean tiklandiMi;

	//Oyuna ait nesneler ve yap�lar
	private static ArrayList<Pokemon> kartListesi;
	private static InsanOyuncusu oyuncu1;
	private static BilgisayarOyuncusu oyuncu1b;
	private static BilgisayarOyuncusu oyuncu2;


	//Zamanlay�c�lar ve di�erleri
	private static int tur = 1;
	static int bilgisayarTimer = 0;
	private static int savasTimer = 0;
	private static int cevirmeTimer = 0;
	private static int bitisTimer = 0;

	static Random random = new Random();
	private static BufferedImage kartarka;
	private static BufferedImage baslik;
	private static BufferedImage oyunarkaplan;


	private static Font menuFont;
	private static Color menuBlackColor;
	private static Color menuRedColor;
	private static Color menuGreenColor;
	private static Color menuYellowColor;

	private static int pokeTopAdet;
	private static BufferedImage pokeTopu;
	private static BufferedImage arkaplan;
	private static PokeTopu[] poketoplari;

	static Pokemon savasan1;
	static Pokemon savasan2;
	static Font hasarPuaniFont;

	public Oyun(){
		//G�rsel y�klemeleri
		pokeTopAdet = 32;
		poketoplari = new PokeTopu[pokeTopAdet];

		for(int i = 0; i < pokeTopAdet; i++){
			poketoplari[i] = new PokeTopu(i * 40, -random.nextInt(350), 3+random.nextFloat()*2);
		}

		try {
			kartarka = ImageIO.read(new File(dosyayolu + "kartarka.png"));
			baslik =  ImageIO.read(new File(dosyayolu + "baslik.png"));
			oyunarkaplan = ImageIO.read(new File(dosyayolu + "oyunarkaplan.png"));
			 arkaplan = ImageIO.read(new File(dosyayolu + "menuarkaplan.png"));
			//pokeTopu = ImageIO.read(new File(dosyayolu + "poketop.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		//Font olusturma
		hasarPuaniFont = new Font("MonoSpaced", Font.BOLD, 18);
		menuFont = new Font("MonoSpaced", Font.BOLD, 15);
		menuBlackColor = new Color(0,0,0,150);
		menuRedColor = new Color(255, 0, 0, 180);
		menuGreenColor = new Color(0 , 255 , 0 , 180);
		menuYellowColor = new Color(255, 255, 0 , 180);
	}

	//Ayarla fonksiyonu oyun i�in gerekli de�i�kenleri ayarl�yor
	public void ayarla() {
		sahne = "menu";
		tiklandiMi = false;
		baslangicKartDagitildiMi = false;
		turSonuKartCek = false;
		tur = 1;
		bilgisayarTimer = 0;
		savasTimer = 0;
		bitisTimer = 0;
		cevirmeTimer = 0;
		oyuncu1 = new InsanOyuncusu(3, null, 0);
		oyuncu2 = new BilgisayarOyuncusu(2,null,0);
		oyuncu1b = new BilgisayarOyuncusu(1,null,0);
		kartListesi = new ArrayList<Pokemon>();
		desteOlustur(kartListesi);
		desteKaristir(kartListesi);
		savasan1 = null;
		savasan2 = null;
	}

	public void desteOlustur(ArrayList<Pokemon> kartListesi){
		  kartListesi.add(new Pikachu(0,"Pikachu","Elektrik"));
		  kartListesi.add(new Bulbasaur(1,"Bulbasaur","�im"));
		  kartListesi.add(new Charmander(2,"Charmander","Ate�"));
		  kartListesi.add(new Squirtle(3,"Squirtle","Su"));
		  kartListesi.add(new Zubat(4,"Zubat","Hava"));
		  kartListesi.add(new Psyduck(5,"Psyduck","Su"));
		  kartListesi.add(new Snorlax (6,"Snorlax","Normal"));
		  kartListesi.add(new Butterfree(7,"Butterfree","Hava"));
		  kartListesi.add(new Jigglypuff(8,"Jigglypuff","Ses"));
		  kartListesi.add(new Meowth(9,"Meowth","Normal"));
	}
	
	public void desteKaristir(ArrayList<Pokemon> kartListesi){
		  Collections.shuffle(kartListesi);
	}

	public void tumDesteleriCiz(Graphics g){
		//Ortadaki kartlar
		if(sunumModu == true){
			desteCiz(g, kartListesi, PENCERE_GENISLIK/8 + 15, PENCERE_YUKSEKLIK/2 - KART_YUKSEKLIK/2, 25, 0, true);
		}else{
			desteCiz(g, kartListesi, PENCERE_GENISLIK/8 + 15, PENCERE_YUKSEKLIK/2 - KART_YUKSEKLIK/2, 25, 0, false);
		}

		  if(sahne == "oyunbb"){
		  	if(sunumModu == true){
				desteCiz(g, oyuncu1b.getKartListesi(),PENCERE_GENISLIK/2 - (oyuncu1b.getKartListesi().size() * (KART_GENISLIK+20))/2-10 + 20,PENCERE_YUKSEKLIK - KART_YUKSEKLIK - 20,KART_GENISLIK + 20,0, true);
			}else{
				desteCiz(g, oyuncu1b.getKartListesi(),PENCERE_GENISLIK/2 - (oyuncu1b.getKartListesi().size() * (KART_GENISLIK+20))/2-10 + 20,PENCERE_YUKSEKLIK - KART_YUKSEKLIK - 20,KART_GENISLIK + 20,0, false);
			}

		  }else if(sahne == "oyunbk"){
		  	if(sunumModu == true){
				desteCiz(g, oyuncu1.getKartListesi(),PENCERE_GENISLIK/2 - (oyuncu1.getKartListesi().size() * (KART_GENISLIK+20))/2-10 + 20,PENCERE_YUKSEKLIK - KART_YUKSEKLIK - 20,KART_GENISLIK + 20,0, true);
			}else {
				desteCiz(g, oyuncu1.getKartListesi(),PENCERE_GENISLIK/2 - (oyuncu1.getKartListesi().size() * (KART_GENISLIK+20))/2-10 + 20,PENCERE_YUKSEKLIK - KART_YUKSEKLIK - 20,KART_GENISLIK + 20,0, true);
			}

		  }

		  //Yerdeki
		if(sunumModu == true) {
			desteCiz(g, oyuncu2.getKartListesi(), PENCERE_GENISLIK / 2 - (oyuncu2.getKartListesi().size() * (KART_GENISLIK + 20)) / 2 - 10 +20, 20, KART_GENISLIK + 20, 0, true);
		}else{
			desteCiz(g, oyuncu2.getKartListesi(), PENCERE_GENISLIK / 2 - (oyuncu2.getKartListesi().size() * (KART_GENISLIK + 20)) / 2 - 10 + 20, 20, KART_GENISLIK + 20, 0, false);
		}

		  if(savasan1 != null){
		      //Burda �nce kapal� �izicez belli bir s�re sonra a��lacak
              if(cevirmeTimer > 50){ //if(cevirmeTimer > 50) haline getirilecek sunumdada ortadaki kartlar kapal� olsun isteniyorsa
                  savasan1.kartCiz(g, PENCERE_GENISLIK/2 - KART_GENISLIK -30+20,PENCERE_YUKSEKLIK/2 - KART_YUKSEKLIK/2);
                  savasan1.hasarPuaniGoster(g);

              }else{
                  g.drawImage(kartarka,PENCERE_GENISLIK/2 - KART_GENISLIK -30+20,PENCERE_YUKSEKLIK/2 - KART_YUKSEKLIK/2,null);
              }

		  }

		  if(savasan2 != null){
              if(cevirmeTimer > 50){ // if(cevirmeTimer > 50) haline getirilecek sunumdada ortadaki kartlar kapal� olsun isteniyorsa
                  savasan2.kartCiz(g,PENCERE_GENISLIK/2 - 10 + 20,PENCERE_YUKSEKLIK/2 - KART_YUKSEKLIK/2);
				  savasan2.hasarPuaniGoster(g);
              }else{
                  g.drawImage(kartarka,PENCERE_GENISLIK/2 - 10 + 20,PENCERE_YUKSEKLIK/2 - KART_YUKSEKLIK/2,null);
              }

		  }

		  g.setFont(hasarPuaniFont);
		  g.setColor(Color.white);
		  if(sahne == "oyunbb"){
		  	oyuncu1b.skorGoster(g);
		  	oyuncu2.skorGoster(g);
		  }else if(sahne == "oyunbk"){
		  	oyuncu1.skorGoster(g);
		  	oyuncu2.skorGoster(g);
		  }
		}
	
	public void desteCiz(Graphics g,ArrayList<Pokemon> kartListesi, int x, int y, int kaymaX, int kaymaY, boolean acikCiz){
		  for(int i = 0; i < kartListesi.size(); i++){
		  	if(acikCiz == true){
				kartListesi.get(i).kartCiz(g, x + i * kaymaX ,y + i * kaymaY);
				kartListesi.get(i).hasarPuaniGoster(g);
				//kartListesi.get(i).hasarPuaniGoster(g);
			}else{
				g.drawImage(kartarka, x + i * kaymaX, y + i * kaymaY, null);
			}

		  }
		}

		public static void poketopuYagmuru(Graphics g){
			for(int i = 0; i < Oyun.pokeTopAdet; i++){
				poketoplari[i].cizdir(g);
			}
		}

	public static void menuCiz(Graphics g) throws IOException {
			g.drawImage(arkaplan, 0, 0, null);

			//Burada gokten poketopu yagdircaz
			poketopuYagmuru(g);
			g.setFont(menuFont);

			g.drawImage(baslik,PENCERE_GENISLIK/2 - 193,PENCERE_YUKSEKLIK/7,null);


			if(mouseOver(PENCERE_GENISLIK/2 - 120, PENCERE_YUKSEKLIK/2 , 240,80)){
				g.setColor(menuYellowColor);
			}else{
				g.setColor(menuBlackColor);
			}

			g.fillRect(PENCERE_GENISLIK/2 - 120, PENCERE_YUKSEKLIK/2 , 240,80);

			if(mouseOver(PENCERE_GENISLIK/2 - 120, PENCERE_YUKSEKLIK/2 , 240,80)){
				g.setColor(Color.black);
			}else{
				g.setColor(Color.white);
			}

			g.drawString("Bilgisayar-�nsan", PENCERE_GENISLIK /2- 70, PENCERE_YUKSEKLIK / 2 + 40);

			if(mouseOver(PENCERE_GENISLIK/2 - 120, PENCERE_YUKSEKLIK/2 + 90 , 240,80)){
				g.setColor(menuYellowColor);
			}else{
				g.setColor(menuBlackColor);
			}
			g.fillRect(PENCERE_GENISLIK/2 - 120, PENCERE_YUKSEKLIK/2 + 90 , 240,80);

			if(mouseOver(PENCERE_GENISLIK/2 - 120, PENCERE_YUKSEKLIK/2 + 90 , 240,80)){
				g.setColor(Color.black);
			}else{
				g.setColor(Color.white);
			}
			g.drawString("Bilgisayar-Bilgisayar", PENCERE_GENISLIK /2- 95, PENCERE_YUKSEKLIK / 2 + 40 + 90);

			g.setColor(menuBlackColor);
			g.fillRect(10, PENCERE_YUKSEKLIK - 70, 180,60);
			g.setColor(Color.white);
			g.drawString("Sunum modu", 50, PENCERE_YUKSEKLIK - 70 + 30);

			if(sunumModu){
				g.setColor(menuGreenColor);
			}else{
				g.setColor(menuBlackColor);
			}

			g.fillRect(200, PENCERE_YUKSEKLIK - 70, 60,60);
			g.setColor(Color.white);
			g.drawString("A�", 220, PENCERE_YUKSEKLIK - 70 + 30);

			if(!sunumModu){
				g.setColor(menuRedColor);
			}else{
				g.setColor(menuBlackColor);
			}

			g.fillRect(270, PENCERE_YUKSEKLIK - 70, 60,60);
			g.setColor(Color.white);
			g.drawString("Kapat", 276, PENCERE_YUKSEKLIK - 70 + 30);

		}
	
	public void kartCek(ArrayList<Pokemon> kartListesi, ArrayList<Pokemon> kartListesi2){
	    int secilenKart = random.nextInt(kartListesi.size());//(int)random(0, kartListesi.size()); //javan�n randomunu kullancaz
	    kartListesi2.add(kartListesi.get(secilenKart));
	    kartListesi.remove(secilenKart);
	}
	
	public static boolean mouseOver(int x, int y, int w, int h){
		  if(mouseX > x && mouseX < x+w && mouseY > y && mouseY < y+h){
		    return true;
		  }
		  return false;
		}
	
	public void savasYap(){
		  if(savasan1 != null && savasan2 != null){
		    savasTimer++;
		    cevirmeTimer++;
		  }

		  if(savasTimer > 250){
		    if(savasan1 != null && savasan2 != null){
		    if(savasan1.getHasarPuani() > savasan2.getHasarPuani()){
		    	if(sahne == "oyunbb"){
					oyuncu1b.setSkor(oyuncu1b.getSkor() + 5);
				}else if(sahne == "oyunbk"){
					oyuncu1.setSkor(oyuncu1.getSkor() + 5);
				}
		      savasan1 = null;
		      savasan2 = null;
		      savasTimer = 0;
		      if(kartListesi.size() >=2 ){
		      turSonuKartCek = true;
		      }
		      cevirmeTimer = 0;
		      
		      return;
		      
		    }else if(savasan1.getHasarPuani() < savasan2.getHasarPuani()){
		      oyuncu2.setSkor(oyuncu2.getSkor() + 5);
		      savasan1 = null;
		      savasan2 = null;
		      savasTimer = 0;
		      if(kartListesi.size() >=2 ){
		      turSonuKartCek = true;
		      }
                cevirmeTimer = 0;
		      return;
		      
		    }else{
		      //Beraberlik
		      savasan1 = null;
		      savasan2 = null;
		      savasTimer = 0;
		      if(kartListesi.size() >=2 ){
		      turSonuKartCek = true;
		      }
                cevirmeTimer = 0;
		      return;

		    }
		  }
		  }
		  
		}

	public void guncelle() {

		switch(sahne) {
		case "menu":
			//Men� tiklamalari ve islemleri
			if(mouseOver(PENCERE_GENISLIK/2 - 120, PENCERE_YUKSEKLIK/2, 240, 80) && tiklandiMi){
				sahne = "oyunbk";
			}

			if(mouseOver(PENCERE_GENISLIK/2 - 120, PENCERE_YUKSEKLIK/2 + 90, 240, 80) && tiklandiMi){
				sahne = "oyunbb";
			}

			if(mouseOver(200, PENCERE_YUKSEKLIK - 70, 60,60) && tiklandiMi) {
				sunumModu = true;
			}

			if(mouseOver(270, PENCERE_YUKSEKLIK- 70, 60, 60) && tiklandiMi) {
				sunumModu = false;
			}
			break;
			
		case "oyunbb":
	        if(baslangicKartDagitildiMi == false){
	            kartCek(kartListesi,oyuncu1b.getKartListesi());
	            kartCek(kartListesi,oyuncu2.getKartListesi());
	            kartCek(kartListesi,oyuncu1b.getKartListesi());
	            kartCek(kartListesi,oyuncu2.getKartListesi());
	            kartCek(kartListesi,oyuncu1b.getKartListesi());
	            kartCek(kartListesi,oyuncu2.getKartListesi());
	            baslangicKartDagitildiMi = true;
	          }
			
			savasYap();
			
			if(tur % 2 == 0){ //2. oyuncu oynayacak
		          //Eğer elinde 3 kart yoksa kart çeksin
		          if(savasan2 == null && oyuncu2.getKartListesi().size() > 0){
		            if(oyuncu2.kartSec()){
		              tur++;
		            }
		          }
		        }else { //1. oyuncu oynayacak
		          if(savasan1 == null && oyuncu1b.getKartListesi().size() > 0){
		            if(oyuncu1b.kartSec()){
		              tur++;
		            }
		          }
		        }
			if(turSonuKartCek){
		          if(kartListesi.size() >= 2){
		          kartCek(kartListesi, oyuncu2.getKartListesi());
		          kartCek(kartListesi, oyuncu1b.getKartListesi());
		          }
		          turSonuKartCek = false;
		        }
			break;
			
		case "oyunbk":
			if(!baslangicKartDagitildiMi){
		          kartCek(kartListesi,oyuncu1.getKartListesi());
		          kartCek(kartListesi,oyuncu2.getKartListesi());
		          kartCek(kartListesi,oyuncu1.getKartListesi());
		          kartCek(kartListesi,oyuncu2.getKartListesi());
		          kartCek(kartListesi,oyuncu1.getKartListesi());
		          kartCek(kartListesi,oyuncu2.getKartListesi());
		          baslangicKartDagitildiMi = true;
		    }
			savasYap();
			if(tur % 2 == 0){ //2. oyuncu oynayacak
		          //Eğer elinde 3 kart yoksa kart çeksin

		          if(savasan2 == null){
		            if(oyuncu2.kartSec()){
		              tur++;
		            }
		          }
		        }else { //1. oyuncu oynayacak
		          if(savasan1 == null){
		            if(oyuncu1.kartSec()){
		              tur++;
		            }
		          }
		        }
			if(turSonuKartCek){
		          if(kartListesi.size() >= 2){
		          kartCek(kartListesi, oyuncu2.getKartListesi());
		          kartCek(kartListesi, oyuncu1.getKartListesi());
		          }
		          turSonuKartCek = false;
		        }
			break;
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		switch(sahne) {
		case "menu":
			try {
				menuCiz(g);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
			
		case "oyunbb":
			g.drawImage(oyunarkaplan,0,0,null);
			tumDesteleriCiz(g);

			if(kartListesi.size() == 0 && oyuncu1b.getKartListesi().size() == 0 && oyuncu2.getKartListesi().size() == 0 && savasan1 == null && savasan2 == null){
				//textSize(24);
				//Oyun bitmiştir
				if(oyuncu1b.getSkor() > oyuncu2.getSkor()){
					//text("Oyuncu 1 Kazandi!", width/2, height/2);
					g.drawString("Bilgisayar 1 Kazand�!", PENCERE_GENISLIK /2 - 100, PENCERE_YUKSEKLIK / 2);
				}else if(oyuncu1b.getSkor() < oyuncu2.getSkor()){
					//text("Oyuncu 2 Kazandi!", width/2, height/2);
					g.drawString("Bilgisayar 2 Kazand�!", PENCERE_GENISLIK /2 - 100, PENCERE_YUKSEKLIK / 2);
				}else{
					//text("Berabere!", width/2, height/2);
					g.drawString("Berabere!", PENCERE_GENISLIK /2 - 50, PENCERE_YUKSEKLIK / 2);
				}

				bitisTimer++;
				if(bitisTimer > 250){
					bitisTimer = 0;
					//System.exit(0);
					//setup();
					ayarla();
					sahne = "menu";
				}

			}
			break;
			
		case "oyunbk":
			g.drawImage(oyunarkaplan,0,0,null);
			tumDesteleriCiz(g);

			if(kartListesi.size() == 0 && oyuncu1.getKartListesi().size() == 0 && oyuncu2.getKartListesi().size() == 0 && savasan1 == null && savasan2 == null){
				//textSize(24);
				//Oyun bitmiştir
				if(oyuncu1.getSkor() > oyuncu2.getSkor()){
					//text("Oyuncu 1 Kazandi!", width/2, height/2);
					g.drawString("Oyuncu Kazand�!", PENCERE_GENISLIK /2 - 80, PENCERE_YUKSEKLIK / 2);
				}else if(oyuncu1.getSkor() < oyuncu2.getSkor()){
					//text("Oyuncu 2 Kazandi!", width/2, height/2);
					g.drawString("Bilgisayar Kazand�!", PENCERE_GENISLIK /2 - 100, PENCERE_YUKSEKLIK / 2);
				}else{
					//text("Berabere!", width/2, height/2);
					g.drawString("Berabere!", PENCERE_GENISLIK /2 - 50, PENCERE_YUKSEKLIK / 2);
				}

				bitisTimer++;
				if(bitisTimer > 250){
					bitisTimer = 0;
					ayarla();
					sahne = "menu";
				}

			}

			break;
		}
	}

	public static void main(String[] args) throws InterruptedException { //Thread i�lemleri i�in exception f�rlatt�k
		//System.setProperty("sun.java2d.opengl", "true");
		JFrame pencere = new JFrame("Pokemon Kart Oyunu"); // Pencere olusturduk
		Oyun oyun = new Oyun(); // Oyunun bulundugu paneli olusturduk
		oyun.setPreferredSize(new Dimension(Oyun.PENCERE_GENISLIK,Oyun.PENCERE_YUKSEKLIK)); // Panel boyutunu ayarlad�k
		pencere.add(oyun); //Paneli pencereye ekledik
		pencere.pack(); // Boyutu en fazla olan komponent panel, pencereyi panele gore boyutlandiriyoruz.
		pencere.addMouseListener(oyun); // Mouselisteneri pencereye ekledik
		pencere.setResizable(false); // Boyutlandirmayi kapattik
		pencere.setVisible(true); // Pencereyi g�r�n�r hale getirdik
		pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Varsay�lan kapatma i�lemi
		pencere.setLocationRelativeTo(null); //Pencereyi ekran�n ortas�na ald�k
		
		oyun.ayarla(); // Bir kere ayarla fonksiyonu �al���yor ve tan�mlamalar� yap�yor.

		while(true) { //Daha sonra program oyun d�ng�s�ne giriyor
			// Mouseun ekrandaki konumundan pencereyi ��kararak paneldeki konumu buluyoruz.
			Insets kenarliklar = pencere.getInsets();
			Oyun.mouseX = MouseInfo.getPointerInfo().getLocation().x - pencere.getX() - kenarliklar.left;
			Oyun.mouseY = MouseInfo.getPointerInfo().getLocation().y - pencere.getY() - kenarliklar.top;

			oyun.guncelle(); // Oyun mant��� �al���yor
			oyun.repaint(); // Daha sonra render i�lemi yap�l�yor
			Thread.sleep(10);// Komplike oyun d�ng�s� kullan�lmad� 10 ms program uyutuluyor
		}
	}

	//MouseListener Interface Metodlar�
    @Override public void mousePressed(MouseEvent e) {
        tiklandiMi = true;
    }
    @Override public void mouseReleased(MouseEvent e) {
        tiklandiMi = false;
    }
	@Override public void mouseClicked(MouseEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}

	//GET-SET METODLARI

	public static boolean getTiklandiMi() {
		return tiklandiMi;
	}

	public static void setTiklandiMi(boolean tiklandiMi) {
		Oyun.tiklandiMi = tiklandiMi;
	}

	public static String getSahne() {
		return sahne;
	}

}
