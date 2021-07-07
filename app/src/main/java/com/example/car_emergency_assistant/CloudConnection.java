package com.example.car_emergency_assistant;

public class CloudConnection {
    public boolean establish(String tenant_id, String username, String password)
    {
        if (tenant_id == null || username == null || password == null)
        {
            return false;
        }

        return true; // TODO!
    }

    public void send_data(byte[] data)
    {
        return; // TODO!
    }

    public void set_alarm(String severity)
    {
        return; // TODO!
    }
}
