# 🏥 MediMind AI

<p align="center">

![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)
![Gemini AI](https://img.shields.io/badge/Gemini%20AI-8E75B2?style=for-the-badge&logo=google&logoColor=white)
![Room](https://img.shields.io/badge/Room-FF6F00?style=for-the-badge&logo=sqlite&logoColor=white)
![CameraX](https://img.shields.io/badge/CameraX-4285F4?style=for-the-badge&logo=android&logoColor=white)

</p>

> **AI-powered Android health assistant built with Kotlin, Jetpack Compose, CameraX, Room Database, and Google Gemini AI.**

Users can chat with an AI assistant, capture photos of medicines, prescriptions, or visible symptoms, and receive AI-generated health guidance—all within a modern Android application following the **MVVM architecture**.

---

# ✨ Features

### 🤖 AI Health Assistant
- AI-powered symptom analysis using Google Gemini
- Natural conversational chat interface
- Context-aware responses

### 📷 Image Analysis (Gemini Vision)
- Capture medicine, prescription, or symptom photos
- AI analyzes images directly inside the conversation
- Text and image conversations remain in one chat thread

### 💬 Smart Chat
- Modern messaging interface
- Loading states
- Conversation persistence

### 💾 Offline History
- Room Database stores:
  - Chat messages
  - AI responses
  - Image paths
- View previous consultations even without internet

### 📸 Camera Integration
- CameraX live preview
- Front & back camera switching
- Runtime permission handling
- Image capture directly inside the app

### 🏗 Modern Android Architecture
- MVVM
- Repository Pattern
- StateFlow
- Kotlin Coroutines
- Clean separation of concerns

---

# 📱 Screenshots

| Home | Chat | History |
|------|------|---------|
| <img width="220" src="https://github.com/user-attachments/assets/6425d4b9-30fa-403d-b0c1-dbfb1b4c6026"/> | <img width="220" src="https://github.com/user-attachments/assets/d3811e74-c1fe-46bd-9fb1-c5261b4162bc"/> | <img width="220" src="https://github.com/user-attachments/assets/8e01c06a-5db7-4042-a4ce-6bb590f83539"/> |

### Camera & Image Analysis

<p align="center">

<img width="220" src="https://github.com/user-attachments/assets/fb26aa7a-c3b6-4e45-bade-6273542b0ccf" alt="Camera Permission"/>

<img width="220" src="https://github.com/user-attachments/assets/fdf9d94f-e83e-4196-a266-d4acdedb42ea" alt="Captured Image"/>

<img width="220" src="https://github.com/user-attachments/assets/ead68cc0-fed4-40d0-aadc-ef6e33d2b5ce" alt="AI Processing"/>

<img width="220" src="https://github.com/user-attachments/assets/fb27f89c-5082-43f7-9a33-6a55b14d13c3" alt="AI Response"/>

</p>

</p>

---

# 🏛 Architecture

```
                Jetpack Compose UI
                        │
                        ▼
                  ViewModel
                        │
                        ▼
                 Repository
               ┌─────────────┐
               ▼             ▼
          Room Database   Gemini AI
                               │
                               ▼
                    Gemini Vision API
```

### Application Flow

```
CameraX
   │
Capture Image
   │
   ▼
Chat Screen
   │
   ▼
ViewModel
   │
   ▼
Repository
   │
   ├── Save to Room
   └── Send Image + Prompt to Gemini
                     │
                     ▼
               AI Response
                     │
                     ▼
          Display inside Chat
```

---

# 🛠 Tech Stack

| Technology | Purpose |
|------------|---------|
| Kotlin | Android Development |
| Jetpack Compose | UI |
| MVVM | Architecture |
| Repository Pattern | Data Layer |
| Room Database | Local Storage |
| Gemini AI | Text Generation |
| Gemini Vision | Image Understanding |
| CameraX | Camera Integration |
| StateFlow | UI State Management |
| Kotlin Coroutines | Asynchronous Programming |
| KSP | Annotation Processing |

---

# 🚀 Getting Started

### Clone the repository

```bash
git clone https://github.com/AromaAhmad/MediMindAI.git
```

### Open in Android Studio

Open the project and allow Gradle to sync.

### Add your Gemini API Key

Create or edit **local.properties**

```properties
GEMINI_API_KEY=YOUR_API_KEY
```

> The API key is stored locally and is **never committed** to GitHub.

### Run

Build and run the project on an emulator or physical Android device.

---

# 💡 What I Learned

Building this project helped me gain practical experience with:

- MVVM Architecture
- Repository Pattern
- CameraX
- Runtime Permissions
- Google Gemini AI
- Gemini Vision (Multimodal AI)
- Room Database
- StateFlow
- Kotlin Coroutines
- Jetpack Compose Navigation
- Clean Android Architecture

---

# 🚀 Future Improvements

- 🎤 Voice conversations
- 🔊 Text-to-Speech
- 💊 Medicine reminders
- 📍 Nearby hospitals
- 🧾 Export consultation as PDF
- 🔐 User authentication
- ☁ Cloud synchronization

---

# 👩‍💻 Developer

## Aroma Ahmad

Android Developer passionate about building modern AI-powered Android applications using Kotlin and Jetpack Compose.

- Kotlin
- Jetpack Compose
- Android Architecture (MVVM)
- Room Database
- CameraX
- Gemini AI

---

⭐ If you found this project interesting, consider giving it a **Star**!
