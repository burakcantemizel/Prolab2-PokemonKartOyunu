<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
	<META HTTP-EQUIV="CONTENT-TYPE" CONTENT="text/html; charset=utf-8">
	<META NAME="GENERATOR" CONTENT="LibreOffice 4.1.6.2 (Linux)">
	<META NAME="AUTHOR" CONTENT="IEEE">
	<META NAME="CREATED" CONTENT="20180818;231400000000000">
	<META NAME="CHANGEDBY" CONTENT="Ozge Poyraz">
	<META NAME="CHANGED" CONTENT="20191201;172800000000000">
	<META NAME="__Grammarly_42___1" CONTENT="H4sIAAAAAAAEAKtWcslP9kxRslIyNDYyNDU0N7QwMTMwNjY3NzZT0lEKTi0uzszPAykwrAUAt9LCuywAAAA=">
	<META NAME="__Grammarly_42____i" CONTENT="H4sIAAAAAAAEAKtWckksSQxILCpxzi/NK1GyMqwFAAEhoTITAAAA">
	
</HEAD>
<BODY LANG="en-US" TEXT="#000000" LINK="#0000ff" DIR="LTR">
<H1 ALIGN=CENTER STYLE="text-indent: 0in; margin-top: 0.07in; margin-bottom: 0.07in; line-height: 100%">
<FONT SIZE=6>Programlama Laboratuvarı Pokemon Kart Oyunu</FONT></H1>

<P ALIGN=CENTER STYLE="text-indent: 0in; margin-top: 0.07in; margin-bottom: 0.07in; line-height: 50%">
<BR><BR>
</P>
<DIV ID="Section1" DIR="LTR" GUTTER=48 STYLE="column-count: 3">
	<P ALIGN=CENTER STYLE="text-indent: 0in; margin-top: 0.07in; margin-bottom: 0.03in; line-height: 100%">
	<FONT SIZE=2 STYLE="font-size: 11pt"><FONT SIZE=2 STYLE="font-size: 9pt">Özge
	POYRAZ <BR>Kocaeli Üniversitesi</FONT><FONT SIZE=2 STYLE="font-size: 9pt"><I>
	<BR></I></FONT><FONT SIZE=2 STYLE="font-size: 9pt">Mühendislik
	Fakültesi<BR></FONT><FONT SIZE=2 STYLE="font-size: 9pt">Bilgisayar
	Mühendisliği</FONT><FONT SIZE=2 STYLE="font-size: 9pt"><I>
	<BR>180202025@kocaeli.edu.tr</I></FONT></FONT></P>
	<P ALIGN=CENTER STYLE="text-indent: 0in; margin-top: 0.07in; margin-bottom: 0.03in; line-height: 100%">
	<BR><BR>
	</P>
	<P ALIGN=CENTER STYLE="text-indent: 0in; margin-top: 0.07in; margin-bottom: 0.03in; line-height: 100%">
	<FONT SIZE=2 STYLE="font-size: 11pt"><FONT SIZE=2 STYLE="font-size: 9pt">Burak
	Can TEMİZEL<BR>Kocaeli Üniversitesi</FONT><FONT SIZE=2 STYLE="font-size: 9pt"><I>
	</I></FONT><FONT SIZE=2 STYLE="font-size: 9pt"><BR>Mühendislik
	Fakültesi</FONT><FONT SIZE=2 STYLE="font-size: 9pt"><I><BR></I></FONT><FONT SIZE=2 STYLE="font-size: 9pt">Bilgisayar
	Mühendisliği<BR>180202024@kocaeli.edu.tr</FONT></FONT></P>
</DIV>
<DIV ID="Section2" DIR="LTR" GUTTER=48 STYLE="column-count: 3">
	<P CLASS="western" ALIGN=CENTER STYLE="text-indent: 0in; margin-bottom: 0in; line-height: 100%">
	<BR>
	</P>
