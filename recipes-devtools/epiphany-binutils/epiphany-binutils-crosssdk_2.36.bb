FILESEXTRAPATHS =. "${COREBASE}/meta/recipes-devtools/binutils/binutils:"

inherit crosssdk

inherit epiphany-target
require recipes-devtools/binutils/binutils-crosssdk_${PV}.bb
require epiphany-binutils-2.36.inc

PN = "epiphany-binutils-crosssdk-${SDK_SYS}"
