# 🚆 Railway Ticket Reservation System (Java Console Application)

## 📌 Project Overview

This project is a **Railway Ticket Reservation System** developed using **Core Java**. It is a console-based application that simulates real-time train ticket booking, cancellation, and berth allocation logic similar to the Indian railway reservation system.

The system manages **Lower (L), Middle (M), Upper (U), RAC, and Waiting List (WL)** allocations dynamically based on availability.

---

## 🎯 Key Features

* ✅ Book tickets with berth preference (L/M/U)
* ✅ Automatic berth allocation based on availability
* ✅ RAC (Reservation Against Cancellation) handling
* ✅ Waiting List management
* ✅ Ticket cancellation with automatic upgrading:

  * Waiting List → RAC
  * RAC → Confirmed Berth
* ✅ View available tickets
* ✅ View booked passenger details
* ✅ Unique Passenger ID generation

---

## 🛠️ Technologies Used

* **Java (Core Java)**
* **Object-Oriented Programming (OOP)**
* Collections Framework (`HashMap`, `ArrayList`)
* Console-based input handling using `Scanner`

---

## 🏗️ Project Structure

* **Main.java** → Handles user interaction and menu system
* **Passenger.java** → Stores passenger details
* **TicketBooker.java** → Contains booking, cancellation, and allocation logic

---

## ⚙️ System Logic

* If preferred berth is available → Allocate immediately
* If preferred berth not available → Allocate other available confirmed berth
* If no confirmed berths → Allocate RAC
* If RAC full → Allocate Waiting List
* On cancellation:

  * RAC passenger gets confirmed berth
  * Waiting List passenger moves to RAC

---

