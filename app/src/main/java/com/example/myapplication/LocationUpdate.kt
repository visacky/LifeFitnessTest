package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_location_update.*

class LocationUpdate : AppCompatActivity() {

    var locationDescription = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_update)
        prepareStr()
    }

    private fun prepareStr() {
        locationDescription = "Location update can be done by in several ways we can set the handler to trigger every 5 minutes or we can use " +
                "the GPSListener or by using the location listener when ever the location is changed in several interval of the time we can call or trigger out APi using the brodcast reciver to trigger the API+\n+" +
                "Let us take the few basic setups to get the location.+\n+ <uses-permission android:name=\"android.permission.INTERNET\" />\n" +
                " <uses-permission android:name=\"com.google.android.providers.gsf.permission.READ_GSERVICES\" />\n" +
                " <uses-permission android:name=\"android.permission.ACCESS_COARSE_LOCATION\"/>\n" +
                " <uses-permission android:name=\"android.permission.ACCESS_FINE_LOCATION\"/>\n" +
                "\n" +
                " <receiver\n" +
                "     android:name=\".activity.Timerservice\"\n" +
                "     android:process=\":remote\" >\n" +
                " </receiver>\n" +
                "\n" +
                " <service\n" +
                "     android:name=\".model.GPSTracker\"\n" +
                "     android:exported=\"false\" />+\n" +
                "we need to add this permission in Manifest file register the broadcast and create the class with extended service with the location listener implementation +\n+" +
                "trigger the broadcsat reciver win the certain period of time inside the location listener override methods,once the service is started automatically location brodcast reciver started triggering the API cal in background service.  "
        description.text = locationDescription
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
