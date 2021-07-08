package com.example.car_emergency_assistant;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class SensorService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        SensorInfo sensor = new SensorInfo();

        while (true)
        {
            sensor.process_sensor_data();

            if (sensor.check_for_issues())
            {
                UserInterface ui = new UserInterface(this);

                ui.prompt_user();

                stopSelf();
            }
        }
    }
}
