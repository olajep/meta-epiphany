FILESEXTRAPATHS =. "${COREBASE}/meta/recipes-devtools/gcc/gcc:"

require recipes-devtools/gcc/gcc-${PV}.inc
require recipes-devtools/gcc/gcc-source.inc
require epiphany-gcc-shared-source.inc

PN = "epiphany-gcc-source-${PV}"
WORKDIR = "${TMPDIR}/work-shared/epiphany-gcc-${PV}-${PR}"

STAMP = "${STAMPS_DIR}/work-shared/epiphany-gcc-${PV}-${PR}"
STAMPCLEAN = "${STAMPS_DIR}/work-shared/epiphany-gcc-${PV}-*"

EXCLUDE_FROM_WORLD = "1"

BASEURI="git://github.com/olajep/epiphany-gcc.git;branch=epiphany-gcc-10.2.0;protocol=https"
SRCREV = "6760f82ba0e8bae0c44a007cc0666bfe76a3fcb7"
