# User Interface — UI Automation Test Suite

Automated UI tests for the [userinyerface.com](https://userinyerface.com/game.html) challenge site, built with **Java 17**, **Maven**, **TestNG**, and the **aquality-selenium** framework. The suite follows the Page Object Model (POM) and reads its environment and test data from JSON resources.


## Tech Stack

- **Java 17**
- **Maven** (build and dependency management)
- **TestNG** (test runner)
- **aquality-selenium** (Selenium wrapper: browser management, element factory, waits, logging)
- **Lombok** (boilerplate reduction)
- **Gson** (JSON parsing)

## Project Structure
```
.
├── pom.xml
└── src
    └── test
        ├── java
        │   ├── constants
        │   │   └── Domains.java            # Supported email domain extensions
        │   ├── models
        │   │   ├── EmailData.java          # Test data model for sign-up credentials
        │   │   └── EnvConfig.java          # Environment config model (host)
        │   ├── pages
        │   │   ├── MainPage.java           # Main page + timer + form accessors
        │   │   ├── CookieForm.java         # Cookies policy banner
        │   │   ├── SignUpForm.java         # Card 1: credentials form
        │   │   └── InterestsForm.java      # Card 2: interests/avatar form
        │   ├── tests
        │   │   ├── BaseTest.java           # Setup/teardown shared by all tests
        │   │   ├── SessionTimerTests.java
        │   │   ├── CookiesPolicyTests.java
        │   │   └── CardOneCredentialsTests.java
        │   └── utils
        │       ├── EnvConfigReader.java    # Reads the active environment config
        │       ├── TestDataReader.java     # Reads test data JSON
        │       ├── JsonUtils.java          # Gson deserialization helper
        │       └── WaitUtils.java          # sleep helper
        └── resources
            ├── env.json                    # Active environment selector
            ├── environment
            │   └── stage.json              # Environment-specific settings (host URL)
            ├── testData
            │   └── emailData.json          # Sign-up test data
            └── settings.json               # aquality-selenium browser settings
```

## Prerequisites

- **JDK 17** or newer
- **Maven 3.8+**
- A supported browser installed (e.g., Chrome) — the browser is configured in `src/test/resources/settings.json`

## Configuration

### Environment

The active environment is set in `src/test/resources/env.json`:

```json
{
  "env": "stage"
}
```

The matching environment file (`src/test/resources/environment/<env>.json`) provides the application URL:

```json
{
  "host": "https://userinyerface.com/game.html"
}
```

To target a different environment, add a new file under `environment/` and update `env.json` accordingly.

### Browser settings

Browser configuration (browser name, waits, timeouts, logging) is managed by aquality-selenium in `src/test/resources/settings.json`.

### Test data

Sign-up credentials are defined in `src/test/resources/testData/emailData.json`:

```json
{
  "emailName": "",
  "emailDomain": "",
  "emailExtension": "",
  "firstPassword": "",
  "secondPassword": ""
}
```

Supported email domain extensions are declared in the `Domains` enum (`src/test/java/constants/Domains.java`) and are exercised by the `checkEmailDomainExtensions` test.

## Running the Tests

Run the full test suite:

```bash
mvn clean test
```

Run a single test class:

```bash
mvn clean test -Dtest=SessionTimerTests
```

Run a single test method:

```bash
mvn clean test -Dtest=CardOneCredentialsTests#checkPasswordPolicyCompliance
```

## Test Flow

Each test is executed in isolation:

1. **Setup** (`BaseTest#setup`): the browser is started, maximized, and navigated to the configured host.
2. **Execution**: page objects interact with the UI and assertions validate the expected state.
3. **Teardown** (`BaseTest#teardown`): the browser is quit if it is still running.

## Notes

- Page objects extend aquality-selenium's `Form`, so each form declares its own locator and is verified with `state().waitForDisplayed()`.
- `MainPage` lazily initializes its child forms (`SignUpForm`, `InterestsForm`, `CookieForm`) to avoid unnecessary element lookups.
- Logging is provided by the aquality-selenium logger (`AqualityServices.getLogger()`).