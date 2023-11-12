public interface CanDeposit {
  void deposit(Integer jumlahDeposit);
  void tarikTunai(Integer jumlahTarikTunai);
  Integer getSaldo();
}