# Expand before we override the target variables
MULTIMACH_TARGET_SYS := "${PACKAGE_ARCH}${TARGET_VENDOR}-${TARGET_OS}"

TARGET_ARCH = "epiphany"
TARGET_OS = "elf"
TARGET_VENDOR = ""
#TARGET_SYS = "${target_arch}${target_vendor}-${target_os}"
#TARGET_PREFIX = "${TARGET_SYS}-"
TARGET_CC_ARCH = ""
TARGET_LD_ARCH = ""
TARGET_AS_ARCH = ""

# Disable some sanity checking and variable expansions in
# cross-canadian.bbclass to work around 'unknown target errors'.
# We need to make sure we set the correct values here.
MODIFYTOS = "0"

PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}compilerlibs = "${TARGET_ARCH}-gcc-runtime"
