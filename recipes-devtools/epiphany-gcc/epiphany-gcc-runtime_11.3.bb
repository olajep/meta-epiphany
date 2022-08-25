FILESEXTRAPATHS =. "${COREBASE}/meta/recipes-devtools/gcc:"

inherit epiphany-library
require recipes-devtools/gcc/gcc-${PV}.inc
require recipes-devtools/gcc/gcc-runtime.inc
require epiphany-gcc-shared-source.inc

SLIB = "${S}"

BBCLASSEXTEND:remove = "nativesdk"

DEPENDS = " virtual/${TARGET_PREFIX}gcc ${TARGET_ARCH}-libgloss ${TARGET_ARCH}-libgcc"

PROVIDES = "virtual/${TARGET_PREFIX}compilerlibs"
