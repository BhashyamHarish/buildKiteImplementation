@echo off
REM Batch file to run Espresso Test Suite dynamically

echo Running My Demo App Regression Test Suite...

REM Run the Gradle command with user-provided class
gradlew.bat connectedAndroidTest -x assembleDebug -Pandroid.testInstrumentationRunnerArguments.class=com.saucelabs.mydemoapp.android.e2eTests.testSuites.RegressionTestSuite

REM Check if the command was successful
IF %ERRORLEVEL%==0 (
    echo Tests executed successfully!
) ELSE (
    echo Tests failed. Check the logs for details.
)
pause
cmd /k