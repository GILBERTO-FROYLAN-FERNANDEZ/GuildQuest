## Added UI classes
- for each class that I implemented, I added UI to keep the UI separate from the functionality.
  - I _could_ have implemented this in the original core classes, but because I needed to add various methods to facilitate choosing different options from the user, doing this would have bloated the original class and made it _significantly_ more confusing to determine what was functionality-based and what was for the UI.
  - This definitely increased dependencies and UML size, as a lot of UI classes had the same dependencies as the functionality classes, but I still believe this separation is good.
- added Page class to serve as interface between objects and the terminal for a CLI interface.
  - Originally, UI was undefined, so this is my straightforward implementation.
  - Created helper methods for accepting input and choosing between integer options, operations done numerous times in the UI classes.

## Other
- created an `Engine` class to start the program. Could have either been implemented in the UserUI as a main method, but if I needed to add something anyway, then I should separate it into it's own class for future use.
- Added relations in UML diagram since it was unspecified
- made `EffectType` an enum, was originally unspecified
  - I would prefer to make it an abstract class, but I will stick to the diagram.
- added character methods `giveItem` and `takeItem` to make `InventoryEffect apply()` work.
- added `ThemeType` abstract class since `ThemeType` entity was not described.
- made `TimeDisplayMode` an enum entity; originally unspecified.
  - Could later be abstract class with concretions.
- Used plantUML Parser plugin: https://plugins.jetbrains.com/plugin/15524-plantuml-parser


- added static allUsers attribute to Users class to access different users.
## User
- Did not implement sharing campaign/quest events
- Added `createUser` method to keep constructor abstract
## Campaign
- Removed `setVisibility` from ONLY UML for clarity
## WorldTime
- added `toString` method and `compareTo` (`comparable` interface)
## Realm
- added `toString`
## Character
- added `giveItem` and `takeItem`




























