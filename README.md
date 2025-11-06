# FinalTask_BookingApp

SETUP:

1. Navigate to Resources -> configs -> config.properties file
2. Enter the information of your device
3. Run commands "brew install maven" and "brew install allure" if not already installed
   
RUNNING TESTS:

1. Launch iOS emulator (The emulator needs to be the same device type and os as in config.properties file)
2. In terminal write "mvn test -Dtest.suite=filename.xml"
