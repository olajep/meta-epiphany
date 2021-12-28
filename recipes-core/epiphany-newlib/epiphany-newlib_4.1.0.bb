inherit epiphany-library

require epiphany-newlib.inc

PROVIDES += "virtual/epiphany-libc virtual/epiphany-libiconv virtual/epiphany-libintl"

do_configure() {
    export CC_FOR_TARGET="${TARGET_CC}"
    ${S}/configure ${EXTRA_OECONF}
}

FILES_${PN}-staticdev += "${exec_prefix}/${TARGET_SYS}/lib/*.a"

# No rpm package is actually created but -dev depends on it, avoid dnf error
RDEPENDS_${PN}-dev_libc-newlib = ""
