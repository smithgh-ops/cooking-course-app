# Aplikasi Kursus Masak - Spring Boot Demo

Aplikasi demo Spring Boot untuk sistem manajemen kursus masak yang mencakup form input dan tabel data dengan SQLite sebagai database.

## Fitur

- **Manajemen Instruktur**: Tambah, edit, dan hapus data instruktur dengan spesialisasi masing-masing
- **Manajemen Peserta**: Kelola data peserta kursus masak
- **Manajemen Kursus**: Buat kursus dengan menghubungkan instruktur dan peserta
- **Manajemen Pembayaran**: Catat pembayaran dengan opsi Cash atau Transfer

## Struktur Class (UML)

```
Orang (Abstract)
├── nama: String
├── alamat: String
└── noHP: String

Instruktur extends Orang
├── idInstruktur: String
└── spesialisasi: String

Peserta extends Orang
└── idPeserta: String

KursusMasak
├── idKursus: String
├── namaKursus: String
├── biaya: double
├── objInstruktur: Instruktur
└── objPeserta: Peserta

Pembayaran (Abstract)
├── idPembayaran: String
├── jumlah: double
└── prosesPembayaran(): String

PembayaranCash extends Pembayaran
└── noRekening: String

PembayaranTransfer extends Pembayaran
└── jumlahTunai: double
```

## Prerequisites

- Java 17 atau lebih baru
- Maven 3.6 atau lebih baru (atau gunakan Maven Wrapper yang disertakan)

## Cara Menjalankan Aplikasi

### Menggunakan Maven Wrapper (Direkomendasikan)

```bash
# Di Linux/Mac
./mvnw spring-boot:run

# Di Windows
mvnw.cmd spring-boot:run
```

### Menggunakan Maven yang Terinstal

```bash
mvn spring-boot:run
```

### Build dan Jalankan JAR

```bash
# Build
./mvnw clean package

# Jalankan
java -jar target/cooking-course-app-0.0.1-SNAPSHOT.jar
```

## Akses Aplikasi

Setelah aplikasi berjalan, buka browser dan akses:

- **Homepage**: http://localhost:8080
- **Instruktur**: http://localhost:8080/instruktur
- **Peserta**: http://localhost:8080/peserta
- **Kursus**: http://localhost:8080/kursus
- **Pembayaran**: http://localhost:8080/pembayaran

## Database

Aplikasi menggunakan SQLite. Database akan otomatis terbuat di root project dengan nama `cooking_course.db` saat aplikasi pertama kali dijalankan.

## Tech Stack

- Spring Boot 3.2.0
- Spring Data JPA
- Thymeleaf
- SQLite
- Bootstrap 5.3
- Lombok

## Struktur Project

```
src/main/java/com/cookingcourse/
├── CookingCourseApplication.java
├── controller/
│   ├── HomeController.java
│   ├── InstrukturController.java
│   ├── PesertaController.java
│   ├── KursusMasakController.java
│   └── PembayaranController.java
├── model/
│   ├── Orang.java
│   ├── Instruktur.java
│   ├── Peserta.java
│   ├── KursusMasak.java
│   ├── Pembayaran.java
│   ├── PembayaranCash.java
│   └── PembayaranTransfer.java
├── repository/
│   ├── InstrukturRepository.java
│   ├── PesertaRepository.java
│   ├── KursusMasakRepository.java
│   └── PembayaranRepository.java
└── service/
    ├── InstrukturService.java
    ├── PesertaService.java
    ├── KursusMasakService.java
    └── PembayaranService.java

src/main/resources/
├── application.properties
└── templates/
    ├── index.html
    ├── fragments/
    │   └── layout.html
    ├── instruktur/
    │   ├── list.html
    │   └── form.html
    ├── peserta/
    │   ├── list.html
    │   └── form.html
    ├── kursus/
    │   ├── list.html
    │   └── form.html
    └── pembayaran/
        ├── list.html
        └── form.html
```

## Lisensi

MIT License
