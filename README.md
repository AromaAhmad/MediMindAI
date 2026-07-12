MediMind AI 🏥🤖
![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)
![Gemini AI](https://img.shields.io/badge/Gemini%20AI-8E75B2?style=for-the-badge&logo=google&logoColor=white)
![Room](https://img.shields.io/badge/Room%20DB-FF6F00?style=for-the-badge&logo=sqlite&logoColor=white)
![CameraX](https://img.shields.io/badge/CameraX-4285F4?style=for-the-badge&logo=android&logoColor=white)
> An AI-powered Android health assistant that analyzes your symptoms — through text **or a photo** — using Google Gemini AI.
---
📖 About
MediMind AI is an Android application that helps users get AI-powered health guidance through a simple chat interface. It uses Google's Gemini AI to generate responses and Room Database to store conversations locally — allowing users to revisit previous consultations even without an internet connection.
Beyond text chat, MediMind AI now supports multimodal image analysis — users can snap a photo of medicine, a prescription, or a visible symptom directly from the app, and Gemini Vision analyzes it and responds right inside the same chat thread.
---
📸 Screenshots
Home Screen	Chat Screen	History Screen Camera Screen Permission
<img width="200" src="https://github.com/user-attachments/assets/6425d4b9-30fa-403d-b0c1-dbfb1b4c6026" />	<img width="200" src="https://github.com/user-attachments/assets/d3811e74-c1fe-46bd-9fb1-c5261b4162bc" />	<img width="200" src="https://github.com/user-attachments/assets/8e01c06a-5db7-4042-a4ce-6bb590f83539" />
<img width="714" height="1599" alt="try" src="https://github.com/user-attachments/assets/961b9625-2be8-48e2-9f90-1e41176ebd6b" />
<img width="714" height="1599" alt="try" src="https://github.com/user-attachments/assets/fdf9d94f-e83e-4196-a266-d4acdedb42ea" />
<img width="714" height="1599" alt="im thinking" src="https://github.com/user-attachments/assets/ead68cc0-fed4-40d0-aadc-ef6e33d2b5ce" />
<img width="714" height="1599" alt="image" src="https://github.com/user-attachments/assets/fb27f89c-5082-43f7-9a33-6a55b14d13c3" />
<img width="714" height="1599" alt="cam" src="https://github.com/user-attachments/assets/89c6dc8a-d6fb-441d-b961-dcfd3b89dcf0" />





---
✨ Features
🤖 AI-powered symptom analysis using Gemini AI
📷 Multimodal image analysis — capture a photo (medicine, prescription, symptom) and get an instant Gemini Vision explanation, delivered as a chat message
🔄 Live camera preview with front/back camera switching (CameraX)
💬 Real-time chat interface
💾 Local chat history via Room Database, including saved images
📜 Consultation History screen
🏗️ Clean MVVM Architecture
📦 Repository Pattern
🎨 Modern UI with Jetpack Compose
⚡ Kotlin Coroutines for async operations
---
🏛️ Architecture
```
UI (Jetpack Compose)
       │
       ▼
   ViewModel
       │
       ▼
  Repository
   ┌───┴────┐
   ▼        ▼
Room DB   Gemini AI SDK
                │
                ▼
        Gemini Vision (multimodal)
```
`CameraScreen` captures a photo via CameraX, then navigates to `ChatScreen` with the image path
`ChatViewModel` triggers a multimodal Gemini call, sending the image + a health-context prompt together
`HealthRepository` handles both text-only and multimodal requests behind one clean API
Room stores the image path alongside each message, so photo conversations persist across app restarts
---
🛠️ Tech Stack
Technology	Purpose
Kotlin	Programming Language
Jetpack Compose	Modern Android UI
MVVM	App Architecture
Room Database	Local Storage
Gemini AI SDK	Text & Multimodal (Vision) AI Responses
CameraX	Live camera preview & image capture
Kotlin Coroutines	Background Tasks
KSP	Annotation Processing
---
🚀 Getting Started
Clone the repository
```bash
git clone https://github.com/AromaAhmad/MediMindAI.git
```
Open in Android Studio
Get a Gemini API key from Google AI Studio, then add it to `local.properties` (this file is gitignored and never committed):
```
GEMINI_API_KEY=your_key_here
```
Sync Gradle and Run
---
📌 Future Improvements
🎤 Voice input
🔊 Text-to-Speech responses
💊 Medicine reminders
📍 Nearby hospitals
🧾 PDF health reports
🔐 User authentication
---
👩‍💻 Author
Aroma Ahmad
Android Developer | Kotlin | Jetpack Compose | AI Enthusiast
![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)
![Email](https://img.shields.io/badge/Email-D14836?style=for-the-badge&logo=gmail&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)
