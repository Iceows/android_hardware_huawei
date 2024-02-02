#include <dlfcn.h>

#include <log/log.h>
#include <telephony/ril.h>

extern "C" void _ZN7android35Comm_RIL_onRequestComplete_ForSvlteEPv9RIL_ErrnoS0_mi(
        RIL_Token t, RIL_Errno e, void* response, size_t responselen, int modemId) {
    auto orig_onRequestComplete_ForSvlte =
            reinterpret_cast<void (*)(RIL_Token, RIL_Errno, void*, size_t, int)>(
                    dlsym(RTLD_NEXT,
                          "_ZN7android35Comm_RIL_onRequestComplete_ForSvlteEPv9RIL_ErrnoS0_mi"));
    ALOGI("%s: token = %p, errno = %d, response = %p, responselen = %p, modemId = %d", __func__, t,
          e, response, responselen, modemId);
    orig_onRequestComplete_ForSvlte(t, e, response, responselen, modemId);
}
