package com.huawei.android.hardware.fmradio;

import android.content.Context;
import android.media.AudioSystem;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.huawei.android.hardware.fmradio.IHwFmService;
import java.util.Arrays;


public class HwFmService extends IHwFmService.Stub {
    private static final int EVENT_LISTEN = 1;
    private static final String FM_PERMISSION = "com.huawei.permission.ACCESS_FM";
    private static final int DEVICE_OUT_FM = 1048576;
    private static final int STD_BUF_SIZE = 128;
    private static final String TAG = "HwFmService";
    private Context mContext;
    private boolean mIsFmConnected = false;
    private int mUid = -1;
    private Thread mThread = null;
    private IFmEventCallback mCallback = null;

    public HwFmService(Context context) {
        this.mContext = context;
    }

    public HwFmService() {
    }

    @Override // com.huawei.android.hardware.fmradio.IHwFmService
    public int acquireFd(String path) {
        this.mContext.enforceCallingOrSelfPermission(FM_PERMISSION, "need FM permission");
        int uid = Binder.getCallingUid();
        Log.d(TAG, "acquireFd uid = " + uid);
        if (uid != this.mUid && this.mUid != -1) {
            Log.d(TAG, "support only one client now");
            return -1;
        }
        int fd = FmReceiverJNI.acquireFdNative(path);
        if (fd != -1) {
            this.mUid = uid;
        }
        return fd;
    }

    @Override // com.huawei.android.hardware.fmradio.IHwFmService
    public int audioControl(int fd, int control, int field) {
        this.mContext.enforceCallingOrSelfPermission(FM_PERMISSION, "need FM permission");
        return FmReceiverJNI.audioControlNative(fd, control, field);
    }

    @Override // com.huawei.android.hardware.fmradio.IHwFmService
    public int cancelSearch(int fd) {
        this.mContext.enforceCallingOrSelfPermission(FM_PERMISSION, "need FM permission");
        return FmReceiverJNI.cancelSearchNative(fd);
    }

    @Override // com.huawei.android.hardware.fmradio.IHwFmService
    public int closeFd(int fd) {
        this.mContext.enforceCallingOrSelfPermission(FM_PERMISSION, "need FM permission");
        int uid = Binder.getCallingUid();
        if (uid != this.mUid) {
            Log.d(TAG, "can not close fd");
            return -1;
        }
        this.mUid = -1;
        return FmReceiverJNI.closeFdNative(fd);
    }

    @Override // com.huawei.android.hardware.fmradio.IHwFmService
    public int getFreq(int fd) {
        this.mContext.enforceCallingOrSelfPermission(FM_PERMISSION, "need FM permission");
        return FmReceiverJNI.getFreqNative(fd);
    }

    @Override // com.huawei.android.hardware.fmradio.IHwFmService
    public int setFreq(int fd, int freq) {
        this.mContext.enforceCallingOrSelfPermission(FM_PERMISSION, "need FM permission");
        return FmReceiverJNI.setFreqNative(fd, freq);
    }

    @Override // com.huawei.android.hardware.fmradio.IHwFmService
    public int getControl(int fd, int id) {
        this.mContext.enforceCallingOrSelfPermission(FM_PERMISSION, "need FM permission");
        return FmReceiverJNI.getControlNative(fd, id);
    }

    @Override // com.huawei.android.hardware.fmradio.IHwFmService
    public int setControl(int fd, int id, int value) {
        this.mContext.enforceCallingOrSelfPermission(FM_PERMISSION, "need FM permission");
        int uid = Binder.getCallingUid();
        if (uid != this.mUid) {
            return -1;
        }
        return FmReceiverJNI.setControlNative(fd, id, value);
    }

    @Override // com.huawei.android.hardware.fmradio.IHwFmService
    public int startSearch(int fd, int dir) {
        this.mContext.enforceCallingOrSelfPermission(FM_PERMISSION, "need FM permission");
        return FmReceiverJNI.startSearchNative(fd, dir);
    }

    @Override // com.huawei.android.hardware.fmradio.IHwFmService
    public int getBuffer(int fd, byte[] buff, int index) {
        this.mContext.enforceCallingOrSelfPermission(FM_PERMISSION, "need FM permission");
        return FmReceiverJNI.getBufferNative(fd, buff, index);
    }

    @Override // com.huawei.android.hardware.fmradio.IHwFmService
    public int getRSSI(int fd) {
        this.mContext.enforceCallingOrSelfPermission(FM_PERMISSION, "need FM permission");
        return FmReceiverJNI.getRSSINative(fd);
    }

    @Override // com.huawei.android.hardware.fmradio.IHwFmService
    public int setBand(int fd, int low, int high) {
        this.mContext.enforceCallingOrSelfPermission(FM_PERMISSION, "need FM permission");
        return FmReceiverJNI.setBandNative(fd, low, high);
    }

    @Override // com.huawei.android.hardware.fmradio.IHwFmService
    public int getLowerBand(int fd) {
        this.mContext.enforceCallingOrSelfPermission(FM_PERMISSION, "need FM permission");
        return FmReceiverJNI.getLowerBandNative(fd);
    }

    @Override // com.huawei.android.hardware.fmradio.IHwFmService
    public int getUpperBand(int fd) {
        this.mContext.enforceCallingOrSelfPermission(FM_PERMISSION, "need FM permission");
        return FmReceiverJNI.getUpperBandNative(fd);
    }

    @Override // com.huawei.android.hardware.fmradio.IHwFmService
    public int setMonoStereo(int fd, int val) {
        this.mContext.enforceCallingOrSelfPermission(FM_PERMISSION, "need FM permission");
        return FmReceiverJNI.setMonoStereoNative(fd, val);
    }

