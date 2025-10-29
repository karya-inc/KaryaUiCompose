# Contributing to Karya UI Components

Thank you for contributing to Karya! This guide will help you add new UI components to the library following our established patterns and conventions.

## Component Contribution Workflow

When adding a new component to `:libs:com.daiatech.karya.ui.<component-package>`, please follow these three essential steps:

### 1. Create the Component Preview Catalogue

Every component must have a preview catalogue that showcases its various states and configurations.

**Location:** `:libs:com.daiatech.karya.ui.<component-package>`

**Example:**
```kotlin
@Composable
fun NewComponent(
    val prop1: SomeType,
    val prop2: SomeType
) { ... }

@Preview()
@Composable
fun NewComponentPreview() {
    val componentVariants = listOf(
        variation1, variation2, ...
    )

    Column(Modifier.fillMaxSize().scrollable()) {
        componentVariants.forEach { 
            NewComponent(
                prop1 = it.prop1,
                prop2 = it.prop2
            )
        }
    }
}
```

**Guidelines:**
- Use `@Preview` annotation with descriptive names
- Set `showBackground = true` for better visibility
- Create previews for:
  - Default state
  - Disabled state
  - Different variants (primary, secondary, etc.)
  - Loading states (if applicable)
  - Error states (if applicable)
  - Various sizes
  - With/without icons or additional elements
- Keep preview functions simple and focused
- Use meaningful sample data

### 2. Add Component to Components Registry

Make the component accessible by adding it to the centralized components collection.

**Location:** `:composeApp:com.daiatech.karya.ui.Components`

### 3. Display in Component Screen

Call the preview in the ComponentScreen to make it visible in the app's component showcase.

**Location:** `:composeApp:com.daiatech.karya.ui.screens.ComponentScreen`

**Example:**
```kotlin
when (component) {
    Components.NEW_COMPONENT -> NewComponentPreview()
    ...
}
```

Thank you for contributing to Karya! 🎉
