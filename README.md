# Bank Account System (Java OOP)

Sistem perbankan berbasis CLI yang menerapkan enkapsulasi, komposisi class, dan validasi data.

## Desain Class
- **Customer**: Menyimpan profil nasabah.
- **Account**: Class utama dengan 5 atribut private untuk menjaga integritas saldo.
- **Transaction**: Komponen untuk merekam jejak transaksi (_Composition_).
- **BankApp**: Class interaktif dengan sistem menu.

## Fitur Validasi Pada Dua Method Tertentu dan Satu Setter Method
1. **Deposit**: Minimal harus positif.
2. **Withdraw**: Tidak bisa melebihi saldo.
3. **PIN**: Wajib 6 digit angka.