
# 
# For these recipes we may need to override TARGET and HOST whilst keeping 
# variables derived from the original TARGET and HOST unchanged.
# To do this store the original TARGET and HOST and then effectively make
# the TARGET_?? and HOST_?? variables local to the lower layers in the hierarchy.
#
# Note that it would be better not to use TARGET_?? and HOST_?? in recipes lower
# in the hierarchy but rather local variables that are passed to the lower
# layers, but for now hack it like this to simulate the proposed future
#
# TODO save other bitbake.conf variables as appropriate
HOST_ARCH_GVARIABLE := "${HOST_ARCH}"
HOST_OS_GVARIABLE := "${HOST_OS}"
HOST_VENDOR_GVARIABLE := "${HOST_VENDOR}"
HOST_SYS_GVARIABLE := "${HOST_SYS}"
HOST_PREFIX_GVARIABLE := "${HOST_PREFIX}"
HOST_CC_ARCH_GVARIABLE := "${HOST_CC_ARCH}"
HOST_LD_ARCH_GVARIABLE := "${HOST_LD_ARCH}"
HOST_AS_ARCH_GVARIABLE := "${HOST_AS}"
HOST_EXEEXT_GVARIABLE := "${HOST_EXEEXT}"

TARGET_ARCH_GVARIABLE := "${TARGET_ARCH}"
TARGET_OS_GVARIABLE := "${TARGET_OS}"
TARGET_VENDOR_GVARIABLE := "${TARGET_VENDOR}"
TARGET_SYS_GVARIABLE := "${TARGET_SYS}"
TARGET_PREFIX_GVARIABLE := "${TARGET_PREFIX}"
TARGET_CC_ARCH_GVARIABLE := "${TARGET_CC_ARCH}"
TARGET_LD_ARCH_GVARIABLE := "${TARGET_LD_ARCH}"
TARGET_AS_ARCH_GVARIABLE := "${TARGET_AS}"
TARGET_EXEEXT_GVARIABLE := "${TARGET_EXEEXT}"
#
# The following are additional and should be defined in bitbake.conf
# with defaults CROSS_HOST_ARCH = HOST_ARCH etc
#
# In this recipe we override setting CROSS_HOST with TARGET
CROSS_HOST_ARCH_GVARIABLE = "${TARGET_ARCH_GVARIABLE}"
CROSS_HOST_OS_GVARIABLE = "${TARGET_OS_GVARIABLE}"
CROSS_HOST_VENDOR_GVARIABLE = "${TARGET_VENDOR_GVARIABLE}"
CROSS_HOST_SYS_GVARIABLE = "${TARGET_SYS_GVARIABLE}"
CROSS_HOST_PREFIX_GVARIABLE = "${TARGET_PREFIX_GVARIABLE}"
CROSS_HOST_CC_ARCH_GVARIABLE = "${TARGET_CC_ARCH_GVARIABLE}"
CROSS_HOST_LD_ARCH_GVARIABLE = "${TARGET_LD_ARCH_GVARIABLE}"
CROSS_HOST_AS_ARCH_GVARIABLE = "${TARGET_AS_GVARIABLE}"
CROSS_HOST_EXEEXT_GVARIABLE = "${TARGET_EXEEXT_GVARIABLE}"

CROSS_TARGET_ARCH_GVARIABLE = "elf"
CROSS_TARGET_OS_GVARIABLE = ""
CROSS_TARGET_VENDOR_GVARIABLE = ""
CROSS_TARGET_SYS_GVARIABLE = "epiphany-elf"
CROSS_TARGET_PREFIX_GVARIABLE = "${CROSS_TARGET_SYS_GVARIABLE}-"
CROSS_TARGET_CC_ARCH_GVARIABLE = ""
CROSS_TARGET_LD_ARCH_GVARIABLE = ""
CROSS_TARGET_AS_ARCH_GVARIABLE = ""
CROSS_TARGET_EXEEXT_GVARIABLE = ""

# TODO update these as appropriate!
CROSS_TARGET_CFLAGS_GVARIABLE := "${TARGET_CFLAGS}"
CROSS_TARGET_CXXFLAGS_GVARIABLE := "${TARGET_CXXFLAGS}"
CROSS_TARGET_LDFLAGS_GVARIABLE := "${TARGET_LDFLAGS}"

#
# Now all the scripts in this recipe can use CROSS_TARGET_??_GVARIABLE
# or CROSS_HOST_??_GVARIABLE 
# or can use the original settings of TARGET and HOST
# the effect is to make TARGET and HOST variables local to the lower layers
#
# For example override STAGING_BINDIR_TOOLCHAIN to match original TARGET
#
STAGING_BINDIR_TOOLCHAIN = "${STAGING_DIR_NATIVE}${bindir_native}/${TARGET_ARCH_GVARIABLE}${TARGET_VENDOR_GVARIABLE}-${TARGET_OS_GVARIABLE}"

# TODO remove the following once the referenced recipes are updated
# Now replace HOST_?? and TARGET_?? required for this layer
HOST_ARCH = "${CROSS_HOST_ARCH_GVARIABLE}"
HOST_OS = "${CROSS_HOST_OS_GVARIABLE}"
HOST_VENDOR = "${CROSS_HOST_VENDOR_GVARIABLE}"
HOST_SYS = "${CROSS_HOST_SYS_GVARIABLE}"
HOST_PREFIX = "${CROSS_HOST_PREFIX_GVARIABLE}"
HOST_CC_ARCH = "${CROSS_HOST_CC_ARCH_GVARIABLE}"
HOST_LD_ARCH = "${CROSS_HOST_LD_ARCH_GVARIABLE}"
HOST_AS_ARCH = "${CROSS_HOST_AS_GVARIABLE}"
HOST_EXEEXT = "${CROSS_HOST_EXEEXT_GVARIABLE}"

TARGET_ARCH = "${CROSS_TARGET_ARCH_GVARIABLE}"
TARGET_OS = "${CROSS_TARGET_OS_GVARIABLE}"
TARGET_VENDOR = "${CROSS_TARGET_VENDOR_GVARIABLE}"
TARGET_SYS = "${CROSS_TARGET_SYS_GVARIABLE}"
TARGET_PREFIX = "${CROSS_TARGET_PREFIX_GVARIABLE}"
TARGET_CC_ARCH = "${CROSS_TARGET_CC_ARCH_GVARIABLE}"
TARGET_LD_ARCH = "${CROSS_TARGET_LD_ARCH_GVARIABLE}"
TARGET_AS_ARCH = "${CROSS_TARGET_AS_GVARIABLE}"
TARGET_EXEEXT = "${CROSS_TARGET_EXEEXT_GVARIABLE}"

#
# Now the script
#

require epiphany-elf-binutils.inc
require epiphany-elf-binutils-${PV}.inc
require epiphany-elf-binutils-cross-canadian.inc
