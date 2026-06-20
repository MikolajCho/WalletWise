WalletWise

A simple home expense manager — a final project for the Mobile Device Programming course.
Project Description

A mobile app for budgeting. Features include:

    Adding expenses (amount, category, description, date).

    Attaching a photo of a receipt to each expense.

    Viewing expense history categorized by month.

    Filtering expenses by category.

    Displaying statistics via a pie chart.

    Daily reminders to log expenses (notification at 8:00 PM).

Technologies Used
Element	Technology
Language	Kotlin
Database	Room (SQLite)
Notifications	WorkManager
Charts	MPAndroidChart
Architecture	MVVM (ViewModel, LiveData, Repository)
UI	Material Design 3
Hardware Features Utilized

    Camera: Utilizing system intents to take photos of receipts and save them to the app's internal storage.

    Database (Room): Persistent local data storage on the device.

    Notifications: System notification mechanism for daily user reminders.

    Data Visualization: Generating charts based on the inputted data.

Setup & Running Instructions

    Open the project in Android Studio.

    Wait for the Gradle synchronization to complete.

    Connect a physical device with USB debugging enabled or launch an emulator.

    Click the Run button (green triangle).

File Structure

app/src/main/java/com/example/walletwise/
├── data/            # Data handling (Room DB, Models, Repository)
├── ui/              # Presentation layer (Fragments, ViewModels, Adapters)
├── worker/          # Background tasks (Notifications)
└── utils/           # Helper classes (Date and currency formatting)

Project: WalletWise

Course: Mobile Device Programming

Author: Mikołaj Chodur
