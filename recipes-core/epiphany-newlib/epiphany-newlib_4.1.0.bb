inherit epiphany-library

require epiphany-newlib.inc

PROVIDES += "virtual/epiphany-libc virtual/epiphany-libiconv virtual/epiphany-libintl"

# Work around image install dependency issues
ALLOW_EMPTY_${PN} = "1"

do_configure() {
    export CC_FOR_TARGET="${TARGET_CC}"
    ${S}/configure ${EXTRA_OECONF} --prefix=${prefix}
}

do_install_append() {
    # Move include files and libs to default directories so they can be picked up later
    mv -v ${D}${prefix}/${TARGET_SYS}/lib ${D}${libdir}
    mv -v ${D}${prefix}/${TARGET_SYS}/include ${D}${includedir}

    # Remove original directory
    rmdir ${D}${prefix}/${TARGET_SYS}
}
