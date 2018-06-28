```
How to install:
Go to this link and login to start creating a Netatmo DEV app: http://dev.netatmo.com/dev/createapp

In the “Create an application” page, just fill in what you like for the app name and description e.g. smartthings connect, agree to the terms of use and hit the create button. In your newly created app, note down the clientID and secret, we’ll need it later in smart things

Now log into the SmartThings IDE: https://account.smartthings.com

Click into “My SmartApps” and then click “New SmartApp”
Click “From Code”, paste in the code from Github then click “create” Then click on “Save” and then “publish” —> “For Me”
Click on the “App Settings” button and click “settings” on the next page.

Enter the “ClientID” and “Secret” that you obtained previously when you created your Netatmo DEV app.
Also enter “serverUrl”, I use https://graph.api.smartthings.com/ even if I am on the UK servers. If you are having problems later on, try the adress your hub is connected to. If this adress is not correct you might get a “webview missing on device” error on your Android device

NA01: https://graph.api.smartthings.com/
NA02: https://graph-na02-useast1.api.smartthings.com/
NA04: https://graph-na04-useast2.api.smartthings.com/
EU01: https://graph-eu01-euwest1.api.smartthings.com/
AP02: https://graph-ap02-apnortheast2/

Click on OAuth and enable it, press “Update” at the bottom of the page

Go back in to the online ST IDE and in the “My Device Handlers” section, click on the “Create New Device Handler”
Click “From Code”, paste in the code from the DTH from Github then click “create”. Click on “Save” and then “publish” —> “For Me”. Repeat for all DTH

On your mobile, navigate to the martketplace ‐> my apps, and you can now install the “netatmo connect” smart app

Now you should be able to use the app as intended to install your netatmo weather station devices into ST
```
https://community.smartthings.com/t/modified-netatmo-weather-station/78133?u=sbdobrescu&source_topic_id=107178
