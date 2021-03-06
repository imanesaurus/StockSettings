package com.xs.stocksettings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;

public class CameraSound extends miui.preference.PreferenceActivity {

    private static final String KEY_CAMERA_SOUND = "camera_sound_key";
    private static final String KEY_RECORD_SOUND = "record_sound_key";
    private static final String KEY_FOCUS_SOUND = "focus_sound_key";

    private CheckBoxPreference mCameraSound;
    private CheckBoxPreference mRecordSound;
    private CheckBoxPreference mFocusSound;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(miui.R.style.Theme_Light_Settings);
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.camera_sound);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        mCameraSound = (CheckBoxPreference) findPreference(KEY_CAMERA_SOUND);
        mRecordSound = (CheckBoxPreference) findPreference(KEY_RECORD_SOUND);
        mFocusSound = (CheckBoxPreference) findPreference(KEY_FOCUS_SOUND);
    }

    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen,
                                         Preference preference) {

        if (preference == mCameraSound) {
            RootCmd.RunRootCmd("mount -o remount,rw /system");
            if (mCameraSound.isChecked()) {
                RootCmd.RunRootCmd("mv /system/media/audio/ui/camera_click.bak /system/media/audio/ui/camera_click.ogg");
            } else {
                RootCmd.RunRootCmd("mv /system/media/audio/ui/camera_click.ogg /system/media/audio/ui/camera_click.bak");
            }
        }
        if (preference == mRecordSound) {
            RootCmd.RunRootCmd("mount -o remount,rw /system");
            if (mRecordSound.isChecked()) {
                RootCmd.RunRootCmd("mv /system/media/audio/ui/VideoRecord.bak /system/media/audio/ui/VideoRecord.ogg");
            } else {
                RootCmd.RunRootCmd("mv /system/media/audio/ui/VideoRecord.ogg /system/media/audio/ui/VideoRecord.bak");
            }
        }
        if (preference == mFocusSound) {
            RootCmd.RunRootCmd("mount -o remount,rw /system");
            if (mFocusSound.isChecked()) {
                RootCmd.RunRootCmd("mv /system/media/audio/ui/camera_focus.bak /system/media/audio/ui/camera_focus.ogg");
            } else {
                RootCmd.RunRootCmd("mv /system/media/audio/ui/camera_focus.ogg /system/media/audio/ui/camera_focus.bak");
            }
        }

        return false;

    }
}