# Android MVI Archicture

- manage a single immutable view state in the reactive flow architecture.
- The MVI pattern promotes immutability, ensuring the application’s state remains consistent and
  predictable.
- In the Android context, migrating an existing MVVM to MVI is simple by grouping the states into
  one single. It fits nicely with Compose to manage a feature state. Moreover, debugging a single
  state helps monitor the property changes and understand the app’s behavior.
  = the Model consists of business logic that provides data to the View (UI) based on the requested
  Intent by the user. & Intents are the actions that will trigger based on user action.

- the mead db
- https://www.themealdb.com/api.php

- #### M - Model -> State of UI ,
- on the basis of State we update UI. The state is immutable and can only be modified through
  intents
- represents the single state and the business model. It manages the data and responds to user
  intents to produce a new state. The Model ensures that the state remains immutable and processes
  user interactions
- #### V View,
- The View layer is responsible for rendering the UI and displaying the current state to the
  user. It is a passive component that listens for user interactions and translates them into
  intents. In MVI, the View is typically implemented as a passive observer that receives state
  updates from the Model. When the Model's state changes, the View re-renders the UI based on the
  new state. The View component also captures user interactions, such as button clicks or text
  input, and transforms them into Intents.
- #### I Intent ->
- intent based actions , listening to user actions
- It encapsulates the user interactions captured by the View and serves as a signal to the Model for
  state updates or other operations

# State

- it is a single source of truth. data class 
    - Selecting an item in list , item is state
    - Button is enable/ disable is a state
    - State(LOADING, emptyState, refreshing,error,items)

## State problem

- in some times it is happen that view state is not update properly , just some times we hit the
  pull to refresh and data is there but the progress is still visible , it is called problem in
  state of view.
- State of Ui coordinated by Presenter/ VM
- presentation , business logic and view has own state
- in MVI Single source of truth and State
    - it has one contract like state that will be update each time.

## We have Actions

- Plain object , sealed class
- Types of Actions
- Intentions of User

## We have States

- Immutable List / object noting is mutable
- Set representing the state of views
- Any change is trigger is only by dispatching actions

## Reducer , Partial state

- previous state , result and return new state

## Flow of App

- Intent -> viewmodel -> usecase -> repository -> data -> viewmodel / update view state -> view
  render

1. The View layer receives user interactions and converts them into intents, which are dispatched to
   the Model layer.
2. The Model processes the intent and generates a new state based on the current state and the
   intent received.
3. The new state is propagated back to the View layer, which updates the UI accordingly to reflect
   the changes.
4. The updated UI presents the new state to the user, and the cycle continues as the user interacts
   further.

## Advantages of MVI

- Unidirectional flow
- Immutable State -> Predictable state -> clear UI behaviour and UI state management and handling,
- Intent Action -> each actions is well defined
- Testability , clear separation of concern

## Disadvantages

- Boilerplate code
- complexity increase with large apps
- Overhead
- Learning curve

## Benefit of using MVI with Compose

- As compose is event driven architecture , just like we have lambda in click and all its like
  passing events
- UI states is help to rendering the certain compose with the use of UIState
- Testability , complex Ui interaction
- Declarative UI with Unidirectional flow of Data.

### Implementation

- It exposes two flows. Internally, the `first is a hot flow of ViewState typed as StateFlow` to get
  the current state, and the `second is a hot flow of Event as Channel`.

### References

- https://www.linkedin.com/pulse/mastering-mvi-architecture-revolutionizing-android-app-dhule/
- https://engineering.teknasyon.com/how-to-implement-mvi-with-delegates-on-android-f2aa1a842b73
- https://www.youtube.com/watch?v=Wvq__KqOeSA
- https://github.com/bazaartechnologies-oss/android-mvi-architecture-kotlin
- https://medium.com/@meetjanani47/mvi-architecture-implementation-with-kotlin-flow-android-ae094fa83bff
- https://engineering.teknasyon.com/how-to-implement-mvi-with-delegates-on-android-f2aa1a842b73
- https://www.youtube.com/watch?v=wTJX_lWdh60
- https://www.droidcon.com/2023/10/06/trio-compose-architecture-with-mavericks/ -> most imp
- https://www.droidcon.com/2019/07/03/mvi-made-for-android/
- https://www.youtube.com/watch?v=xZ_A6kYfMEg 