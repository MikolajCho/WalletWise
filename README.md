# 📱 WalletWise

<p align="center">
  <strong>A simple home expense manager</strong><br>
  <sub>A final project for the Mobile Device Programming course.</sub>
</p>

---

## 📝 Project Description

A sleek and intuitive mobile application designed for personal budgeting and expense tracking.

### Key Features:
*   **Expense Logging:** Easily add expenses with amount, category, description, and date.
*   **Receipt Capture:** Attach a photo of a receipt directly to each expense.
*   **Monthly History:** View your comprehensive expense history categorized by month.
*   **Smart Filtering:** Filter through your financial data by specific categories.
*   **Data Visualization:** Clear financial statistics displayed via an interactive pie chart.
*   **Daily Reminders:** Automated system notification at 8:00 PM to remind you to log your daily expenses.

---

## 🛠️ Technologies Used

| Element | Technology |
| :--- | :--- |
| **Language** | Kotlin |
| **Database** | Room (SQLite) |
| **Notifications** | WorkManager |
| **Charts** | MPAndroidChart |
| **Architecture** | MVVM (ViewModel, LiveData, Repository) |
| **UI** | Material Design 3 |

---

## ⚙️ Hardware Features Utilized

1. 📷 **Camera**
   > Utilizing system intents to take photos of receipts and safely save them to the app's internal storage.
2. 💾 **Database (Room)**
   > Persistent, robust local data storage directly on the device.
3. 🔔 **Notifications**
   > System notification mechanism scheduled for daily user reminders.
4. 📊 **Data Visualization**
   > Generating dynamic charts based on the inputted financial data.

---

## 🚀 Setup & Running Instructions

Follow these steps to get the project up and running locally:

1. **Open** the project in **Android Studio**.
2. **Wait** for the Gradle synchronization to complete successfully.
3. **Connect** a physical device with USB debugging enabled, or launch an **emulator**.
4. **Click** the **Run** button (indicated by the green triangle).

---

## 📂 File Structure

```text
app/src/main/java/com/example/walletwise/
├── data/            # Data handling (Room DB, Models, Repository)
├── ui/              # Presentation layer (Fragments, ViewModels, Adapters)
├── worker/          # Background tasks (Notifications)
└── utils/           # Helper classes (Date and currency formatting)
