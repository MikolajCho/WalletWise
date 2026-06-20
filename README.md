# WalletWise

Prosty menedżer wydatków domowych — projekt na zaliczenie przedmiotu Programowanie Urządzeń Mobilnych.

## Opis projektu

Aplikacja mobilna służąca do kontrolowania budżetu. Pozwala na:
- Dodawanie wydatków (kwota, kategoria, opis, data).
- Robienie zdjęcia paragonu do każdego wydatku.
- Przeglądanie historii wydatków z podziałem na miesiące.
- Filtrowanie wydatków po kategorii.
- Wyświetlanie statystyk w formie wykresu kołowego.
- Codzienne przypomnienie o wpisaniu wydatków (powiadomienie o 20:00).

## Zastosowane technologie

| Element | Technologia |
|---|---|
| Język | Kotlin |
| Baza danych | Room (SQLite) |
| Powiadomienia | WorkManager |
| Wykresy | MPAndroidChart |
| Architektura | MVVM (ViewModel, LiveData, Repository) |
| Interfejs | Material Design 3 |

## Wykorzystane funkcje urządzenia

1. **Aparat**: Wykorzystanie intencji systemowej do robienia zdjęć paragonów i zapisywania ich w pamięci aplikacji.
2. **Baza danych (Room)**: Trwałe przechowywanie danych lokalnie na urządzeniu.
3. **Powiadomienia**: Systemowy mechanizm powiadomień przypominający o obsłudze aplikacji.
4. **Wizualizacja**: Generowanie wykresów na podstawie wprowadzonych danych.

## Instrukcja uruchomienia

1. Otwórz projekt w programie Android Studio.
2. Poczekaj na zakończenie synchronizacji Gradle.
3. Podłącz telefon z włączonym debugowaniem USB lub uruchom emulator.
4. Kliknij przycisk **Run** (zielony trójkąt).

## Struktura plików

```
app/src/main/java/com/example/walletwise/
├── data/            # Obsługa danych (Baza Room, Modele, Repozytorium)
├── ui/              # Warstwa wizualna (Fragmenty, ViewModele, Adaptery)
├── worker/          # Zadania w tle (Powiadomienia)
└── utils/           # Klasy pomocnicze (Formatowanie daty, waluty)
```

## Autor

**Projekt:** WalletWise  
**Przedmiot:** Programowanie Urządzeń Mobilnych  
**Autor:** Mikołaj Chodur
