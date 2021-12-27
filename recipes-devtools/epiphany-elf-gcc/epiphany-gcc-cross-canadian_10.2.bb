FILESEXTRAPATHS =. "${COREBASE}/meta/recipes-devtools/gcc:"

inherit epiphany-target
require recipes-devtools/gcc/gcc-${PV}.inc
require recipes-devtools/gcc/gcc-cross-canadian.inc
require epiphany-gcc-shared-source.inc
