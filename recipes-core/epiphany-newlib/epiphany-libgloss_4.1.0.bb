inherit epiphany-library

require epiphany-newlib.inc

DEPENDS += "epiphany-newlib"

do_configure() {
	${S}/libgloss/configure ${EXTRA_OECONF}
}

# Split packages correctly
FILES_${PN} += " \
    ${exec_prefix}/${TARGET_SYS}/lib/*.ld \
    ${exec_prefix}/${TARGET_SYS}/lib/*.specs \
"

FILES_${PN}-staticdev += " \
    ${exec_prefix}/${TARGET_SYS}/lib/*.a \
    ${exec_prefix}/${TARGET_SYS}/lib/*.o \
"

INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
