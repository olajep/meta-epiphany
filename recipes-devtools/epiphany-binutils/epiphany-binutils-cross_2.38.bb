FILESEXTRAPATHS =. "${COREBASE}/meta/recipes-devtools/binutils/binutils:"

inherit epiphany-target
require recipes-devtools/binutils/binutils.inc
require recipes-devtools/binutils/binutils-${PV}.inc
require recipes-devtools/binutils/binutils-cross.inc
require epiphany-binutils-${PV}.inc
