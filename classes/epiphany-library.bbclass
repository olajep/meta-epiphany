inherit epiphany-target
inherit prepend-target-prefix-to-pn

PACKAGE_ARCH = "${TARGET_ARCH}"

MULTIMACH_TARGET_SYS="${PACKAGE_ARCH}${TARGET_VENDOR}-${TARGET_OS}"

libdir = "${exec_prefix}/lib/${TARGET_SYS}"
datadir = "${prefix}/${TARGET_SYS}/share"
includedir = "${exec_prefix}/${TARGET_SYS}/include"

TOOLCHAIN_OPTIONS = " -isystem ${STAGING_DIR_HOST}${includedir}"

EXTRA_OECONF_PATHS_append = " \
    --libdir=${libdir} \
    --datarootdir=${datadir} \
    --includedir=${includedir} \
"
