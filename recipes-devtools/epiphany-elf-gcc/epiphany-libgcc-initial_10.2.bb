FILESEXTRAPATHS =. "${COREBASE}/meta/recipes-devtools/gcc:"

inherit epiphany-library
require recipes-devtools/gcc/gcc-${PV}.inc
require recipes-devtools/gcc/libgcc.inc
require epiphany-gcc-shared-source.inc

# NB: Seems we'll get a circular dependency for anything but newlib
DEPENDS += "${TARGET_SYS}-${EPIPHANY_LIBC}"
