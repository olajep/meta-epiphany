FILESEXTRAPATHS =. "${COREBASE}/meta/recipes-devtools/gcc:"

DISABLE_STATIC=""

inherit epiphany-library
require recipes-devtools/gcc/gcc-${PV}.inc
require recipes-devtools/gcc/gcc-runtime.inc
require epiphany-gcc-shared-source.inc

SLIB = "${S}"

DEPENDS += "${TARGET_SYS}-${EPIPHANY_LIBC}"
PROVIDES := "virtual/${TARGET_PREFIX}compilerlibs"
