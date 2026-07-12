# MediMind AI 🏥🤖

![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)
![Gemini AI](https://img.shields.io/badge/Gemini%20AI-8E75B2?style=for-the-badge&logo=google&logoColor=white)
![Room](https://img.shields.io/badge/Room%20DB-FF6F00?style=for-the-badge&logo=sqlite&logoColor=white)

> An AI-powered Android health assistant that analyzes your symptoms using Google Gemini AI.

---

## 📖 About

MediMind AI is an Android application that helps users get AI-powered health guidance through a simple chat interface. It uses Google's Gemini AI to generate responses and Room Database to store conversations locally — allowing users to revisit previous consultations even without an internet connection.

---

## 📸 Screenshots

| Home Screen | Chat Screen | History Screen |
|-------------|-------------|----------------|
| <img width="200" src="https://github.com/user-attachments/assets/6425d4b9-30fa-403d-b0c1-dbfb1b4c6026" /> | <img width="200" src="https://github.com/user-attachments/assets/d3811e74-c1fe-46bd-9fb1-c5261b4162bc" /> | <img width="200" src="https://github.com/user-attachments/assets/8e01c06a-5db7-4042-a4ce-6bb590f83539" /> |

---

## ✨ Features

- 🤖 AI-powered symptom analysis using Gemini AI
- 💬 Real-time chat interface
- 💾 Local chat history via Room Database
- 📜 Consultation History screen
- 🏗️ Clean MVVM Architecture
- 📦 Repository Pattern
- 🎨 Modern UI with Jetpack Compose
- ⚡ Kotlin Coroutines for async operations

---

## 🏛️ Architecture
UI (Jetpack Compose)
│
▼
ViewModel
│
▼
Repository
┌─────┴──────┐
▼            ▼
Room DB    Gemini AI SDK

---

## 🛠️ Tech Stack

| Technology | Purpose |
|------------|---------|
| Kotlin | Programming Language |
| Jetpack Compose | Modern Android UI |
| MVVM | App Architecture |
| Room Database | Local Storage |
| Gemini AI SDK | AI Responses |
| Kotlin Coroutines | Background Tasks |
| KSP | Annotation Processing |

---

## 🚀 Getting Started

1. Clone the repository
```bash
git clone https://github.com/AromaAhmad/MediMindAI.git
```

2. Open in Android Studio

3. Add your Gemini API key in `local.properties`:
GEMINI_API_KEY=your_key_here

4. Sync Gradle and Run

---

## 📌 Future Improvements

- 🎤 Voice input
- 🔊 Text-to-Speech responses
- 💊 Medicine reminders
- 📍 Nearby hospitals
- 🧾 PDF health reports
- 🔐 User authentication

---

## 👩‍💻 Author

**Aroma Ahmad**
Android Developer | Kotlin | Jetpack Compose | AI Enthusiast
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/aroma-a-378245342)
[![Email](https://img.shields.io/badge/Email-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:aromaahmad91@gmail.com)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/AromaAhmad)
