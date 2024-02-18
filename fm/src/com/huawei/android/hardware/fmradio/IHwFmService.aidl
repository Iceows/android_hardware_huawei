/*
* aidl file :
* com/huawei/android/hardware/fmradio/IHwFmService.aidl
* This file contains definitions of functions which are
* exposed by service.
*
* Author : Raphael Mounier (Iceows)
*/

package com.huawei.android.hardware.fmradio;
import com.huawei.android.hardware.fmradio.IFmEventCallback;


/**{@hide}*/
interface IHwFmService {
    int acquireFd(String str);
    int audioControl(int i, int i2, int i3);
    int cancelSearch(int i);
    int closeFd(int i);
    int getAudioQuilty(int i, int i2);
    int getBuffer(int i,out byte[] bArr, int i2);
    int getControl(int i, int i2);
    int getFreq(int i);
    int getLowerBand(int i);
    int getRSSI(int i);
    int getRawRds(int i,out byte[] bArr, int i2);
    int getUpperBand(int i);
    int setBand(int i, int i2, int i3);
    int setControl(int i, int i2, int i3);
    void setFmDeviceConnectionState(int i);
    int setFmRssiThresh(int i, int i2);
    int setFmSnrThresh(int i, int i2);
    int setFreq(int i, int i2);
    int setMonoStereo(int i, int i2);
    void setNotchFilter(boolean z);
    void startListner(int i, IFmEventCallback iFmEventCallback);
    int startSearch(int i, int i2);
    void stopListner();
}
