public class MemberSilver implements Member, CanGetDiskon,CanRequestDelivery {
        private Integer poin=0;

          public MemberSilver(Integer jarakTempuh) {
              this.poin = 0;
          }
      
      
          public void redeemPoin(Integer jumlahPoin) {
              if (jumlahPoin <= poin) {
                  this.poin -= jumlahPoin;
              }
          }
      
          public Integer getPoin() {
              return this.poin;
          }
      
          public Integer hitungTotalBayar(Integer totalBelanja) {
              double diskon = 0;
              
              if (totalBelanja >= 500000 && totalBelanja < 1000000) {
                  diskon = 0.01; 
                  totalBelanja=(int) (totalBelanja * (1 - diskon));
                  this.poin+=totalBelanja/10000;
              } else if (totalBelanja >= 1000000 && totalBelanja < 7000000) {
                  diskon = 0.03; 
                  totalBelanja=(int) (totalBelanja * (1 - diskon));
                  this.poin+=totalBelanja/10000;
      
              } else if (totalBelanja >= 7000000) {
                  diskon = 0.05; 
                  totalBelanja=(int) (totalBelanja * (1 - diskon));
                  this.poin+=totalBelanja/10000;
              }
              else {
                  diskon=0;
                  this.poin+=totalBelanja/10000;
              }
              return totalBelanja;
          }
      
          public Double hitungOngkir(Double jarak) {
              Double ongkir;
              if(jarak>5){
                  if(jarak%1!=0){
                  ongkir=(jarak-4-(jarak%1))*1500;
                  }
                  else{
                  ongkir=(jarak-5)*1500;
                  }
              }
              else{
                  ongkir=0.0;
              }
              return ongkir;
          }
      }