</DIV>
<DIV ID="Section3" DIR="LTR" GUTTER=24 STYLE="column-count: 2">
	<P STYLE="text-indent: 0.19in; margin-bottom: 0.14in; line-height: 100%">
	<FONT SIZE=2 STYLE="font-size: 9pt"><B><I>Özet</I>—Bu çalışmada
	nesneye yönelik programlama ve arayüz ögeleri ile bir pokemon
	kart oyunu gerçekleştirdik. Oyun mantığı için basit bir oyun
	döngüsü kullandık ve grafik fonksiyonları ile animasyonlar
	oluşturduk. Çeşitli veri yapılarını ve nesneye yönelik
	programlamanın temel kavramlarından olan kapsülleme, kalıtım,
	çok biçimliliği kullanarak oyunu tamamladık.</B></FONT></P>
	<P STYLE="text-indent: 0.19in; line-height: 100%"><FONT SIZE=2 STYLE="font-size: 9pt"><I><B>Anahtar
	kelimeler—Nesne, sınıf, oyun, arayüz, pokemon </B></I></FONT>
	</P>
	<H1 LANG="en-US" CLASS="western">I.Giriş 
	</H1>
	<P LANG="tr-TR" CLASS="western">Gerçekleştirdiğimiz proje
	temelinde basit bir oyun olsa da içerisinde farklı farklı
	sistemler içermekteydi. İlk olarak her oyun gibi bu oyunun da bir
	arayüze sahip olması gerekliydi. Bu arayüz ortamını gerçeklemek
	için Java’nın dahili grafik kütüphaneleri olan swing ve awtden
	faydalandık. Oyunumuz bir kart oyunu olması sebebiyle mantık
	olarak nesneye yönelik programlama konseptine çok uygundu. Burada
	oyundaki çeşitli nesneler için çeşitli sınıflar tanımlandı.
	Oyunun mantığının işlemesi için farklı seçeneklerimiz
	bulunuyordu. Kart oyunu olması sebebiyle ilk olarak event sistemi
	üzerinde durduk. Böylece gerçekleştirilen seçimler veya
	etkileşimlere karşılık olayları tetikleyerek oyun akışını
	oluşturabilecektik fakat oyun içerisinde çeşitli animasyonları
	ya da fizik etkileşimleri kullanabilme ihtimalimiz olursa diye oyun
	döngüsü kullanmaya karar verdik. Oyunun yapısı gereği farklı
	türde oyun döngülerinden en doğru olanı seçmemiz gerekiyordu
	fakat düşününce render işleminin oyun mantığından bağımsız
	oluşu ve fiziksel etkileşimlerin olmaması sebebiyle değişken ya
	da sabit zamanlı oyun döngüsü kullanmayıp işlem yaptığımız
	threadi kullanarak belli bir kare sayısı elde ettik. Bu kısma
	daha sonra yöntemler ve program mimarisinde daha detaylıca
	değinilecektir. Oyunun sınıf yapısı daha önceden belli bir
	patternde bize verilmişti ve buradaki metotları düzenleyerek ya
	da ekleme yaparak genel yapıyı oluşturduk. Oyunun temelde bir
	kart oyunu olması sebebiyle kartların bir veri yapısında
	tutulması gerekiyordu, bunun için çeşitli alternatifler olmasına
	karşın biz hem gerçeklemesinin daha kolay olmasıyla hem de kart
	listelerini daha iyi modellediğini düşünmemizden ötürü
	arraylist yapısını kullanmayı tercih ettik.  Oyun yapısal
	olarak bir pencere içerisindeki tek bir panelde her sahne için
	farklı bir oyun mantığı ve render metodu çalıştırarak
	çalışıyor. Temelde mevcut olan menü, bilgisayar – bilgisayar
	ve kullanıcı – bilgisayar sahneleri için aynı metotlar farklı
	logicler ve render işlemlerini gerçekleştirerek sahneler
	oluşturuluyor. Bunun sebebi ise oyun sahneleri içerisinde farklı
	işlemlerin gerçekleştirilmesi. Kullanıcı – bilgisayar
	sahnesinde kullanıcı bilgisayara karşı oynuyorken,  bilgisayar -
	bilgisayar sahnesinde  kullanıcı girişi olmuyor ve bilgisayar
	nesneleri kendi kendilerine oyun döngüsünü ilerletiyorlar.</P>
	<H1 LANG="en-US" CLASS="western">II.Yöntemler ve program mimarisi</H1>
	<P LANG="en-US" CLASS="western">B<SPAN LANG="tr-TR">u kısımda
	programın farklı özelliklerini oluşturmak için kullandığımız
	araçlar ve yöntemler üzerinde durularak ayrıntılı olarak bilgi
	verilecektir ve program mimarisi daha detaylı bir şekilde
	açıklanacaktır.</SPAN></P>
	<H2 LANG="en-US" CLASS="western">A.Arayüz Programlama</H2>
	<P LANG="en-US" CLASS="western"><SPAN LANG="tr-TR">Program ilk
	oluşturulurken bir adet JFrame objesi içerisine JPanel nesnesini
	extend eden Oyun sınıfını ekleyerek temel pencereyi oluşturuyor.
	Bu aşamadan sonra herhangi bir JFrame ya da JPanel nesnesi
	kullanılmıyor ve mevcut olan pencere ve panel çeşitli oyun
	sahneleri için farklı mantık ve render metotlarıyla sürekli
	olarak güncellenerek temel pencere yapısı oluşturuluyor. Oyun
	sınıfı, oyunun tüm genel işleyişini yürüttüğü gibi tüm
	genel çizim fonksiyonlarını da içerisinde barındırıyor.
	Böylece oyun sınıfının daha sonra bahsedilecek olan basit oyun
	döngüsü içerisinde ayarla, güncelle ve paint gibi metotları
	çağırılarak oyun mantığı ve çizim akışı sağlanıyor.
	Panel içerisinde çeşitli sahnelerin çizdirilmesi ve kontrolü
	için sahne adlı değişken kullanılıyor, bu değişken mevcut
	olan sahneyi tutuyor ve oyun döngüsü içerisindeki işlemler bu
	sahneye göre gerçekleştiriliyor. Böylece ekrana şu anda
	bulunulan sahne yansıtılmış oluyor. Oyunun çeşitli
	sahnelerinde örneğin; Kullanıcı – bilgisayar ve bilgisayar –
	bilgisayarda oyun sonunda tekrar menüye dönüş işleminde halen
	aynı döngü içerisinde bulunduğumuz için oyun akışının
	bozulmaması için ayarla adında bir metot yardımı ile oyun
	döngüsünde kullanılan değişkenlere tekrar atama yapılarak
	sahnelerin sıfırlanması sağlanıyor. Yukarıda bahsettiğimiz
	gibi oynanışın sürdüğü iki adet temel sahne bulunmakta.
	Kullanıcı – bilgisayar ve bilgisayar - bilgisayarda her ne kadar
	oyun mantığı farklı olsa da arayüz konusunda oldukça benzer
	şekilde gerçekleşmektedirler. Burada temel mantık panel
	işlevimizi gören Oyun sınıfındaki paint metodu kullanarak
	çizimin gerçekleşmesi. Buradaki Graphics nesnesi çeşitli
	metotlara argüman olarak gönderilip, işleniyor ve panel
	üzerindeki görüntü güncellenmiş oluyor. Arayüz içerisinde
	JFrame ve JPanel haricinde herhangi bir swing ya da awt nesnesi
	kullanılmayıp tüm çizimler Graphics objesi üzerinden panele
	yapılıyor. Böylece bu nesnelerin eventlerini de kullanmayarak
	daha sonra bahsedeceğimiz döngüler içerisinde kendi mantığımızı
	oluşturup kullanıyoruz.</SPAN> 
	</P>
	<H2 LANG="en-US" CLASS="western">B.Sınıf ve Nesne Yapısı</H2>
	<P LANG="tr-TR" CLASS="western">Projenin gerçekleştirilmesinde
	Java programlama dilini ve nesneye yönelik programlama prensibini
	kullandığımız için bu kısımda sınıf ve nesne yapısı daha
	detaylı açıklanacaktır. Öncelikle oyunun ana paneli olan ve
	çeşitli ana fonksiyonlarının yürütüldüğü bir Oyun sınıfı
	bulunmaktadır. Bu sınıfın herhangi bir nesnesi türetilmeyip    
	   genellikle metotları ve değişkenleri statik metotlardır.     
	   En önemli görevi temel oyun yapısını barındıran sınıf
	olmasıdır diğer tüm sınıflardan türeyen nesneler bu sınıfta
	işlenerek oyun ortaya çıkmaktadır. Oyun sınıfı ayrıca
	içerinde main metodunu da barındırmaktadır. Main metodu
	içerisinde basit oyun döngüsünü barındırmaktadır ve bu döngü
	içerisinde Oyun sınıfının içerisindeki oyun mantığı ve
	render metotlarını çağırır. Oyun sınıfı ayrıca oyun
	içerisinde kullanılan çoğu değişkeni ve sabiti de statik bir
	şekilde içermektedir böylece diğer sınıflardan ulaşılıp
	kullanılabilmektedirler. Onun dışında temel sınıflarımızdan
	birisi Oyuncu sınıfıdır bu sınıf oyun içerisindeki
	oyuncuların özelliklerini ve metotlarını barındırmaktadır ve
	abstract bir sınıftır ve abstract bir metodu bulunmaktadır. Bu
	metot kartSec() metodudur. Sebebi ise oyun içerisinde Oyuncu
	sınıfını extend eden iki farklı oyuncu yapısının
	bulunmasıdır. bilgisayar ve insan oyuncusu için iki farklı sınıf
	bulunmaktadır bu sınıflar Oyuncu sınıfından türemiştir ve
	abstract olan kartSec() metodunu doldurmak zorundadır. Bunun sebebi
	ise bilgisayar ve insan için oyun döngüsü içerisinde
	gerçekleşen farklı kart seçme mekanizmalarıdır. Onun haricinde
	ikisinin ortak olarak override ettiği metotlarda bulunmaktadır.
	Bunun haricinde bir diğer temel sınıfımız ise Pokemon
	sınıfıdır. Pokemon sınıfı oyun içerisinde bulunan kartların
	türetildiği en genel sınıftır. Bu sınıf kartlara birçok
	özelliği miras bırakmaktadır. Daha sonra on adet Pokemon sınıfı
	üzerinden bu karta ek olarak yeni özellikler ve metotlar
	tanımlanarak yine bu kart extend edilerek oluşturulacaklardır.
	Burada bize verilen patternde on adet Pokemon için Pokemon ana
	sınıfında bulunmayan bazı özellikler de tanımlanmıştır. Bu
	özelliklere erişimi için çeşitli yerlerde çok biçimlilik
	uygulamaları kullanılması gerekmektedir. Verilen pattern dışında
	bir de basit bir PokeTopu sınıfı bulunmaktadır bu sınıfın
	amacı sadece menü içerisinde bulunan animasyonun temel nesnesi
	olmasıdır. Tam olarak program içerisinde bulunan sınıfların
	listesi şu şekildedir: Oyun, PokeTopu, Pokemon, Bulbasaur,
	Butterfree, Charmander, Jigglypuff, Meowth, Pikachu, Psyduck,
	Snorlax, Squirtle, Zubat, Oyuncu, InsanOyuncusu,  
	BilgisayarOyuncusu. Sınıflara ait ‘UML Sınıf Diyagramı’ ek
	olarak raporda verilmiştir.</P>
	<H2 LANG="en-US" CLASS="western">C.Oyun Döngüsü ve Oyun Mantığı</H2>
	<P LANG="tr-TR" CLASS="western">En başta da bahsettiğimiz gibi
	oyun mantığının işleyişi için elimizde birkaç farklı
	alternatif bulunmaktaydı. Öncelikli olarak eğer swing ya da awt
	elemanlarını kullanarak bir arayüz gerçekleştirseydik. Bu
	elemanların bağlı olduğu eventlerin yardımı ile kolayca oyun
	işleyişini gerçekleyebilirdik ama bizim tercih ettiğimiz yöntem
	bir oyun döngüsü kullanmak oldu. Yine bu noktada elimizde birden
	fazla alternatifler bulunmaktaydı; sabit zamanlı oyun döngüsü,
	değişken zamanlı oyun döngüsü, yarı sabit zamanlı oyun
	döngüsü, serbest fizik oyun döngüsü gibi ama oyunumuzun basit
	bir kart oyunu olması sebebiyle oyun döngüsünü basit tutarak
	“Ne kadar hızlı çalışabilirsen çalış.” Mantığı
	üzerinden bir oyun döngüsü yazarak thread fonksiyonlarından
	faydalanarak bu döngüyü her seferinde on milisaniye uyutmayı
	tercih ettik. Böylece işlemlerin gerçekleştiği en iyi senaryoda
	programımız en fazla yüz kare hızına çıkabilecek ve bu da
	bizim istediğimiz işlemleri ve animasyonları
	gerçekleştirebilmemizi sağlayacaktı. Oyun döngüsü sonsuz bir
	döngü içerisinde başlıyor ve önce oyun mantığının
	yürütüldüğü ve Oyun sınıfında bulunan güncelle() metodunu
	çağırıyor oyun mantığı güncellendikten sonra ise render
	işlemini yapan panel metodu olan ve override ettiğimiz paint()
	metodunun yürütülmesi için repaint metodunu çağırıyor
	ardından ise threadi on milisaniye uyutarak kare hızımızın
	kontrolünü sağlıyor. Döngü içerisinde herhangi bir çıkış
	şartı bulunmuyor. Programın terminate işlemi Oyun sınıfı
	tarafından gerçekleştirilene kadar oyun döngüsü sonsuz bir
	şekilde çalışıyor. Oyun döngümüz en iyi ihtimalle yüz kare
	hızı üzerinden çalıştığı için oyun mantığındaki tüm
	işlemlerde saniyede yüz kez çalışıyor. Burada oyun mantığının
	sağlanması için çeşitli flag değerleri ve zamanlayıcılarla
	program akışı kontrol edilerek işlemlerin kare hızı kadar
	gerçekleştirilmesi engelleniyor çünkü kart oyununda
	etkileşimler ile gerçekleşen işlemler kullanılmasına karşın
	sürekli bir görüntü yenilenmesi elde etmeyi hedeflemiştik. Oyun
	mantığı kartların ayarlanması, dağıtılması, karıştırılması,
	kart seçilmesi, savaş işlemi, skorların güncellenmesi, oyun
	sonunun kontrolü gibi çok çeşitli işlemleri yürütüp her
	karede bunların akışını kontrol ediyor. Onun haricinde render
	işlemini yaptığımız paint() metodu ise menü, oyun arka planı,
	butonlar, kartlar, skorlar gibi tüm ögelerin ekrana sürekli
	olarak çizilmesini sağlıyor ayrıca menüde Poketopu animasyonun
	çizilmesini gerçekleştiriyor.</P>
	<P LANG="tr-TR" CLASS="western"><BR><BR>
	</P>
	<P LANG="en-US" CLASS="western" STYLE="text-indent: 0in">   
	<IMG SRC="http://burakcantemizel.com/resimler/pok3.png" NAME="graphics1" ALIGN=BOTTOM BORDER=0></P>
	<P ALIGN=CENTER STYLE="text-indent: 0in; margin-top: 0.17in; margin-bottom: 0.17in; line-height: 90%">
	<FONT FACE="Symbol, serif"><FONT FACE="Times New Roman, serif"><I>Basit
	Oyun Döngüsü Diyagramı</I></FONT></FONT></P>
	<H2 LANG="en-US" CLASS="western">D.Kullanılan Temel Veri Yapıları</H2>
	<P LANG="tr-TR" CLASS="western">Oyun mekaniği kurulurken sürekli
	olarak kartlarla çeşitli işlemler gerçekleştirilmesi
	gerekiyordu. Burada kartları saklamak için bir veri yapısı
	kullanmamız gerekiyordu. Dizi kullanmak yerine ArrayListleri
	kullanmayı tercih ettik. Bu seçim peşinde birçok mekaniği de
	getirmiş oldu. Örnek olarak kartları dinamik bir ArrayListte
	tutmanın bize en büyük getirilerinden biri çizim aşamasında
	oldu. Bir döngü içerisinde belli koordinat hesaplamalarıyla
	listenin o an sahip olduğu kart adetine göre çizim işlemlerini
	tek bir fonksiyon içerisinde gerçekleştirdik. Böylece kaç adet
	kart olursa olsun her seferinde ekranın belirli bir bölgesine
	kendi kendini ortalayarak çizim fonksiyonu tarafından
	çizdirilebilir hale geldi. ArrayList ile kart listelerini
	gerçeklemenin en büyük artılarından biri de objeleri tuttuğumuz
	için gerçekten de bir kart oyununda olduğu gibi bir desteden
	diğerine kart aktarma kartların adetinin bu şekilde dinamik
	olarak artması ve azalması gerçek bir modelleme gibi olmasını
	sağladı. ArrayList ile işlem yaparken bazı noktalarda Java’nın
	hazır fonksiyonlarından da faydalandık örneğin; Collections
	sınıfının shuffle metodu yardımı ile ArrayListi rastgele bir
	şekilde karıştırdık.</P>
	<H2 LANG="en-US" CLASS="western">E.Dosya İşlemleri</H2>
	<P CLASS="western" ALIGN=JUSTIFY STYLE="margin-bottom: 0in; line-height: 100%">
	Projeyi gerçekleştirirken klasik Java arayüz componentlerinin
	aksine kendi görsel dosyalarımızı çizdirerek daha çarpıcı ve
	güzel bir arayüz oluşturmayı hedeflemiştik. Bu yüzden harici
	olarak grafik dosyalarını dizinden almamız ve çeşitli render
	metotlarımızla çizdirmemiz gerekiyordu. Bunun için önce grafik
	metotlarını daha sonra grafik dosyalarını hazırladık. Sıra
	program akışının başında bu dosyaları yüklemeye geldiğinde
	karşımıza bir takım dizin işlemi çıktı. Dosyaları yüklemek
	için birçok farklı alternatifimiz olduğunu gördük fakat biz
	Java’nın File sınıfından yardım alarak yüklemeyi seçtik.
	Burada url ve göreceli olmak üzere iki farklı dizin yolu
	karşımıza çıktı. Yüklemeyi yaparken istersek direct olarak
	dosyanın geçerli sistemdeki adresini ve File sınıfını
	kullanarak yüklemesini gerçekleştirebiliyorduk fakat böyle bir
	durumda proje kaynak dosyası farklı bir sisteme taşındığı
	zaman aynı klasörün o sistemde de bulunması gerekiyordu. Böyle
	bir sorunla karşılaşmamak için göreceli dosya yolu sistemini
	kullanmaya karar verdik. Burada File sınıfına herhangi bir adres
	bilgisi verilmediği zaman Projemizin kök dizininde src klasörünün
	yanına klasör imlecini otomatik olarak yerleştirip dosya
	okumasını oradan gerçekleştirildiğini gördük. Javanın
	paketli proje yapısında src dizininden üst dizinlere çıkılması
	gerekiyordu, (kaynak dosyalarımızın proje kök dizininin içinde
	olduğunu varsayarsak) fakat bir herhangi bir paket kullanmadığımız
	için zaten src klasörünün bulunduğu konum kök dizinimiz
	oluyordu ve buradan kaynaklar klasörünü okuyarak dosya
	yüklemelerimizi gerçekleştirebildik.</P>
	<P CLASS="western" ALIGN=JUSTIFY STYLE="margin-left: 0.2in; text-indent: 0in; margin-bottom: 0in; line-height: 100%">
	<BR>
	</P>
	<H1 LANG="en-US" CLASS="western">III.Geliştirme ortamı ve
	kullanılan dil</H1>
	<P LANG="tr-TR" CLASS="western">Projeyi Java programlama dilinde
	Windows işletim sistemi üzerinde gerçekleştirirken, geliştirme
	ortamı olarak 11.0.2 JDK konfigürasyonlu Intellij Idea idesini
	kullandık. Kaynak dosyaları Intellij Idea proje formatına
	sahiptir.</P>
	<H1 LANG="en-US" CLASS="western">IV.PROGRAMIN GENEL YAPISI VE
	TASARIMI</H1>
	<P CLASS="western" ALIGN=LEFT STYLE="text-indent: 0.5in; margin-bottom: 0in; line-height: 100%">
	Program temel olarak menü, kullanıcı – bilgisayar ve bilgisayar
	– bilgisayar olmak üzere üç adet sahne içeriyor. Her sahne
	farklı bir tasarıma sahip ve basit bir sahne yöneticisi
	aracılığıyla sahneler arası geçiş gerçekleştiriliyor.</P>
	<P CLASS="western" ALIGN=LEFT STYLE="text-indent: 0.5in; margin-bottom: 0in; line-height: 100%">
	<BR>
	</P>
	<P CLASS="western" ALIGN=LEFT STYLE="text-indent: 0in; margin-bottom: 0in; line-height: 100%">
	.</P>
	<P CLASS="western" ALIGN=CENTER STYLE="text-indent: 0in; margin-bottom: 0in; line-height: 100%">
	<IMG SRC="http://burakcantemizel.com/resimler/pok1.png" NAME="graphics2" ALIGN=BOTTOM  BORDER=0><I>Oyun
	Menüsünün Genel Tasarımı</I></P>
	<P CLASS="western" ALIGN=CENTER STYLE="text-indent: 0in; margin-bottom: 0in; line-height: 100%">
	<BR>
	</P>
	<P CLASS="western" ALIGN=CENTER STYLE="text-indent: 0in; margin-bottom: 0in; line-height: 100%">
	<IMG SRC="http://burakcantemizel.com/resimler/pok2.png" NAME="graphics3" ALIGN=BOTTOM  BORDER=0><I>Sunum
	Modu Açık iken Oyun İçi Tasarım</I></P>
	<P CLASS="western" ALIGN=CENTER STYLE="text-indent: 0in; margin-bottom: 0in; line-height: 100%">
	<BR>
	</P>
	<H1 LANG="en-US" CLASS="western">V.Deneysel sonuçlar</H1>
	<P LANG="tr-TR" CLASS="western">Bu projeyle birlikte oyun
	döngülerinin işleyişi, döngünün fiziksel hesaplara ve
	etkileşimlere etkisi, kare hızının çizimlere etkisi gibi birçok
	şeyi gözlemledik. Kaynak görsel dosyalarımızı yüklerken dizin
	işlemlerini gerçekleştirmek için Java’nın proje dizin yapısı
	hakkında pek çok şey öğrendik. Göreceli dizin yolundan dosya
	yüklemeyi gerçekleştirdik. Java awt ve swing sınıflarının
	hiyerarşisi, arayüz modüllerini öğrenirken oyun döngümüzde
	ihtiyaç duyduğumuz inputları almak için Java’nın event
	sistemlerinden yardım aldık görecelide olsa bu eventleri
	kullanarak ana threadimizde çalışan oyun döngümüze çeşitli
	input girişleri yolladık ve bunları oyun akışı için
	kullandık. Nesneye yönelik programlama konseptlerinde pek çok
	bilgi edindik. Pokemon sınıfını extend eden diğer subclasslara
	Pokemon tipinde nesnelerden erişirken bazı zamanlar çok
	biçimlilik, Oyuncu ve Pokemon yapısında kalıtım, tüm sınıflar
	için kapsülleme ve eventleri çağırmak için interface
	yapılarını kullandık ve uyguladık. Oyun mantığını
	işletirken ArrayList veri yapısını çok çeşitli metotlarıyla
	kullanma fırsatını bulduk.</P>
	<H1 LANG="en-US" CLASS="western">VI.sonuç</H1>
	<P CLASS="western" ALIGN=JUSTIFY STYLE="margin-bottom: 0in; line-height: 100%">
	Bu projeyi gerçekleştirerek basit bir oynanışa sahip olsa da tam
	olarak ortaya bir son ürün çıkartmayı başardık. Bir önceki
	projenin aksine son kullanıcıya daha uygun bir Kullanıcı
	arayüzüne sahip ve kullanıcının daha kolay etkileşime
	girebileceği bir uygulama gerçekleştirdik.</P>
	<P CLASS="western" ALIGN=JUSTIFY STYLE="margin-bottom: 0in; line-height: 100%">
	<BR>
	</P>
	<H1 LANG="en-US" CLASS="western">VII.Kaynaklar</H1>
	<OL>
		<LI><P CLASS="western" ALIGN=JUSTIFY STYLE="text-indent: 0in; margin-bottom: 0in; line-height: 100%">
		https://gameprogrammingpatterns.com/game-loop.html</P>
		<LI><P CLASS="western" ALIGN=JUSTIFY STYLE="text-indent: 0in; margin-bottom: 0in; line-height: 100%">
		https://docs.oracle.com/javase/tutorial/2d/images/loadimage.html</P>
	</OL>
</DIV>
<DIV ID="Section4" DIR="LTR">
	<P CLASS="western" ALIGN=JUSTIFY STYLE="text-indent: 0in; margin-bottom: 0in; line-height: 100%">
	<BR>
	</P>

	      
</DIV>
<DIV TYPE=FOOTER>

</DIV>
</BODY>
</HTML>
