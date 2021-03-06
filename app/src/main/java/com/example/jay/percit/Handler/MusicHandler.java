package com.example.jay.percit.Handler;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.jay.percit.Controller.MusicStageActivity;
import com.example.jay.percit.Thread.MusicplayerThread;
import com.example.jay.percit.Thread.RecordThread;
import com.example.jay.percit.Util.BluetoothConnectService;

public class MusicHandler extends Handler {

    private static final int MUSIC_START = 0;
    private static final int REQUEST_A = 'a';
    private static final int REQUEST_B = 'b';
    private static final int REQUEST_C = 'c';
    private static final int REQUEST_D = 'd';
    private static final int NOMAL_MODE = 5;
    private static final int RECORD_MODE = 6;
    private static final int PLAY_MODE = 7;
    private static final int PLAY_BGM = 8;
    private static final int PAUSE_BGM = 9;
    private static final int RESUME_BGM = 10;
    private static final int CLEAR_BGM = 11;

    private float current_Volume = 1;
    private int save_Volume = 1;

    private MusicplayerThread mMusicPlayerThread;
    private RecordThread mRecordThread;
    private BluetoothConnectService mBluetoothConnectService;

    public MusicHandler(RecordThread mRecordThread) {
        this.mRecordThread = mRecordThread;
        this.mMusicPlayerThread = MusicStageActivity.gMusicplayerThread;
    }

    public void handleMessage(Message msg) {
        super.handleMessage(msg);

        switch (msg.what) {
            case MUSIC_START:

                break;

//            case REQUEST_A:
//
//                if (MusicStageActivity.state == PLAY_MODE) {
//
//                    byte[] temp_content = {'a'};
//
//                    //      mBluetoothConnectService.write(temp_content);
//                    MusicStageActivity.gBluetoothThread.write(temp_content);
//                    MusicStageFragment4.guiHandler.sendEmptyMessage(REQUEST_A);
//                    mMusicPlayerThread.play(1, current_Volume);
//                } else if (MusicStageActivity.state == RECORD_MODE) {
//
//                    int temp_index = mRecordThread.get_time();
//
//                    MusicStageActivity.record_power[temp_index] = save_Volume;
//                    MusicStageActivity.record_arr[temp_index] = REQUEST_A;
//                    mMusicPlayerThread.play(1, current_Volume);
//                } else {
//                    mMusicPlayerThread.play(1, current_Volume);
//                }
//
//                break;
//
//            case REQUEST_B:
//
//                if (MusicStageActivity.state == PLAY_MODE) {
//
//                    byte[] temp_content = {'b'};
//
//                    //    mBluetoothConnectService.write(temp_content);
//                    MusicStageActivity.gBluetoothThread.write(temp_content);
//                    MusicStageFragment4.guiHandler.sendEmptyMessage(REQUEST_B);
//                    mMusicPlayerThread.play(2, current_Volume);
//
//
//                } else if (MusicStageActivity.state == RECORD_MODE) {
//
//                    int temp_index = mRecordThread.get_time();
//
//                    MusicStageActivity.record_power[temp_index] = save_Volume;
//
//                    MusicStageActivity.record_arr[temp_index] = REQUEST_B;
//
//                    mMusicPlayerThread.play(2, current_Volume);
//                } else {
//
//                    mMusicPlayerThread.play(2, current_Volume);
//                }
//
//                break;
//
//
//            case REQUEST_C:
//
//                if (MusicStageActivity.state == PLAY_MODE) {
//
//                    byte[] temp_content = {'c'};
//
//                    //    mBluetoothConnectService.write(temp_content);
//                    MusicStageActivity.gBluetoothThread.write(temp_content);
//                    MusicStageFragment4.guiHandler.sendEmptyMessage(REQUEST_C);
//                    mMusicPlayerThread.play(3, current_Volume);
//
//                } else if (MusicStageActivity.state == RECORD_MODE) {
//
//                    int temp_index = mRecordThread.get_time();
//
//                    MusicStageActivity.record_power[temp_index] = save_Volume;
//
//                    MusicStageActivity.record_arr[temp_index] = REQUEST_C;
//
//                    mMusicPlayerThread.play(3, current_Volume);
//                } else {
//                    mMusicPlayerThread.play(3, current_Volume);
//                }
//
//                break;
//
//
//            case REQUEST_D:
//
//                if (MusicStageActivity.state == PLAY_MODE) {
//
//                    byte[] temp_content = {'d'};
//                    //       mBluetoothConnectService.write(temp_content);
//                    MusicStageActivity.gBluetoothThread.write(temp_content);
//                    MusicStageFragment4.guiHandler.sendEmptyMessage(REQUEST_D);
//                    mMusicPlayerThread.play(4, current_Volume);
//                } else if (MusicStageActivity.state == RECORD_MODE) {
//
//                    int temp_index = mRecordThread.get_time();
//
//                    MusicStageActivity.record_power[temp_index] = save_Volume;
//
//                    MusicStageActivity.record_arr[temp_index] = REQUEST_D;
//
//                    mMusicPlayerThread.play(4, current_Volume);
//                } else {
//
//                    mMusicPlayerThread.play(4, current_Volume);
//                }
//
//                break;

            case NOMAL_MODE:
                break;
//
//                MusicStageFragment4.guiHandler.sendEmptyMessage(NOMAL_MODE);
//                break;

            case RECORD_MODE:
                break;
//                MusicStageFragment4.guiHandler.sendEmptyMessage(RECORD_MODE);
//                break;

            case PLAY_MODE:
                break;
//
//                MusicStageFragment4.guiHandler.sendEmptyMessage(PLAY_MODE);
//                break;

            case PLAY_BGM:
                try {
                    Log.i("PLAY_BGM!!", " OK");
                    int temp_index = msg.arg1;
                    mMusicPlayerThread.select_playBGM(temp_index);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case PAUSE_BGM:
                mMusicPlayerThread.stopBGM();
                break;

            case RESUME_BGM:
                Log.i("RESUME_BGM!!", " OK");
                mMusicPlayerThread.resumeBGM();
                break;

            case CLEAR_BGM:
                mMusicPlayerThread.killMediaPlayer();
                break;
            default:
                save_Volume = msg.what;
                current_Volume = (float) ((msg.what - '0')) / (float) 10;
                break;
        }

    }
}



