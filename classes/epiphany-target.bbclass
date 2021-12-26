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
