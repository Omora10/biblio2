# Design System Strategy: The Digital Archivist

## 1. Overview & Creative North Star
The "Digital Archivist" is the creative North Star of this design system. In a data-heavy environment like a library management system, "order" often risks becoming "clutter." This system moves beyond the standard enterprise template by adopting an **Editorial Precision** aesthetic. 

We treat information not as "rows in a database," but as "entries in a curated collection." We break the traditional rigid grid by utilizing intentional asymmetry, expansive white space, and high-contrast typography scales. By layering surfaces rather than boxing them in, we create a UI that feels architectural, authoritative, and profoundly calm.

## 2. Colors: Tonal Depth & The "No-Line" Rule
This system utilizes a sophisticated Material 3 palette to move away from the "flat" web.

### Color Logic
*   **Primary (`#24389c`):** Our "Ink." It represents the authority of the archive. Use it for core branding and primary actions.
*   **Tertiary/Accent (`#574000` / `#FFC107` equivalent):** Our "Highlight." Used sparingly for warnings and alerts to ensure the professional indigo remains dominant.
*   **Neutral Surfaces:** A spectrum from `surface_container_lowest` (#ffffff) to `surface_dim` (#d9dadc).

### The "No-Line" Rule
**Explicit Instruction:** Prohibit 1px solid borders for sectioning. Do not use borders to separate the sidebar from the main content or to box in a data table.
*   **Defining Boundaries:** Boundaries must be defined solely through background color shifts. For example, a `surface_container_low` dashboard section sitting on a `surface` background creates a clear but soft structural break.

### Surface Hierarchy & Nesting
Treat the UI as a series of physical layers—stacked sheets of fine paper.
*   **Base:** `background` (#f9f9fb)
*   **Structural Sections:** `surface_container_low` (#f3f3f5)
*   **Actionable Cards/Modals:** `surface_container_lowest` (#ffffff)
*   **The "Glass & Gradient" Rule:** To provide visual "soul," use subtle linear gradients (Primary to Primary Container) for hero states. For floating navigation or filters, use **Glassmorphism**: `surface_container_lowest` at 80% opacity with a `20px` backdrop-blur.

## 3. Typography: Editorial Authority
We pair **Work Sans** (Display/Headlines) with **Inter** (Body/Labels) to balance character with high-density legibility.

*   **Display & Headlines (Work Sans):** Large, bold, and authoritative. `display-lg` (3.5rem) should be used for empty states or major section headers to create an "editorial magazine" feel.
*   **Body & Labels (Inter):** Optimized for data. Use `body-md` (0.875rem) as the standard for data tables.
*   **Hierarchy Tip:** Lean into the weight contrast. Use `title-sm` (1rem, Bold) against `body-sm` (0.75rem, Regular) to create a clear "Field Label vs. Value" relationship without needing lines or boxes.

## 4. Elevation & Depth: Tonal Layering
Traditional drop shadows are often messy. This system uses **Tonal Layering** to convey hierarchy.

*   **The Layering Principle:** Place a `surface_container_lowest` card on a `surface_container_low` section. The subtle shift in hex code creates a "soft lift."
*   **Ambient Shadows:** For floating elements (Modals, Popovers), use an extra-diffused shadow: `box-shadow: 0 12px 32px -4px rgba(26, 28, 29, 0.08)`. The shadow color is a tinted version of `on_surface`, making it feel like natural ambient light.
*   **The "Ghost Border" Fallback:** If accessibility requires a border, use the `outline_variant` (#c5c5d4) at **20% opacity**. Never use 100% opaque borders.

## 5. Components: Precision Primitives

### Buttons
*   **Primary:** Solid `primary` (#24389c) with `on_primary` (#ffffff) text. Use `round-md` (0.375rem).
*   **Secondary:** `primary_container` (#3f51b5) background. 
*   **Tertiary:** No background; `primary` text. Used for low-emphasis actions like "Cancel."

### Data Tables (The Core Component)
*   **Forbid Divider Lines:** Separate rows using a vertical spacing of `spacing-4` (0.9rem) and a subtle background hover state using `surface_container_high`.
*   **Header:** Use `label-md` in `on_surface_variant` (#454652) with all-caps styling for a professional, "archival" look.

### Input Fields
*   **Style:** Filled style using `surface_container`. On focus, transition to a 2px bottom-stroke of `primary`—avoid the "full box" outline to keep the interface feeling open.
*   **Corners:** Use `DEFAULT` (0.25rem) for a sharper, more corporate feel.

### Chips & Tags
*   **Status Chips:** Use `tertiary_fixed` (#ffdf9e) for "Pending" and `error_container` (#ffdad6) for "Overdue." Use `full` rounding (9999px).

## 6. Do’s and Don'ts

### Do
*   **Do** use asymmetrical layouts. A large title on the left with a small action button on the far right creates a high-end feel.
*   **Do** use `spacing-16` (3.5rem) or more between major content blocks to let the data "breathe."
*   **Do** use `surface_tint` (#4355b9) at very low opacities (5%) to give grey areas a "cool" indigo undertone.

### Don’t
*   **Don't** use pure black (#000000) for text. Always use `on_surface` (#1a1c1d) to maintain professional softness.
*   **Don't** use 1px dividers to separate list items. Use white space (`spacing-3`) or tonal shifts.
*   **Don't** use standard Material "Floating Action Buttons" (FABs) in the bottom right; instead, integrate actions into the editorial flow of the page headers.