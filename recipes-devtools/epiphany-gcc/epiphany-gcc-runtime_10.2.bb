FILESEXTRAPATHS =. "${COREBASE}/meta/recipes-devtools/gcc:"

inherit epiphany-library
require recipes-devtools/gcc/gcc-${PV}.inc
require recipes-devtools/gcc/gcc-runtime.inc
require epiphany-gcc-shared-source.inc

SLIB = "${S}"

BBCLASSEXTEND:remove = "nativesdk"

DEPENDS = "virtual/${TARGET_PREFIX}gcc virtual/${TARGET_ARCH}-libc"

PROVIDES = "virtual/${TARGET_PREFIX}compilerlibs"
