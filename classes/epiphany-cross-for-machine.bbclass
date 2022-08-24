# Epiphany cross compiler class for MACHINE

inherit prepend-target-prefix-to-pn

HOST_ARCH       := "${TARGET_ARCH}"
HOST_OS         := "${TARGET_OS}"
HOST_VENDOR     := "${TARGET_VENDOR}"
HOST_CC_ARCH    := "${TARGET_CC_ARCH}"
HOST_LD_ARCH    := "${TARGET_LD_ARCH}"
HOST_AS_ARCH    := "${TARGET_AS_ARCH}"
HOST_TUNE_PKGARCH := "${TUNE_PKGARCH}"
HOST_SYS         = "${HOST_ARCH}${HOST_VENDOR}-${HOST_OS}"
HOST_PREFIX      = "${HOST_SYS}-"

# It's still for the same HOST machine
MULTIMACH_TARGET_SYS = "${HOST_TUNE_PKGARCH}${HOST_VENDOR}-${HOST_OS}"
PACKAGE_ARCH="${HOST_TUNE_PKGARCH}"

TARGET_ARCH = "epiphany"
TARGET_OS = "elf"
TARGET_VENDOR = ""
#TARGET_SYS = "${target_arch}${target_vendor}-${target_os}"
#TARGET_PREFIX = "${TARGET_SYS}-"
TARGET_CC_ARCH = ""
TARGET_LD_ARCH = ""
TARGET_AS_ARCH = ""

TUNE_FEATURES = ""
TARGET_FPU = ""

# Include path to host (MACHINE) toolchain
PATH_prepend = "${STAGING_DIR_NATIVE}${bindir_native}/${HOST_SYS}:"

# Disable some sanity checking and variable expansions in
# cross-canadian.bbclass to work around 'unknown target errors'.
# We need to make sure we set the correct values here.
MODIFYTOS = "0"

# No easy way to override to use HOST_ARCH in insane.bbclass
INSANE_SKIP = "arch"

PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}compilerlibs = "${TARGET_ARCH}-gcc-runtime"
