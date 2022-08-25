FILESEXTRAPATHS =. "${COREBASE}/meta/recipes-devtools/gcc/gcc:"

require recipes-devtools/gcc/gcc-${PV}.inc
require recipes-devtools/gcc/gcc-source.inc
require epiphany-gcc-shared-source.inc

PN = "epiphany-gcc-source-${PV}"
WORKDIR = "${TMPDIR}/work-shared/epiphany-gcc-${PV}-${PR}"

STAMP = "${STAMPS_DIR}/work-shared/epiphany-gcc-${PV}-${PR}"
STAMPCLEAN = "${STAMPS_DIR}/work-shared/epiphany-gcc-${PV}-*"

EXCLUDE_FROM_WORLD = "1"
BRANCH = "epiphany-gcc-11.3.0"
BASEURI="git://github.com/olajep/epiphany-gcc.git;branch=${BRANCH};protocol=https"
SRCREV = "ec0be0e86f0ef8d33eccdf6748523ef7d2d59d91"
