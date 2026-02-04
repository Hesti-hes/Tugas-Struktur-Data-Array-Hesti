public class tugashesti {
    public static void main(String[] args) throws java.io.IOException {
        // Kapasitas 10 baris, 2 kolom (NIM & Nama)
        String[][] data = new String[10][2];
        int count = 0; //
        int capacity = 10;
        int pilihan = 0;

        // ================= HEADER IDENTITAS =================
        System.out.println("\n=================================================");
        System.out.println("            TUGAS STRUKTUR DATA ARRAY            ");
        System.out.println("=================================================");
        System.out.println(" Nama    : Hesti Febriyani");
        System.out.println(" Kelas   : Informatika A");
        System.out.println(" NIM     : 24106050010"); 
        System.out.println(" Matkul  : Struktur Data");
        System.out.println("=================================================");
        System.out.println(" >> Tekan ENTER untuk masuk ke Menu Program...");
        
        while (System.in.read() != '\n');

        // Loop berjalan selama pilihan bukan 9
        while (pilihan != 9) {
            System.out.println("\n=== MENU MAHASISWA (Count: " + count + "/" + capacity + ") ===");
            System.out.println("1. Insert at beginning    4. Delete from beginning");
            System.out.println("2. Insert at position     5. Delete given position");
            System.out.println("3. Insert at end          6. Delete from end");
            System.out.println("7. Delete first (NIM)     8. Show data");
            System.out.println("9. Exit");
            System.out.print("Pilih menu: ");

            int inputChar = System.in.read();
            pilihan = inputChar - '0';
            while (System.in.read() != '\n'); 

            switch (pilihan) {
                case 1: case 2: case 3:
                    if (count < capacity) {
                        int targetPos = (pilihan == 1) ? 0 : (pilihan == 3) ? count : -1;
                        if (pilihan == 2) {
                            System.out.print("Masukkan posisi index (0-" + count + "): ");
                            int pChar = System.in.read();
                            targetPos = pChar - '0';
                            while (System.in.read() != '\n');
                        }
                        if (targetPos >= 0 && targetPos <= count) {
                            System.out.print("Masukkan NIM : ");
                            String nim = ""; int c;
                            while ((c = System.in.read()) != '\n' && c != '\r') { nim += (char) c; }
                            if (c == '\r') System.in.read();

                            System.out.print("Masukkan Nama: ");
                            String nama = "";
                            while ((c = System.in.read()) != '\n' && c != '\r') { nama += (char) c; }
                            if (c == '\r') System.in.read();

                            for (int i = count; i > targetPos; i--) {
                                data[i][0] = data[i-1][0];
                                data[i][1] = data[i-1][1];
                            }
                            data[targetPos][0] = nim;
                            data[targetPos][1] = nama;
                            count++; //
                            System.out.println("Data berhasil ditambahkan.");
                        }
                    } else { System.out.println("!! Array Penuh !!"); }
                    break;

                case 4: // Delete from beginning
                    if (count > 0) {
                        for (int i = 0; i < count - 1; i++) {
                            data[i][0] = data[i+1][0];
                            data[i][1] = data[i+1][1];
                        }
                        count--; //
                        System.out.println("Data index 0 berhasil dihapus.");
                    }
                    break;

                case 5: // Delete given position
                    if (count > 0) {
                        System.out.print("Masukkan index yang dihapus: ");
                        int dPos = System.in.read() - '0';
                        while (System.in.read() != '\n');
                        if (dPos >= 0 && dPos < count) {
                            for (int i = dPos; i < count - 1; i++) {
                                data[i][0] = data[i+1][0];
                                data[i][1] = data[i+1][1];
                            }
                            count--; //
                        }
                    }
                    break;

                case 6: // Delete from end
                    if (count > 0) {
                        count--; //
                        System.out.println("Data terakhir berhasil dihapus.");
                    }
                    break;

                case 7: // Delete first occurrence (NIM)
                    if (count > 0) {
                        System.out.print("Masukkan NIM yang ingin dihapus: ");
                        String sNim = ""; int baca;
                        while ((baca = System.in.read()) != '\n' && baca != '\r') { sNim += (char) baca; }
                        if (baca == '\r') System.in.read();
                        int idxKetemu = -1;
                        for (int i = 0; i < count; i++) {
                            if (data[i][0] != null && data[i][0].equals(sNim)) {
                                idxKetemu = i; break;
                            }
                        }
                        if (idxKetemu != -1) {
                            for (int i = idxKetemu; i < count - 1; i++) {
                                data[i][0] = data[i+1][0];
                                data[i][1] = data[i+1][1];
                            }
                            count--; //
                            System.out.println("NIM " + sNim + " berhasil dihapus.");
                        }
                    }
                    break;

                case 8: // Show data
                    System.out.println("\n--- DAFTAR DATA MAHASISWA ---");
                    if (count == 0) System.out.println("Data masih kosong.");
                    for (int i = 0; i < count; i++) {
                        System.out.println("[" + i + "] NIM: " + data[i][0] + " | Nama: " + data[i][1]);
                    }
                    break;

                case 9: // Exit
                    System.out.println("Keluar dari program... Sampai jumpa Hesti!");
                    break;

                default:
                    System.out.println("!! Menu tidak valid !!");
                    break;
            }
        }
    }
}