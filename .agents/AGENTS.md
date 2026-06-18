# Adaptive Workspace Project Rules

## Architecture & Layouts
- **Navigation:** Always use Jetpack Navigation 3 (`androidx.navigation3`). Do not use Navigation Compose or legacy pane scaffolds. Use `ListDetailSceneStrategy` combined with `NavDisplay` for dual-pane or adaptive list-detail screens.
- **Top-Level Adaptive Routing:** Use `NavigationSuiteScaffold` unconditionally at the root of the app. Let it internally evaluate `WindowAdaptiveInfo` to automatically switch between a Bottom Navigation Bar on phones and a Navigation Rail on tablets/foldables.
- **Grid Layouts:** Use the experimental Compose Foundation `Grid` API (`androidx.compose.foundation.layout.Grid`) with fractional units (e.g., `1.fr`) or `GridTrackSize`. Do not use float fractions directly in column or row configs. Wrap the `Grid` in a `BoxWithConstraints` to dynamically adjust the column count (e.g., 2 columns on compact, 4 on expanded).
- **FlexBox Layouts:** Use the experimental Compose Foundation `FlexBox` API. All properties (like `wrap`, `justifyContent`, `gap`) must be placed inside the `config { }` block, not passed as direct parameters to the composable.
- **TopAppBars:** Avoid using `LargeTopAppBar` unless there is expansive hero content to fill it. Use the standard `TopAppBar` with `TopAppBarDefaults.pinnedScrollBehavior()` for a consistent look.

## WindowSizeClass Constraints (M3 Adaptive V2)
- Do not use the deprecated `WindowWidthSizeClass` enum or properties. 
- When manually evaluating window width breakpoints, use the V2 extension method on the root class: `!windowSizeClass.isWidthAtLeastBreakpoint(WindowSizeClass.BREAKPOINT_MEDIUM)` (or equivalent).
- Prefer relying on ambient structural components (like `NavigationSuiteScaffold`) over manual manual `if/else` checks to avoid state-loss and Compose node destruction on device rotation.

## Project Setup & Environments
- **Package Name:** The verified base package is `dev.alimansour.adaptive.workspace`.
- **SDK Target:** `compileSdk` must remain at `37` (or higher) to support the 16KB-page-size experimental system images and the latest alpha/beta Compose libraries.
- **Emulator:** The `Resizable_Experimental` emulator is unstable on Linux with Wayland and may require `QT_QPA_PLATFORM=xcb` or `Software` graphics to run. The `Pixel_10_Pro_Fold` emulator is recommended for testing foldable and adaptive transitions.
