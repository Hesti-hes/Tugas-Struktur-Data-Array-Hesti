# ================= HEADER IDENTITAS =================
print("\n=================================================")
print("            TUGAS STRUKTUR DATA ARRAY            ")
print("=================================================")
print(" Nama    : Hesti Febriyani")
print(" Kelas   : Informatika A")
print(" NIM     : 24106050010")
print(" Matkul  : Struktur Data")
print("=================================================")
input(" >> Tekan ENTER untuk masuk ke Menu Program...")

# Inisialisasi Array 2D (10 baris, 2 kolom) dengan nilai None
# Di Python, ini cara membuat fixed-size array manual
data = [[None for _ in range(2)] for _ in range(10)]
count = 0
capacity = 10
pilihan = 0

while pilihan != 9:
    print(f"\n=== MENU MAHASISWA (Count: {count}/{capacity}) ===")
    print("1. Insert at beginning    4. Delete from beginning")
    print("2. Insert at position     5. Delete given position")
    print("3. Insert at end          6. Delete from end")
    print("7. Delete first (NIM)     8. Show data")
    print("9. Exit")
    
    try:
        pilihan = int(input("Pilih menu: "))
    except ValueError:
        print("!! Masukkan angka 1-9 !!")
        continue

    if pilihan == 1 or pilihan == 2 or pilihan == 3:
        if count < capacity:
            # Tentukan posisi
            if pilihan == 1:
                target_pos = 0
            elif pilihan == 3:
                target_pos = count
            else:
                target_pos = int(input(f"Masukkan posisi index (0-{count}): "))

            if 0 <= target_pos <= count:
                nim = input("Masukkan NIM : ")
                nama = input("Masukkan Nama: ")

                # LOGIKA GESER KANAN (Shifting Manual)
                # Dimulai dari belakang ke depan
                for i in range(count, target_pos, -1):
                    data[i][0] = data[i-1][0]
                    data[i][1] = data[i-1][1]
                
                data[target_pos][0] = nim
                data[target_pos][1] = nama
                count += 1
                print("Data berhasil ditambahkan.")
            else:
                print("!! Posisi tidak valid !!")
        else:
            print("!! Array Penuh !!")

    elif pilihan == 4: # Delete beginning
        if count > 0:
            # LOGIKA GESER KIRI (Manual)
            for i in range(0, count - 1):
                data[i][0] = data[i+1][0]
                data[i][1] = data[i+1][1]
            count -= 1
            print("Data index 0 berhasil dihapus.")
        else:
            print("!! Data Kosong !!")

    elif pilihan == 5: # Delete given position
        if count > 0:
            d_pos = int(input("Masukkan index yang dihapus: "))
            if 0 <= d_pos < count:
                for i in range(d_pos, count - 1):
                    data[i][0] = data[i+1][0]
                    data[i][1] = data[i+1][1]
                count -= 1
                print(f"Data index {d_pos} berhasil dihapus.")
            else:
                print("!! Index tidak valid !!")

    elif pilihan == 6: # Delete end
        if count > 0:
            count -= 1
            print("Data terakhir berhasil dihapus.")
        else:
            print("!! Data Kosong !!")

    elif pilihan == 7: # Delete first occurrence (NIM)
        if count > 0:
            s_nim = input("Masukkan NIM yang ingin dihapus: ")
            idx_ketemu = -1
            # Cari manual
            for i in range(count):
                if data[i][0] == s_nim:
                    idx_ketemu = i
                    break
            
            if idx_ketemu != -1:
                for i in range(idx_ketemu, count - 1):
                    data[i][0] = data[i+1][0]
                    data[i][1] = data[i+1][1]
                count -= 1
                print(f"NIM {s_nim} berhasil dihapus.")
            else:
                print("!! NIM tidak ditemukan !!")

    elif pilihan == 8: # Show data
        print("\n--- DAFTAR DATA MAHASISWA ---")
        if count == 0:
            print("Data masih kosong.")
        for i in range(count):
            print(f"[{i}] NIM: {data[i][0]} | Nama: {data[i][1]}")

    elif pilihan == 9:
        print("Keluar dari program... Sampai jumpa Hesti!")

    else:
        print("!! Menu tidak valid !!")

print("Program Selesai.")