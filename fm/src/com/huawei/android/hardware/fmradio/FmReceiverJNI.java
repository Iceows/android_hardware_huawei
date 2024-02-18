//
// Copyright (C) 2024 The LineageOS Project
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//
// Author : Raphael Mounier (Iceows)
//

package com.huawei.android.hardware.fmradio;

class FmReceiverJNI {
    static final int FM_JNI_FAILURE = -1;
    static final int FM_JNI_SUCCESS = 0;
    
    public static native int acquireFdNative(String str);

    public static native int cancelSearchNative(int i);

    public static native int closeFdNative(int i);

    public static native int getAudioQuiltyNative(int i, int i2);

    public static native int getBufferNative(int i, byte[] bArr, int i2);

    public static native int getControlNative(int i, int i2);

    public static native int getFreqNative(int i);

    public static native int getLowerBandNative(int i);

    public static native int getRSSINative(int i);

    public static native int getRawRdsNative(int i, byte[] bArr, int i2);

    public static native int setBandNative(int i, int i2, int i3);

    public static native int setControlNative(int i, int i2, int i3);

    public static native int setFmRssiThreshNative(int i, int i2);

    public static native int setFmSnrThreshNative(int i, int i2);

    public static native int setFreqNative(int i, int i2);

    public static native int setMonoStereoNative(int i, int i2);

    public static native int startSearchNative(int i, int i2);

    FmReceiverJNI() {
    }

    static {
        System.loadLibrary("fm_jni");
    }

    public static int audioControlNative(int fd, int control, int field) {
        return 0;
    }

    public static int getUpperBandNative(int fd) {
        return 0;
    }

    public static void setNotchFilterNative(boolean value) {
    }
}
