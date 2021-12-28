FILESEXTRAPATHS =. "${COREBASE}/meta/recipes-devtools/gcc:"

SECURITY_STRINGFORMAT := ""

inherit epiphany-cross-for-machine
require recipes-devtools/gcc/gcc-${PV}.inc
require recipes-devtools/gcc/gcc-target.inc
require epiphany-gcc-shared-source.inc

BBCLASSEXTEND = "nativesdk"

RDEPENDS_${PN}_remove = "cpp"
RDEPENDS_${PN} = "${TARGET_ARCH}-cpp"

DEPENDS += "${TARGET_SYS}-${EPIPHANY_LIBC} virtual/${HOST_PREFIX}gcc"
