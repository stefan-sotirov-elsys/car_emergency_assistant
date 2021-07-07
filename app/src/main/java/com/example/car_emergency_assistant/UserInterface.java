package com.example.car_emergency_assistant;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class UserInterface
{
    static String channel_id = "prompt";
    Service calling_service;

    public UserInterface(Service calling_activity)
    {
        this.calling_service = calling_activity;

        create_notification_channel();
    }

    public void prompt_user()
    {
        Intent intent = new Intent(calling_service.getBaseContext(), PromptActivity.class);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        calling_service.startActivity(intent);
    }

/*
    public void prompt_user() - doesn't work for now, will debug later
    {
        Intent intent = new Intent(calling_service.getBaseContext(), PromptActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pending_intent = PendingIntent.getActivity(calling_service.getBaseContext(), 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(new PromptActivity().getBaseContext(), channel_id)
                .setSmallIcon(R.drawable.icon)
                .setContentTitle("Safety Prompt")
                .setContentText("Are you experiencing any issues?")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pending_intent);

        NotificationManagerCompat notification_manager = NotificationManagerCompat.from(calling_service.getBaseContext());
        int notification_id = 1;

        notification_manager.notify(notification_id, builder.build());
    }
*/
    private void create_notification_channel()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            CharSequence name = channel_id;
            String description = "asks if the user is hurt";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(channel_id, name, importance);
            channel.setDescription(description);
        }
    }
}