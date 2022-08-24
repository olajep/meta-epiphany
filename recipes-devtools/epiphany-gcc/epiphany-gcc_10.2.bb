FILESEXTRAPATHS =. "${COREBASE}/meta/recipes-devtools/gcc:"

SECURITY_STRINGFORMAT := ""

inherit epiphany-cross-for-machine
require recipes-devtools/gcc/gcc-${PV}.inc
require recipes-devtools/gcc/gcc-target.inc
require epiphany-gcc-shared-source.inc

BBCLASSEXTEND = "nativesdk"

RDEPENDS_${PN}_remove = "cpp"
RDEPENDS_${PN} = "${TARGET_ARCH}-cpp"

DEPENDS += "virtual/${TARGET_ARCH}-libc virtual/${HOST_PREFIX}gcc"

# These symlink packages should only be installed for the main GCC arch
PACKAGES_remove = " \
    ${PN}-symlinks \
    ${TARGET_ARCH}-g++-symlinks \
    ${TARGET_ARCH}-cpp-symlinks \
    ${TARGET_ARCH}-g77-symlinks \
    ${TARGET_ARCH}-gfortran-symlinks \
    ${TARGET_ARCH}-gcov-symlinks \
"

do_install_append () {
    # Remove symlinks we don't want
    for i in g77 f77 gfortran f95 g++ gcc cpp gcov gcov-tool c++ cc; do
        if [ -e ${D}${bindir}/$i -o -h ${D}${bindir}/$i ]; then
            rm ${D}${bindir}/$i
        fi
    done
    rm ${D}${base_libdir}/cpp
    rmdir ${D}${base_libdir}
}
