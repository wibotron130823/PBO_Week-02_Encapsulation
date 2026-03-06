import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("   SELAMAT DATANG DI BANK SYSTEM    ");
        System.out.println("====================================");

        // Tahap Registrasi
        System.out.print("Masukkan Nama Nasabah : ");
        String name = scanner.nextLine();
        System.out.print("Masukkan NIK          : ");
        String nik = scanner.nextLine();

        Customer nasabah = new Customer(name, nik);
        Account myAccount = new Account("ACC-1001", nasabah);

        System.out.print("Buat PIN (6 digit)    : ");
        myAccount.setPin(scanner.nextLine());

        // Tahap Transaksi
        boolean isRunning = true;
        while (isRunning) {
            printMenu();
            System.out.print("Pilih opsi (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    handleDeposit(scanner, myAccount);
                    break;
                case 2:
                    handleWithdraw(scanner, myAccount);
                    break;
                case 3:
                    showAccountInfo(myAccount);
                    break;
                case 4:
                    isRunning = false;
                    System.out.println("\nTerima kasih telah bertransaksi!");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia, silakan coba lagi.");
                    break;
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n--- MENU LAYANAN ---");
        System.out.println("1. Deposit Tunai");
        System.out.println("2. Tarik Tunai");
        System.out.println("3. Cek Saldo & Riwayat");
        System.out.println("4. Keluar");
    }

    private static void handleDeposit(Scanner sc, Account acc) {
        System.out.print("Masukkan nominal deposit: Rp");
        acc.deposit(sc.nextDouble());
    }

    private static void handleWithdraw(Scanner sc, Account acc) {
        System.out.print("Masukkan nominal penarikan: Rp");
        acc.withdraw(sc.nextDouble());
    }

    private static void showAccountInfo(Account acc) {
        System.out.println("\n--- RINGKASAN AKUN ---");
        System.out.println("Saldo Terkini: Rp" + acc.getBalance());
        System.out.println("Riwayat Transaksi:");
        acc.printHistory();
    }

}