inherit epiphany-library

require epiphany-newlib.inc

DEPENDS = "virtual/${TARGET_PREFIX}gcc ${TARGET_ARCH}-newlib"

do_configure() {
    ${S}/libgloss/configure ${EXTRA_OECONF} --prefix=${prefix}
}

do_install_append() {
    # Move libs to default directories so they can be picked up later
    install -d ${D}${libdir}
    mv -v ${D}${prefix}/${TARGET_SYS}/lib/* ${D}${libdir}

    # Remove original directory
    rmdir -p --ignore-fail-on-non-empty ${D}${prefix}/${TARGET_SYS}/lib
}

# Split packages correctly
FILES_${PN} += "${libdir}/*.ld ${libdir}/*.specs"

INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
