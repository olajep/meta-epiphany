FILESEXTRAPATHS =. "${COREBASE}/meta/recipes-devtools/gcc:"

inherit epiphany-library
require recipes-devtools/gcc/gcc-${PV}.inc
require recipes-devtools/gcc/libgcc.inc

# NB: Seems we'll get a circular dependency for anything but newlib
DEPENDS += "${TARGET_SYS}-${EPIPHANY_LIBC}"

TOOLCHAIN_OPTIONS = " -isystem ${STAGING_DIR_HOST}${prefix}/${TARGET_SYS}/include"