    @Override // com.huawei.android.hardware.fmradio.IHwFmService
    public int getRawRds(int fd, byte[] buff, int count) {
        this.mContext.enforceCallingOrSelfPermission(FM_PERMISSION, "need FM permission");
        return FmReceiverJNI.getRawRdsNative(fd, buff, count);
    }

    @Override // com.huawei.android.hardware.fmradio.IHwFmService
    public void setNotchFilter(boolean value) {
        this.mContext.enforceCallingOrSelfPermission(FM_PERMISSION, "need FM permission");
        FmReceiverJNI.setNotchFilterNative(value);
    }

    @Override // com.huawei.android.hardware.fmradio.IHwFmService
    public int getAudioQuilty(int fd, int value) {
        this.mContext.enforceCallingOrSelfPermission(FM_PERMISSION, "need FM permission");
        return FmReceiverJNI.getAudioQuiltyNative(fd, value);
    }

    @Override // com.huawei.android.hardware.fmradio.IHwFmService
    public int setFmSnrThresh(int fd, int value) {
        this.mContext.enforceCallingOrSelfPermission(FM_PERMISSION, "need FM permission");
        return FmReceiverJNI.setFmSnrThreshNative(fd, value);
    }

    @Override // com.huawei.android.hardware.fmradio.IHwFmService
    public int setFmRssiThresh(int fd, int value) {
        this.mContext.enforceCallingOrSelfPermission(FM_PERMISSION, "need FM permission");
        return FmReceiverJNI.setFmRssiThreshNative(fd, value);
    }

    @Override // com.huawei.android.hardware.fmradio.IHwFmService
    public void setFmDeviceConnectionState(int state) {
        this.mContext.enforceCallingOrSelfPermission(FM_PERMISSION, "need FM permission");
        /*        
	if (!checkPermission()) {
		return PERMISSION_DENIED;
	}*/
	/*
	if (!AudioSystem::isOutputDevice(device) && !AudioSystem::isInputDevice(device)) {
		return BAD_VALUE;
	}
	if (state != AudioSystem::DEVICE_STATE_AVAILABLE &&
	    state != AudioSystem::DEVICE_STATE_UNAVAILABLE) {
		return BAD_VALUE;
	}*/
    
        if (state == 0 && this.mIsFmConnected) {
            //AudioSystem.setDeviceConnectionState(DEVICE_OUT_FM, 0, "");
            this.mIsFmConnected = false;
        } else if (state == 1 && (!this.mIsFmConnected)) {
            //AudioSystem.setDeviceConnectionState(DEVICE_OUT_FM, 1, "");
            this.mIsFmConnected = true;
        }
    }

    @Override // com.huawei.android.hardware.fmradio.IHwFmService
    public void startListner(final int fd, IFmEventCallback cb) {
        this.mContext.enforceCallingOrSelfPermission(FM_PERMISSION, "need FM permission");
        this.mCallback = cb;
        this.mThread = new Thread() { // from class: com.huawei.android.hardware.fmradio.HwFmService.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                byte[] buff = new byte[128];
                Log.d(HwFmService.TAG, "Starting listener " + fd);
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Arrays.fill(buff, (byte) 0);
                        int eventCount = HwFmService.this.getBuffer(fd, buff, 1);
                        Log.d(HwFmService.TAG, "Received event. Count: " + eventCount);
                        if (HwFmService.this.mCallback != null) {
                            for (int index = 0; index < eventCount; index++) {
                                Log.d(HwFmService.TAG, "Received <" + ((int) buff[index]) + ">");
                                switch (buff[index]) {
                                    case 1:
                                    case 2:
                                        HwFmService.this.mCallback.onEventCallback(buff[index], HwFmService.this.getFreq(fd), -1);
                                        break;
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    default:
                                        HwFmService.this.mCallback.onEventCallback(buff[index], -1, -1);
                                        break;
                                    case 8:
                                    case 11:
                                    case 13:
                                        HwFmService.this.mCallback.onEventCallback(buff[index], 0, -1);
                                        break;
                                    case 9:
                                    case 10:
                                    case 12:
                                        HwFmService.this.mCallback.onEventCallback(buff[index], 1, -1);
                                        break;
                                }
                            }
                        }
                    } catch (RuntimeException ex) {
                        Log.d(HwFmService.TAG, ex.toString());
                        Thread.currentThread().interrupt();
                    } catch (Exception ex2) {
                        Log.d(HwFmService.TAG, "RunningThread InterruptedException ex = " + ex2);
                        Thread.currentThread().interrupt();
                        try {
                            if (HwFmService.this.mCallback != null) {
                                Log.d(HwFmService.TAG, "mCallback is not null");
                                HwFmService.this.mCallback.onEventCallback(2, -1, -1);
                            } else {
                                Log.d(HwFmService.TAG, "mCallback == null");
                            }
                        } catch (RemoteException rx) {
                            Log.d(HwFmService.TAG, "RunningThread InterruptedException for callback = " + rx);
                        }
                    }
                }
            }
        };
        this.mThread.start();
    }

    @Override // com.huawei.android.hardware.fmradio.IHwFmService
    public void stopListner() {
        this.mContext.enforceCallingOrSelfPermission(FM_PERMISSION, "need FM permission");
        int uid = Binder.getCallingUid();
        if (uid != this.mUid) {
            return;
        }
        this.mCallback = null;
        Log.d(TAG, "stopping the Listener\n");
        if (this.mThread != null) {
            this.mThread.interrupt();
        }
    }
}
