# Adaptive Workspace 📱 ➝ 💻

A cutting-edge sample application demonstrating advanced adaptive layouts and responsive UI patterns in Android.

> **Note:** This project was originally created as the official companion repository for my session: **"From Rigid to Responsive: Adaptive Layouts in Jetpack Compose"** presented at **Google I/O Extended Cairo 2026**.

## Overview

Adaptive Workspace is designed to showcase how modern Jetpack Compose applications can effortlessly scale across compact phones, foldables, tablets, and desktop environments without duplicating UI code or relying on rigid XML layouts.

The application dynamically adjusts its routing and layouts based on the ambient `WindowSizeClass` and posture of the device.

## Key Features & APIs Demonstrated

*   **Adaptive Scaffolding (`NavigationSuiteScaffold`)**: Automatically switches between a Bottom Navigation Bar on compact devices and a Navigation Rail on expanded screens.
*   **Dual-Pane Navigation (`ListDetailSceneStrategy`)**: Uses the new Jetpack Navigation 3 router to seamlessly manage a single-pane list on phones and a side-by-side list/detail view on tablets.
*   **Experimental Grid API**: Utilizes the Compose Foundation `Grid` with fractional (`.fr`) units and `BoxWithConstraints` to create a responsive, two-dimensional dashboard that dynamically spans 2 to 4 columns depending on available width.
*   **Experimental FlexBox API**: Implements fluid, multi-axis wrapping for filter chips, avoiding manual screen-size calculations.

## Tech Stack

*   **Jetpack Compose BOM**: `2026.06.00` (Compose 1.11+)
*   **Navigation**: Jetpack Navigation 3 (`1.2.0-alpha04`)
*   **Material 3 Adaptive**: `1.3.0-rc01`
*   **Foundation Layout**: `1.12.0-beta01`
*   **Kotlin**: `2.4.0`

## Getting Started

### Requirements
*   **Android Studio**: Use the latest stable release of Android Studio (which supports AGP 9.2+).
*   **Compile SDK**: This project requires `compileSdk 37` (or higher) to support the latest experimental APIs and the 16KB-page-size system images.

### Running the App
To fully experience the adaptive features, it is highly recommended to run this app on the **`Pixel_10_Pro_Fold`** emulator. This allows you to instantly toggle between "Folded" (Compact) and "Unfolded" (Expanded) postures using the emulator toolbar, triggering the layout adaptations in real time.

---
*Built with ❤️ for the Google Developer Groups (GDG) Cairo community.*
