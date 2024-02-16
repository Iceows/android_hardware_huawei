package com.huawei.android.hardware.fmradio;


class FmReceiverJNI {
    static final int FM_JNI_FAILURE = -1;
    static final int FM_JNI_SUCCESS = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int acquireFdNative(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int cancelSearchNative(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int closeFdNative(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int getAudioQuiltyNative(int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int getBufferNative(int i, byte[] bArr, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int getControlNative(int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int getFreqNative(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int getLowerBandNative(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int getRSSINative(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int getRawRdsNative(int i, byte[] bArr, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int setBandNative(int i, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int setControlNative(int i, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int setFmRssiThreshNative(int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int setFmSnrThreshNative(int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int setFreqNative(int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int setMonoStereoNative(int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int startSearchNative(int i, int i2);

    FmReceiverJNI() {
    }

    static {
        System.loadLibrary("fm_jni");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int audioControlNative(int fd, int control, int field) {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getUpperBandNative(int fd) {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setNotchFilterNative(boolean value) {
    }
}
