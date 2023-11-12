 public class MemberPlatinum implements Member, CanGetDiskon,CanRequestDelivery,CanRequestCicilan,CanDeposit{
        private Integer poin;
        private double saldoDeposit;
      
        public MemberPlatinum(int jarakTempuh, double saldoAwal) {
            this.poin = 0;
            this.saldoDeposit = saldoAwal;
        }
      
        public MemberPlatinum() {
        }

        public void belanja(double jumlahBelanja) {
            this.poin += (int) (jumlahBelanja / 10000); 
        }
      
        public void redeemPoin(Integer jumlahPoin) {
            if (jumlahPoin <= poin) {
                this.poin -= jumlahPoin;
        }
    }
         public Integer getSaldo() {
          return getSaldo();
         }
      
        public Integer getPoin() {
          return this.poin;
      }
      
        public Integer hitungTotalBayar(Integer totalBelanja) {
              double diskon = 0;
              
              if (totalBelanja >= 500000 && totalBelanja < 1000000) {
                  diskon = 0.03; 
                  totalBelanja=(int) (totalBelanja * (1 - diskon));
                  this.poin+=totalBelanja/10000;
              } else if (totalBelanja >= 1000000 && totalBelanja < 7000000) {
                  diskon = 0.05;
                  totalBelanja=(int) (totalBelanja * (1 - diskon));
                  this.poin+=totalBelanja/10000;
              } else if (totalBelanja >= 7000000 && totalBelanja <=10000000) {
                  diskon = 0.07; 
                  totalBelanja=(int) (totalBelanja * (1 - diskon));
                  this.poin+=totalBelanja/10000;
              } else if (totalBelanja >=10000000) {
                  diskon = 0.09; 
                  totalBelanja=(int) (totalBelanja * (1 - diskon));
                  this.poin+=totalBelanja/10000;
              } 
              else {
                  diskon=0;
                  totalBelanja=(int) (totalBelanja*1);
                  this.poin+=totalBelanja/10000;
              }
              return totalBelanja;
        }
      
              public Double hitungOngkir(Double jarak) {
                  Double ongkir;
                  if(jarak>10){
                      if(jarak%1!=0){
                      ongkir=(jarak-9-(jarak%1))*1000;
                      }
                      else{
                      ongkir=(jarak-10)*1000;
                      }
                  }
                  else{
                      ongkir=0.0;
                  }
                  return ongkir;
              }
      
              @Override
              public void deposit(Integer jumlahDeposit) {
                  this.saldoDeposit += jumlahDeposit;
                  System.out.println("Deposit berhasil: " + jumlahDeposit);
              }
      
        @Override
          public void tarikTunai(Integer jumlahTarikTunai) {
              if (jumlahTarikTunai <= saldoDeposit) {
                  this.saldoDeposit -= jumlahTarikTunai;
                  System.out.println("Penarikan tunai berhasil!");
              } else {
                  System.out.println("Saldo deposit tidak mencukupi.");
              }
          }
      
        public double cekSaldo() {
            return saldoDeposit;
        }
      
      
        @Override
          public Integer hitungCicilanPerBulan(Integer totalBelanja, Integer jumlahBelanja) {
              return totalBelanja / jumlahBelanja;
          }
      }

