package com.huawei.android.hardware.fmradio;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import com.huawei.android.hardware.fmradio.IHwFmService;

class FmReceiverWrapper {
    static final int FM_JNI_FAILURE = -1;
    static final int FM_JNI_SUCCESS = 0;
    private static final String TAG = "FmReceiverWrapper";
    private static IHwFmService sService;

    FmReceiverWrapper() {
    }

    
    private static IHwFmService getService() {
        Log.d(FmReceiverWrapper.TAG, "getService");
        if (sService != null) {
            return sService;
        }
        
	IBinder service = ServiceManager.getService("hwfm_service");
	if (service != null) {
            sService = IHwFmService.Stub.asInterface(service);
            return sService;
	}
	else {
            System.out.println("service hwfm_service not found");
	}
	return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int acquireFdNative(String path) {
        try {
            return getService().acquireFd(path);
        } catch (RemoteException e) {
            return -1;
        }
    }

    static int audioControlNative(int fd, int control, int field) {
        try {
            return getService().audioControl(fd, control, field);
        } catch (RemoteException e) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int cancelSearchNative(int fd) {
        try {
            return getService().cancelSearch(fd);
        } catch (RemoteException e) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int closeFdNative(int fd) {
        try {
            return getService().closeFd(fd);
        } catch (RemoteException e) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getFreqNative(int fd) {
        try {
            return getService().getFreq(fd);
        } catch (RemoteException e) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int setFreqNative(int fd, int freq) {
        try {
            return getService().setFreq(fd, freq);
        } catch (RemoteException e) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getControlNative(int fd, int id) {
        try {
            return getService().getControl(fd, id);
        } catch (RemoteException e) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int setControlNative(int fd, int id, int value) {
        try {
            Log.d(FmReceiverWrapper.TAG, "setControlNative");
            return getService().setControl(fd, id, value);
        } catch (RemoteException e) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int startSearchNative(int fd, int dir) {
        try {
            return getService().startSearch(fd, dir);
        } catch (RemoteException e) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getBufferNative(int fd, byte[] buff, int index) {
        try {
            return getService().getBuffer(fd, buff, index);
        } catch (RemoteException e) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getRSSINative(int fd) {
        try {
            return getService().getRSSI(fd);
        } catch (RemoteException e) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int setBandNative(int fd, int low, int high) {
        try {
            return getService().setBand(fd, low, high);
        } catch (RemoteException e) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getLowerBandNative(int fd) {
        try {
            return getService().getLowerBand(fd);
        } catch (RemoteException e) {
            return -1;
        }
    }

    static int getUpperBandNative(int fd) {
        try {
            return getService().getUpperBand(fd);
        } catch (RemoteException e) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int setMonoStereoNative(int fd, int val) {
        try {
            return getService().setMonoStereo(fd, val);
        } catch (RemoteException e) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getRawRdsNative(int fd, byte[] buff, int count) {
        try {
            return getService().getRawRds(fd, buff, count);
        } catch (RemoteException e) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setNotchFilterNative(boolean value) {
        try {
            getService().setNotchFilter(value);
        } catch (RemoteException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getAudioQuiltyNative(int fd, int value) {
        try {
            return getService().getAudioQuilty(fd, value);
        } catch (RemoteException e) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int setFmSnrThreshNative(int fd, int value) {
        try {
            return getService().setFmSnrThresh(fd, value);
        } catch (RemoteException e) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int setFmRssiThreshNative(int fd, int value) {
        try {
            return getService().setFmRssiThresh(fd, value);
        } catch (RemoteException e) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setFmDeviceConnectionState(int state) {
        try {
            getService().setFmDeviceConnectionState(state);
        } catch (RemoteException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void startListner(int fd, IFmEventCallback cb) {
        try {
            getService().startListner(fd, cb);
        } catch (RemoteException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void stopListner() {
        try {
            getService().stopListner();
        } catch (RemoteException e) {
        }
    }
}
