# Student Management (Java + MySQL)

A simple console-based Student Management application (Add / View students) using JDBC and MySQL.

## Prerequisites

- JDK 17+ installed (`java -version`, `javac -version`)
- MySQL Server running
- MySQL Connector/J jar placed in `lib/`

## Database

This app connects to a MySQL database named `student_db`.

- The database is auto-created if missing (based on the JDBC URL).
- The `students` table is auto-created on startup.

## Configuration (recommended: environment variables)

Set these environment variables before running:

- `MYSQL_URL`
  - Default: `jdbc:mysql://localhost:3306/student_db?createDatabaseIfNotExist=true`
- `MYSQL_USER`
  - Default: `root`
- `MYSQL_PASSWORD`
  - Default: empty

### Windows PowerShell (current terminal session)

```powershell
$env:MYSQL_URL = "jdbc:mysql://localhost:3306/student_db?createDatabaseIfNotExist=true"
$env:MYSQL_USER = "root"
$env:MYSQL_PASSWORD = "YOUR_PASSWORD"
```

## Build & Run

From the project folder:

### Compile

```powershell
javac -cp ".;lib/*" Student.java DBConnection.java StudentDAOImpl.java Main.java
```

### Run

```powershell
java -cp ".;lib/*" Main
```

## Notes

- Do not commit database passwords into source code.
- JARs under `lib/` are ignored by git; place your MySQL connector jar locally.
