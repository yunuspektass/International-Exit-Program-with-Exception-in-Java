import java.util.Scanner;
import java.util.SortedMap;

class SiyasiException extends Exception{
    //check exceptiondan extendledik
    @Override
    public void printStackTrace() {
        System.out.println("Siyasi Yasağınız Bulunuyor.");
    }
}
class  VizeException extends Exception{

    @Override
    public void printStackTrace() {
        System.out.println("Gideceğiniz Ülkeye Vizeniz Bulunmamaktadır.");
    }
}
class  HarcException extends Exception{
    @Override
    public void printStackTrace() {
        System.out.println("Lütfen Yurtdışı Harcını Tam Yatırın...");
    }
}


public class Yolcu {
    private int harc;
    private boolean siyasiYasak;
    private boolean vizeDurumu;



    public Yolcu(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Yatırdığınız Harç Bedeli: ");

        this.harc = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Herhangi bir siyasi yasağınız bulunuyor mu? (evet ya da hayır) :");

        String cevap = scanner.nextLine();

        if (cevap.equals("evet") ){
            this.siyasiYasak = true;
        }
        else {
            this.siyasiYasak = false;
        }

        System.out.print("Vizeniz bulunuyor mu? (evet ya da hayır) :");

        String cevap2 = scanner.nextLine();

        if (cevap2.equals("evet") ){
            this.vizeDurumu = true;

        }
        else {
            this.vizeDurumu = false;
        }



    }


    public void yurtdisiHarciKontrol() throws HarcException  {
       if (this.harc < 15){
           throw  new HarcException();
           //check exception olduğu için yakalamamız lazım

       }
       else {
           System.out.println("Yurtdışı harcı işlemi tamamlandı.");

       }

    }


    public void siyasiYasakKontrol() throws  SiyasiException {
        if (this.siyasiYasak == true) {
            throw new SiyasiException();

        }
        else {
            System.out.println("Siyasi yasağınız bulunmuyor.");

        }
    }


    public void vizeDurumuKontrol() throws  VizeException{
        //bu metod vize exception fırlatır.
        if (this.vizeDurumu == true){

            System.out.println("Vize işlemleriniz tamamlandı.");
        }
        else {
      throw new VizeException();
        }


    }
}
