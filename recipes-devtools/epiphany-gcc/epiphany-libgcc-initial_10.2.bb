FILESEXTRAPATHS =. "${COREBASE}/meta/recipes-devtools/gcc:"

inherit epiphany-library
require recipes-devtools/gcc/gcc-${PV}.inc
require recipes-devtools/gcc/libgcc.inc
require epiphany-gcc-shared-source.inc

DEPENDS = "virtual/${TARGET_PREFIX}gcc virtual/epiphany-libc"
